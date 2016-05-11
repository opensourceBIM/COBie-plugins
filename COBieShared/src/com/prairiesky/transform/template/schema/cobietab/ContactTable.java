package com.prairiesky.transform.template.schema.cobietab;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.ContactType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class ContactTable extends SpreadsheetTemplateTable<ContactRow>
{

	@Override
	public Supplier<ContactRow> getRowSupplier()
	{
		return ContactRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobieDocument)
	{
		if(cobieDocument != null && cobieDocument.getCOBIE() != null && 
				cobieDocument.getCOBIE().getContacts() != null && 
				cobieDocument.getCOBIE().getContacts().getContactList() != null)
		{
			for(ContactType contact : cobieDocument.getCOBIE().getContacts().getContactList())
			{
				ContactRow row = newRow();
				row.populateFromCobieContact(contact);
				insertRow(row);
			}
		}
		
	}

}
