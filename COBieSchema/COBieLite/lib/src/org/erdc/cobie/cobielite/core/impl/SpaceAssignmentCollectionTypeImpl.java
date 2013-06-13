/*
 * XML Type:  SpaceAssignmentCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpaceAssignmentCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML SpaceAssignmentCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class SpaceAssignmentCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieComplexObjectTypeImpl implements org.erdc.cobie.cobielite.core.SpaceAssignmentCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public SpaceAssignmentCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPACEASSIGNMENT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceAssignment");
    
    
    /**
     * Gets array of all "SpaceAssignment" elements
     */
    public org.erdc.cobie.cobielite.core.SpaceKeyType[] getSpaceAssignmentArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(SPACEASSIGNMENT$0, targetList);
            org.erdc.cobie.cobielite.core.SpaceKeyType[] result = new org.erdc.cobie.cobielite.core.SpaceKeyType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "SpaceAssignment" element
     */
    public org.erdc.cobie.cobielite.core.SpaceKeyType getSpaceAssignmentArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceKeyType)get_store().find_element_user(SPACEASSIGNMENT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "SpaceAssignment" element
     */
    public int sizeOfSpaceAssignmentArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPACEASSIGNMENT$0);
        }
    }
    
    /**
     * Sets array of all "SpaceAssignment" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setSpaceAssignmentArray(org.erdc.cobie.cobielite.core.SpaceKeyType[] spaceAssignmentArray)
    {
        check_orphaned();
        arraySetterHelper(spaceAssignmentArray, SPACEASSIGNMENT$0);
    }
    
    /**
     * Sets ith "SpaceAssignment" element
     */
    public void setSpaceAssignmentArray(int i, org.erdc.cobie.cobielite.core.SpaceKeyType spaceAssignment)
    {
        generatedSetterHelperImpl(spaceAssignment, SPACEASSIGNMENT$0, i, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_ARRAYITEM);
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "SpaceAssignment" element
     */
    public org.erdc.cobie.cobielite.core.SpaceKeyType insertNewSpaceAssignment(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceKeyType)get_store().insert_element_user(SPACEASSIGNMENT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "SpaceAssignment" element
     */
    public org.erdc.cobie.cobielite.core.SpaceKeyType addNewSpaceAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceKeyType)get_store().add_element_user(SPACEASSIGNMENT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "SpaceAssignment" element
     */
    public void removeSpaceAssignment(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPACEASSIGNMENT$0, i);
        }
    }
}
