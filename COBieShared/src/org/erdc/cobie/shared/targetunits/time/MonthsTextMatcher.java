package org.erdc.cobie.shared.targetunits.time;

import org.bimserver.models.ifc2x3tc1.IfcReal;

public class MonthsTextMatcher extends ConversionBasedTimeUnitTextMatcher
{

    public MonthsTextMatcher(String searchString)
    {
        super(searchString);

    }

    @Override
    protected IfcReal getConversionFactorValue()
    {
        return TimeStatics.MonthStatics.CONVERSION_FACTOR;
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return TimeStatics.MonthStatics.UNIT_STRINGS;
    }

    @Override
    protected String getUnitName()
    {
        return TimeStatics.MonthStatics.UNIT_NAME;
    }

}
