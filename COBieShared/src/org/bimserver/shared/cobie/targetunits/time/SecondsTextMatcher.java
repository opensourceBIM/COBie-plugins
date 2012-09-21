package org.bimserver.shared.cobie.targetunits.time;

import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.shared.cobie.targetunits.UnitTextMatcher;

public class SecondsTextMatcher extends UnitTextMatcher
{

	public SecondsTextMatcher(String searchString)
	{
		super(searchString);
	}

	@Override
	public IfcUnit getTargetUnit()
	{
		return TimeStatics.SecondsStatics.getUnit();
	}

	@Override
	protected String[] getTargetStringArray()
	{
		return TimeStatics.SecondsStatics.UNIT_STRINGS;
	}

}
