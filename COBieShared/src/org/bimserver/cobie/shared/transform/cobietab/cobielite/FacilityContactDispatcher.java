package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import java.net.URL;
import java.net.URLClassLoader;

import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ContactDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ContactType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ContactCollectionType;

public class FacilityContactDispatcher extends
        TypicalParserDispatcher<org.nibs.cobie.tab.ContactType, ContactCollectionType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ContactType, FacilityType>
{

    public FacilityContactDispatcher(Iterable<org.nibs.cobie.tab.ContactType> childSourceElements, FacilityType targetParent, IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<org.nibs.cobie.tab.ContactType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ContactType> createNewParser(
    		org.nibs.cobie.tab.ContactType sourceElement,
            ContactType newTargetElement)
    {
        return new ContactTransformer(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected ContactType createNewTargetElement()
    {
    	return (ContactType) targetCollection.addNewContact().substitute(ContactDocument.type.getDocumentElementName(), ContactType.type);
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
