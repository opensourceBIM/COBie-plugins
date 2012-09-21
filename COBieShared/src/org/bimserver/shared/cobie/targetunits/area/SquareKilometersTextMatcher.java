package org.bimserver.shared.cobie.targetunits.area;

import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.shared.cobie.targetunits.UnitTextMatcher;
import org.bimserver.shared.cobie.targetunits.area.AreaStatics.Metric.SquareKilometers;

public class SquareKilometersTextMatcher extends UnitTextMatcher
{

	public SquareKilometersTextMatcher(String searchString)
	{
		super(searchString);
	}

	@Override
	public IfcUnit getTargetUnit()
	{
		return SquareKilometers.getUnit();
	}

	@Override
	protected String[] getTargetStringArray()
	{
		return SquareKilometers.UNIT_STRINGS;
	}

}
