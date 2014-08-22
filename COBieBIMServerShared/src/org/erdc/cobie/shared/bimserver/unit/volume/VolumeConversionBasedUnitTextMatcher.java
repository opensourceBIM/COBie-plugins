package org.erdc.cobie.shared.bimserver.unit.volume;

import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.erdc.cobie.shared.bimserver.unit.ConversionBasedUnitTextMatcher;

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
