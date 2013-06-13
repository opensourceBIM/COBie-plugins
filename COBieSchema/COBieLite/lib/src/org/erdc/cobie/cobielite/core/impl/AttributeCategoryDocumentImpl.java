/*
 * An XML document type.
 * Localname: AttributeCategory
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeCategoryDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AttributeCategory(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AttributeCategoryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AttributeCategoryDocument
{
    private static final long serialVersionUID = 1L;
    
    public AttributeCategoryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTECATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeCategory");
    
    
    /**
     * Gets the "AttributeCategory" element
     */
    public java.lang.String getAttributeCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTECATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AttributeCategory" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCategorySimpleType xgetAttributeCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCategorySimpleType)get_store().find_element_user(ATTRIBUTECATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AttributeCategory" element
     */
    public void setAttributeCategory(java.lang.String attributeCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ATTRIBUTECATEGORY$0);
            }
            target.setStringValue(attributeCategory);
        }
    }
    
    /**
     * Sets (as xml) the "AttributeCategory" element
     */
    public void xsetAttributeCategory(org.erdc.cobie.cobielite.core.AttributeCategorySimpleType attributeCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCategorySimpleType)get_store().find_element_user(ATTRIBUTECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.AttributeCategorySimpleType)get_store().add_element_user(ATTRIBUTECATEGORY$0);
            }
            target.set(attributeCategory);
        }
    }
}
