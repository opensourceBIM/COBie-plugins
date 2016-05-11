package com.prairiesky.transform.template.schema.cobietab;

import java.util.Calendar;
import org.nibs.cobie.tab.ConnectionType;
import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateRow;

@ExcelReference(spreadsheetName="Connection")
public class ConnectionRow extends SpreadsheetTemplateRow
{
	private final Property<String> name = new Property<>(String.class);
	private final Property<String> createdBy = new Property<>(String.class);
	private final Property<Calendar> createdOn = new Property<>(Calendar.class);
	private final Property<String> connectionType = new Property<>(String.class);
	private final Property<String> sheetName = new Property<>(String.class);
	private final Property<String> rowName1 = new Property<>(String.class);
	private final Property<String> rowName2 = new Property<>(String.class);
	private final Property<String> realizingElement = new Property<>(
			String.class);
	private final Property<String> portName1 = new Property<>(String.class);
	private final Property<String> portName2 = new Property<>(String.class);
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

	@ExcelReference(columnAddress = ColumnAddress.D, columnName = "ConnectionType", isPrimaryKey = false)
	public final Property<String> ConnectionType()
	{
		return connectionType;
	}

	@ExcelReference(columnAddress = ColumnAddress.E, columnName = "SheetName", isPrimaryKey = false)
	public final Property<String> SheetName()
	{
		return sheetName;
	}

	@ExcelReference(columnAddress = ColumnAddress.F, columnName = "RowName1", isPrimaryKey = false)
	public final Property<String> RowName1()
	{
		return rowName1;
	}

	@ExcelReference(columnAddress = ColumnAddress.G, columnName = "RowName2", isPrimaryKey = false)
	public final Property<String> RowName2()
	{
		return rowName2;
	}

	@ExcelReference(columnAddress = ColumnAddress.H, columnName = "RealizingElement", isPrimaryKey = false)
	public final Property<String> RealizingElement()
	{
		return realizingElement;
	}

	@ExcelReference(columnAddress = ColumnAddress.I, columnName = "PortName1", isPrimaryKey = false)
	public final Property<String> PortName1()
	{
		return portName1;
	}

	@ExcelReference(columnAddress = ColumnAddress.J, columnName = "PortName2", isPrimaryKey = false)
	public final Property<String> PortName2()
	{
		return portName2;
	}

	@ExcelReference(columnAddress = ColumnAddress.K, columnName = "ExtSystem", isPrimaryKey = false)
	public final Property<String> ExtSystem()
	{
		return extSystem;
	}

	@ExcelReference(columnAddress = ColumnAddress.L, columnName = "ExtObject", isPrimaryKey = false)
	public final Property<String> ExtObject()
	{
		return extObject;
	}

	@ExcelReference(columnAddress = ColumnAddress.M, columnName = "ExtIdentifier", isPrimaryKey = false)
	public final Property<String> ExtIdentifier()
	{
		return extIdentifier;
	}

	@ExcelReference(columnAddress = ColumnAddress.N, columnName = "Description", isPrimaryKey = false)
	public final Property<String> Description()
	{
		return description;
	}
	
	public void populateFromCobieConnection(ConnectionType connection)
	{
		Name().set(connection.getName());
		CreatedBy().set(connection.getCreatedBy());
		CreatedOn().set(connection.getCreatedOn());
		ConnectionType().set(connection.getConnectionType());
		SheetName().set(connection.getSheetName());
		RowName1().set(connection.getRowName1());
		RowName2().set(connection.getRowName2());
		RealizingElement().set(connection.getRealizingElement());
		PortName1().set(connection.getPortName1());
		PortName2().set(connection.getPortName2());
		ExtSystem().set(connection.getExtSystem());
		ExtObject().set(connection.getExtObject());
		ExtIdentifier().set(connection.getExtIdentifier());
		Description().set(connection.getDescription());

	}

}
