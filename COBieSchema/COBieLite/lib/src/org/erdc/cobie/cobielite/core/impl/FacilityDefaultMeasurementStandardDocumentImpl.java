/*
 * An XML document type.
 * Localname: FacilityDefaultMeasurementStandard
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.FacilityDefaultMeasurementStandardDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one FacilityDefaultMeasurementStandard(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FacilityDefaultMeasurementStandardDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.FacilityDefaultMeasurementStandardDocument
{
    private static final long serialVersionUID = 1L;
    
    public FacilityDefaultMeasurementStandardDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FACILITYDEFAULTMEASUREMENTSTANDARD$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityDefaultMeasurementStandard");
    
    
    /**
     * Gets the "FacilityDefaultMeasurementStandard" element
     */
    public java.lang.String getFacilityDefaultMeasurementStandard()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTMEASUREMENTSTANDARD$0, 0);
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
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(FACILITYDEFAULTMEASUREMENTSTANDARD$0, 0);
            return target;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTMEASUREMENTSTANDARD$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FACILITYDEFAULTMEASUREMENTSTANDARD$0);
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
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(FACILITYDEFAULTMEASUREMENTSTANDARD$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(FACILITYDEFAULTMEASUREMENTSTANDARD$0);
            }
            target.set(facilityDefaultMeasurementStandard);
        }
    }
}
