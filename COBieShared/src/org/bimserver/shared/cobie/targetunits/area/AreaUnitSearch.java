package org.bimserver.shared.cobie.targetunits.area;


import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.shared.cobie.targetunits.IfcUnitSearch;
public class AreaUnitSearch extends  IfcUnitSearch
{

	private static final long serialVersionUID = 8183960380657939040L;

	public AreaUnitSearch(String searchString)
	{
		super(searchString,IfcUnitEnum.AREAUNIT);
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
