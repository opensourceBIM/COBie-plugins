package org.bimserver.cobie.shared.unit.length;

import org.bimserver.cobie.shared.deserialization.cobietab.propertysets.PropertyUtility;
import org.bimserver.cobie.shared.unit.LinearUnit;
import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcUnit;

public class MilesTextMatcher extends LengthConversionBasedUnitTextMatcher
{
    private static final IfcUnit CONVERSION_UNIT = KilometerTextMatcher.getIfcKilometers();
    public static final String UNIT_NAME = LinearUnit.MILES.getMeasurable().getUnitName();
    public static final String[] MILES_STRINGS = LinearUnit.MILES.getMeasurable().getSynonymousNames();
    public static double MILES_IN_KILOMETER = 1.609344;

    public MilesTextMatcher(String searchString)
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
        return PropertyUtility.initializeRealToStringVal(String.valueOf(MILES_IN_KILOMETER));
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return MILES_STRINGS;
    }

    @Override
    protected String getUnitName()
    {
        return UNIT_NAME;
    }

}
