/*
 * An XML document type.
 * Localname: JobName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.JobNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one JobName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class JobNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.JobNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public JobNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName JOBNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobName");
    
    
    /**
     * Gets the "JobName" element
     */
    public java.lang.String getJobName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "JobName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetJobName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(JOBNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "JobName" element
     */
    public void setJobName(java.lang.String jobName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(JOBNAME$0);
            }
            target.setStringValue(jobName);
        }
    }
    
    /**
     * Sets (as xml) the "JobName" element
     */
    public void xsetJobName(org.erdc.cobie.cobielite.core.CobieNameSimpleType jobName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(JOBNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(JOBNAME$0);
            }
            target.set(jobName);
        }
    }
}
