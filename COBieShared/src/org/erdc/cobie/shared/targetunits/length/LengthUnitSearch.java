package org.erdc.cobie.shared.targetunits.length;

import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.erdc.cobie.shared.targetunits.IfcUnitSearch;

public class LengthUnitSearch extends IfcUnitSearch
{

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
