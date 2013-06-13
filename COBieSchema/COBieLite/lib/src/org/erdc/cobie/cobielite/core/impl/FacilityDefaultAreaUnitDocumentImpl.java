/*
 * An XML document type.
 * Localname: FacilityDefaultAreaUnit
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.FacilityDefaultAreaUnitDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one FacilityDefaultAreaUnit(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FacilityDefaultAreaUnitDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.FacilityDefaultAreaUnitDocument
{
    private static final long serialVersionUID = 1L;
    
    public FacilityDefaultAreaUnitDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FACILITYDEFAULTAREAUNIT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityDefaultAreaUnit");
    
    
    /**
     * Gets the "FacilityDefaultAreaUnit" element
     */
    public org.erdc.cobie.cobielite.core.AreaUnitSimpleType.Enum getFacilityDefaultAreaUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTAREAUNIT$0, 0);
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
            target = (org.erdc.cobie.cobielite.core.AreaUnitSimpleType)get_store().find_element_user(FACILITYDEFAULTAREAUNIT$0, 0);
            return target;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTAREAUNIT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FACILITYDEFAULTAREAUNIT$0);
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
            target = (org.erdc.cobie.cobielite.core.AreaUnitSimpleType)get_store().find_element_user(FACILITYDEFAULTAREAUNIT$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.AreaUnitSimpleType)get_store().add_element_user(FACILITYDEFAULTAREAUNIT$0);
            }
            target.set(facilityDefaultAreaUnit);
        }
    }
}
