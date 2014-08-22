package org.erdc.cobie.shared.bimserver.unit.length;

import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.erdc.cobie.shared.bimserver.cobietab.deserialization.propertysets.PropertyUtility;
import org.erdc.cobie.shared.unit.LinearUnit;

public class InchesTextMatcher extends LengthConversionBasedUnitTextMatcher
{

    private static final IfcUnit CONVERSION_UNIT = MillimeterTextMatcher.getTargetUnitStatic();
    public static final String UNIT_NAME = LinearUnit.INCHES.getMeasurable().getUnitName();
    public static final String[] INCHES_STRINGS = LinearUnit.INCHES.getMeasurable().getSynonymousNames();
    public static double INCHES_IN_MILLIMETERS = 25.4;

    public InchesTextMatcher(String searchString)
    {
        super(searchString);
    }

    @Override
    protected IfcUnit getConversionFactorUnit()
    {
        return CONVERSION_UNIT;
    }

    @Override
    protected IfcReal getConversionFactorValue()
    {
        return PropertyUtility.initializeRealToStringVal(String.valueOf(INCHES_IN_MILLIMETERS));
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return INCHES_STRINGS;
    }

    @Override
    protected String getUnitName()
    {
        return UNIT_NAME;
    }

}
