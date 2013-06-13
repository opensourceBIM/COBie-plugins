/*
 * An XML document type.
 * Localname: ConnectionAsset2Name
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ConnectionAsset2NameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ConnectionAsset2Name(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ConnectionAsset2NameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ConnectionAsset2NameDocument
{
    private static final long serialVersionUID = 1L;
    
    public ConnectionAsset2NameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONNECTIONASSET2NAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ConnectionAsset2Name");
    
    
    /**
     * Gets the "ConnectionAsset2Name" element
     */
    public java.lang.String getConnectionAsset2Name()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONASSET2NAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ConnectionAsset2Name" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetConnectionAsset2Name()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(CONNECTIONASSET2NAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ConnectionAsset2Name" element
     */
    public void setConnectionAsset2Name(java.lang.String connectionAsset2Name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONASSET2NAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONNECTIONASSET2NAME$0);
            }
            target.setStringValue(connectionAsset2Name);
        }
    }
    
    /**
     * Sets (as xml) the "ConnectionAsset2Name" element
     */
    public void xsetConnectionAsset2Name(org.erdc.cobie.cobielite.core.CobieNameSimpleType connectionAsset2Name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(CONNECTIONASSET2NAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(CONNECTIONASSET2NAME$0);
            }
            target.set(connectionAsset2Name);
        }
    }
}
