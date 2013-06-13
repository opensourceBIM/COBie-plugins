/*
 * An XML document type.
 * Localname: IntegerValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.IntegerValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one IntegerValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class IntegerValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.IntegerValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public IntegerValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
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
}
