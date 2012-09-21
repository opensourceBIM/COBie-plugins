package org.bimserver.cobie.utils.deserializer;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.ResourceType;
import org.bimserver.cobie.utils.deserializer.modelhandlers.IfcCommonHandler;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcConstructionEquipmentResource;

public class ResourceDeserializer
{
	private COBieIfcModel model;
	private IfcCommonHandler ifcCommonHandler;
	private COBIEType.Resources resources;
	
	public ResourceDeserializer(COBieIfcModel model,IfcCommonHandler ifcCommonHandler, COBIEType.Resources resources)
	{
		this.model = model;
		this.ifcCommonHandler = ifcCommonHandler;
		this.resources = resources;
	}
	
	public void deserializeResources()
	{
		if (resources!=null && resources.getResourceArray()!=null)
		{
			for(ResourceType resource:resources.getResourceArray())
			{
				try
				{
					if (!model.containsResource(resource.getName()))
						model.add(constructionEquipmentFromResource(resource),ifcCommonHandler.getOidProvider());
				}
				catch(Exception ex)
				{
					
				}
			}
		}
	}
	
	public IfcConstructionEquipmentResource constructionEquipmentFromResource(ResourceType resource)
	{
		IfcConstructionEquipmentResource constructionEquipmentResource =
				Ifc2x3tc1Factory.eINSTANCE.createIfcConstructionEquipmentResource();
		constructionEquipmentResource.setName(resource.getName());
		constructionEquipmentResource.setDescription(resource.getDescription());
		constructionEquipmentResource.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(resource.getCreatedBy(),
				resource.getCreatedOn(), resource.getExtSystem()));
		constructionEquipmentResource.setGlobalId(ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(resource.getExtIdentifier()));
		constructionEquipmentResource.setObjectType(resource.getCategory());
		return constructionEquipmentResource;
	}
}
