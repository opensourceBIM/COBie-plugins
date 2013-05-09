package org.erdc.cobie.utils.serializer.sheetserializers;

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
import java.util.Calendar;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcConstructionEquipmentResource;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.ResourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IfcToResource
{
    private static final Logger LOGGER = LoggerFactory.getLogger(IfcToResource.class);
    private static final CobieSheetName sheetName = CobieSheetName.Resource;

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

    public static void writeResources(COBIEType cType, IfcModelInterface model)
    {
        LogHandler loggerHandler = new LogHandler(sheetName, LOGGER);
        loggerHandler.sheetWriteBegin();
        COBIEType.Resources resources;
        String name;
        IfcOwnerHistory oh;
        String createdBy;
        Calendar createdOn;
        String category;
        String extSystem;
        String extObject;
        String extIdentifier;
        String description;
        try
        {
            resources = cType.getResources();
            if (resources == null)
            {
                resources = cType.addNewResources();
            }
        } catch (Exception ex)
        {
            resources = cType.addNewResources();
        }

        for (IfcConstructionEquipmentResource equipmentResource : model.getAll(IfcConstructionEquipmentResource.class))
        {
            try
            {

                name = IfcToResource.nameFromConstructionEquipmentResource(equipmentResource);
                oh = equipmentResource.getOwnerHistory();
                createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
                createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
                category = IfcToResource.categoryFromConstructionEquipmentResource(equipmentResource);
                extSystem = COBieUtility.getApplicationName(oh);
                extObject = COBieUtility.extObjectFromObjectDef(equipmentResource);
                extIdentifier = equipmentResource.getGlobalId();
                description = IfcToResource.descriptionFromConstructionEquipmentResource(equipmentResource);

                ResourceType resource = resources.addNewResource();
                resource.setName(name);
                resource.setCreatedBy(createdBy);
                resource.setCreatedOn(createdOn);
                resource.setCategory(category);
                resource.setExtSystem(extSystem);
                resource.setExtObject(extObject);
                resource.setExtIdentifier(extIdentifier);
                resource.setDescription(description);
                loggerHandler.rowWritten();
            } catch (Exception ex)
            {
                loggerHandler.error(ex);
            }

        }
        loggerHandler.sheetWritten();
    }
}
