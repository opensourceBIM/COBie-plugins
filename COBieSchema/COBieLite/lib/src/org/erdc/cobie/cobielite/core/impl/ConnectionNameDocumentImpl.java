/*
 * An XML document type.
 * Localname: ConnectionName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ConnectionNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ConnectionName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ConnectionNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ConnectionNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public ConnectionNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONNECTIONNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ConnectionName");
    
    
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
}
