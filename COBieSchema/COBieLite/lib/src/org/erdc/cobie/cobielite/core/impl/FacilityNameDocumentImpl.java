/*
 * An XML document type.
 * Localname: FacilityName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.FacilityNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one FacilityName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FacilityNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.FacilityNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public FacilityNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FACILITYNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityName");
    
    
    /**
     * Gets the "FacilityName" element
     */
    public java.lang.String getFacilityName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FacilityName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetFacilityName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(FACILITYNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "FacilityName" element
     */
    public void setFacilityName(java.lang.String facilityName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FACILITYNAME$0);
            }
            target.setStringValue(facilityName);
        }
    }
    
    /**
     * Sets (as xml) the "FacilityName" element
     */
    public void xsetFacilityName(org.erdc.cobie.cobielite.core.CobieNameSimpleType facilityName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(FACILITYNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(FACILITYNAME$0);
            }
            target.set(facilityName);
        }
    }
}
