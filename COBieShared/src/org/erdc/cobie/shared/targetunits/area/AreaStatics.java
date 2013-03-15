package org.erdc.cobie.shared.targetunits.area;

import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.utils.deserializer.propertysets.PropertyUtility;

public final class AreaStatics
{

    public static class Imperial
    {
        public static class SquareFeet
        {
            private static final double SQUARE_FOOT_TO_SQUARE_METERS = 0.09290;
            public static final IfcUnit CONVERSION_UNIT = Metric.SquareMeters.getUnit();
            public static final String[] UNIT_STRINGS =
            {
                    "squarefeet", "square feet", "square foot", "feet squared", "squarefoot", "ft2", "ft^2", "sq. feet", "sq. foot", "sq feet",
                    "sq foot"
            };
            public static final String UNIT_NAME = "square foot";
            public static final IfcReal CONVERSION_FACTOR = PropertyUtility.initializeRealToStringVal(String.valueOf(SQUARE_FOOT_TO_SQUARE_METERS));

        }

        public static class SquareInches
        {
            private static final double SQUARE_INCH_TO_SQUARE_MILLIMETERS = 645.2;
            public static final IfcUnit CONVERSION_UNIT = Metric.SquareMilliMeters.getUnit();
            public static final String[] UNIT_STRINGS =
            {
                    "squareinches", "square inches", "square inch", "inches squared", "squareinch", "in2", "in^2", "sq. inches", "sq. inch",
                    "sq inches", "sq inch"
            };
            public static final String UNIT_NAME = "square inch";
            public static final IfcReal CONVERSION_FACTOR = PropertyUtility.initializeRealToStringVal(String
                    .valueOf(SQUARE_INCH_TO_SQUARE_MILLIMETERS));

        }

    }

    public static class Metric
    {
        public static class SquareCentiMeters
        {
            public static final IfcSIUnitName UNIT_NAME = IfcSIUnitName.SQUARE_METRE;
            public static final String[] UNIT_STRINGS =
            {
                    "squarecentimeters", IfcSIPrefix.CENTI.name() + IfcSIUnitName.SQUARE_METRE.name(), "square centimeter", "centimeters squared",
                    "squarecentimeter", "cm2", "cm^2", "sq centimeters", "sq centimeter", "sq. centimeter", "sq.centimeters"
            };

            public static final IfcSIUnit getUnit()
            {
                IfcSIUnit squareCentimeters = COBieUtility.ifcFactory.createIfcSIUnit();
                squareCentimeters.setUnitType(unitType);
                squareCentimeters.setName(UNIT_NAME);
                squareCentimeters.setPrefix(IfcSIPrefix.CENTI);
                return squareCentimeters;
            }
        }

        public static class SquareKilometers
        {
            public static final IfcSIUnitName UNIT_NAME = IfcSIUnitName.SQUARE_METRE;
            public static final String[] UNIT_STRINGS =
            {
                    "squarekilometers", IfcSIPrefix.KILO.name() + IfcSIUnitName.SQUARE_METRE.name(), "square kilometer", "kilometers squared",
                    "squarekilometer", "km2", "km^2", "sq kilometers", "sq kilometer", "sq. kilometer", "sq.kilometers"
            };

            public static final IfcSIUnit getUnit()
            {
                IfcSIUnit milliMeters = COBieUtility.ifcFactory.createIfcSIUnit();
                milliMeters.setUnitType(unitType);
                milliMeters.setName(UNIT_NAME);
                milliMeters.setPrefix(IfcSIPrefix.KILO);
                return milliMeters;
            }
        }

        public static class SquareMeters
        {
            public static final IfcSIUnitName UNIT_NAME = IfcSIUnitName.SQUARE_METRE;
            public static final String[] UNIT_STRINGS =
            {
                    "squaremeters", IfcSIUnitName.SQUARE_METRE.name(), "square meter", "meters squared", "squaremeter", "m2", "m^2", "sq meters",
                    "sq meter", "sq. meter", "sq.meters"
            };

            public static final IfcSIUnit getUnit()
            {
                IfcSIUnit squareMeters = COBieUtility.ifcFactory.createIfcSIUnit();
                squareMeters.setUnitType(unitType);
                squareMeters.setName(UNIT_NAME);
                return squareMeters;
            }
        }

        public static class SquareMilliMeters
        {
            public static final IfcSIUnitName UNIT_NAME = IfcSIUnitName.SQUARE_METRE;
            public static final String[] UNIT_STRINGS =
            {
                    "squaremillimeters", IfcSIPrefix.MILLI.name() + IfcSIUnitName.SQUARE_METRE.name(), "square millimeter", "millimeters squared",
                    "squaremillimeter", "mm2", "mm^2", "sq millimeters", "sq millimeter", "sq. millimeter", "sq.millimeters"
            };

            public static final IfcSIUnit getUnit()
            {
                IfcSIUnit milliMeters = COBieUtility.ifcFactory.createIfcSIUnit();
                milliMeters.setUnitType(unitType);
                milliMeters.setName(UNIT_NAME);
                milliMeters.setPrefix(IfcSIPrefix.MILLI);
                return milliMeters;
            }
        }
    }

    public static final IfcUnitEnum unitType = IfcUnitEnum.AREAUNIT;
}
