/*
 * An XML document type.
 * Localname: MonetaryUnit
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.MonetaryUnitDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one MonetaryUnit(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class MonetaryUnitDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.MonetaryUnitDocument
{
    private static final long serialVersionUID = 1L;
    
    public MonetaryUnitDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MONETARYUNIT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "MonetaryUnit");
    
    
    /**
     * Gets the "MonetaryUnit" element
     */
    public org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType.Enum getMonetaryUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MONETARYUNIT$0, 0);
            if (target == null)
            {
                return null;
            }
            return (org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "MonetaryUnit" element
     */
    public org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType xgetMonetaryUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType)get_store().find_element_user(MONETARYUNIT$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "MonetaryUnit" element
     */
    public void setMonetaryUnit(org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType.Enum monetaryUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MONETARYUNIT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MONETARYUNIT$0);
            }
            target.setEnumValue(monetaryUnit);
        }
    }
    
    /**
     * Sets (as xml) the "MonetaryUnit" element
     */
    public void xsetMonetaryUnit(org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType monetaryUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType)get_store().find_element_user(MONETARYUNIT$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType)get_store().add_element_user(MONETARYUNIT$0);
            }
            target.set(monetaryUnit);
        }
    }
}
