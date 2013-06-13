/*
 * An XML document type.
 * Localname: SystemCategory
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SystemCategoryDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SystemCategory(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SystemCategoryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SystemCategoryDocument
{
    private static final long serialVersionUID = 1L;
    
    public SystemCategoryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SYSTEMCATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SystemCategory");
    
    
    /**
     * Gets the "SystemCategory" element
     */
    public java.lang.String getSystemCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SYSTEMCATEGORY$0, 0);
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
            target = (org.erdc.cobie.cobielite.core.SystemCategorySimpleType)get_store().find_element_user(SYSTEMCATEGORY$0, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SYSTEMCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SYSTEMCATEGORY$0);
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
            target = (org.erdc.cobie.cobielite.core.SystemCategorySimpleType)get_store().find_element_user(SYSTEMCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.SystemCategorySimpleType)get_store().add_element_user(SYSTEMCATEGORY$0);
            }
            target.set(systemCategory);
        }
    }
}
