package org.erdc.cobie.sqlite.entity.relationship;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Row;
import org.erdc.cobie.sqlite.string.Default;

public final class NoRelationship extends Relationship 
{
	public NoRelationship() throws CobieSQLiteException
	{
		super();
	}
	
	public NoRelationship(Row row) throws CobieSQLiteException
	{
		super(row);
	}

	@Override
	public String getTableName() 
	{
		return Default.RELATIONSHIP_NONE.toString();
	}
	
	@Override
	public Long getChildKey() 
	{
		return null;
	}

	@Override
	public Long getParentKey() 
	{
		return null;
	}
	
	@Override
	public void setChildKey(Long key) throws CobieSQLiteException 
	{
		// No code needed; NoRelationship has no child key.
	}

	@Override
	public void setParentKey(Long key) throws CobieSQLiteException 
	{
		// No code needed; NoRelationship has no parent key.
	}
}
