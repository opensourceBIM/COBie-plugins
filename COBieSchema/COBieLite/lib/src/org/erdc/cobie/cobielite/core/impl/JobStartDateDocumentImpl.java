/*
 * An XML document type.
 * Localname: JobStartDate
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.JobStartDateDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one JobStartDate(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class JobStartDateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.JobStartDateDocument
{
    private static final long serialVersionUID = 1L;
    
    public JobStartDateDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName JOBSTARTDATE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobStartDate");
    
    
    /**
     * Gets the "JobStartDate" element
     */
    public java.util.Calendar getJobStartDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBSTARTDATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "JobStartDate" element
     */
    public org.apache.xmlbeans.XmlDate xgetJobStartDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(JOBSTARTDATE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "JobStartDate" element
     */
    public void setJobStartDate(java.util.Calendar jobStartDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBSTARTDATE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(JOBSTARTDATE$0);
            }
            target.setCalendarValue(jobStartDate);
        }
    }
    
    /**
     * Sets (as xml) the "JobStartDate" element
     */
    public void xsetJobStartDate(org.apache.xmlbeans.XmlDate jobStartDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(JOBSTARTDATE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDate)get_store().add_element_user(JOBSTARTDATE$0);
            }
            target.set(jobStartDate);
        }
    }
}
