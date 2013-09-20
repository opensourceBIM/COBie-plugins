package org.erdc.cobie.shared.targetunits.area;

import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.erdc.cobie.shared.targetunits.ConversionBasedUnitTextMatcher;

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
