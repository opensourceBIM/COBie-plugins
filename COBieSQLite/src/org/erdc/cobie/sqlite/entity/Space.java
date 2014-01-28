package org.erdc.cobie.sqlite.entity;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public final class Space extends CobieAttributesEntity
{
	public enum ColumnName
	{
		SpaceCategory("SpaceCategory"), 
		SpaceDescription("SpaceDescription"), 
		SpaceName("SpaceName"), 
		SpaceSignageName("SpaceSignageName"), 
		RefSpaceGrossAreaValue("RefSpaceGrossAreaValue"), 
		RefSpaceNetAreaValue("RefSpaceNetAreaValue"), 
		RefSpaceUsableHeightValue("RefSpaceUsableHeightValue");

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

	public Space() throws CobieSQLiteException
	{
		super();
	}
	
	public Space(Row row) throws CobieSQLiteException
	{
		super(row);
	}

	@SuppressWarnings("boxing")
	public final int getRefSpaceGrossAreaValue() throws CobieSQLiteException
	{
		return (Integer)getColumn(ColumnName.RefSpaceGrossAreaValue.toString()).getValue();
	}

	@SuppressWarnings("boxing")
	public final int getRefSpaceNetAreaValue() throws CobieSQLiteException
	{
		return (Integer)getColumn(ColumnName.RefSpaceNetAreaValue.toString()).getValue();
	}

	@SuppressWarnings("boxing")
	public final int getRefSpaceUsableHeightValue() throws CobieSQLiteException
	{
		return (Integer)getColumn(ColumnName.RefSpaceUsableHeightValue.toString()).getValue();
	}

	public final String getSpaceCategory() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.SpaceCategory.toString()).getValue();
	}

	public final String getSpaceDescription() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.SpaceDescription.toString()).getValue();
	}

	public final String getSpaceName() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.SpaceName.toString()).getValue();
	}

	public final String getSpaceSignageName() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.SpaceSignageName.toString()).getValue();
	}

	@Override
	public String getTableName()
	{
		return "Space";
	}

	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
		Row row = new Row(
					new Column<>(String.class, ColumnName.SpaceCategory.toString(), null), 
					new Column<>(String.class, ColumnName.SpaceDescription.toString(), null), 
					new Column<>(String.class, ColumnName.SpaceName.toString(), Entity.STRING_NOT_NULL), 
					new Column<>(String.class, ColumnName.SpaceSignageName.toString(), null), 
					new Column<>(Integer.class, ColumnName.RefSpaceGrossAreaValue.toString(), null), 
					new Column<>(Integer.class, ColumnName.RefSpaceNetAreaValue.toString(), null), 
					new Column<>(Integer.class, ColumnName.RefSpaceUsableHeightValue.toString(), null));
		
    	row.add(super.makeRow().getColumns());
    	
    	return row;
	}
	
	@SuppressWarnings("boxing")
	public final void setRefSpaceGrossAreaValue(int refSpaceGrossAreaValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.RefSpaceGrossAreaValue.toString()).update(refSpaceGrossAreaValue);
	}

	@SuppressWarnings("boxing")
	public final void setRefSpaceNetAreaValue(int refSpaceNetAreaValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.RefSpaceNetAreaValue.toString()).update(refSpaceNetAreaValue);
	}

	@SuppressWarnings("boxing")
	public final void setRefSpaceUsableHeightValue(int refSpaceUsableHeightValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.RefSpaceUsableHeightValue.toString()).update(refSpaceUsableHeightValue);
	}

	public final void setSpaceCategory(String spaceCategory) throws CobieSQLiteException
	{
		getColumn(ColumnName.SpaceCategory.toString()).update(spaceCategory);
	}

	public final void setSpaceDescription(String spaceDescription) throws CobieSQLiteException
	{
		getColumn(ColumnName.SpaceDescription.toString()).update(spaceDescription);
	}

	public final void setSpaceName(String spaceName) throws CobieSQLiteException
	{
		getColumn(ColumnName.SpaceName.toString()).update(spaceName);
	}

	public final void setSpaceSignageName(String spaceSignageName) throws CobieSQLiteException
	{
		getColumn(ColumnName.SpaceSignageName.toString()).update(spaceSignageName);
	}
}
