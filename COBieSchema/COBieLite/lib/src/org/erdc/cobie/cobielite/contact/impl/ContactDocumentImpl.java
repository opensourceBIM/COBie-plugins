/*
 * An XML document type.
 * Localname: Contact
 * Namespace: http://contact.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.contact.ContactDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.contact.impl;
/**
 * A document containing one Contact(@http://contact.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ContactDocumentImpl extends org.erdc.cobie.cobielite.core.impl.ContactDocumentImpl implements org.erdc.cobie.cobielite.contact.ContactDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContactDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACT2$0 = 
        new javax.xml.namespace.QName("http://contact.cobielite.cobie.erdc.org", "Contact");
    
    
    /**
     * Gets the "Contact" element
     */
    public org.erdc.cobie.cobielite.contact.ContactType getContact2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.contact.ContactType target = null;
            target = (org.erdc.cobie.cobielite.contact.ContactType)get_store().find_element_user(CONTACT2$0, 0);
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
    public void setContact2(org.erdc.cobie.cobielite.contact.ContactType contact2)
    {
        generatedSetterHelperImpl(contact2, CONTACT2$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Contact" element
     */
    public org.erdc.cobie.cobielite.contact.ContactType addNewContact2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.contact.ContactType target = null;
            target = (org.erdc.cobie.cobielite.contact.ContactType)get_store().add_element_user(CONTACT2$0);
            return target;
        }
    }
}
