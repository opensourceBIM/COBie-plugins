package org.erdc.cobie.sqlite.entity;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public final class Unit extends CobieEntity
{
    public enum ColumnName
    {
        UnitName("UnitName");        

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
    
	public Unit() throws CobieSQLiteException
	{
		super();
	}
	
    public Unit(Row row) throws CobieSQLiteException
    {
    	super(row);
    }
    
	@Override
	public String getTableName()
	{
		return "Unit";
	}
	
	public final String getUnitName() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.UnitName.toString()).getValue();
	}
	
	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
		Row row = new Row(new Column<>(String.class, ColumnName.UnitName.toString(), Entity.STRING_NOT_NULL));		
    	row.add(super.makeRow().getColumns());
    	
    	return row;
	}
	
	public final void setUnitName(String unitName) throws CobieSQLiteException
	{
		getColumn(ColumnName.UnitName.toString()).update(unitName);
	}
}
