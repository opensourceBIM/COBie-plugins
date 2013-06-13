/*
 * An XML document type.
 * Localname: ContactPostalCode
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactPostalCodeDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ContactPostalCode(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ContactPostalCodeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ContactPostalCodeDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContactPostalCodeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTPOSTALCODE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactPostalCode");
    
    
    /**
     * Gets the "ContactPostalCode" element
     */
    public java.lang.String getContactPostalCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTPOSTALCODE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactPostalCode" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactPostalCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTPOSTALCODE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ContactPostalCode" element
     */
    public void setContactPostalCode(java.lang.String contactPostalCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTPOSTALCODE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTPOSTALCODE$0);
            }
            target.setStringValue(contactPostalCode);
        }
    }
    
    /**
     * Sets (as xml) the "ContactPostalCode" element
     */
    public void xsetContactPostalCode(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactPostalCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTPOSTALCODE$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTPOSTALCODE$0);
            }
            target.set(contactPostalCode);
        }
    }
}
