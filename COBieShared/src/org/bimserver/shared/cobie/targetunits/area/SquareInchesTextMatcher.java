package org.bimserver.shared.cobie.targetunits.area;

import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.shared.cobie.targetunits.area.AreaStatics.Imperial.SquareInches;

public class SquareInchesTextMatcher extends AreaConversionBasedUnitTextMatcher
{

	public SquareInchesTextMatcher(String searchString)
	{
		super(searchString);
	}

	@Override
	protected IfcReal getConversionFactorValue()
	{
		return SquareInches.CONVERSION_FACTOR;
	}

	@Override
	protected String getUnitName()
	{
		return SquareInches.UNIT_NAME;
	}

	@Override
	protected IfcUnit getConversionFactorUnit()
	{
		return SquareInches.CONVERSION_UNIT;
	}

	@Override
	protected String[] getTargetStringArray()
	{
		return SquareInches.UNIT_STRINGS;
	}

}
