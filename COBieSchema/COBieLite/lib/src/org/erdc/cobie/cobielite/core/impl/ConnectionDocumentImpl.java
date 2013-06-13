/*
 * An XML document type.
 * Localname: Connection
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ConnectionDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Connection(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ConnectionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ConnectionDocument
{
    private static final long serialVersionUID = 1L;
    
    public ConnectionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONNECTION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Connection");
    private static final org.apache.xmlbeans.QNameSet CONNECTION$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Connection"),
        new javax.xml.namespace.QName("http://connection.cobielite.cobie.erdc.org", "Connection"),
    });
    
    
    /**
     * Gets the "Connection" element
     */
    public org.erdc.cobie.cobielite.core.ConnectionType getConnection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ConnectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ConnectionType)get_store().find_element_user(CONNECTION$1, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Connection" element
     */
    public void setConnection(org.erdc.cobie.cobielite.core.ConnectionType connection)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ConnectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ConnectionType)get_store().find_element_user(CONNECTION$1, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.ConnectionType)get_store().add_element_user(CONNECTION$0);
            }
            target.set(connection);
        }
    }
    
    /**
     * Appends and returns a new empty "Connection" element
     */
    public org.erdc.cobie.cobielite.core.ConnectionType addNewConnection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ConnectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ConnectionType)get_store().add_element_user(CONNECTION$0);
            return target;
        }
    }
}
