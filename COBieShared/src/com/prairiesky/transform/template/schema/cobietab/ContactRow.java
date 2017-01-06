package com.prairiesky.transform.template.schema.cobietab;

import java.util.Calendar;

import org.nibs.cobie.tab.ContactType;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateRow;

@ExcelReference(spreadsheetName="Contact")
public class ContactRow extends SpreadsheetTemplateRow 
{
	private final Property<String> email = new Property<>(String.class);
	private final Property<String> createdBy = new Property<>(String.class);
	private final Property<Calendar> createdOn = new Property<>(Calendar.class);
	private Property<String> category = new Property<>(String.class);
	private Property<String> company = new Property<>(String.class);
	private Property<String> phone = new Property<>(String.class);
	private Property<String> externalSystem = new Property<>(String.class);
	private Property<String> externalIdentifier = new Property<>(String.class);
	private Property<String> externalObject = new Property<>(String.class);
	private Property<String> department = new Property<>(String.class);
	private Property<String> organizationCode = new Property<>(String.class);
	private Property<String> givenName = new Property<>(String.class);
	private Property<String> familyName = new Property<>(String.class);
	private Property<String> street = new Property<>(String.class);
	private Property<String> postalBox = new Property<>(String.class);
	private Property<String> town = new Property<>(String.class);
	private Property<String> stateRegion = new Property<>(String.class);
	private Property<String> postalCode = new Property<>(String.class);
	private Property<String> country = new Property<>(String.class);
	
	@ExcelReference(columnAddress=ColumnAddress.A, columnName="Email", isPrimaryKey=true)
	public final Property<String> Email()
	{
		return email;
	}
	
	@ExcelReference(columnAddress=ColumnAddress.B, columnName="CreatedBy", isPrimaryKey=false)
	public final Property<String> CreatedBy()
	{
		return createdBy;
	}
	
	@ExcelReference(columnAddress=ColumnAddress.C, columnName="CreatedOn", isPrimaryKey=false)
	public final Property<Calendar> CreatedOn()
	{
		return createdOn;
	}
	
	@ExcelReference(columnAddress=ColumnAddress.D, columnName="Category", isPrimaryKey=false)
	public final Property<String> Category()
	{
		return category;
	}
	
	@ExcelReference(columnAddress=ColumnAddress.E, columnName="Company", isPrimaryKey=false)
	public final Property<String> Company()
	{
		return company;
	}
	@ExcelReference(columnAddress=ColumnAddress.F, columnName="Phone", isPrimaryKey=false)
	public final Property<String> Phone()
	{
		return phone;
	}
	
	@ExcelReference(columnAddress=ColumnAddress.G, columnName="ExternalSystem", isPrimaryKey=false)
	public final Property<String> ExternalSystem()
	{
		return externalSystem;
	}
	
	@ExcelReference(columnAddress=ColumnAddress.H, columnName="ExternalObject", isPrimaryKey=false)
	public final Property<String> ExternalObject()
	{
		return externalObject;
	}
	
	@ExcelReference(columnAddress=ColumnAddress.I, columnName="ExternalIdentifier", isPrimaryKey=false)
	public final Property<String> ExternalIdentifier()
	{
		return externalIdentifier;
	}

	@ExcelReference(columnAddress=ColumnAddress.J, columnName="Department", isPrimaryKey=false)
	public final Property<String> Department()
	{
		return department;
	}
	@ExcelReference(columnAddress=ColumnAddress.K, columnName="OrganizationCode", isPrimaryKey=false)
	public final Property<String> OrganizationCode()
	{
		return organizationCode;
	}
	@ExcelReference(columnAddress=ColumnAddress.L, columnName="GivenName", isPrimaryKey=false)
	public final Property<String> GivenName()
	{
		return givenName;
	}
	@ExcelReference(columnAddress=ColumnAddress.M, columnName="FamilyName", isPrimaryKey=false)
	public final Property<String> FamilyName()
	{
		return familyName;
	}
	@ExcelReference(columnAddress=ColumnAddress.N, columnName="Street", isPrimaryKey=false)
	public final Property<String> Street()
	{
		return street;
	}
	
	@ExcelReference(columnAddress=ColumnAddress.O, columnName="PostalBox", isPrimaryKey=false)
	public final Property<String> PostalBox()
	{
		return postalBox;
	}

	@ExcelReference(columnAddress=ColumnAddress.P, columnName="Town", isPrimaryKey=false)
	public final Property<String> Town()
	{
		return town;
	}

	@ExcelReference(columnAddress=ColumnAddress.Q, columnName="StateRegion", isPrimaryKey=false)
	public final Property<String> StateRegion()
	{
		return stateRegion;
	}
	@ExcelReference(columnAddress=ColumnAddress.R, columnName="PostalCode", isPrimaryKey=false)
	public final Property<String> PostalCode()
	{
		return postalCode;
	}
	
	@ExcelReference(columnAddress=ColumnAddress.S, columnName="Country", isPrimaryKey=false)
	public final Property<String> Country()
	{
		return country;
	}
	
	public void populateFromCobieContact(ContactType contact)
	{
		Category().set(contact.getCategory());
		Company().set(contact.getCompany());
		Country().set(contact.getCountry());
		Department().set(contact.getDepartment());
		Email().set(contact.getEmail());
		FamilyName().set(contact.getFamilyName());
		GivenName().set(contact.getGivenName());
		OrganizationCode().set(contact.getOrganizationCode());
		Phone().set(contact.getPhone());
		PostalBox().set(contact.getPostalBox());
		PostalCode().set(contact.getPostalCode());
		StateRegion().set(contact.getStateRegion());
		Street().set(contact.getStreet());
		Town().set(contact.getTown());
		CreatedBy().set(contact.getCreatedBy());
		CreatedOn().set(contact.getCreatedOn());
		ExternalIdentifier().set(contact.getExternalIdentifier());
		ExternalObject().set(contact.getExternalObject());
		ExternalSystem().set(contact.getExternalSystem());
	}
	
	
}
