package org.bimserver.shared.cobie.targetunits.length;

import java.util.Arrays;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.shared.cobie.targetunits.UnitTextMatcher;

public class MetersTextMatcher extends UnitTextMatcher
{
	public MetersTextMatcher(String searchString)
	{
		super(searchString);
	}



	@Override
	public IfcUnit getTargetUnit()
	{
		return getTargetUnitStatic();
	}

	public static IfcUnit  getTargetUnitStatic()
	{
		IfcSIUnit meters =
				Ifc2x3tc1Factory.eINSTANCE.createIfcSIUnit();
		meters.setName(IfcSIUnitName.METRE);
		meters.setUnitType(IfcUnitEnum.LENGTHUNIT);
		return meters;
	}


	@Override
	protected String[] getTargetStringArray()
	{
		// TODO Auto-generated method stub
		String[] strings =
				{"meters","m","metre","metres"};
		return strings;
	}

}
