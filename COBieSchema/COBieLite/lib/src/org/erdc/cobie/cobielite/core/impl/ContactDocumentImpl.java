/*
 * An XML document type.
 * Localname: Contact
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Contact(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ContactDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ContactDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContactDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Contact");
    private static final org.apache.xmlbeans.QNameSet CONTACT$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Contact"),
        new javax.xml.namespace.QName("http://contact.cobielite.cobie.erdc.org", "Contact"),
    });
    
    
    /**
     * Gets the "Contact" element
     */
    public org.erdc.cobie.cobielite.core.ContactType getContact()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactType)get_store().find_element_user(CONTACT$1, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Contact" element
     */
    public void setContact(org.erdc.cobie.cobielite.core.ContactType contact)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactType)get_store().find_element_user(CONTACT$1, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.ContactType)get_store().add_element_user(CONTACT$0);
            }
            target.set(contact);
        }
    }
    
    /**
     * Appends and returns a new empty "Contact" element
     */
    public org.erdc.cobie.cobielite.core.ContactType addNewContact()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactType)get_store().add_element_user(CONTACT$0);
            return target;
        }
    }
}
