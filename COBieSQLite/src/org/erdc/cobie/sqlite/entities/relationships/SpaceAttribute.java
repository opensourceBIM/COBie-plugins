package org.erdc.cobie.sqlite.entities.relationships;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public class SpaceAttribute extends Relationship
{
    public enum ColumnName
    {        
        RefAttribute("RefAttribute"),
        RefSpace("RefSpace");

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
    
    public SpaceAttribute()
    {
    	super();
    	
    	Columns columns = new Columns(    			
    			new Column<Integer>(ColumnName.RefAttribute.toString(), null, true),
    			new Column<Integer>(ColumnName.RefSpace.toString(), null, true));
    	
    	addColumns(columns);
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public Column<Integer> getChildKey() 
	{
		return (Column<Integer>)getColumn(ColumnName.RefAttribute.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Column<Integer> getParentKey() 
	{
		return (Column<Integer>)getColumn(ColumnName.RefSpace.toString());
	}
	
	@Override
	public String getTableName() 
	{
		return "SpaceAttribute";
	}
}