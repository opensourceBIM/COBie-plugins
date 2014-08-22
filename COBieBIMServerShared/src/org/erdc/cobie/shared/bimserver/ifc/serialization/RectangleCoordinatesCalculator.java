package org.erdc.cobie.shared.bimserver.ifc.serialization;

import java.util.Vector;

import org.bimserver.models.ifc2x3tc1.IfcBoundingBox;
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.ifc2x3tc1.IfcExtrudedAreaSolid;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.bimserver.models.ifc2x3tc1.IfcObjectPlacement;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProductDefinitionShape;
import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRectangleProfileDef;
import org.bimserver.models.ifc2x3tc1.IfcRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationItem;
import org.bimserver.models.ifc2x3tc1.IfcSweptAreaSolid;
import org.erdc.cobie.shared.bimserver.cobietab.deserialization.modelhandlers.GeometryHandler;

public class RectangleCoordinatesCalculator
{
    public enum RectangleCoordinateSourceEnum
    {
        boundingbox, sweptareasolid
    }

    public static final int THREE_D_DIMENSION_COUNT = 3;;
    private Vector<Double> boundingBoxVector;
    private Vector<Double> extrudedAreaSolidVector;
    private IfcProduct ifcProduct;
    private Vector<Double> locationVector;
    private RectangleCoordinateSourceEnum rectangleCoordinateSource;
    private Vector<Double> rectangleProfilePositionVector;
    private Vector<Double> lowerLeftVector;
    private Vector<Double> upperRightVector;

    public RectangleCoordinatesCalculator(IfcProduct ifcProduct)
    {
        init();
        setIfcProduct(ifcProduct);
        setLocationVector(locationVectorFromProduct(ifcProduct));
        setAllShapeVectors();
        if (rectangleCoordinateSource != null)
        {
            calculateLowerLeftVector();
            calculateUpperRightVector();
        } else
        {
            setLowerLeftVector(new Vector<Double>());
            setUpperRightVector(new Vector<Double>());
        }
    }

    private Vector<Double> boundingBoxPointVectorFromRepresentationItem(IfcRepresentationItem repItem)
    {
        Vector<Double> representationPoint = new Vector<Double>();
        double x;
        double y;
        double z;
        IfcBoundingBox boundingBox = (IfcBoundingBox)repItem;
        x = boundingBox.getXDim();
        y = boundingBox.getYDim();
        z = boundingBox.getZDim();
        representationPoint.add(x);
        representationPoint.add(y);
        representationPoint.add(z);
        return representationPoint;
    }

    private Vector<Double> calculateBoundingBoxLowerLeft()
    {
        return locationVector;
    }

    private Vector<Double> calculateBoundingBoxUpperRight()
    {
        Vector<Double> upperRight = new Vector<Double>();
        for (int i = 0; i < locationVector.size(); i++)
        {
            upperRight.add(locationVector.get(i));
        }
        for (int i = 0; i < boundingBoxVector.size(); i++)
        {
            if (i > (upperRight.size() - 1))
            {
                upperRight.add(boundingBoxVector.get(i));
            } else
            {
                upperRight.set(i, upperRight.get(i) + boundingBoxVector.get(i));
            }
        }
        return upperRight;
    }

    private void calculateLowerLeftVector()
    {
        Vector<Double> lowerLeftVector = new Vector<Double>();
        if (rectangleCoordinateSource != null)
        {
            switch (rectangleCoordinateSource)
            {
                case boundingbox:
                    lowerLeftVector = calculateBoundingBoxLowerLeft();
                    break;
                case sweptareasolid:
                    lowerLeftVector = calculateSweptAreaSolidLowerLeft();
                    break;
            }
        }
        setLowerLeftVector(lowerLeftVector);
    }

