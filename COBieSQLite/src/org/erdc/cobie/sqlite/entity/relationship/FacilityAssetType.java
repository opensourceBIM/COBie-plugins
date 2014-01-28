package org.erdc.cobie.sqlite.entity.relationship;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public final class FacilityAssetType extends Relationship
{
	public enum ColumnName
	{	
		RefAssetType("RefAssetType"),
		RefFacility("RefFacility");

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
	
	public FacilityAssetType() throws CobieSQLiteException
	{
		super();
	}
	
	public FacilityAssetType(Row row) throws CobieSQLiteException
	{
		super(row);
	}
	
	@Override
	public Long getChildKey() throws CobieSQLiteException 
	{
		return (Long)getColumn(ColumnName.RefAssetType.toString()).getValue();
	}

	@Override
	public Long getParentKey() throws CobieSQLiteException 
	{
		return (Long)getColumn(ColumnName.RefFacility.toString()).getValue();
	}
	
	@Override
	public String getTableName() 
	{
		return "FacilityAssetType";
	}
	
	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
		return new Row(
				new Column<>(Integer.class, ColumnName.RefAssetType.toString(), null, true),
				new Column<>(Integer.class, ColumnName.RefFacility.toString(), null, true));
	}
	
	@Override
	public void setChildKey(Long key) throws CobieSQLiteException 
	{
		getColumn(ColumnName.RefAssetType.toString()).update(key);
	}

	@Override
	public void setParentKey(Long key) throws CobieSQLiteException 
	{
		getColumn(ColumnName.RefFacility.toString()).update(key);
	}
}
