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
    
    private static final javax.xml.namespace.QName DECIMALVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "DecimalValue");
    
    
    /**
     * Gets the "DecimalValue" element
     */
    public java.math.BigDecimal getDecimalValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DECIMALVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getBigDecimalValue();
        }
    }
    
    /**
     * Gets (as xml) the "DecimalValue" element
     */
    public org.apache.xmlbeans.XmlDecimal xgetDecimalValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDecimal target = null;
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(DECIMALVALUE$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "DecimalValue" element
     */
    public boolean isSetDecimalValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DECIMALVALUE$0) != 0;
        }
    }
    
    /**
     * Sets the "DecimalValue" element
     */
    public void setDecimalValue(java.math.BigDecimal decimalValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DECIMALVALUE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DECIMALVALUE$0);
            }
            target.setBigDecimalValue(decimalValue);
        }
    }
    
    /**
     * Sets (as xml) the "DecimalValue" element
     */
    public void xsetDecimalValue(org.apache.xmlbeans.XmlDecimal decimalValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDecimal target = null;
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(DECIMALVALUE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(DECIMALVALUE$0);
            }
            target.set(decimalValue);
        }
    }
    
    /**
     * Unsets the "DecimalValue" element
     */
    public void unsetDecimalValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DECIMALVALUE$0, 0);
        }
    }
}
