package org.erdc.cobie.sqlite.entities;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public class RealRange extends CobieEntity
{
	public enum ColumnName
	{	
		Minimum("Minimum"),
		Maximum("Maximum");

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

	public RealRange()
	{
		super();
		
		Columns columns = new Columns(
				new Column<Integer>(ColumnName.Minimum.toString(), null),
				new Column<String>(ColumnName.Maximum.toString(), null));
		
		addColumns(columns);
	}
	
	@Override
	public String getName()
	{
		return "[" +
				(String)getColumn(ColumnName.Minimum.toString()).getValue() +
				", " +
				(String)getColumn(ColumnName.Maximum.toString()).getValue() +
				"]";
	}
	
	@Override
	public String getTableName() 
	{
		return "RealRange";
	}
}
