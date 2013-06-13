/*
 * An XML document type.
 * Localname: AttributeTimeValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeTimeValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AttributeTimeValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AttributeTimeValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AttributeTimeValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public AttributeTimeValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTETIMEVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeTimeValue");
    
    
    /**
     * Gets the "AttributeTimeValue" element
     */
    public java.util.Calendar getAttributeTimeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTETIMEVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "AttributeTimeValue" element
     */
    public org.apache.xmlbeans.XmlTime xgetAttributeTimeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlTime target = null;
            target = (org.apache.xmlbeans.XmlTime)get_store().find_element_user(ATTRIBUTETIMEVALUE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AttributeTimeValue" element
     */
    public void setAttributeTimeValue(java.util.Calendar attributeTimeValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTETIMEVALUE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ATTRIBUTETIMEVALUE$0);
            }
            target.setCalendarValue(attributeTimeValue);
        }
    }
    
    /**
     * Sets (as xml) the "AttributeTimeValue" element
     */
    public void xsetAttributeTimeValue(org.apache.xmlbeans.XmlTime attributeTimeValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlTime target = null;
            target = (org.apache.xmlbeans.XmlTime)get_store().find_element_user(ATTRIBUTETIMEVALUE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlTime)get_store().add_element_user(ATTRIBUTETIMEVALUE$0);
            }
            target.set(attributeTimeValue);
        }
    }
}
