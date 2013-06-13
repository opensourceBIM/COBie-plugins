/*
 * An XML document type.
 * Localname: Facility
 * Namespace: http://facility.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.facility.FacilityDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.facility.impl;
/**
 * A document containing one Facility(@http://facility.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FacilityDocumentImpl extends org.erdc.cobie.cobielite.core.impl.FacilityDocumentImpl implements org.erdc.cobie.cobielite.facility.FacilityDocument
{
    private static final long serialVersionUID = 1L;
    
    public FacilityDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FACILITY2$0 = 
        new javax.xml.namespace.QName("http://facility.cobielite.cobie.erdc.org", "Facility");
    
    
    /**
     * Gets the "Facility" element
     */
    public org.erdc.cobie.cobielite.facility.FacilityType getFacility2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.facility.FacilityType target = null;
            target = (org.erdc.cobie.cobielite.facility.FacilityType)get_store().find_element_user(FACILITY2$0, 0);
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
    public void setFacility2(org.erdc.cobie.cobielite.facility.FacilityType facility2)
    {
        generatedSetterHelperImpl(facility2, FACILITY2$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Facility" element
     */
    public org.erdc.cobie.cobielite.facility.FacilityType addNewFacility2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.facility.FacilityType target = null;
            target = (org.erdc.cobie.cobielite.facility.FacilityType)get_store().add_element_user(FACILITY2$0);
            return target;
        }
    }
}
