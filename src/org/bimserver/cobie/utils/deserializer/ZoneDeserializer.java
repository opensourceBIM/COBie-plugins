package org.bimserver.cobie.utils.deserializer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.ZoneType;
import org.bimserver.cobie.plugins.COBieIfcModel;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.IfcClassificationReference;
import org.bimserver.models.ifc2x3.IfcRelAssignsToGroup;
import org.bimserver.models.ifc2x3.IfcSpace;
import org.bimserver.models.ifc2x3.IfcZone;

public class ZoneDeserializer 
{
	private COBieIfcModel model;
	private IfcCommonHandler ifcCommonHandler;
	private COBIEType.Zones zones;
	private HashMap<String,ArrayList<String>> zoneNameToSpaceNames;
	private HashMap<String,Long> zoneNameToGroupRelationOid;
	public ZoneDeserializer (COBieIfcModel cobieIfcModel, IfcCommonHandler ifcCommonHandler, COBIEType.Zones zones)
	{
		this.model = cobieIfcModel;
		this.ifcCommonHandler = ifcCommonHandler;
		this.zones = zones;
		zoneNameToSpaceNames = new HashMap<String,ArrayList<String>>();
		zoneNameToGroupRelationOid = new HashMap<String,Long>();
	}
	
	public void deserializeZones()
	{
		if (zones!=null && zones.getZoneArray()!=null)
		{
			populateZoneNameCategoryToSpaceNames();

			for(ZoneType zone : zones.getZoneArray())
			{
				try
				{
					String zoneKey = getZoneKeyFromZone(zone);
					if (!model.containsZone(zoneKey) && zoneNameToSpaceNames.containsKey(zoneKey))
					{
						handleAddNewZone(zone);
					}
				}
				catch(Exception e)
				{
					String noop="";
				}
			}
		}
	}
	

	private void handleAddNewZone(ZoneType zone) 
	{
		String zoneKey = ZoneDeserializer.getZoneKeyFromZone(zone);
		IfcZone ifcZone = ifcZoneFromCOBieZone(zone);
		ArrayList<String> spaceNames = zoneNameToSpaceNames.get(zoneKey);
		populateZoneSpaceRelationships(ifcZone,spaceNames);
	}
	
