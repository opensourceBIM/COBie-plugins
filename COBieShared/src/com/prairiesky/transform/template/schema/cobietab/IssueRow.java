package com.prairiesky.transform.template.schema.cobietab;

import java.util.Calendar;

import org.nibs.cobie.tab.IssueType;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateRow;

@ExcelReference(spreadsheetName="Issue")
public class IssueRow extends SpreadsheetTemplateRow
{
	private final Property<String> name = new Property<>(String.class);
	private final Property<String> createdBy = new Property<>(String.class);
	private final Property<Calendar> createdOn = new Property<>(Calendar.class);
	private final Property<String> type = new Property<>(String.class);
	private final Property<String> risk = new Property<>(String.class);
	private final Property<String> chance = new Property<>(String.class);
	private final Property<String> impact = new Property<>(String.class);
	private final Property<String> sheetName1 = new Property<>(String.class);
	private final Property<String> rowName1 = new Property<>(String.class);
	private final Property<String> sheetName2 = new Property<>(String.class);
	private final Property<String> rowName2 = new Property<>(String.class);
	private final Property<String> description = new Property<>(String.class);
	private final Property<String> owner = new Property<>(String.class);
	private final Property<String> mitigation = new Property<>(String.class);
	private final Property<String> extSystem = new Property<>(String.class);
	private final Property<String> extObject = new Property<>(String.class);
	private final Property<String> extIdentifier = new Property<>(String.class);

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

	@ExcelReference(columnAddress = ColumnAddress.D, columnName = "Type", isPrimaryKey = false)
	public final Property<String> Type()
	{
		return type;
	}

	@ExcelReference(columnAddress = ColumnAddress.E, columnName = "Risk", isPrimaryKey = false)
	public final Property<String> Risk()
	{
		return risk;
	}

	@ExcelReference(columnAddress = ColumnAddress.F, columnName = "Chance", isPrimaryKey = false)
	public final Property<String> Chance()
	{
		return chance;
	}

	@ExcelReference(columnAddress = ColumnAddress.G, columnName = "Impact", isPrimaryKey = false)
	public final Property<String> Impact()
	{
		return impact;
	}

	@ExcelReference(columnAddress = ColumnAddress.H, columnName = "SheetName1", isPrimaryKey = true)
	public final Property<String> SheetName1()
	{
		return sheetName1;
	}

	@ExcelReference(columnAddress = ColumnAddress.I, columnName = "RowName1", isPrimaryKey = true)
	public final Property<String> RowName1()
	{
		return rowName1;
	}

	@ExcelReference(columnAddress = ColumnAddress.J, columnName = "SheetName2", isPrimaryKey = true)
	public final Property<String> SheetName2()
	{
		return sheetName2;
	}

	@ExcelReference(columnAddress = ColumnAddress.K, columnName = "RowName2", isPrimaryKey = true)
	public final Property<String> RowName2()
	{
		return rowName2;
	}

	@ExcelReference(columnAddress = ColumnAddress.L, columnName = "Description", isPrimaryKey = false)
	public final Property<String> Description()
	{
		return description;
	}

	@ExcelReference(columnAddress = ColumnAddress.M, columnName = "Owner", isPrimaryKey = false)
	public final Property<String> Owner()
	{
		return owner;
	}

	@ExcelReference(columnAddress = ColumnAddress.N, columnName = "Mitigation", isPrimaryKey = false)
	public final Property<String> Mitigation()
	{
		return mitigation;
	}

	@ExcelReference(columnAddress = ColumnAddress.O, columnName = "ExtSystem", isPrimaryKey = false)
	public final Property<String> ExtSystem()
	{
		return extSystem;
	}

	@ExcelReference(columnAddress = ColumnAddress.P, columnName = "ExtObject", isPrimaryKey = false)
	public final Property<String> ExtObject()
	{
		return extObject;
	}

	@ExcelReference(columnAddress = ColumnAddress.Q, columnName = "ExtIdentifier", isPrimaryKey = false)
	public final Property<String> ExtIdentifier()
	{
		return extIdentifier;
	}
	
	public void populateFromCobieIssue(IssueType issue)
	{
		Name().set(issue.getName());
		CreatedBy().set(issue.getCreatedBy());
		CreatedOn().set(issue.getCreatedOn());
		Type().set(issue.getType());
		Risk().set(issue.getRisk());
		Chance().set(issue.getChance());
		Impact().set(issue.getImpact());
		SheetName1().set(issue.getSheetName1());
		RowName1().set(issue.getRowName1());
		SheetName2().set(issue.getSheetName2());
		RowName2().set(issue.getRowName2());
		Description().set(issue.getDescription());
		Owner().set(issue.getOwner());
		Mitigation().set(issue.getMitigation());
		ExtSystem().set(issue.getExtSystem());
		ExtObject().set(issue.getExtObject());
		ExtIdentifier().set(issue.getExtIdentifier());

	}

}
