package org.erdc.cobie.shared.bimserver.cobietab.deserialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement2D;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.ifc2x3tc1.IfcExtrudedAreaSolid;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.bimserver.models.ifc2x3tc1.IfcProductDefinitionShape;
import org.bimserver.models.ifc2x3tc1.IfcProfileTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcRectangleProfileDef;
import org.bimserver.models.ifc2x3tc1.IfcShapeRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.bimserver.COBieIfcUtility;
import org.erdc.cobie.shared.bimserver.cobietab.deserialization.modelhandlers.GeometryHandler;
import org.erdc.cobie.shared.bimserver.cobietab.deserialization.modelhandlers.IfcCommonHandler;
import org.erdc.cobie.shared.bimserver.cobietab.key.KeyedCoordinateType;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.COBIEType.Coordinates;
import org.erdc.cobie.sheetxmldata.CoordinateType;
import org.slf4j.LoggerFactory;

public class CoordinateDeserializer extends SimpleDeserializer<COBIEType.Coordinates, CoordinateType, IfcProductDefinitionShape>
{
    { LOGGER = LoggerFactory.getLogger(CoordinateDeserializer.class); }

    private enum CoordinateCategory
    {
        upperright, lowerleft
    }

    private static final IfcProfileTypeEnum RECTANGLE_PROFILE_DEF_DEFAULT_PROFILETYPE = IfcProfileTypeEnum.AREA;
    private static final int DEFAULT_SPACE_VECTOR_VALUE = 3000;
    private static final int THREE_D_DIMENSIONS = 3;
    private static final String REPRESENTATION_TYPE = "SweptSolid";

    private static final String REPRESENTATION_ID = "Body";;

    private static String productDefShapeNameFromKeyedCoordinate(KeyedCoordinateType coordinate)
    {
        String name = coordinate.getCOBieSheetXMLDataElementKey() + PRODUCT_DEFINITION_SHAPE_SUFFIX;
        return name;
    }

    private HashMap<KeyedCoordinateType, Vector<Double>> coordNameSheetRowToVector;

    private static final String PRODUCT_DEFINITION_SHAPE_SUFFIX = " geometry";

    public CoordinateDeserializer(IfcCommonHandler ifcCommonHandler, COBieIfcModel model, Coordinates cobieSheetXMLDataSection)
    {
        super(ifcCommonHandler, model, cobieSheetXMLDataSection);
        init();

    }

    @Override
    protected long writeIfcObject(IfcProductDefinitionShape ifcObject, CoordinateType cobieSheetXMLDataElement) throws IfcModelInterfaceException
    {
        KeyedCoordinateType keyedCoordinate = new KeyedCoordinateType(cobieSheetXMLDataElement);
        List<KeyedCoordinateType> matchingCoordinates = findCoordinateWithSameNameSheetRow(keyedCoordinate);
        List<CoordinateType> coordinates = new ArrayList<CoordinateType>();
        for (KeyedCoordinateType tempKeyedCoordinate : matchingCoordinates)
        {
            coordinates.add(tempKeyedCoordinate.getCOBieSheetXMLDataElement());
        }
        coordinates.add(keyedCoordinate.getCOBieSheetXMLDataElement());
        return getModel().addCoordinates(coordinates, ifcObject, getIfcCommonHandler().getOidProvider());
    }

    @Override
    protected boolean cobieSheetXMLDataElementIsInModel(CoordinateType cobieSheetXMLDataElement)
    {
        return getModel().containsCoordinate(cobieSheetXMLDataElement);
    }

    @Override
    protected Iterable<CoordinateType> cobieSheetXMLDataSectionIterableFromCOBieSheetXMLDataSection(Coordinates cobieSheetXMLDataSection)
    {
        return Arrays.asList(cobieSheetXMLDataSection.getCoordinateArray());
    }

    private CoordinateCategory coordinateCategoryFromString(String categoryString)
    {
        CoordinateCategory category = null;
        if (categoryString.toLowerCase().contains(CoordinateCategory.lowerleft.name()))
        {
            category = CoordinateCategory.lowerleft;
        } else if (categoryString.toLowerCase().contains(CoordinateCategory.upperright.name()))
        {
            category = CoordinateCategory.upperright;
        }
        return category;
    }

