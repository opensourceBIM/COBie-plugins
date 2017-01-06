package com.prairiesky.transform.template.schema.cobietab;

import java.util.Calendar;
import org.nibs.cobie.tab.ImpactType;
import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateRow;

@ExcelReference(spreadsheetName="Impact")
public class ImpactRow extends SpreadsheetTemplateRow
{
	private final Property<String> name = new Property<>(String.class);
	private final Property<String> createdBy = new Property<>(String.class);
	private final Property<Calendar> createdOn = new Property<>(Calendar.class);
	private final Property<String> impactType = new Property<>(String.class);
	private final Property<String> impactStage = new Property<>(String.class);
	private final Property<String> sheetName = new Property<>(String.class);
	private final Property<String> rowName = new Property<>(String.class);
	private final Property<String> value = new Property<>(String.class);
	private final Property<String> impactUnit = new Property<>(String.class);
	private final Property<String> leadInTime = new Property<>(String.class);
	private final Property<String> duration = new Property<>(String.class);
	private final Property<String> leadOutTime = new Property<>(String.class);
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

	@ExcelReference(columnAddress = ColumnAddress.D, columnName = "ImpactType", isPrimaryKey = false)
	public final Property<String> ImpactType()
	{
		return impactType;
	}

	@ExcelReference(columnAddress = ColumnAddress.E, columnName = "ImpactStage", isPrimaryKey = false)
	public final Property<String> ImpactStage()
	{
		return impactStage;
	}

	@ExcelReference(columnAddress = ColumnAddress.F, columnName = "SheetName", isPrimaryKey = false)
	public final Property<String> SheetName()
	{
		return sheetName;
	}

	@ExcelReference(columnAddress = ColumnAddress.G, columnName = "RowName", isPrimaryKey = false)
	public final Property<String> RowName()
	{
		return rowName;
	}

	@ExcelReference(columnAddress = ColumnAddress.H, columnName = "Value", isPrimaryKey = false)
	public final Property<String> Value()
	{
		return value;
	}

	@ExcelReference(columnAddress = ColumnAddress.I, columnName = "ImpactUnit", isPrimaryKey = false)
	public final Property<String> ImpactUnit()
	{
		return impactUnit;
	}

	@ExcelReference(columnAddress = ColumnAddress.J, columnName = "LeadInTime", isPrimaryKey = false)
	public final Property<String> LeadInTime()
	{
		return leadInTime;
	}

	@ExcelReference(columnAddress = ColumnAddress.K, columnName = "Duration", isPrimaryKey = false)
	public final Property<String> Duration()
	{
		return duration;
	}

	@ExcelReference(columnAddress = ColumnAddress.L, columnName = "LeadOutTime", isPrimaryKey = false)
	public final Property<String> LeadOutTime()
	{
		return leadOutTime;
	}

	@ExcelReference(columnAddress = ColumnAddress.M, columnName = "ExtSystem", isPrimaryKey = false)
	public final Property<String> ExtSystem()
	{
		return extSystem;
	}

	@ExcelReference(columnAddress = ColumnAddress.N, columnName = "ExtObject", isPrimaryKey = false)
	public final Property<String> ExtObject()
	{
		return extObject;
	}

	@ExcelReference(columnAddress = ColumnAddress.O, columnName = "ExtIdentifier", isPrimaryKey = false)
	public final Property<String> ExtIdentifier()
	{
		return extIdentifier;
	}

	@ExcelReference(columnAddress = ColumnAddress.P, columnName = "Description", isPrimaryKey = false)
	public final Property<String> Description()
	{
		return description;
	}
	
	public void populateFromCobieImpact(ImpactType impact)
	{
		Name().set(impact.getName());
		CreatedBy().set(impact.getCreatedBy());
		CreatedOn().set(impact.getCreatedOn());
		ImpactType().set(impact.getImpactType());
		ImpactStage().set(impact.getImpactStage());
		SheetName().set(impact.getSheetName());
		RowName().set(impact.getRowName());
		Value().set(impact.getValue());
		ImpactUnit().set(impact.getImpactUnit());
		LeadInTime().set(impact.getLeadInTime());
		Duration().set(impact.getDuration());
		LeadOutTime().set(impact.getLeadOutTime());
		ExtSystem().set(impact.getExtSystem());
		ExtObject().set(impact.getExtObject());
		ExtIdentifier().set(impact.getExtIdentifier());
		Description().set(impact.getDescription());

	}

}
