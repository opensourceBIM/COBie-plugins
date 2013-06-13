/*
 * An XML document type.
 * Localname: JobStatus
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.JobStatusDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one JobStatus(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class JobStatusDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.JobStatusDocument
{
    private static final long serialVersionUID = 1L;
    
    public JobStatusDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName JOBSTATUS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobStatus");
    
    
    /**
     * Gets the "JobStatus" element
     */
    public java.lang.String getJobStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBSTATUS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "JobStatus" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetJobStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(JOBSTATUS$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "JobStatus" element
     */
    public void setJobStatus(java.lang.String jobStatus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBSTATUS$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(JOBSTATUS$0);
            }
            target.setStringValue(jobStatus);
        }
    }
    
    /**
     * Sets (as xml) the "JobStatus" element
     */
    public void xsetJobStatus(org.erdc.cobie.cobielite.core.CobieTextSimpleType jobStatus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(JOBSTATUS$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(JOBSTATUS$0);
            }
            target.set(jobStatus);
        }
    }
}