    private IfcExtrudedAreaSolid extrudedAreaSolidFromCoordinates(List<KeyedCoordinateType> coordinates) throws Exception
    {
        IfcExtrudedAreaSolid extrudedAreaSolid = null;
        KeyedCoordinateType lowerLeft = getLowerLeftCoordinate(coordinates);
        KeyedCoordinateType upperRight = getUpperRightCoordinate(coordinates);
        if ((lowerLeft == null) || (upperRight == null))
        {
            throw new Exception("Lower left and/or upper right points not found");
        } else
        {
            Vector<Double> lowerLeftVector = coordNameSheetRowToVector.get(lowerLeft);
            Vector<Double> upperRightVector = coordNameSheetRowToVector.get(upperRight);
            double xLowerLeft = 0, xUpperRight = 0, yLowerLeft = 0, yUpperRight = 0, zLowerLeft = 0, zUpperRight = 0;
            double dx, dy, dz;

            if ((lowerLeftVector.size() == THREE_D_DIMENSIONS) && (upperRightVector.size() == THREE_D_DIMENSIONS))
            {
                xLowerLeft = lowerLeftVector.get(0);
                yLowerLeft = lowerLeftVector.get(1);
                zLowerLeft = lowerLeftVector.get(2);

                xUpperRight = upperRightVector.get(0);
                yUpperRight = upperRightVector.get(1);
                zUpperRight = upperRightVector.get(2);
                dx = xUpperRight - xLowerLeft;
                dy = yUpperRight - yLowerLeft;
                dz = zUpperRight - zLowerLeft;
                double position2DPlacementX = DEFAULT_SPACE_VECTOR_VALUE;
                double position2DPlacementY = DEFAULT_SPACE_VECTOR_VALUE;
                double depth = DEFAULT_SPACE_VECTOR_VALUE;

                if (dx > 0)
                {
                    position2DPlacementX = dx;
                }
                if (dy > 0)
                {
                    position2DPlacementY = dy;
                }
                if (dz > 0)
                {
                    depth = dz;
                }
                extrudedAreaSolid = COBieIfcUtility.ifcFactory.createIfcExtrudedAreaSolid();

                IfcRectangleProfileDef rectangleProfileDef = COBieIfcUtility.ifcFactory.createIfcRectangleProfileDef();
                rectangleProfileDef.setProfileType(RECTANGLE_PROFILE_DEF_DEFAULT_PROFILETYPE);
                rectangleProfileDef.setXDim(position2DPlacementX);
                rectangleProfileDef.setYDim(position2DPlacementY);
                IfcAxis2Placement2D position2D = COBieIfcUtility.ifcFactory.createIfcAxis2Placement2D();
                IfcCartesianPoint point = COBieIfcUtility.ifcFactory.createIfcCartesianPoint();
                point.getCoordinates().add(position2DPlacementX / 2);
                point.getCoordinates().add(position2DPlacementY / 2);
                getModel().add(point, getIfcCommonHandler().getOidProvider());
                position2D.setLocation(point);
                position2D.setRefDirection(getIfcCommonHandler().getGeometryHandler().newDefaultRefDirection3D());
                getModel().add(position2D, getIfcCommonHandler().getOidProvider());
                rectangleProfileDef.setPosition(position2D);
                getModel().add(rectangleProfileDef, getIfcCommonHandler().getOidProvider());
                extrudedAreaSolid.setSweptArea(rectangleProfileDef);
                extrudedAreaSolid.setExtrudedDirection(getIfcCommonHandler().getGeometryHandler().newDefaultDirectionAxis3D());
                extrudedAreaSolid.setPosition(getIfcCommonHandler().getGeometryHandler().newDefaultPlacement3D());
                extrudedAreaSolid.setDepth(depth);

                getModel().add(extrudedAreaSolid, getIfcCommonHandler().getOidProvider());
            }

        }

        return extrudedAreaSolid;

    }

