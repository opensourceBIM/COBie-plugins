/*
 * An XML document type.
 * Localname: ContactRegionCode
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactRegionCodeDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ContactRegionCode(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ContactRegionCodeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ContactRegionCodeDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContactRegionCodeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTREGIONCODE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactRegionCode");
    
    
    /**
     * Gets the "ContactRegionCode" element
     */
    public java.lang.String getContactRegionCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTREGIONCODE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactRegionCode" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactRegionCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTREGIONCODE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ContactRegionCode" element
     */
    public void setContactRegionCode(java.lang.String contactRegionCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTREGIONCODE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTREGIONCODE$0);
            }
            target.setStringValue(contactRegionCode);
        }
    }
    
    /**
     * Sets (as xml) the "ContactRegionCode" element
     */
    public void xsetContactRegionCode(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactRegionCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTREGIONCODE$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTREGIONCODE$0);
            }
            target.set(contactRegionCode);
        }
    }
}
