package org.erdc.cobie.sqlite.entities.relationships;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public class AssetAttribute extends Relationship
{
    public enum ColumnName
    {
        RefAsset("RefAsset"),
        RefAttribute("RefAttribute");        

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
    
    public AssetAttribute()
    {
    	super();
    	
    	Columns columns = new Columns(
    			new Column<Integer>(ColumnName.RefAsset.toString(), null, true),
    			new Column<Integer>(ColumnName.RefAttribute.toString(), null, true));
    	
    	addColumns(columns);
    }
    
	@Override
	public String getTableName() 
	{
		return "AssetAttribute";
	}
}
