/*
 * An XML document type.
 * Localname: FacilityDescription
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.FacilityDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one FacilityDescription(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FacilityDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.FacilityDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public FacilityDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FACILITYDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityDescription");
    
    
    /**
     * Gets the "FacilityDescription" element
     */
    public java.lang.String getFacilityDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDESCRIPTION$0, 0);
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
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(FACILITYDESCRIPTION$0, 0);
            return target;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FACILITYDESCRIPTION$0);
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
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(FACILITYDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(FACILITYDESCRIPTION$0);
            }
            target.set(facilityDescription);
        }
    }
}
