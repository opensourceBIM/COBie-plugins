/*
 * An XML document type.
 * Localname: JobTaskID
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.JobTaskIDDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one JobTaskID(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class JobTaskIDDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.JobTaskIDDocument
{
    private static final long serialVersionUID = 1L;
    
    public JobTaskIDDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName JOBTASKID$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobTaskID");
    
    
    /**
     * Gets the "JobTaskID" element
     */
    public java.lang.String getJobTaskID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBTASKID$0, 0);
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
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(JOBTASKID$0, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBTASKID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(JOBTASKID$0);
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
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(JOBTASKID$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(JOBTASKID$0);
            }
            target.set(jobTaskID);
        }
    }
}
