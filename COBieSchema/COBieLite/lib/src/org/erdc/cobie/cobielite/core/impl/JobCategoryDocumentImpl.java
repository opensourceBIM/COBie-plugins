/*
 * An XML document type.
 * Localname: JobCategory
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.JobCategoryDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one JobCategory(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class JobCategoryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.JobCategoryDocument
{
    private static final long serialVersionUID = 1L;
    
    public JobCategoryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName JOBCATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobCategory");
    
    
    /**
     * Gets the "JobCategory" element
     */
    public java.lang.String getJobCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBCATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "JobCategory" element
     */
    public org.erdc.cobie.cobielite.core.JobCategorySimpleType xgetJobCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.JobCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.JobCategorySimpleType)get_store().find_element_user(JOBCATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "JobCategory" element
     */
    public void setJobCategory(java.lang.String jobCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(JOBCATEGORY$0);
            }
            target.setStringValue(jobCategory);
        }
    }
    
    /**
     * Sets (as xml) the "JobCategory" element
     */
    public void xsetJobCategory(org.erdc.cobie.cobielite.core.JobCategorySimpleType jobCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.JobCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.JobCategorySimpleType)get_store().find_element_user(JOBCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.JobCategorySimpleType)get_store().add_element_user(JOBCATEGORY$0);
            }
            target.set(jobCategory);
        }
    }
}
