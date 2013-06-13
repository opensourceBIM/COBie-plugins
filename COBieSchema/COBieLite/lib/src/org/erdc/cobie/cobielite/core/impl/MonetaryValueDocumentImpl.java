/*
 * An XML document type.
 * Localname: MonetaryValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.MonetaryValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one MonetaryValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class MonetaryValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.MonetaryValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public MonetaryValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MONETARYVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "MonetaryValue");
    
    
    /**
     * Gets the "MonetaryValue" element
     */
    public java.math.BigDecimal getMonetaryValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MONETARYVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getBigDecimalValue();
        }
    }
    
    /**
     * Gets (as xml) the "MonetaryValue" element
     */
    public org.erdc.cobie.cobielite.core.MonetaryValueSimpleType xgetMonetaryValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.MonetaryValueSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.MonetaryValueSimpleType)get_store().find_element_user(MONETARYVALUE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "MonetaryValue" element
     */
    public void setMonetaryValue(java.math.BigDecimal monetaryValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MONETARYVALUE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MONETARYVALUE$0);
            }
            target.setBigDecimalValue(monetaryValue);
        }
    }
    
    /**
     * Sets (as xml) the "MonetaryValue" element
     */
    public void xsetMonetaryValue(org.erdc.cobie.cobielite.core.MonetaryValueSimpleType monetaryValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.MonetaryValueSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.MonetaryValueSimpleType)get_store().find_element_user(MONETARYVALUE$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.MonetaryValueSimpleType)get_store().add_element_user(MONETARYVALUE$0);
            }
            target.set(monetaryValue);
        }
    }
}
