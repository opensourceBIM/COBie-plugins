package org.erdc.cobie.sqlite.entity.relationship;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public final class FacilityContact extends Relationship 
{
    public enum ColumnName
    {        
        RefContact("RefContact"),
        RefFacility("RefFacility");        

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
    
	public FacilityContact() throws CobieSQLiteException
	{
		super();
	}
	
    public FacilityContact(Row row) throws CobieSQLiteException
    {
    	super(row);
    }
    
	@Override
	public Long getChildKey() throws CobieSQLiteException 
	{
		return (Long)getColumn(ColumnName.RefContact.toString()).getValue();
	}

	@Override
	public Long getParentKey() throws CobieSQLiteException 
	{
		return (Long)getColumn(ColumnName.RefFacility.toString()).getValue();
	}
	
	@Override
	public String getTableName() 
	{
		return "FacilityContact";
	}
	
	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
    	return new Row(    			
			new Column<>(Integer.class, ColumnName.RefContact.toString(), null, true),
			new Column<>(Integer.class, ColumnName.RefFacility.toString(), null, true));
	}
	
	@Override
	public void setChildKey(Long key) throws CobieSQLiteException 
	{
		getColumn(ColumnName.RefContact.toString()).update(key);
	}

	@Override
	public void setParentKey(Long key) throws CobieSQLiteException 
	{
		getColumn(ColumnName.RefFacility.toString()).update(key);
	}
}
