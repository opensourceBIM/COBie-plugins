/*
 * An XML document type.
 * Localname: JobDuration
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.JobDurationDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one JobDuration(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class JobDurationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.JobDurationDocument
{
    private static final long serialVersionUID = 1L;
    
    public JobDurationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName JOBDURATION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobDuration");
    
    
    /**
     * Gets the "JobDuration" element
     */
    public org.erdc.cobie.cobielite.core.IntegerValueType getJobDuration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IntegerValueType target = null;
            target = (org.erdc.cobie.cobielite.core.IntegerValueType)get_store().find_element_user(JOBDURATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "JobDuration" element
     */
    public void setJobDuration(org.erdc.cobie.cobielite.core.IntegerValueType jobDuration)
    {
        generatedSetterHelperImpl(jobDuration, JOBDURATION$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "JobDuration" element
     */
    public org.erdc.cobie.cobielite.core.IntegerValueType addNewJobDuration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IntegerValueType target = null;
            target = (org.erdc.cobie.cobielite.core.IntegerValueType)get_store().add_element_user(JOBDURATION$0);
            return target;
        }
    }
}
