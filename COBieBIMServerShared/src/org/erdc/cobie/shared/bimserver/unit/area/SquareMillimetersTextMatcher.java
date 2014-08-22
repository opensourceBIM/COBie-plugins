package org.erdc.cobie.shared.bimserver.unit.area;

import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.erdc.cobie.shared.bimserver.unit.UnitTextMatcher;

public class SquareMillimetersTextMatcher extends UnitTextMatcher
{

    public SquareMillimetersTextMatcher(String searchString)
    {
        super(searchString);
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return AreaStatics.Metric.SquareMilliMeters.UNIT_STRINGS;
    }

    @Override
    public IfcUnit getTargetUnit()
    {
        return AreaStatics.Metric.SquareMilliMeters.getUnit();
    }

}
