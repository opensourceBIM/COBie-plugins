package org.bimserver.cobie.shared.unit.area;

import org.bimserver.cobie.shared.unit.area.AreaStatics.Imperial.SquareFeet;
import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcUnit;

public class SquareFeetTextMatcher extends AreaConversionBasedUnitTextMatcher
{

    public SquareFeetTextMatcher(String searchString)
    {
        super(searchString);
    }

    @Override
    protected IfcUnit getConversionFactorUnit()
    {
        return SquareFeet.CONVERSION_UNIT;
    }

    @Override
    protected IfcReal getConversionFactorValue()
    {
        return SquareFeet.CONVERSION_FACTOR;
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return SquareFeet.UNIT_STRINGS;
    }

    @Override
    protected String getUnitName()
    {
        return SquareFeet.UNIT_NAME;
    }

}
