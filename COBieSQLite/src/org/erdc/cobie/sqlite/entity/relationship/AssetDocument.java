package org.erdc.cobie.sqlite.entity.relationship;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public final class AssetDocument extends Relationship
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
    
	public AssetDocument() throws CobieSQLiteException
	{
		super();
	}
	
    public AssetDocument(Row row) throws CobieSQLiteException
    {
    	super(row);
    }
    
	@Override
	public Long getChildKey() throws CobieSQLiteException 
	{
		return (Long)getColumn(ColumnName.RefDocument.toString()).getValue();
	}

	@Override
	public Long getParentKey() throws CobieSQLiteException 
	{
		return (Long)getColumn(ColumnName.RefAsset.toString()).getValue();
	}
	
	@Override
	public String getTableName() 
	{
		return "AssetDocument";
	}
	
	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
    	return new Row(
			new Column<>(Integer.class, ColumnName.RefAsset.toString(), null, true),
			new Column<>(Integer.class, ColumnName.RefDocument.toString(), null, true));
	}
	
	@Override
	public void setChildKey(Long key) throws CobieSQLiteException 
	{
		getColumn(ColumnName.RefDocument.toString()).update(key);
	}

	@Override
	public void setParentKey(Long key) throws CobieSQLiteException 
	{
		getColumn(ColumnName.RefAsset.toString()).update(key);
	}
}
