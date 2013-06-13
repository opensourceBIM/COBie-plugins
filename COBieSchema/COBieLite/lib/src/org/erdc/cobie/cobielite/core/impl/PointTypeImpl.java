/*
 * XML Type:  PointType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.PointType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML PointType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class PointTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieComplexObjectTypeImpl implements org.erdc.cobie.cobielite.core.PointType
{
    private static final long serialVersionUID = 1L;
    
    public PointTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName POINTXVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "PointXValue");
    private static final javax.xml.namespace.QName POINTYVALUE$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "PointYValue");
    
    
    /**
     * Gets the "PointXValue" element
     */
    public java.math.BigDecimal getPointXValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POINTXVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getBigDecimalValue();
        }
    }
    
    /**
     * Gets (as xml) the "PointXValue" element
     */
    public org.apache.xmlbeans.XmlDecimal xgetPointXValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDecimal target = null;
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(POINTXVALUE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PointXValue" element
     */
    public void setPointXValue(java.math.BigDecimal pointXValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POINTXVALUE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(POINTXVALUE$0);
            }
            target.setBigDecimalValue(pointXValue);
        }
    }
    
    /**
     * Sets (as xml) the "PointXValue" element
     */
    public void xsetPointXValue(org.apache.xmlbeans.XmlDecimal pointXValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDecimal target = null;
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(POINTXVALUE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(POINTXVALUE$0);
            }
            target.set(pointXValue);
        }
    }
    
    /**
     * Gets the "PointYValue" element
     */
    public java.math.BigDecimal getPointYValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POINTYVALUE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getBigDecimalValue();
        }
    }
    
    /**
     * Gets (as xml) the "PointYValue" element
     */
    public org.apache.xmlbeans.XmlDecimal xgetPointYValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDecimal target = null;
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(POINTYVALUE$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PointYValue" element
     */
    public void setPointYValue(java.math.BigDecimal pointYValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POINTYVALUE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(POINTYVALUE$2);
            }
            target.setBigDecimalValue(pointYValue);
        }
    }
    
    /**
     * Sets (as xml) the "PointYValue" element
     */
    public void xsetPointYValue(org.apache.xmlbeans.XmlDecimal pointYValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDecimal target = null;
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(POINTYVALUE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(POINTYVALUE$2);
            }
            target.set(pointYValue);
        }
    }
}
