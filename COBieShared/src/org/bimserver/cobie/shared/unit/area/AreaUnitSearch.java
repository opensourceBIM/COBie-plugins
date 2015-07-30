package org.bimserver.cobie.shared.unit.area;

import org.bimserver.cobie.shared.unit.IfcUnitSearch;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;

public class AreaUnitSearch extends IfcUnitSearch
{

    private static final long serialVersionUID = 8183960380657939040L;

    public AreaUnitSearch(String searchString)
    {
        super(searchString, IfcUnitEnum.AREAUNIT);
    }

    @Override
    protected void addSearchItems()
    {
        add(new SquareCentimetersTextMatcher(searchString));
        add(new SquareFeetTextMatcher(searchString));
        add(new SquareInchesTextMatcher(searchString));
        add(new SquareKilometersTextMatcher(searchString));
        add(new SquareMetersTextMatcher(searchString));
        add(new SquareMillimetersTextMatcher(searchString));

    }

}
