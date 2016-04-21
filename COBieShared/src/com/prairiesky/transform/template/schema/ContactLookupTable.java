package com.prairiesky.transform.template.schema;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.ContactType;

public class ContactLookupTable extends ConstructionTemplateTable<ContactLookupRow>
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
