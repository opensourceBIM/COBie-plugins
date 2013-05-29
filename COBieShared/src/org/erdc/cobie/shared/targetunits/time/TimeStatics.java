package org.erdc.cobie.shared.targetunits.time;

import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.deserializer.sheetxmldata.propertysets.PropertyUtility;

public class TimeStatics
{
    public static class CenturyStatics
    {
        private static final double NATIVE_TO_DERIVED = YearStatics.NATIVE_TO_DERIVED * 100;
        public static final IfcUnit CONVERSION_UNIT = SecondsStatics.getUnit();
        public static final String[] UNIT_STRINGS =
        {
                "century", "centuries"
        };
        public static final String UNIT_NAME = "century";
        public static final IfcReal CONVERSION_FACTOR = PropertyUtility.initializeRealToStringVal(String.valueOf(NATIVE_TO_DERIVED));
    }

    public static class DayStatics
    {
        private static final double NATIVE_TO_DERIVED = HourStatics.NATIVE_TO_DERIVED * 24;
        public static final IfcUnit CONVERSION_UNIT = SecondsStatics.getUnit();
        public static final String[] UNIT_STRINGS =
        {
                "day", "days", "days (d)", "dd", "d"
        };
        public static final String UNIT_NAME = "day";
        public static final IfcReal CONVERSION_FACTOR = PropertyUtility.initializeRealToStringVal(String.valueOf(NATIVE_TO_DERIVED));
    }

    public static class DecadeStatics
    {
        private static final double NATIVE_TO_DERIVED = YearStatics.NATIVE_TO_DERIVED * 10;
        public static final IfcUnit CONVERSION_UNIT = SecondsStatics.getUnit();
        public static final String[] UNIT_STRINGS =
        {
                "decade", "decades"
        };
        public static final String UNIT_NAME = "decade";
        public static final IfcReal CONVERSION_FACTOR = PropertyUtility.initializeRealToStringVal(String.valueOf(NATIVE_TO_DERIVED));
    }

    public static class HourStatics
    {
        private static final double NATIVE_TO_DERIVED = MinuteStatics.NATIVE_TO_DERIVED * 60;
        public static final IfcUnit CONVERSION_UNIT = SecondsStatics.getUnit();
        public static final String[] UNIT_STRINGS =
        {
                "hour", "hr.", "hr", "hours (hr.)", "hours (hr)", "hour (hr)", "hour (hr.)", "hours"
        };
        public static final String UNIT_NAME = "hour";
        public static final IfcReal CONVERSION_FACTOR = PropertyUtility.initializeRealToStringVal(String.valueOf(NATIVE_TO_DERIVED));
    }

    public static class MinuteStatics
    {
        private static final double NATIVE_TO_DERIVED = 60;
        public static final IfcUnit CONVERSION_UNIT = SecondsStatics.getUnit();
        public static final String[] UNIT_STRINGS =
        {
                "minute", "min.", "min", "minutes (m)", "minute (m)", "minute"
        };
        public static final String UNIT_NAME = "minute";
        public static final IfcReal CONVERSION_FACTOR = PropertyUtility.initializeRealToStringVal(String.valueOf(NATIVE_TO_DERIVED));
    }

    public static class MonthStatics
    {
        private static final double NATIVE_TO_DERIVED = WeekStatics.NATIVE_TO_DERIVED * 4;
        public static final IfcUnit CONVERSION_UNIT = SecondsStatics.getUnit();
        public static final String[] UNIT_STRINGS =
        {
                "months", "month", "mo", "months (mo)", "month (mo)"
        };
        public static final String UNIT_NAME = "month";
        public static final IfcReal CONVERSION_FACTOR = PropertyUtility.initializeRealToStringVal(String.valueOf(NATIVE_TO_DERIVED));
    }

    public static class QuarterHourStatics
    {
        private static final double NATIVE_TO_DERIVED = MinuteStatics.NATIVE_TO_DERIVED * 15;
        public static final IfcUnit CONVERSION_UNIT = SecondsStatics.getUnit();
        public static final String[] UNIT_STRINGS =
        {
                "quarter", "quarter", "qrt", "quarterhours"
        };
        public static final String UNIT_NAME = "quarter hour";
        public static final IfcReal CONVERSION_FACTOR = PropertyUtility.initializeRealToStringVal(String.valueOf(NATIVE_TO_DERIVED));
    }

    public static class SecondsStatics
    {
        public static final IfcSIUnitName UNIT_NAME = IfcSIUnitName.SECOND;
        public static final String[] UNIT_STRINGS =
        {
                "seconds", UNIT_NAME.name(), "seconds (s)", "sec.", "s", "sec", "second (s)", "second"
        };

        public static final IfcSIUnit getUnit()
        {
            IfcSIUnit unit = COBieUtility.ifcFactory.createIfcSIUnit();
            unit.setUnitType(unitType);
            unit.setName(UNIT_NAME);
            return unit;
        }
    }

    public static class WeekStatics
    {
        private static final double NATIVE_TO_DERIVED = DayStatics.NATIVE_TO_DERIVED * 7;
        public static final IfcUnit CONVERSION_UNIT = SecondsStatics.getUnit();
        public static final String[] UNIT_STRINGS =
        {
                "week", "weeks", "wk", "wk.", "week (wk.)", "weeks (wk.)"
        };
        public static final String UNIT_NAME = "week";
        public static final IfcReal CONVERSION_FACTOR = PropertyUtility.initializeRealToStringVal(String.valueOf(NATIVE_TO_DERIVED));
    }

    public static class YearStatics
    {
        private static final double NATIVE_TO_DERIVED = DayStatics.NATIVE_TO_DERIVED * 365;
        public static final IfcUnit CONVERSION_UNIT = SecondsStatics.getUnit();
        public static final String[] UNIT_STRINGS =
        {
                "years", "year", "year (yr.)", "fy", "year (yr)", "yr", "yr.", "years (yr.)", "years (yr)"
        };
        public static final String UNIT_NAME = "year";
        public static final IfcReal CONVERSION_FACTOR = PropertyUtility.initializeRealToStringVal(String.valueOf(NATIVE_TO_DERIVED));
    }

    public static IfcUnitEnum unitType = IfcUnitEnum.TIMEUNIT;

    public static IfcSIUnitName TIME_CONVERSION_UNIT = IfcSIUnitName.SECOND;
}
