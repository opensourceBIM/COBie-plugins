/*
 * XML Type:  AssemblyAssignmentCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML AssemblyAssignmentCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class AssemblyAssignmentCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieRowAssignmentsTypeImpl implements org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public AssemblyAssignmentCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSEMBLYASSIGNMENT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssemblyAssignment");
    private static final org.apache.xmlbeans.QNameSet ASSEMBLYASSIGNMENT$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssemblyAssignment"),
        new javax.xml.namespace.QName("http://assembly.cobielite.cobie.erdc.org", "AssemblyAssignment"),
    });
    
    
    /**
     * Gets array of all "AssemblyAssignment" elements
     */
    public org.erdc.cobie.cobielite.core.AssemblyType[] getAssemblyAssignmentArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ASSEMBLYASSIGNMENT$1, targetList);
            org.erdc.cobie.cobielite.core.AssemblyType[] result = new org.erdc.cobie.cobielite.core.AssemblyType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "AssemblyAssignment" element
     */
    public org.erdc.cobie.cobielite.core.AssemblyType getAssemblyAssignmentArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssemblyType target = null;
            target = (org.erdc.cobie.cobielite.core.AssemblyType)get_store().find_element_user(ASSEMBLYASSIGNMENT$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "AssemblyAssignment" element
     */
    public int sizeOfAssemblyAssignmentArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSEMBLYASSIGNMENT$1);
        }
    }
    
    /**
     * Sets array of all "AssemblyAssignment" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setAssemblyAssignmentArray(org.erdc.cobie.cobielite.core.AssemblyType[] assemblyAssignmentArray)
    {
        check_orphaned();
        arraySetterHelper(assemblyAssignmentArray, ASSEMBLYASSIGNMENT$0, ASSEMBLYASSIGNMENT$1);
    }
    
    /**
     * Sets ith "AssemblyAssignment" element
     */
    public void setAssemblyAssignmentArray(int i, org.erdc.cobie.cobielite.core.AssemblyType assemblyAssignment)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssemblyType target = null;
            target = (org.erdc.cobie.cobielite.core.AssemblyType)get_store().find_element_user(ASSEMBLYASSIGNMENT$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(assemblyAssignment);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "AssemblyAssignment" element
     */
    public org.erdc.cobie.cobielite.core.AssemblyType insertNewAssemblyAssignment(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssemblyType target = null;
            target = (org.erdc.cobie.cobielite.core.AssemblyType)get_store().insert_element_user(ASSEMBLYASSIGNMENT$1, ASSEMBLYASSIGNMENT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "AssemblyAssignment" element
     */
    public org.erdc.cobie.cobielite.core.AssemblyType addNewAssemblyAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssemblyType target = null;
            target = (org.erdc.cobie.cobielite.core.AssemblyType)get_store().add_element_user(ASSEMBLYASSIGNMENT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "AssemblyAssignment" element
     */
    public void removeAssemblyAssignment(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSEMBLYASSIGNMENT$1, i);
        }
    }
}
