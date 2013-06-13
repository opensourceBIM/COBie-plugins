/*
 * XML Type:  SpaceCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpaceCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML SpaceCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class SpaceCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieWorksheetTypeImpl implements org.erdc.cobie.cobielite.core.SpaceCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public SpaceCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPACE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Space");
    private static final org.apache.xmlbeans.QNameSet SPACE$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Space"),
        new javax.xml.namespace.QName("http://space.cobielite.cobie.erdc.org", "Space"),
    });
    
    
    /**
     * Gets array of all "Space" elements
     */
    public org.erdc.cobie.cobielite.core.SpaceType[] getSpaceArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(SPACE$1, targetList);
            org.erdc.cobie.cobielite.core.SpaceType[] result = new org.erdc.cobie.cobielite.core.SpaceType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Space" element
     */
    public org.erdc.cobie.cobielite.core.SpaceType getSpaceArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceType)get_store().find_element_user(SPACE$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Space" element
     */
    public int sizeOfSpaceArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPACE$1);
        }
    }
    
    /**
     * Sets array of all "Space" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setSpaceArray(org.erdc.cobie.cobielite.core.SpaceType[] spaceArray)
    {
        check_orphaned();
        arraySetterHelper(spaceArray, SPACE$0, SPACE$1);
    }
    
    /**
     * Sets ith "Space" element
     */
    public void setSpaceArray(int i, org.erdc.cobie.cobielite.core.SpaceType space)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceType)get_store().find_element_user(SPACE$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(space);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Space" element
     */
    public org.erdc.cobie.cobielite.core.SpaceType insertNewSpace(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceType)get_store().insert_element_user(SPACE$1, SPACE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Space" element
     */
    public org.erdc.cobie.cobielite.core.SpaceType addNewSpace()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceType)get_store().add_element_user(SPACE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Space" element
     */
    public void removeSpace(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPACE$1, i);
        }
    }
}
