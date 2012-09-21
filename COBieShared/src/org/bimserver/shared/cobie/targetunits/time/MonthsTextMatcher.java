package org.bimserver.shared.cobie.targetunits.time;

import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.shared.cobie.targetunits.ConversionBasedUnitTextMatcher;

public class MonthsTextMatcher extends ConversionBasedTimeUnitTextMatcher
{

	public MonthsTextMatcher(String searchString)
	{
		super(searchString);

	}

	@Override
	protected IfcReal getConversionFactorValue()
	{
		return TimeStatics.MonthStatics.CONVERSION_FACTOR;
	}

	@Override
	protected String getUnitName()
	{
		return TimeStatics.MonthStatics.UNIT_NAME;
	}



	@Override
	protected String[] getTargetStringArray()
	{
		return TimeStatics.MonthStatics.UNIT_STRINGS;
	}

}
