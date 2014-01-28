package org.erdc.cobie.sqlite.entity;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public abstract class CobieAttributesEntity extends CobieEntity
{
	public enum ColumnName
	{
		ExternalEntityName("externalEntityName"), 
		ExternalID("externalID"), 
		ExternalSystemName("externalSystemName");

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

	protected CobieAttributesEntity() throws CobieSQLiteException
	{
		super();
	}
	
	protected CobieAttributesEntity(Row row) throws CobieSQLiteException
	{
		super(row);
	}
	
	public final String getExternalEntityName() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ExternalEntityName.toString()).getValue();
	}

	public final String getExternalID() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ExternalID.toString()).getValue();
	}

	public final String getExternalSystemName() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ExternalSystemName.toString()).getValue();
	}

	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
    	Row row = new Row(
				new Column<>(String.class, ColumnName.ExternalEntityName.toString(), null), 
				new Column<>(String.class, ColumnName.ExternalID.toString(), null), 
				new Column<>(String.class, ColumnName.ExternalSystemName.toString(), null));
    	
    	row.add(super.makeRow().getColumns());
    	
    	return row;
	}
	
	public final void setExternalEntityName(String externalEntityName) throws CobieSQLiteException
	{
		getColumn(ColumnName.ExternalEntityName.toString()).update(externalEntityName);
	}

	public final void setExternalID(String externalID) throws CobieSQLiteException
	{
		getColumn(ColumnName.ExternalID.toString()).update(externalID);
	}

	public final void setExternalSystemName(String externalSystemName) throws CobieSQLiteException
	{
		getColumn(ColumnName.ExternalSystemName.toString()).update(externalSystemName);
	}
}
