package org.erdc.cobie.sqlite.entities;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public final class Attribute extends CobieAttributesEntity 
{
	public enum ColumnName
	{	
		AttributeName("AttributeName"),
		AttributeCategory("AttributeCategory"),
		AttributeDescription("AttributeDescription"),
		propertySetName("propertySetName"),
		propertySetExternalIdentifier("propertySetExternalIdentifier"),
		RefValue("RefValue");

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
	
	public Attribute()
	{
		super();
		
		Columns columns = new Columns(
				new Column<String>(ColumnName.AttributeCategory.toString(), null),
				new Column<String>(ColumnName.AttributeDescription.toString(), null),
				new Column<String>(ColumnName.AttributeName.toString(), CRUDEntity.STRING_NOT_NULL),
				new Column<String>(ColumnName.propertySetExternalIdentifier.toString(), null),
				new Column<String>(ColumnName.propertySetName.toString(), null),
				new Column<Integer>(ColumnName.RefValue.toString(), null));
		
		addColumns(columns);
	}
	
	@Override
	public String getName()
	{
		return (String)getColumn(ColumnName.AttributeName.toString()).getValue();
	}
	
	@Override
	public String getTableName() 
	{
		return "Attribute";
	}
}
