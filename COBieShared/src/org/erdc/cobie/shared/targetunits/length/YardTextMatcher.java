package org.erdc.cobie.shared.targetunits.length;

import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.erdc.cobie.shared.deserializer.sheetxmldata.propertysets.PropertyUtility;

public class YardTextMatcher extends LengthConversionBasedUnitTextMatcher
{
    private static final IfcUnit TARGET_UNIT = MetersTextMatcher.getTargetUnitStatic();
    public static final double YARDS_TO_METER = 0.9144;
    public static final String UNIT_NAME = "yard";
    public static final String[] YARD_STRINGS =
    {
            UNIT_NAME, "yard", "yd"
    };

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
