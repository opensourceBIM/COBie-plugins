package org.erdc.cobie.shared.bimserver.unit.area;

import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.erdc.cobie.shared.bimserver.unit.area.AreaStatics.Imperial.SquareInches;

public class SquareInchesTextMatcher extends AreaConversionBasedUnitTextMatcher
{

    public SquareInchesTextMatcher(String searchString)
    {
        super(searchString);
    }

    @Override
    protected IfcUnit getConversionFactorUnit()
    {
        return SquareInches.CONVERSION_UNIT;
    }

    @Override
    protected IfcReal getConversionFactorValue()
    {
        return SquareInches.CONVERSION_FACTOR;
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return SquareInches.UNIT_STRINGS;
    }

    @Override
    protected String getUnitName()
    {
        return SquareInches.UNIT_NAME;
    }

}
