package org.bimserver.shared.cobie.targetunits.length;

import org.bimserver.cobie.utils.deserializer.propertysets.PropertyUtility;
import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcUnit;

public class FeetTextMatcher extends LengthConversionBasedUnitTextMatcher
{

	private static final double FEET_IN_MILLIMETERS = 304.8;
	private static final IfcUnit CONVERSION_UNIT = MillimeterTextMatcher.getTargetUnitStatic();
	public static final String UNIT_NAME = "foot";
	private static final String[] FEET_STRINGS =
		{"foot","ft",UNIT_NAME,"'"};

	public FeetTextMatcher(String searchString)
	{
		super(searchString);
	}

	

	@Override
	protected String[] getTargetStringArray()
	{
		return FEET_STRINGS;
	}

	@Override
	protected IfcReal getConversionFactorValue()
	{
		return PropertyUtility.initializeRealToStringVal(String.valueOf(FEET_IN_MILLIMETERS));
	}

	@Override
	protected String getUnitName()
	{
		return UNIT_NAME;
	}

	@Override
	protected IfcUnit getConversionFactorUnit()
	{
		return CONVERSION_UNIT;
	}

}
