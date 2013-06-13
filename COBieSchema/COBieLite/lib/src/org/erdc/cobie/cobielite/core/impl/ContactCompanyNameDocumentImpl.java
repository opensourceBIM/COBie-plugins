/*
 * An XML document type.
 * Localname: ContactCompanyName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactCompanyNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ContactCompanyName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ContactCompanyNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ContactCompanyNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContactCompanyNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTCOMPANYNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactCompanyName");
    
    
    /**
     * Gets the "ContactCompanyName" element
     */
    public java.lang.String getContactCompanyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTCOMPANYNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactCompanyName" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactCompanyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTCOMPANYNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ContactCompanyName" element
     */
    public void setContactCompanyName(java.lang.String contactCompanyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTCOMPANYNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTCOMPANYNAME$0);
            }
            target.setStringValue(contactCompanyName);
        }
    }
    
    /**
     * Sets (as xml) the "ContactCompanyName" element
     */
    public void xsetContactCompanyName(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactCompanyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTCOMPANYNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTCOMPANYNAME$0);
            }
            target.set(contactCompanyName);
        }
    }
}
