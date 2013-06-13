/*
 * An XML document type.
 * Localname: Contacts
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Contacts(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ContactsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ContactsDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContactsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Contacts");
    
    
    /**
     * Gets the "Contacts" element
     */
    public org.erdc.cobie.cobielite.core.ContactCollectionType getContacts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactCollectionType)get_store().find_element_user(CONTACTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Contacts" element
     */
    public void setContacts(org.erdc.cobie.cobielite.core.ContactCollectionType contacts)
    {
        generatedSetterHelperImpl(contacts, CONTACTS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Contacts" element
     */
    public org.erdc.cobie.cobielite.core.ContactCollectionType addNewContacts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactCollectionType)get_store().add_element_user(CONTACTS$0);
            return target;
        }
    }
}
