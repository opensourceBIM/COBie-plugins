package org.bimserver.cobie.shared.unit.time;

import org.bimserver.cobie.shared.unit.ConversionBasedUnitTextMatcher;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;

public abstract class ConversionBasedTimeUnitTextMatcher extends ConversionBasedUnitTextMatcher
{

    public ConversionBasedTimeUnitTextMatcher(String searchString)
    {
        super(searchString);
    }

    @Override
    protected final IfcUnit getConversionFactorUnit()
    {
        return TimeStatics.SecondsStatics.getUnit();
    }

    @Override
    protected final IfcUnitEnum getUnitType()
    {
        return TimeStatics.unitType;
    }

}
