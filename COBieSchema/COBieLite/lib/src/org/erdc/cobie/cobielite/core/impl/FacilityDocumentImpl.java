/*
 * An XML document type.
 * Localname: Facility
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.FacilityDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Facility(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FacilityDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.FacilityDocument
{
    private static final long serialVersionUID = 1L;
    
    public FacilityDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FACILITY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Facility");
    private static final org.apache.xmlbeans.QNameSet FACILITY$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Facility"),
        new javax.xml.namespace.QName("http://facility.cobielite.cobie.erdc.org", "Facility"),
    });
    
    
    /**
     * Gets the "Facility" element
     */
    public org.erdc.cobie.cobielite.core.FacilityType getFacility()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FacilityType target = null;
            target = (org.erdc.cobie.cobielite.core.FacilityType)get_store().find_element_user(FACILITY$1, 0);
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
    public void setFacility(org.erdc.cobie.cobielite.core.FacilityType facility)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FacilityType target = null;
            target = (org.erdc.cobie.cobielite.core.FacilityType)get_store().find_element_user(FACILITY$1, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.FacilityType)get_store().add_element_user(FACILITY$0);
            }
            target.set(facility);
        }
    }
    
    /**
     * Appends and returns a new empty "Facility" element
     */
    public org.erdc.cobie.cobielite.core.FacilityType addNewFacility()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FacilityType target = null;
            target = (org.erdc.cobie.cobielite.core.FacilityType)get_store().add_element_user(FACILITY$0);
            return target;
        }
    }
}
