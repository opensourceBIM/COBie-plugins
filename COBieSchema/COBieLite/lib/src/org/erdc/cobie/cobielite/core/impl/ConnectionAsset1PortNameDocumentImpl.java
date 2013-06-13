/*
 * An XML document type.
 * Localname: ConnectionAsset1PortName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ConnectionAsset1PortNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ConnectionAsset1PortName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ConnectionAsset1PortNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ConnectionAsset1PortNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public ConnectionAsset1PortNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONNECTIONASSET1PORTNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ConnectionAsset1PortName");
    
    
    /**
     * Gets the "ConnectionAsset1PortName" element
     */
    public java.lang.String getConnectionAsset1PortName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONASSET1PORTNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ConnectionAsset1PortName" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetConnectionAsset1PortName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONNECTIONASSET1PORTNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ConnectionAsset1PortName" element
     */
    public void setConnectionAsset1PortName(java.lang.String connectionAsset1PortName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONASSET1PORTNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONNECTIONASSET1PORTNAME$0);
            }
            target.setStringValue(connectionAsset1PortName);
        }
    }
    
    /**
     * Sets (as xml) the "ConnectionAsset1PortName" element
     */
    public void xsetConnectionAsset1PortName(org.erdc.cobie.cobielite.core.CobieTextSimpleType connectionAsset1PortName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONNECTIONASSET1PORTNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONNECTIONASSET1PORTNAME$0);
            }
            target.set(connectionAsset1PortName);
        }
    }
}
