package com.prairiesky.transform.template.schema.productinstallation;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.ContactType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class ContactLookupTable extends SpreadsheetTemplateTable<ContactLookupRow>
{

	@Override
	public Supplier<ContactLookupRow> getRowSupplier()
	{
		return ContactLookupRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobieDocument)
	{
		if(cobieDocument.getCOBIE() != null && 
				cobieDocument.getCOBIE().getContacts() != null && 
				cobieDocument.getCOBIE().getContacts().getContactList() != null)
		{
			for(ContactType contact : cobieDocument.getCOBIE().getContacts().getContactList())
			{
				ContactLookupRow row = newRow();
				row.populateFromCobieContact(contact);
				insertRow(row);
			}
		}
		
	}

}
