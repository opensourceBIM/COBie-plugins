package org.bimserver.cobie.shared.unit.time;

import org.bimserver.models.ifc2x3tc1.IfcReal;

public class WeeksTextMatcher extends ConversionBasedTimeUnitTextMatcher
{

    public WeeksTextMatcher(String searchString)
    {
        super(searchString);

    }

    @Override
    protected IfcReal getConversionFactorValue()
    {
        return TimeStatics.WeekStatics.CONVERSION_FACTOR;
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return TimeStatics.WeekStatics.UNIT_STRINGS;
    }

    @Override
    protected String getUnitName()
    {
        return TimeStatics.WeekStatics.UNIT_NAME;
    }

}
