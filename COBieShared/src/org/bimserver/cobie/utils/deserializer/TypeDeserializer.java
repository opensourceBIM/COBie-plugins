package org.bimserver.cobie.utils.deserializer;
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
import java.util.Calendar;
import java.util.List;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.TypeType;

import org.bimserver.cobie.utils.deserializer.modelhandlers.IfcCommonHandler;
import org.bimserver.cobie.utils.deserializer.propertysets.Pset_Asset;
import org.bimserver.cobie.utils.deserializer.propertysets.Pset_EconomicImpactValues;
import org.bimserver.cobie.utils.deserializer.propertysets.Pset_ManufacturersTypeInformation;
import org.bimserver.cobie.utils.deserializer.propertysets.Pset_ServiceLife;
import org.bimserver.cobie.utils.deserializer.propertysets.Pset_Specification;
import org.bimserver.cobie.utils.deserializer.propertysets.Pset_Warranty;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcActuatorType;
import org.bimserver.models.ifc2x3tc1.IfcAlarmType;
import org.bimserver.models.ifc2x3tc1.IfcClassificationReference;
import org.bimserver.models.ifc2x3tc1.IfcControllerType;
import org.bimserver.models.ifc2x3tc1.IfcControllerTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcDoorStyle;
import org.bimserver.models.ifc2x3tc1.IfcElementType;
import org.bimserver.models.ifc2x3tc1.IfcMaterial;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayer;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcSensorType;
import org.bimserver.models.ifc2x3tc1.IfcSensorTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.bimserver.models.ifc2x3tc1.IfcTypeProduct;
import org.bimserver.models.ifc2x3tc1.IfcWindowStyle;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.cobie.COBieUtility;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EEnumImpl;


public class TypeDeserializer 
{
	private static final String IFC_ENUM_VALUE_NOT_DEFINED = "NOTDEFINED";
	private static final String AS_STRING_SUFFIX = "AsString";
	private static final String PREDEFINED_TYPE = "PredefinedType";
	public static final String BAMIE_TYPE_CATEGORY_PREFIX = "BAMie:";
	private COBieIfcModel model;
	private IfcCommonHandler ifcCommonHandler;
	private COBIEType.Types types;
	public TypeDeserializer(COBieIfcModel cobieIfcModel, IfcCommonHandler ifcCommonHandler, COBIEType.Types types)
	{
		this.model = cobieIfcModel;
		this.ifcCommonHandler = ifcCommonHandler;
		this.types = types;
	}
	
	public void deserializeTypes()
	{
		String name = "";
		String createdBy;
		String externalId;
		Calendar createdOn;
		if (types != null)
		{
			for (TypeType type : types.getTypeArray())
			{
				try
				{
					name = type.getName();
					type.getExtObject();
					IfcTypeObject newTypeObject = TypeDeserializer.typeObjectFromType(type);
					if (newTypeObject != null && !model.containsType(name))
					{
						String category = type.getCategory();
						if(isTypeBAMie(newTypeObject))
						{
							tryToAssignBAMieEnumValueToType(category,newTypeObject);
							category = removeBAMieValuesFromCategoryDelimitedList(category);
							
						}
						List<IfcClassificationReference> classifications = 
								ifcCommonHandler.getClassificationHandler().classificationReferencesFromString(category);
						createdBy = type.getCreatedBy();
						externalId = type.getExtIdentifier();
						createdOn = type.getCreatedOn();
						IfcOwnerHistory ownerHistory = this
								.ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(createdBy, createdOn,type.getExtSystem());
						newTypeObject.setOwnerHistory(ownerHistory);
						newTypeObject.setGlobalId(this
								.ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(externalId));

						Pset_ManufacturersTypeInformation psetManufacturerType = new Pset_ManufacturersTypeInformation(
								type);
						this.ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToTypeObject(newTypeObject,
								psetManufacturerType, false);

						Pset_Warranty psetWarranty = new Pset_Warranty(type);
						this.ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToTypeObject

						(newTypeObject, psetWarranty, false);

						Pset_Asset psetAsset = new Pset_Asset(type);
						this.ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToTypeObject(newTypeObject,
								psetAsset, false);

						Pset_ServiceLife svcLife = new Pset_ServiceLife(type);
						this.ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToTypeObject(newTypeObject,
								svcLife, false);

						Pset_EconomicImpactValues psetEconomicImpact = new Pset_EconomicImpactValues(
								type);
						this.ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToTypeObject(newTypeObject,
								psetEconomicImpact, false);
						Pset_Specification psetSpec = new Pset_Specification(type);
						this.ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToTypeObject(newTypeObject,
								psetSpec, false);
								model.add(newTypeObject, this.ifcCommonHandler.getOidProvider());
						for(IfcClassificationReference classification:classifications)
							this.ifcCommonHandler.getClassificationHandler().addClassificationReferenceToObject(classification,
									newTypeObject);
					}
				} catch (Exception e)
				{
				}
			}
		}

	}
	
