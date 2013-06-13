/*
 * An XML document type.
 * Localname: ContactStreet
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactStreetDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ContactStreet(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ContactStreetDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ContactStreetDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContactStreetDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTSTREET$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactStreet");
    
    
    /**
     * Gets the "ContactStreet" element
     */
    public java.lang.String getContactStreet()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTSTREET$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactStreet" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactStreet()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTSTREET$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ContactStreet" element
     */
    public void setContactStreet(java.lang.String contactStreet)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTSTREET$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTSTREET$0);
            }
            target.setStringValue(contactStreet);
        }
    }
    
    /**
     * Sets (as xml) the "ContactStreet" element
     */
    public void xsetContactStreet(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactStreet)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTSTREET$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTSTREET$0);
            }
            target.set(contactStreet);
        }
    }
}
