/*
 * An XML document type.
 * Localname: JobPriorTaskID
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.JobPriorTaskIDDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one JobPriorTaskID(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class JobPriorTaskIDDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.JobPriorTaskIDDocument
{
    private static final long serialVersionUID = 1L;
    
    public JobPriorTaskIDDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName JOBPRIORTASKID$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobPriorTaskID");
    
    
    /**
     * Gets the "JobPriorTaskID" element
     */
    public java.lang.String getJobPriorTaskID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBPRIORTASKID$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "JobPriorTaskID" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetJobPriorTaskID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(JOBPRIORTASKID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "JobPriorTaskID" element
     */
    public void setJobPriorTaskID(java.lang.String jobPriorTaskID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBPRIORTASKID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(JOBPRIORTASKID$0);
            }
            target.setStringValue(jobPriorTaskID);
        }
    }
    
    /**
     * Sets (as xml) the "JobPriorTaskID" element
     */
    public void xsetJobPriorTaskID(org.erdc.cobie.cobielite.core.CobieTextSimpleType jobPriorTaskID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(JOBPRIORTASKID$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(JOBPRIORTASKID$0);
            }
            target.set(jobPriorTaskID);
        }
    }
}
