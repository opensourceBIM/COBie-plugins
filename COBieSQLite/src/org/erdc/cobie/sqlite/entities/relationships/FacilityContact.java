package org.erdc.cobie.sqlite.entities.relationships;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public class FacilityContact extends Relationship 
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
    
    public FacilityContact()
    {
    	super();
    	
    	Columns columns = new Columns(    			
    			new Column<Integer>(ColumnName.RefContact.toString(), null, true),
    			new Column<Integer>(ColumnName.RefFacility.toString(), null, true));
    	
    	addColumns(columns);
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public Column<Integer> getChildKey() 
	{
		return (Column<Integer>)getColumn(ColumnName.RefContact.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Column<Integer> getParentKey() 
	{
		return (Column<Integer>)getColumn(ColumnName.RefFacility.toString());
	}
	
	@Override
	public String getTableName() 
	{
		return "FacilityContact";
	}
}
