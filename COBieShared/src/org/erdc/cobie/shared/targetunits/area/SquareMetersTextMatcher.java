package org.erdc.cobie.shared.targetunits.area;

import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.erdc.cobie.shared.targetunits.UnitTextMatcher;
import org.erdc.cobie.shared.targetunits.area.AreaStatics.Metric;

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
