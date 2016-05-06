package org.bimserver.cobie.shared.serialization.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.bimserver.cobie.shared.serialization.IfcCobieSerializer;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcConstructionEquipmentResource;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.COBIEType.Resources;
import org.nibs.cobie.tab.ResourceType;

import com.prairiesky.transform.cobieifc.settings.SettingsType;

public class IfcConstructionEquipmentResourceSerializer extends
		IfcCobieSerializer<ResourceType, COBIEType.Resources, IfcConstructionEquipmentResource> 
{

	public IfcConstructionEquipmentResourceSerializer(Resources cobieSection,
			IfcModelInterface model, SettingsType settings) 
	{
		super(cobieSection, model, settings);
	}

	@Override
	protected List<IfcConstructionEquipmentResource> getTopLevelModelObjects() 
	{
		return model.getAll(IfcConstructionEquipmentResource.class);
	}

	@Override
	protected List<ResourceType> serializeModelObject(
			IfcConstructionEquipmentResource equipmentResource) 
	{
        String name;
        IfcOwnerHistory oh;
        String createdBy;
        Calendar createdOn;
        String category;
        String extSystem;
        String extObject;
        String extIdentifier;
        String description;
        List<ResourceType> resources = new ArrayList<>();
        
        name = IfcConstructionEquipmentResourceSerializer.nameFromConstructionEquipmentResource(equipmentResource);
        oh = equipmentResource.getOwnerHistory();
        createdBy = COBieIfcUtility.getEmailFromOwnerHistory(oh);
        createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
        category = IfcConstructionEquipmentResourceSerializer.categoryFromConstructionEquipmentResource(equipmentResource);
        extSystem = COBieIfcUtility.getApplicationName(oh);
        extObject = COBieIfcUtility.extObjectFromObjectDef(equipmentResource);
        extIdentifier = COBieIfcUtility.extIdFromRoot(equipmentResource);
        description = IfcConstructionEquipmentResourceSerializer.descriptionFromConstructionEquipmentResource(equipmentResource);

        ResourceType resource = getCobieSection().addNewResource();
        resource.setName(name);
        resource.setCreatedBy(createdBy);
        resource.setCreatedOn(createdOn);
        resource.setCategory(category);
        resource.setExtSystem(extSystem);
        resource.setExtObject(extObject);
        resource.setExtIdentifier(extIdentifier);
        resource.setDescription(description);
        resources.add(resource);
        return resources;
	}
	
    private static String categoryFromConstructionEquipmentResource(IfcConstructionEquipmentResource equipmentResource)
    {
        String category = equipmentResource.getObjectType();
        return COBieUtility.getCOBieString(category);
    }

    private static String descriptionFromConstructionEquipmentResource(IfcConstructionEquipmentResource equipmentResource)
    {
        String description = equipmentResource.getDescription();
        if ((description == null) || description.isEmpty())
        {
            description = equipmentResource.getName();
        }
        return COBieUtility.getCOBieString(description);
    }

    private static String nameFromConstructionEquipmentResource(IfcConstructionEquipmentResource equipmentResource)
    {
        String name = equipmentResource.getName();
        return COBieUtility.getCOBieString(name);
    }

}
