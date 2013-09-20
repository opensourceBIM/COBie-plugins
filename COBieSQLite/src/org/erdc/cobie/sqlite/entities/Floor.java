package org.erdc.cobie.sqlite.entities;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public final class Floor extends CobieAttributesEntity
{
	public enum ColumnName
	{			 
		FloorCategory("FloorCategory"),
		FloorDescription("FloorDescription"),
		FloorName("FloorName"),
		RefFloorElevationValue("RefFloorElevationValue"),
		RefFloorHeightValue("RefFloorHeightValue");

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

	public Floor()
	{
		super();
		
		Columns columns = new Columns(			 
			new Column<String>(ColumnName.FloorCategory.toString(), null),
			new Column<String>(ColumnName.FloorDescription.toString(), null),
			new Column<String>(ColumnName.FloorName.toString(), CRUDEntity.STRING_NOT_NULL),
			new Column<Integer>(ColumnName.RefFloorElevationValue.toString(), null),
			new Column<Integer>(ColumnName.RefFloorHeightValue.toString(), null));
		
		addColumns(columns);
	}

	@Override
	public String getName()
	{
		return (String)getColumn(ColumnName.FloorName.toString()).getValue();
	}
	
	@Override
	public String getTableName()
	{
		return "Floor";
	}
}
