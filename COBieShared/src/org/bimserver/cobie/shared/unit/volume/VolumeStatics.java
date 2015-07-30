package org.bimserver.cobie.shared.unit.volume;

import org.bimserver.cobie.shared.deserialization.cobietab.propertysets.PropertyUtility;
import org.bimserver.cobie.shared.unit.VolumeUnit;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;

public final class VolumeStatics
{
    public static class Imperial
    {
        public static class CubicFeet
        {
            private static final double CUBIC_FOOT_TO_CUBIC_METERS = 0.028316;
            public static final IfcUnit CONVERSION_UNIT = Metric.CubicMeters.getUnit();
            public static final String[] UNIT_STRINGS = VolumeUnit.CUBIC_FEET.getMeasurable().getSynonymousNames();
            public static final String UNIT_NAME = VolumeUnit.CUBIC_FEET.getMeasurable().getUnitName();
            public static final IfcReal CONVERSION_FACTOR = PropertyUtility.initializeRealToStringVal(String.valueOf(CUBIC_FOOT_TO_CUBIC_METERS));

        }

        public static class CubicInches
        {
            private static final double CUBIC_INCH_TO_CUBIC_MILLIMETERS = 16387.064;
            public static final IfcUnit CONVERSION_UNIT = Metric.CubicMillimeters.getUnit();
            public static final String[] UNIT_STRINGS = VolumeUnit.CUBIC_INCHES.getMeasurable().getSynonymousNames();
            public static final String UNIT_NAME = VolumeUnit.CUBIC_INCHES.getMeasurable().getUnitName();
            public static final IfcReal CONVERSION_FACTOR = PropertyUtility
                    .initializeRealToStringVal(String.valueOf(CUBIC_INCH_TO_CUBIC_MILLIMETERS));

        }

    }

    public static class Metric
    {
        public static class CubicCentiMeters
        {
            public static final IfcSIUnitName UNIT_NAME = IfcSIUnitName.CUBIC_METRE;
            public static final String[] UNIT_STRINGS = VolumeUnit.CUBIC_CENTIMETERS.getMeasurable().getSynonymousNames();

            public static final IfcSIUnit getUnit()
            {
                IfcSIUnit cubicCentimeters = COBieIfcUtility.ifcFactory.createIfcSIUnit();
                cubicCentimeters.setUnitType(unitType);
                cubicCentimeters.setName(UNIT_NAME);
                cubicCentimeters.setPrefix(IfcSIPrefix.CENTI);
                return cubicCentimeters;
            }
        }

       

        public static class CubicMeters
        {
            public static final IfcSIUnitName UNIT_NAME = IfcSIUnitName.CUBIC_METRE;
            public static final String[] UNIT_STRINGS = VolumeUnit.CUBIC_METERS.getMeasurable().getSynonymousNames();
            public static final IfcSIUnit getUnit()
            {
                IfcSIUnit cubicMeters = COBieIfcUtility.ifcFactory.createIfcSIUnit();
                cubicMeters.setUnitType(unitType);
                cubicMeters.setName(UNIT_NAME);
                return cubicMeters;
            }
        }

        public static class CubicMillimeters
        {
            public static final IfcSIUnitName UNIT_NAME = IfcSIUnitName.CUBIC_METRE;
            public static final String[] UNIT_STRINGS = VolumeUnit.CUBIC_MILLIMETERS.getMeasurable().getSynonymousNames();
            public static final IfcSIUnit getUnit()
            {
                IfcSIUnit cubicmillimeters = COBieIfcUtility.ifcFactory.createIfcSIUnit();
                cubicmillimeters.setUnitType(unitType);
                cubicmillimeters.setName(UNIT_NAME);
                cubicmillimeters.setPrefix(IfcSIPrefix.MILLI);
                return cubicmillimeters;
            }
        }
    }

    public static final IfcUnitEnum unitType = IfcUnitEnum.VOLUMEUNIT;
}
