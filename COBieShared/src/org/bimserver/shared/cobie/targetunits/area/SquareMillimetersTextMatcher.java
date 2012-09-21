package org.bimserver.shared.cobie.targetunits.area;

import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.shared.cobie.targetunits.UnitTextMatcher;

public class SquareMillimetersTextMatcher extends UnitTextMatcher
{

	public SquareMillimetersTextMatcher(String searchString)
	{
		super(searchString);
	}

	@Override
	public IfcUnit getTargetUnit()
	{
		return AreaStatics.Metric.SquareMilliMeters.getUnit();
	}

	@Override
	protected String[] getTargetStringArray()
	{
		return AreaStatics.Metric.SquareMilliMeters.UNIT_STRINGS;
	}

}
