/*
 * An XML document type.
 * Localname: FacilityDefaultCurrencyUnit
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.FacilityDefaultCurrencyUnitDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one FacilityDefaultCurrencyUnit(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FacilityDefaultCurrencyUnitDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.FacilityDefaultCurrencyUnitDocument
{
    private static final long serialVersionUID = 1L;
    
    public FacilityDefaultCurrencyUnitDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FACILITYDEFAULTCURRENCYUNIT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityDefaultCurrencyUnit");
    
    
    /**
     * Gets the "FacilityDefaultCurrencyUnit" element
     */
    public org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType.Enum getFacilityDefaultCurrencyUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTCURRENCYUNIT$0, 0);
            if (target == null)
            {
                return null;
            }
            return (org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "FacilityDefaultCurrencyUnit" element
     */
    public org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType xgetFacilityDefaultCurrencyUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType)get_store().find_element_user(FACILITYDEFAULTCURRENCYUNIT$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "FacilityDefaultCurrencyUnit" element
     */
    public void setFacilityDefaultCurrencyUnit(org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType.Enum facilityDefaultCurrencyUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYDEFAULTCURRENCYUNIT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FACILITYDEFAULTCURRENCYUNIT$0);
            }
            target.setEnumValue(facilityDefaultCurrencyUnit);
        }
    }
    
    /**
     * Sets (as xml) the "FacilityDefaultCurrencyUnit" element
     */
    public void xsetFacilityDefaultCurrencyUnit(org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType facilityDefaultCurrencyUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType)get_store().find_element_user(FACILITYDEFAULTCURRENCYUNIT$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType)get_store().add_element_user(FACILITYDEFAULTCURRENCYUNIT$0);
            }
            target.set(facilityDefaultCurrencyUnit);
        }
    }
}
