package org.erdc.cobie.shared.targetunits.time;

import org.bimserver.models.ifc2x3tc1.IfcReal;

public class MinutesTextMatcher extends ConversionBasedTimeUnitTextMatcher
{

    public MinutesTextMatcher(String searchString)
    {
        super(searchString);
    }

    @Override
    protected IfcReal getConversionFactorValue()
    {
        return TimeStatics.MinuteStatics.CONVERSION_FACTOR;
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return TimeStatics.MinuteStatics.UNIT_STRINGS;
    }

    @Override
    protected String getUnitName()
    {
        return TimeStatics.MinuteStatics.UNIT_NAME;
    }

}
