package org.bimserver.cobie.utils.COBieWriters;
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
import java.util.HashMap;
import java.util.Map;

import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.COBieUtility.CobieSheetName;
import org.bimserver.cobie.utils.StringWriters.IfcSingleValueToCOBieString;
import org.bimserver.models.ifc2x3.IfcObjectDefinition;
import org.bimserver.models.ifc2x3.IfcOwnerHistory;
import org.bimserver.models.ifc2x3.IfcProperty;
import org.bimserver.models.ifc2x3.IfcPropertySet;
import org.bimserver.models.ifc2x3.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3.IfcRelAssignsToGroup;
import org.bimserver.models.ifc2x3.IfcRelDefines;
import org.bimserver.models.ifc2x3.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3.IfcSpace;
import org.bimserver.models.ifc2x3.IfcZone;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cobieLite.COBIEType;
import cobieLite.ZoneType;

public class IfcToZone 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcToZone.class);
	private static final CobieSheetName sheetName = CobieSheetName.Zone;
	public static final String extObject = IfcZone.class.getSimpleName();
	public static final String extObjectAlt = IfcPropertySingleValue.class.getSimpleName();
	private static enum propertySingleValueZoneNames {ZoneName};

	public static COBIEType writeZonesToCOBie(COBIEType cType,
			IfcModelInterface model) 
	{
		LogHandler loggerHandler = new LogHandler(sheetName,LOGGER);
		loggerHandler.sheetWriteBegin();
		ArrayList<IfcZone> zones = (ArrayList<IfcZone>) model
				.getAll(IfcZone.class);
		COBIEType.Zones cZones = cType.addNewZones();
		ArrayList<String> zoneNamesAdded = new ArrayList<String>();
		IfcOwnerHistory oh;
		String name = "";
		String createdBy = "";
		Calendar createdOn;
		String category = "";
		String spaceNames = "";
		String extSystem = "";
		String extObject = "";
		String extIdentifier = "";
		String description = "";
		if (!zones.isEmpty()) 
		{
			for (IfcZone zone : zones) 
			{
				name = IfcToZone.nameFromZone(zone);
				if (!zoneNamesAdded.contains(name)) 
				{
					try
					{
						zoneNamesAdded.add(name);
						ZoneType cZone = cZones.addNewZone();
						oh = zone.getOwnerHistory();

						createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
						createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
						category = IfcToZone.categoryFromZone(zone);
						spaceNames = IfcToZone.spaceNamesFromZone(zone);
						extSystem = COBieUtility.getApplicationName(oh);
						extObject = IfcToZone.extObject;
						extIdentifier = COBieUtility.identifierFromObject(zone);
						description = IfcToZone.descriptionFromZone(zone);

						cZone.setName(name);
						cZone.setCreatedBy(createdBy);
						cZone.setCreatedOn(createdOn);
						cZone.setCategory(category);
						cZone.setSpaceNames(spaceNames);
						cZone.setExtSystem(extSystem);
						cZone.setExtObject(extObject);
						cZone.setExtIdentifier(extIdentifier);
						cZone.setDescription(description);
						loggerHandler.rowWritten();
					}
					catch(Exception ex)
					{
						loggerHandler.error(ex);
					}
					
				}
			}
		} else 
		{
			Map<String,ArrayList<String>> zoneSpaces = new 
					HashMap<String,ArrayList<String>>();
			// look for IfcPropertySingleValue instances...
			try
			{
				 zoneSpaces =
						IfcToZone.zoneSpacesFromModel(model);
					
			}
			catch(Exception e)
			{
				loggerHandler.error(e);
			}

			for (IfcSpace space : model.getAll(IfcSpace.class)) 
			{
				for (IfcRelDefines relDefines : space.getIsDefinedBy()) 
				{
					try
					{
						if (relDefines instanceof IfcRelDefinesByProperties) 
						{
							IfcRelDefinesByProperties rP = (IfcRelDefinesByProperties) relDefines;
							IfcPropertySetDefinition pSetDef = rP
									.getRelatingPropertyDefinition();
							if (pSetDef instanceof IfcPropertySet) 
							{
								IfcPropertySet pSet = (IfcPropertySet) pSetDef;
								for (IfcProperty property : pSet.getHasProperties()) 
								{
									if (property instanceof IfcPropertySingleValue) 
									{
										IfcPropertySingleValue val = (IfcPropertySingleValue) property;
										if (IfcToZone.isPropertySingleValueZone(val)) 
										{
											name = IfcToZone
													.nameFromSingleValueZone(val);
											if (!zoneNamesAdded.contains(name)) 
											{
												zoneNamesAdded.add(name);
												oh = IfcToContact
														.getFirstOwnerHistory(model);
												ZoneType cZone = cZones
														.addNewZone();

												if (oh != null) 
												{
													createdBy = COBieUtility
															.getEmailFromOwnerHistory(oh);
													createdOn = IfcToContact
															.getCreatedOn(oh
																	.getCreationDate());
												} 
												else 
												{
													createdBy = COBieUtility.COBieNA;
													createdOn = COBieUtility.getDefaultCalendar();															
												}
												category = IfcToZone
														.categoryFromSingleValueZone(val);
												if (zoneSpaces.isEmpty() || !zoneSpaces.keySet().contains(name))
														spaceNames = IfcToSpace
															.nameFromSpace(space);
												else
													spaceNames =
														COBieUtility.delimittedStringFromArrayList(zoneSpaces.get(name));
												
												extSystem = COBieUtility
														.getApplicationName(oh);
												extObject = IfcToZone.extObjectAlt;
												extIdentifier = COBieUtility.COBieNA;
												description = IfcToZone
														.descriptionFromSingleValueZone(val);

												cZone.setName(name);
												cZone.setCreatedBy(createdBy);
												cZone.setCreatedOn(createdOn);
												cZone.setCategory(category);
												cZone.setSpaceNames(spaceNames);
												cZone.setExtSystem(extSystem);
												cZone.setExtObject(extObject);
												cZone.setExtIdentifier(extIdentifier);
												cZone.setDescription(description);
												loggerHandler.rowWritten();
											}
										}
									}
								}
							}
						}
					}
					catch(Exception ex)
					{
						loggerHandler.error(ex);
					}
				}
			}
		}
		loggerHandler.sheetWritten();
		return cType;
	}
	
	protected static String nameFromZone(IfcZone zone)
	{
		String name = "";
		name = zone.getName();
		return COBieUtility.getCOBieString(name);
	}
	
	
	protected static Map<String,ArrayList<String>> zoneSpacesFromModel(IfcModelInterface model) throws Exception
	{
		Map<String,ArrayList<String>> zoneSpaces = new HashMap<String,ArrayList<String>>();
		String name;
		for (IfcSpace space : model.getAll(IfcSpace.class)) 
		{
			for (IfcRelDefines relDefines : space.getIsDefinedBy()) 
			{
				try
				{
					if (relDefines instanceof IfcRelDefinesByProperties) 
					{
						IfcRelDefinesByProperties rP = (IfcRelDefinesByProperties) relDefines;
						IfcPropertySetDefinition pSetDef = rP
								.getRelatingPropertyDefinition();
						if (pSetDef instanceof IfcPropertySet) 
						{
							IfcPropertySet pSet = (IfcPropertySet) pSetDef;
							for (IfcProperty property : pSet.getHasProperties()) 
							{
								if (property instanceof IfcPropertySingleValue) 
								{
									IfcPropertySingleValue val = (IfcPropertySingleValue) property;
									name = IfcToZone
											.nameFromSingleValueZone(val);
									if (IfcToZone.isPropertySingleValueZone(val)) 
									{
										ArrayList<String> spaceList;
										if (!zoneSpaces.keySet().contains(name))
										{
											spaceList = new ArrayList<String>();

										}
										else
										{
											spaceList =
													zoneSpaces.get(name);

										}
										spaceList.add(IfcToSpace.nameFromSpace(space));
										zoneSpaces.put(name, spaceList);
									}
								}
							}
						}
					}
				}
				catch(Exception e)
				{
					throw e;
				}
			}
		}
		return zoneSpaces;
	}
	protected static String nameFromSingleValueZone(IfcPropertySingleValue val)
	{
		IfcSingleValueToCOBieString sValStr = new org.bimserver.cobie.utils.StringWriters.IfcSingleValueToCOBieString(val);
		return COBieUtility.getCOBieString(sValStr.getValueString());
	}
	
	protected static String categoryFromSingleValueZone(IfcPropertySingleValue val)
	{
		IfcSingleValueToCOBieString sValStr = new org.bimserver.cobie.utils.StringWriters.IfcSingleValueToCOBieString(val);
		return COBieUtility.getCOBieString(sValStr.getPropertyNameString());
	}
	
	protected static boolean isPropertySingleValueZone(IfcPropertySingleValue val)
	{
		boolean isZone = false;
		for (propertySingleValueZoneNames literal : propertySingleValueZoneNames.values())
			if (val.getName().contains(literal.toString()))
				isZone = true;
			return isZone;
	}
	
	protected static String categoryFromZone(IfcZone zone)
	{
		String category = "";
		category = COBieUtility.getObjectClassification(zone);
		return category;
	}
	protected static String spaceNamesFromZone(IfcZone zone)
	{
		String spaceNames = "";
		IfcRelAssignsToGroup rGroup = zone.getIsGroupedBy();
		for(IfcObjectDefinition objDef : rGroup.getRelatedObjects())
		{
				if (objDef instanceof IfcSpace)
				{
					IfcSpace tmpSpace = (IfcSpace) objDef;
					String tmpName = tmpSpace.getName();
					if (tmpName.length()>0)
						spaceNames += tmpName +COBieUtility.getCOBieDelim();
				}
		}
		if (spaceNames.endsWith(COBieUtility.getCOBieDelim()))
			spaceNames = spaceNames.substring(0,spaceNames.length()-1);
		return COBieUtility.getCOBieString(spaceNames);
	}
	protected static String spaceNamesFromSingleValueZone(IfcPropertySingleValue val)
	{
		String spaceNames = "";
		
		return COBieUtility.getCOBieString(spaceNames);
	}

	protected static String descriptionFromZone(IfcZone zone)
	{
		String description = "";
		String zDesc = zone.getDescription();
		if (zDesc.length()>0)
			description = zDesc;
		else
			description = zone.getName();
		return COBieUtility.getCOBieString(description);
	}
	
	protected static String extIdentifierFromSingleValueZone(IfcPropertySingleValue val)
	{
		String extId = "";
		IfcSingleValueToCOBieString sValStr = new org.bimserver.cobie.utils.StringWriters.IfcSingleValueToCOBieString(val);
		extId = sValStr.getPropertyNameString();
		return COBieUtility.getCOBieString(extId);
	}
	
	protected static String descriptionFromSingleValueZone(IfcPropertySingleValue val)
	{
		String description = "";
		IfcSingleValueToCOBieString sValStr = new org.bimserver.cobie.utils.StringWriters.IfcSingleValueToCOBieString(val);
		if (sValStr.getValueString().length()==0)
			description = val.getName();
		else
			description = sValStr.getValueString();
		return COBieUtility.getCOBieString(description);
	}
}
