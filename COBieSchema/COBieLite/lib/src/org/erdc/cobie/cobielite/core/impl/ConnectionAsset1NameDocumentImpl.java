/*
 * An XML document type.
 * Localname: ConnectionAsset1Name
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ConnectionAsset1NameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ConnectionAsset1Name(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ConnectionAsset1NameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ConnectionAsset1NameDocument
{
    private static final long serialVersionUID = 1L;
    
    public ConnectionAsset1NameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONNECTIONASSET1NAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ConnectionAsset1Name");
    
    
    /**
     * Gets the "ConnectionAsset1Name" element
     */
    public java.lang.String getConnectionAsset1Name()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONASSET1NAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ConnectionAsset1Name" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetConnectionAsset1Name()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(CONNECTIONASSET1NAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ConnectionAsset1Name" element
     */
    public void setConnectionAsset1Name(java.lang.String connectionAsset1Name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONASSET1NAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONNECTIONASSET1NAME$0);
            }
            target.setStringValue(connectionAsset1Name);
        }
    }
    
    /**
     * Sets (as xml) the "ConnectionAsset1Name" element
     */
    public void xsetConnectionAsset1Name(org.erdc.cobie.cobielite.core.CobieNameSimpleType connectionAsset1Name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(CONNECTIONASSET1NAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(CONNECTIONASSET1NAME$0);
            }
            target.set(connectionAsset1Name);
        }
    }
}
