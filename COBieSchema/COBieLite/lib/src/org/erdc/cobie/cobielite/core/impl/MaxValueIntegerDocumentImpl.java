/*
 * An XML document type.
 * Localname: MaxValueInteger
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.MaxValueIntegerDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one MaxValueInteger(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class MaxValueIntegerDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.MaxValueIntegerDocument
{
    private static final long serialVersionUID = 1L;
    
    public MaxValueIntegerDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MAXVALUEINTEGER$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "MaxValueInteger");
    
    
    /**
     * Gets the "MaxValueInteger" element
     */
    public java.math.BigInteger getMaxValueInteger()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MAXVALUEINTEGER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getBigIntegerValue();
        }
    }
    
    /**
     * Gets (as xml) the "MaxValueInteger" element
     */
    public org.apache.xmlbeans.XmlInteger xgetMaxValueInteger()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInteger target = null;
            target = (org.apache.xmlbeans.XmlInteger)get_store().find_element_user(MAXVALUEINTEGER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "MaxValueInteger" element
     */
    public void setMaxValueInteger(java.math.BigInteger maxValueInteger)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MAXVALUEINTEGER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MAXVALUEINTEGER$0);
            }
            target.setBigIntegerValue(maxValueInteger);
        }
    }
    
    /**
     * Sets (as xml) the "MaxValueInteger" element
     */
    public void xsetMaxValueInteger(org.apache.xmlbeans.XmlInteger maxValueInteger)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInteger target = null;
            target = (org.apache.xmlbeans.XmlInteger)get_store().find_element_user(MAXVALUEINTEGER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlInteger)get_store().add_element_user(MAXVALUEINTEGER$0);
            }
            target.set(maxValueInteger);
        }
    }
}
