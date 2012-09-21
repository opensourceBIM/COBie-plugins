package org.bimserver.shared.cobie.targetunits.area;


import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.shared.cobie.targetunits.ConversionBasedUnitTextMatcher;

public abstract class AreaConversionBasedUnitTextMatcher extends
		ConversionBasedUnitTextMatcher
{

	public AreaConversionBasedUnitTextMatcher(String searchString)
	{
		super(searchString);
	}
	
	@Override
	protected final IfcUnitEnum getUnitType()
	{
		return IfcUnitEnum.AREAUNIT;
	}

}
