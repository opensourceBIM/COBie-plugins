/*
 * An XML document type.
 * Localname: MinValueInteger
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.MinValueIntegerDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one MinValueInteger(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class MinValueIntegerDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.MinValueIntegerDocument
{
    private static final long serialVersionUID = 1L;
    
    public MinValueIntegerDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MINVALUEINTEGER$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "MinValueInteger");
    
    
    /**
     * Gets the "MinValueInteger" element
     */
    public java.math.BigInteger getMinValueInteger()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MINVALUEINTEGER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getBigIntegerValue();
        }
    }
    
    /**
     * Gets (as xml) the "MinValueInteger" element
     */
    public org.apache.xmlbeans.XmlInteger xgetMinValueInteger()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInteger target = null;
            target = (org.apache.xmlbeans.XmlInteger)get_store().find_element_user(MINVALUEINTEGER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "MinValueInteger" element
     */
    public void setMinValueInteger(java.math.BigInteger minValueInteger)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MINVALUEINTEGER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MINVALUEINTEGER$0);
            }
            target.setBigIntegerValue(minValueInteger);
        }
    }
    
    /**
     * Sets (as xml) the "MinValueInteger" element
     */
    public void xsetMinValueInteger(org.apache.xmlbeans.XmlInteger minValueInteger)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInteger target = null;
            target = (org.apache.xmlbeans.XmlInteger)get_store().find_element_user(MINVALUEINTEGER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlInteger)get_store().add_element_user(MINVALUEINTEGER$0);
            }
            target.set(minValueInteger);
        }
    }
}
