package org.erdc.cobie.sqlite.entities;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public class Unit extends CobieEntity
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
    
    public Unit()
    {
    	super();
    	
    	Columns columns = new Columns(new Column<String>(ColumnName.UnitName.toString(), CRUDEntity.STRING_NOT_NULL));
    	addColumns(columns);
    }
    
    @Override
    public String getName()
    {
    	return (String)getColumn(ColumnName.UnitName.toString()).getValue();
    }
    
	@Override
	public String getTableName()
	{
		return "Unit";
	}
}
