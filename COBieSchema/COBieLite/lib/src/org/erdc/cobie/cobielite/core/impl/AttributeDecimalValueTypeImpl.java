/*
 * XML Type:  AttributeDecimalValueType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeDecimalValueType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML AttributeDecimalValueType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class AttributeDecimalValueTypeImpl extends org.erdc.cobie.cobielite.core.impl.DecimalValueTypeImpl implements org.erdc.cobie.cobielite.core.AttributeDecimalValueType
{
    private static final long serialVersionUID = 1L;
    
    public AttributeDecimalValueTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MINVALUEDECIMAL$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "MinValueDecimal");
    private static final javax.xml.namespace.QName MAXVALUEDECIMAL$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "MaxValueDecimal");
    
    
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
     * True if has "MinValueDecimal" element
     */
    public boolean isSetMinValueDecimal()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(MINVALUEDECIMAL$0) != 0;
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
    
    /**
     * Unsets the "MinValueDecimal" element
     */
    public void unsetMinValueDecimal()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(MINVALUEDECIMAL$0, 0);
        }
    }
    
    /**
     * Gets the "MaxValueDecimal" element
     */
    public java.math.BigDecimal getMaxValueDecimal()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MAXVALUEDECIMAL$2, 0);
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
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(MAXVALUEDECIMAL$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "MaxValueDecimal" element
     */
    public boolean isSetMaxValueDecimal()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(MAXVALUEDECIMAL$2) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MAXVALUEDECIMAL$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MAXVALUEDECIMAL$2);
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
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(MAXVALUEDECIMAL$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(MAXVALUEDECIMAL$2);
            }
            target.set(maxValueDecimal);
        }
    }
    
    /**
     * Unsets the "MaxValueDecimal" element
     */
    public void unsetMaxValueDecimal()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(MAXVALUEDECIMAL$2, 0);
        }
    }
}
