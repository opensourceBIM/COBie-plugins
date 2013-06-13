/*
 * An XML document type.
 * Localname: DecimalValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.DecimalValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one DecimalValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class DecimalValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.DecimalValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public DecimalValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
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
}
