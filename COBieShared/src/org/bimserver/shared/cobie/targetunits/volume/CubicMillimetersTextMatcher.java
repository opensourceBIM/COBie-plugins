package org.bimserver.shared.cobie.targetunits.volume;

import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.shared.cobie.targetunits.UnitTextMatcher;

public class CubicMillimetersTextMatcher extends UnitTextMatcher
{

	public CubicMillimetersTextMatcher(String searchString)
	{
		super(searchString);

	}

	@Override
	public IfcUnit getTargetUnit()
	{
		return VolumeStatics.Metric.CubicMillimeters.getUnit();
	}

	@Override
	protected String[] getTargetStringArray()
	{
		return VolumeStatics.Metric.CubicMillimeters.UNIT_STRINGS;
	}

}
