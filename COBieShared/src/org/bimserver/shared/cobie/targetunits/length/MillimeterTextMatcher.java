package org.bimserver.shared.cobie.targetunits.length;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.shared.cobie.targetunits.UnitTextMatcher;

public class MillimeterTextMatcher extends UnitTextMatcher
{
	public MillimeterTextMatcher(String searchString)
	{
		super(searchString);
	}

	@Override
	public IfcUnit getTargetUnit()
	{
		return getTargetUnitStatic();
	}
	
	public static IfcUnit getTargetUnitStatic()
	{
		IfcSIUnit millimeters =
				Ifc2x3tc1Factory.eINSTANCE.createIfcSIUnit();
		millimeters.setName(IfcSIUnitName.METRE);
		millimeters.setUnitType(IfcUnitEnum.LENGTHUNIT);
		millimeters.setPrefix(IfcSIPrefix.MILLI);
		return millimeters;
	}

	@Override
	protected String[] getTargetStringArray()
	{
		// TODO Auto-generated method stub
		String[] strings =
				{"mm","millimeters","millimeter","millimetre","millimetres"};
		return strings;
	}
	
}
