/*
 * An XML document type.
 * Localname: AttributeDateTimeValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeDateTimeValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AttributeDateTimeValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AttributeDateTimeValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AttributeDateTimeValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public AttributeDateTimeValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTEDATETIMEVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeDateTimeValue");
    
    
    /**
     * Gets the "AttributeDateTimeValue" element
     */
    public java.util.Calendar getAttributeDateTimeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTEDATETIMEVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "AttributeDateTimeValue" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetAttributeDateTimeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(ATTRIBUTEDATETIMEVALUE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AttributeDateTimeValue" element
     */
    public void setAttributeDateTimeValue(java.util.Calendar attributeDateTimeValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTEDATETIMEVALUE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ATTRIBUTEDATETIMEVALUE$0);
            }
            target.setCalendarValue(attributeDateTimeValue);
        }
    }
    
    /**
     * Sets (as xml) the "AttributeDateTimeValue" element
     */
    public void xsetAttributeDateTimeValue(org.apache.xmlbeans.XmlDateTime attributeDateTimeValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(ATTRIBUTEDATETIMEVALUE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(ATTRIBUTEDATETIMEVALUE$0);
            }
            target.set(attributeDateTimeValue);
        }
    }
}
