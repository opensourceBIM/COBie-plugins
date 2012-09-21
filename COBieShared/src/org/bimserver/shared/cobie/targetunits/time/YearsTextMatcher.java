package org.bimserver.shared.cobie.targetunits.time;

import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.shared.cobie.targetunits.ConversionBasedUnitTextMatcher;

public class YearsTextMatcher extends ConversionBasedTimeUnitTextMatcher
{

	public YearsTextMatcher(String searchString)
	{
		super(searchString);

	}

	@Override
	protected IfcReal getConversionFactorValue()
	{
		return TimeStatics.YearStatics.CONVERSION_FACTOR;
	}

	@Override
	protected String getUnitName()
	{
		return TimeStatics.YearStatics.UNIT_NAME;
	}


	@Override
	protected String[] getTargetStringArray()
	{
		return TimeStatics.YearStatics.UNIT_STRINGS;
	}

}
