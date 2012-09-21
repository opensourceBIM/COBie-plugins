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
import java.util.Map;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.TypeType;
import org.bimserver.cobie.utils.deserializer.ConnectionDeserializer;
import org.bimserver.cobie.utils.stringwriters.IfcPropertyToCOBieString;
import org.bimserver.cobie.utils.stringwriters.IfcRelationshipsToCOBie;
import org.bimserver.cobie.utils.stringwriters.IfcSingleValueToCOBieString;
import org.bimserver.cobie.utils.stringwriters.IfcUnitToCOBieString;
import org.bimserver.cobie.utils.stringwriters.PropertyNameStringValueMap;
import org.bimserver.models.ifc2x3tc1.IfcControllerType;
import org.bimserver.models.ifc2x3tc1.IfcFurnitureType;
import org.bimserver.models.ifc2x3tc1.IfcMaterial;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSetUsage;
import org.bimserver.models.ifc2x3tc1.IfcMaterialSelect;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesMaterial;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.cobie.COBieUtility;
import org.bimserver.shared.cobie.COBieUtility.CobieSheetName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IfcToType
{
	private static final String FIXED_ASSET_TYPE_CAMELCASE = "Fixed";
	private static final String MOVEABLE_ASSET_TYPE_CAMELCASE = "Moveable";
	private static final String NONFIXED_ASSET_TYPE_LCASE = "nonfixed";
	private static final String MOVEABLE_ASSET_TYPE_LCASE = "moveable";
	private static final Logger LOGGER = LoggerFactory
			.getLogger(IfcToType.class);
	private static final CobieSheetName sheetName = CobieSheetName.Type;
	private static final ArrayList<String> excludeAssetStrings = new ArrayList<String>(
			Arrays.asList("IfcBeamType", "IfcMaterial", "IfcMaterialLayerSet",
					"IfcCableCarrierSegmentType", "IfcCableSegmentType",
					"IfcColumnType", "IfcCurtainWallType",
					"IfcDuctFittingType", "IfcDuctSegmentType",
					"IfcFastenerType", 
					"IfcJunctionBoxType", 
					"IfcMemberType",
					"IfcPipeFittingType", "IfcPipeSegmentType", 
					"IfcPlateType",
					"IfcRailingType", "IfcRampFlightType", "IfcRampType",
					"IfcSlabType", "IfcSpaceType", "IfcStairFlightType",
					"IfcStairType", "IfcWallType", "IfcTypeObject",
					"IfcTypeProduct", "IfcElementType"));

	private static final ArrayList<String> assetTypeStrings = new ArrayList<String>(
			Arrays.asList("AssetAccountingType"));
	private static final ArrayList<String> manufacturerStrings = new ArrayList<String>(
			Arrays.asList("Manufacturer"));
	private static final ArrayList<String> modelNumberStrings = new ArrayList<String>(
			Arrays.asList("ArticleNumber", "ModelLabel"));
	private static final ArrayList<String> warrantyGuarantorPartsStrings = new ArrayList<String>(
			Arrays.asList("WarrantyGuarantorParts", "PointOfContact"));
	private static final ArrayList<String> warrantyDurationPartsStrings = new ArrayList<String>(
			Arrays.asList("WarrantyDurationParts"));
	private static final ArrayList<String> warrantyGuarantorLaborStrings = new ArrayList<String>(
			Arrays.asList("WarrantyGuarantorLabor", "PointOfContact"));
	private static final ArrayList<String> warrantyDurationLaborStrings = new ArrayList<String>(
			Arrays.asList("WarrantyDurationLabor"));
	private static final ArrayList<String> replacementCostStrings = new ArrayList<String>(
			Arrays.asList("ReplacementCost","Replacement Cost","Cost","Replacement"));
	private static final ArrayList<String> expectedLifeStrings = new ArrayList<String>(
			Arrays.asList("ServiceLifeDuration", "Expected"));
	private static final ArrayList<String> warrantyDescriptionStrings = new ArrayList<String>(
			Arrays.asList("WarrantyDescription", "WarrantyIdentifier"));
	private static final ArrayList<String> nominalLengthStrings = new ArrayList<String>(
			Arrays.asList("NominalLength", "OverallLength"));
	private static final ArrayList<String> nominalWidthStrings = new ArrayList<String>(
			Arrays.asList("NominalWidth", "Width"));
	private static final ArrayList<String> nominalHeightStrings = new ArrayList<String>(
			Arrays.asList("NominalHeight", "Heght"));
	private static final ArrayList<String> modelReferenceStrings = new ArrayList<String>(
			Arrays.asList("ModelReference", "Reference"));
	private static final ArrayList<String> shapeStrings = new ArrayList<String>(
			Arrays.asList("Shape"));
	private static final ArrayList<String> sizeStrings = new ArrayList<String>(
			Arrays.asList("Size"));
	private static final ArrayList<String> colorStrings = new ArrayList<String>(
			Arrays.asList("Color", "Colour"));
	private static final ArrayList<String> finishStrings = new ArrayList<String>(
			Arrays.asList("Finish"));
	private static final ArrayList<String> gradeStrings = new ArrayList<String>(
			Arrays.asList("Grade"));
	private static final ArrayList<String> materialStrings = new ArrayList<String>(
			Arrays.asList("Material"));
	private static final ArrayList<String> constituentsString = new ArrayList<String>(
			Arrays.asList("Constituents", "Parts"));
	private static final ArrayList<String> featuresStrings = new ArrayList<String>(
			Arrays.asList("Features"));
	private static final ArrayList<String> accessibilityPerformanceStrings = new ArrayList<String>(
			Arrays.asList("AccessibilityPerformance", "Access"));
	private static final ArrayList<String> codePerformanceStrings = new ArrayList<String>(
			Arrays.asList("CodePerformance", "Regulation"));
	private static final ArrayList<String> sustainabilityPerformanceStrings = new ArrayList<String>(
			Arrays.asList("SustainabilityPerformance", "Environmental"));
	private static final String warrantyDurationUnit = "year";

	protected static String getWarrantyDurationUnit()
	{
		return warrantyDurationUnit;
	}

	public static COBIEType writeAssetTypesToCOBie(COBIEType cType,
			IfcModelInterface model)
	{
		LogHandler loggerHandler = new LogHandler(sheetName, LOGGER);
		loggerHandler.sheetWriteBegin();
		ArrayList<String> writtenTypes = new ArrayList<String>();
		COBIEType.Types cTypes = cType.addNewTypes();

		exportAssetTypeObjects(model, loggerHandler, writtenTypes, cTypes,
				warrantyDurationUnit);

		// May 24 2012...commented out...no longer exporting material layer sets...exportMaterialLayerTypes(model, loggerHandler, writtenTypes, cTypes,
				//warrantyDurationUnit);
		loggerHandler.sheetWritten();
		return cType;
	}

	public static void exportAssetTypeObjects(IfcModelInterface model,
			LogHandler loggerHandler, ArrayList<String> writtenTypes,
			COBIEType.Types cTypes, String warrantyDurationUnit)
	{
		String name;
		String category;
		String description;
		String extSystem;
		String extObj;
		String extIdentifier;
		String assetType;
		String manufacturer;
		String modelNumber;
		String warrantyGuarantorParts;
		String warrantyDurationParts;
		String warrantyGuarantorLabor;
		String warrantyDurationLabor;
		String replacementCost;
		String expectedLife;
		String warrantyDescription;
		String nominalLength;
		String nominalWidth;
		String nominalHeight;
		String modelReference;
		String shape;
		String size;
		String color;
		String finish;
		String grade;
		String material;
		String constituents;
		String features;
		String accessibilityPerformance;
		String codePerformance;
		String sustainabilityPerformance;
		String durationUnit = "";
		ArrayList<IfcRelDefinesByType> relTypes = IfcToType
				.getCandidateRelDefinesByTypes(model);
		for (IfcRelDefinesByType defByType : relTypes)
		{
			try
			{
				IfcTypeObject type = defByType.getRelatingType();
				if (type != null)
				{

					IfcOwnerHistory oh = type.getOwnerHistory();
					name = IfcToType.nameFromTypeObject(type);
					if (!writtenTypes.contains(name))
					{
						String createdBy = COBieUtility
								.getEmailFromOwnerHistory(oh);
						Calendar createdOn = IfcToContact.getCreatedOn(oh
								.getCreationDate());
						category = IfcToType
								.categoryFromRelDefinesByType(defByType);
						description = IfcToType.descriptionFromTypeObject(type);
						extSystem = COBieUtility.getApplicationName(oh);
						extObj = IfcToType.extObjectFromTypeObject(type);
						extIdentifier = COBieUtility
								.identifierFromObjectDefinition(type);
						durationUnit = IfcToType.durationUnitsFromTypeObject(type);
						assetType = IfcToType.assetTypeFromTypeObject(type);
						manufacturer = IfcToType
								.manufacturerFromTypeObject(type);
						modelNumber = IfcToType.modelNumberFromTypeObject(type);
						warrantyGuarantorParts = IfcToType
								.warrantyGuarantorPartsFromTypeObject(type);
						warrantyDurationParts = IfcToType
								.warrantyDurationPartsFromTypeObject(type);
						warrantyGuarantorLabor = IfcToType
								.warrantyGuarantorLaborFromTypeObject(type);
						warrantyDurationLabor = IfcToType
								.warrantyDurationLaborFromTypeObject(type);
						replacementCost = IfcToType
								.replacementCostFromTypeObject(type);
						expectedLife = IfcToType
								.expectedLifeFromTypeObject(type);
						warrantyDescription = IfcToType
								.warrantyDescriptionFromTypeObject(type);
						nominalLength = IfcToType
								.nominalLengthFromTypeObject(type);
						nominalWidth = IfcToType
								.nominalWidthFromTypeObject(type);
						nominalHeight = IfcToType
								.nominalHeightFromTypeObject(type);
						modelReference = IfcToType
								.modelReferenceFromTypeObject(type);
						shape = IfcToType.shapeFromTypeObject(type);
						size = IfcToType.sizeFromTypeObject(type);
						color = IfcToType.colorFromTypeObject(type);
						finish = IfcToType.finishFromTypeObject(type);
						grade = IfcToType.gradeFromTypeObject(type);
						material = IfcToType.materialFromTypeObject(type);
						constituents = IfcToType
								.constituentsStringFromTypeObject(type);
						features = IfcToType.featuresFromTypeObject(type);
						accessibilityPerformance = IfcToType
								.accessibilityPerformanceFromTypeObject(type);
						codePerformance = IfcToType
								.codePerformanceFromTypeObject(type);
						sustainabilityPerformance = IfcToType
								.sustainabilityPerformanceFromTypeObject(type);
						addNewType(writtenTypes, cTypes, name, category,
								description, extSystem, extObj, extIdentifier,
								assetType, manufacturer, modelNumber,
								warrantyGuarantorParts, warrantyDurationParts,
								warrantyGuarantorLabor, warrantyDurationLabor,
								warrantyDurationUnit, replacementCost,
								expectedLife, warrantyDescription,
								nominalLength, nominalWidth, nominalHeight,
								modelReference, shape, size, color, finish,
								grade, material, constituents, features,
								accessibilityPerformance, codePerformance,
								sustainabilityPerformance, createdBy, createdOn,durationUnit);
						loggerHandler.rowWritten();
						
					}
				}

			}
			catch (Exception ex)
			{
				loggerHandler.error(ex);
			}
			
			
		}
	}

	public static void exportMaterialLayerTypes(IfcModelInterface model,
			LogHandler loggerHandler, ArrayList<String> writtenTypes,
			COBIEType.Types cTypes, String warrantyDurationUnit)
	{
		String name;
		String category;
		String description;
		String extSystem;
		String extObj;
		String extIdentifier;
		String assetType;
		String manufacturer;
		String modelNumber;
		String warrantyGuarantorParts;
		String warrantyDurationParts;
		String warrantyGuarantorLabor;
		String warrantyDurationLabor;
		String replacementCost;
		String expectedLife;
		String warrantyDescription;
		String nominalLength;
		String nominalWidth;
		String nominalHeight;
		String modelReference;
		String shape;
		String size;
		String color;
		String finish;
		String grade;
		String material;
		String constituents;
		String features;
		String accessibilityPerformance;
		String codePerformance;
		String sustainabilityPerformance;
		for (IfcRelAssociatesMaterial assocMat : model
				.getAll(IfcRelAssociatesMaterial.class))
		{
			try
			{
				// IfcTypeObject type = assocMat.getRelatingType();
				IfcMaterialSelect matSel = IfcToType
						.getMaterialOrMaterialLayerSet(assocMat);
				if (matSel != null)
				{
					name = IfcToType.nameFromMaterialSelect(matSel);
					if (!writtenTypes.contains(name))
					{

						IfcOwnerHistory oh = assocMat.getOwnerHistory();
						String createdBy = COBieUtility
								.getEmailFromOwnerHistory(oh);
						Calendar createdOn = IfcToContact.getCreatedOn(oh
								.getCreationDate());
						category = COBieUtility.COBieNA;
						description = IfcToType
								.descriptionFromIfcMaterialSelect(matSel);
						extSystem = COBieUtility.getApplicationName(oh);
						extObj = IfcToType.extObjectFromMaterialSelect(matSel);
						extIdentifier = COBieUtility.COBieNA;

						assetType = IfcToType
								.assetTypeFromRelAssociatesMaterial(assocMat);
						manufacturer = IfcToType
								.manufacturerFromRelAssociatesMaterial(assocMat);
						modelNumber = IfcToType
								.modelNumberFromRelAssociatesMaterial(assocMat);
						warrantyGuarantorParts = IfcToType
								.warrantyGuarantorPartsFromRelAssociatesMaterial(assocMat);
						warrantyDurationParts = IfcToType
								.warrantyDurationPartsFromRelAssociatesMaterial(assocMat);
						warrantyGuarantorLabor = IfcToType
								.warrantyGuarantorLaborFromRelAssociatesMaterial(assocMat);
						warrantyDurationLabor = IfcToType
								.warrantyDurationLaborFromRelAssociatesMaterial(assocMat);
						replacementCost = IfcToType
								.replacementCostFromRelAssociatesMaterial(assocMat);
						expectedLife = IfcToType
								.expectedLifeFromRelAssociatesMaterial(assocMat);
						warrantyDescription = IfcToType
								.warrantyDescriptionFromRelAssociatesMaterial(assocMat);
						nominalLength = IfcToType
								.nominalLengthFromRelAssociatesMaterial(assocMat);
						nominalWidth = IfcToType
								.nominalWidthFromRelAssociatesMaterial(assocMat);
						nominalHeight = IfcToType
								.nominalHeightFromRelAssociatesMaterial(assocMat);
						modelReference = IfcToType
								.modelReferenceFromRelAssociatesMaterial(assocMat);
						shape = IfcToType
								.shapeFromRelAssociatesMaterial(assocMat);
						size = IfcToType
								.sizeFromRelAssociatesMaterial(assocMat);
						color = IfcToType
								.colorFromRelAssociatesMaterial(assocMat);
						finish = IfcToType
								.finishFromRelAssociatesMaterial(assocMat);
						grade = IfcToType
								.gradeFromRelAssociatesMaterial(assocMat);
						material = IfcToType
								.materialFromRelAssociatesMaterial(assocMat);
						constituents = IfcToType
								.constituentsStringFromRelAssociatesMaterial(assocMat);
						features = IfcToType
								.featuresFromRelAssociatesMaterial(assocMat);
						accessibilityPerformance = IfcToType
								.accessibilityPerformanceFromRelAssociatesMaterial(assocMat);
						codePerformance = IfcToType
								.codePerformanceFromRelAssociatesMaterial(assocMat);
						sustainabilityPerformance = IfcToType
								.sustainabilityPerformanceFromRelAssociatesMaterial(assocMat);
						TypeType newType = cTypes.addNewType();
						writtenTypes.add(name);
						newType.setName(name);
						newType.setCategory(category);
						newType.setCreatedBy(createdBy);
						newType.setCreatedOn(createdOn);
						newType.setDescription(description);
						newType.setExtSystem(extSystem);
						newType.setExtObject(extObj);
						newType.setExtIdentifier(extIdentifier);

						newType.setAssetType(assetType);
						newType.setManufacturer(manufacturer);
						newType.setModelNumber(modelNumber);
						newType.setWarrantyGuarantorParts(warrantyGuarantorParts);
						newType.setWarrantyDurationParts(warrantyDurationParts);
						newType.setWarrantyGuarantorLabor(warrantyGuarantorLabor);
						newType.setWarrantyDurationLabor(warrantyDurationLabor);
						newType.setReplacementCost(replacementCost);
						newType.setExpectedLife(expectedLife);
						newType.setWarrantyDurationUnit(warrantyDurationUnit);
						newType.setWarrantyDescription(warrantyDescription);
						newType.setNominalLength(nominalLength);
						newType.setNominalWidth(nominalWidth);
						newType.setNominalHeight(nominalHeight);
						newType.setModelReference(modelReference);
						newType.setShape(shape);
						newType.setSize(size);
						newType.setColor(color);
						newType.setFinish(finish);
						newType.setGrade(grade);
						newType.setMaterial(material);
						newType.setConstituents(constituents);
						newType.setFeatures(features);
						newType.setAccessibilityPerformance(accessibilityPerformance);
						newType.setCodePerformance(codePerformance);
						newType.setSustainabilityPerformance(sustainabilityPerformance);
						newType.setDurationUnit(warrantyDurationUnit);
						loggerHandler.rowWritten();
					}
				}
			}
			catch (Exception ex)
			{
				loggerHandler.error(ex);
			}

		}
	}

	public static COBIEType writeAllTypesToCOBie(COBIEType cType,
			IfcModelInterface model)
	{
		LogHandler loggerHandler = new LogHandler(sheetName, LOGGER);
		loggerHandler.sheetWriteBegin();
		ArrayList<String> writtenTypes = new ArrayList<String>();
		COBIEType.Types cTypes = cType.addNewTypes();
		String name;
		String category;
		String description;
		String extSystem;
		String extObj;
		String extIdentifier;

		String assetType;
		String manufacturer;
		String modelNumber;
		String warrantyGuarantorParts;
		String warrantyDurationParts;
		String warrantyGuarantorLabor;
		String warrantyDurationLabor;
		String warrantyDurationUnit;
		String replacementCost;
		String expectedLife;
		String warrantyDescription;
		String nominalLength;
		String nominalWidth;
		String nominalHeight;
		String modelReference;
		String shape;
		String size;
		String color;
		String finish;
		String grade;
		String material;
		String constituents;
		String features;
		String accessibilityPerformance;
		String codePerformance;
		String sustainabilityPerformance;
		String durationUnit="";
		
		for (IfcTypeObject type : model.getAllWithSubTypes(IfcTypeObject.class))
		{
			try
			{
				// IfcTypeObject type =
				// defByType.getRelatingType();
				
				IfcOwnerHistory oh = type.getOwnerHistory();
				if (type!=null)
				{
					name = IfcToType.nameFromTypeObject(type);
					if (!writtenTypes.contains(name)&& !isBAMieVirtualController(type))
					{

						
						String createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
						Calendar createdOn = IfcToContact.getCreatedOn(oh
								.getCreationDate());
						category = IfcToType.categoryFromTypeObject(type);
						description = IfcToType.descriptionFromTypeObject(type);
						extSystem = COBieUtility.getApplicationName(oh);
						extObj = IfcToType.extObjectFromTypeObject(type);
						extIdentifier = COBieUtility
								.identifierFromObjectDefinition(type);

						assetType = IfcToType.assetTypeFromTypeObject(type);
						manufacturer = IfcToType.manufacturerFromTypeObject(type);
						modelNumber = IfcToType.modelNumberFromTypeObject(type);
						warrantyGuarantorParts = IfcToType
								.warrantyGuarantorPartsFromTypeObject(type);
						warrantyDurationParts = IfcToType
								.warrantyDurationPartsFromTypeObject(type);
						warrantyGuarantorLabor = IfcToType
								.warrantyGuarantorLaborFromTypeObject(type);
						warrantyDurationLabor = IfcToType
								.warrantyDurationLaborFromTypeObject(type);
						warrantyDurationUnit =
								IfcToType.warrantyDurationUnitsFromTypeObject(type);
						replacementCost = IfcToType.replacementCostFromTypeObject(type);
						expectedLife = IfcToType.expectedLifeFromTypeObject(type);
						durationUnit = IfcToType.durationUnitsFromTypeObject(type);
						warrantyDescription = IfcToType
								.warrantyDescriptionFromTypeObject(type);
						nominalLength = IfcToType.nominalLengthFromTypeObject(type);
						nominalWidth = IfcToType.nominalWidthFromTypeObject(type);
						nominalHeight = IfcToType.nominalHeightFromTypeObject(type);
						modelReference = IfcToType.modelReferenceFromTypeObject(type);
						shape = IfcToType.shapeFromTypeObject(type);
						size = IfcToType.sizeFromTypeObject(type);
						color = IfcToType.colorFromTypeObject(type);
						finish = IfcToType.finishFromTypeObject(type);
						grade = IfcToType.gradeFromTypeObject(type);
						material = IfcToType.materialFromTypeObject(type);
						constituents = IfcToType.constituentsStringFromTypeObject(type);
						features = IfcToType.featuresFromTypeObject(type);
						accessibilityPerformance = IfcToType
								.accessibilityPerformanceFromTypeObject(type);
						codePerformance = IfcToType.codePerformanceFromTypeObject(type);
						sustainabilityPerformance = IfcToType
								.sustainabilityPerformanceFromTypeObject(type);
						addNewType(writtenTypes, cTypes, name, category,
								description, extSystem, extObj, extIdentifier,
								assetType, manufacturer, modelNumber,
								warrantyGuarantorParts, warrantyDurationParts,
								warrantyGuarantorLabor, warrantyDurationLabor,
								warrantyDurationUnit, replacementCost,
								expectedLife, warrantyDescription,
								nominalLength, nominalWidth, nominalHeight,
								modelReference, shape, size, color, finish,
								grade, material, constituents, features,
								accessibilityPerformance, codePerformance,
								sustainabilityPerformance, createdBy, createdOn,durationUnit);
						loggerHandler.rowWritten();
					}
				}
				
				
			}
			catch (Exception ex)
			{
				loggerHandler.error(ex);
			}
		}
		loggerHandler.sheetWritten();
		return cType;
	}

	private static boolean isBAMieVirtualController(IfcTypeObject type)
	{
		return (type instanceof IfcControllerType && type.getName().startsWith(ConnectionDeserializer.VIRTUAL_CONTROLLER_TYPE_PREFIX));
	}

	public static void addNewType(ArrayList<String> writtenTypes,
			COBIEType.Types cTypes, String name, String category,
			String description, String extSystem, String extObj,
			String extIdentifier, String assetType, String manufacturer,
			String modelNumber, String warrantyGuarantorParts,
			String warrantyDurationParts, String warrantyGuarantorLabor,
			String warrantyDurationLabor, String warrantyDurationUnit,
			String replacementCost, String expectedLife,
			String warrantyDescription, String nominalLength,
			String nominalWidth, String nominalHeight, String modelReference,
			String shape, String size, String color, String finish,
			String grade, String material, String constituents,
			String features, String accessibilityPerformance,
			String codePerformance, String sustainabilityPerformance,
			String createdBy, Calendar createdOn,String durationUnit)
	{
		TypeType newType = cTypes.addNewType();
		newType.setName(name);
		newType.setCategory(category);
		newType.setCreatedBy(createdBy);
		newType.setCreatedOn(createdOn);
		newType.setDescription(description);
		newType.setExtSystem(extSystem);
		newType.setExtObject(extObj);
		newType.setExtIdentifier(extIdentifier);

		newType.setAssetType(assetType);
		newType.setManufacturer(manufacturer);
		newType.setModelNumber(modelNumber);
		newType.setWarrantyGuarantorParts(warrantyGuarantorParts);
		newType.setWarrantyDurationParts(warrantyDurationParts);
		newType.setWarrantyGuarantorLabor(warrantyGuarantorLabor);
		newType.setWarrantyDurationLabor(warrantyDurationLabor);
		newType.setReplacementCost(replacementCost);
		newType.setExpectedLife(expectedLife);
		newType.setWarrantyDurationUnit(warrantyDurationUnit);
		newType.setWarrantyDescription(warrantyDescription);
		newType.setNominalLength(nominalLength);
		newType.setNominalWidth(nominalWidth);
		newType.setNominalHeight(nominalHeight);
		newType.setModelReference(modelReference);
		newType.setShape(shape);
		newType.setSize(size);
		newType.setColor(color);
		newType.setFinish(finish);
		newType.setGrade(grade);
		newType.setMaterial(material);
		newType.setConstituents(constituents);
		newType.setFeatures(features);
		newType.setAccessibilityPerformance(accessibilityPerformance);
		newType.setCodePerformance(codePerformance);
		newType.setSustainabilityPerformance(sustainabilityPerformance);
		newType.setDurationUnit(durationUnit);
		writtenTypes.add(name);
	}
	

	public static ArrayList<IfcRelDefinesByType> getCandidateRelDefinesByTypes(
			IfcModelInterface model)
	{
		String name;
		ArrayList<String> selectedTypes = new ArrayList<String>();
		ArrayList<IfcRelDefinesByType> relTypes = new ArrayList<IfcRelDefinesByType>();
		for (IfcRelDefinesByType defByType : model
				.getAll(IfcRelDefinesByType.class))
		{
			try
			{
				IfcTypeObject type = defByType.getRelatingType();
				name = IfcToType.nameFromTypeObject(type);
				if ( !selectedTypes.contains(name))
				{
					if(!isBAMieVirtualControllerTypeDefinition(defByType))
						relTypes.add(defByType);
				}
			}
			catch(Exception e)
			{
				
			}
		}
		return relTypes;
	}

	private static boolean isBAMieVirtualControllerTypeDefinition(
			IfcRelDefinesByType defByType)
	{
		return (defByType.getName().startsWith(ConnectionDeserializer.BAMIE_VIRTUAL_CONTROLLER_TYPE_RELATION_PREFIX));
	}

	protected static boolean isAsset(IfcObjectDefinition objDef)
	{

		boolean isAsset = true;
		ArrayList<String> excludeStrings = getExcludeAssetStrings();
		for (@SuppressWarnings("rawtypes") Class iClass : objDef.getClass().getInterfaces())
		{
			if (excludeStrings.contains(iClass.getSimpleName()))
				isAsset = false;
		}
		return isAsset;
	}

	protected static boolean isAsset(IfcRelAssociatesMaterial mat)
	{

		boolean isAsset = true;
		IfcMaterialSelect matSel = getMaterialOrMaterialLayerSet(mat);
		if (matSel != null)
		{
			ArrayList<String> excludeStrings = getExcludeAssetStrings();
			for (@SuppressWarnings("rawtypes") Class iClass : matSel.getClass().getInterfaces())
			{
				if (excludeStrings.contains(iClass.getSimpleName()))
					isAsset = false;
			}
		}
		return isAsset;
	}

	protected static IfcMaterialSelect getMaterialOrMaterialLayerSet(
			IfcRelAssociatesMaterial matAssoc)
	{
		IfcMaterialSelect returnSel = null;
		IfcMaterialSelect matSel = matAssoc.getRelatingMaterial();
		if (matSel instanceof IfcMaterialLayerSet
				|| matSel instanceof IfcMaterial)
			returnSel = matSel;
		if (matSel instanceof IfcMaterialLayerSetUsage)
		{
			IfcMaterialLayerSetUsage usg = (IfcMaterialLayerSetUsage) matSel;
			returnSel = usg.getForLayerSet();
		}
		return returnSel;
	}

	protected static String extObjectFromTypeObject(IfcTypeObject type)
	{
		String className = type.getClass().getSimpleName();
		className = COBieUtility.trimImplFromClassNameString(className);
		return className;
	}

	protected static String extObjectFromMaterialSelect(
			IfcMaterialSelect materialSelect)
	{
		String className = materialSelect.getClass().getSimpleName();
		className = COBieUtility.trimImplFromClassNameString(className);
		return className;
	}

	protected static String nameFromTypeObject(IfcTypeObject type)
	{
		String name = "";
		name = type.getName();
		return COBieUtility.getCOBieString(name);
	}

	protected static String nameFromMaterialSelect(
			IfcMaterialSelect materialSelect)
	{
		String name = "";
		if (materialSelect != null)
		{
			if (materialSelect instanceof IfcMaterial)
			{
				IfcMaterial material = (IfcMaterial) materialSelect;
				name = material.getName();
			}
			else if (materialSelect instanceof IfcMaterialLayerSet)
			{
				IfcMaterialLayerSet materialLayer = (IfcMaterialLayerSet) materialSelect;
				name = materialLayer.getLayerSetName();
			}
		}

		return COBieUtility.getCOBieString(name);
	}

	protected static String categoryFromRelDefinesByType(
			IfcRelDefinesByType type)
	{
		String category = "";
		category = COBieUtility.getRelDefinesByTypeClassification(type);
		return COBieUtility.getCOBieString(category);
	}

	public static String categoryFromTypeObject(IfcTypeObject type)
	{
		String category = "";
		category = COBieUtility.getObjectClassificationCategoryString(type);
		return COBieUtility.getCOBieString(category);
	}

	protected static String descriptionFromTypeObject(IfcTypeObject type)
	{
		String description = "";
		description = type.getDescription();
		if (description == null || description.isEmpty())
			description = type.getName();
		return COBieUtility.getCOBieString(description);
	}

	protected static String descriptionFromIfcMaterialSelect(
			IfcMaterialSelect materialSelect)
	{
		String description = "";
		if (materialSelect instanceof IfcMaterial)
		{
			IfcMaterial material = (IfcMaterial) materialSelect;
			description = material.getName();
		}
		else if (materialSelect instanceof IfcMaterialLayerSet)
		{
			IfcMaterialLayerSet layerSet = (IfcMaterialLayerSet) materialSelect;
			description = layerSet.getLayerSetName();
		}
		return description;
	}

	protected static String assetTypeFromTypeObject(IfcTypeObject type)
	{
		String assetType = "";
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> assetTypePNames = getAssetTypeStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				assetTypePNames);
		assetType = COBieUtility.cobieStringFromStringMap(valMap,
				assetTypePNames);

		if (assetType.toLowerCase().trim().equals(MOVEABLE_ASSET_TYPE_LCASE)
				|| assetType.toLowerCase().trim().equals(NONFIXED_ASSET_TYPE_LCASE))
			assetType = MOVEABLE_ASSET_TYPE_CAMELCASE;
		else if (assetType.toLowerCase().trim().equals("fixed"))
			assetType = FIXED_ASSET_TYPE_CAMELCASE;

		if (type instanceof IfcFurnitureType && assetType.isEmpty())
		{
			assetType = MOVEABLE_ASSET_TYPE_CAMELCASE;
		}

		return COBieUtility.getCOBieString(assetType);
	}

	protected static String manufacturerFromTypeObject(IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getManufacturerStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String modelNumberFromTypeObject(IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getModelNumberStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String warrantyGuarantorPartsFromTypeObject(
			IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType
				.getWarrantyGuarantorPartsStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String warrantyDurationPartsFromTypeObject(
			IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType
				.getWarrantyDurationPartsStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String warrantyGuarantorLaborFromTypeObject(
			IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType
				.getWarrantyGuarantorLaborStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String warrantyDurationLaborFromTypeObject(
			IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType
				.getWarrantyDurationLaborStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}
	
	protected static String warrantyDurationUnitsFromTypeObject(
			IfcTypeObject type)
	{
		IfcPropertyToCOBieString pString;
		String durationUnit = "";
		Map<String, IfcPropertyToCOBieString> valMap = new HashMap<String, IfcPropertyToCOBieString>();
		ArrayList<String> typePNames = IfcToType
				.getWarrantyDurationLaborStrings();
		valMap = IfcRelationshipsToCOBie.psetStringsFromTypeObject(type,
				typePNames,false);
		pString = COBieUtility.cobiePsetStringFromStringMap(valMap, typePNames);
		if(pString==null)
		{
			typePNames = IfcToType.getWarrantyDurationPartsStrings();
			valMap = IfcRelationshipsToCOBie.psetStringsFromTypeObject(type, typePNames,false);
			pString = COBieUtility.cobiePsetStringFromStringMapAllowNA(valMap, typePNames);
		}
		if(pString!=null && 
				pString instanceof IfcSingleValueToCOBieString)
		{
			durationUnit= ((IfcSingleValueToCOBieString)pString).getUnitString();
		}
		return COBieUtility.getCOBieString(durationUnit);
	}

	protected static String replacementCostFromTypeObject(IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getReplacementCostStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String expectedLifeFromTypeObject(IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getExpectedLifeStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}
	
	protected static String durationUnitsFromTypeObject(
			IfcTypeObject type)
	{
		IfcPropertyToCOBieString pString;
		String durationUnit = "";
		Map<String, IfcPropertyToCOBieString> valMap = new HashMap<String, IfcPropertyToCOBieString>();
		ArrayList<String> typePNames = IfcToType
				.getExpectedLifeStrings();
		valMap = IfcRelationshipsToCOBie.psetStringsFromTypeObject(type,
				typePNames,false);
		pString = COBieUtility.cobiePsetStringFromStringMapAllowNA(valMap, typePNames);
		if(pString!=null && 
				pString instanceof IfcSingleValueToCOBieString)
		{
			durationUnit= ((IfcSingleValueToCOBieString)pString).getUnitString();
		}
		return COBieUtility.getCOBieString(durationUnit);
	}

	protected static String warrantyDescriptionFromTypeObject(IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType
				.getWarrantyDescriptionStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String nominalLengthFromTypeObject(IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getNominalLengthStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String nominalWidthFromTypeObject(IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getNominalWidthStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String nominalHeightFromTypeObject(IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getNominalHeightStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String modelReferenceFromTypeObject(IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getModelReferenceStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String shapeFromTypeObject(IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getShapeStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String sizeFromTypeObject(IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getSizeStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String colorFromTypeObject(IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getColorStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String finishFromTypeObject(IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getFinishStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String gradeFromTypeObject(IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getGradeStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String materialFromTypeObject(IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getMaterialStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String constituentsStringFromTypeObject(IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getConstituentsString();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String featuresFromTypeObject(IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getFeaturesStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String accessibilityPerformanceFromTypeObject(
			IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType
				.getAccessibilityPerformanceStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String codePerformanceFromTypeObject(IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getCodePerformanceStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String sustainabilityPerformanceFromTypeObject(
			IfcTypeObject type)
	{
		String pString;

		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType
				.getSustainabilityPerformanceStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(type,
				typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap, typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String assetTypeFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getAssetTypeStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		if (pString.toLowerCase().trim().equals(MOVEABLE_ASSET_TYPE_LCASE)
				|| pString.toLowerCase().trim().equals(NONFIXED_ASSET_TYPE_LCASE))
			pString = MOVEABLE_ASSET_TYPE_CAMELCASE;
		else if (pString.toLowerCase().trim().equals("fixed"))
			pString = FIXED_ASSET_TYPE_CAMELCASE;
		return COBieUtility.getCOBieString(pString);
	}

	protected static String manufacturerFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getManufacturerStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap,typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String modelNumberFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getModelNumberStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap,typePNames);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String warrantyGuarantorPartsFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType
				.getWarrantyGuarantorPartsStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String warrantyDurationPartsFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType
				.getWarrantyDurationPartsStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String warrantyGuarantorLaborFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType
				.getWarrantyGuarantorLaborStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String warrantyDurationLaborFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType
				.getWarrantyDurationLaborStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String replacementCostFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getReplacementCostStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String expectedLifeFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getExpectedLifeStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String warrantyDescriptionFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType
				.getWarrantyDescriptionStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String nominalLengthFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getNominalLengthStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String nominalWidthFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getNominalWidthStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String nominalHeightFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getNominalHeightStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String modelReferenceFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getModelReferenceStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String shapeFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getShapeStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String sizeFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getSizeStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String colorFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getColorStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String finishFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getFinishStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String gradeFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getGradeStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String materialFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getMaterialStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String constituentsStringFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getConstituentsString();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String featuresFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getFeaturesStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String accessibilityPerformanceFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType
				.getAccessibilityPerformanceStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String codePerformanceFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType.getCodePerformanceStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static String sustainabilityPerformanceFromRelAssociatesMaterial(
			IfcRelAssociatesMaterial rel)
	{
		String pString;
		Map<String, String> valMap = new HashMap<String, String>();
		ArrayList<String> typePNames = IfcToType
				.getSustainabilityPerformanceStrings();
		valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(
				rel, typePNames);
		pString = COBieUtility.cobieStringFromStringMap(valMap);
		return COBieUtility.getCOBieString(pString);
	}

	protected static ArrayList<String> getExcludeAssetStrings()
	{
		return excludeAssetStrings;
	}

	private static ArrayList<String> getAssetTypeStrings()
	{
		return assetTypeStrings;
	}

	private static ArrayList<String> getManufacturerStrings()
	{
		return manufacturerStrings;
	}

	private static ArrayList<String> getModelNumberStrings()
	{
		return modelNumberStrings;
	}

	private static ArrayList<String> getWarrantyGuarantorPartsStrings()
	{
		return warrantyGuarantorPartsStrings;
	}

	private static ArrayList<String> getWarrantyDurationPartsStrings()
	{
		return warrantyDurationPartsStrings;
	}

	private static ArrayList<String> getWarrantyGuarantorLaborStrings()
	{
		return warrantyGuarantorLaborStrings;
	}

	private static ArrayList<String> getWarrantyDurationLaborStrings()
	{
		return warrantyDurationLaborStrings;
	}

	private static ArrayList<String> getReplacementCostStrings()
	{
		return replacementCostStrings;
	}

	private static ArrayList<String> getExpectedLifeStrings()
	{
		return expectedLifeStrings;
	}

	private static ArrayList<String> getWarrantyDescriptionStrings()
	{
		return warrantyDescriptionStrings;
	}

	private static ArrayList<String> getNominalLengthStrings()
	{
		return nominalLengthStrings;
	}

	private static ArrayList<String> getNominalWidthStrings()
	{
		return nominalWidthStrings;
	}

	private static ArrayList<String> getNominalHeightStrings()
	{
		return nominalHeightStrings;
	}

	private static ArrayList<String> getModelReferenceStrings()
	{
		return modelReferenceStrings;
	}

	private static ArrayList<String> getShapeStrings()
	{
		return shapeStrings;
	}

	private static ArrayList<String> getSizeStrings()
	{
		return sizeStrings;
	}

	private static ArrayList<String> getColorStrings()
	{
		return colorStrings;
	}

	private static ArrayList<String> getFinishStrings()
	{
		return finishStrings;
	}

	private static ArrayList<String> getGradeStrings()
	{
		return gradeStrings;
	}

	private static ArrayList<String> getMaterialStrings()
	{
		return materialStrings;
	}

	private static ArrayList<String> getConstituentsString()
	{
		return constituentsString;
	}

	private static ArrayList<String> getFeaturesStrings()
	{
		return featuresStrings;
	}

	private static ArrayList<String> getAccessibilityPerformanceStrings()
	{
		return accessibilityPerformanceStrings;
	}

	private static ArrayList<String> getCodePerformanceStrings()
	{
		return codePerformanceStrings;
	}

	private static ArrayList<String> getSustainabilityPerformanceStrings()
	{
		return sustainabilityPerformanceStrings;
	}
	
	

}
