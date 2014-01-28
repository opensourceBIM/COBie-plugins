package org.erdc.cobie.sqlite.entity;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public final class Contact extends CobieAttributesEntity
{
	public enum ColumnName
	{
		ContactCategory("ContactCategory"), 
		ContactCompanyName("ContactCompanyName"), 
		ContactCountryName("ContactCountryName"), 
		ContactDepartmentName("ContactDepartmentName"), 
		ContactEmail("ContactEmail"), 
		ContactFamilyName("ContactFamilyName"), 
		ContactGivenName("ContactGivenName"), 
		ContactPhoneNumber("ContactPhoneNumber"), 
		ContactPostalBoxNumber("ContactPostalBoxNumber"), 
		ContactTownName("ContactTownName"), 
		ContactRegionCode("ContactRegionCode"), 
		ContactPostalCode("ContactPostalCode"), 
		ContactStreet("ContactStreet"), 
		ContactURL("ContactURL");

		private String columName;

		private ColumnName(final String columnName)
		{
			columName = columnName;
		}

		@Override
		public final String toString()
		{
			return columName;
		}
	}

	public Contact() throws CobieSQLiteException
	{
		super();
	}
	
	public Contact(Row row) throws CobieSQLiteException
	{
		super(row);
	}
	
	public final String getContactCategory() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ContactCategory.toString()).getValue();
	}

	public final String getContactCompanyName() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ContactCompanyName.toString()).getValue();
	}

	public final String getContactCountryName() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ContactCountryName.toString()).getValue();
	}

	public final String getContactDepartmentName() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ContactDepartmentName.toString()).getValue();
	}

	public final String getContactEmail() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ContactEmail.toString()).getValue();
	}

	public final String getContactFamilyName() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ContactFamilyName.toString()).getValue();
	}

	public final String getContactGivenName() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ContactGivenName.toString()).getValue();
	}

	public final String getContactPhoneNumber() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ContactPhoneNumber.toString()).getValue();
	}

	public final String getContactPostalBoxNumber() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ContactPostalBoxNumber.toString()).getValue();
	}

	public final String getContactPostalCode() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ContactPostalCode.toString()).getValue();
	}

	public final String getContactRegionCode() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ContactRegionCode.toString()).getValue();
	}

	public final String getContactStreet() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ContactStreet.toString()).getValue();
	}

	public final String getContactTownName() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ContactTownName.toString()).getValue();
	}

	public final String getContactURL() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.ContactURL.toString()).getValue();
	}

	@Override
	public String getTableName()
	{
		return "Contact";
	}

	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
    	Row row = new Row(
					new Column<>(String.class, ColumnName.ContactCategory.toString(), null), 
					new Column<>(String.class, ColumnName.ContactCompanyName.toString(), null), 
					new Column<>(String.class, ColumnName.ContactCountryName.toString(), null), 
					new Column<>(String.class, ColumnName.ContactDepartmentName.toString(), null), 
					new Column<>(String.class, ColumnName.ContactEmail.toString(), null), 
					new Column<>(String.class, ColumnName.ContactFamilyName.toString(), null), 
					new Column<>(String.class, ColumnName.ContactGivenName.toString(), null), 
					new Column<>(String.class, ColumnName.ContactPhoneNumber.toString(), null), 
					new Column<>(String.class, ColumnName.ContactPostalBoxNumber.toString(), null), 
					new Column<>(String.class, ColumnName.ContactPostalCode.toString(), null), 
					new Column<>(String.class, ColumnName.ContactRegionCode.toString(), null), 
					new Column<>(String.class, ColumnName.ContactStreet.toString(), null), 
					new Column<>(String.class, ColumnName.ContactTownName.toString(), null), 
					new Column<>(String.class, ColumnName.ContactURL.toString(), null));
    	
    	row.add(super.makeRow().getColumns());
    	
    	return row;
	}
	
	public final void setContactCategory(String contactCategory) throws CobieSQLiteException
	{
		getColumn(ColumnName.ContactCategory.toString()).update(contactCategory);
	}

	public final void setContactCompanyName(String contactCompanyName) throws CobieSQLiteException
	{
		getColumn(ColumnName.ContactCompanyName.toString()).update(contactCompanyName);
	}

	public final void setContactCountryName(String contactCountryName) throws CobieSQLiteException
	{
		getColumn(ColumnName.ContactCountryName.toString()).update(contactCountryName);
	}

	public final void setContactDepartmentName(String contactDepartmentName) throws CobieSQLiteException
	{
		getColumn(ColumnName.ContactDepartmentName.toString()).update(contactDepartmentName);
	}

	public final void setContactEmail(String contactEmail) throws CobieSQLiteException
	{
		getColumn(ColumnName.ContactEmail.toString()).update(contactEmail);
	}

	public final void setContactFamilyName(String contactFamilyName) throws CobieSQLiteException
	{
		getColumn(ColumnName.ContactFamilyName.toString()).update(contactFamilyName);
	}

	public final void setContactGivenName(String contactGivenName) throws CobieSQLiteException
	{
		getColumn(ColumnName.ContactGivenName.toString()).update(contactGivenName);
	}

	public final void setContactPhoneNumber(String ContactPhoneNumber) throws CobieSQLiteException
	{
		getColumn(ColumnName.ContactPhoneNumber.toString()).update(ContactPhoneNumber);
	}

	public final void setContactPostalBoxNumber(String contactPostalBoxNumber) throws CobieSQLiteException
	{
		getColumn(ColumnName.ContactPostalBoxNumber.toString()).update(contactPostalBoxNumber);
	}

	public final void setContactPostalCode(String contactPostalCode) throws CobieSQLiteException
	{
		getColumn(ColumnName.ContactPostalCode.toString()).update(contactPostalCode);
	}

	public final void setContactRegionCode(String contactRegionCode) throws CobieSQLiteException
	{
		getColumn(ColumnName.ContactRegionCode.toString()).update(contactRegionCode);
	}

	public final void setContactStreet(String contactStreet) throws CobieSQLiteException
	{
		getColumn(ColumnName.ContactStreet.toString()).update(contactStreet);
	}

	public final void setContactTownName(String contactTownName) throws CobieSQLiteException
	{
		getColumn(ColumnName.ContactTownName.toString()).update(contactTownName);
	}

	public final void setContactURL(String contactURL) throws CobieSQLiteException
	{
		getColumn(ColumnName.ContactURL.toString()).update(contactURL);
	}
}
