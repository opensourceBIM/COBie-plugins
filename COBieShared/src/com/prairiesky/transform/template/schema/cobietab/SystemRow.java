package com.prairiesky.transform.template.schema.cobietab;

import java.util.Calendar;

import org.nibs.cobie.tab.SystemType;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateRow;

@ExcelReference(spreadsheetName="System")
public class SystemRow extends SpreadsheetTemplateRow
{
	private final Property<String> name = new Property<>(String.class);
	private final Property<String> createdBy = new Property<>(String.class);
	private final Property<Calendar> createdOn = new Property<>(Calendar.class);
	private final Property<String> category = new Property<>(String.class);
	private final Property<String> componentNames = new Property<>(String.class);
	private final Property<String> extSystem = new Property<>(String.class);
	private final Property<String> extObject = new Property<>(String.class);
	private final Property<String> extIdentifier = new Property<>(String.class);
	private final Property<String> description = new Property<>(String.class);

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

	@ExcelReference(columnAddress = ColumnAddress.E, columnName = "ComponentNames", isPrimaryKey = false)
	public final Property<String> ComponentNames()
	{
		return componentNames;
	}

	@ExcelReference(columnAddress = ColumnAddress.F, columnName = "ExtSystem", isPrimaryKey = false)
	public final Property<String> ExtSystem()
	{
		return extSystem;
	}

	@ExcelReference(columnAddress = ColumnAddress.G, columnName = "ExtObject", isPrimaryKey = false)
	public final Property<String> ExtObject()
	{
		return extObject;
	}

	@ExcelReference(columnAddress = ColumnAddress.H, columnName = "ExtIdentifier", isPrimaryKey = false)
	public final Property<String> ExtIdentifier()
	{
		return extIdentifier;
	}

	@ExcelReference(columnAddress = ColumnAddress.I, columnName = "Description", isPrimaryKey = false)
	public final Property<String> Description()
	{
		return description;
	}
	
	public void populateFromCobieSystem(SystemType system)
	{
		Name().set(system.getName());
		CreatedBy().set(system.getCreatedBy());
		CreatedOn().set(system.getCreatedOn());
		Category().set(system.getCategory());
		ComponentNames().set(system.getComponentNames());
		ExtSystem().set(system.getExtSystem());
		ExtObject().set(system.getExtObject());
		ExtIdentifier().set(system.getExtIdentifier());
		Description().set(system.getDescription());

	}

}
