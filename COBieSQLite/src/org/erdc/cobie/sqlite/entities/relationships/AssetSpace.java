package org.erdc.cobie.sqlite.entities.relationships;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public class AssetSpace extends Relationship
{
    public enum ColumnName
    {
        RefAsset("RefAsset"),
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
    
    public AssetSpace()
    {
    	super();
    	
    	Columns columns = new Columns(
    			new Column<Integer>(ColumnName.RefAsset.toString(), null, true),
    			new Column<Integer>(ColumnName.RefSpace.toString(), null, true));
    	
    	addColumns(columns);
    }
    
	@Override
	public String getTableName() 
	{
		return "AssetSpace";
	}
}
