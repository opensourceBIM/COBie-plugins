package com.prairiesky.transform.template.schema.cobietab;

import java.util.Calendar;

import org.nibs.cobie.tab.SpareType;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateRow;

@ExcelReference(spreadsheetName="Spare")
public class SpareRow extends SpreadsheetTemplateRow
{
	private final Property<String> name = new Property<>(String.class);
	private final Property<String> createdBy = new Property<>(String.class);
	private final Property<Calendar> createdOn = new Property<>(Calendar.class);
	private final Property<String> category = new Property<>(String.class);
	private final Property<String> typeName = new Property<>(String.class);
	private final Property<String> suppliers = new Property<>(String.class);
	private final Property<String> extSystem = new Property<>(String.class);
	private final Property<String> extObject = new Property<>(String.class);
	private final Property<String> extIdentifier = new Property<>(String.class);
	private final Property<String> description = new Property<>(String.class);
	private final Property<String> setNumber = new Property<>(String.class);
	private final Property<String> partNumber = new Property<>(String.class);

	@ExcelReference(columnAddress=ColumnAddress.A, columnName="Name", isPrimaryKey=true) public final Property<String> Name(){ return name;}
	@ExcelReference(columnAddress=ColumnAddress.B, columnName="CreatedBy", isPrimaryKey=false) public final Property<String> CreatedBy(){ return createdBy;}
	@ExcelReference(columnAddress=ColumnAddress.C, columnName="CreatedOn", isPrimaryKey=false) public final Property<Calendar> CreatedOn(){ return createdOn;}
	@ExcelReference(columnAddress=ColumnAddress.D, columnName="Category", isPrimaryKey=false) public final Property<String> Category(){ return category;}
	@ExcelReference(columnAddress=ColumnAddress.E, columnName="TypeName", isPrimaryKey=false) public final Property<String> TypeName(){ return typeName;}
	@ExcelReference(columnAddress=ColumnAddress.F, columnName="Suppliers", isPrimaryKey=false) public final Property<String> Suppliers(){ return suppliers;}
	@ExcelReference(columnAddress=ColumnAddress.G, columnName="ExtSystem", isPrimaryKey=false) public final Property<String> ExtSystem(){ return extSystem;}
	@ExcelReference(columnAddress=ColumnAddress.H, columnName="ExtObject", isPrimaryKey=false) public final Property<String> ExtObject(){ return extObject;}
	@ExcelReference(columnAddress=ColumnAddress.I, columnName="ExtIdentifier", isPrimaryKey=false) public final Property<String> ExtIdentifier(){ return extIdentifier;}
	@ExcelReference(columnAddress=ColumnAddress.J, columnName="Description", isPrimaryKey=false) public final Property<String> Description(){ return description;}
	@ExcelReference(columnAddress=ColumnAddress.K, columnName="SetNumber", isPrimaryKey=false) public final Property<String> SetNumber(){ return setNumber;}
	@ExcelReference(columnAddress=ColumnAddress.L, columnName="PartNumber", isPrimaryKey=false) public final Property<String> PartNumber(){ return partNumber;}

	public void populateFromCobieSpare(SpareType spare)
	{
		Name().set(spare.getName());
		CreatedBy().set(spare.getCreatedBy());
		CreatedOn().set(spare.getCreatedOn());
		Category().set(spare.getCategory());
		TypeName().set(spare.getTypeName());
		Suppliers().set(spare.getSuppliers());
		ExtSystem().set(spare.getExtSystem());
		ExtObject().set(spare.getExtObject());
		ExtIdentifier().set(spare.getExtIdentifier());
		Description().set(spare.getDescription());
		SetNumber().set(spare.getSetNumber());
		PartNumber().set(spare.getPartNumber());

	}
}
