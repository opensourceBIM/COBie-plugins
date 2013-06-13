/*
 * An XML document type.
 * Localname: FacilityDefaultVolumeUnit
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.FacilityDefaultVolumeUnitDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one FacilityDefaultVolumeUnit(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FacilityDefaultVolumeUnitDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.FacilityDefaultVolumeUnitDocument
{
    private static final long serialVersionUID = 1L;
    
    public FacilityDefaultVolumeUnitDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FACILITYDEFAULTVOLUMEUNIT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityDefaultVolumeUnit");
    
    
    /**
     * Gets the "FacilityDefaultVolumeUnit" element
     */
    public org.erdc.cobie.cobielite.core.VolumeUnitSimpleType.Enum getFacilityDefaultVolumeUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTVOLUMEUNIT$0, 0);
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
            target = (org.erdc.cobie.cobielite.core.VolumeUnitSimpleType)get_store().find_element_user(FACILITYDEFAULTVOLUMEUNIT$0, 0);
            return target;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTVOLUMEUNIT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FACILITYDEFAULTVOLUMEUNIT$0);
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
            target = (org.erdc.cobie.cobielite.core.VolumeUnitSimpleType)get_store().find_element_user(FACILITYDEFAULTVOLUMEUNIT$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.VolumeUnitSimpleType)get_store().add_element_user(FACILITYDEFAULTVOLUMEUNIT$0);
            }
            target.set(facilityDefaultVolumeUnit);
        }
    }
}
