package org.erdc.cobie.sqlite.entities;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public abstract class CobieEntity extends CRUDEntity
{
    public enum ColumnName
    {
        ID("_id");

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
    
    protected CobieEntity()
    {
        super();
        
        Columns columns = new Columns(new Column<Integer>(ColumnName.ID.toString(), null, true));       
        addColumns(columns);
    }
    
    @SuppressWarnings("unchecked") // This should be okay.
	public final Column<Integer> getKey()
    {
    	return (Column<Integer>)getColumn(CobieEntity.ColumnName.ID.toString());
    }
    
    public abstract String getName();
}