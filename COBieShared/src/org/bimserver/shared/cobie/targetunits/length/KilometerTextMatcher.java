package org.bimserver.shared.cobie.targetunits.length;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.shared.cobie.targetunits.UnitTextMatcher;

public class KilometerTextMatcher extends UnitTextMatcher
{
	private static final String[] KILOMETER_STRINGS =
		{"kilometers","kilometer","km","kilometre","kilometres"};

	public KilometerTextMatcher(String searchString)
	{
		super(searchString);
	}

	@Override
	public IfcUnit getTargetUnit()
	{
		return getIfcKilometers();
	}

	public static IfcUnit getIfcKilometers()
	{
		IfcSIUnit meters =
				Ifc2x3tc1Factory.eINSTANCE.createIfcSIUnit();
		meters.setName(IfcSIUnitName.METRE);
		meters.setUnitType(IfcUnitEnum.LENGTHUNIT);
		meters.setPrefix(IfcSIPrefix.KILO);
		return meters;
	}

	@Override
	protected String[] getTargetStringArray()
	{
		return KILOMETER_STRINGS;
	}

}
