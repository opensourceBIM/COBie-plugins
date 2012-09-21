package org.bimserver.shared.cobie.targetunits.time;

import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.shared.cobie.targetunits.ConversionBasedUnitTextMatcher;

public class MinutesTextMatcher extends ConversionBasedTimeUnitTextMatcher
{

	public MinutesTextMatcher(String searchString)
	{
		super(searchString);
	}

	@Override
	protected IfcReal getConversionFactorValue()
	{
		return TimeStatics.MinuteStatics.CONVERSION_FACTOR;
	}

	@Override
	protected String getUnitName()
	{
		return TimeStatics.MinuteStatics.UNIT_NAME;
	}

	

	@Override
	protected String[] getTargetStringArray()
	{
		return TimeStatics.MinuteStatics.UNIT_STRINGS;
	}

}
