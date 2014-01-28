package org.erdc.cobie.sqlite.entity.relationship;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Row;
import org.erdc.cobie.sqlite.entity.Entity;

public abstract class Relationship extends Entity
{	
	protected Relationship() throws CobieSQLiteException
	{
		super();
	}
	
	protected Relationship(Row row) throws CobieSQLiteException
	{
		super(row);
	}
	
	public abstract Long getChildKey() throws CobieSQLiteException;
	public abstract Long getParentKey() throws CobieSQLiteException;
	
	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
		return new Row();
	}
	
	public abstract void setChildKey(Long key) throws CobieSQLiteException;	
	public abstract void setParentKey(Long key) throws CobieSQLiteException;
}
