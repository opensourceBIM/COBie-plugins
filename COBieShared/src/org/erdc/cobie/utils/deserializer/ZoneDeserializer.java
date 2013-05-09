package org.erdc.cobie.utils.deserializer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcClassificationReference;
import org.bimserver.models.ifc2x3tc1.IfcRelAssignsToGroup;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcZone;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.ZoneType;
import org.erdc.cobie.utils.deserializer.modelhandlers.ClassificationHandler;
import org.erdc.cobie.utils.deserializer.modelhandlers.IfcCommonHandler;

public class ZoneDeserializer
{
    public static String getZoneKeyFromZone(IfcZone zone)
    {
        String zoneName = zone.getName();
        String category = COBieUtility.getObjectClassificationCategoryString(zone);
        if (COBieUtility.isNA(category))
        {
            category = zone.getObjectType();
        }
        if (zoneName == null)
        {
            zoneName = "";
        }
        if (category == null)
        {
            category = "";
        }
        String zoneKey = zoneName + COBieUtility.getCOBieDelim() + category;
        return zoneKey;
    }

    public static String getZoneKeyFromZone(ZoneType zone)
    {
        String zoneName = zone.getName();
        String category = zone.getCategory();
        if (zoneName == null)
        {
            zoneName = "";
        }
        if (category == null)
        {
            category = "";
        }
        String zoneKey = zoneName + COBieUtility.getCOBieDelim() + category;
        return zoneKey;
    }

    private COBieIfcModel model;
    private IfcCommonHandler ifcCommonHandler;
    private COBIEType.Zones zones;
    private HashMap<String, ArrayList<String>> zoneNameToSpaceNames;

    private HashMap<String, Long> zoneNameToGroupRelationOid;

    public ZoneDeserializer(COBieIfcModel cobieIfcModel, IfcCommonHandler ifcCommonHandler, COBIEType.Zones zones)
    {
        model = cobieIfcModel;
        this.ifcCommonHandler = ifcCommonHandler;
        this.zones = zones;
        zoneNameToSpaceNames = new HashMap<String, ArrayList<String>>();
        zoneNameToGroupRelationOid = new HashMap<String, Long>();
    }

    private void addToSpaceListIgnoreDuplicates(String spaceNames, ArrayList<String> spaceNameList)
    {
        if (!spaceNameList.contains(spaceNames) && model.containsSpace(spaceNames))
        {
            spaceNameList.add(spaceNames);
        }
    }

    public void deserializeZones()
    {
        if ((zones != null) && (zones.getZoneArray() != null))
        {
            populateZoneNameCategoryToSpaceNames();

            for (ZoneType zone : zones.getZoneArray())
            {
                try
                {
                    String zoneKey = getZoneKeyFromZone(zone);
                    if (!model.containsZone(zoneKey) && zoneNameToSpaceNames.containsKey(zoneKey))
                    {
                        handleAddNewZone(zone);
                    }
                } catch (Exception e)
                {
                }
            }
        }
    }

    private void handleAddNewZone(ZoneType zone)
    {
        String zoneKey = ZoneDeserializer.getZoneKeyFromZone(zone);
        IfcZone ifcZone = ifcZoneFromCOBieZone(zone);
        ArrayList<String> spaceNames = zoneNameToSpaceNames.get(zoneKey);
        populateZoneSpaceRelationships(ifcZone, spaceNames);
    }

