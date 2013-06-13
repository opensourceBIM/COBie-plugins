/*
 * An XML document type.
 * Localname: ResourceCategory
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ResourceCategoryDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ResourceCategory(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ResourceCategoryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ResourceCategoryDocument
{
    private static final long serialVersionUID = 1L;
    
    public ResourceCategoryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RESOURCECATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ResourceCategory");
    
    
    /**
     * Gets the "ResourceCategory" element
     */
    public java.lang.String getResourceCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESOURCECATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ResourceCategory" element
     */
    public org.erdc.cobie.cobielite.core.ResourceCategorySimpleType xgetResourceCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ResourceCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.ResourceCategorySimpleType)get_store().find_element_user(RESOURCECATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ResourceCategory" element
     */
    public void setResourceCategory(java.lang.String resourceCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESOURCECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RESOURCECATEGORY$0);
            }
            target.setStringValue(resourceCategory);
        }
    }
    
    /**
     * Sets (as xml) the "ResourceCategory" element
     */
    public void xsetResourceCategory(org.erdc.cobie.cobielite.core.ResourceCategorySimpleType resourceCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ResourceCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.ResourceCategorySimpleType)get_store().find_element_user(RESOURCECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.ResourceCategorySimpleType)get_store().add_element_user(RESOURCECATEGORY$0);
            }
            target.set(resourceCategory);
        }
    }
}
