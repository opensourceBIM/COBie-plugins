package org.bimserver.cobie.shared.unit.area;

import org.bimserver.cobie.shared.unit.UnitTextMatcher;
import org.bimserver.models.ifc2x3tc1.IfcUnit;

public class SquareCentimetersTextMatcher extends UnitTextMatcher
{

    public SquareCentimetersTextMatcher(String searchString)
    {
        super(searchString);
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return AreaStatics.Metric.SquareCentiMeters.UNIT_STRINGS;
    }

    @Override
    public IfcUnit getTargetUnit()
    {
        return AreaStatics.Metric.SquareCentiMeters.getUnit();
    }

}
