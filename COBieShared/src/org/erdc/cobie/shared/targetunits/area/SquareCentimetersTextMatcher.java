package org.erdc.cobie.shared.targetunits.area;

import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.erdc.cobie.shared.targetunits.UnitTextMatcher;

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
