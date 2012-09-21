package org.bimserver.shared.cobie.targetunits.length;


import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.shared.cobie.targetunits.ConversionBasedUnitTextMatcher;

public abstract class LengthConversionBasedUnitTextMatcher extends
		ConversionBasedUnitTextMatcher
{

	public LengthConversionBasedUnitTextMatcher(String searchString)
	{
		super(searchString);
	}

	public final IfcUnitEnum getUnitType()
	{
		return IfcUnitEnum.LENGTHUNIT;
	}
	

}