	public void populateZoneSpaceRelationships(IfcZone zone, ArrayList<String> spaceNames)
	{
		for(String spaceName : spaceNames)
		{
			IfcSpace space = (IfcSpace) model.get(model.getSpaceOid(spaceName));
			relAssignsToGroupFromZoneAndSpace(zone,space);
		}
	}
	
	
	public IfcRelAssignsToGroup relAssignsToGroupFromZoneAndSpace(IfcZone zone,IfcSpace space)
	{
		IfcRelAssignsToGroup groupAssignment;
		String zoneKey = ZoneDeserializer.getZoneKeyFromZone(zone);
		if (zoneNameToGroupRelationOid.containsKey(zoneKey))
			groupAssignment = (IfcRelAssignsToGroup) model.get(zoneNameToGroupRelationOid.get(zoneKey));
		else
		{
			groupAssignment = Ifc2x3Factory.eINSTANCE.createIfcRelAssignsToGroup();
			groupAssignment.setRelatingGroup(zone);
			groupAssignment.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid());
			groupAssignment.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().DefaultOwnerHistory());
			groupAssignment.setName(zone.getName()+" to "+ space.getName()+ " relation");
			long relOid = model.add(groupAssignment,ifcCommonHandler.getOidProvider());
			zoneNameToGroupRelationOid.put(zoneKey, relOid);
		}
		groupAssignment.getRelatedObjects().add(space);
		return groupAssignment;
	}
	
	public IfcZone ifcZoneFromCOBieZone(ZoneType zone)
	{
		IfcZone ifcZone = Ifc2x3Factory.eINSTANCE.createIfcZone();
		String name = zone.getName();
		String category = zone.getCategory();
		String createdBy = zone.getCreatedBy();
		Calendar createdOn = zone.getCreatedOn();
		String description = zone.getDescription();
		String extIdentifier = zone.getExtIdentifier();
		
		ifcZone.setName(name);
		ifcZone.setDescription(description);
		ifcZone.setGlobalId(ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(extIdentifier));
		ifcZone.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailAndTimestamp(createdBy, createdOn));
		ifcZone.setObjectType(category);
		IfcClassificationReference classRef =
				ifcCommonHandler.getClassificationHandler().classificationReferenceFromString(category);
		model.add(ifcZone,ifcCommonHandler.getOidProvider());
		if (classRef!=null)
			ifcCommonHandler.getClassificationHandler().addClassificationReferenceToObject(classRef, ifcZone);
		return ifcZone;
	}
	
	public boolean isSpaceNamesDelimList(String spaceNames)
	{
		boolean isDelim = false;
		if (spaceNames.contains(COBieUtility.getCOBieDelim()))
			isDelim=true;
		return isDelim;
	}
	
	public void populateZoneNameToSpaceNames()
	{
		String spaceNames;
		String zoneName;
		ArrayList<String> spaceNameList;
		for(ZoneType zone : zones.getZoneArray())
		{
			zoneName = zone.getName();
			if (zoneNameToSpaceNames.containsKey(zoneName))
				spaceNameList = zoneNameToSpaceNames.get(zoneName);
			else
				spaceNameList = new ArrayList<String>();
			try
			{
				spaceNames = zone.getSpaceNames();
				if (isSpaceNamesDelimList(spaceNames))
				{
					String[] spaceNameArray = spaceNames.split(COBieUtility.getCOBieDelim());
					for(String spaceName : spaceNameArray)
					{
						addToSpaceListIgnoreDuplicates(spaceName, spaceNameList);
					}
				}
				else
				{
					addToSpaceListIgnoreDuplicates(spaceNames, spaceNameList);
				}
				zoneNameToSpaceNames.put(zoneName, spaceNameList);
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
	public static String getZoneKeyFromZone(ZoneType zone)
	{
		String zoneName = zone.getName();
		String category = zone.getCategory();
		if (zoneName==null)
			zoneName = "";
		if (category==null)
			category = "";
		String zoneKey = zoneName + COBieUtility.getCOBieDelim() + category;
		return zoneKey;
	}
	
	public static String getZoneKeyFromZone(IfcZone zone)
	{
		String zoneName = zone.getName();
		String category = COBieUtility.getObjectClassification(zone);
		if (COBieUtility.isNA(category))
			category = zone.getObjectType();
		if (zoneName==null)
			zoneName = "";
		if (category==null)
			category = "";
		String zoneKey = zoneName + COBieUtility.getCOBieDelim() + category;
		return zoneKey;
	}
	
	
	
	public void populateZoneNameCategoryToSpaceNames()
	{
		String spaceNames;
		String zoneKey;
		ArrayList<String> spaceNameList;
		for(ZoneType zone : zones.getZoneArray())
		{
			zoneKey = getZoneKeyFromZone(zone);
			if (zoneNameToSpaceNames.containsKey(zoneKey))
				spaceNameList = zoneNameToSpaceNames.get(zoneKey);
			else
				spaceNameList = new ArrayList<String>();
			try
			{
				spaceNames = zone.getSpaceNames();
				if (isSpaceNamesDelimList(spaceNames))
				{
					String[] spaceNameArray = spaceNames.split(COBieUtility.getCOBieDelim());
					for(String spaceName : spaceNameArray)
					{
						addToSpaceListIgnoreDuplicates(spaceName, spaceNameList);
					}
				}
				else
				{
					addToSpaceListIgnoreDuplicates(spaceNames, spaceNameList);
				}
				zoneNameToSpaceNames.put(zoneKey, spaceNameList);
			}
			catch(Exception e)
			{
				
			}
		}
	}

	private void addToSpaceListIgnoreDuplicates(String spaceNames,
			ArrayList<String> spaceNameList) {
		if (!spaceNameList.contains(spaceNames) && model.containsSpace(spaceNames))
		spaceNameList.add(spaceNames);
	}
	
}
