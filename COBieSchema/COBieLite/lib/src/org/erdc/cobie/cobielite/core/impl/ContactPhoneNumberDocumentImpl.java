/*
 * An XML document type.
 * Localname: ContactPhoneNumber
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactPhoneNumberDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ContactPhoneNumber(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ContactPhoneNumberDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ContactPhoneNumberDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContactPhoneNumberDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTPHONENUMBER$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactPhoneNumber");
    
    
    /**
     * Gets the "ContactPhoneNumber" element
     */
    public java.lang.String getContactPhoneNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTPHONENUMBER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactPhoneNumber" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactPhoneNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTPHONENUMBER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ContactPhoneNumber" element
     */
    public void setContactPhoneNumber(java.lang.String contactPhoneNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTPHONENUMBER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTPHONENUMBER$0);
            }
            target.setStringValue(contactPhoneNumber);
        }
    }
    
    /**
     * Sets (as xml) the "ContactPhoneNumber" element
     */
    public void xsetContactPhoneNumber(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactPhoneNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTPHONENUMBER$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTPHONENUMBER$0);
            }
            target.set(contactPhoneNumber);
        }
    }
}
