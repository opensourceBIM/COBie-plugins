package com.prairiesky.transform.template.schema.productinstallation;

import org.nibs.cobie.tab.SpaceType;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateRow;

@ExcelReference(spreadsheetName="Space")
public class SpaceLookupRow extends SpreadsheetTemplateRow
{
	private final Property<String> roomNumber = new Property<>(String.class);
	private final Property<String> floorName = new Property<>(String.class);
	
	@ExcelReference(columnAddress=ColumnAddress.A, columnName="Room Number", isPrimaryKey=true)
	public final Property<String> RoomNumber()
	{
		return roomNumber;
	}
	
	@ExcelReference(columnAddress=ColumnAddress.B, columnName="FloorName", isPrimaryKey=false)
	public final Property<String> FloorName()
	{
		return floorName;
	}
	
	public void populateFromCobieSpace(SpaceType space)
	{
		FloorName().set(space.getFloorName());
		RoomNumber().set(space.getName());
	}

}
