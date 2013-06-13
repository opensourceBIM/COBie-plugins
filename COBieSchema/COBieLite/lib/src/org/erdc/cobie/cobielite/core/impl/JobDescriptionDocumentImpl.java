/*
 * An XML document type.
 * Localname: JobDescription
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.JobDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one JobDescription(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class JobDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.JobDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public JobDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName JOBDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobDescription");
    
    
    /**
     * Gets the "JobDescription" element
     */
    public java.lang.String getJobDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "JobDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetJobDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(JOBDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "JobDescription" element
     */
    public void setJobDescription(java.lang.String jobDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(JOBDESCRIPTION$0);
            }
            target.setStringValue(jobDescription);
        }
    }
    
    /**
     * Sets (as xml) the "JobDescription" element
     */
    public void xsetJobDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType jobDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(JOBDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(JOBDESCRIPTION$0);
            }
            target.set(jobDescription);
        }
    }
}
