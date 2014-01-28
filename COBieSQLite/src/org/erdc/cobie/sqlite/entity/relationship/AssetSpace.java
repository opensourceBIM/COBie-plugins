package org.erdc.cobie.sqlite.entity.relationship;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public final class AssetSpace extends Relationship
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
    
	public AssetSpace() throws CobieSQLiteException
	{
		super();
	}
    
    public AssetSpace(Row row) throws CobieSQLiteException
    {
    	super(row);
    }
    
	@Override
	public Long getChildKey() throws CobieSQLiteException 
	{
		return (Long)getColumn(ColumnName.RefSpace.toString()).getValue();
	}

	@Override
	public Long getParentKey() throws CobieSQLiteException 
	{
		return (Long)getColumn(ColumnName.RefAsset.toString()).getValue();
	}
	
	@Override
	public String getTableName() 
	{
		return "AssetSpace";
	}
	
	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
    	return new Row(
			new Column<>(Integer.class, ColumnName.RefAsset.toString(), null, true),
			new Column<>(Integer.class, ColumnName.RefSpace.toString(), null, true));
	}
	
	@Override
	public void setChildKey(Long key) throws CobieSQLiteException 
	{
		getColumn(ColumnName.RefSpace.toString()).update(key);
	}

	@Override
	public void setParentKey(Long key) throws CobieSQLiteException 
	{
		getColumn(ColumnName.RefAsset.toString()).update(key);
	}
}
