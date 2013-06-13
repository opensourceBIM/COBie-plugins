/*
 * XML Type:  JobCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.JobCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML JobCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class JobCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieWorksheetTypeImpl implements org.erdc.cobie.cobielite.core.JobCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public JobCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName JOB$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Job");
    private static final org.apache.xmlbeans.QNameSet JOB$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Job"),
        new javax.xml.namespace.QName("http://job.cobielite.cobie.erdc.org", "Job"),
    });
    
    
    /**
     * Gets array of all "Job" elements
     */
    public org.erdc.cobie.cobielite.core.JobType[] getJobArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(JOB$1, targetList);
            org.erdc.cobie.cobielite.core.JobType[] result = new org.erdc.cobie.cobielite.core.JobType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Job" element
     */
    public org.erdc.cobie.cobielite.core.JobType getJobArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.JobType target = null;
            target = (org.erdc.cobie.cobielite.core.JobType)get_store().find_element_user(JOB$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Job" element
     */
    public int sizeOfJobArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(JOB$1);
        }
    }
    
    /**
     * Sets array of all "Job" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setJobArray(org.erdc.cobie.cobielite.core.JobType[] jobArray)
    {
        check_orphaned();
        arraySetterHelper(jobArray, JOB$0, JOB$1);
    }
    
    /**
     * Sets ith "Job" element
     */
    public void setJobArray(int i, org.erdc.cobie.cobielite.core.JobType job)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.JobType target = null;
            target = (org.erdc.cobie.cobielite.core.JobType)get_store().find_element_user(JOB$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(job);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Job" element
     */
    public org.erdc.cobie.cobielite.core.JobType insertNewJob(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.JobType target = null;
            target = (org.erdc.cobie.cobielite.core.JobType)get_store().insert_element_user(JOB$1, JOB$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Job" element
     */
    public org.erdc.cobie.cobielite.core.JobType addNewJob()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.JobType target = null;
            target = (org.erdc.cobie.cobielite.core.JobType)get_store().add_element_user(JOB$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Job" element
     */
    public void removeJob(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(JOB$1, i);
        }
    }
}
