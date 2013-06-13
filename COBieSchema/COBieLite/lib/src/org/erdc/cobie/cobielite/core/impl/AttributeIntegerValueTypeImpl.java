/*
 * XML Type:  AttributeIntegerValueType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeIntegerValueType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML AttributeIntegerValueType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class AttributeIntegerValueTypeImpl extends org.erdc.cobie.cobielite.core.impl.IntegerValueTypeImpl implements org.erdc.cobie.cobielite.core.AttributeIntegerValueType
{
    private static final long serialVersionUID = 1L;
    
    public AttributeIntegerValueTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MINVALUEINTEGER$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "MinValueInteger");
    private static final javax.xml.namespace.QName MAXVALUEINTEGER$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "MaxValueInteger");
    
    
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
     * True if has "MinValueInteger" element
     */
    public boolean isSetMinValueInteger()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(MINVALUEINTEGER$0) != 0;
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
    
    /**
     * Unsets the "MinValueInteger" element
     */
    public void unsetMinValueInteger()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(MINVALUEINTEGER$0, 0);
        }
    }
    
    /**
     * Gets the "MaxValueInteger" element
     */
    public java.math.BigInteger getMaxValueInteger()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MAXVALUEINTEGER$2, 0);
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
            target = (org.apache.xmlbeans.XmlInteger)get_store().find_element_user(MAXVALUEINTEGER$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "MaxValueInteger" element
     */
    public boolean isSetMaxValueInteger()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(MAXVALUEINTEGER$2) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MAXVALUEINTEGER$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MAXVALUEINTEGER$2);
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
            target = (org.apache.xmlbeans.XmlInteger)get_store().find_element_user(MAXVALUEINTEGER$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlInteger)get_store().add_element_user(MAXVALUEINTEGER$2);
            }
            target.set(maxValueInteger);
        }
    }
    
    /**
     * Unsets the "MaxValueInteger" element
     */
    public void unsetMaxValueInteger()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(MAXVALUEINTEGER$2, 0);
        }
    }
}
