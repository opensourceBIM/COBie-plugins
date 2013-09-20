package org.erdc.cobie.sqlite.entities.relationships;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public class AssetTypeAttribute extends Relationship
{
    public enum ColumnName
    {
        RefAssetType("RefAssetType"),
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
    
    public AssetTypeAttribute()
    {
    	super();
    	
    	Columns columns = new Columns(
    			new Column<Integer>(ColumnName.RefAssetType.toString(), null, true),
    			new Column<Integer>(ColumnName.RefAttribute.toString(), null, true));
    	
    	addColumns(columns);
    }
    
	@Override
	public String getTableName() 
	{
		return "AssetTypeAttribute";
	}
}
