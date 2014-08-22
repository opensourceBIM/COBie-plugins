package org.erdc.cobie.shared.cobietab.transformation.cobielite;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ContactDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ContactCollectionType;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.ContactType;

public class FacilityContactDispatcher extends
        TypicalParserDispatcher<ContactType, ContactCollectionType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ContactType, FacilityType>
{

    public FacilityContactDispatcher(Iterable<ContactType> childSourceElements, FacilityType targetParent, IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<ContactType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ContactType> createNewParser(
            ContactType sourceElement,
            org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ContactType newTargetElement)
    {
        return new ContactTransformer(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ContactType createNewTargetElement()
    {
        return (org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ContactType)targetCollection.addNewContact().substitute(ContactDocument.type.getDocumentElementName(), org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ContactType.type);
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
