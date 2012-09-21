package org.bimserver.cobie.utils.serializer.sheetserializers;
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
import java.util.List;
import java.util.Map;

import org.bimserver.cobie.cobielite.AttributeType;
import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.utils.deserializer.modelhandlers.OwnerHistoryHandler;
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
import org.bimserver.shared.cobie.COBieQuery;
import org.bimserver.shared.cobie.COBieUtility;
import org.bimserver.shared.cobie.COBieUtility.CobieSheetName;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IfcToAttribute 
{
	protected static final boolean ExcludesOnNameValueDependency = true;
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(IfcToAttribute.class);
	protected static final String componentSheetName = "Component";
	protected static CobieSheetName cobieSheet = CobieSheetName.Attribute;
	protected static final String componentCategory = "Requirement";
	protected static final String typeCategory = "Requirement";
	protected static final String facilityCategory = "Requirement";
	protected static final String floorCategory = "Requirement";
	protected static final String spaceCategory = "Requirement";
	protected static final String typeSheetName = "Type";
	protected static final String facilitySheetName = "Facility";
	protected static final String spaceSheetName = "Space";
	protected static final String floorSheetName = "Floor";
	protected static final ArrayList<String> valueExclusions =
			new ArrayList<String>(Arrays.asList("default"));
	protected static final ArrayList<String> nameValueDependencyExceptions =
			new ArrayList<String>(Arrays.asList("Fire Rating"));
	protected static ArrayList<String> facilityExclusions =
			new ArrayList<String>(Arrays.asList("Phase"));
	protected static ArrayList<String> floorExclusions =
			new ArrayList<String>(Arrays.asList("Elevation"));
	protected static ArrayList<String> spacePropertySetNameExclusions = new ArrayList<String>(Arrays.asList("BaseQuantities"));
	protected static ArrayList<String> spaceExclusions =
			new ArrayList<String>(Arrays.asList("Area","Number","ZoneName"));
	protected static ArrayList<String> typeExclusions =
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
	protected static ArrayList<String> componentExclusions =
			new ArrayList<String>(Arrays.asList("SerialNumber",
								"InstallationDate",
								"WarrantyStartDate",
								"TagNumber",
								"BarCode",
								"AssetIdentifier",
								"System Name",
								"System Type",
								"Circuit Number"));
	protected static ArrayList<String> allExclusions =
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

	public static void writeAttributes(COBIEType cobieType, IfcModelInterface model)
	{	
		LogHandler loggerHandler = new LogHandler(cobieSheet,LOGGER);
		loggerHandler.sheetWriteBegin();
		IfcToAttribute.writeObjectAttributes(getBuildings(model), IfcToAttribute.getCobieAttributes(cobieType), model,loggerHandler);
		IfcToAttribute.writeObjectAttributes(getFloors(model),IfcToAttribute.getCobieAttributes(cobieType),model,loggerHandler);
		IfcToAttribute.writeObjectAttributes(getSpaces(model),IfcToAttribute.getCobieAttributes(cobieType),model,loggerHandler);
		IfcToAttribute.writeTypesComponents(cobieType, model,loggerHandler);	
		try
		{
			IfcToAttributeBPie.emulateSpaceTypeRelationships(cobieType, model);
		}
		catch(Exception ex)
		{
			
		}
		loggerHandler.sheetWritten();
	}
	
	
	protected static void writeObjectAttributes(ArrayList<IfcObject> objects, 
			COBIEType.Attributes attributes, IfcModelInterface model,LogHandler loggerStrings)
	{
		IfcRoot firstRoot = null;
		if (objects.size()>0)
			firstRoot = objects.get(0);
		IfcOwnerHistory defaultOwnerHistory = IfcToContact.getLatestOwnerHistory(model);
		String name = "";
		String defaultCreatedBy = COBieUtility.getEmailFromOwnerHistory(defaultOwnerHistory);
		String createdBy = defaultCreatedBy;
		Calendar createdOn = IfcToContact.getCreatedOn(defaultOwnerHistory.getCreationDate());
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
						 category = IfcToAttribute.categoryFromRoot(firstRoot);
						 name = attributeKey;
						 pStrvalue = attributeSet.get(attributeKey);
						 value = pStrvalue.getValueString();
						 if (excludesNameValue && !(isExcludedByNameValue(name,value)))
						 {
							 try
							 {
								 if(pStrvalue.getAttachedOwnerHistory()!=null)
								 {
									 createdBy = COBieUtility.getEmailFromOwnerHistory(pStrvalue.getAttachedOwnerHistory());
									 createdOn = IfcToContact.getCreatedOn(pStrvalue.getAttachedOwnerHistory().getCreationDate());
									 extSystem = COBieUtility.getApplicationName(pStrvalue.getAttachedOwnerHistory());
								 }
								 else
								 {
									 createdBy = defaultCreatedBy;
									 createdOn = IfcToContact.getCreatedOn(defaultOwnerHistory.getCreationDate());
									 extSystem = COBieUtility.getApplicationName(defaultOwnerHistory);
								 }
							 }
							 catch(Exception ohException)
							 {
								 createdBy = defaultCreatedBy;
								 createdOn = IfcToContact.getCreatedOn(defaultOwnerHistory.getCreationDate());
								 extSystem = COBieUtility.getApplicationName(defaultOwnerHistory);
							 }
							 rowName = productName;
							 description = pStrvalue.getDescriptionString();
							 extObject = pStrvalue.getPropertySetString();
							if(!(worksheetName.equalsIgnoreCase(COBieUtility.CobieSheetName.Space.name())&&
									spacePropertySetNameExclusions.contains(extObject)))
							{
								 extIdentifier = pStrvalue.getPropertySetGlobalIDString();
								 
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
								 if(pStrvalue.getPropertySet()!=null)
								 {
									 String tmpCategory = COBieUtility.getPropertySetClassification(pStrvalue.getPropertySet(),model);
									 if(!COBieUtility.isNA(tmpCategory))
										 category = tmpCategory;
								 }
									 
								 addNewAttribute(attributes, name, createdBy,
										createdOn, category, worksheetName,
										rowName, value, unit, extSystem, extObject,
										extIdentifier, description, allowedValues);
								 loggerStrings.rowWritten();
								}
							
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


	public static void addNewAttribute(COBIEType.Attributes attributes,
			String name, String createdBy, Calendar createdOn, String category,
			String worksheetName, String rowName, String value, String unit,
			String extSystem, String extObject, String extIdentifier,
			String description, String allowedValues)
	{
		AttributeType tempAttribute;
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
	}
	
	protected static void writeTypeAttributes(List<IfcRelDefinesByType> defByTypes, COBIEType.Attributes
			attributes, IfcModelInterface model,LogHandler loggerStrings)
	{
		boolean excludesNameValue = getExcludesOnNameValueDependency();
		IfcOwnerHistory oh = IfcToContact.getLatestOwnerHistory(model);
		String name = "";
		String defaultCreatedBy = COBieUtility.getEmailFromOwnerHistory(oh);
		String createdBy = defaultCreatedBy;
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
		IfcOwnerHistory defaultOwnerHistory = IfcToContact.getLatestOwnerHistory(model);
		Map<String, ArrayList<Map<String, IfcPropertyToCOBieString>>> typeAttributes =
				IfcToAttribute.getPsetStringsFromTypes(defByTypes);
		
		for(String typeName : typeAttributes.keySet())
		{
			List<Map<String,IfcPropertyToCOBieString>> productAttributes =
					typeAttributes.get(typeName);
			for (Map<String,IfcPropertyToCOBieString> attributeSet : productAttributes)
			{
				for (String attributeKey : attributeSet.keySet())
				{
					category = IfcToAttribute.typeCategory;
					try
					{
						name = attributeKey;
						pStrvalue = attributeSet.get(attributeKey);
						value = pStrvalue.getValueString();
						if (excludesNameValue && !(isExcludedByNameValue(name,value)))
						{					
							
							 try
							 {
								 if(pStrvalue.getAttachedOwnerHistory()!=null)
								 {
									 createdBy = COBieUtility.getEmailFromOwnerHistory(pStrvalue.getAttachedOwnerHistory());
									 createdOn = IfcToContact.getCreatedOn(pStrvalue.getAttachedOwnerHistory().getCreationDate());
									 extSystem = COBieUtility.getApplicationName(pStrvalue.getAttachedOwnerHistory());
								 }
								 else
								 {
									 createdBy = defaultCreatedBy;
									 createdOn = IfcToContact.getCreatedOn(defaultOwnerHistory.getCreationDate());
									 extSystem = OwnerHistoryHandler.UNKNOWN_APPLICATION_NAME;
								 }
							 }
							 catch(Exception ohException)
							 {
								 createdBy = defaultCreatedBy;
								 createdOn = IfcToContact.getCreatedOn(defaultOwnerHistory.getCreationDate());
							 }
							 rowName = typeName;
							 description = pStrvalue.getDescriptionString();
							 extObject = pStrvalue.getPropertySetString();
							 extIdentifier = pStrvalue.getPropertySetGlobalIDString();
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
							 if(pStrvalue.getPropertySet()!=null)
							 {
								 String tmpCategory = COBieUtility.getPropertySetClassification(pStrvalue.getPropertySet(),model);
								 if(!COBieUtility.isNA(tmpCategory))
									 category = tmpCategory;
							 }
							 addNewAttribute(attributes, name, createdBy,
									createdOn, category, sheetName, rowName,
									value, unit, extSystem, extObject,
									extIdentifier, description, allowedValues);
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
	
	protected static void writeTypesComponents(COBIEType cType, IfcModelInterface model,LogHandler loggerStrings)
	{
		List<IfcRelDefinesByType> defByTypes =
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

	protected static ArrayList<IfcObject> getBuildings(IfcModelInterface model)
	{
		ArrayList<IfcObject> bldgObjs =
			 new ArrayList<IfcObject>();
		for(IfcBuilding bldg : model.getAll(IfcBuilding.class))
			bldgObjs.add(bldg);
		return bldgObjs;
	}
	
	protected static ArrayList<IfcObject> getFloors(IfcModelInterface model)
	{
		
		ArrayList<IfcObject> bldgObjs =
			 new ArrayList<IfcObject>();
		for(IfcBuildingStorey bldgStorey : model.getAll(IfcBuildingStorey.class))
			bldgObjs.add(bldgStorey);
		return bldgObjs;
	}
	
	protected static ArrayList<IfcObject> getSpaces(IfcModelInterface model)
	{
		ArrayList<IfcObject> bldgObjs =
			 new ArrayList<IfcObject>();
		for(IfcSpace  space : model.getAll(IfcSpace.class))
			bldgObjs.add(space);
		return bldgObjs;
	}
	
	
	protected static String sheetNameFromRoot(IfcRoot root)
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
	
	protected static String categoryFromRoot(IfcRoot root)
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
		else
			category = IfcToAttribute.spaceCategory;
		return category;
	}
	
		
	protected static COBIEType.Attributes getCobieAttributes(COBIEType cType)
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
	
	protected static Map<String, ArrayList<Map<String, IfcPropertyToCOBieString>>> 
	getPsetStringsFromTypes(List<IfcRelDefinesByType> defByTypes)
{
	Map<String, ArrayList<Map<String, IfcPropertyToCOBieString>>> typeAttributes = 
			new HashMap<String, ArrayList<Map<String, IfcPropertyToCOBieString>>>();
	//Map<String, Map<String, String>> propertyMaps =
		//	new Map<String,Map<String,String>>();
	for (IfcRelDefinesByType relDefines : defByTypes)
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
	
	protected static Map<String, ArrayList<Map<String, IfcPropertyToCOBieString>>> 
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
	
	protected static ArrayList<String> getComponentExclusions()
	{
		ArrayList<String> compExclusions = new ArrayList<String>();
			compExclusions.addAll(allExclusions);
			compExclusions.addAll(componentExclusions);
		return compExclusions;
	}
	
	protected static ArrayList<String> getAllExclusions()
	{
		ArrayList<String> compExclusions = new ArrayList<String>();
		compExclusions.addAll(allExclusions);
		return compExclusions;
	}
	
	protected static ArrayList<String> getTypeExclusions()
	{
		ArrayList<String> typeExclusionsCopy = new ArrayList<String>();
		typeExclusionsCopy.addAll(allExclusions);
		typeExclusionsCopy.addAll(typeExclusions);
		return typeExclusionsCopy;
	}
	
	protected static ArrayList<String> getFacilityExclusions()
	{
		ArrayList<String> facilityExclusionsCopy = new ArrayList<String>();
		facilityExclusionsCopy.addAll(allExclusions);
		facilityExclusionsCopy.addAll(facilityExclusions);
		return facilityExclusionsCopy;
	}
	
	protected static ArrayList<String> getFloorExclusions()
	{
		ArrayList<String> floorExclusionsCopy = new ArrayList<String>();
		floorExclusionsCopy.addAll(allExclusions);
		floorExclusionsCopy.addAll(floorExclusions);
		return floorExclusionsCopy;
	}
	
	protected static ArrayList<String> getSpaceExclusions()
	{
		ArrayList<String> spaceExclusionsCopy = new ArrayList<String>();
		spaceExclusionsCopy.addAll(allExclusions);
		spaceExclusionsCopy.addAll(spaceExclusions);
		return spaceExclusionsCopy;
	}

	protected static boolean getExcludesOnNameValueDependency()
	{
		return ExcludesOnNameValueDependency;
	}
	
	
	protected static ArrayList<String> getExcludesOnNameValueDependencyExceptions()
	{
		return nameValueDependencyExceptions;
	}
	
	protected static boolean isExcludedByNameValue(String name, String value)
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
	
	protected static ArrayList<String> getValueExclusions()
	{
		return valueExclusions;
	}
	
	protected static ArrayList<String> getValueExclusionsLCase()
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
