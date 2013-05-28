package org.erdc.cobie.shared.targetunits.volume;

import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.erdc.cobie.shared.targetunits.IfcUnitSearch;

public class VolumeUnitSearch extends IfcUnitSearch
{

    /**
     * 
     */
    private static final long serialVersionUID = 8325040169644048805L;

    public VolumeUnitSearch(String searchString)
    {
        super(searchString, IfcUnitEnum.VOLUMEUNIT);
    }

    @Override
    protected void addSearchItems()
    {
        add(new CubicCentimetersTextMatcher(searchString));
        add(new CubicFeetTextMatcher(searchString));
        add(new CubicInchesTextMatcher(searchString));
        add(new CubicKilometersTextMatcher(searchString));
        add(new CubicMetersTextMatcher(searchString));
        add(new CubicMillimetersTextMatcher(searchString));

    }

}
