/*
 * XML Type:  DecimalValueType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.DecimalValueType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML DecimalValueType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class DecimalValueTypeImpl extends org.erdc.cobie.cobielite.core.impl.ValueBaseTypeImpl implements org.erdc.cobie.cobielite.core.DecimalValueType
{
    private static final long serialVersionUID = 1L;
    
    public DecimalValueTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INTEGERVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "IntegerValue");
    
    
    /**
     * Gets the "IntegerValue" element
     */
    public java.math.BigInteger getIntegerValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INTEGERVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getBigIntegerValue();
        }
    }
    
    /**
     * Gets (as xml) the "IntegerValue" element
     */
    public org.apache.xmlbeans.XmlInteger xgetIntegerValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInteger target = null;
            target = (org.apache.xmlbeans.XmlInteger)get_store().find_element_user(INTEGERVALUE$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "IntegerValue" element
     */
    public boolean isSetIntegerValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(INTEGERVALUE$0) != 0;
        }
    }
    
    /**
     * Sets the "IntegerValue" element
     */
    public void setIntegerValue(java.math.BigInteger integerValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INTEGERVALUE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(INTEGERVALUE$0);
            }
            target.setBigIntegerValue(integerValue);
        }
    }
    
    /**
     * Sets (as xml) the "IntegerValue" element
     */
    public void xsetIntegerValue(org.apache.xmlbeans.XmlInteger integerValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInteger target = null;
            target = (org.apache.xmlbeans.XmlInteger)get_store().find_element_user(INTEGERVALUE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlInteger)get_store().add_element_user(INTEGERVALUE$0);
            }
            target.set(integerValue);
        }
    }
    
    /**
     * Unsets the "IntegerValue" element
     */
    public void unsetIntegerValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(INTEGERVALUE$0, 0);
        }
    }
}
