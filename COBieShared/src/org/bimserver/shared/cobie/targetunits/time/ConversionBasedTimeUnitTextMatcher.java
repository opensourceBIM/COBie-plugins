package org.bimserver.shared.cobie.targetunits.time;

import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.shared.cobie.targetunits.ConversionBasedUnitTextMatcher;

public abstract class ConversionBasedTimeUnitTextMatcher extends
		ConversionBasedUnitTextMatcher
{

	public ConversionBasedTimeUnitTextMatcher(String searchString)
	{
		super(searchString);
	}



	@Override
	protected final IfcUnit getConversionFactorUnit()
	{
		return TimeStatics.SecondsStatics.getUnit();
	}

	@Override
	protected final IfcUnitEnum getUnitType()
	{
		return TimeStatics.unitType;
	}

}
