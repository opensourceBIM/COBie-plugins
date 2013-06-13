/*
 * XML Type:  AttributeMonetaryValueType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeMonetaryValueType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML AttributeMonetaryValueType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class AttributeMonetaryValueTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AttributeMonetaryValueType
{
    private static final long serialVersionUID = 1L;
    
    public AttributeMonetaryValueTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MONETARYVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "MonetaryValue");
    private static final javax.xml.namespace.QName MONETARYUNIT$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "MonetaryUnit");
    
    
    /**
     * Gets the "MonetaryValue" element
     */
    public java.math.BigDecimal getMonetaryValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MONETARYVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getBigDecimalValue();
        }
    }
    
    /**
     * Gets (as xml) the "MonetaryValue" element
     */
    public org.erdc.cobie.cobielite.core.MonetaryValueSimpleType xgetMonetaryValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.MonetaryValueSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.MonetaryValueSimpleType)get_store().find_element_user(MONETARYVALUE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "MonetaryValue" element
     */
    public void setMonetaryValue(java.math.BigDecimal monetaryValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MONETARYVALUE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MONETARYVALUE$0);
            }
            target.setBigDecimalValue(monetaryValue);
        }
    }
    
    /**
     * Sets (as xml) the "MonetaryValue" element
     */
    public void xsetMonetaryValue(org.erdc.cobie.cobielite.core.MonetaryValueSimpleType monetaryValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.MonetaryValueSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.MonetaryValueSimpleType)get_store().find_element_user(MONETARYVALUE$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.MonetaryValueSimpleType)get_store().add_element_user(MONETARYVALUE$0);
            }
            target.set(monetaryValue);
        }
    }
    
    /**
     * Gets the "MonetaryUnit" element
     */
    public org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType.Enum getMonetaryUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MONETARYUNIT$2, 0);
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
            target = (org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType)get_store().find_element_user(MONETARYUNIT$2, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MONETARYUNIT$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MONETARYUNIT$2);
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
            target = (org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType)get_store().find_element_user(MONETARYUNIT$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType)get_store().add_element_user(MONETARYUNIT$2);
            }
            target.set(monetaryUnit);
        }
    }
}