    private List<KeyedCoordinateType> findCoordinateWithSameNameSheetRow(KeyedCoordinateType coordinate)
    {
        List<KeyedCoordinateType> matchingCoordinates = new ArrayList<KeyedCoordinateType>();
        for (KeyedCoordinateType keyedCoordinate : coordNameSheetRowToVector.keySet())
        {
            if (!coordinate.getCOBieSheetXMLDataElementKey().equals(keyedCoordinate.getCOBieSheetXMLDataElementKey())
                    // The following line was in there and I have no idea
                    // why...keeping the comment for a revision or two
                    // &&
                    // coordinate.getCOBieSheetXMLDataElement().getName().equals(keyedCoordinate.getCOBieSheetXMLDataElement().getName())
                    && coordinate.getCOBieSheetXMLDataElement().getSheetName().equals(keyedCoordinate.getCOBieSheetXMLDataElement().getSheetName())
                    && coordinate.getCOBieSheetXMLDataElement().getRowName().equals(keyedCoordinate.getCOBieSheetXMLDataElement().getRowName()))
            {
                matchingCoordinates.add(keyedCoordinate);
            }
        }
        return matchingCoordinates;
    }

    public HashMap<KeyedCoordinateType, Vector<Double>> getCoordNameSheetRowToVector()
    {
        return coordNameSheetRowToVector;
    }

    private IfcProductDefinitionShape getInitialProductDefShape(KeyedCoordinateType keyedCoordinate)
    {
        IfcProductDefinitionShape productDefShape;
        productDefShape = COBieIfcUtility.ifcFactory.createIfcProductDefinitionShape();
        String nameDescription = productDefShapeNameFromKeyedCoordinate(keyedCoordinate);
        productDefShape.setName(nameDescription);
        productDefShape.setDescription(nameDescription);
        return productDefShape;
    }

    private IfcShapeRepresentation getInitialShaperepresentation()
    {
        IfcShapeRepresentation shapeRepresentation = COBieIfcUtility.ifcFactory.createIfcShapeRepresentation();
        List<IfcProject> ifcProjects = getModel().getAll(IfcProject.class);
        if ((ifcProjects.size() > 0) && (ifcProjects.get(0).getRepresentationContexts().size() > 0))
        {
            shapeRepresentation.setContextOfItems(ifcProjects.get(0).getRepresentationContexts().get(0));
        }
        shapeRepresentation.setRepresentationIdentifier(REPRESENTATION_ID);
        shapeRepresentation.setRepresentationType(REPRESENTATION_TYPE);
        return shapeRepresentation;
    }

    private KeyedCoordinateType getLowerLeftCoordinate(List<KeyedCoordinateType> coordinates)
    {
        KeyedCoordinateType lowerLeft = null;
        for (KeyedCoordinateType coordinate : coordinates)
        {
            if (coordinateCategoryFromString(coordinate.getCOBieSheetXMLDataElement().getCategory()) == CoordinateCategory.lowerleft)
            {
                lowerLeft = coordinate;
            }
        }
        return lowerLeft;
    }

    private KeyedCoordinateType getUpperRightCoordinate(List<KeyedCoordinateType> coordinates)
    {
        KeyedCoordinateType upperRight = null;
        for (KeyedCoordinateType coordinate : coordinates)
        {
            if (coordinateCategoryFromString(coordinate.getCOBieSheetXMLDataElement().getCategory()) == 
                    CoordinateCategory.upperright)
            {
                upperRight = coordinate;
            }
        }
        return upperRight;
    }

    private void init()
    {
        initializeCoordinateHashMap();
    }


    private void initializeCoordinateHashMap()
    {
        setCoordNameSheetRowToVector(new HashMap<KeyedCoordinateType, Vector<Double>>());
        for (CoordinateType coordinate : getCobieSheetXMLDataSection().getCoordinateArray())
        {
            KeyedCoordinateType keyedCoordinate = new KeyedCoordinateType(coordinate);
            Vector<Double> vector = GeometryHandler.vectorFromCoordinate(coordinate);
            coordNameSheetRowToVector.put(keyedCoordinate, vector);
        }
    }

