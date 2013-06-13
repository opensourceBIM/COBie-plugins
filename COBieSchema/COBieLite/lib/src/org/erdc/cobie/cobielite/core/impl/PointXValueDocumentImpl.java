/*
 * An XML document type.
 * Localname: PointXValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.PointXValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one PointXValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class PointXValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.PointXValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public PointXValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName POINTXVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "PointXValue");
    
    
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
}
