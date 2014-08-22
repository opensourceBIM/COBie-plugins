package org.erdc.cobie.shared.bimserver.cobietab.deserialization.modelhandlers;

import java.util.Vector;

import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.OidProvider;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.ifc2x3tc1.IfcDirection;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.eclipse.emf.common.util.EList;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.bimserver.COBieIfcUtility;
import org.erdc.cobie.shared.bimserver.cobietab.deserialization.COBieIfcModel;
import org.erdc.cobie.shared.bimserver.ifc.serialization.RectangleCoordinatesCalculator;
import org.erdc.cobie.sheetxmldata.CoordinateType;
import org.erdc.cobie.sheetxmldata.FloorType;

public class GeometryHandler
{
    private static final double DEFAULT_REF_DIRECTION_Z = 0.0;
    private static final double DEFAULT_REF_DIRECTION_Y = 0.0;
    private static final double DEFAULT_REF_DIRECTION_X = 1.0;
    private static final double DEFAULT_AXIS_X = 0.0;
    private static final double DEFAULT_AXIS_Y = 0.0;
    private static final double DEFAULT_AXIS_Z = 1.0;
    private static final double COORDINATE_ORIGIN_DOUBLE = 0.0;

    public static Vector<Double> vectorFromCoordinate(CoordinateType coordinate)
    {
        Vector<Double> vector = new Vector<Double>();
        String x = coordinate.getCoordinateXAxis();
        String y = coordinate.getCoordinateYAxis();
        String z = coordinate.getCoordinateZAxis();
        double numX = 0, numY = 0, numZ = 0;
        if (!COBieUtility.isNA(x))
        {
            try
            {
                numX = Double.parseDouble(x);
            } catch (Exception ex)
            {

            }
        }
        if (!COBieUtility.isNA(y))
        {
            try
            {
                numY = Double.parseDouble(y);
            } catch (Exception ex)
            {

            }
        }
        if (!COBieUtility.isNA(z))
        {
            try
            {
                numZ = Double.parseDouble(z);
            } catch (Exception ex)
            {

            }
        }
        vector.add(numX);
        vector.add(numY);
        vector.add(numZ);
        return vector;
    }

    public static Vector<Double> vectorFromLocalPlacement(IfcLocalPlacement localPlacement)
    {
        Vector<Double> localPlacementVector = new Vector<Double>();
        if (localPlacement.getRelativePlacement() instanceof IfcAxis2Placement3D)
        {
            IfcAxis2Placement3D axisToPlacement = (IfcAxis2Placement3D)localPlacement.getRelativePlacement();
            EList<Double> localPlacementPoint = axisToPlacement.getLocation().getCoordinates();
            if (localPlacementPoint.size() == RectangleCoordinatesCalculator.THREE_D_DIMENSION_COUNT)
            {
                for (int i = 0; i < RectangleCoordinatesCalculator.THREE_D_DIMENSION_COUNT; i++)
                {
                    localPlacementVector.add(localPlacementPoint.get(i));
                }
                if (localPlacement.isSetPlacementRelTo() && (localPlacement.getPlacementRelTo() instanceof IfcLocalPlacement))
                {
                    Vector<Double> parentLocation = vectorFromLocalPlacement((IfcLocalPlacement)localPlacement.getPlacementRelTo());
                    for (int i = 0; (i < parentLocation.size()) && (i < localPlacementVector.size()); i++)
                    {
                        localPlacementVector.set(i, localPlacementVector.get(i) + parentLocation.get(i));
                    }

                }
            }
        }
        return localPlacementVector;
    }

    private IfcGuidHandler cobieGuidHandler;

    private OidProvider<Long> cobieOidProvider;
    private COBieIfcModel model;

    public GeometryHandler(OidProvider<Long> oidProvider, COBieIfcModel model, IfcGuidHandler guidHandler)
    {
        setCobieOidProvider(oidProvider);
        setModel(model);
        setCobieGuidHandler(guidHandler);
    }

    public IfcGuidHandler getCobieGuidHandler()
    {
        return cobieGuidHandler;
    }

    public OidProvider<Long> getCobieOidProvider()
    {
        return cobieOidProvider;
    }

    public IfcLocalPlacement getFloorLocalPlacement(String floorName)
    {
        IfcLocalPlacement localPlacement = null;
        try
        {
            IfcBuildingStorey bldgStorey = model.getFloorByName(floorName);
            if ((bldgStorey != null) && bldgStorey.isSetObjectPlacement())
            {
                localPlacement = (IfcLocalPlacement)bldgStorey.getObjectPlacement();
            }
        } catch (Exception ex)
        {

        }
        return localPlacement;
    }

    public COBieIfcModel getModel()
    {
        return model;
    }

