package org.bimserver.cobie.shared.unit.area;

import org.bimserver.cobie.shared.unit.UnitTextMatcher;
import org.bimserver.cobie.shared.unit.area.AreaStatics.Metric.SquareKilometers;
import org.bimserver.models.ifc2x3tc1.IfcUnit;

public class SquareKilometersTextMatcher extends UnitTextMatcher
{

    public SquareKilometersTextMatcher(String searchString)
    {
        super(searchString);
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return SquareKilometers.UNIT_STRINGS;
    }

    @Override
    public IfcUnit getTargetUnit()
    {
        return SquareKilometers.getUnit();
    }

}
