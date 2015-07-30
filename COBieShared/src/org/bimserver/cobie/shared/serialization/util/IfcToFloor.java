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
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.COBieUtility.CobieSheetName;
import org.bimserver.cobie.shared.utility.ifc.IfcRelationshipsToCOBie;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.impl.IfcBuildingStoreyImpl;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.FloorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IfcToFloor
{
    private static final String SITE = "Site";
    private static final String IFC_SITE = "IfcSite";
    protected static final String extObject = IfcBuildingStorey.class.getSimpleName();
    private static final Logger LOGGER = LoggerFactory.getLogger(IfcToFloor.class);
    private static final CobieSheetName sheetName = CobieSheetName.Floor;
    private static final ArrayList<String> heightPropertyNames = new ArrayList<String>(Arrays.asList("Height", "NetHeight", "GrossHeight",
            "Net Height", "Gross Height", "StoreyHeight", "Storey Height", "FloorHeight", "Floor Height"));

    protected static String elevationFromStorey(IfcBuildingStorey storey)
    {
        float elevation = (float)storey.getElevation();
        String elevationStr = storey.getElevationAsString();
        if ((elevationStr == null) || !elevationStr.equals(COBieUtility.COBieNA))
        {
            elevationStr = String.valueOf(elevation);
        }
        return elevationStr;
    }

    private static String extObjectFromBuildingStorey(IfcBuildingStorey storey)
    {
        String extObject = IfcToFloor.extObject;
        if (!COBieUtility.isNA(storey.getObjectType()))
        {
            String objectType = storey.getObjectType();
            if (objectType.equalsIgnoreCase(SITE) || objectType.equalsIgnoreCase(IFC_SITE))
            {
                extObject = IFC_SITE;
            }

        }
        return extObject;
    }

    protected static ArrayList<IfcBuildingStorey> floorsFromBuilding(IfcBuilding bldg)
    {
        ArrayList<IfcBuildingStorey> floors = new ArrayList<IfcBuildingStorey>();
        ArrayList<String> floorGuids = new ArrayList<String>();
        for (IfcRelDecomposes relDec : bldg.getIsDecomposedBy())
        {
            for (IfcObjectDefinition objDef : relDec.getRelatedObjects())
            {
                if (objDef.getClass() == IfcBuildingStoreyImpl.class)
                {
                    IfcBuildingStorey storey = (IfcBuildingStorey)objDef;
                    String guid = storey.getGlobalId();
                    if (!floorGuids.contains(guid))
                    {
                        floors.add(storey);
                        floorGuids.add(guid);
                    }
                }
            }
        }
        /*
         * Collections.sort(floors,new Comparator() { protected int
         * compare(Object o1,Object o2) { IfcBuildingStorey s1 =
         * (IfcBuildingStorey) o1; IfcBuildingStorey s2 = (IfcBuildingStorey)
         * o2; float e1 = s1.getElevation(); float e2 = s2.getElevation(); if
         * (e2>e1) return -1; else if (e2<e1) return 1; else return 0; }
         * 
         * });
         */

        return floors;
    }

    protected static ArrayList<String> getHeightPropertyNameMatches()
    {
        return heightPropertyNames;
    }

    protected static String heightFromStorey(IfcBuildingStorey storey)
    {
        String height = COBieUtility.COBieNA;
        Map<String, String> properties = new HashMap<String, String>();
        ArrayList<String> names = getHeightPropertyNameMatches();
        for (IfcRelDefines def : storey.getIsDefinedBy())
        {
            properties = IfcRelationshipsToCOBie.propertyStringsFromRelDefines(def, names);
        }
        for (String key : properties.keySet())
        {
            if (COBieUtility.isNA(height))
            {
                height = properties.get(key);
            }
        }
        return height;
    }

    public static String nameFromBuildingStorey(IfcBuildingStorey storey)
    {
        return COBieUtility.getCOBieString(storey.getName());
    }

    public static COBIEType writeFloorsToCOBie(COBIEType cType, IfcModelInterface model)
    {
        LogHandler loggerHandler = new LogHandler(sheetName, LOGGER);
        loggerHandler.sheetWriteBegin();
        for (IfcBuilding bldg : model.getAll(IfcBuilding.class))
        {
            COBIEType.Floors floors = cType.addNewFloors();
            ArrayList<IfcBuildingStorey> storeys = IfcToFloor.floorsFromBuilding(bldg);
            String name = "";
            String createdBy = "";
            Calendar createdOn;
            String category = "";
            String extSystem = "";
            String extObject = "";
            String extIdentifier = "";
            String description = "";
            String elevation;
            String height = "";
            for (IfcBuildingStorey storey : storeys)
            {
                try
                {

                    IfcOwnerHistory ownerHistory = storey.getOwnerHistory();
                    name = IfcToFloor.nameFromBuildingStorey(storey);
                    createdBy = COBieIfcUtility.getEmailFromOwnerHistory(ownerHistory);
                    createdOn = IfcToContact.getCreatedOn(ownerHistory.getCreationDate());
                    category = COBieIfcUtility.getObjectClassificationCategoryString(storey);
                    extSystem = COBieIfcUtility.getApplicationName(ownerHistory);
                    extObject = extObjectFromBuildingStorey(storey);
                    extIdentifier = COBieIfcUtility.extIdFromRoot(storey);
                    description = IfcToFacility.descriptionFromSpatialStructureElement(storey);
                    elevation = COBieUtility.getCOBieString(IfcToFloor.elevationFromStorey(storey));
                    height = IfcToFloor.heightFromStorey(storey);

                    FloorType tmpFloor = floors.addNewFloor();
                    tmpFloor.setName(name);
                    tmpFloor.setCreatedBy(createdBy);
                    tmpFloor.setCreatedOn(createdOn);
                    tmpFloor.setCategory(category);
                    tmpFloor.setExtSystem(extSystem);
                    tmpFloor.setExtObject(extObject);
                    tmpFloor.setExtIdentifier(extIdentifier);
                    tmpFloor.setDescription(description);
                    tmpFloor.setElevation(elevation);
                    tmpFloor.setHeight(height);
                    loggerHandler.rowWritten();
                } catch (Exception ex)
                {
                    loggerHandler.error(ex);
                }

            }
        }
        loggerHandler.sheetWritten();
        return cType;
    }
}
