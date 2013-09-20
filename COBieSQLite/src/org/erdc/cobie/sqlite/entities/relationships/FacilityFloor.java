package org.erdc.cobie.sqlite.entities.relationships;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public class FacilityFloor extends Relationship 
{
	public enum ColumnName
	{	
		RefFacility("RefFacility"), 
		RefFloor("RefFloor");

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
	
	public FacilityFloor()
	{
		super();
		
		Columns columns = new Columns(
				new Column<Integer>(ColumnName.RefFacility.toString(), null, true),
				new Column<Integer>(ColumnName.RefFloor.toString(), null, true));
		
		addColumns(columns);
	}
	
	@Override
	public String getTableName() 
	{
		return "FacilityFloor";
	}
}
