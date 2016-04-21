package com.prairiesky.transform.template.schema;

import java.util.Calendar;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Row;
import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.ComponentType;
import org.nibs.cobie.tab.TypeType;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.AttributeName;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;

@ExcelReference(spreadsheetName="Product")
public class GeneralInstalledProduct extends ConstructionTemplateProductRow
{

	private final Property<String> product = new Property<>(String.class);
	@ExcelReference(columnAddress = ColumnAddress.A, columnName = "Product", isPrimaryKey = true)
	public final Property<String> Product(){ return product;}
	
	private final Property<String> productType = new Property<>(String.class);
	@ExcelReference(columnAddress = ColumnAddress.B, columnName = "Product Type",  isForeignKey = true, foreignKeySpreadsheetName = "Type", foreignKeyColumnAddress = ColumnAddress.A, foreignKeyColumnName = "Type Name")
	public final Property<String> ProductType(){ return productType;}
	
	private final Property<String> roomNumber = new Property<>(String.class);
	@ExcelReference(columnAddress = ColumnAddress.C, columnName = "Room Number",  isForeignKey = true, foreignKeySpreadsheetName = "Space", foreignKeyColumnAddress = ColumnAddress.A, foreignKeyColumnName = "Room Number")
	public final Property<String> RoomNumber(){ return roomNumber;}
	
	private final Property<String> manufacturer = new Property<>(String.class);
	@ExcelReference(columnAddress = ColumnAddress.D, columnName = "Manufacturer",  isForeignKey = true, foreignKeySpreadsheetName = "Contact", foreignKeyColumnAddress = ColumnAddress.A, foreignKeyColumnName = "Email")
	public final Property<String> Manufacturer() { return manufacturer; }
	
	private final Property<String> supplier = new Property<>(String.class);
	@ExcelReference(columnAddress = ColumnAddress.E, columnName = "Supplier",  isForeignKey = true, foreignKeySpreadsheetName = "Contact", foreignKeyColumnAddress = ColumnAddress.A, foreignKeyColumnName = "Email")
	public final Property<String> Supplier() { return supplier; }
	
	private final Property<String> critical = new Property<>(String.class);
	@ExcelReference(columnAddress = ColumnAddress.F, columnName = "Critical")
	public final Property<String> Critical() { return critical;}
	
	private final Property<String> installedModelNumber = new Property<>(String.class);
	@ExcelReference(columnAddress = ColumnAddress.G, columnName = "Installed Model Number", spreadsheetName = "Product")
	public final Property<String> InstalledModelNumber(){ return installedModelNumber;}
	
	private final Property<String> installedSerialNumber = new Property<>(String.class);
	@ExcelReference(columnAddress = ColumnAddress.H, columnName = "Installed Serial Number")
	public final Property<String> InstalledSerialNumber() { return installedSerialNumber; }
	
	private final Property<Calendar> installedOn = new Property<>(Calendar.class);
	@ExcelReference(columnAddress = ColumnAddress.I, columnName = "Installed On")
	public final Property<Calendar> InstalledOn() { return installedOn; }
	
	private final Property<Calendar> startedOn = new Property<>(Calendar.class);
	@ExcelReference(columnAddress = ColumnAddress.J, columnName = "Started On")
	public final Property<Calendar> StartedOn() { return startedOn;}
	
	private final Property<String> tagNumber = new Property<>(String.class);
	@ExcelReference(columnAddress = ColumnAddress.K, columnName = "Tag Number")
	public final Property<String> TagNumber() { return tagNumber; }
	
	private final Property<String> specSection = new Property<>(String.class);
	@ExcelReference(columnAddress = ColumnAddress.L, columnName = "Spec Section")
	public final Property<String> SpecSection() { return specSection; }
	
	private Property<String> omniClassCode = new Property<>(String.class);
	@ExcelReference(columnAddress = ColumnAddress.M, columnName = "OmniClass Code")
	public final Property<String> OmniClassCode() { return omniClassCode; }

	@Override
	public void populateFromCOBie(ComponentType component, TypeType type,
			IndexedCOBie indexedCobie)
	{
		COBIEType cobie = indexedCobie.getCobie();
		String componentName = component.getName();
		Product().set(componentName);
		if(type != null)
		{
			ProductType().set(component.getTypeName());
			Manufacturer().set(type.getManufacturer());
		}
		RoomNumber().set(component.getSpace());
		
		populateStringValueFromComponentAttribute(AttributeName.SUPPLIER,
				componentName, indexedCobie, s -> Supplier().set(s));
		populateStringValueFromComponentAttribute(AttributeName.CRITICAL,
				componentName, indexedCobie, c -> Critical().set(c));
		populateStringValueFromComponentAttribute(
				AttributeName.INSTALLED_MODEL_NUMBER, componentName, indexedCobie,
				n -> InstalledModelNumber().set(n));
		if (type!=null && (!Optional.ofNullable(InstalledModelNumber().get()).isPresent()
				|| InstalledModelNumber().get().length() == 0))
		{
			InstalledModelNumber().set(type.getModelNumber());
		}
		populateStringValueFromComponentAttribute(
				AttributeName.INSTALLED_SERIAL_NUMBER, componentName, indexedCobie,
				s -> InstalledSerialNumber().set(s));
		if (!Optional.ofNullable(InstalledSerialNumber().get()).isPresent()
				|| InstalledSerialNumber().get().length() == 0)
		{
			InstalledSerialNumber().set(component.getSerialNumber());
		}
		Calendar installationDate;
		try
		{
			installationDate = COBieUtility
					.calendarFromStringWithException(component
							.getInstallationDate());
			InstalledOn().set(installationDate);
		}
		catch (Exception e)
		{

		}
		try
		{
			Calendar startedOn = 
					COBieUtility.calendarFromStringWithException(component.getWarrantyStartDate());
			StartedOn().set(startedOn);
		}
		catch(Exception e)
		{
			
		}
		TagNumber().set(component.getTagNumber());
		populateStringValueFromComponentAttribute(AttributeName.SPEC_SECTION,
				componentName, indexedCobie, s -> SpecSection().set(s));
		if(type != null)
		{
			OmniClassCode().set(type.getCategory());
		}		
	}
}
