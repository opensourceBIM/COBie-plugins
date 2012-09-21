package org.bimserver.shared.cobie.targetunits.volume;

import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.shared.cobie.targetunits.UnitTextMatcher;

public class CubicCentimetersTextMatcher extends UnitTextMatcher
{

	public CubicCentimetersTextMatcher(String searchString)
	{
		super(searchString);
	}

	@Override
	public IfcUnit getTargetUnit()
	{
		return VolumeStatics.Metric.CubicCentiMeters.getUnit();
	}

	@Override
	protected String[] getTargetStringArray()
	{
		return VolumeStatics.Metric.CubicCentiMeters.UNIT_STRINGS;
	}

}
