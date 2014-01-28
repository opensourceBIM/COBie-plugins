package org.erdc.cobie.sqlite.entity;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public final class Zone extends CobieAttributesEntity
{
	public enum ColumnName
	{
		ZoneCategory("ZoneCategory"), 
		ZoneDescription("ZoneDescription"), 
		ZoneName("ZoneName");

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

	public Zone() throws CobieSQLiteException
	{
		super();
	}
	
	public Zone(Row row) throws CobieSQLiteException
	{
		super(row);
	}

	@Override
	public String getTableName()
	{
		return "Zone";
	}

	public final String getZoneCategory() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ZoneCategory.toString()).getValue();
	}

	public final String getZoneDescription() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ZoneDescription.toString()).getValue();
	}

	public final String getZoneName() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ZoneName.toString()).getValue();
	}

	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
		Row row = new Row(
					new Column<>(String.class, ColumnName.ZoneCategory.toString(), null), 
					new Column<>(String.class, ColumnName.ZoneDescription.toString(), null), 
					new Column<>(String.class, ColumnName.ZoneName.toString(), Entity.STRING_NOT_NULL));
		
    	row.add(super.makeRow().getColumns());
    	
    	return row;
	}
	
	public final void setZoneCategory(String zoneCategory) throws CobieSQLiteException
	{
		getColumn(ColumnName.ZoneCategory.toString()).update(zoneCategory);
	}

	public final void setZoneDescription(String zoneDescription) throws CobieSQLiteException
	{
		getColumn(ColumnName.ZoneDescription.toString()).update(zoneDescription);
	}

	public final void setZoneName(String zoneName) throws CobieSQLiteException
	{
		getColumn(ColumnName.ZoneName.toString()).update(zoneName);
	}
}
