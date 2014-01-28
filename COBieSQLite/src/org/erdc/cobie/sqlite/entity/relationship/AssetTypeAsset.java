package org.erdc.cobie.sqlite.entity.relationship;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public final class AssetTypeAsset extends Relationship
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
    
	public AssetTypeAsset() throws CobieSQLiteException
	{
		super();
	}
	
    public AssetTypeAsset(Row row) throws CobieSQLiteException
    {
    	super(row);
    }
    
	@Override
	public Long getChildKey() throws CobieSQLiteException 
	{
		return (Long)getColumn(ColumnName.RefAsset.toString()).getValue();
	}

	@Override
	public Long getParentKey() throws CobieSQLiteException 
	{
		return (Long)getColumn(ColumnName.RefAssetType.toString()).getValue();
	}
	
	@Override
	public String getTableName() 
	{
		return "AssetTypeAsset";
	}
	
	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
    	return new Row(
			new Column<>(Integer.class, ColumnName.RefAsset.toString(), null, true),
			new Column<>(Integer.class, ColumnName.RefAssetType.toString(), null, true));
	}
	
	@Override
	public void setChildKey(Long key) throws CobieSQLiteException 
	{
		getColumn(ColumnName.RefAsset.toString()).update(key);
	}

	@Override
	public void setParentKey(Long key) throws CobieSQLiteException 
	{
		getColumn(ColumnName.RefAssetType.toString()).update(key);
	}
}
