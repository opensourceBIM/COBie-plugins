/*
 * XML Type:  SystemCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SystemCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML SystemCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class SystemCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieWorksheetTypeImpl implements org.erdc.cobie.cobielite.core.SystemCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public SystemCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SYSTEM$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "System");
    private static final org.apache.xmlbeans.QNameSet SYSTEM$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://system.cobielite.cobie.erdc.org", "System"),
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "System"),
    });
    
    
    /**
     * Gets array of all "System" elements
     */
    public org.erdc.cobie.cobielite.core.SystemType[] getSystemArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(SYSTEM$1, targetList);
            org.erdc.cobie.cobielite.core.SystemType[] result = new org.erdc.cobie.cobielite.core.SystemType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "System" element
     */
    public org.erdc.cobie.cobielite.core.SystemType getSystemArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemType)get_store().find_element_user(SYSTEM$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "System" element
     */
    public int sizeOfSystemArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SYSTEM$1);
        }
    }
    
    /**
     * Sets array of all "System" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setSystemArray(org.erdc.cobie.cobielite.core.SystemType[] systemArray)
    {
        check_orphaned();
        arraySetterHelper(systemArray, SYSTEM$0, SYSTEM$1);
    }
    
    /**
     * Sets ith "System" element
     */
    public void setSystemArray(int i, org.erdc.cobie.cobielite.core.SystemType system)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemType)get_store().find_element_user(SYSTEM$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(system);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "System" element
     */
    public org.erdc.cobie.cobielite.core.SystemType insertNewSystem(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemType)get_store().insert_element_user(SYSTEM$1, SYSTEM$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "System" element
     */
    public org.erdc.cobie.cobielite.core.SystemType addNewSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemType)get_store().add_element_user(SYSTEM$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "System" element
     */
    public void removeSystem(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SYSTEM$1, i);
        }
    }
}
