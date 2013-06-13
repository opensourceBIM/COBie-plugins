/*
 * An XML document type.
 * Localname: SpareCategory
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpareCategoryDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SpareCategory(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SpareCategoryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SpareCategoryDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpareCategoryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPARECATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpareCategory");
    
    
    /**
     * Gets the "SpareCategory" element
     */
    public java.lang.String getSpareCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPARECATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SpareCategory" element
     */
    public org.erdc.cobie.cobielite.core.SpareCategorySimpleType xgetSpareCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpareCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.SpareCategorySimpleType)get_store().find_element_user(SPARECATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SpareCategory" element
     */
    public void setSpareCategory(java.lang.String spareCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPARECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SPARECATEGORY$0);
            }
            target.setStringValue(spareCategory);
        }
    }
    
    /**
     * Sets (as xml) the "SpareCategory" element
     */
    public void xsetSpareCategory(org.erdc.cobie.cobielite.core.SpareCategorySimpleType spareCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpareCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.SpareCategorySimpleType)get_store().find_element_user(SPARECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.SpareCategorySimpleType)get_store().add_element_user(SPARECATEGORY$0);
            }
            target.set(spareCategory);
        }
    }
}
