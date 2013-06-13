/*
 * XML Type:  IssueCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.IssueCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML IssueCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class IssueCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieWorksheetTypeImpl implements org.erdc.cobie.cobielite.core.IssueCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public IssueCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ISSUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Issue");
    private static final org.apache.xmlbeans.QNameSet ISSUE$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Issue"),
        new javax.xml.namespace.QName("http://issue.cobielite.cobie.erdc.org", "Issue"),
    });
    
    
    /**
     * Gets array of all "Issue" elements
     */
    public org.erdc.cobie.cobielite.core.IssueType[] getIssueArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ISSUE$1, targetList);
            org.erdc.cobie.cobielite.core.IssueType[] result = new org.erdc.cobie.cobielite.core.IssueType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Issue" element
     */
    public org.erdc.cobie.cobielite.core.IssueType getIssueArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueType)get_store().find_element_user(ISSUE$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Issue" element
     */
    public int sizeOfIssueArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ISSUE$1);
        }
    }
    
    /**
     * Sets array of all "Issue" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setIssueArray(org.erdc.cobie.cobielite.core.IssueType[] issueArray)
    {
        check_orphaned();
        arraySetterHelper(issueArray, ISSUE$0, ISSUE$1);
    }
    
    /**
     * Sets ith "Issue" element
     */
    public void setIssueArray(int i, org.erdc.cobie.cobielite.core.IssueType issue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueType)get_store().find_element_user(ISSUE$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(issue);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Issue" element
     */
    public org.erdc.cobie.cobielite.core.IssueType insertNewIssue(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueType)get_store().insert_element_user(ISSUE$1, ISSUE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Issue" element
     */
    public org.erdc.cobie.cobielite.core.IssueType addNewIssue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueType)get_store().add_element_user(ISSUE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Issue" element
     */
    public void removeIssue(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ISSUE$1, i);
        }
    }
}
