package org.erdc.cobie.sqlite.entity;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Row;

public final class IntegerRange extends Range<Integer>
{	
	public IntegerRange() throws CobieSQLiteException
	{
		super();
	}
	
	public IntegerRange(Row row) throws CobieSQLiteException
	{
		super(row);
	}

	@Override
	public String getTableName() 
	{
		return "IntegerRange";
	}
}
