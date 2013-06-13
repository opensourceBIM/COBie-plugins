/*
 * An XML document type.
 * Localname: PointYValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.PointYValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one PointYValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class PointYValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.PointYValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public PointYValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName POINTYVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "PointYValue");
    
    
    /**
     * Gets the "PointYValue" element
     */
    public java.math.BigDecimal getPointYValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POINTYVALUE$0, 0);
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
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(POINTYVALUE$0, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POINTYVALUE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(POINTYVALUE$0);
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
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(POINTYVALUE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(POINTYVALUE$0);
            }
            target.set(pointYValue);
        }
    }
}
