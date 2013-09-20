package org.erdc.cobie.sqlite.entities.relationships;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public class AssetTypeAsset extends Relationship
{
    public enum ColumnName
    {
        RefAsset("RefAsset"),
        RefAssetType("RefAssetType");        

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
    
    public AssetTypeAsset()
    {
    	super();
    	
    	Columns columns = new Columns(
    			new Column<Integer>(ColumnName.RefAsset.toString(), null, true),
    			new Column<Integer>(ColumnName.RefAssetType.toString(), null, true));
    	
    	addColumns(columns);
    }
    
	@Override
	public String getTableName() 
	{
		return "AssetTypeAsset";
	}
}
