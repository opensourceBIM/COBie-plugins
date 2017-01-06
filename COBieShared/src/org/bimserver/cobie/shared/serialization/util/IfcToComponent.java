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
import java.util.HashMap;
import java.util.Map;

import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.ifc.IfcRelationshipUtility;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcDoor;
import org.bimserver.models.ifc2x3tc1.IfcElement;
import org.bimserver.models.ifc2x3tc1.IfcMaterialSelect;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
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
import org.nibs.cobie.tab.ComponentType;

import com.prairiesky.transform.cobieifc.settings.SettingsType;

public class IfcToComponent
{

    private static ArrayList<String> serialNumberStrings = new ArrayList<String>(Arrays.asList("SerialNumber"));
    private static ArrayList<String> installationDateStrings = new ArrayList<String>(Arrays.asList("InstallationDate"));
    private static ArrayList<String> warrantyStartDateStrings = new ArrayList<String>(Arrays.asList("WarrantyStartDate"));
    private static ArrayList<String> tagNumberStrings = new ArrayList<String>(Arrays.asList("TagNumber"));
    private static ArrayList<String> barCodeStrings = new ArrayList<String>(Arrays.asList("BarCode"));
    private static ArrayList<String> assetIdentifierStrings = new ArrayList<String>(Arrays.asList("AssetIdentifier"));
  
    protected static String assetIdentifierFromProduct(IfcProduct product)
    {
        String pString = null;
        ArrayList<String> typePNames = IfcToComponent.getAssetIdentifierStrings();
        pString = IfcRelationshipUtility.getHighestRankingPropertyStringFromRelDefinesList(product.getIsDefinedBy(), typePNames, false);
        return COBieUtility.getCOBieString(pString);
    }

    protected static String barCodeFromProduct(IfcProduct product)
    {
        String pString = null;
        ArrayList<String> typePNames = IfcToComponent.getBarCodeStrings();
        pString = IfcRelationshipUtility.getHighestRankingPropertyStringFromRelDefinesList(product.getIsDefinedBy(), typePNames, false);
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

    private static void findAggregatesComonents(IfcModelInterface model, HashMap<String, ArrayList<String>> componentDictionary, SettingsType settings)
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
                    if (IfcProductToComponentsSerializer.isAssetComponent(product, settings))
                    {
                        updateComponentDictionary(componentDictionary, componentKey, spaceName);
                    }
                }
            }
        }
    }

    private static void findContainedInSpatialStructureComponents(IfcModelInterface model, HashMap<String, ArrayList<String>> componentDictionary, SettingsType settings)
    {
        for (IfcRelContainedInSpatialStructure relCont : model.getAll(IfcRelContainedInSpatialStructure.class))
        {
            for (IfcProduct product : relCont.getRelatedElements())
            {
                String componentKey = IfcToComponent.keyFromProduct(product);
                String SpaceName = IfcToComponent.spaceFromRelContainedInSpatialStructure(relCont);
                if (IfcProductToComponentsSerializer.isAssetComponent(product, settings))
                {
                    updateComponentDictionary(componentDictionary, componentKey, SpaceName);
                }
            }
        }
    }

    private static void findSpaceBoundaryComponents(IfcModelInterface model, HashMap<String, ArrayList<String>> componentDictionary, SettingsType settings)
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
                    spaceName = IfcSpaceSerializer.nameFromSpace(relBoundary.getRelatingSpace());
                }
                if (IfcProductToComponentsSerializer.isAssetComponent(product, settings))
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

    protected static HashMap<String, ArrayList<String>> getComponentNamesSpaceLookupFromModel(IfcModelInterface model, SettingsType settings)
    {
        HashMap<String, ArrayList<String>> componentDictionary = new HashMap<String, ArrayList<String>>();

        findContainedInSpatialStructureComponents(model, componentDictionary, settings);
        findAggregatesComonents(model, componentDictionary, settings);
        findSpaceBoundaryComponents(model, componentDictionary, settings);

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

    protected static String installationDateFromProduct(IfcProduct product)
    {
        String pString = null;
        ArrayList<String> typePNames = IfcToComponent.getInstallationDateStrings();
        pString = IfcRelationshipUtility.getHighestRankingPropertyStringFromRelDefinesList(product.getIsDefinedBy(), typePNames, false);
        return COBieUtility.NormalizeDateString(COBieUtility.getCOBieString(pString));
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

        pString = IfcRelationshipUtility.getHighestRankingPropertyStringFromRelDefinesList(product.getIsDefinedBy(), typePNames, false);
        return COBieUtility.getCOBieString(pString);
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
            spaces = IfcSpaceSerializer.nameFromSpace(iSpace);
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
            spaces = IfcSpaceSerializer.nameFromSpace(iSpace);
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
                    valMap = IfcRelationshipUtility.propertyStringsFromRelDefines(rel, typePNames);
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
                type = IfcTypeToCOBieTypeSerializer.nameFromTypeObject(((IfcRelDefinesByType)def).getRelatingType());
            }
        }
        if (!foundAType)
        {
            for (IfcRelAssociates assoc : product.getHasAssociations())
            {
                if (!foundAType && (assoc instanceof IfcRelAssociatesMaterial))
                {

                    IfcRelAssociatesMaterial assocMaterial = (IfcRelAssociatesMaterial)assoc;
                    IfcMaterialSelect relMaterial = IfcTypeToCOBieTypeSerializer.getMaterialOrMaterialLayerSet(assocMaterial);
                    if (relMaterial != null)
                    {
                        foundAType = true;
                        type = IfcTypeToCOBieTypeSerializer.nameFromMaterialSelect(relMaterial);
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
        pString = IfcRelationshipUtility.getHighestRankingPropertyStringFromRelDefinesList(product.getIsDefinedBy(), typePNames, false);
        return COBieUtility.NormalizeDateString(COBieUtility.getCOBieString(pString));
    }

}
