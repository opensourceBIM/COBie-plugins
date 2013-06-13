/*
 * An XML document type.
 * Localname: ContactEmail
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactEmailDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ContactEmail(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ContactEmailDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ContactEmailDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContactEmailDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTEMAIL$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactEmail");
    
    
    /**
     * Gets the "ContactEmail" element
     */
    public java.lang.String getContactEmail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTEMAIL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactEmail" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetContactEmail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(CONTACTEMAIL$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ContactEmail" element
     */
    public void setContactEmail(java.lang.String contactEmail)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTEMAIL$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTEMAIL$0);
            }
            target.setStringValue(contactEmail);
        }
    }
    
    /**
     * Sets (as xml) the "ContactEmail" element
     */
    public void xsetContactEmail(org.erdc.cobie.cobielite.core.CobieNameSimpleType contactEmail)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(CONTACTEMAIL$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(CONTACTEMAIL$0);
            }
            target.set(contactEmail);
        }
    }
}
