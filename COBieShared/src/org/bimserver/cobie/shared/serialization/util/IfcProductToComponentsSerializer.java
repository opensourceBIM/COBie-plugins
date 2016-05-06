package org.bimserver.cobie.shared.serialization.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.cobie.shared.serialization.IfcCobieSerializer;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.CaseInsensitiveStringList;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcDoor;
import org.bimserver.models.ifc2x3tc1.IfcElement;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcRelAggregates;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcRelSpaceBoundary;
import org.bimserver.models.ifc2x3tc1.IfcSite;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcWindow;
import org.bimserver.models.ifc2x3tc1.IfcZone;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.COBIEType.Components;
import org.nibs.cobie.tab.ComponentType;
import org.slf4j.LoggerFactory;

import com.prairiesky.transform.cobieifc.settings.SettingsType;

public class IfcProductToComponentsSerializer extends IfcCobieSerializer<ComponentType, COBIEType.Components, IfcProduct>
{

    private static void getRidOfNASpaceNamesIfOthersExist(ArrayList<String> spaceNames)
    {
        if (spaceNames.size() > 1)
        {
            spaceNames.remove(COBieUtility.COBieNA);
        }

    }

    private static boolean isNotAnotherSheetIfcProductType(IfcObjectDefinition obj)
    {
        return (obj instanceof IfcProduct) && !(obj instanceof IfcSpace) && !(obj instanceof IfcBuildingStorey) && !(obj instanceof IfcZone)
                && !(obj instanceof IfcBuilding) && !(obj instanceof IfcSite);
    }

    private boolean shouldWriteComponent(IfcProduct product)
    {
       return (IfcToComponent.isNotAnotherSheetIfcProductType(product)) && (isAssetComponent(product));
    }

    private Map<String, ArrayList<String>> componentToSpaceDictionary;

    public IfcProductToComponentsSerializer(Components cobieSection, IfcModelInterface model, SettingsType settings)
    {
        super(cobieSection, model, settings);
        setComponentNameToSpaceNameDictionary(new HashMap<String, ArrayList<String>>());
        setLOGGER(LoggerFactory.getLogger(IfcProductToComponentsSerializer.class));

    }

    private void addNewOrUpdateComponentSpaceDictionary(String Name, String SpaceName)
    {
        ArrayList<String> spaceNames;
        if (componentToSpaceDictionary.containsKey(Name))
        {
            spaceNames = componentToSpaceDictionary.get(Name);
        } else
        {
            spaceNames = new ArrayList<String>();
        }
        if (!spaceNames.contains(SpaceName))
        {
            spaceNames.add(SpaceName);
        }
        getRidOfNASpaceNamesIfOthersExist(spaceNames);
        componentToSpaceDictionary.put(Name, spaceNames);
    }

