/*
 * An XML document type.
 * Localname: MaxValueDecimal
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.MaxValueDecimalDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one MaxValueDecimal(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class MaxValueDecimalDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.MaxValueDecimalDocument
{
    private static final long serialVersionUID = 1L;
    
    public MaxValueDecimalDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MAXVALUEDECIMAL$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "MaxValueDecimal");
    
    
    /**
     * Gets the "MaxValueDecimal" element
     */
    public java.math.BigDecimal getMaxValueDecimal()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MAXVALUEDECIMAL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getBigDecimalValue();
        }
    }
    
    /**
     * Gets (as xml) the "MaxValueDecimal" element
     */
    public org.apache.xmlbeans.XmlDecimal xgetMaxValueDecimal()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDecimal target = null;
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(MAXVALUEDECIMAL$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "MaxValueDecimal" element
     */
    public void setMaxValueDecimal(java.math.BigDecimal maxValueDecimal)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MAXVALUEDECIMAL$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MAXVALUEDECIMAL$0);
            }
            target.setBigDecimalValue(maxValueDecimal);
        }
    }
    
    /**
     * Sets (as xml) the "MaxValueDecimal" element
     */
    public void xsetMaxValueDecimal(org.apache.xmlbeans.XmlDecimal maxValueDecimal)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDecimal target = null;
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(MAXVALUEDECIMAL$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(MAXVALUEDECIMAL$0);
            }
            target.set(maxValueDecimal);
        }
    }
}
