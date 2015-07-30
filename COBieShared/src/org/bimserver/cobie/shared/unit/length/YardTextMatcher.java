package org.bimserver.cobie.shared.unit.length;

import org.bimserver.cobie.shared.deserialization.cobietab.propertysets.PropertyUtility;
import org.bimserver.cobie.shared.unit.LinearUnit;
import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcUnit;

public class YardTextMatcher extends LengthConversionBasedUnitTextMatcher
{
    private static final IfcUnit TARGET_UNIT = MetersTextMatcher.getTargetUnitStatic();
    public static final double YARDS_TO_METER = 0.9144;
    public static final String UNIT_NAME = LinearUnit.YARDS.getMeasurable().getUnitName();
    public static final String[] YARD_STRINGS = LinearUnit.YARDS.getMeasurable().getSynonymousNames();

    public YardTextMatcher(String searchString)
    {
        super(searchString);
    }

    @Override
    protected IfcUnit getConversionFactorUnit()
    {

        return TARGET_UNIT;
    }

    @Override
    protected IfcReal getConversionFactorValue()
    {
        return PropertyUtility.initializeRealToStringVal(String.valueOf(YARDS_TO_METER));
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return YARD_STRINGS;
    }

    @Override
    protected String getUnitName()
    {
        return UNIT_NAME;
    }

}
