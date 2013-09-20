package org.erdc.cobie.sqlite.entities.relationships;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public class FacilityAttribute extends Relationship
{
    public enum ColumnName
    {        
        RefAttribute("RefAttribute"),
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
    
    public FacilityAttribute()
    {
    	super();
    	
    	Columns columns = new Columns(    			
    			new Column<Integer>(ColumnName.RefAttribute.toString(), null, true),
    			new Column<Integer>(ColumnName.RefFacility.toString(), null, true));
    	
    	addColumns(columns);
    }
    
	@Override
	public String getTableName() 
	{
		return "FacilityAttribute";
	}
}
