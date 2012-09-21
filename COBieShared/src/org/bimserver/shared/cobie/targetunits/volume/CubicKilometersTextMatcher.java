package org.bimserver.shared.cobie.targetunits.volume;

import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.shared.cobie.targetunits.UnitTextMatcher;

public class CubicKilometersTextMatcher extends UnitTextMatcher
{

	public CubicKilometersTextMatcher(String searchString)
	{
		super(searchString);
	}

	@Override
	public IfcUnit getTargetUnit()
	{
		return VolumeStatics.Metric.CubicKilometers.getUnit();
	}

	@Override
	protected String[] getTargetStringArray()
	{
		return VolumeStatics.Metric.CubicKilometers.UNIT_STRINGS;
	}

}
