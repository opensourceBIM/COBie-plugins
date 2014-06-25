package org.erdc.cobie.utils.serializer.sheetserializers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.COBIEType.Components;
import org.erdc.cobie.sheetxmldata.ComponentType;
import org.erdc.cobie.utils.serializer.IfcCOBieSerializer;
import org.slf4j.LoggerFactory;

public class IfcProductToComponentsSerializer extends IfcCOBieSerializer<ComponentType, COBIEType.Components, IfcProduct>
{

	private boolean ignoreNonAssets = false;
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
       return (IfcToComponent.isNotAnotherSheetIfcProductType(product)) && (!ignoreNonAssets || IfcToComponent.isAssetComponent(product));
    }

    private Map<String, ArrayList<String>> componentToSpaceDictionary;

    public IfcProductToComponentsSerializer(Components cobieSection, IfcModelInterface model)
    {
        super(cobieSection, model);
        setComponentNameToSpaceNameDictionary(new HashMap<String, ArrayList<String>>());
        setLOGGER(LoggerFactory.getLogger(IfcProductToComponentsSerializer.class));

    }
    
    public IfcProductToComponentsSerializer(Components cobieSection, IfcModelInterface model, boolean ignoreNonAssets)
    {
    	this(cobieSection, model);
    	this.ignoreNonAssets = ignoreNonAssets;
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
                    spaceName = IfcToSpace.nameFromSpace(relBoundary.getRelatingSpace());
                }
                componentExistsWithNASpace(componentKey);
                if (IfcToComponent.isAssetComponent(product))
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
                if (IfcToComponent.isAssetComponent(product))
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
                    if (IfcToComponent.isAssetComponent(product))
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
            createdBy = COBieUtility.getEmailFromOwnerHistory(ownerHistory);
            createdOn = IfcToContact.getCreatedOn(ownerHistory.getCreationDate());
            extSystem = COBieUtility.getApplicationName(ownerHistory);
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
            extIdentifier = COBieUtility.extIdFromRoot(product);
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
