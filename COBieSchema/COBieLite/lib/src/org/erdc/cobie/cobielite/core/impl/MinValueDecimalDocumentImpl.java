/*
 * An XML document type.
 * Localname: MinValueDecimal
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.MinValueDecimalDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one MinValueDecimal(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class MinValueDecimalDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.MinValueDecimalDocument
{
    private static final long serialVersionUID = 1L;
    
    public MinValueDecimalDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MINVALUEDECIMAL$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "MinValueDecimal");
    
    
    /**
     * Gets the "MinValueDecimal" element
     */
    public java.math.BigDecimal getMinValueDecimal()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MINVALUEDECIMAL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getBigDecimalValue();
        }
    }
    
    /**
     * Gets (as xml) the "MinValueDecimal" element
     */
    public org.apache.xmlbeans.XmlDecimal xgetMinValueDecimal()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDecimal target = null;
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(MINVALUEDECIMAL$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "MinValueDecimal" element
     */
    public void setMinValueDecimal(java.math.BigDecimal minValueDecimal)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MINVALUEDECIMAL$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MINVALUEDECIMAL$0);
            }
            target.setBigDecimalValue(minValueDecimal);
        }
    }
    
    /**
     * Sets (as xml) the "MinValueDecimal" element
     */
    public void xsetMinValueDecimal(org.apache.xmlbeans.XmlDecimal minValueDecimal)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDecimal target = null;
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(MINVALUEDECIMAL$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(MINVALUEDECIMAL$0);
            }
            target.set(minValueDecimal);
        }
    }
}
