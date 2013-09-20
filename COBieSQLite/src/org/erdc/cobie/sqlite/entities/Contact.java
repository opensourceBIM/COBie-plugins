package org.erdc.cobie.sqlite.entities;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

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
	
	public Contact()
	{
		super();
		
		Columns columns = new Columns(
				new Column<String>(ColumnName.ContactCategory.toString(), null),
				new Column<String>(ColumnName.ContactCompanyName.toString(), null),
				new Column<String>(ColumnName.ContactCountryName.toString(), null),
				new Column<String>(ColumnName.ContactDepartmentName.toString(), null),
				new Column<String>(ColumnName.ContactEmail.toString(), null),
				new Column<String>(ColumnName.ContactFamilyName.toString(), null),
				new Column<String>(ColumnName.ContactGivenName.toString(), null), 
				new Column<String>(ColumnName.ContactPhoneNumber.toString(), null),
				new Column<String>(ColumnName.ContactPostalBoxNumber.toString(), null),
				new Column<String>(ColumnName.ContactPostalCode.toString(), null),
				new Column<String>(ColumnName.ContactRegionCode.toString(), null),
				new Column<String>(ColumnName.ContactStreet.toString(), null),
				new Column<String>(ColumnName.ContactTownName.toString(), null),
				new Column<String>(ColumnName.ContactURL.toString(), null));
		
		addColumns(columns);
	}
	
	@Override
	public String getName()
	{
		return (String)getColumn(ColumnName.ContactFamilyName.toString()).getValue() + 
				", " +
				(String)getColumn(ColumnName.ContactGivenName.toString()).getValue();
	}
	
	@Override
	public String getTableName() 
	{
		return "Contact";
	}
}