    private Vector<Double> calculateSweptAreaSolidLowerLeft()
    {
        Vector<Double> lowerLeft = new Vector<Double>();
        for (int i = 0; i < locationVector.size(); i++)
        {
            lowerLeft.add(locationVector.get(i));
        }

        // iterate through x and y coordinates, skip z b/c it is only location +
        // position z
        for (int i = 0; (i < extrudedAreaSolidVector.size()) && (i < (THREE_D_DIMENSION_COUNT - 1)); i++)
        {
            if (i > (lowerLeft.size() - 1))
            {
                lowerLeft.add(extrudedAreaSolidVector.get(i));
            } else
            {
                lowerLeft.set(i, lowerLeft.get(i) + extrudedAreaSolidVector.get(i));
            }
        }
        for (int i = 0; i < rectangleProfilePositionVector.size(); i++)
        {
            if (i > (lowerLeft.size() - 1))
            {
                lowerLeft.add(rectangleProfilePositionVector.get(i));
            } else
            {
                lowerLeft.set(i, lowerLeft.get(i) + rectangleProfilePositionVector.get(i));
            }
        }
        return lowerLeft;
    }

    private Vector<Double> calculateSweptAreaSolidUpperRight()
    {
        Vector<Double> upperRight = new Vector<Double>();
        for (int i = 0; i < locationVector.size(); i++)
        {
            upperRight.add(locationVector.get(i));
        }
        for (int i = 0; i < extrudedAreaSolidVector.size(); i++)
        {
            if (i > (upperRight.size() - 1))
            {
                upperRight.add(extrudedAreaSolidVector.get(i));
            } else
            {
                upperRight.set(i, upperRight.get(i) + extrudedAreaSolidVector.get(i));
            }
        }
        for (int i = 0; i < rectangleProfilePositionVector.size(); i++)
        {
            if (i > (upperRight.size() - 1))
            {
                upperRight.add(rectangleProfilePositionVector.get(i));
            } else
            {
                upperRight.set(i, upperRight.get(i) + rectangleProfilePositionVector.get(i));
            }
        }
        return upperRight;
    }

    private void calculateUpperRightVector()
    {
        Vector<Double> upperRightVector = new Vector<Double>();
        switch (rectangleCoordinateSource)
        {
            case boundingbox:
                upperRightVector = calculateBoundingBoxUpperRight();
                break;
            case sweptareasolid:
                upperRightVector = calculateSweptAreaSolidUpperRight();

        }
        setUpperRightVector(upperRightVector);
    }

    public Vector<Double> getBoundingBoxVector()
    {
        return boundingBoxVector;
    }

    public Vector<Double> getExtrudedAreaSolidVector()
    {
        return extrudedAreaSolidVector;
    }

    public IfcProduct getIfcProduct()
    {
        return ifcProduct;
    }

    public Vector<Double> getLocationVector()
    {
        return locationVector;
    }

    public Vector<Double> getLowerLeftVector()
    {
        return lowerLeftVector;
    }

    public RectangleCoordinateSourceEnum getRectangleCoordinateSource()
    {
        return rectangleCoordinateSource;
    }

    public Vector<Double> getRectangleProfilePositionVector()
    {
        return rectangleProfilePositionVector;
    }

    private Vector<Double> getSweptAreaSolidVector(IfcSweptAreaSolid sweptAreaSolid, IfcRectangleProfileDef rectangleProfile)
    {
        Vector<Double> representationPoint = new Vector<Double>();
        double x;
        double y;
        double z;
        x = rectangleProfile.getXDim();
        y = rectangleProfile.getYDim();
        representationPoint.add(x);
        representationPoint.add(y);
        if (sweptAreaSolid instanceof IfcExtrudedAreaSolid)
        {
            z = ((IfcExtrudedAreaSolid)sweptAreaSolid).getDepth();
            representationPoint.add(z);
        }
        return representationPoint;
    }

    public Vector<Double> getUpperRightVector()
    {
        return upperRightVector;
    }

    private void init()
    {
        boundingBoxVector = new Vector<Double>();
        extrudedAreaSolidVector = new Vector<Double>();
        locationVector = new Vector<Double>();
        rectangleProfilePositionVector = new Vector<Double>();
    }

