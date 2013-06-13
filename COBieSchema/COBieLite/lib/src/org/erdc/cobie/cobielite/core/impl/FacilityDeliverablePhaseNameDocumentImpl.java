/*
 * An XML document type.
 * Localname: FacilityDeliverablePhaseName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.FacilityDeliverablePhaseNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one FacilityDeliverablePhaseName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FacilityDeliverablePhaseNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.FacilityDeliverablePhaseNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public FacilityDeliverablePhaseNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FACILITYDELIVERABLEPHASENAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityDeliverablePhaseName");
    
    
    /**
     * Gets the "FacilityDeliverablePhaseName" element
     */
    public java.lang.String getFacilityDeliverablePhaseName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDELIVERABLEPHASENAME$0, 0);
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
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(FACILITYDELIVERABLEPHASENAME$0, 0);
            return target;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDELIVERABLEPHASENAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FACILITYDELIVERABLEPHASENAME$0);
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
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(FACILITYDELIVERABLEPHASENAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(FACILITYDELIVERABLEPHASENAME$0);
            }
            target.set(facilityDeliverablePhaseName);
        }
    }
}
