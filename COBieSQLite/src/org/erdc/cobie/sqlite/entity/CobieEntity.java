package org.erdc.cobie.sqlite.entity;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public abstract class CobieEntity extends Entity
{
	/**
	 * ColumnName should contain an enumeration of the columns contained in a specific entity. 
	 * 
	 * For convenience, it is recommended that these enumerated values be named to match the 
	 * actual column names as much as possible, i.e. "ExternalID" rather than "EXTERNAL_ID".
	 * 
	 * @author RDITLNBM
	 */
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
    
    protected CobieEntity() throws CobieSQLiteException
    {
    	super();
    }
    
    protected CobieEntity(Row row) throws CobieSQLiteException
    {
    	super(row);
    }
    
    public final Long getKey() throws CobieSQLiteException
    {
    	return (Long)getColumn(CobieEntity.ColumnName.ID.toString()).getValue();
    }
    
    @Override
	protected Row makeRow() throws CobieSQLiteException
    {
    	return new Row(new Column<>(Long.class, ColumnName.ID.toString(), null, true));
    }
    
    @SuppressWarnings("unchecked")
	public final void setKey(Long key) throws CobieSQLiteException
    {
    	Column<Long> keyColumn = (Column<Long>) getColumn(ColumnName.ID.toString());
    	keyColumn.update(key);
    	keyColumn.reset();
    }
}