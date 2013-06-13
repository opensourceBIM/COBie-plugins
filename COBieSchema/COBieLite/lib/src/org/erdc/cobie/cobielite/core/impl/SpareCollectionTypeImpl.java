/*
 * XML Type:  SpareCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpareCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML SpareCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class SpareCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieWorksheetTypeImpl implements org.erdc.cobie.cobielite.core.SpareCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public SpareCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPARE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Spare");
    private static final org.apache.xmlbeans.QNameSet SPARE$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Spare"),
        new javax.xml.namespace.QName("http://spare.cobielite.cobie.erdc.org", "Spare"),
    });
    
    
    /**
     * Gets array of all "Spare" elements
     */
    public org.erdc.cobie.cobielite.core.SpareType[] getSpareArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(SPARE$1, targetList);
            org.erdc.cobie.cobielite.core.SpareType[] result = new org.erdc.cobie.cobielite.core.SpareType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Spare" element
     */
    public org.erdc.cobie.cobielite.core.SpareType getSpareArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpareType target = null;
            target = (org.erdc.cobie.cobielite.core.SpareType)get_store().find_element_user(SPARE$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Spare" element
     */
    public int sizeOfSpareArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPARE$1);
        }
    }
    
    /**
     * Sets array of all "Spare" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setSpareArray(org.erdc.cobie.cobielite.core.SpareType[] spareArray)
    {
        check_orphaned();
        arraySetterHelper(spareArray, SPARE$0, SPARE$1);
    }
    
    /**
     * Sets ith "Spare" element
     */
    public void setSpareArray(int i, org.erdc.cobie.cobielite.core.SpareType spare)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpareType target = null;
            target = (org.erdc.cobie.cobielite.core.SpareType)get_store().find_element_user(SPARE$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(spare);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Spare" element
     */
    public org.erdc.cobie.cobielite.core.SpareType insertNewSpare(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpareType target = null;
            target = (org.erdc.cobie.cobielite.core.SpareType)get_store().insert_element_user(SPARE$1, SPARE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Spare" element
     */
    public org.erdc.cobie.cobielite.core.SpareType addNewSpare()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpareType target = null;
            target = (org.erdc.cobie.cobielite.core.SpareType)get_store().add_element_user(SPARE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Spare" element
     */
    public void removeSpare(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPARE$1, i);
        }
    }
}
