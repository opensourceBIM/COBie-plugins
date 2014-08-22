package org.erdc.cobie.shared.bimserver.unit.length;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.erdc.cobie.shared.bimserver.unit.UnitTextMatcher;
import org.erdc.cobie.shared.unit.LinearUnit;

public class KilometerTextMatcher extends UnitTextMatcher
{
    private static final String[] KILOMETER_STRINGS = LinearUnit.KILOMETERS.getMeasurable().getSynonymousNames();

    public static IfcUnit getIfcKilometers()
    {
        IfcSIUnit meters = Ifc2x3tc1Factory.eINSTANCE.createIfcSIUnit();
        meters.setName(IfcSIUnitName.METRE);
        meters.setUnitType(IfcUnitEnum.LENGTHUNIT);
        meters.setPrefix(IfcSIPrefix.KILO);
        return meters;
    }

    public KilometerTextMatcher(String searchString)
    {
        super(searchString);
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return KILOMETER_STRINGS;
    }

    @Override
    public IfcUnit getTargetUnit()
    {
        return getIfcKilometers();
    }

}
