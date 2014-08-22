package org.erdc.cobie.shared.unit;

public class Measurable
{
	private final String unitName;
	private final String[] synonymousNames;
	
	public Measurable(String unitName, String cobieLiteName, String... synonymousNames)
	{
		this.unitName = unitName;
		this.synonymousNames = synonymousNames;
	}
		
	public final String getUnitName()
	{
		return unitName;
	}

	public  final String[] getSynonymousNames()
	{
		return synonymousNames;
	}
}