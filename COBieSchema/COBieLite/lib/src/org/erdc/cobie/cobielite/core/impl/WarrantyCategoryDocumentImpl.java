/*
 * An XML document type.
 * Localname: WarrantyCategory
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.WarrantyCategoryDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one WarrantyCategory(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class WarrantyCategoryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.WarrantyCategoryDocument
{
    private static final long serialVersionUID = 1L;
    
    public WarrantyCategoryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WARRANTYCATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "WarrantyCategory");
    
    
    /**
     * Gets the "WarrantyCategory" element
     */
    public java.lang.String getWarrantyCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYCATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "WarrantyCategory" element
     */
    public org.erdc.cobie.cobielite.core.WarrantyCategorySimpleType xgetWarrantyCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.WarrantyCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.WarrantyCategorySimpleType)get_store().find_element_user(WARRANTYCATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "WarrantyCategory" element
     */
    public void setWarrantyCategory(java.lang.String warrantyCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WARRANTYCATEGORY$0);
            }
            target.setStringValue(warrantyCategory);
        }
    }
    
    /**
     * Sets (as xml) the "WarrantyCategory" element
     */
    public void xsetWarrantyCategory(org.erdc.cobie.cobielite.core.WarrantyCategorySimpleType warrantyCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.WarrantyCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.WarrantyCategorySimpleType)get_store().find_element_user(WARRANTYCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.WarrantyCategorySimpleType)get_store().add_element_user(WARRANTYCATEGORY$0);
            }
            target.set(warrantyCategory);
        }
    }
}
