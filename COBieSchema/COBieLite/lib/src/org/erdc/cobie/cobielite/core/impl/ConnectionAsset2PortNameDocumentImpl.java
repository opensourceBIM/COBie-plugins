/*
 * An XML document type.
 * Localname: ConnectionAsset2PortName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ConnectionAsset2PortNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ConnectionAsset2PortName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ConnectionAsset2PortNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ConnectionAsset2PortNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public ConnectionAsset2PortNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONNECTIONASSET2PORTNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ConnectionAsset2PortName");
    
    
    /**
     * Gets the "ConnectionAsset2PortName" element
     */
    public java.lang.String getConnectionAsset2PortName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONASSET2PORTNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ConnectionAsset2PortName" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetConnectionAsset2PortName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONNECTIONASSET2PORTNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ConnectionAsset2PortName" element
     */
    public void setConnectionAsset2PortName(java.lang.String connectionAsset2PortName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONASSET2PORTNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONNECTIONASSET2PORTNAME$0);
            }
            target.setStringValue(connectionAsset2PortName);
        }
    }
    
    /**
     * Sets (as xml) the "ConnectionAsset2PortName" element
     */
    public void xsetConnectionAsset2PortName(org.erdc.cobie.cobielite.core.CobieTextSimpleType connectionAsset2PortName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONNECTIONASSET2PORTNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONNECTIONASSET2PORTNAME$0);
            }
            target.set(connectionAsset2PortName);
        }
    }
}
