package org.erdc.cobie.shared.targetunits.time;

import org.bimserver.models.ifc2x3tc1.IfcReal;

public class HoursTextMatcher extends ConversionBasedTimeUnitTextMatcher
{

    public HoursTextMatcher(String searchString)
    {
        super(searchString);

    }

    @Override
    protected IfcReal getConversionFactorValue()
    {
        return TimeStatics.HourStatics.CONVERSION_FACTOR;
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return TimeStatics.HourStatics.UNIT_STRINGS;
    }

    @Override
    protected String getUnitName()
    {
        return TimeStatics.HourStatics.UNIT_NAME;
    }

}
