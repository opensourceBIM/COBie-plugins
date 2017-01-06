package com.prairiesky.transform.template.schema.cobietab;

import java.util.Calendar;

import org.nibs.cobie.tab.SpaceType;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateRow;

@ExcelReference(spreadsheetName="Space")
public class SpaceRow extends SpreadsheetTemplateRow
{
	private final Property<String> name = new Property<>(String.class);
	private final Property<String> createdBy = new Property<>(String.class);
	private final Property<Calendar> createdOn = new Property<>(Calendar.class);
	private final Property<String> category = new Property<>(String.class);
	private final Property<String> floorName = new Property<>(String.class);
	private final Property<String> description = new Property<>(String.class);
	private final Property<String> extSystem = new Property<>(String.class);
	private final Property<String> extObject = new Property<>(String.class);
	private final Property<String> extIdentifier = new Property<>(String.class);
	private final Property<String> roomTag = new Property<>(String.class);
	private final Property<String> usableHeight = new Property<>(String.class);
	private final Property<String> grossArea = new Property<>(String.class);
	private final Property<String> netArea = new Property<>(String.class);

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

	@ExcelReference(columnAddress = ColumnAddress.E, columnName = "FloorName", isPrimaryKey = false)
	public final Property<String> FloorName()
	{
		return floorName;
	}

	@ExcelReference(columnAddress = ColumnAddress.F, columnName = "Description", isPrimaryKey = false)
	public final Property<String> Description()
	{
		return description;
	}

	@ExcelReference(columnAddress = ColumnAddress.G, columnName = "ExtSystem", isPrimaryKey = false)
	public final Property<String> ExtSystem()
	{
		return extSystem;
	}

	@ExcelReference(columnAddress = ColumnAddress.H, columnName = "ExtObject", isPrimaryKey = false)
	public final Property<String> ExtObject()
	{
		return extObject;
	}

	@ExcelReference(columnAddress = ColumnAddress.I, columnName = "ExtIdentifier", isPrimaryKey = false)
	public final Property<String> ExtIdentifier()
	{
		return extIdentifier;
	}

	@ExcelReference(columnAddress = ColumnAddress.J, columnName = "RoomTag", isPrimaryKey = false)
	public final Property<String> RoomTag()
	{
		return roomTag;
	}

	@ExcelReference(columnAddress = ColumnAddress.K, columnName = "UsableHeight", isPrimaryKey = false)
	public final Property<String> UsableHeight()
	{
		return usableHeight;
	}

	@ExcelReference(columnAddress = ColumnAddress.L, columnName = "GrossArea", isPrimaryKey = false)
	public final Property<String> GrossArea()
	{
		return grossArea;
	}

	@ExcelReference(columnAddress = ColumnAddress.M, columnName = "NetArea", isPrimaryKey = false)
	public final Property<String> NetArea()
	{
		return netArea;
	}
	
	public void populateFromCobieSpace(SpaceType space)
	{
		Name().set(space.getName());
		CreatedBy().set(space.getCreatedBy());
		CreatedOn().set(space.getCreatedOn());
		Category().set(space.getCategory());
		FloorName().set(space.getFloorName());
		Description().set(space.getDescription());
		ExtSystem().set(space.getExtSystem());
		ExtObject().set(space.getExtObject());
		ExtIdentifier().set(space.getExtIdentifier());
		RoomTag().set(space.getRoomTag());
		UsableHeight().set(space.getUsableHeight());
		GrossArea().set(space.getGrossArea());
		NetArea().set(space.getNetArea());

	}

}
