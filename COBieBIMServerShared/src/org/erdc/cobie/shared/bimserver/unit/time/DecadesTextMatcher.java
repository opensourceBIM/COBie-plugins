package org.erdc.cobie.shared.bimserver.unit.time;

import org.bimserver.models.ifc2x3tc1.IfcReal;

public class DecadesTextMatcher extends ConversionBasedTimeUnitTextMatcher
{

    public DecadesTextMatcher(String searchString)
    {
        super(searchString);

    }

    @Override
    protected IfcReal getConversionFactorValue()
    {
        return TimeStatics.DecadeStatics.CONVERSION_FACTOR;
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return TimeStatics.DecadeStatics.UNIT_STRINGS;
    }

    @Override
    protected String getUnitName()
    {
        return TimeStatics.DecadeStatics.UNIT_NAME;
    }

}
