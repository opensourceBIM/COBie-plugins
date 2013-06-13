/*
 * An XML document type.
 * Localname: ContactURL
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactURLDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ContactURL(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ContactURLDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ContactURLDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContactURLDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTURL$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactURL");
    
    
    /**
     * Gets the "ContactURL" element
     */
    public java.lang.String getContactURL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTURL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactURL" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactURL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTURL$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ContactURL" element
     */
    public void setContactURL(java.lang.String contactURL)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTURL$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTURL$0);
            }
            target.setStringValue(contactURL);
        }
    }
    
    /**
     * Sets (as xml) the "ContactURL" element
     */
    public void xsetContactURL(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactURL)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTURL$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTURL$0);
            }
            target.set(contactURL);
        }
    }
}
