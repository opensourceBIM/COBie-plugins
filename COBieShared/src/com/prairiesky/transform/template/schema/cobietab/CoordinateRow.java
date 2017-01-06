package com.prairiesky.transform.template.schema.cobietab;

import java.util.Calendar;

import org.nibs.cobie.tab.CoordinateType;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateRow;

@ExcelReference(spreadsheetName="Coordinate")
public class CoordinateRow extends SpreadsheetTemplateRow
{
	private final Property<String> name = new Property<>(String.class);
	private final Property<String> createdBy = new Property<>(String.class);
	private final Property<Calendar> createdOn = new Property<>(Calendar.class);
	private final Property<String> category = new Property<>(String.class);
	private final Property<String> sheetName = new Property<>(String.class);
	private final Property<String> rowName = new Property<>(String.class);
	private final Property<String> coordinateXAxis = new Property<>(String.class);
	private final Property<String> coordinateYAxis = new Property<>(String.class);
	private final Property<String> coordinateZAxis = new Property<>(String.class);
	private final Property<String> extSystem = new Property<>(String.class);
	private final Property<String> extObject = new Property<>(String.class);
	private final Property<String> extIdentifier = new Property<>(String.class);
	private final Property<String> clockwiseRotation = new Property<>(String.class);
	private final Property<String> elevationalRotation = new Property<>(String.class);
	private final Property<String> yawRotation = new Property<>(String.class);

	@ExcelReference(columnAddress=ColumnAddress.A, columnName="Name", isPrimaryKey=true) public final Property<String> Name(){ return name;}
	@ExcelReference(columnAddress=ColumnAddress.B, columnName="CreatedBy", isPrimaryKey=false) public final Property<String> CreatedBy(){ return createdBy;}
	@ExcelReference(columnAddress=ColumnAddress.C, columnName="CreatedOn", isPrimaryKey=false) public final Property<Calendar> CreatedOn(){ return createdOn;}
	@ExcelReference(columnAddress=ColumnAddress.D, columnName="Category", isPrimaryKey=false) public final Property<String> Category(){ return category;}
	@ExcelReference(columnAddress=ColumnAddress.E, columnName="SheetName", isPrimaryKey=true) public final Property<String> SheetName(){ return sheetName;}
	@ExcelReference(columnAddress=ColumnAddress.F, columnName="RowName", isPrimaryKey=true) public final Property<String> RowName(){ return rowName;}
	@ExcelReference(columnAddress=ColumnAddress.G, columnName="CoordinateXAxis", isPrimaryKey=false) public final Property<String> CoordinateXAxis(){ return coordinateXAxis;}
	@ExcelReference(columnAddress=ColumnAddress.H, columnName="CoordinateYAxis", isPrimaryKey=false) public final Property<String> CoordinateYAxis(){ return coordinateYAxis;}
	@ExcelReference(columnAddress=ColumnAddress.I, columnName="CoordinateZAxis", isPrimaryKey=false) public final Property<String> CoordinateZAxis(){ return coordinateZAxis;}
	@ExcelReference(columnAddress=ColumnAddress.J, columnName="ExtSystem", isPrimaryKey=false) public final Property<String> ExtSystem(){ return extSystem;}
	@ExcelReference(columnAddress=ColumnAddress.K, columnName="ExtObject", isPrimaryKey=false) public final Property<String> ExtObject(){ return extObject;}
	@ExcelReference(columnAddress=ColumnAddress.L, columnName="ExtIdentifier", isPrimaryKey=false) public final Property<String> ExtIdentifier(){ return extIdentifier;}
	@ExcelReference(columnAddress=ColumnAddress.M, columnName="ClockwiseRotation", isPrimaryKey=false) public final Property<String> ClockwiseRotation(){ return clockwiseRotation;}
	@ExcelReference(columnAddress=ColumnAddress.N, columnName="ElevationalRotation", isPrimaryKey=false) public final Property<String> ElevationalRotation(){ return elevationalRotation;}
	@ExcelReference(columnAddress=ColumnAddress.O, columnName="YawRotation", isPrimaryKey=false) public final Property<String> YawRotation(){ return yawRotation;}

	public void populateFromCobieCoordinate(CoordinateType coordinate)
	{
		Name().set(coordinate.getName());
		CreatedBy().set(coordinate.getCreatedBy());
		CreatedOn().set(coordinate.getCreatedOn());
		Category().set(coordinate.getCategory());
		SheetName().set(coordinate.getSheetName());
		RowName().set(coordinate.getRowName());
		CoordinateXAxis().set(coordinate.getCoordinateXAxis());
		CoordinateYAxis().set(coordinate.getCoordinateYAxis());
		CoordinateZAxis().set(coordinate.getCoordinateZAxis());
		ExtSystem().set(coordinate.getExtSystem());
		ExtObject().set(coordinate.getExtObject());
		ExtIdentifier().set(coordinate.getExtIdentifier());
		ClockwiseRotation().set(coordinate.getClockwiseRotation());
		ElevationalRotation().set(coordinate.getElevationalRotation());
		YawRotation().set(coordinate.getYawRotation());

	}
	
}
