package org.bimserver.cobie.shared.unit.volume;

import org.bimserver.cobie.shared.unit.ConversionBasedUnitTextMatcher;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;

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
