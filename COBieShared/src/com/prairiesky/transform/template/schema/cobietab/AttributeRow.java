package com.prairiesky.transform.template.schema.cobietab;

import java.util.Calendar;

import org.nibs.cobie.tab.AttributeType;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateRow;

@ExcelReference(spreadsheetName="Attribute")
public class AttributeRow extends SpreadsheetTemplateRow
{
	private final Property<String> name = new Property<>(String.class);
	private final Property<String> createdBy = new Property<>(String.class);
	private final Property<Calendar> createdOn = new Property<>(Calendar.class);
	private final Property<String> category = new Property<>(String.class);
	private final Property<String> sheetName = new Property<>(String.class);
	private final Property<String> rowName = new Property<>(String.class);
	private final Property<String> value = new Property<>(String.class);
	private final Property<String> unit = new Property<>(String.class);
	private final Property<String> extSystem = new Property<>(String.class);
	private final Property<String> extObject = new Property<>(String.class);
	private final Property<String> extIdentifier = new Property<>(String.class);
	private final Property<String> description = new Property<>(String.class);
	private final Property<String> allowedValues = new Property<>(String.class);

	@ExcelReference(columnAddress = ColumnAddress.A, columnName = "Name", isPrimaryKey = true)
	public final Property<String> Name()
	{
		return name;
	}

	@ExcelReference(columnAddress = ColumnAddress.B, columnName = "CreatedBy", isPrimaryKey = false)
	public final Property<String> CreatedBy()
	{
		return createdBy;
	}

	@ExcelReference(columnAddress = ColumnAddress.C, columnName = "CreatedOn", isPrimaryKey = false)
	public final Property<Calendar> CreatedOn()
	{
		return createdOn;
	}

	@ExcelReference(columnAddress = ColumnAddress.D, columnName = "Category", isPrimaryKey = false)
	public final Property<String> Category()
	{
		return category;
	}

	@ExcelReference(columnAddress = ColumnAddress.E, columnName = "SheetName", isPrimaryKey = true)
	public final Property<String> SheetName()
	{
		return sheetName;
	}

	@ExcelReference(columnAddress = ColumnAddress.F, columnName = "RowName", isPrimaryKey = true)
	public final Property<String> RowName()
	{
		return rowName;
	}

	@ExcelReference(columnAddress = ColumnAddress.G, columnName = "Value", isPrimaryKey = false)
	public final Property<String> Value()
	{
		return value;
	}

	@ExcelReference(columnAddress = ColumnAddress.H, columnName = "Unit", isPrimaryKey = false)
	public final Property<String> Unit()
	{
		return unit;
	}

	@ExcelReference(columnAddress = ColumnAddress.I, columnName = "ExtSystem", isPrimaryKey = false)
	public final Property<String> ExtSystem()
	{
		return extSystem;
	}

	@ExcelReference(columnAddress = ColumnAddress.J, columnName = "ExtObject", isPrimaryKey = false)
	public final Property<String> ExtObject()
	{
		return extObject;
	}

	@ExcelReference(columnAddress = ColumnAddress.K, columnName = "ExtIdentifier", isPrimaryKey = false)
	public final Property<String> ExtIdentifier()
	{
		return extIdentifier;
	}

	@ExcelReference(columnAddress = ColumnAddress.L, columnName = "Description", isPrimaryKey = false)
	public final Property<String> Description()
	{
		return description;
	}

	@ExcelReference(columnAddress = ColumnAddress.M, columnName = "AllowedValues", isPrimaryKey = false)
	public final Property<String> AllowedValues()
	{
		return allowedValues;
	}
	
	public void populateFromCobieAttribute(AttributeType attribute)
	{
		Name().set(attribute.getName());
		CreatedBy().set(attribute.getCreatedBy());
		CreatedOn().set(attribute.getCreatedOn());
		Category().set(attribute.getCategory());
		SheetName().set(attribute.getSheetName());
		RowName().set(attribute.getRowName());
		Value().set(attribute.getValue());
		Unit().set(attribute.getUnit());
		ExtSystem().set(attribute.getExtSystem());
		ExtObject().set(attribute.getExtObject());
		ExtIdentifier().set(attribute.getExtIdentifier());
		Description().set(attribute.getDescription());
		AllowedValues().set(attribute.getAllowedValues());

	}

}
