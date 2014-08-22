package org.erdc.cobie.shared.bimserver.unit.time;

import org.bimserver.models.ifc2x3tc1.IfcReal;

public class DaysTextMatcher extends ConversionBasedTimeUnitTextMatcher
{

    public DaysTextMatcher(String searchString)
    {
        super(searchString);

    }

    @Override
    protected IfcReal getConversionFactorValue()
    {
        return TimeStatics.DayStatics.CONVERSION_FACTOR;
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return TimeStatics.DayStatics.UNIT_STRINGS;
    }

    @Override
    protected String getUnitName()
    {
        return TimeStatics.DayStatics.UNIT_NAME;
    }

}
