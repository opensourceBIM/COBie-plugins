package org.erdc.cobie.sqlite.entity.relationship;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public final class AssetTypeAttribute extends Relationship
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
    
	public AssetTypeAttribute() throws CobieSQLiteException
	{
		super();
	}
	
    public AssetTypeAttribute(Row row) throws CobieSQLiteException
    {
    	super(row);
    }
    
	@Override
	public Long getChildKey() throws CobieSQLiteException 
	{
		return (Long)getColumn(ColumnName.RefAttribute.toString()).getValue();
	}

	@Override
	public Long getParentKey() throws CobieSQLiteException 
	{
		return (Long)getColumn(ColumnName.RefAssetType.toString()).getValue();
	}
	
	@Override
	public String getTableName() 
	{
		return "AssetTypeAttribute";
	}
	
	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
    	return new Row(
			new Column<>(Integer.class, ColumnName.RefAssetType.toString(), null, true),
			new Column<>(Integer.class, ColumnName.RefAttribute.toString(), null, true));
	}
	
	@Override
	public void setChildKey(Long key) throws CobieSQLiteException 
	{
		getColumn(ColumnName.RefAttribute.toString()).update(key);
	}

	@Override
	public void setParentKey(Long key) throws CobieSQLiteException 
	{
		getColumn(ColumnName.RefAssetType.toString()).update(key);
	}
}
