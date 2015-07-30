package org.bimserver.cobie.shared.unit.volume;

import org.bimserver.cobie.shared.unit.UnitTextMatcher;
import org.bimserver.models.ifc2x3tc1.IfcUnit;

public class CubicMetersTextMatcher extends UnitTextMatcher
{

    public CubicMetersTextMatcher(String searchString)
    {
        super(searchString);

    }

    @Override
    protected String[] getTargetStringArray()
    {
        return VolumeStatics.Metric.CubicMeters.UNIT_STRINGS;
    }

    @Override
    public IfcUnit getTargetUnit()
    {
        return VolumeStatics.Metric.CubicMeters.getUnit();
    }

}
