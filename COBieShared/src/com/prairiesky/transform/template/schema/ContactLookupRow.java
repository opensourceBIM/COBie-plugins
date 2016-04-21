package com.prairiesky.transform.template.schema;

import org.nibs.cobie.tab.ContactType;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;

@ExcelReference(spreadsheetName="Contact")
public class ContactLookupRow extends ConstructionTemplateRow
{
//Email	Category	Company	Phone	Department	OrganizationCode	GivenName	FamilyName	Street	PostalBox	Town	StateRegion	PostalCode	Country
	private final Property<String> email = new Property<>(String.class);
	private Property<String> category = new Property<>(String.class);
	private Property<String> company = new Property<>(String.class);
	private Property<String> phone = new Property<>(String.class);
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
	
	@ExcelReference(columnAddress=ColumnAddress.B, columnName="Category", isPrimaryKey=false)
	public final Property<String> Category()
	{
		return category;
	}
	
	@ExcelReference(columnAddress=ColumnAddress.C, columnName="Company", isPrimaryKey=false)
	public final Property<String> Company()
	{
		return company;
	}
	@ExcelReference(columnAddress=ColumnAddress.D, columnName="Phone", isPrimaryKey=false)
	public final Property<String> Phone()
	{
		return phone;
	}

	@ExcelReference(columnAddress=ColumnAddress.E, columnName="Department", isPrimaryKey=false)
	public final Property<String> Department()
	{
		return department;
	}
	@ExcelReference(columnAddress=ColumnAddress.F, columnName="OrganizationCode", isPrimaryKey=false)
	public final Property<String> OrganizationCode()
	{
		return organizationCode;
	}
	@ExcelReference(columnAddress=ColumnAddress.G, columnName="GivenName", isPrimaryKey=false)
	public final Property<String> GivenName()
	{
		return givenName;
	}
	@ExcelReference(columnAddress=ColumnAddress.H, columnName="FamilyName", isPrimaryKey=false)
	public final Property<String> FamilyName()
	{
		return familyName;
	}
	@ExcelReference(columnAddress=ColumnAddress.I, columnName="Street", isPrimaryKey=false)
	public final Property<String> Street()
	{
		return street;
	}
	
	@ExcelReference(columnAddress=ColumnAddress.J, columnName="PostalBox", isPrimaryKey=false)
	public final Property<String> PostalBox()
	{
		return postalBox;
	}

	@ExcelReference(columnAddress=ColumnAddress.K, columnName="Town", isPrimaryKey=false)
	public final Property<String> Town()
	{
		return town;
	}

	@ExcelReference(columnAddress=ColumnAddress.L, columnName="StateRegion", isPrimaryKey=false)
	public final Property<String> StateRegion()
	{
		return stateRegion;
	}
	@ExcelReference(columnAddress=ColumnAddress.M, columnName="PostalCode", isPrimaryKey=false)
	public final Property<String> PostalCode()
	{
		return postalCode;
	}
	
	@ExcelReference(columnAddress=ColumnAddress.N, columnName="Country", isPrimaryKey=false)
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
	}

}
