package org.bimserver.shared.cobie.targetunits.area;

import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.shared.cobie.targetunits.UnitTextMatcher;

public class SquareCentimetersTextMatcher extends UnitTextMatcher
{

	public SquareCentimetersTextMatcher(String searchString)
	{
		super(searchString);
	}

	@Override
	public IfcUnit getTargetUnit()
	{
		return AreaStatics.Metric.SquareCentiMeters.getUnit();
	}

	@Override
	protected String[] getTargetStringArray()
	{
		return AreaStatics.Metric.SquareCentiMeters.UNIT_STRINGS;
	}

}
