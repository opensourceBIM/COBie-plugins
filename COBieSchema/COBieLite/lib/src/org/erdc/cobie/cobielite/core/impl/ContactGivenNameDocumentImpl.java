/*
 * An XML document type.
 * Localname: ContactGivenName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactGivenNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ContactGivenName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ContactGivenNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ContactGivenNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContactGivenNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTGIVENNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactGivenName");
    
    
    /**
     * Gets the "ContactGivenName" element
     */
    public java.lang.String getContactGivenName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTGIVENNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactGivenName" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactGivenName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTGIVENNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ContactGivenName" element
     */
    public void setContactGivenName(java.lang.String contactGivenName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTGIVENNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTGIVENNAME$0);
            }
            target.setStringValue(contactGivenName);
        }
    }
    
    /**
     * Sets (as xml) the "ContactGivenName" element
     */
    public void xsetContactGivenName(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactGivenName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTGIVENNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTGIVENNAME$0);
            }
            target.set(contactGivenName);
        }
    }
}
