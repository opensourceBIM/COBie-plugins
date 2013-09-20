package org.erdc.cobie.sqlite.entities;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

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

	public Space()
	{
		super();
		
		Columns columns = new Columns(			 
			new Column<String>(ColumnName.SpaceCategory.toString(), null),
			new Column<String>(ColumnName.SpaceDescription.toString(), null),
			new Column<String>(ColumnName.SpaceName.toString(), CRUDEntity.STRING_NOT_NULL),
			new Column<String>(ColumnName.SpaceSignageName.toString(), null),
			new Column<Integer>(ColumnName.RefSpaceGrossAreaValue.toString(), null),
			new Column<Integer>(ColumnName.RefSpaceNetAreaValue.toString(), null),
			new Column<Integer>(ColumnName.RefSpaceUsableHeightValue.toString(), null));
		
		addColumns(columns);
	}
	
	@Override
	public String getName()
	{
		return (String)getColumn(ColumnName.SpaceName.toString()).getValue();
	}
	
	@Override
	public String getTableName()
	{
		return "Space";
	}
}
