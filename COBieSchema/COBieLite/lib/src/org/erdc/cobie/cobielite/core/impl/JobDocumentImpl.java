/*
 * An XML document type.
 * Localname: Job
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.JobDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Job(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class JobDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.JobDocument
{
    private static final long serialVersionUID = 1L;
    
    public JobDocumentImpl(org.apache.xmlbeans.SchemaType sType)
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
     * Gets the "Job" element
     */
    public org.erdc.cobie.cobielite.core.JobType getJob()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.JobType target = null;
            target = (org.erdc.cobie.cobielite.core.JobType)get_store().find_element_user(JOB$1, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Job" element
     */
    public void setJob(org.erdc.cobie.cobielite.core.JobType job)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.JobType target = null;
            target = (org.erdc.cobie.cobielite.core.JobType)get_store().find_element_user(JOB$1, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.JobType)get_store().add_element_user(JOB$0);
            }
            target.set(job);
        }
    }
    
    /**
     * Appends and returns a new empty "Job" element
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
}