	private void tryToAssignBAMieEnumValueToType(String category,IfcTypeObject type)
	{
		ArrayList<String> bamieStrings = getBAMieValuesFromCategoryDelimitedList(category);
		for(String bamieString:bamieStrings)
		{
			String candidateEnumValue = bamieString.replace(BAMIE_TYPE_CATEGORY_PREFIX, "").toUpperCase();
			if(type instanceof IfcSensorType)
			{
				IfcSensorType sensorType = (IfcSensorType) type;
				try
				{
					sensorType.setPredefinedType(IfcSensorTypeEnum.valueOf(candidateEnumValue));
				}
				catch(Exception e)
				{
					
				}
			}
			else if (type instanceof IfcControllerType)
			{
				IfcControllerType controllerType = (IfcControllerType) type;
				try
				{
					controllerType.setPredefinedType(IfcControllerTypeEnum.valueOf(candidateEnumValue));
				}
				catch(Exception ex)
				{
					
				}
			}
		}
	}
	
	public static String removeBAMieValuesFromCategoryDelimitedList(String categoryDelimString)
	{
		ArrayList<String> allStrings = COBieUtility.arrayListFromDelimString(categoryDelimString);
		ArrayList<String> bamieStrings = new ArrayList<String>();
		for(String delimString:allStrings)
			if(isBAMieTypeCategory(delimString))
				bamieStrings.add(delimString);
		for(String bamieString:bamieStrings)
			allStrings.remove(bamieString);
		String newDelimitedString = COBieUtility.delimittedStringFromArrayList(allStrings);
		return newDelimitedString;
	}
	
	public static ArrayList<String> getBAMieValuesFromCategoryDelimitedList(String categoryDelimString)
	{
		ArrayList<String> allStrings = COBieUtility.arrayListFromDelimString(categoryDelimString);
		ArrayList<String> bamieStrings = new ArrayList<String>();
		for(String delimString:allStrings)
			if(isBAMieTypeCategory(delimString))
				bamieStrings.add(delimString);
		return bamieStrings;
	}
	
	private static boolean isBAMieTypeCategory(String delimString)
	{
		return delimString.toLowerCase().startsWith(BAMIE_TYPE_CATEGORY_PREFIX.toLowerCase());
	}

	public static IfcTypeObject typeObjectFromType(TypeType cobieType)
	{
		boolean isLegal = false;
		IfcTypeProduct defaultTypeObj =
				Ifc2x3tc1Factory.eINSTANCE.createIfcTypeProduct();
		String externalObject =
				cobieType.getExtObject();
		IdEObject genericType =
				FromCOBieToIfc.newIdEObject(externalObject);
		
		
		if (genericType instanceof IfcMaterial || genericType instanceof IfcMaterialLayer ||
				genericType instanceof IfcMaterialLayerSet)
			genericType = Ifc2x3tc1Factory.eINSTANCE.createIfcFurnishingElementType();

		if (genericType != null && genericType instanceof 
				IfcTypeObject)
		{
			IfcTypeObject typeObj =
					(IfcTypeObject) genericType;
			isLegal = true;
			if (genericType instanceof IfcWindowStyle)
			{
				IfcWindowStyle windowStyle =
						(IfcWindowStyle) typeObj;
				//has to get some properties from the Attribute sheet
				//e.g. OperationType ConstructionType...
				defaultTypeObj = windowStyle;
				
			}
			else if (genericType instanceof IfcDoorStyle)
			{
				IfcDoorStyle doorStyle =
						(IfcDoorStyle) typeObj;
				defaultTypeObj = doorStyle;
			}
			else if (genericType instanceof IfcElementType)
			{
				IfcElementType elementType =
						(IfcElementType) typeObj;
				defaultTypeObj = elementType;
			}
		}
		defaultTypeObj.setName(cobieType.getName());
		defaultTypeObj.setDescription(cobieType.getDescription());
		try
		{
			checkPredefinedTypeField(defaultTypeObj);
		}
		catch(Exception ex)
		{
			
		}
		return defaultTypeObj;
	}
	
	private static void checkPredefinedTypeField(IfcTypeObject typeObject)
	{
		EClass eClass = typeObject.eClass();
		
		for(EStructuralFeature feature : eClass.getEAllStructuralFeatures())
		{
			if (!feature.isDerived() && !feature.isVolatile() && !feature.getName().endsWith(AS_STRING_SUFFIX)) 
			{
				EClassifier type = feature.getEType();
				if (type instanceof EEnum )
				{
					EEnumLiteral enumValue = 
							(((EEnumImpl) feature.getEType()).getEEnumLiteral(IFC_ENUM_VALUE_NOT_DEFINED));
					typeObject.eSet(feature,enumValue.getInstance());
				}
			}
		}
	}
	
	public  List<IfcClassificationReference> classificationReferenceFromType
	(TypeType cobieType)
	{
		return ifcCommonHandler.getClassificationHandler().classificationReferencesFromString(cobieType.getCategory());
	}

	public static boolean isTypeBAMie(IfcTypeObject typeObject)
	{
		return typeObject instanceof IfcSensorType || typeObject instanceof IfcControllerType || typeObject instanceof IfcActuatorType || typeObject instanceof IfcAlarmType;
	}
}
