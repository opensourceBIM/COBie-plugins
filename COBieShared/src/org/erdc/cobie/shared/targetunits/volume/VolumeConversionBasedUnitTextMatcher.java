package org.erdc.cobie.shared.targetunits.volume;

import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.erdc.cobie.shared.targetunits.ConversionBasedUnitTextMatcher;

public abstract class VolumeConversionBasedUnitTextMatcher extends ConversionBasedUnitTextMatcher
{

    public VolumeConversionBasedUnitTextMatcher(String searchString)
    {
        super(searchString);
    }

    @Override
    protected IfcUnitEnum getUnitType()
    {
        return IfcUnitEnum.VOLUMEUNIT;
    }

}
