/*
 * XML Type:  JobKeyType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.JobKeyType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML JobKeyType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class JobKeyTypeImpl extends org.erdc.cobie.cobielite.core.impl.AssetTypeKeyTypeImpl implements org.erdc.cobie.cobielite.core.JobKeyType
{
    private static final long serialVersionUID = 1L;
    
    public JobKeyTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName JOBNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobName");
    private static final javax.xml.namespace.QName JOBTASKID$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobTaskID");
    
    
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
    
    /**
     * Gets the "JobTaskID" element
     */
    public java.lang.String getJobTaskID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBTASKID$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "JobTaskID" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetJobTaskID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(JOBTASKID$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "JobTaskID" element
     */
    public void setJobTaskID(java.lang.String jobTaskID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBTASKID$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(JOBTASKID$2);
            }
            target.setStringValue(jobTaskID);
        }
    }
    
    /**
     * Sets (as xml) the "JobTaskID" element
     */
    public void xsetJobTaskID(org.erdc.cobie.cobielite.core.CobieTextSimpleType jobTaskID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(JOBTASKID$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(JOBTASKID$2);
            }
            target.set(jobTaskID);
        }
    }
}
