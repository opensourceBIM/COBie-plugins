package org.bimserver.shared.cobie.targetunits.volume;

import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.shared.cobie.targetunits.UnitTextMatcher;

public class CubicMetersTextMatcher extends UnitTextMatcher
{

	public CubicMetersTextMatcher(String searchString)
	{
		super(searchString);

	}

	@Override
	public IfcUnit getTargetUnit()
	{
		return VolumeStatics.Metric.CubicMeters.getUnit();
	}

	@Override
	protected String[] getTargetStringArray()
	{
		return VolumeStatics.Metric.CubicMeters.UNIT_STRINGS;
	}

}
