/*
 * An XML document type.
 * Localname: JobFrequencyValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.JobFrequencyValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one JobFrequencyValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class JobFrequencyValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.JobFrequencyValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public JobFrequencyValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName JOBFREQUENCYVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobFrequencyValue");
    
    
    /**
     * Gets the "JobFrequencyValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getJobFrequencyValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(JOBFREQUENCYVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "JobFrequencyValue" element
     */
    public void setJobFrequencyValue(org.erdc.cobie.cobielite.core.DecimalValueType jobFrequencyValue)
    {
        generatedSetterHelperImpl(jobFrequencyValue, JOBFREQUENCYVALUE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "JobFrequencyValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType addNewJobFrequencyValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(JOBFREQUENCYVALUE$0);
            return target;
        }
    }
}
