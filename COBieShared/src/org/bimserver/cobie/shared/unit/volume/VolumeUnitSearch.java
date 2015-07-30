package org.bimserver.cobie.shared.unit.volume;

import org.bimserver.cobie.shared.unit.IfcUnitSearch;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;

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
        add(new CubicMetersTextMatcher(searchString));
        add(new CubicMillimetersTextMatcher(searchString));

    }

}
