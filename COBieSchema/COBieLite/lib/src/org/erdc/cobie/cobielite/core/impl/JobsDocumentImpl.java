/*
 * An XML document type.
 * Localname: Jobs
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.JobsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Jobs(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class JobsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.JobsDocument
{
    private static final long serialVersionUID = 1L;
    
    public JobsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName JOBS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Jobs");
    
    
    /**
     * Gets the "Jobs" element
     */
    public org.erdc.cobie.cobielite.core.JobCollectionType getJobs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.JobCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.JobCollectionType)get_store().find_element_user(JOBS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Jobs" element
     */
    public void setJobs(org.erdc.cobie.cobielite.core.JobCollectionType jobs)
    {
        generatedSetterHelperImpl(jobs, JOBS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Jobs" element
     */
    public org.erdc.cobie.cobielite.core.JobCollectionType addNewJobs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.JobCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.JobCollectionType)get_store().add_element_user(JOBS$0);
            return target;
        }
    }
}
