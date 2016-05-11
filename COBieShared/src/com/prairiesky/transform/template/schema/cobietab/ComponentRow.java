package com.prairiesky.transform.template.schema.cobietab;

import java.util.Calendar;

import org.nibs.cobie.tab.ComponentType;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateRow;

@ExcelReference(spreadsheetName="Component")
public class ComponentRow extends SpreadsheetTemplateRow
{
	private final Property<String> name = new Property<>(String.class);
	private final Property<String> createdBy = new Property<>(String.class);
	private final Property<Calendar> createdOn = new Property<>(Calendar.class);
	private final Property<String> typeName = new Property<>(String.class);
	private final Property<String> space = new Property<>(String.class);
	private final Property<String> description = new Property<>(String.class);
	private final Property<String> extSystem = new Property<>(String.class);
	private final Property<String> extObject = new Property<>(String.class);
	private final Property<String> extIdentifier = new Property<>(String.class);
	private final Property<String> serialNumber = new Property<>(String.class);
	private final Property<String> installationDate = new Property<>(
			String.class);
	private final Property<String> warrantyStartDate = new Property<>(
			String.class);
	private final Property<String> tagNumber = new Property<>(String.class);
	private final Property<String> barCode = new Property<>(String.class);
	private final Property<String> assetIdentifier = new Property<>(
			String.class);

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

	@ExcelReference(columnAddress = ColumnAddress.D, columnName = "TypeName", isPrimaryKey = false)
	public final Property<String> TypeName()
	{
		return typeName;
	}

	@ExcelReference(columnAddress = ColumnAddress.E, columnName = "Space", isPrimaryKey = false)
	public final Property<String> Space()
	{
		return space;
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

	@ExcelReference(columnAddress = ColumnAddress.J, columnName = "SerialNumber", isPrimaryKey = false)
	public final Property<String> SerialNumber()
	{
		return serialNumber;
	}

	@ExcelReference(columnAddress = ColumnAddress.K, columnName = "InstallationDate", isPrimaryKey = false)
	public final Property<String> InstallationDate()
	{
		return installationDate;
	}

	@ExcelReference(columnAddress = ColumnAddress.L, columnName = "WarrantyStartDate", isPrimaryKey = false)
	public final Property<String> WarrantyStartDate()
	{
		return warrantyStartDate;
	}

	@ExcelReference(columnAddress = ColumnAddress.M, columnName = "TagNumber", isPrimaryKey = false)
	public final Property<String> TagNumber()
	{
		return tagNumber;
	}

	@ExcelReference(columnAddress = ColumnAddress.N, columnName = "BarCode", isPrimaryKey = false)
	public final Property<String> BarCode()
	{
		return barCode;
	}

	@ExcelReference(columnAddress = ColumnAddress.O, columnName = "AssetIdentifier", isPrimaryKey = false)
	public final Property<String> AssetIdentifier()
	{
		return assetIdentifier;
	}
	
	public void populateFromCobieComponent(ComponentType component)
	{
		Name().set(component.getName());
		CreatedBy().set(component.getCreatedBy());
		CreatedOn().set(component.getCreatedOn());
		TypeName().set(component.getTypeName());
		Space().set(component.getSpace());
		Description().set(component.getDescription());
		ExtSystem().set(component.getExtSystem());
		ExtObject().set(component.getExtObject());
		ExtIdentifier().set(component.getExtIdentifier());
		SerialNumber().set(component.getSerialNumber());
		InstallationDate().set(component.getInstallationDate());
		WarrantyStartDate().set(component.getWarrantyStartDate());
		TagNumber().set(component.getTagNumber());
		BarCode().set(component.getBarCode());
		AssetIdentifier().set(component.getAssetIdentifier());

	}

}
