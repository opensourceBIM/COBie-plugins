package org.bimserver.shared.cobie.targetunits.volume;


import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.shared.cobie.targetunits.ConversionBasedUnitTextMatcher;

public abstract class VolumeConversionBasedUnitTextMatcher extends
		ConversionBasedUnitTextMatcher
{

	public VolumeConversionBasedUnitTextMatcher(String searchString)
	{
		super(searchString);
	}

	@Override
	protected IfcUnitEnum getUnitType()
	{
		return IfcUnitEnum.VOLUMEUNIT;
	}

}
