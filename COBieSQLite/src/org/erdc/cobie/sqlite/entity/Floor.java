package org.erdc.cobie.sqlite.entity;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

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

	public Floor() throws CobieSQLiteException
	{
		super();
	}
	
	public Floor(Row row) throws CobieSQLiteException
	{
		super(row);
	}
	
	public final String getFloorCategory() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.FloorCategory.toString()).getValue();
	}

	public final String getFloorDescription() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.FloorDescription.toString()).getValue();
	}

	public final String getFloorName() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.FloorName.toString()).getValue();
	}

	@SuppressWarnings("boxing")
	public final int getRefFloorElevationValue() throws CobieSQLiteException
	{
		return (Integer)getColumn(ColumnName.RefFloorElevationValue.toString()).getValue();
	}

	@SuppressWarnings("boxing")
	public final int getRefFloorHeightValue() throws CobieSQLiteException
	{
		return (Integer)getColumn(ColumnName.RefFloorHeightValue.toString()).getValue();
	}

	@Override
	public String getTableName()
	{
		return "Floor";
	}

	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
    	Row row = new Row(
					new Column<>(String.class, ColumnName.FloorCategory.toString(), null), 
					new Column<>(String.class, ColumnName.FloorDescription.toString(), null), 
					new Column<>(String.class, ColumnName.FloorName.toString(), Entity.STRING_NOT_NULL), 
					new Column<>(Integer.class, ColumnName.RefFloorElevationValue.toString(), null), 
					new Column<>(Integer.class, ColumnName.RefFloorHeightValue.toString(), null));
    	
    	row.add(super.makeRow().getColumns());
    	
    	return row;
	}
	
	public final void setFloorCategory(String floorCategory) throws CobieSQLiteException
	{
		getColumn(ColumnName.FloorCategory.toString()).update(floorCategory);
	}

	public final void setFloorDescription(String floorDescription) throws CobieSQLiteException
	{
		getColumn(ColumnName.FloorDescription.toString()).update(floorDescription);
	}

	public final void setFloorName(String floorName) throws CobieSQLiteException
	{
		getColumn(ColumnName.FloorName.toString()).update(floorName);
	}

	@SuppressWarnings("boxing")
	public final void setRefFloorElevationValue(int refFloorElevationValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.RefFloorElevationValue.toString()).update(refFloorElevationValue);
	}

	@SuppressWarnings("boxing")
	public final void setRefFloorHeightValue(int refFloorHeightValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.RefFloorHeightValue.toString()).update(refFloorHeightValue);
	}
}
