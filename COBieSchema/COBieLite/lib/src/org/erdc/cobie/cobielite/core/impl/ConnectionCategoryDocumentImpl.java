/*
 * An XML document type.
 * Localname: ConnectionCategory
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ConnectionCategoryDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ConnectionCategory(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ConnectionCategoryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ConnectionCategoryDocument
{
    private static final long serialVersionUID = 1L;
    
    public ConnectionCategoryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONNECTIONCATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ConnectionCategory");
    
    
    /**
     * Gets the "ConnectionCategory" element
     */
    public java.lang.String getConnectionCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONCATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ConnectionCategory" element
     */
    public org.erdc.cobie.cobielite.core.ConnectionCategorySimpleType xgetConnectionCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ConnectionCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.ConnectionCategorySimpleType)get_store().find_element_user(CONNECTIONCATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ConnectionCategory" element
     */
    public void setConnectionCategory(java.lang.String connectionCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONNECTIONCATEGORY$0);
            }
            target.setStringValue(connectionCategory);
        }
    }
    
    /**
     * Sets (as xml) the "ConnectionCategory" element
     */
    public void xsetConnectionCategory(org.erdc.cobie.cobielite.core.ConnectionCategorySimpleType connectionCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ConnectionCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.ConnectionCategorySimpleType)get_store().find_element_user(CONNECTIONCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.ConnectionCategorySimpleType)get_store().add_element_user(CONNECTIONCATEGORY$0);
            }
            target.set(connectionCategory);
        }
    }
}
