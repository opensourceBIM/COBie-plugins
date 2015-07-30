package org.bimserver.cobie.shared.unit.length;

import org.bimserver.cobie.shared.unit.ConversionBasedUnitTextMatcher;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;

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
