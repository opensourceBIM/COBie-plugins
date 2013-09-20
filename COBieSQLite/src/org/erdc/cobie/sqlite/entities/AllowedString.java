package org.erdc.cobie.sqlite.entities;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public class AllowedString extends CRUDEntity
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

	public AllowedString()
	{
		super();
		
		Columns columns = new Columns(
				new Column<Integer>(ColumnName.RefValue.toString(), null, true),
				new Column<String>(ColumnName.StringValue.toString(), null));
		
		addColumns(columns);
	}
	
	@Override
	public String getTableName() 
	{
		return "AllowedString";
	}
}
