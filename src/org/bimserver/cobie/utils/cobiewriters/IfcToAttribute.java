package org.bimserver.cobie.utils.cobiewriters;
/******************************************************************************
 * Copyright (C) 2011  ERDC
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.cobie.cobielite.AttributeType;
import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.utils.COBieQuery;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.COBieUtility.CobieSheetName;
import org.bimserver.cobie.utils.stringwriters.IfcEnumeratedValueToCOBieString;
import org.bimserver.cobie.utils.stringwriters.IfcPhysicalQuantityToCOBieString;
import org.bimserver.cobie.utils.stringwriters.IfcPropertyToCOBieString;
import org.bimserver.cobie.utils.stringwriters.IfcRelationshipsToCOBie;
import org.bimserver.cobie.utils.stringwriters.IfcSingleValueToCOBieString;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IfcToAttribute 
{
	private static final boolean ExcludesOnNameValueDependency = true;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcToAttribute.class);
	private static final String componentSheetName = "Component";
	private static CobieSheetName cobieSheet = CobieSheetName.Attribute;
	private static final String componentCategory = "Requirement";
	private static final String typeCategory = "Requirement";
	private static final String facilityCategory = "Requirement";
	private static final String floorCategory = "Requirement";
	private static final String spaceCategory = "Requirement";
	private static final String typeSheetName = "Type";
	private static final String facilitySheetName = "Facility";
	private static final String spaceSheetName = "Space";
	private static final String floorSheetName = "Floor";
	private static final ArrayList<String> valueExclusions =
			new ArrayList<String>(Arrays.asList("default"));
	private static final ArrayList<String> nameValueDependencyExceptions =
			new ArrayList<String>(Arrays.asList("Fire Rating"));
	private static ArrayList<String> facilityExclusions =
			new ArrayList<String>(Arrays.asList("Phase"));
	private static ArrayList<String> floorExclusions =
			new ArrayList<String>(Arrays.asList("Elevation"));
	private static ArrayList<String> spaceExclusions =
			new ArrayList<String>(Arrays.asList("Area","Number","ZoneName"));
	private static ArrayList<String> typeExclusions =
			new ArrayList<String>(Arrays.asList("AssetType",
					"IsFixed",
					"Manufacturer",
					"ModelNumber",
					"ModelLabel",
					"WarrantyGuarantorParts",
					"WarrantyDurationParts",
					"WarrantyGuarantorLabor",
					"WarrantyDurationLabor",
					"WarrantyDurationUnit",
					"ReplacementCost",
					"Cost",
					"LifeCyclePhase",
					"ExpectedLife",
					"ServiceLifeDuration",
					"ServiceLifeType",
					"DurationUnit",
					"WarrantyDescription",
					"WarrantyName",
					"NominalLength",
					"NominalWidth",
					"NominalHeight",
					"ModelReference",
					"Shape",
					"Size",
					"Color",
					"Finish",
					"Grade",
					"Material",
					"Constituents",
					"Features",
					"AccessibilityPerformance",
					"CodePerformance",
					"SustainabilityPerformance"));
	private static ArrayList<String> componentExclusions =
			new ArrayList<String>(Arrays.asList("SerialNumber",
								"InstallationDate",
								"WarrantyStartDate",
								"TagNumber",
								"BarCode",
								"AssetIdentifier",
								"System Name",
								"System Type",
								"Circuit Number"));
	private static ArrayList<String> allExclusions =
			new ArrayList<String>(Arrays.asList("MethodOfMeasurement","Omniclass Number",
									"Omniclass Title",
									"Assembly Code",
									"Assembly Description",
									"Uniclass Code",
									"Uniclass Description",
									"Category Code",
									"Category Description",
									"Classification Code",
									"Classification Description",
									"Name",
									"Description",
									" AssetAccountingType ",
									" GSA BIM Area ",
									"Half Oval ",
									" Height ",
									" Length ",
									"Hot Water Radius",
									"Host",
									"Level ",
									" Size ",
									" Lighting Calculation Workplan ",
									"Limit Offset",
									"Recepticles",
									"Mark",
									" Offset ",
									" Omniclass ",
									"Outside Diameter ",
									"Outside Radius ",
									"Phase",
									"Phase Created",
									" Radius ",
									"Window Inset",
									"Width ",
									"Symbol",
									"Line Pattern",
									"Roomtag",
									"Upper Limit",
									"Base Offset",
									" Zone "));

	public static void writeAttributes(COBIEType cType, IfcModelInterface model)
	{	
		LogHandler loggerHandler = new LogHandler(cobieSheet,LOGGER);
		loggerHandler.sheetWriteBegin();
		IfcToAttribute.writeObjectAttributes(getBuildings(model), IfcToAttribute.getCobieAttributes(cType), model,loggerHandler);
		IfcToAttribute.writeObjectAttributes(getFloors(model),IfcToAttribute.getCobieAttributes(cType),model,loggerHandler);
		IfcToAttribute.writeObjectAttributes(getSpaces(model),IfcToAttribute.getCobieAttributes(cType),model,loggerHandler);
		IfcToAttribute.writeTypesComponents(cType, model,loggerHandler);		
		loggerHandler.sheetWritten();
	}
	
	
	private static void writeObjectAttributes(ArrayList<IfcObject> objects, 
			COBIEType.Attributes attributes, IfcModelInterface model,LogHandler loggerStrings)
	{
		IfcRoot firstRoot = null;
		if (objects.size()>0)
			firstRoot = objects.get(0);
		IfcOwnerHistory oh = IfcToContact.getFirstOwnerHistory(model);
		String name = "";
		String createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
		Calendar createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
		String category = IfcToAttribute.categoryFromRoot(firstRoot);
		String worksheetName = IfcToAttribute.sheetNameFromRoot(firstRoot);
		String rowName = "";
		IfcPropertyToCOBieString pStrvalue;
		String value;
		String unit = "";
		String extSystem = "";
		String extObject = "";
		String extIdentifier = "";
		String description = "";
		String allowedValues = "";
		boolean excludesNameValue = getExcludesOnNameValueDependency();
		AttributeType tempAttribute;
		Map<String, ArrayList<Map<String, IfcPropertyToCOBieString>>> productsAttributes =
				IfcToAttribute.getAttributePsetStringsFromObjects(objects);
		for(String productName : productsAttributes.keySet())
		{
			ArrayList<Map<String,IfcPropertyToCOBieString>> productAttributes =
					productsAttributes.get(productName);
			for (Map<String,IfcPropertyToCOBieString> attributeSet : productAttributes)
			{
				for (String attributeKey : attributeSet.keySet())
				{
					
					try
					{
							
						 name = attributeKey;
						 pStrvalue = attributeSet.get(attributeKey);
						 value = pStrvalue.getValueString();
						 if (excludesNameValue && !(isExcludedByNameValue(name,value)))
						 {
							 rowName = productName;
							 description = pStrvalue.getDescriptionString();
							 extObject = pStrvalue.getPropertySetString();
							 extIdentifier = pStrvalue.getPropertySetGlobalIDString();
							 extSystem = COBieUtility.getApplicationName(oh);
							 if (pStrvalue instanceof IfcPhysicalQuantityToCOBieString)
							 {
								 allowedValues = COBieUtility.COBieNA;
								 IfcPhysicalQuantityToCOBieString pQStr =
										 (IfcPhysicalQuantityToCOBieString) pStrvalue;
								 unit = COBieUtility.getCOBieString(pQStr.getUnitString());
							 }
							 else if (pStrvalue instanceof IfcSingleValueToCOBieString)
							 {
								 IfcSingleValueToCOBieString svStr =
										 (IfcSingleValueToCOBieString) pStrvalue;
								 allowedValues = COBieUtility.COBieNA;
								 unit = COBieUtility.getCOBieString(svStr.getUnitString());
							 }
							 else if (pStrvalue instanceof IfcEnumeratedValueToCOBieString)
							 {
								 IfcEnumeratedValueToCOBieString enumStr =
										 (IfcEnumeratedValueToCOBieString) pStrvalue;
								 unit = COBieUtility.getCOBieString(enumStr.getUnitString());
								 allowedValues =
										 COBieUtility.getCOBieString(COBieUtility.delimittedStringFromArrayList(enumStr.getEnumerationReferenceStrings()));
								 
							 }
							 
							 tempAttribute =
										attributes.addNewAttribute();
							 tempAttribute.setName(name);
							 tempAttribute.setRowName(rowName);
							 tempAttribute.setSheetName(worksheetName);
							 tempAttribute.setValue(value);
							 tempAttribute.setUnit(unit);
							 tempAttribute.setExtSystem(extSystem);
							 tempAttribute.setExtIdentifier(extIdentifier);
							 tempAttribute.setCreatedBy(createdBy);
							 tempAttribute.setCreatedOn(createdOn);
							 tempAttribute.setCategory(category);
							 tempAttribute.setExtObject(extObject);
							 tempAttribute.setDescription(description);
							 tempAttribute.setAllowedValues(allowedValues);
							 tempAttribute.setExtIdentifier(extIdentifier);
							 loggerStrings.rowWritten();
						 }
						 
					}
					catch(Exception ex)
					{
						loggerStrings.error(ex);
					}
					 
				}
			}
		}
	}
	
	private static void writeTypeAttributes(ArrayList<IfcRelDefinesByType> types, COBIEType.Attributes
			attributes, IfcModelInterface model,LogHandler loggerStrings)
	{
		boolean excludesNameValue = getExcludesOnNameValueDependency();
		IfcOwnerHistory oh = IfcToContact.getFirstOwnerHistory(model);
		String name = "";
		String createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
		Calendar createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
		String category = IfcToAttribute.typeCategory;
		String sheetName = IfcToAttribute.typeSheetName;
		String rowName = "";
		IfcPropertyToCOBieString pStrvalue;
		String value;
		String unit = "";
		String extSystem = "";
		String extObject = "";
		String extIdentifier = "";
		String description = "";
		String allowedValues = "";
		AttributeType tempAttribute;

		Map<String,ArrayList<Map<String,IfcPropertyToCOBieString>>> typeAttributes =
				IfcToAttribute.getPsetStringsFromTypes(types);
		
		for(String typeName : typeAttributes.keySet())
		{
			ArrayList<Map<String,IfcPropertyToCOBieString>> productAttributes =
					typeAttributes.get(typeName);
			for (Map<String,IfcPropertyToCOBieString> attributeSet : productAttributes)
			{
				for (String attributeKey : attributeSet.keySet())
				{
					try
					{
						name = attributeKey;
						pStrvalue = attributeSet.get(attributeKey);
						value = pStrvalue.getValueString();
						if (excludesNameValue && !(isExcludedByNameValue(name,value)))
						{							
							 rowName = typeName;
							 description = pStrvalue.getDescriptionString();
							 extObject = pStrvalue.getPropertySetString();
							 extIdentifier = pStrvalue.getPropertySetGlobalIDString();
							 extSystem = COBieUtility.getApplicationName(oh);
							 if (pStrvalue instanceof IfcPhysicalQuantityToCOBieString)
							 {
								 allowedValues = COBieUtility.COBieNA;
								 IfcPhysicalQuantityToCOBieString pQStr =
										 (IfcPhysicalQuantityToCOBieString) pStrvalue;
								 unit = COBieUtility.getCOBieString(pQStr.getUnitString());
							 }
							 else if (pStrvalue instanceof IfcSingleValueToCOBieString)
							 {
								 IfcSingleValueToCOBieString svStr =
										 (IfcSingleValueToCOBieString) pStrvalue;
								 allowedValues = COBieUtility.COBieNA;
								 unit = COBieUtility.getCOBieString(svStr.getUnitString());
							 }
							 else if (pStrvalue instanceof IfcEnumeratedValueToCOBieString)
							 {
								 IfcEnumeratedValueToCOBieString enumStr =
										 (IfcEnumeratedValueToCOBieString) pStrvalue;
								 unit = COBieUtility.getCOBieString(enumStr.getUnitString());
								 allowedValues =
										 COBieUtility.getCOBieString(COBieUtility.delimittedStringFromArrayList(enumStr.getEnumerationReferenceStrings()));
								 
							 }
							 tempAttribute =
										attributes.addNewAttribute();
							 tempAttribute.setName(name);
							 tempAttribute.setRowName(rowName);
							 tempAttribute.setSheetName(sheetName);
							 tempAttribute.setValue(value);
							 tempAttribute.setUnit(unit);
							 tempAttribute.setExtSystem(extSystem);
							 tempAttribute.setExtIdentifier(extIdentifier);
							 tempAttribute.setCreatedBy(createdBy);
							 tempAttribute.setCreatedOn(createdOn);
							 tempAttribute.setCategory(category);
							 tempAttribute.setExtObject(extObject);
							 tempAttribute.setDescription(description);
							 tempAttribute.setAllowedValues(allowedValues);
							 tempAttribute.setExtIdentifier(extIdentifier);
							 loggerStrings.rowWritten();
						}
					}
					catch(Exception ex)
					{
						loggerStrings.error(ex);
					}
					 
				}
			}
		}
	}
	
	private static void writeTypesComponents(COBIEType cType, IfcModelInterface model,LogHandler loggerStrings)
	{
		ArrayList<IfcRelDefinesByType> defByTypes =
				IfcToType.getCandidateRelDefinesByTypes(model);
		ArrayList<String> componentNamesAdded =
				new ArrayList<String>();
		IfcProduct tempProduct;
		String name;
		ArrayList<IfcObject> products = new ArrayList<IfcObject>();
		for(IfcRelDefinesByType defByType : defByTypes)
		{
			
			for(IfcObject obj : defByType.getRelatedObjects())
			{
				if (obj instanceof IfcProduct)
				{
					tempProduct = (IfcProduct) obj;
					name = IfcToComponent.nameFromProduct(tempProduct);
					if (!componentNamesAdded.contains(name) &&
							COBieQuery.isComponentInCOBie(tempProduct, cType))
							//	IfcToComponent.isAssetComponent(tempProduct))
							products.add(tempProduct);
				}
			}
		}
		//IfcToAttribute.writeComponentAttributes(products,getCobieAttributes(cType),model);
		IfcToAttribute.writeTypeAttributes(defByTypes,getCobieAttributes(cType),model,loggerStrings);
		IfcToAttribute.writeObjectAttributes(products, getCobieAttributes(cType), model,loggerStrings);	
	}

	private static ArrayList<IfcObject> getBuildings(IfcModelInterface model)
	{
		ArrayList<IfcObject> bldgObjs =
			 new ArrayList<IfcObject>();
		for(IfcBuilding bldg : model.getAll(IfcBuilding.class))
			bldgObjs.add(bldg);
		return bldgObjs;
	}
	
	private static ArrayList<IfcObject> getFloors(IfcModelInterface model)
	{
		
		ArrayList<IfcObject> bldgObjs =
			 new ArrayList<IfcObject>();
		for(IfcBuildingStorey bldgStorey : model.getAll(IfcBuildingStorey.class))
			bldgObjs.add(bldgStorey);
		return bldgObjs;
	}
	
	private static ArrayList<IfcObject> getSpaces(IfcModelInterface model)
	{
		ArrayList<IfcObject> bldgObjs =
			 new ArrayList<IfcObject>();
		for(IfcSpace  space : model.getAll(IfcSpace.class))
			bldgObjs.add(space);
		return bldgObjs;
	}
	
	
	private static String sheetNameFromRoot(IfcRoot root)
	{
		String worksheetName = "";
		
		if (root instanceof IfcBuilding)
			worksheetName = IfcToAttribute.facilitySheetName;
		else if (root instanceof IfcBuildingStorey)
			worksheetName = IfcToAttribute.floorSheetName;
		else if (root instanceof IfcSpace)
			worksheetName = IfcToAttribute.spaceSheetName;
		else if (root instanceof IfcProduct)
			worksheetName = IfcToAttribute.componentSheetName;
		return worksheetName;
	}
	
	private static String categoryFromRoot(IfcRoot root)
	{
		String category = "";
		if (root instanceof IfcProduct)
			category = IfcToAttribute.componentCategory;
		else if (root instanceof IfcBuilding)
			category = IfcToAttribute.facilityCategory;
		else if (root instanceof IfcBuildingStorey)
			category = IfcToAttribute.floorCategory;
		else if (root instanceof IfcSpace)
			category = IfcToAttribute.spaceCategory;
		return category;
	}
	
		
	private static COBIEType.Attributes getCobieAttributes(COBIEType cType)
	{
		COBIEType.Attributes attributes;
		try
		{
			attributes = cType.getAttributes();
			if (attributes==null || attributes.isNil())
				attributes = cType.addNewAttributes();
		}
		catch(Exception ex)
		{
			attributes = cType.addNewAttributes();
		}
		return attributes;
	}
	
	private static Map<String, ArrayList<Map<String, IfcPropertyToCOBieString>>> 
	getPsetStringsFromTypes(ArrayList<IfcRelDefinesByType> types)
{
	Map<String, ArrayList<Map<String, IfcPropertyToCOBieString>>> typeAttributes = 
			new HashMap<String, ArrayList<Map<String, IfcPropertyToCOBieString>>>();
	//Map<String, Map<String, String>> propertyMaps =
		//	new Map<String,Map<String,String>>();
	for (IfcRelDefinesByType relDefines : types)
	{
		try
		{
			String name = relDefines.getRelatingType().getName();
			if (!typeAttributes.containsKey(name))
			{
				ArrayList<Map<String,IfcPropertyToCOBieString>> typePropertyStrings =
						new ArrayList<Map<String,IfcPropertyToCOBieString>>();
				Map<String,IfcPropertyToCOBieString> propertyStrings =
						IfcRelationshipsToCOBie.psetStringsFromRelDefines(relDefines, 
					getTypeExclusions(), true);
				if (!propertyStrings.isEmpty())
					typePropertyStrings.add(propertyStrings);
				typeAttributes.put(name, typePropertyStrings);
			}			
		}
		catch(Exception e)
		{
			String noop="";
		}
	}
	return typeAttributes;
}
	
	private static Map<String, ArrayList<Map<String, IfcPropertyToCOBieString>>> 
	getAttributePsetStringsFromObjects(ArrayList<IfcObject> objects)
	{
		Map<String, ArrayList<Map<String, IfcPropertyToCOBieString>>> productsAttributes = 
				new HashMap<String, ArrayList<Map<String, IfcPropertyToCOBieString>>>();
		//Map<String, Map<String, String>> propertyMaps =
			//	new Map<String,Map<String,String>>();
		ArrayList<String> excludeAttributes = new ArrayList<String>();
		IfcObject firstObj = null;
		if (objects.size()>0)
			firstObj = objects.get(0);
		if (firstObj instanceof IfcBuilding)
			excludeAttributes = IfcToAttribute.getFacilityExclusions();
		else if (firstObj instanceof IfcBuildingStorey)
			excludeAttributes = IfcToAttribute.getFloorExclusions();
		else if (firstObj instanceof IfcSpace)
			excludeAttributes = IfcToAttribute.getSpaceExclusions();
		else if (firstObj instanceof IfcProduct)
			excludeAttributes = IfcToAttribute.getComponentExclusions();
		for (IfcObject obj : objects)
		{
			String name = obj.getName();
			if (!productsAttributes.containsKey(name))
			{
				EList<IfcRelDefines> relDefines = 
						obj.getIsDefinedBy();
				ArrayList<Map<String,IfcPropertyToCOBieString>> productPropertyStrings =
						new ArrayList<Map<String,IfcPropertyToCOBieString>>();
				
				for(IfcRelDefines relDef : relDefines)
				{
					
					if (!(relDef instanceof IfcRelDefinesByType))
					{
						if (!productsAttributes.containsKey(name))
						{
							
							Map<String,IfcPropertyToCOBieString> propertyStrings =
									IfcRelationshipsToCOBie.psetStringsFromRelDefines(relDef, 
								excludeAttributes, true);
							if (!propertyStrings.isEmpty())
								productPropertyStrings.add(propertyStrings);
								
						}
					}
					
				}
				Map<String,IfcPropertyToCOBieString> directAttributes =
						COBieUtility.psetStringsFromAttributes(obj, getAllExclusions(), true);
				if (!directAttributes.isEmpty())
					productPropertyStrings.add(directAttributes);
				productsAttributes.put(name, productPropertyStrings);
			}			
		}
		return productsAttributes;
	}
	
	private static ArrayList<String> getComponentExclusions()
	{
		ArrayList<String> compExclusions = new ArrayList<String>();
			compExclusions.addAll(allExclusions);
			compExclusions.addAll(componentExclusions);
		return compExclusions;
	}
	
	private static ArrayList<String> getAllExclusions()
	{
		ArrayList<String> compExclusions = new ArrayList<String>();
		compExclusions.addAll(allExclusions);
		return compExclusions;
	}
	
	private static ArrayList<String> getTypeExclusions()
	{
		ArrayList<String> typeExclusionsCopy = new ArrayList<String>();
		typeExclusionsCopy.addAll(allExclusions);
		typeExclusionsCopy.addAll(typeExclusions);
		return typeExclusionsCopy;
	}
	
	private static ArrayList<String> getFacilityExclusions()
	{
		ArrayList<String> facilityExclusionsCopy = new ArrayList<String>();
		facilityExclusionsCopy.addAll(allExclusions);
		facilityExclusionsCopy.addAll(facilityExclusions);
		return facilityExclusionsCopy;
	}
	
	private static ArrayList<String> getFloorExclusions()
	{
		ArrayList<String> floorExclusionsCopy = new ArrayList<String>();
		floorExclusionsCopy.addAll(allExclusions);
		floorExclusionsCopy.addAll(floorExclusions);
		return floorExclusionsCopy;
	}
	
	private static ArrayList<String> getSpaceExclusions()
	{
		ArrayList<String> spaceExclusionsCopy = new ArrayList<String>();
		spaceExclusionsCopy.addAll(allExclusions);
		spaceExclusionsCopy.addAll(spaceExclusions);
		return spaceExclusionsCopy;
	}

	private static boolean getExcludesOnNameValueDependency()
	{
		return ExcludesOnNameValueDependency;
	}
	
	
	private static ArrayList<String> getExcludesOnNameValueDependencyExceptions()
	{
		return nameValueDependencyExceptions;
	}
	
	private static boolean isExcludedByNameValue(String name, String value)
	{
		ArrayList<String> exceptionNames =
				getExcludesOnNameValueDependencyExceptions();
		if (name.equalsIgnoreCase(value) && !exceptionNames.contains(name))
			return true;
		else if (getValueExclusionsLCase().contains(value.toLowerCase()))
			return true;
		else
			return false;
	}
	
	private static ArrayList<String> getValueExclusions()
	{
		return valueExclusions;
	}
	
	private static ArrayList<String> getValueExclusionsLCase()
	{
		ArrayList<String> lCaseCopy = new ArrayList<String>();
		ArrayList<String> originalValues = getValueExclusions();
		for(String value : originalValues)
		{
			lCaseCopy.add(value.toLowerCase());
		}
		return lCaseCopy;
	}
}
