/*
 * An XML document type.
 * Localname: FacilityDefaultLinearUnit
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.FacilityDefaultLinearUnitDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one FacilityDefaultLinearUnit(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FacilityDefaultLinearUnitDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.FacilityDefaultLinearUnitDocument
{
    private static final long serialVersionUID = 1L;
    
    public FacilityDefaultLinearUnitDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FACILITYDEFAULTLINEARUNIT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityDefaultLinearUnit");
    
    
    /**
     * Gets the "FacilityDefaultLinearUnit" element
     */
    public org.erdc.cobie.cobielite.core.LinearUnitSimpleType.Enum getFacilityDefaultLinearUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTLINEARUNIT$0, 0);
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
            target = (org.erdc.cobie.cobielite.core.LinearUnitSimpleType)get_store().find_element_user(FACILITYDEFAULTLINEARUNIT$0, 0);
            return target;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTLINEARUNIT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FACILITYDEFAULTLINEARUNIT$0);
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
            target = (org.erdc.cobie.cobielite.core.LinearUnitSimpleType)get_store().find_element_user(FACILITYDEFAULTLINEARUNIT$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.LinearUnitSimpleType)get_store().add_element_user(FACILITYDEFAULTLINEARUNIT$0);
            }
            target.set(facilityDefaultLinearUnit);
        }
    }
}
