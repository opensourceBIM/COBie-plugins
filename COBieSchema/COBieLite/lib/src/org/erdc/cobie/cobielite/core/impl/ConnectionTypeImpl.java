/*
 * XML Type:  ConnectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ConnectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML ConnectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class ConnectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieRowTypeImpl implements org.erdc.cobie.cobielite.core.ConnectionType
{
    private static final long serialVersionUID = 1L;
    
    public ConnectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONNECTIONNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ConnectionName");
    private static final javax.xml.namespace.QName CONNECTIONCATEGORY$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ConnectionCategory");
    
    
    /**
     * Gets the "ConnectionName" element
     */
    public java.lang.String getConnectionName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ConnectionName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetConnectionName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(CONNECTIONNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ConnectionName" element
     */
    public void setConnectionName(java.lang.String connectionName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONNECTIONNAME$0);
            }
            target.setStringValue(connectionName);
        }
    }
    
    /**
     * Sets (as xml) the "ConnectionName" element
     */
    public void xsetConnectionName(org.erdc.cobie.cobielite.core.CobieNameSimpleType connectionName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(CONNECTIONNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(CONNECTIONNAME$0);
            }
            target.set(connectionName);
        }
    }
    
    /**
     * Gets the "ConnectionCategory" element
     */
    public java.lang.String getConnectionCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONCATEGORY$2, 0);
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
            target = (org.erdc.cobie.cobielite.core.ConnectionCategorySimpleType)get_store().find_element_user(CONNECTIONCATEGORY$2, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONCATEGORY$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONNECTIONCATEGORY$2);
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
            target = (org.erdc.cobie.cobielite.core.ConnectionCategorySimpleType)get_store().find_element_user(CONNECTIONCATEGORY$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.ConnectionCategorySimpleType)get_store().add_element_user(CONNECTIONCATEGORY$2);
            }
            target.set(connectionCategory);
        }
    }
}
