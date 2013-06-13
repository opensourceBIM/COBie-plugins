/*
 * XML Type:  ConnectionCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ConnectionCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML ConnectionCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class ConnectionCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieWorksheetTypeImpl implements org.erdc.cobie.cobielite.core.ConnectionCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public ConnectionCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
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
     * Gets array of all "Connection" elements
     */
    public org.erdc.cobie.cobielite.core.ConnectionType[] getConnectionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(CONNECTION$1, targetList);
            org.erdc.cobie.cobielite.core.ConnectionType[] result = new org.erdc.cobie.cobielite.core.ConnectionType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Connection" element
     */
    public org.erdc.cobie.cobielite.core.ConnectionType getConnectionArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ConnectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ConnectionType)get_store().find_element_user(CONNECTION$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Connection" element
     */
    public int sizeOfConnectionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONNECTION$1);
        }
    }
    
    /**
     * Sets array of all "Connection" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setConnectionArray(org.erdc.cobie.cobielite.core.ConnectionType[] connectionArray)
    {
        check_orphaned();
        arraySetterHelper(connectionArray, CONNECTION$0, CONNECTION$1);
    }
    
    /**
     * Sets ith "Connection" element
     */
    public void setConnectionArray(int i, org.erdc.cobie.cobielite.core.ConnectionType connection)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ConnectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ConnectionType)get_store().find_element_user(CONNECTION$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(connection);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Connection" element
     */
    public org.erdc.cobie.cobielite.core.ConnectionType insertNewConnection(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ConnectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ConnectionType)get_store().insert_element_user(CONNECTION$1, CONNECTION$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Connection" element
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
    
    /**
     * Removes the ith "Connection" element
     */
    public void removeConnection(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONNECTION$1, i);
        }
    }
}
