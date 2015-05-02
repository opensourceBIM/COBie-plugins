package org.bimserver.cobie.shared.unit;


public class UnitMatcher
{

	private final Unit[] unitDomain;
	private final String searchString;
	private Unit matchedUnit;
	
	public UnitMatcher(String searchString, Unit... units)
	{
		this.unitDomain = units;
		this.searchString = searchString.trim();
	}
	
	public Unit match()
	{
		if(matchedUnit != null)
		{
			for(Unit candidateUnit : unitDomain)
			{
				if(candidateUnit.getMeasurable().getUnitName().trim().equalsIgnoreCase(searchString))
				{
					matchedUnit = candidateUnit;
					break;
				}
				else
				{
					for(String synonym : candidateUnit.getMeasurable().getSynonymousNames())
					{
						if(synonym.trim().equalsIgnoreCase(searchString))
						{
							matchedUnit = candidateUnit;
						}
					}
				}
			}
		}
		return matchedUnit;	
	}		
}
