package org.erdc.cobie.shared.targetunits.volume;

import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.deserializer.sheetxmldata.propertysets.PropertyUtility;

public final class VolumeStatics
{
    public static class Imperial
    {
        public static class CubicFeet
        {
            private static final double CUBIC_FOOT_TO_CUBIC_METERS = 0.028316;
            public static final IfcUnit CONVERSION_UNIT = Metric.CubicMeters.getUnit();
            public static final String[] UNIT_STRINGS =
            {
                    "cubicfeet", "cubic feet", "cubed foot", "feet cubed", "cubic ft", "ft3", "ft^3", "cubed feet", "ft cubed", "cubic ft.",
                    "ft. cubed"
            };
            public static final String UNIT_NAME = "cubic feet";
            public static final IfcReal CONVERSION_FACTOR = PropertyUtility.initializeRealToStringVal(String.valueOf(CUBIC_FOOT_TO_CUBIC_METERS));

        }

        public static class CubicInches
        {
            private static final double CUBIC_INCH_TO_CUBIC_MILLIMETERS = 16387.064;
            public static final IfcUnit CONVERSION_UNIT = Metric.CubicMillimeters.getUnit();
            public static final String[] UNIT_STRINGS =
            {
                    "cubicinches", "cubic inches", "cubic inch", "inches cubed", "cubic in.", "in3", "in^3", "in. cubed", "cubic in", "in cubed"
            };
            public static final String UNIT_NAME = "cubic inches";
            public static final IfcReal CONVERSION_FACTOR = PropertyUtility
                    .initializeRealToStringVal(String.valueOf(CUBIC_INCH_TO_CUBIC_MILLIMETERS));

        }

    }

    public static class Metric
    {
        public static class CubicCentiMeters
        {
            public static final IfcSIUnitName UNIT_NAME = IfcSIUnitName.CUBIC_METRE;
            public static final String[] UNIT_STRINGS =
            {
                    "cubiccentimeters", IfcSIPrefix.CENTI + "_" + IfcSIUnitName.CUBIC_METRE.name(), "cubic centimeter", "centimeters cubed",
                    "cubedcentimeter", "cm3", "cm^3", "cubed centimeters", "cubic cm", "cubed centimeter", "cubed cm", "cm cubed"
            };

            public static final IfcSIUnit getUnit()
            {
                IfcSIUnit cubicCentimeters = COBieUtility.ifcFactory.createIfcSIUnit();
                cubicCentimeters.setUnitType(unitType);
                cubicCentimeters.setName(UNIT_NAME);
                cubicCentimeters.setPrefix(IfcSIPrefix.CENTI);
                return cubicCentimeters;
            }
        }

        public static class CubicKilometers
        {
            public static final IfcSIUnitName UNIT_NAME = IfcSIUnitName.CUBIC_METRE;
            public static final String[] UNIT_STRINGS =
            {
                    "cubickilometers", IfcSIPrefix.KILO + "_" + IfcSIUnitName.CUBIC_METRE.name(), "cubic kilometer", "kilometers cubed",
                    "cubedkilometer", "km3", "km^3", "cubed kilometers", "cubic km", "cubed kilometer", "km cubed"
            };

            public static final IfcSIUnit getUnit()
            {
                IfcSIUnit cubickilometers = COBieUtility.ifcFactory.createIfcSIUnit();
                cubickilometers.setUnitType(unitType);
                cubickilometers.setName(UNIT_NAME);
                cubickilometers.setPrefix(IfcSIPrefix.KILO);
                return cubickilometers;
            }
        }

        public static class CubicMeters
        {
            public static final IfcSIUnitName UNIT_NAME = IfcSIUnitName.CUBIC_METRE;
            public static final String[] UNIT_STRINGS =
            {
                    "cubicmeters", IfcSIUnitName.CUBIC_METRE.name(), "cubic meter", "meters cubed", "cubedmeter", "m3", "m^3", "cubed meters",
                    "cubic m", "cubed meter", "cubed meter", "cubed m", "m cubed"
            };

            public static final IfcSIUnit getUnit()
            {
                IfcSIUnit cubicMeters = COBieUtility.ifcFactory.createIfcSIUnit();
                cubicMeters.setUnitType(unitType);
                cubicMeters.setName(UNIT_NAME);
                return cubicMeters;
            }
        }

        public static class CubicMillimeters
        {
            public static final IfcSIUnitName UNIT_NAME = IfcSIUnitName.CUBIC_METRE;
            public static final String[] UNIT_STRINGS =
            {
                    "cubicmillimeters", IfcSIPrefix.MILLI + "_" + IfcSIUnitName.CUBIC_METRE.name(), "cubic millimeter", "millimeters cubed",
                    "cubedmillimeter", "mm3", "mm^3", "cubed millimeters", "cubic mm", "cubed millimeter", "mm cubed"
            };

            public static final IfcSIUnit getUnit()
            {
                IfcSIUnit cubicmillimeters = COBieUtility.ifcFactory.createIfcSIUnit();
                cubicmillimeters.setUnitType(unitType);
                cubicmillimeters.setName(UNIT_NAME);
                cubicmillimeters.setPrefix(IfcSIPrefix.MILLI);
                return cubicmillimeters;
            }
        }
    }

    public static final IfcUnitEnum unitType = IfcUnitEnum.VOLUMEUNIT;
}
