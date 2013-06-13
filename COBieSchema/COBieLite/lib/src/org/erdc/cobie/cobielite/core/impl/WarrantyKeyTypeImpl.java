/*
 * XML Type:  WarrantyKeyType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.WarrantyKeyType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML WarrantyKeyType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class WarrantyKeyTypeImpl extends org.erdc.cobie.cobielite.core.impl.AssetTypeKeyTypeImpl implements org.erdc.cobie.cobielite.core.WarrantyKeyType
{
    private static final long serialVersionUID = 1L;
    
    public WarrantyKeyTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WARRANTYNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "WarrantyName");
    private static final javax.xml.namespace.QName WARRANTYCATEGORY$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "WarrantyCategory");
    
    
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
    
    /**
     * Gets the "WarrantyCategory" element
     */
    public java.lang.String getWarrantyCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYCATEGORY$2, 0);
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
            target = (org.erdc.cobie.cobielite.core.WarrantyCategorySimpleType)get_store().find_element_user(WARRANTYCATEGORY$2, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYCATEGORY$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WARRANTYCATEGORY$2);
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
            target = (org.erdc.cobie.cobielite.core.WarrantyCategorySimpleType)get_store().find_element_user(WARRANTYCATEGORY$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.WarrantyCategorySimpleType)get_store().add_element_user(WARRANTYCATEGORY$2);
            }
            target.set(warrantyCategory);
        }
    }
}
