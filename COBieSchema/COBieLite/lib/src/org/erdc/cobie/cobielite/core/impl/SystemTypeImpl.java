/*
 * XML Type:  SystemType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SystemType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML SystemType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class SystemTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieRowTypeImpl implements org.erdc.cobie.cobielite.core.SystemType
{
    private static final long serialVersionUID = 1L;
    
    public SystemTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SYSTEMNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SystemName");
    private static final javax.xml.namespace.QName SYSTEMCATEGORY$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SystemCategory");
    
    
    /**
     * Gets the "SystemName" element
     */
    public java.lang.String getSystemName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SYSTEMNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SystemName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetSystemName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(SYSTEMNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SystemName" element
     */
    public void setSystemName(java.lang.String systemName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SYSTEMNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SYSTEMNAME$0);
            }
            target.setStringValue(systemName);
        }
    }
    
    /**
     * Sets (as xml) the "SystemName" element
     */
    public void xsetSystemName(org.erdc.cobie.cobielite.core.CobieNameSimpleType systemName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(SYSTEMNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(SYSTEMNAME$0);
            }
            target.set(systemName);
        }
    }
    
    /**
     * Gets the "SystemCategory" element
     */
    public java.lang.String getSystemCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SYSTEMCATEGORY$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SystemCategory" element
     */
    public org.erdc.cobie.cobielite.core.SystemCategorySimpleType xgetSystemCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemCategorySimpleType)get_store().find_element_user(SYSTEMCATEGORY$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SystemCategory" element
     */
    public void setSystemCategory(java.lang.String systemCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SYSTEMCATEGORY$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SYSTEMCATEGORY$2);
            }
            target.setStringValue(systemCategory);
        }
    }
    
    /**
     * Sets (as xml) the "SystemCategory" element
     */
    public void xsetSystemCategory(org.erdc.cobie.cobielite.core.SystemCategorySimpleType systemCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemCategorySimpleType)get_store().find_element_user(SYSTEMCATEGORY$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.SystemCategorySimpleType)get_store().add_element_user(SYSTEMCATEGORY$2);
            }
            target.set(systemCategory);
        }
    }
}
