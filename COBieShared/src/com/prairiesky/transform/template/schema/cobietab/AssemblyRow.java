package com.prairiesky.transform.template.schema.cobietab;

import java.util.Calendar;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateRow;
import org.nibs.cobie.tab.AssemblyType;
@ExcelReference(spreadsheetName="Assembly")
public class AssemblyRow extends SpreadsheetTemplateRow
{
	private final Property<String> name = new Property<>(String.class);
	private final Property<String> createdBy = new Property<>(String.class);
	private final Property<Calendar> createdOn = new Property<>(Calendar.class);
	private final Property<String> sheetName = new Property<>(String.class);
	private final Property<String> parentName = new Property<>(String.class);
	private final Property<String> childNames = new Property<>(String.class);
	private final Property<String> assemblyType = new Property<>(String.class);
	private final Property<String> extSystem = new Property<>(String.class);
	private final Property<String> extObject = new Property<>(String.class);
	private final Property<String> extIdentifier = new Property<>(String.class);
	private final Property<String> description = new Property<>(String.class);

	@ExcelReference(columnAddress = ColumnAddress.A, columnName = "Name", isPrimaryKey = false)
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

	@ExcelReference(columnAddress = ColumnAddress.D, columnName = "SheetName", isPrimaryKey = false)
	public final Property<String> SheetName()
	{
		return sheetName;
	}

	@ExcelReference(columnAddress = ColumnAddress.E, columnName = "ParentName", isPrimaryKey = false)
	public final Property<String> ParentName()
	{
		return parentName;
	}

	@ExcelReference(columnAddress = ColumnAddress.F, columnName = "ChildNames", isPrimaryKey = false)
	public final Property<String> ChildNames()
	{
		return childNames;
	}

	@ExcelReference(columnAddress = ColumnAddress.G, columnName = "AssemblyType", isPrimaryKey = false)
	public final Property<String> AssemblyType()
	{
		return assemblyType;
	}

	@ExcelReference(columnAddress = ColumnAddress.H, columnName = "ExtSystem", isPrimaryKey = false)
	public final Property<String> ExtSystem()
	{
		return extSystem;
	}

	@ExcelReference(columnAddress = ColumnAddress.I, columnName = "ExtObject", isPrimaryKey = false)
	public final Property<String> ExtObject()
	{
		return extObject;
	}

	@ExcelReference(columnAddress = ColumnAddress.J, columnName = "ExtIdentifier", isPrimaryKey = false)
	public final Property<String> ExtIdentifier()
	{
		return extIdentifier;
	}

	@ExcelReference(columnAddress = ColumnAddress.K, columnName = "Description", isPrimaryKey = false)
	public final Property<String> Description()
	{
		return description;
	}
	
	public void populateFromCobieAssembly(AssemblyType assembly)
	{
		Name().set(assembly.getName());
		CreatedBy().set(assembly.getCreatedBy());
		CreatedOn().set(assembly.getCreatedOn());
		SheetName().set(assembly.getSheetName());
		ParentName().set(assembly.getParentName());
		ChildNames().set(assembly.getChildNames());
		AssemblyType().set(assembly.getAssemblyType());
		ExtSystem().set(assembly.getExtSystem());
		ExtObject().set(assembly.getExtObject());
		ExtIdentifier().set(assembly.getExtIdentifier());
		Description().set(assembly.getDescription());

	}

}
