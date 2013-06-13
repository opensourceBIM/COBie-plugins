/*
 * An XML document type.
 * Localname: FloorCategory
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.FloorCategoryDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one FloorCategory(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FloorCategoryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.FloorCategoryDocument
{
    private static final long serialVersionUID = 1L;
    
    public FloorCategoryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FLOORCATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FloorCategory");
    
    
    /**
     * Gets the "FloorCategory" element
     */
    public java.lang.String getFloorCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FLOORCATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FloorCategory" element
     */
    public org.erdc.cobie.cobielite.core.FloorCategorySimpleType xgetFloorCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FloorCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.FloorCategorySimpleType)get_store().find_element_user(FLOORCATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "FloorCategory" element
     */
    public void setFloorCategory(java.lang.String floorCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FLOORCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FLOORCATEGORY$0);
            }
            target.setStringValue(floorCategory);
        }
    }
    
    /**
     * Sets (as xml) the "FloorCategory" element
     */
    public void xsetFloorCategory(org.erdc.cobie.cobielite.core.FloorCategorySimpleType floorCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FloorCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.FloorCategorySimpleType)get_store().find_element_user(FLOORCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.FloorCategorySimpleType)get_store().add_element_user(FLOORCATEGORY$0);
            }
            target.set(floorCategory);
        }
    }
}
