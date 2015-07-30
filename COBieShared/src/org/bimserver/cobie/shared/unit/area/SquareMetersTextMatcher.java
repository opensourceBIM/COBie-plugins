package org.bimserver.cobie.shared.unit.area;

import org.bimserver.cobie.shared.unit.UnitTextMatcher;
import org.bimserver.cobie.shared.unit.area.AreaStatics.Metric;
import org.bimserver.models.ifc2x3tc1.IfcUnit;

public class SquareMetersTextMatcher extends UnitTextMatcher
{

    public SquareMetersTextMatcher(String searchString)
    {
        super(searchString);
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return Metric.SquareMeters.UNIT_STRINGS;
    }

    @Override
    public IfcUnit getTargetUnit()
    {
        return Metric.SquareMeters.getUnit();
    }

}
