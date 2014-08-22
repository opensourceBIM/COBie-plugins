package org.erdc.cobie.shared.bimserver.unit.volume;

import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.erdc.cobie.shared.bimserver.unit.UnitTextMatcher;

public class CubicCentimetersTextMatcher extends UnitTextMatcher
{

    public CubicCentimetersTextMatcher(String searchString)
    {
        super(searchString);
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return VolumeStatics.Metric.CubicCentiMeters.UNIT_STRINGS;
    }

    @Override
    public IfcUnit getTargetUnit()
    {
        return VolumeStatics.Metric.CubicCentiMeters.getUnit();
    }

}
