/*
 * An XML document type.
 * Localname: ContactFamilyName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactFamilyNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ContactFamilyName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ContactFamilyNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ContactFamilyNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContactFamilyNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTFAMILYNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactFamilyName");
    
    
    /**
     * Gets the "ContactFamilyName" element
     */
    public java.lang.String getContactFamilyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTFAMILYNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactFamilyName" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactFamilyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTFAMILYNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ContactFamilyName" element
     */
    public void setContactFamilyName(java.lang.String contactFamilyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTFAMILYNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTFAMILYNAME$0);
            }
            target.setStringValue(contactFamilyName);
        }
    }
    
    /**
     * Sets (as xml) the "ContactFamilyName" element
     */
    public void xsetContactFamilyName(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactFamilyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTFAMILYNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTFAMILYNAME$0);
            }
            target.set(contactFamilyName);
        }
    }
}