    public IfcZone ifcZoneFromCOBieZone(ZoneType zone)
    {
        IfcZone ifcZone = Ifc2x3tc1Factory.eINSTANCE.createIfcZone();
        String name = zone.getName();
        String category = zone.getCategory();
        String createdBy = zone.getCreatedBy();
        Calendar createdOn = zone.getCreatedOn();
        String description = zone.getDescription();
        String extIdentifier = zone.getExtIdentifier();

        ifcZone.setName(name);
        ifcZone.setDescription(description);
        ifcZone.setGlobalId(ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(extIdentifier).getWrappedValue());
        ifcZone.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(createdBy, createdOn,
                zone.getExtSystem()));
        String objectType = ClassificationHandler.objectTypeFromCategoryString(category);
        if (!COBieUtility.isNA(objectType))
        {
            ifcZone.setObjectType(objectType);
        }
        List<IfcClassificationReference> classRefs = ifcCommonHandler.getClassificationHandler().classificationReferencesFromString(category);
        model.add(ifcZone, ifcCommonHandler.getOidProvider());
        for (IfcClassificationReference classRef : classRefs)
        {
            ifcCommonHandler.getClassificationHandler().addClassificationReferenceToObject(classRef, ifcZone);
        }
        return ifcZone;
    }

    public boolean isSpaceNamesDelimList(String spaceNames)
    {
        boolean isDelim = false;
        if (spaceNames.contains(COBieUtility.getCOBieDelim()))
        {
            isDelim = true;
        }
        return isDelim;
    }

    public void populateZoneNameCategoryToSpaceNames()
    {
        String spaceNames;
        String zoneKey;
        ArrayList<String> spaceNameList;
        for (ZoneType zone : zones.getZoneArray())
        {
            zoneKey = getZoneKeyFromZone(zone);
            if (zoneNameToSpaceNames.containsKey(zoneKey))
            {
                spaceNameList = zoneNameToSpaceNames.get(zoneKey);
            } else
            {
                spaceNameList = new ArrayList<String>();
            }
            try
            {
                spaceNames = zone.getSpaceNames();
                if (isSpaceNamesDelimList(spaceNames))
                {
                    String[] spaceNameArray = spaceNames.split(COBieUtility.getCOBieDelim());
                    for (String spaceName : spaceNameArray)
                    {
                        addToSpaceListIgnoreDuplicates(spaceName, spaceNameList);
                    }
                } else
                {
                    addToSpaceListIgnoreDuplicates(spaceNames, spaceNameList);
                }
                zoneNameToSpaceNames.put(zoneKey, spaceNameList);
            } catch (Exception e)
            {

            }
        }
    }

    public void populateZoneNameToSpaceNames()
    {
        String spaceNames;
        String zoneName;
        ArrayList<String> spaceNameList;
        for (ZoneType zone : zones.getZoneArray())
        {
            zoneName = zone.getName();
            if (zoneNameToSpaceNames.containsKey(zoneName))
            {
                spaceNameList = zoneNameToSpaceNames.get(zoneName);
            } else
            {
                spaceNameList = new ArrayList<String>();
            }
            try
            {
                spaceNames = zone.getSpaceNames();
                if (isSpaceNamesDelimList(spaceNames))
                {
                    String[] spaceNameArray = spaceNames.split(COBieUtility.getCOBieDelim());
                    for (String spaceName : spaceNameArray)
                    {
                        addToSpaceListIgnoreDuplicates(spaceName, spaceNameList);
                    }
                } else
                {
                    addToSpaceListIgnoreDuplicates(spaceNames, spaceNameList);
                }
                zoneNameToSpaceNames.put(zoneName, spaceNameList);
            } catch (Exception e)
            {

            }
        }
    }

    public void populateZoneSpaceRelationships(IfcZone zone, ArrayList<String> spaceNames)
    {
        for (String spaceName : spaceNames)
        {
            IfcSpace space = (IfcSpace)model.get(model.getSpaceOid(spaceName));
            relAssignsToGroupFromZoneAndSpace(zone, space);
        }
    }

    public IfcRelAssignsToGroup relAssignsToGroupFromZoneAndSpace(IfcZone zone, IfcSpace space)
    {
        IfcRelAssignsToGroup groupAssignment;
        String zoneKey = ZoneDeserializer.getZoneKeyFromZone(zone);
        if (zoneNameToGroupRelationOid.containsKey(zoneKey))
        {
            groupAssignment = (IfcRelAssignsToGroup)model.get(zoneNameToGroupRelationOid.get(zoneKey));
        } else
        {
            groupAssignment = Ifc2x3tc1Factory.eINSTANCE.createIfcRelAssignsToGroup();
            groupAssignment.setRelatingGroup(zone);
            groupAssignment.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid().getWrappedValue());
            groupAssignment.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().DefaultOwnerHistory());
            groupAssignment.setName(zone.getName() + " to " + space.getName() + " relation");
            long relOid = model.add(groupAssignment, ifcCommonHandler.getOidProvider());
            zoneNameToGroupRelationOid.put(zoneKey, relOid);
        }
        groupAssignment.getRelatedObjects().add(space);
        return groupAssignment;
    }

}
