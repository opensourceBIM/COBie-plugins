package org.bimserver.cobie.shared.deserialization.cobietab;

import org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers.IfcCommonHandler;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcConstructionEquipmentResource;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.ResourceType;

public class ResourceDeserializer
{
    private COBieIfcModel model;
    private IfcCommonHandler ifcCommonHandler;
    private COBIEType.Resources resources;

    public ResourceDeserializer(COBieIfcModel model, IfcCommonHandler ifcCommonHandler, COBIEType.Resources resources)
    {
        this.model = model;
        this.ifcCommonHandler = ifcCommonHandler;
        this.resources = resources;
    }

    public IfcConstructionEquipmentResource constructionEquipmentFromResource(ResourceType resource) throws IfcModelInterfaceException
    {
        IfcConstructionEquipmentResource constructionEquipmentResource = Ifc2x3tc1Factory.eINSTANCE.createIfcConstructionEquipmentResource();
        constructionEquipmentResource.setName(resource.getName());
        constructionEquipmentResource.setDescription(resource.getDescription());
        constructionEquipmentResource.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(
                resource.getCreatedBy(), resource.getCreatedOn(), resource.getExtSystem()));
        constructionEquipmentResource.setGlobalId(ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(resource.getExtIdentifier())
                .getWrappedValue());
        constructionEquipmentResource.setObjectType(resource.getCategory());
        return constructionEquipmentResource;
    }

    @SuppressWarnings("deprecation")
	public void deserializeResources()
    {
        if ((resources != null) && (resources.getResourceArray() != null))
        {
            for (ResourceType resource : resources.getResourceArray())
            {
                try
                {
                    if (!model.containsResource(resource.getName()))
                    {
                        model.add(constructionEquipmentFromResource(resource), ifcCommonHandler.getOidProvider());
                    }
                } catch (Exception ex)
                {

                }
            }
        }
    }
}
