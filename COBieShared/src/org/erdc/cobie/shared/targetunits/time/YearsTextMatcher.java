package org.erdc.cobie.shared.targetunits.time;

import org.bimserver.models.ifc2x3tc1.IfcReal;

public class YearsTextMatcher extends ConversionBasedTimeUnitTextMatcher
{

    public YearsTextMatcher(String searchString)
    {
        super(searchString);

    }

    @Override
    protected IfcReal getConversionFactorValue()
    {
        return TimeStatics.YearStatics.CONVERSION_FACTOR;
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return TimeStatics.YearStatics.UNIT_STRINGS;
    }

    @Override
    protected String getUnitName()
    {
        return TimeStatics.YearStatics.UNIT_NAME;
    }

}
