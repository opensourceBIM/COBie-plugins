package org.erdc.cobie.sheetxmldata.parsers;

import java.util.Calendar;

import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.ContactType;

public class DefaultContact
{
    private static final String CATEGORY = "Software System";
    private static final String COMPANY = COBieUtility.COBieNA;
    private static final String COUNTRY = COBieUtility.COBieNA;
    private static final String CREATED_BY = "cobietoolkit@this_is_not_a_real_address.com";
    private static final String DEPARTMENT = COBieUtility.COBieNA;
    public static final String EMAIL = "cobietoolkit@this_is_not_a_real_address.com";
    private static final String EXTERNAL_IDENTIFIER = COBieUtility.COBieNA;
    private static final String EXTERNAL_OBJECT = COBieUtility.COBieNA;
    public static final String EXTERNAL_SYSTEM = "cobie toolkit";
    private static final String FAMILY_NAME = "cobie";
    private static final String GIVEN_NAME = "toolkit";
    private static final String ORGANIZATION_CODE = COBieUtility.COBieNA;
    private static final String PHONE = COBieUtility.COBieNA;
    private static final String POSTAL_BOX = COBieUtility.COBieNA;
    private static final String POSTAL_CODE = COBieUtility.COBieNA;
    private static final String STATE_REGION = COBieUtility.COBieNA;
    private static final String STREET = COBieUtility.COBieNA;
    private static final String TOWN = COBieUtility.COBieNA;
    protected ContactType contact;
    protected COBIEType.Contacts contacts;
    public COBIEType.Contacts getContacts()
    {
        return contacts;
    }

    public void setContacts(COBIEType.Contacts contacts)
    {
        this.contacts = contacts;
    }

    public DefaultContact(COBIEType.Contacts contacts)
    {
        initializeContact();
        setContacts(contacts);
    }
    
    private void initializeContact()
    {
        ContactType newContact =
                contacts.addNewContact();
        
        newContact.setCategory(CATEGORY);
        newContact.setCompany(COMPANY);
        newContact.setCountry(COUNTRY);
        newContact.setCreatedBy(CREATED_BY);
        newContact.setCreatedOn(Calendar.getInstance());
        newContact.setDepartment(DEPARTMENT);
        newContact.setEmail(EMAIL);
        newContact.setExternalIdentifier(EXTERNAL_IDENTIFIER);
        newContact.setExternalObject(EXTERNAL_OBJECT);
        newContact.setExternalSystem(EXTERNAL_SYSTEM);
        newContact.setFamilyName(FAMILY_NAME);
        newContact.setGivenName(GIVEN_NAME);
        newContact.setOrganizationCode(ORGANIZATION_CODE);
        newContact.setPhone(PHONE);
        newContact.setPostalBox(POSTAL_BOX);
        newContact.setPostalCode(POSTAL_CODE);
        newContact.setStateRegion(STATE_REGION);
        newContact.setStreet(STREET);
        newContact.setTown(TOWN);
        
        setContact(newContact);
    }

    public ContactType getContact()
    {
        return contact;
    }

    public void setContact(ContactType contact)
    {
        this.contact = contact;
    }
    
    
}
