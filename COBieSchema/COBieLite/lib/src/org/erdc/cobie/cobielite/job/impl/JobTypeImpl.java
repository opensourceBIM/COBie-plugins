/*
 * XML Type:  JobType
 * Namespace: http://job.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.job.JobType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.job.impl;
/**
 * An XML JobType(@http://job.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class JobTypeImpl extends org.erdc.cobie.cobielite.core.impl.JobTypeImpl implements org.erdc.cobie.cobielite.job.JobType
{
    private static final long serialVersionUID = 1L;
    
    public JobTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName JOBCATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobCategory");
    private static final javax.xml.namespace.QName JOBSTATUS$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobStatus");
    private static final javax.xml.namespace.QName JOBDESCRIPTION$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobDescription");
    private static final javax.xml.namespace.QName JOBDURATION$6 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobDuration");
    private static final javax.xml.namespace.QName JOBSTARTDATE$8 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobStartDate");
    private static final javax.xml.namespace.QName JOBSTARTCONDITIONDESCRIPTION$10 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobStartConditionDescription");
    private static final javax.xml.namespace.QName JOBFREQUENCYVALUE$12 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobFrequencyValue");
    private static final javax.xml.namespace.QName JOBPRIORTASKID$14 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobPriorTaskID");
    private static final javax.xml.namespace.QName RESOURCES$16 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Resources");
    private static final javax.xml.namespace.QName JOBATTRIBUTES$18 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobAttributes");
    private static final javax.xml.namespace.QName JOBDOCUMENTS$20 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobDocuments");
    private static final javax.xml.namespace.QName JOBISSUES$22 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "JobIssues");
    
    
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
     * True if has "JobCategory" element
     */
    public boolean isSetJobCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(JOBCATEGORY$0) != 0;
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
    
    /**
     * Unsets the "JobCategory" element
     */
    public void unsetJobCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(JOBCATEGORY$0, 0);
        }
    }
    
    /**
     * Gets the "JobStatus" element
     */
    public java.lang.String getJobStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBSTATUS$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "JobStatus" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetJobStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(JOBSTATUS$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "JobStatus" element
     */
    public boolean isSetJobStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(JOBSTATUS$2) != 0;
        }
    }
    
    /**
     * Sets the "JobStatus" element
     */
    public void setJobStatus(java.lang.String jobStatus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBSTATUS$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(JOBSTATUS$2);
            }
            target.setStringValue(jobStatus);
        }
    }
    
    /**
     * Sets (as xml) the "JobStatus" element
     */
    public void xsetJobStatus(org.erdc.cobie.cobielite.core.CobieTextSimpleType jobStatus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(JOBSTATUS$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(JOBSTATUS$2);
            }
            target.set(jobStatus);
        }
    }
    
    /**
     * Unsets the "JobStatus" element
     */
    public void unsetJobStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(JOBSTATUS$2, 0);
        }
    }
    
    /**
     * Gets the "JobDescription" element
     */
    public java.lang.String getJobDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBDESCRIPTION$4, 0);
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
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(JOBDESCRIPTION$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "JobDescription" element
     */
    public boolean isSetJobDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(JOBDESCRIPTION$4) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBDESCRIPTION$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(JOBDESCRIPTION$4);
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
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(JOBDESCRIPTION$4, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(JOBDESCRIPTION$4);
            }
            target.set(jobDescription);
        }
    }
    
    /**
     * Unsets the "JobDescription" element
     */
    public void unsetJobDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(JOBDESCRIPTION$4, 0);
        }
    }
    
    /**
     * Gets the "JobDuration" element
     */
    public org.erdc.cobie.cobielite.core.IntegerValueType getJobDuration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IntegerValueType target = null;
            target = (org.erdc.cobie.cobielite.core.IntegerValueType)get_store().find_element_user(JOBDURATION$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "JobDuration" element
     */
    public boolean isSetJobDuration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(JOBDURATION$6) != 0;
        }
    }
    
    /**
     * Sets the "JobDuration" element
     */
    public void setJobDuration(org.erdc.cobie.cobielite.core.IntegerValueType jobDuration)
    {
        generatedSetterHelperImpl(jobDuration, JOBDURATION$6, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
            target = (org.erdc.cobie.cobielite.core.IntegerValueType)get_store().add_element_user(JOBDURATION$6);
            return target;
        }
    }
    
    /**
     * Unsets the "JobDuration" element
     */
    public void unsetJobDuration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(JOBDURATION$6, 0);
        }
    }
    
    /**
     * Gets the "JobStartDate" element
     */
    public java.util.Calendar getJobStartDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBSTARTDATE$8, 0);
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
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(JOBSTARTDATE$8, 0);
            return target;
        }
    }
    
    /**
     * True if has "JobStartDate" element
     */
    public boolean isSetJobStartDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(JOBSTARTDATE$8) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBSTARTDATE$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(JOBSTARTDATE$8);
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
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(JOBSTARTDATE$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDate)get_store().add_element_user(JOBSTARTDATE$8);
            }
            target.set(jobStartDate);
        }
    }
    
    /**
     * Unsets the "JobStartDate" element
     */
    public void unsetJobStartDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(JOBSTARTDATE$8, 0);
        }
    }
    
    /**
     * Gets the "JobStartConditionDescription" element
     */
    public java.lang.String getJobStartConditionDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBSTARTCONDITIONDESCRIPTION$10, 0);
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
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(JOBSTARTCONDITIONDESCRIPTION$10, 0);
            return target;
        }
    }
    
    /**
     * True if has "JobStartConditionDescription" element
     */
    public boolean isSetJobStartConditionDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(JOBSTARTCONDITIONDESCRIPTION$10) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBSTARTCONDITIONDESCRIPTION$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(JOBSTARTCONDITIONDESCRIPTION$10);
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
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(JOBSTARTCONDITIONDESCRIPTION$10, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(JOBSTARTCONDITIONDESCRIPTION$10);
            }
            target.set(jobStartConditionDescription);
        }
    }
    
    /**
     * Unsets the "JobStartConditionDescription" element
     */
    public void unsetJobStartConditionDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(JOBSTARTCONDITIONDESCRIPTION$10, 0);
        }
    }
    
    /**
     * Gets the "JobFrequencyValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getJobFrequencyValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(JOBFREQUENCYVALUE$12, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "JobFrequencyValue" element
     */
    public boolean isSetJobFrequencyValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(JOBFREQUENCYVALUE$12) != 0;
        }
    }
    
    /**
     * Sets the "JobFrequencyValue" element
     */
    public void setJobFrequencyValue(org.erdc.cobie.cobielite.core.DecimalValueType jobFrequencyValue)
    {
        generatedSetterHelperImpl(jobFrequencyValue, JOBFREQUENCYVALUE$12, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(JOBFREQUENCYVALUE$12);
            return target;
        }
    }
    
    /**
     * Unsets the "JobFrequencyValue" element
     */
    public void unsetJobFrequencyValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(JOBFREQUENCYVALUE$12, 0);
        }
    }
    
    /**
     * Gets the "JobPriorTaskID" element
     */
    public java.lang.String getJobPriorTaskID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBPRIORTASKID$14, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "JobPriorTaskID" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetJobPriorTaskID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(JOBPRIORTASKID$14, 0);
            return target;
        }
    }
    
    /**
     * True if has "JobPriorTaskID" element
     */
    public boolean isSetJobPriorTaskID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(JOBPRIORTASKID$14) != 0;
        }
    }
    
    /**
     * Sets the "JobPriorTaskID" element
     */
    public void setJobPriorTaskID(java.lang.String jobPriorTaskID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(JOBPRIORTASKID$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(JOBPRIORTASKID$14);
            }
            target.setStringValue(jobPriorTaskID);
        }
    }
    
    /**
     * Sets (as xml) the "JobPriorTaskID" element
     */
    public void xsetJobPriorTaskID(org.erdc.cobie.cobielite.core.CobieTextSimpleType jobPriorTaskID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(JOBPRIORTASKID$14, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(JOBPRIORTASKID$14);
            }
            target.set(jobPriorTaskID);
        }
    }
    
    /**
     * Unsets the "JobPriorTaskID" element
     */
    public void unsetJobPriorTaskID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(JOBPRIORTASKID$14, 0);
        }
    }
    
    /**
     * Gets the "Resources" element
     */
    public org.erdc.cobie.cobielite.core.ResourceCollectionType getResources()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ResourceCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ResourceCollectionType)get_store().find_element_user(RESOURCES$16, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Resources" element
     */
    public boolean isSetResources()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RESOURCES$16) != 0;
        }
    }
    
    /**
     * Sets the "Resources" element
     */
    public void setResources(org.erdc.cobie.cobielite.core.ResourceCollectionType resources)
    {
        generatedSetterHelperImpl(resources, RESOURCES$16, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Resources" element
     */
    public org.erdc.cobie.cobielite.core.ResourceCollectionType addNewResources()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ResourceCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ResourceCollectionType)get_store().add_element_user(RESOURCES$16);
            return target;
        }
    }
    
    /**
     * Unsets the "Resources" element
     */
    public void unsetResources()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RESOURCES$16, 0);
        }
    }
    
    /**
     * Gets the "JobAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getJobAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(JOBATTRIBUTES$18, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "JobAttributes" element
     */
    public boolean isSetJobAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(JOBATTRIBUTES$18) != 0;
        }
    }
    
    /**
     * Sets the "JobAttributes" element
     */
    public void setJobAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType jobAttributes)
    {
        generatedSetterHelperImpl(jobAttributes, JOBATTRIBUTES$18, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "JobAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewJobAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(JOBATTRIBUTES$18);
            return target;
        }
    }
    
    /**
     * Unsets the "JobAttributes" element
     */
    public void unsetJobAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(JOBATTRIBUTES$18, 0);
        }
    }
    
    /**
     * Gets the "JobDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getJobDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(JOBDOCUMENTS$20, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "JobDocuments" element
     */
    public boolean isSetJobDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(JOBDOCUMENTS$20) != 0;
        }
    }
    
    /**
     * Sets the "JobDocuments" element
     */
    public void setJobDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType jobDocuments)
    {
        generatedSetterHelperImpl(jobDocuments, JOBDOCUMENTS$20, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "JobDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewJobDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(JOBDOCUMENTS$20);
            return target;
        }
    }
    
    /**
     * Unsets the "JobDocuments" element
     */
    public void unsetJobDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(JOBDOCUMENTS$20, 0);
        }
    }
    
    /**
     * Gets the "JobIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getJobIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(JOBISSUES$22, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "JobIssues" element
     */
    public boolean isSetJobIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(JOBISSUES$22) != 0;
        }
    }
    
    /**
     * Sets the "JobIssues" element
     */
    public void setJobIssues(org.erdc.cobie.cobielite.core.IssueCollectionType jobIssues)
    {
        generatedSetterHelperImpl(jobIssues, JOBISSUES$22, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "JobIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewJobIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(JOBISSUES$22);
            return target;
        }
    }
    
    /**
     * Unsets the "JobIssues" element
     */
    public void unsetJobIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(JOBISSUES$22, 0);
        }
    }
}
