package org.erdc.cobie.sqlite.entities.relationships;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public class SpaceZone extends Relationship 
{
    public enum ColumnName
    {
        RefSpace("RefSpace"),
        RefZone("RefZone");        

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
    
    public SpaceZone()
    {
    	super();
    	
    	Columns columns = new Columns(
    			new Column<Integer>(ColumnName.RefSpace.toString(), null, true),
    			new Column<Integer>(ColumnName.RefZone.toString(), null, true));
    	
    	addColumns(columns);
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public Column<Integer> getChildKey() 
	{
		return (Column<Integer>)getColumn(ColumnName.RefZone.toString());
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
		return "SpaceZone";
	}
}
