package org.erdc.cobie.shared.targetunits.length;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.erdc.cobie.shared.targetunits.UnitTextMatcher;

public class MetersTextMatcher extends UnitTextMatcher
{
    public static IfcUnit getTargetUnitStatic()
    {
        IfcSIUnit meters = Ifc2x3tc1Factory.eINSTANCE.createIfcSIUnit();
        meters.setName(IfcSIUnitName.METRE);
        meters.setUnitType(IfcUnitEnum.LENGTHUNIT);
        return meters;
    }

    public MetersTextMatcher(String searchString)
    {
        super(searchString);
    }

    @Override
    protected String[] getTargetStringArray()
    {
        // TODO Auto-generated method stub
        String[] strings =
        {
                "meters", "m", "metre", "metres"
        };
        return strings;
    }

    @Override
    public IfcUnit getTargetUnit()
    {
        return getTargetUnitStatic();
    }

}
