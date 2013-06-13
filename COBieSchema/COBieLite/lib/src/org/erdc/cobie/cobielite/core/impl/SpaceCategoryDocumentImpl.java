/*
 * An XML document type.
 * Localname: SpaceCategory
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpaceCategoryDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SpaceCategory(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SpaceCategoryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SpaceCategoryDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpaceCategoryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPACECATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceCategory");
    
    
    /**
     * Gets the "SpaceCategory" element
     */
    public java.lang.String getSpaceCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPACECATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SpaceCategory" element
     */
    public org.erdc.cobie.cobielite.core.SpaceCategorySimpleType xgetSpaceCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceCategorySimpleType)get_store().find_element_user(SPACECATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SpaceCategory" element
     */
    public void setSpaceCategory(java.lang.String spaceCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPACECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SPACECATEGORY$0);
            }
            target.setStringValue(spaceCategory);
        }
    }
    
    /**
     * Sets (as xml) the "SpaceCategory" element
     */
    public void xsetSpaceCategory(org.erdc.cobie.cobielite.core.SpaceCategorySimpleType spaceCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceCategorySimpleType)get_store().find_element_user(SPACECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.SpaceCategorySimpleType)get_store().add_element_user(SPACECATEGORY$0);
            }
            target.set(spaceCategory);
        }
    }
}
