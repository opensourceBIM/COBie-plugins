package com.prairiesky.transform.template.schema.cobietab;

import java.util.Calendar;

import org.nibs.cobie.tab.JobType;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateRow;

@ExcelReference(spreadsheetName="Job")
public class JobRow extends SpreadsheetTemplateRow
{
	private final Property<String> name = new Property<>(String.class);
	private final Property<String> createdBy = new Property<>(String.class);
	private final Property<Calendar> createdOn = new Property<>(Calendar.class);
	private final Property<String> category = new Property<>(String.class);
	private final Property<String> status = new Property<>(String.class);
	private final Property<String> typeName = new Property<>(String.class);
	private final Property<String> description = new Property<>(String.class);
	private final Property<String> duration = new Property<>(String.class);
	private final Property<String> durationUnit = new Property<>(String.class);
	private final Property<String> start = new Property<>(String.class);
	private final Property<String> taskStartUnit = new Property<>(String.class);
	private final Property<String> frequency = new Property<>(String.class);
	private final Property<String> frequencyUnit = new Property<>(String.class);
	private final Property<String> extSystem = new Property<>(String.class);
	private final Property<String> extObject = new Property<>(String.class);
	private final Property<String> extIdentifier = new Property<>(String.class);
	private final Property<String> taskNumber = new Property<>(String.class);
	private final Property<String> priors = new Property<>(String.class);
	private final Property<String> resourceNames = new Property<>(String.class);

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

	@ExcelReference(columnAddress = ColumnAddress.E, columnName = "Status", isPrimaryKey = false)
	public final Property<String> Status()
	{
		return status;
	}

	@ExcelReference(columnAddress = ColumnAddress.F, columnName = "TypeName", isPrimaryKey = false)
	public final Property<String> TypeName()
	{
		return typeName;
	}

	@ExcelReference(columnAddress = ColumnAddress.G, columnName = "Description", isPrimaryKey = false)
	public final Property<String> Description()
	{
		return description;
	}

	@ExcelReference(columnAddress = ColumnAddress.H, columnName = "Duration", isPrimaryKey = false)
	public final Property<String> Duration()
	{
		return duration;
	}

	@ExcelReference(columnAddress = ColumnAddress.I, columnName = "DurationUnit", isPrimaryKey = false)
	public final Property<String> DurationUnit()
	{
		return durationUnit;
	}

	@ExcelReference(columnAddress = ColumnAddress.J, columnName = "Start", isPrimaryKey = false)
	public final Property<String> Start()
	{
		return start;
	}

	@ExcelReference(columnAddress = ColumnAddress.K, columnName = "TaskStartUnit", isPrimaryKey = false)
	public final Property<String> TaskStartUnit()
	{
		return taskStartUnit;
	}

	@ExcelReference(columnAddress = ColumnAddress.L, columnName = "Frequency", isPrimaryKey = false)
	public final Property<String> Frequency()
	{
		return frequency;
	}

	@ExcelReference(columnAddress = ColumnAddress.M, columnName = "FrequencyUnit", isPrimaryKey = false)
	public final Property<String> FrequencyUnit()
	{
		return frequencyUnit;
	}

	@ExcelReference(columnAddress = ColumnAddress.N, columnName = "ExtSystem", isPrimaryKey = false)
	public final Property<String> ExtSystem()
	{
		return extSystem;
	}

	@ExcelReference(columnAddress = ColumnAddress.O, columnName = "ExtObject", isPrimaryKey = false)
	public final Property<String> ExtObject()
	{
		return extObject;
	}

	@ExcelReference(columnAddress = ColumnAddress.P, columnName = "ExtIdentifier", isPrimaryKey = false)
	public final Property<String> ExtIdentifier()
	{
		return extIdentifier;
	}

	@ExcelReference(columnAddress = ColumnAddress.Q, columnName = "TaskNumber", isPrimaryKey = false)
	public final Property<String> TaskNumber()
	{
		return taskNumber;
	}

	@ExcelReference(columnAddress = ColumnAddress.R, columnName = "Priors", isPrimaryKey = false)
	public final Property<String> Priors()
	{
		return priors;
	}

	@ExcelReference(columnAddress = ColumnAddress.S, columnName = "ResourceNames", isPrimaryKey = false)
	public final Property<String> ResourceNames()
	{
		return resourceNames;
	}
	
	public void populateFromCobieJob(JobType job)
	{
		Name().set(job.getName());
		CreatedBy().set(job.getCreatedBy());
		CreatedOn().set(job.getCreatedOn());
		Category().set(job.getCategory());
		Status().set(job.getStatus());
		TypeName().set(job.getTypeName());
		Description().set(job.getDescription());
		Duration().set(job.getDuration());
		DurationUnit().set(job.getDurationUnit());
		Start().set(job.getStart());
		TaskStartUnit().set(job.getTaskStartUnit());
		Frequency().set(job.getFrequency());
		FrequencyUnit().set(job.getFrequencyUnit());
		ExtSystem().set(job.getExtSystem());
		ExtObject().set(job.getExtObject());
		ExtIdentifier().set(job.getExtIdentifier());
		TaskNumber().set(job.getTaskNumber());
		Priors().set(job.getPriors());
		ResourceNames().set(job.getResourceNames());

	}

}
