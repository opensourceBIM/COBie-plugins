package org.erdc.cobie.sqlite.entity;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public final class AllowedString extends Entity
{
	public enum ColumnName
	{
		RefValue("RefValue"), 
		StringValue("StringValue");

		private String columName;

		private ColumnName(final String columnName)
		{
			columName = columnName;
		}

		@Override
		public final String toString()
		{
			return columName;
		}
	}

	public AllowedString() throws CobieSQLiteException
	{
		super();
	}
	
	public AllowedString(Row row) throws CobieSQLiteException
	{
		super(row);
	}
	
	@SuppressWarnings("boxing")
	public final int getRefValue() throws CobieSQLiteException
	{
		return (Integer)getColumn(ColumnName.RefValue.toString()).getValue();
	}
	
	public final String getStringValue() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.StringValue.toString()).getValue();
	}

	@Override
	public String getTableName()
	{
		return "AllowedString";
	}
	
	@Override
	protected Row makeRow() throws CobieSQLiteException
	{    	    	
		return new Row(
			new Column<>(Integer.class, ColumnName.RefValue.toString(), null, true), 
			new Column<>(String.class, ColumnName.StringValue.toString(), null));
	}

	@SuppressWarnings("boxing")
	public final void setRefValue(int refValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.RefValue.toString()).update(refValue);
	}

	public final void setStringValue(String stringValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.StringValue.toString()).update(stringValue);
	}
}
