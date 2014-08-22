package org.erdc.cobie.shared.bimserver.unit.length;

import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.erdc.cobie.shared.bimserver.unit.ConversionBasedUnitTextMatcher;

public abstract class LengthConversionBasedUnitTextMatcher extends ConversionBasedUnitTextMatcher
{

    public LengthConversionBasedUnitTextMatcher(String searchString)
    {
        super(searchString);
    }

    @Override
    public final IfcUnitEnum getUnitType()
    {
        return IfcUnitEnum.LENGTHUNIT;
    }

}