    private void assignSpacesBySpatialBoundaryIfNull()
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
                componentExistsWithNASpace(componentKey);
                if (isAssetComponent(product))
                {
                    updateExistingComponentSpaceDictionaryElement(componentKey, spaceName);
                }
            }
        }
    }

    private boolean componentExistsWithNASpace(String componentKey)
    {
        boolean containsKey, isSpaceEmptyOrNA = false;
        containsKey = componentToSpaceDictionary.containsKey(componentKey);
        if (containsKey)
        {
            ArrayList<String> spaceNames = componentToSpaceDictionary.get(componentKey);
            if (spaceNames != null)
            {
                String spaceNameString = COBieUtility.delimittedStringFromArrayList(spaceNames);
                if (COBieUtility.isNA(spaceNameString))
                {
                    isSpaceEmptyOrNA = true;
                }
            }
        }
        return containsKey && isSpaceEmptyOrNA;
    }

    private List<IfcProduct> findContainedInSpatialStructureComponents()
    {
        List<IfcProduct> containedInSpatialStructureComponents = new ArrayList<IfcProduct>();
        for (IfcRelContainedInSpatialStructure relCont : model.getAll(IfcRelContainedInSpatialStructure.class))
        {
            for (IfcProduct product : relCont.getRelatedElements())
            {
                String componentKey = IfcToComponent.keyFromProduct(product);
                String SpaceName = IfcToComponent.spaceFromRelContainedInSpatialStructure(relCont);
                if (isAssetComponent(product))
                {
                    addNewOrUpdateComponentSpaceDictionary(componentKey, SpaceName);
                    if (!containedInSpatialStructureComponents.contains(product))
                    {
                        containedInSpatialStructureComponents.add(product);
                    }
                }
            }
        }
        return containedInSpatialStructureComponents;
    }
    
    private boolean isAssetComponent(IfcProduct product) 
    {
    	return IfcProductToComponentsSerializer.isAssetComponent(product, getSettings());
	}

	protected static boolean isAssetComponent(IfcObjectDefinition objDef, SettingsType settings)
    {

        boolean isAsset = true;
        CaseInsensitiveStringList excludeStrings = getExcludeAssetComponentStrings(settings);
        for (@SuppressWarnings("rawtypes")
        Class iClass : objDef.getClass().getInterfaces())
        {
            if (excludeStrings.contains(iClass.getSimpleName()))
            {
                isAsset = false;
            }
        }
        return isAsset;
    }

    private static CaseInsensitiveStringList getExcludeAssetComponentStrings(
			SettingsType settings) 
    {
    	CaseInsensitiveStringList exclude = new CaseInsensitiveStringList(new ArrayList<String>());
    	if(settings != null && settings.getComponentSettings() != null && settings.getComponentSettings().getIfcProductExclusions() != null)
    	{
    		for(String name : settings.getComponentSettings().getIfcProductExclusions().getName())
    		{
    			exclude.add(name);
    		}
    	}
    	return exclude;
	}

	private List<IfcProduct> findRelAggregatesComponents()
    {
        List<IfcProduct> relAggregateComponents = new ArrayList<IfcProduct>();
        for (IfcRelAggregates relAgg : model.getAll(IfcRelAggregates.class))
        {

            for (IfcObjectDefinition obj : relAgg.getRelatedObjects())
            {
                if (isNotAnotherSheetIfcProductType(obj))
                {
                    IfcProduct product = (IfcProduct)obj;
                    String componentKey = IfcToComponent.keyFromProduct(product);
                    String spaceName = IfcToComponent.spaceFromObjectDef(product);
                    if (isAssetComponent(product))
                    {
                        addNewOrUpdateComponentSpaceDictionary(componentKey, spaceName);
                        relAggregateComponents.add(product);
                    }
                }
            }
        }
        return relAggregateComponents;
    }

    public Map<String, ArrayList<String>> getComponentNameToSpaceNameDictionary()
    {
        return componentToSpaceDictionary;
    }

    @Override
    protected List<IfcProduct> getTopLevelModelObjects()
    {
        List<IfcProduct> productList = new ArrayList<IfcProduct>();

        List<IfcProduct> containedInSpatialStructureComponents = findContainedInSpatialStructureComponents();
        List<IfcProduct> aggregateComponents = findRelAggregatesComponents();
        productList.addAll(containedInSpatialStructureComponents);
        productList.addAll(aggregateComponents);
        assignSpacesBySpatialBoundaryIfNull();
        return productList;
    }

    @Override
    protected List<ComponentType> serializeModelObject(IfcProduct product)
    {
        List<ComponentType> newComponents = new ArrayList<ComponentType>();
        String productName = "";
        String createdBy = "";
        Calendar createdOn;
        String typeName = "";
        String spaceNames = "";
        String description = "";
        String extSystem = "";
        String extObject = "";
        String extIdentifier = "";
        String serialNumber = "";
        String installationDate = "";
        String warrantyStartDate = "";
        String tagNumber = "";
        String barCode = "";
        String assetIdentifier = "";
        IfcOwnerHistory ownerHistory;
        ComponentType newComponent;
        String componentKey = "";

        productName = IfcToComponent.nameFromProduct(product);
        componentKey = IfcToComponent.keyFromProduct(product);
        if (shouldWriteComponent(product))
        {

            ownerHistory = product.getOwnerHistory();
            createdBy = COBieIfcUtility.getEmailFromOwnerHistory(ownerHistory);
            createdOn = IfcToContact.getCreatedOn(ownerHistory.getCreationDate());
            extSystem = COBieIfcUtility.getApplicationName(ownerHistory);
            typeName = IfcToComponent.typeNameFromProduct(product);
            if (componentToSpaceDictionary.containsKey(componentKey))
            {
                spaceNames = COBieUtility.getCOBieString(COBieUtility.delimittedStringFromArrayList(componentToSpaceDictionary.get(componentKey)));
            } else
            {
                spaceNames = spaceFromIfcProduct(product);
            }
            description = IfcToComponent.descriptionFromProduct(product);
            extObject = IfcToComponent.extObjectFromProduct(product);
            extIdentifier = COBieIfcUtility.extIdFromRoot(product);
            serialNumber = IfcToComponent.serialNumberFromProduct(product);
            installationDate = IfcToComponent.installationDateFromProduct(product);
            warrantyStartDate = IfcToComponent.warrantyStartDateFromProduct(product);
            tagNumber = IfcToComponent.tagNumberFromProduct(product);
            barCode = IfcToComponent.barCodeFromProduct(product);
            assetIdentifier = IfcToComponent.assetIdentifierFromProduct(product);
            newComponent = cobieSection.addNewComponent();
            
            newComponent.setName(productName);
            newComponent.setCreatedBy(createdBy);
            newComponent.setCreatedOn(createdOn);
            newComponent.setTypeName(typeName);
            newComponent.setSpace(spaceNames);
            newComponent.setDescription(description);
            newComponent.setExtSystem(extSystem);
            newComponent.setExtObject(extObject);
            newComponent.setExtIdentifier(extIdentifier);
            newComponent.setSerialNumber(serialNumber);
            newComponent.setInstallationDate(installationDate);
            newComponent.setWarrantyStartDate(warrantyStartDate);
            newComponent.setTagNumber(tagNumber);
            newComponent.setBarCode(barCode);
            newComponent.setAssetIdentifier(assetIdentifier);
            newComponents.add(newComponent);

        }
        return newComponents;
    }

    public void setComponentNameToSpaceNameDictionary(Map<String, ArrayList<String>> componentNameToSpaceNameDictionary)
    {
        componentToSpaceDictionary = componentNameToSpaceNameDictionary;
    }

    protected String spaceFromIfcProduct(IfcProduct product)
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

    private void updateExistingComponentSpaceDictionaryElement(String Name, String SpaceName)
    {
        ArrayList<String> spaceNames;
        if (componentToSpaceDictionary.containsKey(Name))
        {
            spaceNames = componentToSpaceDictionary.get(Name);

            if (!spaceNames.contains(SpaceName))
            {
                spaceNames.add(SpaceName);
            }
            getRidOfNASpaceNamesIfOthersExist(spaceNames);
            componentToSpaceDictionary.put(Name, spaceNames);
        }
    }

}
