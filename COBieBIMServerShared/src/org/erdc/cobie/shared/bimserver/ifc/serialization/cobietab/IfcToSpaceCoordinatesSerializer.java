/*
 * 
 */
package org.erdc.cobie.shared.bimserver.ifc.serialization.cobietab;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.bimserver.COBieIfcUtility;
import org.erdc.cobie.shared.bimserver.ifc.serialization.IfcCOBieSerializer;
import org.erdc.cobie.shared.bimserver.ifc.serialization.RectangleCoordinatesCalculator;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.COBIEType.Coordinates;
import org.erdc.cobie.sheetxmldata.CoordinateType;

public class IfcToSpaceCoordinatesSerializer extends IfcCOBieSerializer<CoordinateType, COBIEType.Coordinates, IfcSpace>
{

    private enum CoordinateCategory
    {
        upperright, lowerleft, point
    }

    private static final String COORDINATE_FORMAT_STRING = "%.3f%n";
    private static final String CATEGORY_UPPERRIGHT = "box-upperright";
    private static final String CATEGORY_LOWERLEFT = "box-lowerleft";
    private static final String CATEGORY_POINT = "point";;
    private static final int THREE_D_DIMENSION_COUNT = 3;

    public IfcToSpaceCoordinatesSerializer(Coordinates cobieSection, IfcModelInterface model)
    {
        super(cobieSection, model);
    }

    @Override
    protected List<IfcSpace> getTopLevelModelObjects()
    {
        return model.getAll(IfcSpace.class);
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

    private CoordinateType newSpaceCoordinate(CoordinateCategory coordinateCategory, Vector<Double> pointVector, IfcSpace ifcSpace)
    {
        CoordinateType newCoordinate = cobieSection.addNewCoordinate();
        String createdBy = COBieIfcUtility.getEmailFromOwnerHistory(ifcSpace.getOwnerHistory());
        Calendar createdOn = IfcToContact.getCreatedOn(ifcSpace.getOwnerHistory().getCreationDate());
        String category = COBieUtility.COBieNA;
        switch (coordinateCategory)
        {
            case lowerleft:
                category = CATEGORY_LOWERLEFT;
                break;
            case upperright:
                category = CATEGORY_UPPERRIGHT;
                break;
            case point:
                category = CATEGORY_POINT;
                break;

        }
        String name = getCoordinateName(ifcSpace, category);
        String sheetName = COBieUtility.CobieSheetName.Space.name();
        String rowName = IfcToSpace.nameFromSpace(ifcSpace);
        String coordinateXAxis = COBieUtility.COBieNA;
        String coordinateYAxis = COBieUtility.COBieNA;
        String coordinateZAxis = COBieUtility.COBieNA;
        if ((pointVector != null) && (pointVector.size() == THREE_D_DIMENSION_COUNT))
        {
            coordinateXAxis = String.format(COBieUtility.LOCALE, COORDINATE_FORMAT_STRING, pointVector.get(0));
            coordinateYAxis = String.format(COBieUtility.LOCALE, COORDINATE_FORMAT_STRING, pointVector.get(1));
            coordinateZAxis = String.format(COBieUtility.LOCALE, COORDINATE_FORMAT_STRING, pointVector.get(2));
        }
        String extSystem = COBieIfcUtility.getApplicationName(ifcSpace.getOwnerHistory());
        String extObject = COBieIfcUtility.extObjectFromObjectDef(ifcSpace);
        String extId = COBieIfcUtility.extIdFromRoot(ifcSpace);
        String clockWiseRotation = COBieUtility.COBieNA;
        String elevationRotation = COBieUtility.COBieNA;
        String yawRotation = COBieUtility.COBieNA;

        initializeCoordinate(newCoordinate, name, createdBy, createdOn, category, sheetName, rowName, coordinateXAxis, coordinateYAxis,
                coordinateZAxis, extSystem, extObject, extId, clockWiseRotation, elevationRotation, yawRotation);
        return newCoordinate;
    }

    private String getCoordinateName(IfcSpace ifcSpace, String category)
    {
        return IfcToSpace.nameFromSpace(ifcSpace) + "-" + category;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.bimserver.cobie.utils.serializer.IfcCOBieSerializer#serializeModelObject
     * (org.bimserver.emf.IdEObject)
     */
    @Override
    protected List<CoordinateType> serializeModelObject(IfcSpace modelObject)
    {
        List<CoordinateType> coordinatesWritten = new ArrayList<CoordinateType>();
        if (modelObject.isSetRepresentation())
        {

            RectangleCoordinatesCalculator coordinatesCalculator = new RectangleCoordinatesCalculator(modelObject);

            if (coordinatesCalculator.lowerLeftUpperRightExist())
            {
                try
                {
                    coordinatesWritten
                            .add(newSpaceCoordinate(CoordinateCategory.upperright, coordinatesCalculator.getUpperRightVector(), modelObject));
                    coordinatesWritten.add(newSpaceCoordinate(CoordinateCategory.lowerleft, coordinatesCalculator.getLowerLeftVector(), modelObject));

                    /*
                     * if(modelObject.isSetObjectPlacement() &&
                     * modelObject.getObjectPlacement() instanceof
                     * IfcLocalPlacement) { IfcLocalPlacement localPlacement =
                     * (IfcLocalPlacement) modelObject.getObjectPlacement();
                     * if(localPlacement.getRelativePlacement()!=null &&
                     * localPlacement.getRelativePlacement() instanceof
                     * IfcAxis2Placement3D) { IfcAxis2Placement3D placement3D =
                     * (IfcAxis2Placement3D)
                     * localPlacement.getRelativePlacement(); Vector<Double>
                     * placementVector =
                     * vectorFromCartesianPoint(placement3D.getLocation());
                     * coordinatesWritten.add
                     * (newCoordinate(CoordinateCategory.point
                     * ,placementVector,modelObject));
                     * 
                     * } }
                     */
                } catch (Exception ex)
                {

                }
            }

        }
        return coordinatesWritten;
    }

}
