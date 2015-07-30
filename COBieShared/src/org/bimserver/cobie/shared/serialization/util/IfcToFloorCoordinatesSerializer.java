package org.bimserver.cobie.shared.serialization.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers.GeometryHandler;
import org.bimserver.cobie.shared.serialization.IfcCOBieSerializer;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.COBIEType.Coordinates;
import org.nibs.cobie.tab.CoordinateType;

public class IfcToFloorCoordinatesSerializer extends IfcCOBieSerializer<CoordinateType, COBIEType.Coordinates, IfcBuildingStorey>
{
    private static final String COORDINATE_FORMAT_STRING = "%.3f%n";
    private static final int THREE_D_DIMENSIONS = 3;
    private static final String CATEGORY_POINT = "point";

    public IfcToFloorCoordinatesSerializer(Coordinates cobieSection, IfcModelInterface model)
    {
        super(cobieSection, model);
    }

    @Override
    protected List<IfcBuildingStorey> getTopLevelModelObjects()
    {
        return model.getAll(IfcBuildingStorey.class);
    }

    private void initializeCoordinate(
            CoordinateType newCoordinate,
            String name,
            String createdBy,
            Calendar createdOn,
            String category,
            String sheetName,
            String rowName,
            String coordinateXAxis,
            String coordinateYAxis,
            String coordinateZAxis,
            String extSystem,
            String extObject,
            String extId,
            String clockWiseRotation,
            String elevationRotation,
            String yawRotation)
    {
        newCoordinate.setName(name);
        newCoordinate.setCreatedBy(createdBy);
        newCoordinate.setCreatedOn(createdOn);
        newCoordinate.setCategory(category);
        newCoordinate.setSheetName(sheetName);
        newCoordinate.setRowName(rowName);
        newCoordinate.setCoordinateXAxis(coordinateXAxis);
        newCoordinate.setCoordinateYAxis(coordinateYAxis);
        newCoordinate.setCoordinateZAxis(coordinateZAxis);
        newCoordinate.setExtSystem(extSystem);
        newCoordinate.setExtObject(extObject);
        newCoordinate.setExtIdentifier(extId);
        newCoordinate.setClockwiseRotation(clockWiseRotation);
        newCoordinate.setElevationalRotation(elevationRotation);
        newCoordinate.setYawRotation(yawRotation);
    }

    private CoordinateType newFloorCoordinate(Vector<Double> pointVector, IfcBuildingStorey ifcBuildingStorey)
    {
        CoordinateType newCoordinate = cobieSection.addNewCoordinate();
        String name = IfcToFloor.nameFromBuildingStorey(ifcBuildingStorey);
        String createdBy = COBieIfcUtility.getEmailFromOwnerHistory(ifcBuildingStorey.getOwnerHistory());
        Calendar createdOn = IfcToContact.getCreatedOn(ifcBuildingStorey.getOwnerHistory().getCreationDate());
        String category = CATEGORY_POINT;

        String sheetName = COBieUtility.CobieSheetName.Floor.name();
        String rowName = name;
        String coordinateXAxis = COBieUtility.COBieNA;
        String coordinateYAxis = COBieUtility.COBieNA;
        String coordinateZAxis = COBieUtility.COBieNA;
        if ((pointVector != null) && (pointVector.size() == THREE_D_DIMENSIONS))
        {
            coordinateXAxis = String.format(COBieUtility.LOCALE, COORDINATE_FORMAT_STRING, pointVector.get(0));
            coordinateYAxis = String.format(COBieUtility.LOCALE, COORDINATE_FORMAT_STRING, pointVector.get(1));
            coordinateZAxis = String.format(COBieUtility.LOCALE, COORDINATE_FORMAT_STRING, pointVector.get(2));
        }
        String extSystem = COBieIfcUtility.getApplicationName(ifcBuildingStorey.getOwnerHistory());
        String extObject = COBieIfcUtility.extObjectFromObjectDef(ifcBuildingStorey);
        String extId = COBieIfcUtility.extIdFromRoot(ifcBuildingStorey);
        String clockWiseRotation = COBieUtility.COBieNA;
        String elevationRotation = COBieUtility.COBieNA;
        String yawRotation = COBieUtility.COBieNA;

        initializeCoordinate(newCoordinate, name, createdBy, createdOn, category, sheetName, rowName, coordinateXAxis, coordinateYAxis,
                coordinateZAxis, extSystem, extObject, extId, clockWiseRotation, elevationRotation, yawRotation);
        return newCoordinate;
    }

    @Override
    protected List<CoordinateType> serializeModelObject(IfcBuildingStorey modelObject)
    {
        List<CoordinateType> coordinatesWritten = new ArrayList<CoordinateType>();
        if (modelObject.isSetObjectPlacement())
        {
            if (modelObject.getObjectPlacement() instanceof IfcLocalPlacement)
            {
                Vector<Double> pointVector = GeometryHandler.vectorFromLocalPlacement((IfcLocalPlacement)modelObject.getObjectPlacement());
                coordinatesWritten.add(newFloorCoordinate(pointVector, modelObject));
            }

        }
        return coordinatesWritten;
    }

}