    public Vector<Double> locationVectorFromProduct(IfcProduct product)
    {
        Vector<Double> placementPoint = new Vector<Double>();
        if (product.isSetObjectPlacement())
        {
            IfcObjectPlacement objectPlacement = product.getObjectPlacement();
            if (objectPlacement instanceof IfcLocalPlacement)
            {
                IfcLocalPlacement localPlacement = (IfcLocalPlacement)objectPlacement;
                placementPoint = GeometryHandler.vectorFromLocalPlacement(localPlacement);
            }

        }
        return placementPoint;
    }

    public boolean lowerLeftUpperRightExist()
    {
        return ((lowerLeftVector.size() == THREE_D_DIMENSION_COUNT) && (upperRightVector.size() == THREE_D_DIMENSION_COUNT));
    }

    private Vector<Double> positionVectorFromRectangleProfile(IfcRectangleProfileDef rectangleProfile)
    {
        IfcCartesianPoint positionPoint = rectangleProfile.getPosition().getLocation();
        Vector<Double> positionVector = new Vector<Double>();
        for (double point : positionPoint.getCoordinates())
        {
            positionVector.add(point);
        }
        return positionVector;
    }

    private void setAllShapeVectors()
    {
        new Vector<Double>();

        IfcProductRepresentation productRepresentation = ifcProduct.getRepresentation();
        if (productRepresentation instanceof IfcProductDefinitionShape)
        {
            IfcProductDefinitionShape definitionShape = (IfcProductDefinitionShape)productRepresentation;
            setVectorsFromProductDefinitionShape(definitionShape);
        }
    }

    private void setBoundingBoxVector(Vector<Double> boundingBoxVector)
    {
        this.boundingBoxVector = boundingBoxVector;
    }

    private void setExtrudedAreaSolidVector(Vector<Double> extrudedAreaSolidVector)
    {
        this.extrudedAreaSolidVector = extrudedAreaSolidVector;
    }

    private void setIfcProduct(IfcProduct ifcProduct)
    {
        this.ifcProduct = ifcProduct;
    }

    private void setLocationVector(Vector<Double> locationVector)
    {
        this.locationVector = locationVector;
    }

    private void setLowerLeftVector(Vector<Double> lowerLeftVector)
    {
        this.lowerLeftVector = lowerLeftVector;
    }

    private void setRectangleCoordinateSource(RectangleCoordinateSourceEnum rectangleCoordinateSource)
    {
        this.rectangleCoordinateSource = rectangleCoordinateSource;
    }

    private void setRectangleProfilePositionVector(Vector<Double> rectangleProfilePositionVector)
    {
        this.rectangleProfilePositionVector = rectangleProfilePositionVector;
    }

    private void setUpperRightVector(Vector<Double> upperRightVector)
    {
        this.upperRightVector = upperRightVector;
    }

    private void setVectorsFromProductDefinitionShape(IfcProductDefinitionShape definitionShape)
    {
        boolean foundFirstShapeRepresentation = false;
        for (IfcRepresentation rep : definitionShape.getRepresentations())
        {
            for (IfcRepresentationItem repItem : rep.getItems())
            {

                if ((repItem instanceof IfcBoundingBox) && !foundFirstShapeRepresentation)
                {
                    foundFirstShapeRepresentation = true;
                    setBoundingBoxVector(boundingBoxPointVectorFromRepresentationItem(repItem));
                    setRectangleCoordinateSource(RectangleCoordinateSourceEnum.boundingbox);

                }
                if ((repItem instanceof IfcSweptAreaSolid) && !foundFirstShapeRepresentation)
                {

                    IfcSweptAreaSolid sweptAreaSolid = (IfcSweptAreaSolid)repItem;
                    if (sweptAreaSolid.getSweptArea() instanceof IfcRectangleProfileDef)
                    {
                        foundFirstShapeRepresentation = true;
                        setRectangleCoordinateSource(RectangleCoordinateSourceEnum.sweptareasolid);
                        IfcRectangleProfileDef rectangleProfile = (IfcRectangleProfileDef)sweptAreaSolid.getSweptArea();
                        setExtrudedAreaSolidVector(getSweptAreaSolidVector(sweptAreaSolid, rectangleProfile));
                        setRectangleProfilePositionVector(positionVectorFromRectangleProfile(rectangleProfile));
                    }
                }
            }
        }
    }
}
