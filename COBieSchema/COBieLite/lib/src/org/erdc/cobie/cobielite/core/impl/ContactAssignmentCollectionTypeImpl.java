/*
 * XML Type:  ContactAssignmentCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML ContactAssignmentCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class ContactAssignmentCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieRowAssignmentsTypeImpl implements org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public ContactAssignmentCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTASSIGNMENT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactAssignment");
    
    
    /**
     * Gets array of all "ContactAssignment" elements
     */
    public org.erdc.cobie.cobielite.core.ContactKeyType[] getContactAssignmentArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(CONTACTASSIGNMENT$0, targetList);
            org.erdc.cobie.cobielite.core.ContactKeyType[] result = new org.erdc.cobie.cobielite.core.ContactKeyType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "ContactAssignment" element
     */
    public org.erdc.cobie.cobielite.core.ContactKeyType getContactAssignmentArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactKeyType)get_store().find_element_user(CONTACTASSIGNMENT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "ContactAssignment" element
     */
    public int sizeOfContactAssignmentArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTASSIGNMENT$0);
        }
    }
    
    /**
     * Sets array of all "ContactAssignment" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setContactAssignmentArray(org.erdc.cobie.cobielite.core.ContactKeyType[] contactAssignmentArray)
    {
        check_orphaned();
        arraySetterHelper(contactAssignmentArray, CONTACTASSIGNMENT$0);
    }
    
    /**
     * Sets ith "ContactAssignment" element
     */
    public void setContactAssignmentArray(int i, org.erdc.cobie.cobielite.core.ContactKeyType contactAssignment)
    {
        generatedSetterHelperImpl(contactAssignment, CONTACTASSIGNMENT$0, i, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_ARRAYITEM);
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "ContactAssignment" element
     */
    public org.erdc.cobie.cobielite.core.ContactKeyType insertNewContactAssignment(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactKeyType)get_store().insert_element_user(CONTACTASSIGNMENT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "ContactAssignment" element
     */
    public org.erdc.cobie.cobielite.core.ContactKeyType addNewContactAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactKeyType)get_store().add_element_user(CONTACTASSIGNMENT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "ContactAssignment" element
     */
    public void removeContactAssignment(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTASSIGNMENT$0, i);
        }
    }
}
