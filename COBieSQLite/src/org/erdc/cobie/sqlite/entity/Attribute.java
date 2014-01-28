package org.erdc.cobie.sqlite.entity;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

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
	
	public Attribute() throws CobieSQLiteException
	{
		super();
	}
	
	public Attribute(Row row) throws CobieSQLiteException
	{
		super(row);
	}

	public final String getAttributeCategory() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.AttributeCategory.toString()).getValue();
	}

	public final String getAttributeDescription() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.AttributeDescription.toString()).getValue();
	}

	public final String getAttributeName() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.AttributeName.toString()).getValue();
	}

	public final String getPropertySetExternalIdentifier() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.propertySetExternalIdentifier.toString()).getValue();
	}

	public final String getPropertySetName() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.propertySetName.toString()).getValue();
	}

	@SuppressWarnings("boxing")
	public final int getRefValue() throws CobieSQLiteException
	{
		return (Integer)getColumn(ColumnName.RefValue.toString()).getValue();
	}

	@Override
	public String getTableName()
	{
		return "Attribute";
	}

	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
    	Row row = new Row(
					new Column<>(String.class, ColumnName.AttributeCategory.toString(), null), 
					new Column<>(String.class, ColumnName.AttributeDescription.toString(), null), 
					new Column<>(String.class, ColumnName.AttributeName.toString(), Entity.STRING_NOT_NULL), 
					new Column<>(String.class, ColumnName.propertySetExternalIdentifier.toString(), null), 
					new Column<>(String.class, ColumnName.propertySetName.toString(), null), 
					new Column<>(Integer.class, ColumnName.RefValue.toString(), null));
    	
    	row.add(super.makeRow().getColumns());
    	
    	return row;
	}
	
	public final void setAttributeCategory(String attributeCategory) throws CobieSQLiteException
	{
		getColumn(ColumnName.AttributeCategory.toString()).update(attributeCategory);
	}

	public final void setAttributeDescription(String attributeDescription) throws CobieSQLiteException
	{
		getColumn(ColumnName.AttributeDescription.toString()).update(attributeDescription);
	}

	public final void setAttributeName(String attributeName) throws CobieSQLiteException
	{
		getColumn(ColumnName.AttributeName.toString()).update(attributeName);
	}

	public final void setPropertySetExternalIdentifier(String propertySetExternalIdentifier) throws CobieSQLiteException
	{
		getColumn(ColumnName.propertySetExternalIdentifier.toString()).update(propertySetExternalIdentifier);
	}

	public final void setPropertySetName(String propertySetName) throws CobieSQLiteException
	{
		getColumn(ColumnName.propertySetName.toString()).update(propertySetName);
	}

	@SuppressWarnings("boxing")
	public final void setRefValue(int refValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.RefValue.toString()).update(refValue);
	}
}
