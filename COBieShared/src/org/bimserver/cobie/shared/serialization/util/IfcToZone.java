package org.bimserver.cobie.shared.serialization.util;

/******************************************************************************

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
import java.util.List;
import java.util.Map;

import org.bimserver.cobie.shared.deserialization.cobietab.ZoneDeserializer;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.COBieUtility.CobieSheetName;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcRelAssignsToGroup;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcZone;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.ZoneType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IfcToZone
{
    private static enum propertySingleValueZoneNames
    {
        ZoneName
    }

    private static final String NESTED_ZONE_DELIM = "-";
    private static final Logger LOGGER = LoggerFactory.getLogger(IfcToZone.class);
    private static final CobieSheetName sheetName = CobieSheetName.Zone;
    public static final String extObject = IfcZone.class.getSimpleName();
    public static final String extObjectAlt = IfcPropertySingleValue.class.getSimpleName();;

    protected static String categoryFromSingleValueZone(IfcPropertySingleValue val)
    {
        IfcSingleValueToCOBieString sValStr = new org.bimserver.cobie.shared.serialization.util.IfcSingleValueToCOBieString(val);
        return COBieUtility.getCOBieString(sValStr.getPropertyNameString());
    }

    protected static String categoryFromZone(IfcZone zone)
    {
        String category = "";
        category = COBieIfcUtility.getObjectClassificationCategoryString(zone);
        return category;
    }

    protected static String childZoneNameFromParentAndSelf(IfcZone parentZone, IfcZone childZone)
    {
        String name = "";
        String childName = childZone.getName();
        String parentName = parentZone.getName();
        if (!COBieUtility.isNA(childName) && !COBieUtility.isNA(parentName))
        {
            name = parentName + NESTED_ZONE_DELIM + childName;
        } else
        {
            name = childName;
        }

        return COBieUtility.getCOBieString(name);
    }

    protected static String descriptionFromSingleValueZone(IfcPropertySingleValue val)
    {
        String description = "";
        IfcSingleValueToCOBieString sValStr = new org.bimserver.cobie.shared.serialization.util.IfcSingleValueToCOBieString(val);
        if (sValStr.getValueString().length() == 0)
        {
            description = val.getName();
        } else
        {
            description = sValStr.getValueString();
        }
        return COBieUtility.getCOBieString(description);
    }

    protected static String descriptionFromZone(IfcZone zone)
    {
        String description = "";
        String zDesc = zone.getDescription();
        if (!COBieUtility.isNA(zDesc))
        {
            description = zDesc;
        } else
        {
            description = zone.getName();
        }
        return COBieUtility.getCOBieString(description);
    }

    protected static String extIdentifierFromSingleValueZone(IfcPropertySingleValue val)
    {
        String extId = "";
        IfcSingleValueToCOBieString sValStr = new org.bimserver.cobie.shared.serialization.util.IfcSingleValueToCOBieString(val);
        extId = sValStr.getPropertyNameString();
        return COBieUtility.getCOBieString(extId);
    }

    protected static IfcZone getParentZone(IfcZone zone)
    {
        IfcZone parentZone = null;
        for (IfcRelDecomposes decomposes : zone.getDecomposes())
        {
            if (decomposes.getRelatingObject() instanceof IfcZone)
            {
                parentZone = (IfcZone)decomposes.getRelatingObject();
            }
        }
        return parentZone;
    }

    protected static boolean isNestedZone(IfcZone zone)
    {
        boolean isNested = false;
        for (IfcRelDecomposes decomposes : zone.getDecomposes())
        {
            if (decomposes.getRelatingObject() instanceof IfcZone)
            {
                isNested = true;
            }
        }
        return isNested;
    }

    protected static boolean isPropertySingleValueZone(IfcPropertySingleValue val)
    {
        boolean isZone = false;
        for (propertySingleValueZoneNames literal : propertySingleValueZoneNames.values())
        {
            if (val.getName().contains(literal.toString()))
            {
                isZone = true;
            }
        }
        return isZone;
    }

    protected static String nameFromSingleValueZone(IfcPropertySingleValue val)
    {
        IfcSingleValueToCOBieString sValStr = new org.bimserver.cobie.shared.serialization.util.IfcSingleValueToCOBieString(val);
        return COBieUtility.getCOBieString(sValStr.getValueString());
    }

    protected static String nameFromZone(IfcZone zone)
    {
        String name = "";
        if (isNestedZone(zone))
        {
            name = childZoneNameFromParentAndSelf(getParentZone(zone), zone);
        } else
        {
            name = zone.getName();
        }

        return COBieUtility.getCOBieString(name);
    }

    private static void processCandidateCOBieZone(LogHandler loggerHandler, COBIEType.Zones cZones, ArrayList<String> zoneNamesAdded, IfcZone zone)
    {
        IfcOwnerHistory oh;
        String name;
        String createdBy;
        Calendar createdOn;
        String category;
        ArrayList<String> spaceNames;
        String extSystem;
        String extObject;
        String extIdentifier;
        String zoneKey;
        String description;
        name = IfcToZone.nameFromZone(zone);
        zoneKey = IfcToZone.zoneKeyFromZone(zone);
        if (shouldWriteZone(zoneKey, zoneNamesAdded))
        {
            zoneNamesAdded.add(zoneKey);
            try
            {
                spaceNames = IfcToZone.spaceNameArrayFromZone(zone);
                oh = zone.getOwnerHistory();
                createdBy = COBieIfcUtility.getEmailFromOwnerHistory(oh);
                createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
                category = IfcToZone.categoryFromZone(zone);

                extSystem = COBieIfcUtility.getApplicationName(oh);
                extObject = IfcToZone.extObject;
                extIdentifier = COBieIfcUtility.extIdFromRoot(zone);
                description = IfcToZone.descriptionFromZone(zone);
                if (spaceNames.size() > 0)
                {
                    for (String spaceName : spaceNames)
                    {
                        ZoneType cZone = cZones.addNewZone();
                        cZone.setName(name);
                        cZone.setCreatedBy(createdBy);
                        cZone.setCreatedOn(createdOn);
                        cZone.setCategory(category);
                        cZone.setSpaceNames(spaceName);
                        cZone.setExtSystem(extSystem);
                        cZone.setExtObject(extObject);
                        cZone.setExtIdentifier(extIdentifier);
                        cZone.setDescription(description);
                        loggerHandler.rowWritten();
                    }
                } else
                {
                    ZoneType cZone = cZones.addNewZone();
                    cZone.setName(name);
                    cZone.setCreatedBy(createdBy);
                    cZone.setCreatedOn(createdOn);
                    cZone.setCategory(category);
                    cZone.setSpaceNames(COBieUtility.COBieNA);
                    cZone.setExtSystem(extSystem);
                    cZone.setExtObject(extObject);
                    cZone.setExtIdentifier(extIdentifier);
                    cZone.setDescription(description);
                    loggerHandler.rowWritten();
                }
            } catch (Exception ex)
            {
                loggerHandler.error(ex);

            }

        }
    }

    protected static Map<String, ArrayList<String>> revitZoneSpacesFromModel(IfcModelInterface model) throws Exception
    {
        Map<String, ArrayList<String>> zoneSpaces = new HashMap<String, ArrayList<String>>();
        String name;
        for (IfcSpace space : model.getAll(IfcSpace.class))
        {
            for (IfcRelDefines relDefines : space.getIsDefinedBy())
            {
                try
                {
                    if (relDefines instanceof IfcRelDefinesByProperties)
                    {
                        IfcRelDefinesByProperties rP = (IfcRelDefinesByProperties)relDefines;
                        IfcPropertySetDefinition pSetDef = rP.getRelatingPropertyDefinition();
                        if (pSetDef instanceof IfcPropertySet)
                        {
                            IfcPropertySet pSet = (IfcPropertySet)pSetDef;
                            for (IfcProperty property : pSet.getHasProperties())
                            {
                                if (property instanceof IfcPropertySingleValue)
                                {
                                    IfcPropertySingleValue val = (IfcPropertySingleValue)property;
                                    name = IfcToZone.nameFromSingleValueZone(val);
                                    if (IfcToZone.isPropertySingleValueZone(val))
                                    {
                                        ArrayList<String> spaceList;
                                        if (!zoneSpaces.keySet().contains(name))
                                        {
                                            spaceList = new ArrayList<String>();

                                        } else
                                        {
                                            spaceList = zoneSpaces.get(name);

                                        }
                                        spaceList.add(IfcToSpace.nameFromSpace(space));
                                        zoneSpaces.put(name, spaceList);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e)
                {
                    throw e;
                }
            }
        }
        return zoneSpaces;
    }

    private static void revitZonesToCOBieZonesSpacePerRow(IfcModelInterface model, LogHandler loggerHandler, COBIEType.Zones cZones)
    {
        IfcOwnerHistory oh;
        String name;
        String createdBy;
        Calendar createdOn;
        String category;
        String extSystem;
        String extObject;
        String extIdentifier;
        String description;

        Map<String, ArrayList<String>> zoneSpacesAdded = new HashMap<String, ArrayList<String>>();
        for (IfcSpace space : model.getAll(IfcSpace.class))
        {
            for (IfcRelDefines relDefines : space.getIsDefinedBy())
            {
                try
                {
                    if (relDefines instanceof IfcRelDefinesByProperties)
                    {
                        IfcRelDefinesByProperties rP = (IfcRelDefinesByProperties)relDefines;
                        IfcPropertySetDefinition pSetDef = rP.getRelatingPropertyDefinition();
                        if (pSetDef instanceof IfcPropertySet)
                        {
                            IfcPropertySet pSet = (IfcPropertySet)pSetDef;
                            for (IfcProperty property : pSet.getHasProperties())
                            {
                                if (property instanceof IfcPropertySingleValue)
                                {
                                    IfcPropertySingleValue val = (IfcPropertySingleValue)property;
                                    if (IfcToZone.isPropertySingleValueZone(val))
                                    {
                                        name = IfcToZone.nameFromSingleValueZone(val);
                                        String spaceName = COBieUtility.getCOBieString(space.getName());
                                        category = IfcToZone.categoryFromSingleValueZone(val);
                                        String zoneKey = zoneKeyFromNameAndCategory(name, category);
                                        if (!zoneSpacesAdded.containsKey(zoneKey))
                                        {
                                            ArrayList<String> newSpaceList = new ArrayList<String>();
                                            newSpaceList.add(spaceName);
                                            zoneSpacesAdded.put(zoneKey, newSpaceList);
                                        } else if (!zoneSpacesAdded.get(zoneKey).contains(spaceName))
                                        {
                                            ArrayList<String> existingSpaceList = zoneSpacesAdded.get(zoneKey);
                                            existingSpaceList.add(spaceName);
                                            zoneSpacesAdded.put(zoneKey, existingSpaceList);
                                            oh = IfcToContact.getLatestOwnerHistory(model);
                                            ZoneType cZone = cZones.addNewZone();

                                            if (oh != null)
                                            {
                                                createdBy = COBieIfcUtility.getEmailFromOwnerHistory(oh);
                                                createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
                                            } else
                                            {
                                                createdBy = COBieUtility.COBieNA;
                                                createdOn = COBieUtility.getDefaultCalendar();
                                            }

                                            extSystem = COBieIfcUtility.getApplicationName(oh);
                                            extObject = IfcToZone.extObjectAlt;
                                            extIdentifier = COBieUtility.COBieNA;
                                            description = IfcToZone.descriptionFromSingleValueZone(val);

                                            cZone.setName(name);
                                            cZone.setCreatedBy(createdBy);
                                            cZone.setCreatedOn(createdOn);
                                            cZone.setCategory(category);
                                            cZone.setSpaceNames(spaceName);
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
                } catch (Exception ex)
                {
                    loggerHandler.error(ex);
                }
            }
        }
    }

    private static boolean shouldWriteZone(String name, ArrayList<String> zoneNamesAdded)
    {
        // boolean shouldWrite = !zoneNamesAdded.contains(name);
        boolean shouldWrite = true;
        return shouldWrite;
    }

    protected static ArrayList<String> spaceNameArrayFromZone(IfcZone zone)
    {
        ArrayList<String> spaceNames = new ArrayList<String>();
        IfcRelAssignsToGroup rGroup = zone.getIsGroupedBy();
        if (rGroup == null)
        {

        } else
        {
            for (IfcObjectDefinition objDef : rGroup.getRelatedObjects())
            {
                if (objDef instanceof IfcSpace)
                {
                    IfcSpace tmpSpace = (IfcSpace)objDef;
                    String tmpName = tmpSpace.getName();
                    if (tmpName.length() > 0)
                    {
                        spaceNames.add(tmpName);
                    }
                }
            }
        }
        return spaceNames;
    }

    protected static String spaceNamesCommaDelimFromZone(IfcZone zone)
    {
        String spaceNames = "";
        IfcRelAssignsToGroup rGroup = zone.getIsGroupedBy();
        for (IfcObjectDefinition objDef : rGroup.getRelatedObjects())
        {
            if (objDef instanceof IfcSpace)
            {
                IfcSpace tmpSpace = (IfcSpace)objDef;
                String tmpName = tmpSpace.getName();
                if (tmpName.length() > 0)
                {
                    spaceNames += tmpName + COBieUtility.getCOBieDelim();
                }
            }
        }
        if (spaceNames.endsWith(COBieUtility.getCOBieDelim()))
        {
            spaceNames = spaceNames.substring(0, spaceNames.length() - 1);
        }
        return COBieUtility.getCOBieString(spaceNames);
    }

    protected static String spaceNamesFromSingleValueZone(IfcPropertySingleValue val)
    {
        String spaceNames = "";

        return COBieUtility.getCOBieString(spaceNames);
    }

    public static COBIEType writeZonesToCOBie(COBIEType cType, IfcModelInterface model)
    {
        LogHandler loggerHandler = new LogHandler(sheetName, LOGGER);
        loggerHandler.sheetWriteBegin();
        List<IfcZone> zones = model.getAll(IfcZone.class);
        COBIEType.Zones cZones = cType.addNewZones();
        if (!zones.isEmpty())
        {
            zonesToCOBieZonesSpacePerRow(loggerHandler, zones, cZones);
        } else
        {
            revitZonesToCOBieZonesSpacePerRow(model, loggerHandler, cZones);
        }
        loggerHandler.sheetWritten();
        return cType;
    }

    private static String zoneKeyFromNameAndCategory(String name, String category)
    {
        return name + COBieUtility.getCOBieDelim() + category;
    }

    private static String zoneKeyFromZone(IfcZone zone)
    {
        return ZoneDeserializer.getZoneKeyFromZone(zone);
    }

    private static void zonesToCOBieZonesSpacePerRow(LogHandler loggerHandler, List<IfcZone> zones, COBIEType.Zones cZones)
    {
        ArrayList<String> zoneNamesAdded = new ArrayList<String>();
        for (IfcZone zone : zones)
        {
            processCandidateCOBieZone(loggerHandler, cZones, zoneNamesAdded, zone);
        }
    }
}
