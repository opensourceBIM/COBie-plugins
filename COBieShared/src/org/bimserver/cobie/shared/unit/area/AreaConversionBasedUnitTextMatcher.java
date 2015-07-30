package org.bimserver.cobie.shared.unit.area;

import org.bimserver.cobie.shared.unit.ConversionBasedUnitTextMatcher;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;

public abstract class AreaConversionBasedUnitTextMatcher extends ConversionBasedUnitTextMatcher
{

    public AreaConversionBasedUnitTextMatcher(String searchString)
    {
        super(searchString);
    }

    @Override
    protected final IfcUnitEnum getUnitType()
    {
        return IfcUnitEnum.AREAUNIT;
    }

}
