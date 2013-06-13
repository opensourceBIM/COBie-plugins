/*
 * XML Type:  FloorCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.FloorCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML FloorCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class FloorCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieWorksheetTypeImpl implements org.erdc.cobie.cobielite.core.FloorCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public FloorCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FLOOR$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Floor");
    private static final org.apache.xmlbeans.QNameSet FLOOR$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://floor.cobielite.cobie.erdc.org", "Floor"),
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Floor"),
    });
    
    
    /**
     * Gets array of all "Floor" elements
     */
    public org.erdc.cobie.cobielite.core.FloorType[] getFloorArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(FLOOR$1, targetList);
            org.erdc.cobie.cobielite.core.FloorType[] result = new org.erdc.cobie.cobielite.core.FloorType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Floor" element
     */
    public org.erdc.cobie.cobielite.core.FloorType getFloorArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FloorType target = null;
            target = (org.erdc.cobie.cobielite.core.FloorType)get_store().find_element_user(FLOOR$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Floor" element
     */
    public int sizeOfFloorArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FLOOR$1);
        }
    }
    
    /**
     * Sets array of all "Floor" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setFloorArray(org.erdc.cobie.cobielite.core.FloorType[] floorArray)
    {
        check_orphaned();
        arraySetterHelper(floorArray, FLOOR$0, FLOOR$1);
    }
    
    /**
     * Sets ith "Floor" element
     */
    public void setFloorArray(int i, org.erdc.cobie.cobielite.core.FloorType floor)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FloorType target = null;
            target = (org.erdc.cobie.cobielite.core.FloorType)get_store().find_element_user(FLOOR$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(floor);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Floor" element
     */
    public org.erdc.cobie.cobielite.core.FloorType insertNewFloor(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FloorType target = null;
            target = (org.erdc.cobie.cobielite.core.FloorType)get_store().insert_element_user(FLOOR$1, FLOOR$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Floor" element
     */
    public org.erdc.cobie.cobielite.core.FloorType addNewFloor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FloorType target = null;
            target = (org.erdc.cobie.cobielite.core.FloorType)get_store().add_element_user(FLOOR$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Floor" element
     */
    public void removeFloor(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FLOOR$1, i);
        }
    }
}
