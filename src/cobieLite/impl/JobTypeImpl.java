/*
 * XML Type:  JobType
 * Namespace: cobieLite
 * Java type: cobieLite.JobType
 *
 * Automatically generated - do not modify.
 */
package cobieLite.impl;
/**
 * An XML JobType(@cobieLite).
 *
 * This is a complex type.
 */
public class JobTypeImpl extends cobieLite.impl.COBIEBaseTypeImpl implements cobieLite.JobType
{
    private static final long serialVersionUID = 1L;
    
    public JobTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CREATEDBY$0 = 
        new javax.xml.namespace.QName("", "CreatedBy");
    private static final javax.xml.namespace.QName CREATEDON$2 = 
        new javax.xml.namespace.QName("", "CreatedOn");
    private static final javax.xml.namespace.QName CATEGORY$4 = 
        new javax.xml.namespace.QName("", "Category");
    private static final javax.xml.namespace.QName STATUS$6 = 
        new javax.xml.namespace.QName("", "Status");
    private static final javax.xml.namespace.QName TYPENAME$8 = 
        new javax.xml.namespace.QName("", "TypeName");
    private static final javax.xml.namespace.QName DESCRIPTION$10 = 
        new javax.xml.namespace.QName("", "Description");
    private static final javax.xml.namespace.QName DURATION$12 = 
        new javax.xml.namespace.QName("", "Duration");
    private static final javax.xml.namespace.QName DURATIONUNIT$14 = 
        new javax.xml.namespace.QName("", "DurationUnit");
    private static final javax.xml.namespace.QName START$16 = 
        new javax.xml.namespace.QName("", "Start");
    private static final javax.xml.namespace.QName TASKSTARTUNIT$18 = 
        new javax.xml.namespace.QName("", "TaskStartUnit");
    private static final javax.xml.namespace.QName FREQUENCY$20 = 
        new javax.xml.namespace.QName("", "Frequency");
    private static final javax.xml.namespace.QName FREQUENCYUNIT$22 = 
        new javax.xml.namespace.QName("", "FrequencyUnit");
    private static final javax.xml.namespace.QName EXTSYSTEM$24 = 
        new javax.xml.namespace.QName("", "ExtSystem");
    private static final javax.xml.namespace.QName EXTOBJECT$26 = 
        new javax.xml.namespace.QName("", "ExtObject");
    private static final javax.xml.namespace.QName EXTIDENTIFIER$28 = 
        new javax.xml.namespace.QName("", "ExtIdentifier");
    private static final javax.xml.namespace.QName TASKNUMBER$30 = 
        new javax.xml.namespace.QName("", "TaskNumber");
    private static final javax.xml.namespace.QName PRIORS$32 = 
        new javax.xml.namespace.QName("", "Priors");
    private static final javax.xml.namespace.QName RESOURCENAMES$34 = 
        new javax.xml.namespace.QName("", "ResourceNames");
    
    
    /**
     * Gets the "CreatedBy" element
     */
    public java.lang.String getCreatedBy()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREATEDBY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "CreatedBy" element
     */
    public cobieLite.EmailAddressType xgetCreatedBy()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.EmailAddressType target = null;
            target = (cobieLite.EmailAddressType)get_store().find_element_user(CREATEDBY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CreatedBy" element
     */
    public void setCreatedBy(java.lang.String createdBy)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREATEDBY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CREATEDBY$0);
            }
            target.setStringValue(createdBy);
        }
    }
    
    /**
     * Sets (as xml) the "CreatedBy" element
     */
    public void xsetCreatedBy(cobieLite.EmailAddressType createdBy)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.EmailAddressType target = null;
            target = (cobieLite.EmailAddressType)get_store().find_element_user(CREATEDBY$0, 0);
            if (target == null)
            {
                target = (cobieLite.EmailAddressType)get_store().add_element_user(CREATEDBY$0);
            }
            target.set(createdBy);
        }
    }
    
    /**
     * Gets the "CreatedOn" element
     */
    public java.util.Calendar getCreatedOn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREATEDON$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "CreatedOn" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetCreatedOn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(CREATEDON$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CreatedOn" element
     */
    public void setCreatedOn(java.util.Calendar createdOn)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREATEDON$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CREATEDON$2);
            }
            target.setCalendarValue(createdOn);
        }
    }
    
    /**
     * Sets (as xml) the "CreatedOn" element
     */
    public void xsetCreatedOn(org.apache.xmlbeans.XmlDateTime createdOn)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(CREATEDON$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(CREATEDON$2);
            }
            target.set(createdOn);
        }
    }
    
    /**
     * Gets the "Category" element
     */
    public java.lang.String getCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Category" element
     */
    public org.apache.xmlbeans.XmlString xgetCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY$4, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Category" element
     */
    public void setCategory(java.lang.String category)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CATEGORY$4);
            }
            target.setStringValue(category);
        }
    }
    
    /**
     * Sets (as xml) the "Category" element
     */
    public void xsetCategory(org.apache.xmlbeans.XmlString category)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CATEGORY$4);
            }
            target.set(category);
        }
    }
    
    /**
     * Gets the "Status" element
     */
    public java.lang.String getStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STATUS$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Status" element
     */
    public org.apache.xmlbeans.XmlString xgetStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STATUS$6, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Status" element
     */
    public void setStatus(java.lang.String status)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STATUS$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(STATUS$6);
            }
            target.setStringValue(status);
        }
    }
    
    /**
     * Sets (as xml) the "Status" element
     */
    public void xsetStatus(org.apache.xmlbeans.XmlString status)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STATUS$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(STATUS$6);
            }
            target.set(status);
        }
    }
    
    /**
     * Gets the "TypeName" element
     */
    public java.lang.String getTypeName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPENAME$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "TypeName" element
     */
    public org.apache.xmlbeans.XmlString xgetTypeName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TYPENAME$8, 0);
            return target;
        }
    }
    
    /**
     * Sets the "TypeName" element
     */
    public void setTypeName(java.lang.String typeName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPENAME$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TYPENAME$8);
            }
            target.setStringValue(typeName);
        }
    }
    
    /**
     * Sets (as xml) the "TypeName" element
     */
    public void xsetTypeName(org.apache.xmlbeans.XmlString typeName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TYPENAME$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TYPENAME$8);
            }
            target.set(typeName);
        }
    }
    
    /**
     * Gets the "Description" element
     */
    public java.lang.String getDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Description" element
     */
    public org.apache.xmlbeans.XmlString xgetDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$10, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Description" element
     */
    public void setDescription(java.lang.String description)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DESCRIPTION$10);
            }
            target.setStringValue(description);
        }
    }
    
    /**
     * Sets (as xml) the "Description" element
     */
    public void xsetDescription(org.apache.xmlbeans.XmlString description)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DESCRIPTION$10);
            }
            target.set(description);
        }
    }
    
    /**
     * Gets the "Duration" element
     */
    public java.lang.String getDuration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DURATION$12, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Duration" element
     */
    public org.apache.xmlbeans.XmlString xgetDuration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DURATION$12, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Duration" element
     */
    public void setDuration(java.lang.String duration)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DURATION$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DURATION$12);
            }
            target.setStringValue(duration);
        }
    }
    
    /**
     * Sets (as xml) the "Duration" element
     */
    public void xsetDuration(org.apache.xmlbeans.XmlString duration)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DURATION$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DURATION$12);
            }
            target.set(duration);
        }
    }
    
    /**
     * Gets the "DurationUnit" element
     */
    public java.lang.String getDurationUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DURATIONUNIT$14, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "DurationUnit" element
     */
    public org.apache.xmlbeans.XmlString xgetDurationUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DURATIONUNIT$14, 0);
            return target;
        }
    }
    
    /**
     * Sets the "DurationUnit" element
     */
    public void setDurationUnit(java.lang.String durationUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DURATIONUNIT$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DURATIONUNIT$14);
            }
            target.setStringValue(durationUnit);
        }
    }
    
    /**
     * Sets (as xml) the "DurationUnit" element
     */
    public void xsetDurationUnit(org.apache.xmlbeans.XmlString durationUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DURATIONUNIT$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DURATIONUNIT$14);
            }
            target.set(durationUnit);
        }
    }
    
    /**
     * Gets the "Start" element
     */
    public java.lang.String getStart()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(START$16, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Start" element
     */
    public org.apache.xmlbeans.XmlString xgetStart()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(START$16, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Start" element
     */
    public void setStart(java.lang.String start)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(START$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(START$16);
            }
            target.setStringValue(start);
        }
    }
    
    /**
     * Sets (as xml) the "Start" element
     */
    public void xsetStart(org.apache.xmlbeans.XmlString start)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(START$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(START$16);
            }
            target.set(start);
        }
    }
    
    /**
     * Gets the "TaskStartUnit" element
     */
    public java.lang.String getTaskStartUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TASKSTARTUNIT$18, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "TaskStartUnit" element
     */
    public org.apache.xmlbeans.XmlString xgetTaskStartUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TASKSTARTUNIT$18, 0);
            return target;
        }
    }
    
    /**
     * Sets the "TaskStartUnit" element
     */
    public void setTaskStartUnit(java.lang.String taskStartUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TASKSTARTUNIT$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TASKSTARTUNIT$18);
            }
            target.setStringValue(taskStartUnit);
        }
    }
    
    /**
     * Sets (as xml) the "TaskStartUnit" element
     */
    public void xsetTaskStartUnit(org.apache.xmlbeans.XmlString taskStartUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TASKSTARTUNIT$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TASKSTARTUNIT$18);
            }
            target.set(taskStartUnit);
        }
    }
    
    /**
     * Gets the "Frequency" element
     */
    public java.lang.String getFrequency()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FREQUENCY$20, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Frequency" element
     */
    public org.apache.xmlbeans.XmlString xgetFrequency()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FREQUENCY$20, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Frequency" element
     */
    public void setFrequency(java.lang.String frequency)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FREQUENCY$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FREQUENCY$20);
            }
            target.setStringValue(frequency);
        }
    }
    
    /**
     * Sets (as xml) the "Frequency" element
     */
    public void xsetFrequency(org.apache.xmlbeans.XmlString frequency)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FREQUENCY$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FREQUENCY$20);
            }
            target.set(frequency);
        }
    }
    
    /**
     * Gets the "FrequencyUnit" element
     */
    public java.lang.String getFrequencyUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FREQUENCYUNIT$22, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FrequencyUnit" element
     */
    public org.apache.xmlbeans.XmlString xgetFrequencyUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FREQUENCYUNIT$22, 0);
            return target;
        }
    }
    
    /**
     * Sets the "FrequencyUnit" element
     */
    public void setFrequencyUnit(java.lang.String frequencyUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FREQUENCYUNIT$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FREQUENCYUNIT$22);
            }
            target.setStringValue(frequencyUnit);
        }
    }
    
    /**
     * Sets (as xml) the "FrequencyUnit" element
     */
    public void xsetFrequencyUnit(org.apache.xmlbeans.XmlString frequencyUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FREQUENCYUNIT$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FREQUENCYUNIT$22);
            }
            target.set(frequencyUnit);
        }
    }
    
    /**
     * Gets the "ExtSystem" element
     */
    public java.lang.String getExtSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTSYSTEM$24, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ExtSystem" element
     */
    public org.apache.xmlbeans.XmlString xgetExtSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTSYSTEM$24, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ExtSystem" element
     */
    public void setExtSystem(java.lang.String extSystem)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTSYSTEM$24, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTSYSTEM$24);
            }
            target.setStringValue(extSystem);
        }
    }
    
    /**
     * Sets (as xml) the "ExtSystem" element
     */
    public void xsetExtSystem(org.apache.xmlbeans.XmlString extSystem)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTSYSTEM$24, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTSYSTEM$24);
            }
            target.set(extSystem);
        }
    }
    
    /**
     * Gets the "ExtObject" element
     */
    public java.lang.String getExtObject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTOBJECT$26, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ExtObject" element
     */
    public org.apache.xmlbeans.XmlString xgetExtObject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTOBJECT$26, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ExtObject" element
     */
    public void setExtObject(java.lang.String extObject)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTOBJECT$26, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTOBJECT$26);
            }
            target.setStringValue(extObject);
        }
    }
    
    /**
     * Sets (as xml) the "ExtObject" element
     */
    public void xsetExtObject(org.apache.xmlbeans.XmlString extObject)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTOBJECT$26, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTOBJECT$26);
            }
            target.set(extObject);
        }
    }
    
    /**
     * Gets the "ExtIdentifier" element
     */
    public java.lang.String getExtIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTIDENTIFIER$28, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ExtIdentifier" element
     */
    public org.apache.xmlbeans.XmlString xgetExtIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTIDENTIFIER$28, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ExtIdentifier" element
     */
    public void setExtIdentifier(java.lang.String extIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTIDENTIFIER$28, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTIDENTIFIER$28);
            }
            target.setStringValue(extIdentifier);
        }
    }
    
    /**
     * Sets (as xml) the "ExtIdentifier" element
     */
    public void xsetExtIdentifier(org.apache.xmlbeans.XmlString extIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTIDENTIFIER$28, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTIDENTIFIER$28);
            }
            target.set(extIdentifier);
        }
    }
    
    /**
     * Gets the "TaskNumber" element
     */
    public java.lang.String getTaskNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TASKNUMBER$30, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "TaskNumber" element
     */
    public org.apache.xmlbeans.XmlString xgetTaskNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TASKNUMBER$30, 0);
            return target;
        }
    }
    
    /**
     * Sets the "TaskNumber" element
     */
    public void setTaskNumber(java.lang.String taskNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TASKNUMBER$30, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TASKNUMBER$30);
            }
            target.setStringValue(taskNumber);
        }
    }
    
    /**
     * Sets (as xml) the "TaskNumber" element
     */
    public void xsetTaskNumber(org.apache.xmlbeans.XmlString taskNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TASKNUMBER$30, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TASKNUMBER$30);
            }
            target.set(taskNumber);
        }
    }
    
    /**
     * Gets the "Priors" element
     */
    public java.lang.String getPriors()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PRIORS$32, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Priors" element
     */
    public org.apache.xmlbeans.XmlString xgetPriors()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PRIORS$32, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Priors" element
     */
    public void setPriors(java.lang.String priors)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PRIORS$32, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PRIORS$32);
            }
            target.setStringValue(priors);
        }
    }
    
    /**
     * Sets (as xml) the "Priors" element
     */
    public void xsetPriors(org.apache.xmlbeans.XmlString priors)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PRIORS$32, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PRIORS$32);
            }
            target.set(priors);
        }
    }
    
    /**
     * Gets the "ResourceNames" element
     */
    public java.lang.String getResourceNames()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESOURCENAMES$34, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ResourceNames" element
     */
    public org.apache.xmlbeans.XmlString xgetResourceNames()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RESOURCENAMES$34, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ResourceNames" element
     */
    public void setResourceNames(java.lang.String resourceNames)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESOURCENAMES$34, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RESOURCENAMES$34);
            }
            target.setStringValue(resourceNames);
        }
    }
    
    /**
     * Sets (as xml) the "ResourceNames" element
     */
    public void xsetResourceNames(org.apache.xmlbeans.XmlString resourceNames)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RESOURCENAMES$34, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(RESOURCENAMES$34);
            }
            target.set(resourceNames);
        }
    }
}