    public IfcLocalPlacement getSpaceLocalPlacement(String spaceName)
    {
        IfcLocalPlacement localPlacement = null;
        String tmpSpaceName = spaceName;
        if (spaceName.contains(COBieUtility.getCOBieDelim()))
        {
            String[] splitString = spaceName.split(COBieUtility.getCOBieDelim());
            if (splitString.length > 0)
            {
                tmpSpaceName = splitString[0];
            }
        }
        try
        {
            IfcSpace space = model.getSpaceFromName(tmpSpaceName);
            if ((space != null) && space.isSetObjectPlacement())
            {
                localPlacement = (IfcLocalPlacement)space.getObjectPlacement();
            }
        } catch (Exception ex)
        {

        }
        return localPlacement;
    }

    public IfcCartesianPoint newCartesianPointOrigin() throws IfcModelInterfaceException
    {
        IfcCartesianPoint cartesianPoint = COBieIfcUtility.ifcFactory.createIfcCartesianPoint();
        cartesianPoint.getCoordinates().add(COORDINATE_ORIGIN_DOUBLE);
        cartesianPoint.getCoordinates().add(COORDINATE_ORIGIN_DOUBLE);
        cartesianPoint.getCoordinates().add(COORDINATE_ORIGIN_DOUBLE);
        model.add(cartesianPoint, cobieOidProvider);
        return cartesianPoint;
    }

    public IfcDirection newDefaultDirectionAxis3D() throws IfcModelInterfaceException
    {
        IfcDirection direction = COBieIfcUtility.ifcFactory.createIfcDirection();
        direction.getDirectionRatios().add(DEFAULT_AXIS_X);
        direction.getDirectionRatios().add(DEFAULT_AXIS_Y);
        direction.getDirectionRatios().add(DEFAULT_AXIS_Z);
        model.add(direction, cobieOidProvider);
        return direction;
    }

    public IfcLocalPlacement newDefaultLocalPlacement(IfcLocalPlacement relativeTo) throws IfcModelInterfaceException
    {
        IfcLocalPlacement localPlacement = COBieIfcUtility.ifcFactory.createIfcLocalPlacement();
        localPlacement.setRelativePlacement(newDefaultPlacement3D());
        if (relativeTo != null)
        {
            localPlacement.setPlacementRelTo(relativeTo);
        }
        model.add(localPlacement, cobieOidProvider);
        return localPlacement;
    }

    public IfcAxis2Placement3D newDefaultPlacement3D() throws IfcModelInterfaceException
    {
        IfcAxis2Placement3D defaultAxis2Placement3D = COBieIfcUtility.ifcFactory.createIfcAxis2Placement3D();
        defaultAxis2Placement3D.setLocation(newCartesianPointOrigin());
        defaultAxis2Placement3D.setAxis(newDefaultDirectionAxis3D());
        defaultAxis2Placement3D.setRefDirection(newDefaultRefDirection3D());
        model.add(defaultAxis2Placement3D, cobieOidProvider);
        return defaultAxis2Placement3D;
    }

    public IfcDirection newDefaultRefDirection3D() throws IfcModelInterfaceException
    {
        IfcDirection direction = COBieIfcUtility.ifcFactory.createIfcDirection();
        direction.getDirectionRatios().add(DEFAULT_REF_DIRECTION_X);
        direction.getDirectionRatios().add(DEFAULT_REF_DIRECTION_Y);
        direction.getDirectionRatios().add(DEFAULT_REF_DIRECTION_Z);
        model.add(direction, cobieOidProvider);
        return direction;
    }

    public IfcLocalPlacement newFloorLocalPlacement(FloorType floor, IfcLocalPlacement relativeTo) throws IfcModelInterfaceException
    {
        IfcLocalPlacement localPlacement = COBieIfcUtility.ifcFactory.createIfcLocalPlacement();
        localPlacement.setRelativePlacement(placement3DFromFloor(floor));
        if (relativeTo != null)
        {
            localPlacement.setPlacementRelTo(relativeTo);
        }
        model.add(localPlacement, cobieOidProvider);
        return localPlacement;
    }

    public IfcAxis2Placement3D placement3DFromFloor(FloorType floor) throws IfcModelInterfaceException
    {
        IfcAxis2Placement3D placement = newDefaultPlacement3D();
        // placement.getLocation().getCoordinates().get(2) =
        try
        {
            placement.getLocation().getCoordinates().set(2, Double.parseDouble(floor.getHeight()));
        } catch (Exception ex)
        {

        }
        return placement;
    }

    private void setCobieGuidHandler(IfcGuidHandler cobieGuidHandler)
    {
        this.cobieGuidHandler = cobieGuidHandler;
    }

    private void setCobieOidProvider(OidProvider<Long> cobieOidProvider)
    {
        this.cobieOidProvider = cobieOidProvider;
    }

    private void setModel(COBieIfcModel model)
    {
        this.model = model;
    }

}
