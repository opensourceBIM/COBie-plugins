package org.bimserver.cobie.shared.unit.area;

import org.bimserver.cobie.shared.deserialization.cobietab.propertysets.PropertyUtility;
import org.bimserver.cobie.shared.unit.AreaUnit;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;

public final class AreaStatics
{

    public static class Imperial
    {
        public static class SquareFeet
        {
            private static final double SQUARE_FOOT_TO_SQUARE_METERS = 0.09290;
            public static final IfcUnit CONVERSION_UNIT = Metric.SquareMeters.getUnit();
            public static final String[] UNIT_STRINGS = AreaUnit.SQUARE_FEET.getMeasurable().getSynonymousNames();
            public static final String UNIT_NAME = AreaUnit.SQUARE_FEET.getMeasurable().getUnitName();
            public static final IfcReal CONVERSION_FACTOR = PropertyUtility.initializeRealToStringVal(String.valueOf(SQUARE_FOOT_TO_SQUARE_METERS));

        }

        public static class SquareInches
        {
            private static final double SQUARE_INCH_TO_SQUARE_MILLIMETERS = 645.2;
            public static final IfcUnit CONVERSION_UNIT = Metric.SquareMilliMeters.getUnit();
            public static final String[] UNIT_STRINGS = AreaUnit.SQUARE_INCHES.getMeasurable().getSynonymousNames();
            static final String UNIT_NAME = AreaUnit.SQUARE_INCHES.getMeasurable().getUnitName();
            public static final IfcReal CONVERSION_FACTOR = PropertyUtility.initializeRealToStringVal(String
                    .valueOf(SQUARE_INCH_TO_SQUARE_MILLIMETERS));

        }

    }

    public static class Metric
    {
        public static class SquareCentiMeters
        {
            public static final IfcSIUnitName UNIT_NAME = IfcSIUnitName.SQUARE_METRE;
            public static final String[] UNIT_STRINGS = AreaUnit.SQUARE_CENTIMETERS.getMeasurable().getSynonymousNames();

            public static final IfcSIUnit getUnit()
            {
                IfcSIUnit squareCentimeters = COBieIfcUtility.ifcFactory.createIfcSIUnit();
                squareCentimeters.setUnitType(unitType);
                squareCentimeters.setName(UNIT_NAME);
                squareCentimeters.setPrefix(IfcSIPrefix.CENTI);
                return squareCentimeters;
            }
        }

        public static class SquareKilometers
        {
            public static final IfcSIUnitName UNIT_NAME = IfcSIUnitName.SQUARE_METRE;
            public static final String[] UNIT_STRINGS = AreaUnit.SQUARE_KILOMETERS.getMeasurable().getSynonymousNames();

            public static final IfcSIUnit getUnit()
            {
                IfcSIUnit milliMeters = COBieIfcUtility.ifcFactory.createIfcSIUnit();
                milliMeters.setUnitType(unitType);
                milliMeters.setName(UNIT_NAME);
                milliMeters.setPrefix(IfcSIPrefix.KILO);
                return milliMeters;
            }
        }

        public static class SquareMeters
        {
            public static final IfcSIUnitName UNIT_NAME = IfcSIUnitName.SQUARE_METRE;
            public static final String[] UNIT_STRINGS = AreaUnit.SQUARE_METERS.getMeasurable().getSynonymousNames();

            public static final IfcSIUnit getUnit()
            {
                IfcSIUnit squareMeters = COBieIfcUtility.ifcFactory.createIfcSIUnit();
                squareMeters.setUnitType(unitType);
                squareMeters.setName(UNIT_NAME);
                return squareMeters;
            }
        }

        public static class SquareMilliMeters
        {
            public static final IfcSIUnitName UNIT_NAME = IfcSIUnitName.SQUARE_METRE;
            public static final String[] UNIT_STRINGS = AreaUnit.SQUARE_MILLIMETERS.getMeasurable().getSynonymousNames();

            public static final IfcSIUnit getUnit()
            {
                IfcSIUnit milliMeters = COBieIfcUtility.ifcFactory.createIfcSIUnit();
                milliMeters.setUnitType(unitType);
                milliMeters.setName(UNIT_NAME);
                milliMeters.setPrefix(IfcSIPrefix.MILLI);
                return milliMeters;
            }
        }
    }

    public static final IfcUnitEnum unitType = IfcUnitEnum.AREAUNIT;
}
