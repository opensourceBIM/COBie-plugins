/*
 * XML Type:  FacilityType
 * Namespace: cobieLite
 * Java type: cobieLite.FacilityType
 *
 * Automatically generated - do not modify.
 */
package cobieLite.impl;
/**
 * An XML FacilityType(@cobieLite).
 *
 * This is a complex type.
 */
public class FacilityTypeImpl extends cobieLite.impl.COBIEBaseTypeImpl implements cobieLite.FacilityType
{
    private static final long serialVersionUID = 1L;
    
    public FacilityTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CREATEDBY$0 = 
        new javax.xml.namespace.QName("", "CreatedBy");
    private static final javax.xml.namespace.QName CREATEDON$2 = 
        new javax.xml.namespace.QName("", "CreatedOn");
    private static final javax.xml.namespace.QName CATEGORY$4 = 
        new javax.xml.namespace.QName("", "Category");
    private static final javax.xml.namespace.QName PROJECTNAME$6 = 
        new javax.xml.namespace.QName("", "ProjectName");
    private static final javax.xml.namespace.QName SITENAME$8 = 
        new javax.xml.namespace.QName("", "SiteName");
    private static final javax.xml.namespace.QName LINEARUNITS$10 = 
        new javax.xml.namespace.QName("", "LinearUnits");
    private static final javax.xml.namespace.QName AREAUNITS$12 = 
        new javax.xml.namespace.QName("", "AreaUnits");
    private static final javax.xml.namespace.QName VOLUMEUNITS$14 = 
        new javax.xml.namespace.QName("", "VolumeUnits");
    private static final javax.xml.namespace.QName CURRENCYUNITS$16 = 
        new javax.xml.namespace.QName("", "CurrencyUnits");
    private static final javax.xml.namespace.QName AREAMEASUREMENT$18 = 
        new javax.xml.namespace.QName("", "AreaMeasurement");
    private static final javax.xml.namespace.QName EXTERNALSYSTEM$20 = 
        new javax.xml.namespace.QName("", "ExternalSystem");
    private static final javax.xml.namespace.QName EXTERNALPROJECTOBJECT$22 = 
        new javax.xml.namespace.QName("", "ExternalProjectObject");
    private static final javax.xml.namespace.QName EXTERNALPROJECTIDENTIFIER$24 = 
        new javax.xml.namespace.QName("", "ExternalProjectIdentifier");
    private static final javax.xml.namespace.QName EXTERNALSITEOBJECT$26 = 
        new javax.xml.namespace.QName("", "ExternalSiteObject");
    private static final javax.xml.namespace.QName EXTERNALSITEIDENTIFIER$28 = 
        new javax.xml.namespace.QName("", "ExternalSiteIdentifier");
    private static final javax.xml.namespace.QName EXTERNALFACILITYOBJECT$30 = 
        new javax.xml.namespace.QName("", "ExternalFacilityObject");
    private static final javax.xml.namespace.QName EXTERNALFACILITYIDENTIFIER$32 = 
        new javax.xml.namespace.QName("", "ExternalFacilityIdentifier");
    private static final javax.xml.namespace.QName DESCRIPTION$34 = 
        new javax.xml.namespace.QName("", "Description");
    private static final javax.xml.namespace.QName PROJECTDESCRIPTION$36 = 
        new javax.xml.namespace.QName("", "ProjectDescription");
    private static final javax.xml.namespace.QName SITEDESCRIPTION$38 = 
        new javax.xml.namespace.QName("", "SiteDescription");
    private static final javax.xml.namespace.QName PHASE$40 = 
        new javax.xml.namespace.QName("", "Phase");
    
    
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
     * Gets the "ProjectName" element
     */
    public java.lang.String getProjectName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROJECTNAME$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ProjectName" element
     */
    public org.apache.xmlbeans.XmlString xgetProjectName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROJECTNAME$6, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ProjectName" element
     */
    public void setProjectName(java.lang.String projectName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROJECTNAME$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROJECTNAME$6);
            }
            target.setStringValue(projectName);
        }
    }
    
    /**
     * Sets (as xml) the "ProjectName" element
     */
    public void xsetProjectName(org.apache.xmlbeans.XmlString projectName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROJECTNAME$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROJECTNAME$6);
            }
            target.set(projectName);
        }
    }
    
    /**
     * Gets the "SiteName" element
     */
    public java.lang.String getSiteName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SITENAME$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SiteName" element
     */
    public org.apache.xmlbeans.XmlString xgetSiteName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SITENAME$8, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SiteName" element
     */
    public void setSiteName(java.lang.String siteName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SITENAME$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SITENAME$8);
            }
            target.setStringValue(siteName);
        }
    }
    
    /**
     * Sets (as xml) the "SiteName" element
     */
    public void xsetSiteName(org.apache.xmlbeans.XmlString siteName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SITENAME$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SITENAME$8);
            }
            target.set(siteName);
        }
    }
    
    /**
     * Gets the "LinearUnits" element
     */
    public java.lang.String getLinearUnits()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LINEARUNITS$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "LinearUnits" element
     */
    public org.apache.xmlbeans.XmlString xgetLinearUnits()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LINEARUNITS$10, 0);
            return target;
        }
    }
    
    /**
     * Sets the "LinearUnits" element
     */
    public void setLinearUnits(java.lang.String linearUnits)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LINEARUNITS$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LINEARUNITS$10);
            }
            target.setStringValue(linearUnits);
        }
    }
    
    /**
     * Sets (as xml) the "LinearUnits" element
     */
    public void xsetLinearUnits(org.apache.xmlbeans.XmlString linearUnits)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LINEARUNITS$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(LINEARUNITS$10);
            }
            target.set(linearUnits);
        }
    }
    
    /**
     * Gets the "AreaUnits" element
     */
    public java.lang.String getAreaUnits()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AREAUNITS$12, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AreaUnits" element
     */
    public org.apache.xmlbeans.XmlString xgetAreaUnits()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AREAUNITS$12, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AreaUnits" element
     */
    public void setAreaUnits(java.lang.String areaUnits)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AREAUNITS$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AREAUNITS$12);
            }
            target.setStringValue(areaUnits);
        }
    }
    
    /**
     * Sets (as xml) the "AreaUnits" element
     */
    public void xsetAreaUnits(org.apache.xmlbeans.XmlString areaUnits)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AREAUNITS$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(AREAUNITS$12);
            }
            target.set(areaUnits);
        }
    }
    
    /**
     * Gets the "VolumeUnits" element
     */
    public java.lang.String getVolumeUnits()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VOLUMEUNITS$14, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "VolumeUnits" element
     */
    public org.apache.xmlbeans.XmlString xgetVolumeUnits()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(VOLUMEUNITS$14, 0);
            return target;
        }
    }
    
    /**
     * Sets the "VolumeUnits" element
     */
    public void setVolumeUnits(java.lang.String volumeUnits)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VOLUMEUNITS$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(VOLUMEUNITS$14);
            }
            target.setStringValue(volumeUnits);
        }
    }
    
    /**
     * Sets (as xml) the "VolumeUnits" element
     */
    public void xsetVolumeUnits(org.apache.xmlbeans.XmlString volumeUnits)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(VOLUMEUNITS$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(VOLUMEUNITS$14);
            }
            target.set(volumeUnits);
        }
    }
    
    /**
     * Gets the "CurrencyUnits" element
     */
    public java.lang.String getCurrencyUnits()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CURRENCYUNITS$16, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "CurrencyUnits" element
     */
    public org.apache.xmlbeans.XmlString xgetCurrencyUnits()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CURRENCYUNITS$16, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CurrencyUnits" element
     */
    public void setCurrencyUnits(java.lang.String currencyUnits)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CURRENCYUNITS$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CURRENCYUNITS$16);
            }
            target.setStringValue(currencyUnits);
        }
    }
    
    /**
     * Sets (as xml) the "CurrencyUnits" element
     */
    public void xsetCurrencyUnits(org.apache.xmlbeans.XmlString currencyUnits)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CURRENCYUNITS$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CURRENCYUNITS$16);
            }
            target.set(currencyUnits);
        }
    }
    
    /**
     * Gets the "AreaMeasurement" element
     */
    public java.lang.String getAreaMeasurement()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AREAMEASUREMENT$18, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AreaMeasurement" element
     */
    public org.apache.xmlbeans.XmlString xgetAreaMeasurement()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AREAMEASUREMENT$18, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AreaMeasurement" element
     */
    public void setAreaMeasurement(java.lang.String areaMeasurement)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AREAMEASUREMENT$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AREAMEASUREMENT$18);
            }
            target.setStringValue(areaMeasurement);
        }
    }
    
    /**
     * Sets (as xml) the "AreaMeasurement" element
     */
    public void xsetAreaMeasurement(org.apache.xmlbeans.XmlString areaMeasurement)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AREAMEASUREMENT$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(AREAMEASUREMENT$18);
            }
            target.set(areaMeasurement);
        }
    }
    
    /**
     * Gets the "ExternalSystem" element
     */
    public java.lang.String getExternalSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALSYSTEM$20, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ExternalSystem" element
     */
    public org.apache.xmlbeans.XmlString xgetExternalSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALSYSTEM$20, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ExternalSystem" element
     */
    public void setExternalSystem(java.lang.String externalSystem)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALSYSTEM$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTERNALSYSTEM$20);
            }
            target.setStringValue(externalSystem);
        }
    }
    
    /**
     * Sets (as xml) the "ExternalSystem" element
     */
    public void xsetExternalSystem(org.apache.xmlbeans.XmlString externalSystem)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALSYSTEM$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTERNALSYSTEM$20);
            }
            target.set(externalSystem);
        }
    }
    
    /**
     * Gets the "ExternalProjectObject" element
     */
    public java.lang.String getExternalProjectObject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALPROJECTOBJECT$22, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ExternalProjectObject" element
     */
    public org.apache.xmlbeans.XmlString xgetExternalProjectObject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALPROJECTOBJECT$22, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ExternalProjectObject" element
     */
    public void setExternalProjectObject(java.lang.String externalProjectObject)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALPROJECTOBJECT$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTERNALPROJECTOBJECT$22);
            }
            target.setStringValue(externalProjectObject);
        }
    }
    
    /**
     * Sets (as xml) the "ExternalProjectObject" element
     */
    public void xsetExternalProjectObject(org.apache.xmlbeans.XmlString externalProjectObject)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALPROJECTOBJECT$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTERNALPROJECTOBJECT$22);
            }
            target.set(externalProjectObject);
        }
    }
    
    /**
     * Gets the "ExternalProjectIdentifier" element
     */
    public java.lang.String getExternalProjectIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALPROJECTIDENTIFIER$24, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ExternalProjectIdentifier" element
     */
    public org.apache.xmlbeans.XmlString xgetExternalProjectIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALPROJECTIDENTIFIER$24, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ExternalProjectIdentifier" element
     */
    public void setExternalProjectIdentifier(java.lang.String externalProjectIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALPROJECTIDENTIFIER$24, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTERNALPROJECTIDENTIFIER$24);
            }
            target.setStringValue(externalProjectIdentifier);
        }
    }
    
    /**
     * Sets (as xml) the "ExternalProjectIdentifier" element
     */
    public void xsetExternalProjectIdentifier(org.apache.xmlbeans.XmlString externalProjectIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALPROJECTIDENTIFIER$24, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTERNALPROJECTIDENTIFIER$24);
            }
            target.set(externalProjectIdentifier);
        }
    }
    
    /**
     * Gets the "ExternalSiteObject" element
     */
    public java.lang.String getExternalSiteObject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALSITEOBJECT$26, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ExternalSiteObject" element
     */
    public org.apache.xmlbeans.XmlString xgetExternalSiteObject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALSITEOBJECT$26, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ExternalSiteObject" element
     */
    public void setExternalSiteObject(java.lang.String externalSiteObject)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALSITEOBJECT$26, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTERNALSITEOBJECT$26);
            }
            target.setStringValue(externalSiteObject);
        }
    }
    
    /**
     * Sets (as xml) the "ExternalSiteObject" element
     */
    public void xsetExternalSiteObject(org.apache.xmlbeans.XmlString externalSiteObject)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALSITEOBJECT$26, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTERNALSITEOBJECT$26);
            }
            target.set(externalSiteObject);
        }
    }
    
    /**
     * Gets the "ExternalSiteIdentifier" element
     */
    public java.lang.String getExternalSiteIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALSITEIDENTIFIER$28, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ExternalSiteIdentifier" element
     */
    public org.apache.xmlbeans.XmlString xgetExternalSiteIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALSITEIDENTIFIER$28, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ExternalSiteIdentifier" element
     */
    public void setExternalSiteIdentifier(java.lang.String externalSiteIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALSITEIDENTIFIER$28, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTERNALSITEIDENTIFIER$28);
            }
            target.setStringValue(externalSiteIdentifier);
        }
    }
    
    /**
     * Sets (as xml) the "ExternalSiteIdentifier" element
     */
    public void xsetExternalSiteIdentifier(org.apache.xmlbeans.XmlString externalSiteIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALSITEIDENTIFIER$28, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTERNALSITEIDENTIFIER$28);
            }
            target.set(externalSiteIdentifier);
        }
    }
    
    /**
     * Gets the "ExternalFacilityObject" element
     */
    public java.lang.String getExternalFacilityObject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALFACILITYOBJECT$30, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ExternalFacilityObject" element
     */
    public org.apache.xmlbeans.XmlString xgetExternalFacilityObject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALFACILITYOBJECT$30, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ExternalFacilityObject" element
     */
    public void setExternalFacilityObject(java.lang.String externalFacilityObject)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALFACILITYOBJECT$30, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTERNALFACILITYOBJECT$30);
            }
            target.setStringValue(externalFacilityObject);
        }
    }
    
    /**
     * Sets (as xml) the "ExternalFacilityObject" element
     */
    public void xsetExternalFacilityObject(org.apache.xmlbeans.XmlString externalFacilityObject)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALFACILITYOBJECT$30, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTERNALFACILITYOBJECT$30);
            }
            target.set(externalFacilityObject);
        }
    }
    
    /**
     * Gets the "ExternalFacilityIdentifier" element
     */
    public java.lang.String getExternalFacilityIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALFACILITYIDENTIFIER$32, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ExternalFacilityIdentifier" element
     */
    public org.apache.xmlbeans.XmlString xgetExternalFacilityIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALFACILITYIDENTIFIER$32, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ExternalFacilityIdentifier" element
     */
    public void setExternalFacilityIdentifier(java.lang.String externalFacilityIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALFACILITYIDENTIFIER$32, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTERNALFACILITYIDENTIFIER$32);
            }
            target.setStringValue(externalFacilityIdentifier);
        }
    }
    
    /**
     * Sets (as xml) the "ExternalFacilityIdentifier" element
     */
    public void xsetExternalFacilityIdentifier(org.apache.xmlbeans.XmlString externalFacilityIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALFACILITYIDENTIFIER$32, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTERNALFACILITYIDENTIFIER$32);
            }
            target.set(externalFacilityIdentifier);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$34, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$34, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$34, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DESCRIPTION$34);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$34, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DESCRIPTION$34);
            }
            target.set(description);
        }
    }
    
    /**
     * Gets the "ProjectDescription" element
     */
    public java.lang.String getProjectDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROJECTDESCRIPTION$36, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ProjectDescription" element
     */
    public org.apache.xmlbeans.XmlString xgetProjectDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROJECTDESCRIPTION$36, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ProjectDescription" element
     */
    public void setProjectDescription(java.lang.String projectDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROJECTDESCRIPTION$36, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROJECTDESCRIPTION$36);
            }
            target.setStringValue(projectDescription);
        }
    }
    
    /**
     * Sets (as xml) the "ProjectDescription" element
     */
    public void xsetProjectDescription(org.apache.xmlbeans.XmlString projectDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROJECTDESCRIPTION$36, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROJECTDESCRIPTION$36);
            }
            target.set(projectDescription);
        }
    }
    
    /**
     * Gets the "SiteDescription" element
     */
    public java.lang.String getSiteDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SITEDESCRIPTION$38, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SiteDescription" element
     */
    public org.apache.xmlbeans.XmlString xgetSiteDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SITEDESCRIPTION$38, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SiteDescription" element
     */
    public void setSiteDescription(java.lang.String siteDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SITEDESCRIPTION$38, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SITEDESCRIPTION$38);
            }
            target.setStringValue(siteDescription);
        }
    }
    
    /**
     * Sets (as xml) the "SiteDescription" element
     */
    public void xsetSiteDescription(org.apache.xmlbeans.XmlString siteDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SITEDESCRIPTION$38, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SITEDESCRIPTION$38);
            }
            target.set(siteDescription);
        }
    }
    
    /**
     * Gets the "Phase" element
     */
    public java.lang.String getPhase()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PHASE$40, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Phase" element
     */
    public org.apache.xmlbeans.XmlString xgetPhase()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PHASE$40, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Phase" element
     */
    public void setPhase(java.lang.String phase)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PHASE$40, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PHASE$40);
            }
            target.setStringValue(phase);
        }
    }
    
    /**
     * Sets (as xml) the "Phase" element
     */
    public void xsetPhase(org.apache.xmlbeans.XmlString phase)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PHASE$40, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PHASE$40);
            }
            target.set(phase);
        }
    }
}
