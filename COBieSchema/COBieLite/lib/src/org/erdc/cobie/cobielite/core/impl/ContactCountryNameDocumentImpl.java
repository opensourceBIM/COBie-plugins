/*
 * An XML document type.
 * Localname: ContactCountryName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactCountryNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ContactCountryName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ContactCountryNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ContactCountryNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContactCountryNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTCOUNTRYNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactCountryName");
    
    
    /**
     * Gets the "ContactCountryName" element
     */
    public java.lang.String getContactCountryName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTCOUNTRYNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactCountryName" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactCountryName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTCOUNTRYNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ContactCountryName" element
     */
    public void setContactCountryName(java.lang.String contactCountryName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTCOUNTRYNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTCOUNTRYNAME$0);
            }
            target.setStringValue(contactCountryName);
        }
    }
    
    /**
     * Sets (as xml) the "ContactCountryName" element
     */
    public void xsetContactCountryName(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactCountryName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTCOUNTRYNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTCOUNTRYNAME$0);
            }
            target.set(contactCountryName);
        }
    }
}
