/*
 * An XML document type.
 * Localname: Job
 * Namespace: http://job.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.job.JobDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.job.impl;
/**
 * A document containing one Job(@http://job.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class JobDocumentImpl extends org.erdc.cobie.cobielite.core.impl.JobDocumentImpl implements org.erdc.cobie.cobielite.job.JobDocument
{
    private static final long serialVersionUID = 1L;
    
    public JobDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName JOB2$0 = 
        new javax.xml.namespace.QName("http://job.cobielite.cobie.erdc.org", "Job");
    
    
    /**
     * Gets the "Job" element
     */
    public org.erdc.cobie.cobielite.job.JobType getJob2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.job.JobType target = null;
            target = (org.erdc.cobie.cobielite.job.JobType)get_store().find_element_user(JOB2$0, 0);
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
    public void setJob2(org.erdc.cobie.cobielite.job.JobType job2)
    {
        generatedSetterHelperImpl(job2, JOB2$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Job" element
     */
    public org.erdc.cobie.cobielite.job.JobType addNewJob2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.job.JobType target = null;
            target = (org.erdc.cobie.cobielite.job.JobType)get_store().add_element_user(JOB2$0);
            return target;
        }
    }
}
