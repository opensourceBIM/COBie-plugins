/*
 * An XML document type.
 * Localname: WarrantyName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.WarrantyNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one WarrantyName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class WarrantyNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.WarrantyNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public WarrantyNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WARRANTYNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "WarrantyName");
    
    
    /**
     * Gets the "WarrantyName" element
     */
    public java.lang.String getWarrantyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "WarrantyName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetWarrantyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(WARRANTYNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "WarrantyName" element
     */
    public void setWarrantyName(java.lang.String warrantyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WARRANTYNAME$0);
            }
            target.setStringValue(warrantyName);
        }
    }
    
    /**
     * Sets (as xml) the "WarrantyName" element
     */
    public void xsetWarrantyName(org.erdc.cobie.cobielite.core.CobieNameSimpleType warrantyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(WARRANTYNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(WARRANTYNAME$0);
            }
            target.set(warrantyName);
        }
    }
}
