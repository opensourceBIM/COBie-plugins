/*
 * XML Type:  SystemAssignmentCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SystemAssignmentCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML SystemAssignmentCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class SystemAssignmentCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieRowAssignmentsTypeImpl implements org.erdc.cobie.cobielite.core.SystemAssignmentCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public SystemAssignmentCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SYSTEMASSIGNMENT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SystemAssignment");
    
    
    /**
     * Gets array of all "SystemAssignment" elements
     */
    public org.erdc.cobie.cobielite.core.SystemKeyType[] getSystemAssignmentArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(SYSTEMASSIGNMENT$0, targetList);
            org.erdc.cobie.cobielite.core.SystemKeyType[] result = new org.erdc.cobie.cobielite.core.SystemKeyType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "SystemAssignment" element
     */
    public org.erdc.cobie.cobielite.core.SystemKeyType getSystemAssignmentArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemKeyType)get_store().find_element_user(SYSTEMASSIGNMENT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "SystemAssignment" element
     */
    public int sizeOfSystemAssignmentArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SYSTEMASSIGNMENT$0);
        }
    }
    
    /**
     * Sets array of all "SystemAssignment" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setSystemAssignmentArray(org.erdc.cobie.cobielite.core.SystemKeyType[] systemAssignmentArray)
    {
        check_orphaned();
        arraySetterHelper(systemAssignmentArray, SYSTEMASSIGNMENT$0);
    }
    
    /**
     * Sets ith "SystemAssignment" element
     */
    public void setSystemAssignmentArray(int i, org.erdc.cobie.cobielite.core.SystemKeyType systemAssignment)
    {
        generatedSetterHelperImpl(systemAssignment, SYSTEMASSIGNMENT$0, i, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_ARRAYITEM);
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "SystemAssignment" element
     */
    public org.erdc.cobie.cobielite.core.SystemKeyType insertNewSystemAssignment(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemKeyType)get_store().insert_element_user(SYSTEMASSIGNMENT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "SystemAssignment" element
     */
    public org.erdc.cobie.cobielite.core.SystemKeyType addNewSystemAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemKeyType)get_store().add_element_user(SYSTEMASSIGNMENT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "SystemAssignment" element
     */
    public void removeSystemAssignment(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SYSTEMASSIGNMENT$0, i);
        }
    }
}
