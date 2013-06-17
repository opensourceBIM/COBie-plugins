/*
 * XML Type:  FacilityType
 * Namespace: http://facility.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.facility.FacilityType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.facility.impl;
/**
 * An XML FacilityType(@http://facility.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class FacilityTypeImpl extends org.erdc.cobie.cobielite.core.impl.FacilityTypeImpl implements org.erdc.cobie.cobielite.facility.FacilityType
{
    private static final long serialVersionUID = 1L;
    
    public FacilityTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FACILITYCATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityCategory");
    private static final javax.xml.namespace.QName PROJECTASSIGNMENT$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ProjectAssignment");
    private static final javax.xml.namespace.QName SITEASSIGNMENT$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SiteAssignment");
    private static final javax.xml.namespace.QName FACILITYDEFAULTLINEARUNIT$6 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityDefaultLinearUnit");
    private static final javax.xml.namespace.QName FACILITYDEFAULTAREAUNIT$8 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityDefaultAreaUnit");
    private static final javax.xml.namespace.QName FACILITYDEFAULTVOLUMEUNIT$10 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityDefaultVolumeUnit");
    private static final javax.xml.namespace.QName FACILITYDEFAULTCURRENCYUNIT$12 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityDefaultCurrencyUnit");
    private static final javax.xml.namespace.QName FACILITYDEFAULTMEASUREMENTSTANDARD$14 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityDefaultMeasurementStandard");
    private static final javax.xml.namespace.QName FACILITYDESCRIPTION$16 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityDescription");
    private static final javax.xml.namespace.QName FACILITYDELIVERABLEPHASENAME$18 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityDeliverablePhaseName");
    private static final javax.xml.namespace.QName FLOORS$20 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Floors");
    private static final javax.xml.namespace.QName ZONES$22 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Zones");
    private static final javax.xml.namespace.QName ASSETTYPES$24 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypes");
    private static final javax.xml.namespace.QName SYSTEMS$26 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Systems");
    private static final javax.xml.namespace.QName CONNECTIONS$28 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Connections");
    private static final javax.xml.namespace.QName CONTACTS$30 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Contacts");
    private static final javax.xml.namespace.QName FACILITYATTRIBUTES$32 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityAttributes");
    private static final javax.xml.namespace.QName FACILITYDOCUMENTS$34 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityDocuments");
    private static final javax.xml.namespace.QName FACILITYISSUES$36 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityIssues");
    
    
    /**
     * Gets the "FacilityCategory" element
     */
    public java.lang.String getFacilityCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYCATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FacilityCategory" element
     */
    public org.erdc.cobie.cobielite.core.FacilityCategorySimpleType xgetFacilityCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FacilityCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.FacilityCategorySimpleType)get_store().find_element_user(FACILITYCATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "FacilityCategory" element
     */
    public boolean isSetFacilityCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FACILITYCATEGORY$0) != 0;
        }
    }
    
    /**
     * Sets the "FacilityCategory" element
     */
    public void setFacilityCategory(java.lang.String facilityCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FACILITYCATEGORY$0);
            }
            target.setStringValue(facilityCategory);
        }
    }
    
    /**
     * Sets (as xml) the "FacilityCategory" element
     */
    public void xsetFacilityCategory(org.erdc.cobie.cobielite.core.FacilityCategorySimpleType facilityCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FacilityCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.FacilityCategorySimpleType)get_store().find_element_user(FACILITYCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.FacilityCategorySimpleType)get_store().add_element_user(FACILITYCATEGORY$0);
            }
            target.set(facilityCategory);
        }
    }
    
    /**
     * Unsets the "FacilityCategory" element
     */
    public void unsetFacilityCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FACILITYCATEGORY$0, 0);
        }
    }
    
    /**
     * Gets the "ProjectAssignment" element
     */
    public org.erdc.cobie.cobielite.core.ProjectType getProjectAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ProjectType target = null;
            target = (org.erdc.cobie.cobielite.core.ProjectType)get_store().find_element_user(PROJECTASSIGNMENT$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ProjectAssignment" element
     */
    public boolean isSetProjectAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PROJECTASSIGNMENT$2) != 0;
        }
    }
    
    /**
     * Sets the "ProjectAssignment" element
     */
    public void setProjectAssignment(org.erdc.cobie.cobielite.core.ProjectType projectAssignment)
    {
        generatedSetterHelperImpl(projectAssignment, PROJECTASSIGNMENT$2, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ProjectAssignment" element
     */
    public org.erdc.cobie.cobielite.core.ProjectType addNewProjectAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ProjectType target = null;
            target = (org.erdc.cobie.cobielite.core.ProjectType)get_store().add_element_user(PROJECTASSIGNMENT$2);
            return target;
        }
    }
    
    /**
     * Unsets the "ProjectAssignment" element
     */
    public void unsetProjectAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PROJECTASSIGNMENT$2, 0);
        }
    }
    
    /**
     * Gets the "SiteAssignment" element
     */
    public org.erdc.cobie.cobielite.core.SiteType getSiteAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SiteType target = null;
            target = (org.erdc.cobie.cobielite.core.SiteType)get_store().find_element_user(SITEASSIGNMENT$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "SiteAssignment" element
     */
    public boolean isSetSiteAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SITEASSIGNMENT$4) != 0;
        }
    }
    
    /**
     * Sets the "SiteAssignment" element
     */
    public void setSiteAssignment(org.erdc.cobie.cobielite.core.SiteType siteAssignment)
    {
        generatedSetterHelperImpl(siteAssignment, SITEASSIGNMENT$4, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SiteAssignment" element
     */
    public org.erdc.cobie.cobielite.core.SiteType addNewSiteAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SiteType target = null;
            target = (org.erdc.cobie.cobielite.core.SiteType)get_store().add_element_user(SITEASSIGNMENT$4);
            return target;
        }
    }
    
    /**
     * Unsets the "SiteAssignment" element
     */
    public void unsetSiteAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SITEASSIGNMENT$4, 0);
        }
    }
    
    /**
     * Gets the "FacilityDefaultLinearUnit" element
     */
    public org.erdc.cobie.cobielite.core.LinearUnitSimpleType.Enum getFacilityDefaultLinearUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTLINEARUNIT$6, 0);
            if (target == null)
            {
                return null;
            }
            return (org.erdc.cobie.cobielite.core.LinearUnitSimpleType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "FacilityDefaultLinearUnit" element
     */
    public org.erdc.cobie.cobielite.core.LinearUnitSimpleType xgetFacilityDefaultLinearUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.LinearUnitSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.LinearUnitSimpleType)get_store().find_element_user(FACILITYDEFAULTLINEARUNIT$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "FacilityDefaultLinearUnit" element
     */
    public boolean isSetFacilityDefaultLinearUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FACILITYDEFAULTLINEARUNIT$6) != 0;
        }
    }
    
    /**
     * Sets the "FacilityDefaultLinearUnit" element
     */
    public void setFacilityDefaultLinearUnit(org.erdc.cobie.cobielite.core.LinearUnitSimpleType.Enum facilityDefaultLinearUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTLINEARUNIT$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FACILITYDEFAULTLINEARUNIT$6);
            }
            target.setEnumValue(facilityDefaultLinearUnit);
        }
    }
    
    /**
     * Sets (as xml) the "FacilityDefaultLinearUnit" element
     */
    public void xsetFacilityDefaultLinearUnit(org.erdc.cobie.cobielite.core.LinearUnitSimpleType facilityDefaultLinearUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.LinearUnitSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.LinearUnitSimpleType)get_store().find_element_user(FACILITYDEFAULTLINEARUNIT$6, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.LinearUnitSimpleType)get_store().add_element_user(FACILITYDEFAULTLINEARUNIT$6);
            }
            target.set(facilityDefaultLinearUnit);
        }
    }
    
    /**
     * Unsets the "FacilityDefaultLinearUnit" element
     */
    public void unsetFacilityDefaultLinearUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FACILITYDEFAULTLINEARUNIT$6, 0);
        }
    }
    
    /**
     * Gets the "FacilityDefaultAreaUnit" element
     */
    public org.erdc.cobie.cobielite.core.AreaUnitSimpleType.Enum getFacilityDefaultAreaUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTAREAUNIT$8, 0);
            if (target == null)
            {
                return null;
            }
            return (org.erdc.cobie.cobielite.core.AreaUnitSimpleType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "FacilityDefaultAreaUnit" element
     */
    public org.erdc.cobie.cobielite.core.AreaUnitSimpleType xgetFacilityDefaultAreaUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AreaUnitSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.AreaUnitSimpleType)get_store().find_element_user(FACILITYDEFAULTAREAUNIT$8, 0);
            return target;
        }
    }
    
    /**
     * True if has "FacilityDefaultAreaUnit" element
     */
    public boolean isSetFacilityDefaultAreaUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FACILITYDEFAULTAREAUNIT$8) != 0;
        }
    }
    
    /**
     * Sets the "FacilityDefaultAreaUnit" element
     */
    public void setFacilityDefaultAreaUnit(org.erdc.cobie.cobielite.core.AreaUnitSimpleType.Enum facilityDefaultAreaUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTAREAUNIT$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FACILITYDEFAULTAREAUNIT$8);
            }
            target.setEnumValue(facilityDefaultAreaUnit);
        }
    }
    
    /**
     * Sets (as xml) the "FacilityDefaultAreaUnit" element
     */
    public void xsetFacilityDefaultAreaUnit(org.erdc.cobie.cobielite.core.AreaUnitSimpleType facilityDefaultAreaUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AreaUnitSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.AreaUnitSimpleType)get_store().find_element_user(FACILITYDEFAULTAREAUNIT$8, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.AreaUnitSimpleType)get_store().add_element_user(FACILITYDEFAULTAREAUNIT$8);
            }
            target.set(facilityDefaultAreaUnit);
        }
    }
    
    /**
     * Unsets the "FacilityDefaultAreaUnit" element
     */
    public void unsetFacilityDefaultAreaUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FACILITYDEFAULTAREAUNIT$8, 0);
        }
    }
    
    /**
     * Gets the "FacilityDefaultVolumeUnit" element
     */
    public org.erdc.cobie.cobielite.core.VolumeUnitSimpleType.Enum getFacilityDefaultVolumeUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTVOLUMEUNIT$10, 0);
            if (target == null)
            {
                return null;
            }
            return (org.erdc.cobie.cobielite.core.VolumeUnitSimpleType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "FacilityDefaultVolumeUnit" element
     */
    public org.erdc.cobie.cobielite.core.VolumeUnitSimpleType xgetFacilityDefaultVolumeUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.VolumeUnitSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.VolumeUnitSimpleType)get_store().find_element_user(FACILITYDEFAULTVOLUMEUNIT$10, 0);
            return target;
        }
    }
    
    /**
     * True if has "FacilityDefaultVolumeUnit" element
     */
    public boolean isSetFacilityDefaultVolumeUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FACILITYDEFAULTVOLUMEUNIT$10) != 0;
        }
    }
    
    /**
     * Sets the "FacilityDefaultVolumeUnit" element
     */
    public void setFacilityDefaultVolumeUnit(org.erdc.cobie.cobielite.core.VolumeUnitSimpleType.Enum facilityDefaultVolumeUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTVOLUMEUNIT$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FACILITYDEFAULTVOLUMEUNIT$10);
            }
            target.setEnumValue(facilityDefaultVolumeUnit);
        }
    }
    
    /**
     * Sets (as xml) the "FacilityDefaultVolumeUnit" element
     */
    public void xsetFacilityDefaultVolumeUnit(org.erdc.cobie.cobielite.core.VolumeUnitSimpleType facilityDefaultVolumeUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.VolumeUnitSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.VolumeUnitSimpleType)get_store().find_element_user(FACILITYDEFAULTVOLUMEUNIT$10, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.VolumeUnitSimpleType)get_store().add_element_user(FACILITYDEFAULTVOLUMEUNIT$10);
            }
            target.set(facilityDefaultVolumeUnit);
        }
    }
    
    /**
     * Unsets the "FacilityDefaultVolumeUnit" element
     */
    public void unsetFacilityDefaultVolumeUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FACILITYDEFAULTVOLUMEUNIT$10, 0);
        }
    }
    
    /**
     * Gets the "FacilityDefaultCurrencyUnit" element
     */
    public org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType.Enum getFacilityDefaultCurrencyUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTCURRENCYUNIT$12, 0);
            if (target == null)
            {
                return null;
            }
            return (org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "FacilityDefaultCurrencyUnit" element
     */
    public org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType xgetFacilityDefaultCurrencyUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType)get_store().find_element_user(FACILITYDEFAULTCURRENCYUNIT$12, 0);
            return target;
        }
    }
    
    /**
     * True if has "FacilityDefaultCurrencyUnit" element
     */
    public boolean isSetFacilityDefaultCurrencyUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FACILITYDEFAULTCURRENCYUNIT$12) != 0;
        }
    }
    
    /**
     * Sets the "FacilityDefaultCurrencyUnit" element
     */
    public void setFacilityDefaultCurrencyUnit(org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType.Enum facilityDefaultCurrencyUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTCURRENCYUNIT$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FACILITYDEFAULTCURRENCYUNIT$12);
            }
            target.setEnumValue(facilityDefaultCurrencyUnit);
        }
    }
    
    /**
     * Sets (as xml) the "FacilityDefaultCurrencyUnit" element
     */
    public void xsetFacilityDefaultCurrencyUnit(org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType facilityDefaultCurrencyUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType)get_store().find_element_user(FACILITYDEFAULTCURRENCYUNIT$12, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType)get_store().add_element_user(FACILITYDEFAULTCURRENCYUNIT$12);
            }
            target.set(facilityDefaultCurrencyUnit);
        }
    }
    
    /**
     * Unsets the "FacilityDefaultCurrencyUnit" element
     */
    public void unsetFacilityDefaultCurrencyUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FACILITYDEFAULTCURRENCYUNIT$12, 0);
        }
    }
    
    /**
     * Gets the "FacilityDefaultMeasurementStandard" element
     */
    public java.lang.String getFacilityDefaultMeasurementStandard()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTMEASUREMENTSTANDARD$14, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FacilityDefaultMeasurementStandard" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetFacilityDefaultMeasurementStandard()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(FACILITYDEFAULTMEASUREMENTSTANDARD$14, 0);
            return target;
        }
    }
    
    /**
     * True if has "FacilityDefaultMeasurementStandard" element
     */
    public boolean isSetFacilityDefaultMeasurementStandard()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FACILITYDEFAULTMEASUREMENTSTANDARD$14) != 0;
        }
    }
    
    /**
     * Sets the "FacilityDefaultMeasurementStandard" element
     */
    public void setFacilityDefaultMeasurementStandard(java.lang.String facilityDefaultMeasurementStandard)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTMEASUREMENTSTANDARD$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FACILITYDEFAULTMEASUREMENTSTANDARD$14);
            }
            target.setStringValue(facilityDefaultMeasurementStandard);
        }
    }
    
    /**
     * Sets (as xml) the "FacilityDefaultMeasurementStandard" element
     */
    public void xsetFacilityDefaultMeasurementStandard(org.erdc.cobie.cobielite.core.CobieTextSimpleType facilityDefaultMeasurementStandard)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(FACILITYDEFAULTMEASUREMENTSTANDARD$14, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(FACILITYDEFAULTMEASUREMENTSTANDARD$14);
            }
            target.set(facilityDefaultMeasurementStandard);
        }
    }
    
    /**
     * Unsets the "FacilityDefaultMeasurementStandard" element
     */
    public void unsetFacilityDefaultMeasurementStandard()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FACILITYDEFAULTMEASUREMENTSTANDARD$14, 0);
        }
    }
    
    /**
     * Gets the "FacilityDescription" element
     */
    public java.lang.String getFacilityDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDESCRIPTION$16, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FacilityDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetFacilityDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(FACILITYDESCRIPTION$16, 0);
            return target;
        }
    }
    
    /**
     * True if has "FacilityDescription" element
     */
    public boolean isSetFacilityDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FACILITYDESCRIPTION$16) != 0;
        }
    }
    
    /**
     * Sets the "FacilityDescription" element
     */
    public void setFacilityDescription(java.lang.String facilityDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDESCRIPTION$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FACILITYDESCRIPTION$16);
            }
            target.setStringValue(facilityDescription);
        }
    }
    
    /**
     * Sets (as xml) the "FacilityDescription" element
     */
    public void xsetFacilityDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType facilityDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(FACILITYDESCRIPTION$16, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(FACILITYDESCRIPTION$16);
            }
            target.set(facilityDescription);
        }
    }
    
    /**
     * Unsets the "FacilityDescription" element
     */
    public void unsetFacilityDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FACILITYDESCRIPTION$16, 0);
        }
    }
    
    /**
     * Gets the "FacilityDeliverablePhaseName" element
     */
    public java.lang.String getFacilityDeliverablePhaseName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDELIVERABLEPHASENAME$18, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FacilityDeliverablePhaseName" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetFacilityDeliverablePhaseName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(FACILITYDELIVERABLEPHASENAME$18, 0);
            return target;
        }
    }
    
    /**
     * True if has "FacilityDeliverablePhaseName" element
     */
    public boolean isSetFacilityDeliverablePhaseName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FACILITYDELIVERABLEPHASENAME$18) != 0;
        }
    }
    
    /**
     * Sets the "FacilityDeliverablePhaseName" element
     */
    public void setFacilityDeliverablePhaseName(java.lang.String facilityDeliverablePhaseName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDELIVERABLEPHASENAME$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FACILITYDELIVERABLEPHASENAME$18);
            }
            target.setStringValue(facilityDeliverablePhaseName);
        }
    }
    
    /**
     * Sets (as xml) the "FacilityDeliverablePhaseName" element
     */
    public void xsetFacilityDeliverablePhaseName(org.erdc.cobie.cobielite.core.CobieTextSimpleType facilityDeliverablePhaseName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(FACILITYDELIVERABLEPHASENAME$18, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(FACILITYDELIVERABLEPHASENAME$18);
            }
            target.set(facilityDeliverablePhaseName);
        }
    }
    
    /**
     * Unsets the "FacilityDeliverablePhaseName" element
     */
    public void unsetFacilityDeliverablePhaseName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FACILITYDELIVERABLEPHASENAME$18, 0);
        }
    }
    
    /**
     * Gets the "Floors" element
     */
    public org.erdc.cobie.cobielite.core.FloorCollectionType getFloors()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FloorCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.FloorCollectionType)get_store().find_element_user(FLOORS$20, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Floors" element
     */
    public boolean isSetFloors()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FLOORS$20) != 0;
        }
    }
    
    /**
     * Sets the "Floors" element
     */
    public void setFloors(org.erdc.cobie.cobielite.core.FloorCollectionType floors)
    {
        generatedSetterHelperImpl(floors, FLOORS$20, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Floors" element
     */
    public org.erdc.cobie.cobielite.core.FloorCollectionType addNewFloors()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FloorCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.FloorCollectionType)get_store().add_element_user(FLOORS$20);
            return target;
        }
    }
    
    /**
     * Unsets the "Floors" element
     */
    public void unsetFloors()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FLOORS$20, 0);
        }
    }
    
    /**
     * Gets the "Zones" element
     */
    public org.erdc.cobie.cobielite.core.ZoneCollectionType getZones()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneCollectionType)get_store().find_element_user(ZONES$22, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Zones" element
     */
    public boolean isSetZones()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ZONES$22) != 0;
        }
    }
    
    /**
     * Sets the "Zones" element
     */
    public void setZones(org.erdc.cobie.cobielite.core.ZoneCollectionType zones)
    {
        generatedSetterHelperImpl(zones, ZONES$22, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Zones" element
     */
    public org.erdc.cobie.cobielite.core.ZoneCollectionType addNewZones()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneCollectionType)get_store().add_element_user(ZONES$22);
            return target;
        }
    }
    
    /**
     * Unsets the "Zones" element
     */
    public void unsetZones()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ZONES$22, 0);
        }
    }
    
    /**
     * Gets the "AssetTypes" element
     */
    public org.erdc.cobie.cobielite.core.AssetTypeCollectionType getAssetTypes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetTypeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetTypeCollectionType)get_store().find_element_user(ASSETTYPES$24, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AssetTypes" element
     */
    public boolean isSetAssetTypes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPES$24) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypes" element
     */
    public void setAssetTypes(org.erdc.cobie.cobielite.core.AssetTypeCollectionType assetTypes)
    {
        generatedSetterHelperImpl(assetTypes, ASSETTYPES$24, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypes" element
     */
    public org.erdc.cobie.cobielite.core.AssetTypeCollectionType addNewAssetTypes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetTypeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetTypeCollectionType)get_store().add_element_user(ASSETTYPES$24);
            return target;
        }
    }
    
    /**
     * Unsets the "AssetTypes" element
     */
    public void unsetAssetTypes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPES$24, 0);
        }
    }
    
    /**
     * Gets the "Systems" element
     */
    public org.erdc.cobie.cobielite.core.SystemCollectionType getSystems()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemCollectionType)get_store().find_element_user(SYSTEMS$26, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Systems" element
     */
    public boolean isSetSystems()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SYSTEMS$26) != 0;
        }
    }
    
    /**
     * Sets the "Systems" element
     */
    public void setSystems(org.erdc.cobie.cobielite.core.SystemCollectionType systems)
    {
        generatedSetterHelperImpl(systems, SYSTEMS$26, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Systems" element
     */
    public org.erdc.cobie.cobielite.core.SystemCollectionType addNewSystems()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemCollectionType)get_store().add_element_user(SYSTEMS$26);
            return target;
        }
    }
    
    /**
     * Unsets the "Systems" element
     */
    public void unsetSystems()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SYSTEMS$26, 0);
        }
    }
    
    /**
     * Gets the "Connections" element
     */
    public org.erdc.cobie.cobielite.core.ConnectionCollectionType getConnections()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ConnectionCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ConnectionCollectionType)get_store().find_element_user(CONNECTIONS$28, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Connections" element
     */
    public boolean isSetConnections()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONNECTIONS$28) != 0;
        }
    }
    
    /**
     * Sets the "Connections" element
     */
    public void setConnections(org.erdc.cobie.cobielite.core.ConnectionCollectionType connections)
    {
        generatedSetterHelperImpl(connections, CONNECTIONS$28, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Connections" element
     */
    public org.erdc.cobie.cobielite.core.ConnectionCollectionType addNewConnections()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ConnectionCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ConnectionCollectionType)get_store().add_element_user(CONNECTIONS$28);
            return target;
        }
    }
    
    /**
     * Unsets the "Connections" element
     */
    public void unsetConnections()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONNECTIONS$28, 0);
        }
    }
    
    /**
     * Gets the "Contacts" element
     */
    public org.erdc.cobie.cobielite.core.ContactCollectionType getContacts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactCollectionType)get_store().find_element_user(CONTACTS$30, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Contacts" element
     */
    public boolean isSetContacts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTS$30) != 0;
        }
    }
    
    /**
     * Sets the "Contacts" element
     */
    public void setContacts(org.erdc.cobie.cobielite.core.ContactCollectionType contacts)
    {
        generatedSetterHelperImpl(contacts, CONTACTS$30, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Contacts" element
     */
    public org.erdc.cobie.cobielite.core.ContactCollectionType addNewContacts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactCollectionType)get_store().add_element_user(CONTACTS$30);
            return target;
        }
    }
    
    /**
     * Unsets the "Contacts" element
     */
    public void unsetContacts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTS$30, 0);
        }
    }
    
    /**
     * Gets the "FacilityAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getFacilityAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(FACILITYATTRIBUTES$32, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "FacilityAttributes" element
     */
    public boolean isSetFacilityAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FACILITYATTRIBUTES$32) != 0;
        }
    }
    
    /**
     * Sets the "FacilityAttributes" element
     */
    public void setFacilityAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType facilityAttributes)
    {
        generatedSetterHelperImpl(facilityAttributes, FACILITYATTRIBUTES$32, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "FacilityAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewFacilityAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(FACILITYATTRIBUTES$32);
            return target;
        }
    }
    
    /**
     * Unsets the "FacilityAttributes" element
     */
    public void unsetFacilityAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FACILITYATTRIBUTES$32, 0);
        }
    }
    
    /**
     * Gets the "FacilityDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getFacilityDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(FACILITYDOCUMENTS$34, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "FacilityDocuments" element
     */
    public boolean isSetFacilityDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FACILITYDOCUMENTS$34) != 0;
        }
    }
    
    /**
     * Sets the "FacilityDocuments" element
     */
    public void setFacilityDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType facilityDocuments)
    {
        generatedSetterHelperImpl(facilityDocuments, FACILITYDOCUMENTS$34, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "FacilityDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewFacilityDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(FACILITYDOCUMENTS$34);
            return target;
        }
    }
    
    /**
     * Unsets the "FacilityDocuments" element
     */
    public void unsetFacilityDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FACILITYDOCUMENTS$34, 0);
        }
    }
    
    /**
     * Gets the "FacilityIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getFacilityIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(FACILITYISSUES$36, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "FacilityIssues" element
     */
    public boolean isSetFacilityIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FACILITYISSUES$36) != 0;
        }
    }
    
    /**
     * Sets the "FacilityIssues" element
     */
    public void setFacilityIssues(org.erdc.cobie.cobielite.core.IssueCollectionType facilityIssues)
    {
        generatedSetterHelperImpl(facilityIssues, FACILITYISSUES$36, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "FacilityIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewFacilityIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(FACILITYISSUES$36);
            return target;
        }
    }
    
    /**
     * Unsets the "FacilityIssues" element
     */
    public void unsetFacilityIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FACILITYISSUES$36, 0);
        }
    }
}
