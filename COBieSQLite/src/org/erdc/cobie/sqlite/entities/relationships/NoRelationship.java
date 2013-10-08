package org.erdc.cobie.sqlite.entities.relationships;

import org.erdc.cobie.sqlite.Column;

public class NoRelationship extends Relationship 
{
	@Override
	public String getTableName() 
	{
		return "NoRelationship";
	}
	
	@Override
	public Column<Integer> getChildKey() 
	{
		return null;
	}

	@Override
	public Column<Integer> getParentKey() 
	{
		return null;
	}
}
