package org.erdc.cobie.sqlite.entity;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Row;

public class RealRange extends Range<Float>
{	
	public RealRange() throws CobieSQLiteException
	{
		super();
	}
	
	public RealRange(Row row) throws CobieSQLiteException
	{
		super(row);
	}

	@Override
	public String getTableName() 
	{
		return "RealRange";
	}
}
