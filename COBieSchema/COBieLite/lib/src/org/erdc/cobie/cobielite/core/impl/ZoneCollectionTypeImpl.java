/*
 * XML Type:  ZoneCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ZoneCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML ZoneCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class ZoneCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieWorksheetTypeImpl implements org.erdc.cobie.cobielite.core.ZoneCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public ZoneCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ZONE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Zone");
    private static final org.apache.xmlbeans.QNameSet ZONE$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://zone.cobielite.cobie.erdc.org", "Zone"),
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Zone"),
    });
    
    
    /**
     * Gets array of all "Zone" elements
     */
    public org.erdc.cobie.cobielite.core.ZoneType[] getZoneArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ZONE$1, targetList);
            org.erdc.cobie.cobielite.core.ZoneType[] result = new org.erdc.cobie.cobielite.core.ZoneType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Zone" element
     */
    public org.erdc.cobie.cobielite.core.ZoneType getZoneArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneType)get_store().find_element_user(ZONE$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Zone" element
     */
    public int sizeOfZoneArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ZONE$1);
        }
    }
    
    /**
     * Sets array of all "Zone" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setZoneArray(org.erdc.cobie.cobielite.core.ZoneType[] zoneArray)
    {
        check_orphaned();
        arraySetterHelper(zoneArray, ZONE$0, ZONE$1);
    }
    
    /**
     * Sets ith "Zone" element
     */
    public void setZoneArray(int i, org.erdc.cobie.cobielite.core.ZoneType zone)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneType)get_store().find_element_user(ZONE$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(zone);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Zone" element
     */
    public org.erdc.cobie.cobielite.core.ZoneType insertNewZone(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneType)get_store().insert_element_user(ZONE$1, ZONE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Zone" element
     */
    public org.erdc.cobie.cobielite.core.ZoneType addNewZone()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneType)get_store().add_element_user(ZONE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Zone" element
     */
    public void removeZone(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ZONE$1, i);
        }
    }
}
