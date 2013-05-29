package org.erdc.cobie.shared.targetunits.time;

import org.bimserver.models.ifc2x3tc1.IfcReal;

public class QuarterHoursTextMatcher extends ConversionBasedTimeUnitTextMatcher
{

    public QuarterHoursTextMatcher(String searchString)
    {
        super(searchString);

    }

    @Override
    protected IfcReal getConversionFactorValue()
    {
        return TimeStatics.QuarterHourStatics.CONVERSION_FACTOR;
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return TimeStatics.QuarterHourStatics.UNIT_STRINGS;
    }

    @Override
    protected String getUnitName()
    {
        return TimeStatics.QuarterHourStatics.UNIT_NAME;
    }

}
