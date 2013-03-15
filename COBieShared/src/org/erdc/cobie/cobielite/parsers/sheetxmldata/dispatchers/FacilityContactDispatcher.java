package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;

import org.erdc.cobie.cobielite.ContactCollectionType;
import org.erdc.cobie.cobielite.FacilityType;
import org.erdc.cobie.cobielite.parsers.TypicalParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.COBieLiteSheetXMLDataParser;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.ContactParser;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.ContactType;

public class FacilityContactDispatcher extends
        TypicalParserDispatcher<ContactType, ContactCollectionType, org.erdc.cobie.cobielite.ContactType, FacilityType>
{

    public FacilityContactDispatcher(Iterable<ContactType> childSourceElements, FacilityType targetParent, IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieLiteSheetXMLDataParser<ContactType, org.erdc.cobie.cobielite.ContactType> createNewParser(
            ContactType sourceElement,
            org.erdc.cobie.cobielite.ContactType newTargetElement)
    {
        return new ContactParser(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected org.erdc.cobie.cobielite.ContactType createNewTargetElement()
    {
        return targetCollection.addNewContact();
    }

    @Override
    protected ContactCollectionType getTargetCollection()
    {
        ContactCollectionType contacts = targetParent.getContacts();
        if (contacts == null)
        {
            contacts = targetParent.addNewContacts();
        } else
        {
            contacts = targetParent.getContacts();
        }
        return contacts;
    }

}
