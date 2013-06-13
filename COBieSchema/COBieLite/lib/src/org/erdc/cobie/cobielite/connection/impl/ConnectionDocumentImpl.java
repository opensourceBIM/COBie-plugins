/*
 * An XML document type.
 * Localname: Connection
 * Namespace: http://connection.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.connection.ConnectionDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.connection.impl;
/**
 * A document containing one Connection(@http://connection.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ConnectionDocumentImpl extends org.erdc.cobie.cobielite.core.impl.ConnectionDocumentImpl implements org.erdc.cobie.cobielite.connection.ConnectionDocument
{
    private static final long serialVersionUID = 1L;
    
    public ConnectionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONNECTION2$0 = 
        new javax.xml.namespace.QName("http://connection.cobielite.cobie.erdc.org", "Connection");
    
    
    /**
     * Gets the "Connection" element
     */
    public org.erdc.cobie.cobielite.connection.ConnectionType getConnection2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.connection.ConnectionType target = null;
            target = (org.erdc.cobie.cobielite.connection.ConnectionType)get_store().find_element_user(CONNECTION2$0, 0);
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
    public void setConnection2(org.erdc.cobie.cobielite.connection.ConnectionType connection2)
    {
        generatedSetterHelperImpl(connection2, CONNECTION2$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Connection" element
     */
    public org.erdc.cobie.cobielite.connection.ConnectionType addNewConnection2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.connection.ConnectionType target = null;
            target = (org.erdc.cobie.cobielite.connection.ConnectionType)get_store().add_element_user(CONNECTION2$0);
            return target;
        }
    }
}