    @Override
    protected IfcProductDefinitionShape initializeIfcFromCOBieSheetXMLData(CoordinateType cobieElement) throws DeserializerException
    {
        try
        {
            IfcProductDefinitionShape productDefShape = null;
            KeyedCoordinateType keyedCoordinate = new KeyedCoordinateType(cobieElement);
            List<KeyedCoordinateType> coordinates = findCoordinateWithSameNameSheetRow(keyedCoordinate);
            coordinates.add(keyedCoordinate);
            if (coordinates != null)
            {
                productDefShape = getInitialProductDefShape(keyedCoordinate);
                IfcShapeRepresentation shapeRepresentation = getInitialShaperepresentation();
                IfcExtrudedAreaSolid extrudedAreaSolid = extrudedAreaSolidFromCoordinates(coordinates);
                shapeRepresentation.getItems().add(extrudedAreaSolid);
                getModel().add(shapeRepresentation, getIfcCommonHandler().getOidProvider());
                productDefShape.getRepresentations().add(shapeRepresentation);
                // productDefShape.getRepresentations().add(extrudedAreaSolid);
            }
            return productDefShape;
        }
        catch(Exception e)
        {
            throw new DeserializerException(e);
        }
    }

    @Override
    protected void writeRelationships(IfcProductDefinitionShape ifcObject, CoordinateType cobieSheetXMLDataElement) throws DeserializerException
    {
        try
        {
            String sheetName = cobieSheetXMLDataElement.getSheetName();
            String rowName = cobieSheetXMLDataElement.getRowName();
            if (sheetName.equalsIgnoreCase(COBieUtility.CobieSheetName.Space.name()) && getModel().containsSpace(rowName))
            {
                long spaceOid = getModel().getSpaceOid(rowName);
                IfcSpace space = (IfcSpace) getModel().get(spaceOid);
                space.setRepresentation(ifcObject);
            }
            setFloorsLocalPlacementValues();
        }
        
        catch(Exception e)
        {
            throw new DeserializerException(e);
        }

    }

    private void setCoordNameSheetRowToVector(HashMap<KeyedCoordinateType, Vector<Double>> coordNameSheetRowToVector)
    {
        this.coordNameSheetRowToVector = coordNameSheetRowToVector;
    }

    private void setFloorPlacementValues(CoordinateType coordinate) throws IfcModelInterfaceException
    {
        String rowName = coordinate.getRowName();
        if (!COBieUtility.isNA(rowName) && getModel().containsFloor(rowName))
        {
            IfcBuildingStorey buildingStorey = getModel().getFloorByName(rowName);
            if (buildingStorey != null)
            {
                if (buildingStorey.getObjectPlacement() instanceof IfcLocalPlacement)
                {
                    IfcLocalPlacement localPlacement = (IfcLocalPlacement)buildingStorey.getObjectPlacement();
                    Vector<Double> pointVector = GeometryHandler.vectorFromCoordinate(coordinate);
                    if ((localPlacement.getRelativePlacement() != null) && (localPlacement.getRelativePlacement() instanceof IfcAxis2Placement3D))
                    {
                        IfcAxis2Placement3D coordinatePlacement = (IfcAxis2Placement3D)localPlacement.getRelativePlacement();

                        coordinatePlacement.getLocation().getCoordinates().set(0, pointVector.get(0));
                        coordinatePlacement.getLocation().getCoordinates().set(1, pointVector.get(1));
                        coordinatePlacement.getLocation().getCoordinates().set(2, pointVector.get(2));
                    } else
                    {
                        IfcAxis2Placement3D newCoordinatePlacement = getIfcCommonHandler().getGeometryHandler().newDefaultPlacement3D();
                        newCoordinatePlacement.getLocation().getCoordinates().set(0, pointVector.get(0));
                        newCoordinatePlacement.getLocation().getCoordinates().set(1, pointVector.get(1));
                        newCoordinatePlacement.getLocation().getCoordinates().set(2, pointVector.get(2));
                        localPlacement.setRelativePlacement(newCoordinatePlacement);
                    }
                }
            }
        }
    }

    private void setFloorsLocalPlacementValues() throws IfcModelInterfaceException
    {
        for (CoordinateType coordinate : getCobieSheetXMLDataSection().getCoordinateArray())
        {
            String sheetName = coordinate.getSheetName();
            if (!COBieUtility.isNA(sheetName) && sheetName.equalsIgnoreCase(COBieUtility.CobieSheetName.Floor.name()))
            {
                setFloorPlacementValues(coordinate);
            }
        }
    }

}
