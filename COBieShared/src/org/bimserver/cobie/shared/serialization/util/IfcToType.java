package org.bimserver.cobie.shared.serialization.util;

/******************************************************************************

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

import org.bimserver.cobie.shared.deserialization.cobietab.ConnectionDeserializer;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.ifc.IfcRelationshipsToCOBie;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcFurnitureType;
import org.bimserver.models.ifc2x3tc1.IfcMaterial;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSetUsage;
import org.bimserver.models.ifc2x3tc1.IfcMaterialSelect;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesMaterial;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.TypeType;

public class IfcToType
{
    private static final String FIXED_ASSET_TYPE_CAMELCASE = "Fixed";
    private static final String MOVEABLE_ASSET_TYPE_CAMELCASE = "Moveable";
    private static final String NONFIXED_ASSET_TYPE_LCASE = "nonfixed";
    private static final String MOVEABLE_ASSET_TYPE_LCASE = "moveable";
    private static final ArrayList<String> excludeAssetStrings = new ArrayList<String>(Arrays.asList("IfcBeamType", "IfcMaterial",
            "IfcMaterialLayerSet", "IfcCableCarrierSegmentType", "IfcCableSegmentType", "IfcColumnType", "IfcCurtainWallType", "IfcDuctFittingType",
            "IfcDuctSegmentType", "IfcFastenerType", "IfcJunctionBoxType", "IfcMemberType", "IfcPipeFittingType", "IfcPipeSegmentType",
            "IfcPlateType", "IfcRailingType", "IfcRampFlightType", "IfcRampType", "IfcSlabType", "IfcSpaceType", "IfcStairFlightType",
            "IfcStairType", "IfcWallType", "IfcTypeObject", "IfcTypeProduct", "IfcElementType"));

    private static final ArrayList<String> assetTypeStrings = new ArrayList<String>(Arrays.asList("AssetType", "AssetAccountingType"));
    private static final ArrayList<String> manufacturerStrings = new ArrayList<String>(Arrays.asList("Manufacturer"));
    private static final ArrayList<String> modelNumberStrings = new ArrayList<String>(Arrays.asList("ModelNumber", "ArticleNumber", "ModelLabel"));
    private static final ArrayList<String> warrantyGuarantorPartsStrings = new ArrayList<String>(Arrays.asList("WarrantyGuarantorParts",
            "PointOfContact"));
    private static final ArrayList<String> warrantyDurationPartsStrings = new ArrayList<String>(Arrays.asList("WarrantyDurationParts",
            "WarrantyPeriod"));
    private static final ArrayList<String> warrantyGuarantorLaborStrings = new ArrayList<String>(Arrays.asList("WarrantyGuarantorLabor",
            "PointOfContact"));
    private static final ArrayList<String> warrantyDurationLaborStrings = new ArrayList<String>(Arrays.asList("WarrantyDurationLabor",
            "WarrantyPeriod"));
    private static final ArrayList<String> replacementCostStrings = new ArrayList<String>(Arrays.asList("ReplacementCost", "Replacement Cost",
            "Cost", "Replacement"));
    private static final ArrayList<String> expectedLifeStrings = new ArrayList<String>(Arrays.asList("ExpectedLife", "Expected Life",
            "ServiceLifeDuration", "Expected"));
    private static final ArrayList<String> warrantyDescriptionStrings = new ArrayList<String>(Arrays.asList("WarrantyDescription",
            "WarrantyIdentifier"));
    private static final ArrayList<String> nominalLengthStrings = new ArrayList<String>(Arrays.asList("NominalLength", "OverallLength"));
    private static final ArrayList<String> nominalWidthStrings = new ArrayList<String>(Arrays.asList("NominalWidth", "Width"));
    private static final ArrayList<String> nominalHeightStrings = new ArrayList<String>(Arrays.asList("NominalHeight", "Heght"));
    private static final ArrayList<String> modelReferenceStrings = new ArrayList<String>(Arrays.asList("ModelReference", "Reference"));
    private static final ArrayList<String> shapeStrings = new ArrayList<String>(Arrays.asList("Shape"));
    private static final ArrayList<String> sizeStrings = new ArrayList<String>(Arrays.asList("Size"));
    private static final ArrayList<String> colorStrings = new ArrayList<String>(Arrays.asList("Color", "Colour"));
    private static final ArrayList<String> finishStrings = new ArrayList<String>(Arrays.asList("Finish"));
    private static final ArrayList<String> gradeStrings = new ArrayList<String>(Arrays.asList("Grade"));
    private static final ArrayList<String> materialStrings = new ArrayList<String>(Arrays.asList("Material"));
    private static final ArrayList<String> constituentsString = new ArrayList<String>(Arrays.asList("Constituents", "Parts"));
    private static final ArrayList<String> featuresStrings = new ArrayList<String>(Arrays.asList("Features"));
    private static final ArrayList<String> accessibilityPerformanceStrings = new ArrayList<String>(
            Arrays.asList("AccessibilityPerformance", "Access"));
    private static final ArrayList<String> codePerformanceStrings = new ArrayList<String>(Arrays.asList("CodePerformance", "Regulation"));
    private static final ArrayList<String> sustainabilityPerformanceStrings = new ArrayList<String>(Arrays.asList("SustainabilityPerformance",
            "Environmental"));
    private static final String warrantyDurationUnit = "year";

    protected static String accessibilityPerformanceFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getAccessibilityPerformanceStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    public static void addNewType(
            ArrayList<String> writtenTypes,
            COBIEType.Types cTypes,
            String name,
            String category,
            String description,
            String extSystem,
            String extObj,
            String extIdentifier,
            String assetType,
            String manufacturer,
            String modelNumber,
            String warrantyGuarantorParts,
            String warrantyDurationParts,
            String warrantyGuarantorLabor,
            String warrantyDurationLabor,
            String warrantyDurationUnit,
            String replacementCost,
            String expectedLife,
            String warrantyDescription,
            String nominalLength,
            String nominalWidth,
            String nominalHeight,
            String modelReference,
            String shape,
            String size,
            String color,
            String finish,
            String grade,
            String material,
            String constituents,
            String features,
            String accessibilityPerformance,
            String codePerformance,
            String sustainabilityPerformance,
            String createdBy,
            Calendar createdOn,
            String durationUnit)
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

    protected static String assetTypeFromTypeObject(IfcTypeObject type)
    {
        String assetType = "";
        new HashMap<String, String>();
        ArrayList<String> assetTypePNames = getAssetTypeStrings();
        assetType = getTypePropertySearchResult(type, assetTypePNames);
        if (assetType.toLowerCase().trim().equals(MOVEABLE_ASSET_TYPE_LCASE) || assetType.toLowerCase().trim().equals(NONFIXED_ASSET_TYPE_LCASE))
        {
            assetType = MOVEABLE_ASSET_TYPE_CAMELCASE;
        } else if (assetType.toLowerCase().trim().equals("fixed"))
        {
            assetType = FIXED_ASSET_TYPE_CAMELCASE;
        }

        if ((type instanceof IfcFurnitureType) && assetType.isEmpty())
        {
            assetType = MOVEABLE_ASSET_TYPE_CAMELCASE;
        }

        return COBieUtility.getCOBieString(assetType);
    }

    protected static String categoryFromRelDefinesByType(IfcRelDefinesByType type)
    {
        String category = "";
        category = COBieIfcUtility.getRelDefinesByTypeClassification(type);
        return COBieUtility.getCOBieString(category);
    }

    public static String categoryFromTypeObject(IfcTypeObject type)
    {
        String category = "";
        category = COBieIfcUtility.getObjectClassificationCategoryString(type);
        return COBieUtility.getCOBieString(category);
    }

    protected static String codePerformanceFromRelAssociatesMaterial(IfcRelAssociatesMaterial rel)
    {
        String pString;
        Map<String, String> valMap = new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getCodePerformanceStrings();
        valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(rel, typePNames);
        pString = COBieUtility.cobieStringFromStringMap(valMap);
        return COBieUtility.getCOBieString(pString);
    }

    protected static String codePerformanceFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getCodePerformanceStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected static String colorFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getColorStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected static String constituentsStringFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getConstituentsString();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected static String descriptionFromTypeObject(IfcTypeObject type)
    {
        String description = "";
        description = type.getDescription();
        if ((description == null) || description.isEmpty())
        {
            description = type.getName();
        }
        return COBieUtility.getCOBieString(description);
    }

    protected static String durationUnitsFromTypeObject(IfcTypeObject type, IfcModelInterface model)
    {
        IfcPropertyToCOBieString propertyCOBieString;
        String durationUnit = "";
        Map<String, IfcPropertyToCOBieString> valMap = new HashMap<String, IfcPropertyToCOBieString>();
        ArrayList<String> expectedLifePropertyStrings = IfcToType.getExpectedLifeStrings();
        valMap = IfcRelationshipsToCOBie.psetStringsFromTypeObject(type, expectedLifePropertyStrings, false);
        propertyCOBieString = COBieIfcUtility.cobiePsetStringFromStringMapAllowNA(valMap, expectedLifePropertyStrings);
        if ((propertyCOBieString != null) && (propertyCOBieString instanceof IfcSingleValueToCOBieString))
        {
            durationUnit = ((IfcSingleValueToCOBieString)propertyCOBieString).getUnitString();
        }
        if (COBieUtility.isNA(durationUnit))
        {
            durationUnit = COBieIfcUtility.getFirstNamedUnitStringInProjectContext(model, IfcUnitEnum.TIMEUNIT);
        }
        return COBieUtility.getCOBieString(durationUnit);
    }

    protected static String expectedLifeFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getExpectedLifeStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected static String extObjectFromTypeObject(IfcTypeObject type)
    {
        String className = type.getClass().getSimpleName();
        className = COBieUtility.trimImplFromClassNameString(className);
        return className;
    }

    protected static String featuresFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getFeaturesStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected static String finishFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getFinishStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    private static ArrayList<String> getAccessibilityPerformanceStrings()
    {
        return accessibilityPerformanceStrings;
    }

    private static ArrayList<String> getAssetTypeStrings()
    {
        return assetTypeStrings;
    }

    public static ArrayList<IfcRelDefinesByType> getCandidateRelDefinesByTypes(IfcModelInterface model)
    {
        String name;
        ArrayList<String> selectedTypes = new ArrayList<String>();
        ArrayList<IfcRelDefinesByType> relTypes = new ArrayList<IfcRelDefinesByType>();
        for (IfcRelDefinesByType defByType : model.getAll(IfcRelDefinesByType.class))
        {
            try
            {
                IfcTypeObject type = defByType.getRelatingType();
                name = IfcToType.nameFromTypeObject(type);
                if (!selectedTypes.contains(name))
                {
                    if (!isBAMieVirtualControllerTypeDefinition(defByType))
                    {
                        relTypes.add(defByType);
                    }
                }
            } catch (Exception e)
            {
            }
        }
        return relTypes;
    }

    private static ArrayList<String> getCodePerformanceStrings()
    {
        return codePerformanceStrings;
    }

    private static ArrayList<String> getColorStrings()
    {
        return colorStrings;
    }

    private static ArrayList<String> getConstituentsString()
    {
        return constituentsString;
    }

    protected static ArrayList<String> getExcludeAssetStrings()
    {
        return excludeAssetStrings;
    }

    private static ArrayList<String> getExpectedLifeStrings()
    {
        return expectedLifeStrings;
    }

    private static ArrayList<String> getFeaturesStrings()
    {
        return featuresStrings;
    }

    private static ArrayList<String> getFinishStrings()
    {
        return finishStrings;
    }

    private static ArrayList<String> getGradeStrings()
    {
        return gradeStrings;
    }

    private static ArrayList<String> getManufacturerStrings()
    {
        return manufacturerStrings;
    }

    protected static IfcMaterialSelect getMaterialOrMaterialLayerSet(IfcRelAssociatesMaterial matAssoc)
    {
        IfcMaterialSelect returnSel = null;
        IfcMaterialSelect matSel = matAssoc.getRelatingMaterial();
        if ((matSel instanceof IfcMaterialLayerSet) || (matSel instanceof IfcMaterial))
        {
            returnSel = matSel;
        }
        if (matSel instanceof IfcMaterialLayerSetUsage)
        {
            IfcMaterialLayerSetUsage usg = (IfcMaterialLayerSetUsage)matSel;
            returnSel = usg.getForLayerSet();
        }
        return returnSel;
    }

    private static ArrayList<String> getMaterialStrings()
    {
        return materialStrings;
    }

    private static ArrayList<String> getModelNumberStrings()
    {
        return modelNumberStrings;
    }

    private static ArrayList<String> getModelReferenceStrings()
    {
        return modelReferenceStrings;
    }

    private static ArrayList<String> getNominalHeightStrings()
    {
        return nominalHeightStrings;
    }

    private static ArrayList<String> getNominalLengthStrings()
    {
        return nominalLengthStrings;
    }

    private static ArrayList<String> getNominalWidthStrings()
    {
        return nominalWidthStrings;
    }

    private static ArrayList<String> getReplacementCostStrings()
    {
        return replacementCostStrings;
    }

    private static ArrayList<String> getShapeStrings()
    {
        return shapeStrings;
    }

    private static ArrayList<String> getSizeStrings()
    {
        return sizeStrings;
    }

    private static ArrayList<String> getSustainabilityPerformanceStrings()
    {
        return sustainabilityPerformanceStrings;
    }

    private static String getTypePropertySearchResult(IfcTypeObject type, ArrayList<String> typePNames)
    {
        return IfcRelationshipsToCOBie.getHighestRankingPropertyStringFromPropertySets(type.getHasPropertySets(), typePNames);
    }

    private static ArrayList<String> getWarrantyDescriptionStrings()
    {
        return warrantyDescriptionStrings;
    }

    private static ArrayList<String> getWarrantyDurationLaborStrings()
    {
        return warrantyDurationLaborStrings;
    }

    private static ArrayList<String> getWarrantyDurationPartsStrings()
    {
        return warrantyDurationPartsStrings;
    }

    protected static String getWarrantyDurationUnit()
    {
        return warrantyDurationUnit;
    }

    private static ArrayList<String> getWarrantyGuarantorLaborStrings()
    {
        return warrantyGuarantorLaborStrings;
    }

    private static ArrayList<String> getWarrantyGuarantorPartsStrings()
    {
        return warrantyGuarantorPartsStrings;
    }

    protected static String gradeFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getGradeStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    private static boolean isBAMieVirtualControllerTypeDefinition(IfcRelDefinesByType defByType)
    {
        boolean isBAMie = false;
        if (defByType.isSetName() && !COBieUtility.isNA(defByType.getName()))
        {
            isBAMie = (defByType.getName().startsWith(ConnectionDeserializer.BAMIE_VIRTUAL_CONTROLLER_TYPE_RELATION_PREFIX));
        }
        return isBAMie;
    }

    protected static String manufacturerFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getManufacturerStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected static String materialFromRelAssociatesMaterial(IfcRelAssociatesMaterial rel)
    {
        String pString;
        Map<String, String> valMap = new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getMaterialStrings();
        valMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(rel, typePNames);
        pString = COBieUtility.cobieStringFromStringMap(valMap);
        return COBieUtility.getCOBieString(pString);
    }

    protected static String materialFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getMaterialStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected static String modelNumberFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getModelNumberStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected static String modelReferenceFromTypeObject(IfcTypeObject type)
    {
        String pString;

        ArrayList<String> typePNames = IfcToType.getModelReferenceStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected static String nameFromMaterialSelect(IfcMaterialSelect materialSelect)
    {
        String name = "";
        if (materialSelect != null)
        {
            if (materialSelect instanceof IfcMaterial)
            {
                IfcMaterial material = (IfcMaterial)materialSelect;
                name = material.getName();
            } else if (materialSelect instanceof IfcMaterialLayerSet)
            {
                IfcMaterialLayerSet materialLayer = (IfcMaterialLayerSet)materialSelect;
                name = materialLayer.getLayerSetName();
            }
        }

        return COBieUtility.getCOBieString(name);
    }

    protected static String nameFromTypeObject(IfcTypeObject type)
    {
        String name = "";
        if (type.isSetName() && !COBieUtility.isNA(type.getName()))
        {
            name = type.getName();
        }
        return COBieUtility.getCOBieString(name);
    }

    protected static String nominalHeightFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getNominalHeightStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected static String nominalLengthFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getNominalLengthStrings();
        pString = getTypePropertySearchResult(type, typePNames);
        return COBieUtility.getCOBieString(pString);
    }

    protected static String nominalWidthFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getNominalWidthStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected static String replacementCostFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getReplacementCostStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected static String shapeFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getShapeStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected static String sizeFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getSizeStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected static String sustainabilityPerformanceFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getSustainabilityPerformanceStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected static String warrantyDescriptionFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getWarrantyDescriptionStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected static String warrantyDurationLaborFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getWarrantyDurationLaborStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected static String warrantyDurationPartsFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getWarrantyDurationPartsStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected static String warrantyDurationUnitsFromTypeObject(IfcTypeObject type, IfcModelInterface model)
    {
        IfcPropertyToCOBieString pString;
        String durationUnit = "";
        Map<String, IfcPropertyToCOBieString> valMap = new HashMap<String, IfcPropertyToCOBieString>();
        ArrayList<String> typePNames = IfcToType.getWarrantyDurationLaborStrings();
        valMap = IfcRelationshipsToCOBie.psetStringsFromTypeObject(type, typePNames, false);
        pString = COBieIfcUtility.cobiePsetStringFromStringMap(valMap, typePNames);
        if (pString == null)
        {
            typePNames = IfcToType.getWarrantyDurationPartsStrings();
            valMap = IfcRelationshipsToCOBie.psetStringsFromTypeObject(type, typePNames, false);
            pString = COBieIfcUtility.cobiePsetStringFromStringMapAllowNA(valMap, typePNames);
        }
        if ((pString != null) && (pString instanceof IfcSingleValueToCOBieString))
        {
            durationUnit = ((IfcSingleValueToCOBieString)pString).getUnitString();
        }
        if (COBieUtility.isNA(durationUnit))
        {
            durationUnit = COBieIfcUtility.getFirstNamedUnitStringInProjectContext(model, IfcUnitEnum.TIMEUNIT);
        }
        return COBieUtility.getCOBieString(durationUnit);
    }

    protected static String warrantyGuarantorLaborFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getWarrantyGuarantorLaborStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected static String warrantyGuarantorPartsFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToType.getWarrantyGuarantorPartsStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }
    
    protected static boolean isAssetType(IfcObjectDefinition objDef)
    {

        boolean isAsset = true;
        ArrayList<String> excludeStrings = getExcludeAssetStrings();
        for (@SuppressWarnings("rawtypes")
        Class iClass : objDef.getClass().getInterfaces())
        {
            if (excludeStrings.contains(iClass.getSimpleName()))
            {
                isAsset = false;
            }
        }
        // if(objDef instanceof IfcElement)
        // isAsset=true;
        return isAsset;
    }

}
