package org.erdc.cobie.shared.bimserver.cobietab.deserialization;

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
import java.util.List;

import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcClassification;
import org.bimserver.models.ifc2x3tc1.IfcClassificationReference;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3tc1.IfcLengthMeasure;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcQuantityLength;
import org.bimserver.models.ifc2x3tc1.IfcRelAggregates;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.bimserver.cobietab.deserialization.modelhandlers.ClassificationHandler;
import org.erdc.cobie.shared.bimserver.cobietab.deserialization.modelhandlers.IfcCommonHandler;
import org.erdc.cobie.shared.bimserver.cobietab.deserialization.modelhandlers.PropertySetHandler;
import org.erdc.cobie.shared.bimserver.deserialization.DeserializerStaticStrings;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.FloorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FloorDeserializer
{
    private static final String ERROR_PREFIX_LOCAL_PLACEMENT = "An error occured while attempting to initialize the local placement of floor ";
    private static final Logger LOGGER = LoggerFactory.getLogger(FloorDeserializer.class);

    public static IfcClassification classificationFromFloor(FloorType floor)
    {
        IfcClassification classification = Ifc2x3tc1Factory.eINSTANCE.createIfcClassification();
        String category = floor.getCategory();
        if (!COBieUtility.isNA(category))
        {
            classification.setName(floor.getCategory());
            return classification;
        } else
        {
            return null;
        }
    }

    public static float elevationFromFloor(FloorType floor) throws Exception
    {
        float elevation;
        try
        {
            elevation = Float.parseFloat(floor.getElevation());
        } catch (Exception e)
        {
            throw e;
        }
        return elevation;
    }

    public static IfcQuantityLength quantityLengthFromFloor(FloorType floor) throws Exception
    {
        IfcQuantityLength quanLength = Ifc2x3tc1Factory.eINSTANCE.createIfcQuantityLength();
        try
        {
            quanLength.setLengthValue(Float.parseFloat(floor.getHeight()));
        } catch (Exception e)
        {
            throw e;
        }
        return quanLength;
    }

    public static IfcLengthMeasure storeyHeightFromFloor(FloorType floor)
    {
        IfcLengthMeasure lMeasure = Ifc2x3tc1Factory.eINSTANCE.createIfcLengthMeasure();
        float height;
        try
        {
            height = Float.parseFloat(floor.getHeight());
            lMeasure.setWrappedValue(height);
        } catch (Exception e)
        {
            height = 0;
        }
        return lMeasure;
    }

    private COBieIfcModel model;
    private COBIEType.Floors floors;

    private IfcCommonHandler ifcCommonHandler;

    public FloorDeserializer(COBieIfcModel cobieIfcModel, COBIEType.Floors floors, IfcCommonHandler ifcCommonHandler)
    {
        model = cobieIfcModel;
        this.floors = floors;
        this.ifcCommonHandler = ifcCommonHandler;
    }

    public IfcBuildingStorey buildingStoreyFromFloor(FloorType floor)
    {
        IfcBuildingStorey buildingStorey = Ifc2x3tc1Factory.eINSTANCE.createIfcBuildingStorey();
        buildingStorey.setName(floor.getName());
        buildingStorey.setDescription(floor.getDescription());
        setFloorLocalPlacement(buildingStorey, floor);
        try
        {
            float elevation = Float.parseFloat(floor.getElevation());
            buildingStorey.setElevation(elevation);
        } catch (NumberFormatException e)
        {
            buildingStorey.setElevationAsString(COBieUtility.COBieNA);
        }
        return buildingStorey;
    }

    public List<IfcClassificationReference> classificationReferencesFromFloor(FloorType floor) throws IfcModelInterfaceException
    {
        return ifcCommonHandler.getClassificationHandler().classificationReferencesFromString(floor.getCategory());
    }

    public void deserializeFloors()
    {

        long tmpOid;
        String name = "";
        String createdBy;
        String externalId;
        Calendar createdOn;
        String category;
        try
        {

            if (floors != null)
            {
                for (FloorType floor : floors.getFloorArray())
                {
                    name = floor.getName();
                    if (!model.containsFloor(name))
                    {
                        category = floor.getCategory();
                        createdBy = floor.getCreatedBy();
                        externalId = floor.getExtIdentifier();
                        createdOn = floor.getCreatedOn();
                        IfcOwnerHistory ownerHistory = ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(
                                createdBy, createdOn, floor.getExtSystem());
                        IfcBuildingStorey buildingStorey = buildingStoreyFromFloor(floor);
                        buildingStorey.setOwnerHistory(ownerHistory);
                        IfcGloballyUniqueId guid = ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(externalId);
                        buildingStorey.setGlobalId(guid.getWrappedValue());
                        String objectType = ClassificationHandler.objectTypeFromCategoryString(category);
                        if (!COBieUtility.isNA(objectType))
                        {
                            buildingStorey.setObjectType(objectType);
                        }
                        IfcPropertySet psetHeight = PropertySetHandler.heightPropertySetFromFloor(floor);
                        ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToObject(buildingStorey, psetHeight, true);

                        List<IfcClassificationReference> classifications = classificationReferencesFromFloor(floor);

                        tmpOid = model.add(buildingStorey, ifcCommonHandler.getOidProvider());
                        buildingStorey = (IfcBuildingStorey)model.get(tmpOid);
                        for (IfcClassificationReference classification : classifications)
                        {
                            ifcCommonHandler.getClassificationHandler().addClassificationReferenceToObject(classification, buildingStorey);
                        }

                    }
                }
                setFacilityAggregates();
            }

        } catch (Exception e)
        {
            LOGGER.error("Error deserializing Floor " + name + "..." + e.getMessage());
        }

    }

    private void setFacilityAggregates() throws IfcModelInterfaceException
    {
        if (model.getFloorCount() > 0)
        {
            IfcBuilding building = model.getFirstFacility();
            ArrayList<IfcBuildingStorey> storeys = new ArrayList<IfcBuildingStorey>();
            for (String floorName : model.getFloorNames())
            {
                storeys.add(model.getFloorByName(floorName));
            }
            IfcRelAggregates aggregatesBuilding = Ifc2x3tc1Factory.eINSTANCE.createIfcRelAggregates();
            aggregatesBuilding.setName(DeserializerStaticStrings.getBuildingRelAggregatesName());
            aggregatesBuilding.setDescription(DeserializerStaticStrings.getBuildingRelAggregatesDescription());
            aggregatesBuilding.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().DefaultOwnerHistory());
            aggregatesBuilding.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid().getWrappedValue());
            aggregatesBuilding.setRelatingObject(building);
            for (IfcBuildingStorey floor : storeys)
            {
                aggregatesBuilding.getRelatedObjects().add(floor);
            }
            model.add(aggregatesBuilding, ifcCommonHandler.getOidProvider());
        }
    }

    private void setFloorLocalPlacement(IfcBuildingStorey buildingStorey, FloorType floor)
    {
        try
        {
            IfcLocalPlacement buildingPlacement = (IfcLocalPlacement)model.getFirstFacility().getObjectPlacement();
            IfcLocalPlacement floorPlacement = ifcCommonHandler.getGeometryHandler().newFloorLocalPlacement(floor, buildingPlacement);
            buildingStorey.setObjectPlacement(floorPlacement);
        } catch (Exception ex)
        {
            LOGGER.error(ERROR_PREFIX_LOCAL_PLACEMENT + buildingStorey.getName());
        }
    }

}
