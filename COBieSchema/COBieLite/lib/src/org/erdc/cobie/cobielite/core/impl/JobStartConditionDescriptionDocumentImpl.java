/*
 * An XML document type.
 * Localname: JobStartConditionDescription
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.JobStartConditionDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one JobStartConditionDescription(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class JobStartConditionDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.JobStartConditionDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public JobStartConditionDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName JOBSTARTCONDITIONDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobStartConditionDescription");
    
    
    /**
     * Gets the "JobStartConditionDescription" element
     */
    public java.lang.String getJobStartConditionDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBSTARTCONDITIONDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "JobStartConditionDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetJobStartConditionDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(JOBSTARTCONDITIONDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "JobStartConditionDescription" element
     */
    public void setJobStartConditionDescription(java.lang.String jobStartConditionDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBSTARTCONDITIONDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(JOBSTARTCONDITIONDESCRIPTION$0);
            }
            target.setStringValue(jobStartConditionDescription);
        }
    }
    
    /**
     * Sets (as xml) the "JobStartConditionDescription" element
     */
    public void xsetJobStartConditionDescription(org.erdc.cobie.cobielite.core.CobieTextSimpleType jobStartConditionDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(JOBSTARTCONDITIONDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(JOBSTARTCONDITIONDESCRIPTION$0);
            }
            target.set(jobStartConditionDescription);
        }
    }
}
