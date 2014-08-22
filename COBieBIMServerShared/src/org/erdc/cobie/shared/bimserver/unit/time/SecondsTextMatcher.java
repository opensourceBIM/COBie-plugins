package org.erdc.cobie.shared.bimserver.unit.time;

import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.erdc.cobie.shared.bimserver.unit.UnitTextMatcher;

public class SecondsTextMatcher extends UnitTextMatcher
{

    public SecondsTextMatcher(String searchString)
    {
        super(searchString);
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return TimeStatics.SecondsStatics.UNIT_STRINGS;
    }

    @Override
    public IfcUnit getTargetUnit()
    {
        return TimeStatics.SecondsStatics.getUnit();
    }

}
