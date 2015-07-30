package org.bimserver.cobie.shared.unit.length;

import org.bimserver.cobie.shared.unit.LinearUnit;
import org.bimserver.cobie.shared.unit.UnitTextMatcher;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;

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
    	return  LinearUnit.METERS.getMeasurable().getSynonymousNames();     
    }

    @Override
    public IfcUnit getTargetUnit()
    {
        return getTargetUnitStatic();
    }

}
