/*
 * An XML document type.
 * Localname: Facility
 * Namespace: http://cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.FacilityDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.impl;
/**
 * A document containing one Facility(@http://cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FacilityDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.FacilityDocument
{
    private static final long serialVersionUID = 1L;
    
    public FacilityDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FACILITY$0 = 
        new javax.xml.namespace.QName("http://cobielite.cobie.erdc.org", "Facility");
    
    
    /**
     * Gets the "Facility" element
     */
    public org.erdc.cobie.cobielite.facility.FacilityType getFacility()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.facility.FacilityType target = null;
            target = (org.erdc.cobie.cobielite.facility.FacilityType)get_store().find_element_user(FACILITY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Facility" element
     */
    public void setFacility(org.erdc.cobie.cobielite.facility.FacilityType facility)
    {
        generatedSetterHelperImpl(facility, FACILITY$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Facility" element
     */
    public org.erdc.cobie.cobielite.facility.FacilityType addNewFacility()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.facility.FacilityType target = null;
            target = (org.erdc.cobie.cobielite.facility.FacilityType)get_store().add_element_user(FACILITY$0);
            return target;
        }
    }
}
