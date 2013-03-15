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
import java.util.ArrayList;
import java.util.Calendar;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.SpaceType;
import org.erdc.cobie.utils.stringwriters.IfcRelationshipsToCOBie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IfcToSpace
{
    protected static enum grossAreaEnum
    {
        GrossFloorArea, GSA
    }

    protected static enum netAreaEnum
    {
        NetFloorArea, GSA
    }

    protected static enum roomTagEnum
    {
        RoomTag, Tag, Room_Tag
    }

    protected static enum usableHeightEnum
    {
        FinishCeilingHeight, Height, UsableHeight
    };

    private static final Logger LOGGER = LoggerFactory.getLogger(IfcToSpace.class);;
    private static final CobieSheetName sheetName = CobieSheetName.Space;;
    protected static final String extObject = IfcSpace.class.getSimpleName();;

    public static IfcBuildingStorey buildingStoreyFromSpace(IfcSpace space)
    {
        String floorName = "";
        IfcBuildingStorey storey = null;
        for (IfcRelDecomposes decomp : space.getDecomposes())
        {
            IfcObjectDefinition relatedObj = decomp.getRelatingObject();
            if ((relatedObj instanceof IfcBuildingStorey) && (floorName.length() == 0))
            {
                storey = (IfcBuildingStorey)relatedObj;
            }
        }
        return storey;
    }

    protected static String descriptionFromSpace(IfcSpace space)
    {
        String desc = "";
        try
        {
            desc = space.getDescription();
        } catch (Exception e)
        {

        }
        if (COBieUtility.isNA(desc))
        {
            try
            {
                desc = space.getLongName();
                if (COBieUtility.isNA(desc))
                {
                    desc = space.getName();
                }
            } catch (Exception e)
            {

            }
        }

        return COBieUtility.getCOBieString(desc);
    }

    public static String floorNameFromSpace(IfcSpace space)
    {
        String floorName = "";
        IfcBuildingStorey storey = buildingStoreyFromSpace(space);
        if (storey != null)
        {
            floorName = storey.getName();
        }
        return COBieUtility.getCOBieString(floorName);
    }

    protected static String grossAreaFromSpace(IfcSpace space)
    {
        String height = "";
        ArrayList<String> names = new ArrayList<String>();
        for (grossAreaEnum h : grossAreaEnum.values())
        {
            names.add(h.toString().replace("_", " "));
        }
        height = IfcRelationshipsToCOBie.getHighestRankingPropertyStringFromRelDefinesList(space.getIsDefinedBy(), names, false);
        return COBieUtility.getCOBieString(height);
    }

    public static String nameFromSpace(IfcSpace space)
    {
        return COBieUtility.getCOBieString(space.getName());
    }

    protected static String netAreaFromSpace(IfcSpace space)
    {
        String height = "";
        ArrayList<String> names = new ArrayList<String>();
        for (netAreaEnum h : netAreaEnum.values())
        {
            names.add(h.toString().replace("_", " "));
        }
        height = IfcRelationshipsToCOBie.getHighestRankingPropertyStringFromRelDefinesList(space.getIsDefinedBy(), names, false);
        return COBieUtility.getCOBieString(height);
    }

    protected static String roomTagFromSpace(IfcSpace space)
    {
        String roomTag = "";
        ArrayList<String> names = new ArrayList<String>();
        // /TODO: create a config file with these workaround strings
        for (roomTagEnum r : roomTagEnum.values())
        {
            names.add(r.toString().replace("_", " "));
        }
        roomTag = IfcRelationshipsToCOBie.getHighestRankingPropertyStringFromRelDefinesList(space.getIsDefinedBy(), names, false);
        return COBieUtility.getCOBieString(roomTag);
    }

    protected static String usableHeightFromSpace(IfcSpace space)
    {
        String height = "";
        ArrayList<String> names = new ArrayList<String>();
        for (usableHeightEnum h : usableHeightEnum.values())
        {
            names.add(h.toString().replace("_", " "));
        }
        height = IfcRelationshipsToCOBie.getHighestRankingPropertyStringFromRelDefinesList(space.getIsDefinedBy(), names, false);
        return COBieUtility.getCOBieString(height);
    }

    public static COBIEType writeSpacesToCOBie(COBIEType cType, IfcModelInterface model)
    {
        LogHandler loggerHandler = new LogHandler(sheetName, LOGGER);
        loggerHandler.sheetWriteBegin();
        COBIEType.Spaces spaces = cType.addNewSpaces();
        String name = "";
        String createdBy = "";
        Calendar createdOn;
        String category = "";
        String floorName = "";
        String description = "";
        String extSystem = "";
        String extObject = "";
        String extIdentifier = "";
        String roomTag = "";
        String usableHeight = "";
        String grossArea = "";
        String netArea = "";
        for (IfcSpace ifcSpace : model.getAll(IfcSpace.class))
        {
            try
            {
                IfcOwnerHistory oh = ifcSpace.getOwnerHistory();
                name = IfcToSpace.nameFromSpace(ifcSpace);
                createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
                createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
                category = COBieUtility.getObjectClassificationCategoryString(ifcSpace);
                floorName = IfcToSpace.floorNameFromSpace(ifcSpace);
                description = IfcToSpace.descriptionFromSpace(ifcSpace);
                extSystem = COBieUtility.getApplicationName(oh);
                extObject = IfcToSpace.extObject;
                extIdentifier = COBieUtility.identifierFromObject(ifcSpace);
                roomTag = IfcToSpace.roomTagFromSpace(ifcSpace);
                usableHeight = IfcToSpace.usableHeightFromSpace(ifcSpace);
                grossArea = IfcToSpace.grossAreaFromSpace(ifcSpace);
                netArea = IfcToSpace.netAreaFromSpace(ifcSpace);

                SpaceType space = spaces.addNewSpace();
                space.setName(name);
                space.setCreatedBy(createdBy);
                space.setCreatedOn(createdOn);
                space.setCategory(category);
                space.setFloorName(floorName);
                space.setDescription(description);
                space.setExtSystem(extSystem);
                space.setExtObject(extObject);
                space.setExtIdentifier(extIdentifier);
                space.setRoomTag(roomTag);
                space.setUsableHeight(usableHeight);
                space.setGrossArea(grossArea);
                space.setNetArea(netArea);
                loggerHandler.rowWritten();
            } catch (Exception ex)
            {
                loggerHandler.error(ex);
                ex.printStackTrace();
            }
        }
        loggerHandler.sheetWritten();
        return cType;
    }
}
