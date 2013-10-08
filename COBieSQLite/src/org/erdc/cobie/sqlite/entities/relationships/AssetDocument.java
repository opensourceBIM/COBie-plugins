package org.erdc.cobie.sqlite.entities.relationships;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public class AssetDocument extends Relationship
{
    public enum ColumnName
    {
        RefAsset("RefAsset"),
        RefDocument("RefDocument");        

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
    
    public AssetDocument()
    {
    	super();
    	
    	Columns columns = new Columns(
    			new Column<Integer>(ColumnName.RefAsset.toString(), null, true),
    			new Column<Integer>(ColumnName.RefDocument.toString(), null, true));
    	
    	addColumns(columns);
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public Column<Integer> getChildKey() 
	{
		return (Column<Integer>)getColumn(ColumnName.RefDocument.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Column<Integer> getParentKey() 
	{
		return (Column<Integer>)getColumn(ColumnName.RefAsset.toString());
	}
	
	@Override
	public String getTableName() 
	{
		return "AssetDocument";
	}
}
