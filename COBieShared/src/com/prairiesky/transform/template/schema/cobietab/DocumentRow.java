package com.prairiesky.transform.template.schema.cobietab;

import java.util.Calendar;

import org.nibs.cobie.tab.DocumentType;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateRow;

@ExcelReference(spreadsheetName="Document")
public class DocumentRow extends SpreadsheetTemplateRow
{
	private final Property<String> name = new Property<>(String.class);
	private final Property<String> createdBy = new Property<>(String.class);
	private final Property<Calendar> createdOn = new Property<>(Calendar.class);
	private final Property<String> category = new Property<>(String.class);
	private final Property<String> approvalBy = new Property<>(String.class);
	private final Property<String> stage = new Property<>(String.class);
	private final Property<String> sheetName = new Property<>(String.class);
	private final Property<String> rowName = new Property<>(String.class);
	private final Property<String> directory = new Property<>(String.class);
	private final Property<String> file = new Property<>(String.class);
	private final Property<String> extSystem = new Property<>(String.class);
	private final Property<String> extObject = new Property<>(String.class);
	private final Property<String> extIdentifier = new Property<>(String.class);
	private final Property<String> description = new Property<>(String.class);
	private final Property<String> reference = new Property<>(String.class);

	@ExcelReference(columnAddress=ColumnAddress.A, columnName="Name", isPrimaryKey=true) public final Property<String> Name(){ return name;}
	@ExcelReference(columnAddress=ColumnAddress.B, columnName="CreatedBy", isPrimaryKey=false) public final Property<String> CreatedBy(){ return createdBy;}
	@ExcelReference(columnAddress=ColumnAddress.C, columnName="CreatedOn", isPrimaryKey=false) public final Property<Calendar> CreatedOn(){ return createdOn;}
	@ExcelReference(columnAddress=ColumnAddress.D, columnName="Category", isPrimaryKey=false) public final Property<String> Category(){ return category;}
	@ExcelReference(columnAddress=ColumnAddress.E, columnName="ApprovalBy", isPrimaryKey=false) public final Property<String> ApprovalBy(){ return approvalBy;}
	@ExcelReference(columnAddress=ColumnAddress.F, columnName="Stage", isPrimaryKey=false) public final Property<String> Stage(){ return stage;}
	@ExcelReference(columnAddress=ColumnAddress.G, columnName="SheetName", isPrimaryKey=true) public final Property<String> SheetName(){ return sheetName;}
	@ExcelReference(columnAddress=ColumnAddress.H, columnName="RowName", isPrimaryKey=true) public final Property<String> RowName(){ return rowName;}
	@ExcelReference(columnAddress=ColumnAddress.I, columnName="Directory", isPrimaryKey=false) public final Property<String> Directory(){ return directory;}
	@ExcelReference(columnAddress=ColumnAddress.J, columnName="File", isPrimaryKey=false) public final Property<String> File(){ return file;}
	@ExcelReference(columnAddress=ColumnAddress.K, columnName="ExtSystem", isPrimaryKey=false) public final Property<String> ExtSystem(){ return extSystem;}
	@ExcelReference(columnAddress=ColumnAddress.L, columnName="ExtObject", isPrimaryKey=false) public final Property<String> ExtObject(){ return extObject;}
	@ExcelReference(columnAddress=ColumnAddress.M, columnName="ExtIdentifier", isPrimaryKey=false) public final Property<String> ExtIdentifier(){ return extIdentifier;}
	@ExcelReference(columnAddress=ColumnAddress.N, columnName="Description", isPrimaryKey=false) public final Property<String> Description(){ return description;}
	@ExcelReference(columnAddress=ColumnAddress.O, columnName="Reference", isPrimaryKey=false) public final Property<String> Reference(){ return reference;}

	public void populateFromCobieDocument(DocumentType document)
	{
		Name().set(document.getName());
		CreatedBy().set(document.getCreatedBy());
		CreatedOn().set(document.getCreatedOn());
		Category().set(document.getCategory());
		ApprovalBy().set(document.getApprovalBy());
		Stage().set(document.getStage());
		SheetName().set(document.getSheetName());
		RowName().set(document.getRowName());
		Directory().set(document.getDirectory());
		File().set(document.getFile());
		ExtSystem().set(document.getExtSystem());
		ExtObject().set(document.getExtObject());
		ExtIdentifier().set(document.getExtIdentifier());
		Description().set(document.getDescription());
		Reference().set(document.getReference());

	}
	
}
