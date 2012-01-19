package org.bimserver.cobie.utils.cobiewriters;
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
import java.util.Map;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.SpaceType;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.COBieUtility.CobieSheetName;
import org.bimserver.cobie.utils.stringwriters.IfcRelationshipsToCOBie;
import org.bimserver.models.ifc2x3.IfcBuildingStorey;
import org.bimserver.models.ifc2x3.IfcObjectDefinition;
import org.bimserver.models.ifc2x3.IfcOwnerHistory;
import org.bimserver.models.ifc2x3.IfcRelDecomposes;
import org.bimserver.models.ifc2x3.IfcRelDefines;
import org.bimserver.models.ifc2x3.IfcSpace;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IfcToSpace 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcToSpace.class);
	private static final CobieSheetName sheetName = CobieSheetName.Space;
	protected static final String extObject = IfcSpace.class.getSimpleName();
	protected static enum roomTagEnum {RoomTag,Tag,Room_Tag};
	protected static enum usableHeightEnum {FinishCeilingHeight,Height};
	protected static enum grossAreaEnum {GrossFloorArea,GSA};
	protected static enum netAreaEnum {NetFloorArea,GSA};
	
	public static COBIEType writeSpacesToCOBie(COBIEType cType, IfcModelInterface model)
	{	
		LogHandler loggerHandler = new LogHandler(sheetName,LOGGER);
		loggerHandler.sheetWriteBegin();
		COBIEType.Spaces spaces =
				cType.addNewSpaces();
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
				category = COBieUtility.getObjectClassification(ifcSpace);
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
			}
			catch(Exception ex)
			{
				loggerHandler.error(ex);
			}		
		}
		loggerHandler.sheetWritten();
		return cType;
	}
	
	public static String nameFromSpace(IfcSpace space)
	{
		return COBieUtility.getCOBieString(space.getName());
	}
	
	private static String floorNameFromSpace(IfcSpace space)
	{
		String floorName = "";
		for(IfcRelDecomposes decomp : space.getDecomposes())
		{
			IfcObjectDefinition relatedObj = decomp.getRelatingObject();
			if (relatedObj instanceof IfcBuildingStorey && floorName.length()==0)
			{
				IfcBuildingStorey storey = (IfcBuildingStorey)relatedObj;
				floorName = storey.getName();
			}
		}
		return COBieUtility.getCOBieString(floorName);
	}
	
	protected static String descriptionFromSpace(IfcSpace space)
	{
		String desc = "";
		desc = space.getDescription();
		if (desc.length()==0)
			desc = space.getLongName();
		else
			desc = space.getName();
		return COBieUtility.getCOBieString(desc);
	}
	
	protected static String roomTagFromSpace(IfcSpace space)
	{
		String roomTag = "";
		ArrayList<String> names = new ArrayList<String>();
		///TODO:  create a config file with these workaround strings
		for(roomTagEnum r : roomTagEnum.values())
			names.add(r.toString().replace("_"," "));
		for(IfcRelDefines def : space.getIsDefinedBy())
		{
			Map<String,String> tagMap =
					IfcRelationshipsToCOBie.propertyStringsFromRelDefines(def, names);
			if (!tagMap.isEmpty())
			{
				for(String key : tagMap.keySet())
					if (roomTag.length()==0 && tagMap.get(key).length()>0)
						roomTag = tagMap.get(key);
			}
		}
		
		return COBieUtility.getCOBieString(roomTag);
	}
	
	protected static String usableHeightFromSpace (IfcSpace space)
	{
		String height = "";
		ArrayList<String> names = new ArrayList<String>();
		for (usableHeightEnum h : usableHeightEnum.values())
			names.add(h.toString().replace("_"," "));
		for (IfcRelDefines def : space.getIsDefinedBy())
		{
			Map<String,String> heightMap =
					IfcRelationshipsToCOBie.propertyStringsFromRelDefines(def, names);
			if (!heightMap.isEmpty())
			{
				for (String key : heightMap.keySet())
					if (height.length()==0 && heightMap.get(key).length()>0)
						height = heightMap.get(key);
			}
		}
		return COBieUtility.getCOBieString(height);
	}
	protected static String grossAreaFromSpace (IfcSpace space)
	{
		String height = "";
		ArrayList<String> names = new ArrayList<String>();
		for (grossAreaEnum h : grossAreaEnum.values())
			names.add(h.toString().replace("_"," "));
		for (IfcRelDefines def : space.getIsDefinedBy())
		{
			Map<String,String> heightMap =
					IfcRelationshipsToCOBie.propertyStringsFromRelDefines(def, names);
			if (!heightMap.isEmpty())
			{
				for (String key : heightMap.keySet())
					if (height.length()==0 && heightMap.get(key).length()>0)
						height = heightMap.get(key);
			}
		}
		return COBieUtility.getCOBieString(height);
	}
	
	protected static String netAreaFromSpace (IfcSpace space)
	{
		String height = "";
		ArrayList<String> names = new ArrayList<String>();
		for (netAreaEnum h : netAreaEnum.values())
			names.add(h.toString().replace("_"," "));
		for (IfcRelDefines def : space.getIsDefinedBy())
		{
			Map<String,String> heightMap =
					IfcRelationshipsToCOBie.propertyStringsFromRelDefines(def, names);
			if (!heightMap.isEmpty())
			{
				for (String key : heightMap.keySet())
					if (height.length()==0 && heightMap.get(key).length()>0)
						height = heightMap.get(key);
			}
		}
		return COBieUtility.getCOBieString(height);
	}
}
