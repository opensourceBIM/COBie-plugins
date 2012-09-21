package org.bimserver.shared.cobie.targetunits.area;

import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.shared.cobie.targetunits.UnitTextMatcher;
import org.bimserver.shared.cobie.targetunits.area.AreaStatics.Metric;

public class SquareMetersTextMatcher extends UnitTextMatcher
{

	public SquareMetersTextMatcher(String searchString)
	{
		super(searchString);
	}

	@Override
	public IfcUnit getTargetUnit()
	{
		return Metric.SquareMeters.getUnit();
	}

	@Override
	protected String[] getTargetStringArray()
	{
		return Metric.SquareMeters.UNIT_STRINGS;
	}

}
