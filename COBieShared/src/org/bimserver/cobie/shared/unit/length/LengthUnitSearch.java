package org.bimserver.cobie.shared.unit.length;

import org.bimserver.cobie.shared.unit.IfcUnitSearch;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;

public class LengthUnitSearch extends IfcUnitSearch
{

    /**
     * 
     */
    private static final long serialVersionUID = -8437258094469132399L;

    public LengthUnitSearch(String searchString)
    {
        super(searchString, IfcUnitEnum.LENGTHUNIT);
    }

    @Override
    protected void addSearchItems()
    {
        add(new CentimeterTextMatcher(searchString));
        add(new FeetTextMatcher(searchString));
        add(new InchesTextMatcher(searchString));
        add(new KilometerTextMatcher(searchString));
        add(new MetersTextMatcher(searchString));
        add(new MilesTextMatcher(searchString));
        add(new MillimeterTextMatcher(searchString));
        add(new YardTextMatcher(searchString));

    }
}
