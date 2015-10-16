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

import org.bimserver.cobie.shared.deserialization.cobietab.ComponentDeserializer;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.COBieUtility.CobieSheetName;
import org.bimserver.cobie.shared.utility.ifc.IfcRelationshipsToCOBie;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcDoor;
import org.bimserver.models.ifc2x3tc1.IfcElement;
import org.bimserver.models.ifc2x3tc1.IfcMaterialSelect;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcRelAggregates;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociates;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesMaterial;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3tc1.IfcRelSpaceBoundary;
import org.bimserver.models.ifc2x3tc1.IfcSite;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcSpatialStructureElement;
import org.bimserver.models.ifc2x3tc1.IfcWindow;
import org.bimserver.models.ifc2x3tc1.IfcZone;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.COBIEType.Components;
import org.nibs.cobie.tab.ComponentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IfcToComponent
{
    private static final Logger LOGGER = LoggerFactory.getLogger(IfcToComponent.class);
    private static CobieSheetName sheetName = CobieSheetName.Component;
    private static ArrayList<String> serialNumberStrings = new ArrayList<String>(Arrays.asList("SerialNumber"));
    private static ArrayList<String> installationDateStrings = new ArrayList<String>(Arrays.asList("InstallationDate"));
    private static ArrayList<String> warrantyStartDateStrings = new ArrayList<String>(Arrays.asList("WarrantyStartDate"));
    private static ArrayList<String> tagNumberStrings = new ArrayList<String>(Arrays.asList("TagNumber"));
    private static ArrayList<String> barCodeStrings = new ArrayList<String>(Arrays.asList("BarCode"));
    private static ArrayList<String> assetIdentifierStrings = new ArrayList<String>(Arrays.asList("AssetIdentifier"));
    private static ArrayList<String> AssetComponentExcludeStrings = new ArrayList<String>(Arrays.asList("IfcAnnotation", "IfcDistributionPort",
            "IfcSpace", "IfcBuildingStorey", "IfcBuilding", "IfcSite", "IfcVirtualElement", "IfcBeam", "IfcBuildingElementPart", "IfcColumn",
            "IfcCurtainWall", "IfcElementAssembly", "IfcFastener", "IfcFeatureElement", "IfcFlowFitting", "IfcFlowSegment", "IfcFooting",
            "IfcMechanicalFastener", "IfcMember", "IfcPile", "IfcPlate", "IfcRailing", "IfcRamp", "IfcRampFlight", "IfcReinforcingBar",
            "IfcReinforcingMesh", "IfcRoof", "IfcSlab", "IfcStair", "IfcStairFlight", "IfcTendon", "IfcTendonAnchor", "IfcWall",
            "IfcWallStandardCase", "IfcCovering"));
    //NOTE:  This revision was made on 10/28/2013 in response to an issue with the COBieToolkit where user was using "None" as the selected 
    // idm.  So, the redundant entries in that IDM ignore list are now removed from the AssetComponentExcludeStrings list.
    //private static ArrayList<String> AssetComponentExcludeStrings = new ArrayList<String>(Arrays.asList("IfcSpace", "IfcBuildingStorey", "IfcBuilding", "IfcSite"));

    protected static String assetIdentifierFromProduct(IfcProduct product)
    {
        String pString = null;
        ArrayList<String> typePNames = IfcToComponent.getAssetIdentifierStrings();
        pString = IfcRelationshipsToCOBie.getHighestRankingPropertyStringFromRelDefinesList(product.getIsDefinedBy(), typePNames, false);
        return COBieUtility.getCOBieString(pString);
    }

    protected static String barCodeFromProduct(IfcProduct product)
    {
        String pString = null;
        ArrayList<String> typePNames = IfcToComponent.getBarCodeStrings();
        pString = IfcRelationshipsToCOBie.getHighestRankingPropertyStringFromRelDefinesList(product.getIsDefinedBy(), typePNames, false);
        return COBieUtility.getCOBieString(pString);
    }

    static protected String descriptionFromProduct(IfcProduct product)
    {
        String description = "";
        // description = COBieUtility.valueOfAttribute(product,
        // "PredefinedType");
        description = product.getDescription();
        if ((description == null) || (description.length() == 0))
        {
            description = product.getName();
        }
        return description;
    }

    static protected String extObjectFromProduct(IfcProduct product)
    {
        String className = product.getClass().getSimpleName();
        if (className.toLowerCase().endsWith("impl"))
        {
            className = className.substring(0, className.length() - 4);
        }
        return className;
    }

    private static void findAggregatesComonents(IfcModelInterface model, HashMap<String, ArrayList<String>> componentDictionary)
    {
        for (IfcRelAggregates relAgg : model.getAll(IfcRelAggregates.class))
        {

            for (IfcObjectDefinition obj : relAgg.getRelatedObjects())
            {
                if (isNotAnotherSheetIfcProductType(obj))
                {
                    IfcProduct product = (IfcProduct)obj;
                    String componentKey = IfcToComponent.keyFromProduct(product);
                    String spaceName = IfcToComponent.spaceFromObjectDef(product);
                    if (IfcToComponent.isAssetComponent(product))
                    {
                        updateComponentDictionary(componentDictionary, componentKey, spaceName);
                    }
                }
            }
        }
    }

    private static void findContainedInSpatialStructureComponents(IfcModelInterface model, HashMap<String, ArrayList<String>> componentDictionary)
    {
        for (IfcRelContainedInSpatialStructure relCont : model.getAll(IfcRelContainedInSpatialStructure.class))
        {
            for (IfcProduct product : relCont.getRelatedElements())
            {
                String componentKey = IfcToComponent.keyFromProduct(product);
                String SpaceName = IfcToComponent.spaceFromRelContainedInSpatialStructure(relCont);
                if (IfcToComponent.isAssetComponent(product))
                {
                    updateComponentDictionary(componentDictionary, componentKey, SpaceName);
                }
            }
        }
    }

    private static void findSpaceBoundaryComponents(IfcModelInterface model, HashMap<String, ArrayList<String>> componentDictionary)
    {
        for (IfcRelSpaceBoundary relBoundary : model.getAllWithSubTypes(IfcRelSpaceBoundary.class))
        {

            IfcElement relatedElement = relBoundary.getRelatedBuildingElement();

            if (isNotAnotherSheetIfcProductType(relatedElement))
            {
                IfcProduct product = relatedElement;
                String componentKey = IfcToComponent.keyFromProduct(product);
                IfcSpace space = relBoundary.getRelatingSpace();
                String spaceName = COBieUtility.COBieNA;
                if (space != null)
                {
                    spaceName = IfcToSpace.nameFromSpace(relBoundary.getRelatingSpace());
                }
                if (IfcToComponent.isAssetComponent(product))
                {
                    updateComponentDictionary(componentDictionary, componentKey, spaceName);
                }
            }

        }

    }

    private static ArrayList<String> getAssetIdentifierStrings()
    {
        return assetIdentifierStrings;
    }

    private static ArrayList<String> getBarCodeStrings()
    {
        return barCodeStrings;
    }

    protected static HashMap<String, ArrayList<String>> getComponentNamesSpaceLookupFromModel(IfcModelInterface model)
    {
        HashMap<String, ArrayList<String>> componentDictionary = new HashMap<String, ArrayList<String>>();

        findContainedInSpatialStructureComponents(model, componentDictionary);
        findAggregatesComonents(model, componentDictionary);
        findSpaceBoundaryComponents(model, componentDictionary);

        return componentDictionary;
    }

    @SuppressWarnings("deprecation")
	protected static ArrayList<IfcProduct> getComponentProducts(COBIEType cType, IfcModelInterface model)
    {

        ArrayList<IfcProduct> products = new ArrayList<IfcProduct>();
        ArrayList<String> componentGuids = new ArrayList<String>();
        String tmpGuid;
        COBIEType.Components components = cType.getComponents();
        for (ComponentType comp : components.getComponentArray())
        {
            componentGuids.add(comp.getExtIdentifier());
        }

        for (IfcProduct product : model.getAllWithSubTypes(IfcProduct.class))
        {
            tmpGuid = product.getGlobalId();
            if (componentGuids.contains(tmpGuid))
            {
                ;
            }
            products.add(product);
        }
        return products;
    }

    private static ArrayList<String> getExcludeAssetComponentStrings()
    {
        return AssetComponentExcludeStrings;
    }

    private static ArrayList<String> getInstallationDateStrings()
    {
        return installationDateStrings;
    }

    private static void getRidOfNASpaceNamesIfOthersExist(ArrayList<String> spaceNames)
    {
        if (spaceNames.size() > 1)
        {
            spaceNames.remove(COBieUtility.COBieNA);
        }

    }

    private static ArrayList<String> getSerialNumberStrings()
    {
        return serialNumberStrings;
    }

    private static ArrayList<String> getTagNumberStrings()
    {
        return tagNumberStrings;
    }

    private static ArrayList<String> getWarrantyStartDateStrings()
    {
        return warrantyStartDateStrings;
    }

    private static void handleRelAggregates(
            LogHandler loggerHandler,
            ArrayList<String> writtenComponents,
            COBIEType.Components components,
            HashMap<String, ArrayList<String>> componentNamesToSpaceNames,
            IfcRelAggregates relAgg)
    {
        String Name;
        String CreatedBy;
        Calendar CreatedOn;
        String TypeName;
        String Space;
        String Description;
        String ExtSystem;
        String ExtObject;
        String ExtIdentifier;
        String SerialNumber;
        String InstallationDate;
        String WarrantyStartDate;
        String TagNumber;
        String BarCode;
        String AssetIdentifier;
        IfcOwnerHistory oh;
        ComponentType newComponent;
        String key;
        for (IfcObjectDefinition obj : relAgg.getRelatedObjects())
        {
            if (isNotAnotherSheetIfcProductType(obj))
            {
                if (obj instanceof IfcProduct)
                {
                    if (!ComponentDeserializer.isProductAController((IfcProduct)obj))
                    {
                        IfcProduct product = (IfcProduct)obj;
                        Name = IfcToComponent.nameFromProduct(product);
                        key = IfcToComponent.keyFromProduct(product);
                        if (shouldWriteComponent(writtenComponents, Name, product))
                        {
                            try
                            {

                                oh = product.getOwnerHistory();
                                CreatedBy = COBieIfcUtility.getEmailFromOwnerHistory(oh);
                                CreatedOn = IfcToContact.getCreatedOn(oh.getCreationDate());
                                ExtSystem = COBieIfcUtility.getApplicationName(oh);
                                TypeName = IfcToComponent.typeNameFromProduct(product);
                                if (componentNamesToSpaceNames.containsKey(key))
                                {
                                    Space = COBieUtility.getCOBieString(COBieUtility.delimittedStringFromArrayList(componentNamesToSpaceNames
                                            .get(key)));
                                } else
                                {
                                    Space = IfcToComponent.spaceFromObjectDef(relAgg.getRelatingObject());
                                }
                                Description = IfcToComponent.descriptionFromProduct(product);
                                ExtObject = IfcToComponent.extObjectFromProduct(product);
                                ExtIdentifier = COBieIfcUtility.extIdFromRoot(product);
                                SerialNumber = IfcToComponent.serialNumberFromProduct(product);
                                InstallationDate = IfcToComponent.installationDateFromProduct(product);
                                WarrantyStartDate = IfcToComponent.warrantyStartDateFromProduct(product);
                                TagNumber = IfcToComponent.tagNumberFromProduct(product);
                                BarCode = IfcToComponent.barCodeFromProduct(product);
                                AssetIdentifier = IfcToComponent.assetIdentifierFromProduct(product);
                                newComponent = components.addNewComponent();

                                newComponent.setName(Name);
                                newComponent.setCreatedBy(CreatedBy);
                                newComponent.setCreatedOn(CreatedOn);
                                newComponent.setTypeName(TypeName);
                                newComponent.setSpace(Space);
                                newComponent.setDescription(Description);
                                newComponent.setExtSystem(ExtSystem);
                                newComponent.setExtObject(ExtObject);
                                newComponent.setExtIdentifier(ExtIdentifier);
                                newComponent.setSerialNumber(SerialNumber);
                                newComponent.setInstallationDate(InstallationDate);
                                newComponent.setWarrantyStartDate(WarrantyStartDate);
                                newComponent.setTagNumber(TagNumber);
                                newComponent.setBarCode(BarCode);
                                newComponent.setAssetIdentifier(AssetIdentifier);
                                writtenComponents.add(Name);
                                loggerHandler.rowWritten();
                            } catch (Exception ex)
                            {
                                loggerHandler.error(ex);
                            }

                        }
                    }
                }

            }
        }
    }

    private static void handleRelContainedInSpatialStructure(
            LogHandler loggerHandler,
            ArrayList<String> writtenComponents,
            COBIEType.Components components,
            HashMap<String, ArrayList<String>> componentNamesToSpaceNames,
            IfcRelContainedInSpatialStructure relCont)
    {
        String Name;
        String CreatedBy;
        Calendar CreatedOn;
        String TypeName;
        String Space;
        String Description;
        String ExtSystem;
        String ExtObject;
        String ExtIdentifier;
        String SerialNumber;
        String InstallationDate;
        String WarrantyStartDate;
        String TagNumber;
        String BarCode;
        String AssetIdentifier;
        IfcOwnerHistory oh;
        ComponentType newComponent;
        String key;
        for (IfcProduct product : relCont.getRelatedElements())
        {
            Name = IfcToComponent.nameFromProduct(product);
            key = IfcToComponent.keyFromProduct(product);
            if (shouldWriteComponent(writtenComponents, Name, product))
            {
                try
                {

                    oh = product.getOwnerHistory();
                    CreatedBy = COBieIfcUtility.getEmailFromOwnerHistory(oh);
                    CreatedOn = IfcToContact.getCreatedOn(oh.getCreationDate());
                    ExtSystem = COBieIfcUtility.getApplicationName(oh);
                    TypeName = IfcToComponent.typeNameFromProduct(product);

                    if (componentNamesToSpaceNames.containsKey(key))
                    {
                        Space = COBieUtility.getCOBieString(COBieUtility.delimittedStringFromArrayList(componentNamesToSpaceNames.get(key)));
                    } else
                    {
                        Space = IfcToComponent.spaceFromRelContainedInSpatialStructure(relCont);
                    }
                    Description = IfcToComponent.descriptionFromProduct(product);
                    ExtObject = IfcToComponent.extObjectFromProduct(product);
                    ExtIdentifier = COBieIfcUtility.extIdFromRoot(product);
                    SerialNumber = IfcToComponent.serialNumberFromProduct(product);
                    InstallationDate = IfcToComponent.installationDateFromProduct(product);
                    WarrantyStartDate = IfcToComponent.warrantyStartDateFromProduct(product);
                    TagNumber = IfcToComponent.tagNumberFromProduct(product);
                    BarCode = IfcToComponent.barCodeFromProduct(product);
                    AssetIdentifier = IfcToComponent.assetIdentifierFromProduct(product);

                    newComponent = components.addNewComponent();
                    newComponent.setName(Name);
                    newComponent.setCreatedBy(CreatedBy);
                    newComponent.setCreatedOn(CreatedOn);
                    newComponent.setTypeName(TypeName);
                    newComponent.setSpace(Space);
                    newComponent.setDescription(Description);
                    newComponent.setExtSystem(ExtSystem);
                    newComponent.setExtObject(ExtObject);
                    newComponent.setExtIdentifier(ExtIdentifier);
                    newComponent.setSerialNumber(SerialNumber);
                    newComponent.setInstallationDate(InstallationDate);
                    newComponent.setWarrantyStartDate(WarrantyStartDate);
                    newComponent.setTagNumber(TagNumber);
                    newComponent.setBarCode(BarCode);
                    newComponent.setAssetIdentifier(AssetIdentifier);
                    writtenComponents.add(Name);
                    loggerHandler.rowWritten();
                } catch (Exception ex)
                {
                    loggerHandler.error(ex);
                }
            }
        }
    }

    private static void handleSpaceBoundary(
            LogHandler loggerHandler,
            ArrayList<String> writtenComponents,
            Components components,
            HashMap<String, ArrayList<String>> componentNamesToSpaceNames,
            IfcRelSpaceBoundary spaceBoundary)
    {
        String Name;
        String CreatedBy;
        Calendar CreatedOn;
        String TypeName;
        String Space;
        String Description;
        String ExtSystem;
        String ExtObject;
        String ExtIdentifier;
        String SerialNumber;
        String InstallationDate;
        String WarrantyStartDate;
        String TagNumber;
        String BarCode;
        String AssetIdentifier;
        IfcOwnerHistory oh;
        ComponentType newComponent;
        String key;
        IfcElement element = spaceBoundary.getRelatedBuildingElement();
        if (isNotAnotherSheetIfcProductType(element))
        {

            if (!ComponentDeserializer.isProductAController(element))
            {
                IfcProduct product = element;
                Name = IfcToComponent.nameFromProduct(product);
                key = IfcToComponent.keyFromProduct(product);
                if (shouldWriteComponent(writtenComponents, Name, product))
                {
                    try
                    {

                        oh = product.getOwnerHistory();
                        CreatedBy = COBieIfcUtility.getEmailFromOwnerHistory(oh);
                        CreatedOn = IfcToContact.getCreatedOn(oh.getCreationDate());
                        ExtSystem = COBieIfcUtility.getApplicationName(oh);
                        TypeName = IfcToComponent.typeNameFromProduct(product);
                        if (componentNamesToSpaceNames.containsKey(key))
                        {
                            Space = COBieUtility.getCOBieString(COBieUtility.delimittedStringFromArrayList(componentNamesToSpaceNames.get(key)));
                        } else if (spaceBoundary.getRelatingSpace() != null)
                        {
                            Space = IfcToSpace.nameFromSpace(spaceBoundary.getRelatingSpace());
                        } else
                        {
                            Space = COBieUtility.COBieNA;
                        }
                        Description = IfcToComponent.descriptionFromProduct(product);
                        ExtObject = IfcToComponent.extObjectFromProduct(product);
                        ExtIdentifier = COBieIfcUtility.extIdFromRoot(product);
                        SerialNumber = IfcToComponent.serialNumberFromProduct(product);
                        InstallationDate = IfcToComponent.installationDateFromProduct(product);
                        WarrantyStartDate = IfcToComponent.warrantyStartDateFromProduct(product);
                        TagNumber = IfcToComponent.tagNumberFromProduct(product);
                        BarCode = IfcToComponent.barCodeFromProduct(product);
                        AssetIdentifier = IfcToComponent.assetIdentifierFromProduct(product);
                        newComponent = components.addNewComponent();

                        newComponent.setName(Name);
                        newComponent.setCreatedBy(CreatedBy);
                        newComponent.setCreatedOn(CreatedOn);
                        newComponent.setTypeName(TypeName);
                        newComponent.setSpace(Space);
                        newComponent.setDescription(Description);
                        newComponent.setExtSystem(ExtSystem);
                        newComponent.setExtObject(ExtObject);
                        newComponent.setExtIdentifier(ExtIdentifier);
                        newComponent.setSerialNumber(SerialNumber);
                        newComponent.setInstallationDate(InstallationDate);
                        newComponent.setWarrantyStartDate(WarrantyStartDate);
                        newComponent.setTagNumber(TagNumber);
                        newComponent.setBarCode(BarCode);
                        newComponent.setAssetIdentifier(AssetIdentifier);
                        writtenComponents.add(Name);
                        loggerHandler.rowWritten();
                    } catch (Exception ex)
                    {
                        loggerHandler.error(ex);
                    }

                }
            }

        }

    }

    protected static String installationDateFromProduct(IfcProduct product)
    {
        String pString = null;
        ArrayList<String> typePNames = IfcToComponent.getInstallationDateStrings();
        pString = IfcRelationshipsToCOBie.getHighestRankingPropertyStringFromRelDefinesList(product.getIsDefinedBy(), typePNames, false);
        return COBieUtility.NormalizeDateString(COBieUtility.getCOBieString(pString));
    }

    protected static boolean isAssetComponent(IfcObjectDefinition objDef)
    {

        boolean isAsset = true;
        ArrayList<String> excludeStrings = getExcludeAssetComponentStrings();
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

    public static boolean isNotAnotherSheetIfcProductType(IfcObjectDefinition obj)
    {
        return (obj instanceof IfcProduct) && !(obj instanceof IfcSpace) && !(obj instanceof IfcBuildingStorey) && !(obj instanceof IfcZone)
                && !(obj instanceof IfcBuilding) && !(obj instanceof IfcSite);
    }

    static protected String keyFromProduct(IfcProduct product)
    {
        String key;
        try
        {
            key = product.getGlobalId();
            if (COBieUtility.isNA(key))
            {
                key = product.getName();
            }
        } catch (Exception ex)
        {
            key = product.getName();
        }
        return COBieUtility.getCOBieString(key);
    }

    static protected String nameFromProduct(IfcProduct product)
    {
        return COBieUtility.getCOBieString(product.getName());
    }

    protected static String serialNumberFromProduct(IfcProduct product)
    {
        String pString = null;
        ArrayList<String> typePNames = IfcToComponent.getSerialNumberStrings();

        pString = IfcRelationshipsToCOBie.getHighestRankingPropertyStringFromRelDefinesList(product.getIsDefinedBy(), typePNames, false);
        return COBieUtility.getCOBieString(pString);
    }

    private static boolean shouldWriteComponent(ArrayList<String> writtenComponents, String Name, IfcProduct product)
    {
        // boolean shouldWrite = !writtenComponents.contains(Name) &&
        // IfcToComponent.isAssetComponent(product);
        boolean shouldWrite = IfcToComponent.isAssetComponent(product);
        return shouldWrite;
    }

    static protected String spaceFromIfcProduct(IfcProduct product)
    {
        String spaces = "";
        if ((product instanceof IfcDoor) || (product instanceof IfcWindow))
        {
            ArrayList<String> spaceNames = new ArrayList<String>();
            // product.get
            for (IfcRelDecomposes decomposes : product.getDecomposes())
            {
                if (decomposes.getRelatingObject() instanceof IfcSpace)
                {
                    IfcSpace space = (IfcSpace)decomposes.getRelatingObject();
                    String spaceName = COBieUtility.getCOBieString(space.getName());
                    if (!spaceNames.contains(spaceName))
                    {
                        spaceNames.add(spaceName);
                    }
                }
            }
            if (spaceNames.size() > 0)
            {
                spaces = COBieUtility.delimittedStringFromArrayList(spaceNames);
            }
        } else
        {
            spaces = COBieUtility.getCOBieString(spaces);
        }

        return spaces;
    }

    static protected String spaceFromObjectDef(IfcObjectDefinition def)
    {
        String spaces = "";
        if (def instanceof IfcSpace)
        {
            IfcSpace iSpace = (IfcSpace)def;
            spaces = IfcToSpace.nameFromSpace(iSpace);
        }
        return COBieUtility.getCOBieString(spaces);
    }

    static protected String spaceFromRelContainedInSpatialStructure(IfcRelContainedInSpatialStructure containedIn)
    {
        String spaces = "";
        IfcSpatialStructureElement structure = containedIn.getRelatingStructure();
        if (structure instanceof IfcSpace)
        {
            IfcSpace iSpace = (IfcSpace)structure;
            spaces = IfcToSpace.nameFromSpace(iSpace);
        }
        return COBieUtility.getCOBieString(spaces);
    }

    protected static String tagNumberFromProduct(IfcProduct product)
    {
        String pString = null;
        Map<String, String> valMap = new HashMap<String, String>();
        ArrayList<String> typePNames = IfcToComponent.getTagNumberStrings();
        if (product.isSetIsDefinedBy())
        {
            for (IfcRelDefines rel : product.getIsDefinedBy())
            {
                if ((pString == null) || (pString.length() == 0))
                {
                    valMap = IfcRelationshipsToCOBie.propertyStringsFromRelDefines(rel, typePNames);
                    pString = COBieUtility.cobieStringFromStringMap(valMap);
                }
            }
        } else
        {
            pString = COBieUtility.COBieNA;
        }

        return COBieUtility.getCOBieString(pString);
    }

    static protected String typeNameFromProduct(IfcProduct product)
    {
        String type = "";
        boolean foundAType = false;
        for (IfcRelDefines def : product.getIsDefinedBy())
        {
            if (!foundAType && (def instanceof IfcRelDefinesByType))
            {
                foundAType = true;
                type = IfcToType.nameFromTypeObject(((IfcRelDefinesByType)def).getRelatingType());
            }
        }
        if (!foundAType)
        {
            for (IfcRelAssociates assoc : product.getHasAssociations())
            {
                if (!foundAType && (assoc instanceof IfcRelAssociatesMaterial))
                {

                    IfcRelAssociatesMaterial assocMaterial = (IfcRelAssociatesMaterial)assoc;
                    IfcMaterialSelect relMaterial = IfcToType.getMaterialOrMaterialLayerSet(assocMaterial);
                    if (relMaterial != null)
                    {
                        foundAType = true;
                        type = IfcToType.nameFromMaterialSelect(relMaterial);
                    }

                }
            }
        }
        return COBieUtility.getCOBieString(type);
    }

    private static void updateComponentDictionary(HashMap<String, ArrayList<String>> componentDictionary, String Name, String SpaceName)
    {
        ArrayList<String> spaceNames;
        if (componentDictionary.containsKey(Name))
        {
            spaceNames = componentDictionary.get(Name);
        } else
        {
            spaceNames = new ArrayList<String>();
        }
        if (!spaceNames.contains(SpaceName))
        {
            spaceNames.add(SpaceName);
        }
        getRidOfNASpaceNamesIfOthersExist(spaceNames);
        componentDictionary.put(Name, spaceNames);
    }

    protected static String warrantyStartDateFromProduct(IfcProduct product)
    {
        String pString = null;
        ArrayList<String> typePNames = IfcToComponent.getWarrantyStartDateStrings();
        pString = IfcRelationshipsToCOBie.getHighestRankingPropertyStringFromRelDefinesList(product.getIsDefinedBy(), typePNames, false);
        return COBieUtility.NormalizeDateString(COBieUtility.getCOBieString(pString));
    }

    public static COBIEType writeComponentsToCOBie(COBIEType cType, IfcModelInterface model)
    {
        LogHandler loggerHandler = new LogHandler(sheetName, LOGGER);
        loggerHandler.sheetWriteBegin();

        ArrayList<String> writtenComponents = new ArrayList<String>();
        COBIEType.Components components = cType.addNewComponents();

        HashMap<String, ArrayList<String>> componentNamesToSpaceNames = IfcToComponent.getComponentNamesSpaceLookupFromModel(model);
        for (IfcRelContainedInSpatialStructure relCont : model.getAll(IfcRelContainedInSpatialStructure.class))
        {

            handleRelContainedInSpatialStructure(loggerHandler, writtenComponents, components, componentNamesToSpaceNames, relCont);
        }

        for (IfcRelAggregates relAgg : model.getAll(IfcRelAggregates.class))
        {

            handleRelAggregates(loggerHandler, writtenComponents, components, componentNamesToSpaceNames, relAgg);
        }
        for (IfcRelSpaceBoundary spaceBoundary : model.getAllWithSubTypes(IfcRelSpaceBoundary.class))
        {
            handleSpaceBoundary(loggerHandler, writtenComponents, components, componentNamesToSpaceNames, spaceBoundary);
        }
        loggerHandler.sheetWritten();
        return cType;

    }

}
