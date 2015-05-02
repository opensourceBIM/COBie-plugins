package org.bimserver.cobie.shared.unit.length;

import org.bimserver.cobie.shared.unit.LinearUnit;
import org.bimserver.cobie.shared.unit.UnitTextMatcher;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;

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
