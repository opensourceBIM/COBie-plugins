/*
 * An XML document type.
 * Localname: AttributeDateValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeDateValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AttributeDateValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AttributeDateValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AttributeDateValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public AttributeDateValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTEDATEVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeDateValue");
    
    
    /**
     * Gets the "AttributeDateValue" element
     */
    public java.util.Calendar getAttributeDateValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTEDATEVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "AttributeDateValue" element
     */
    public org.apache.xmlbeans.XmlDate xgetAttributeDateValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(ATTRIBUTEDATEVALUE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AttributeDateValue" element
     */
    public void setAttributeDateValue(java.util.Calendar attributeDateValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTEDATEVALUE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ATTRIBUTEDATEVALUE$0);
            }
            target.setCalendarValue(attributeDateValue);
        }
    }
    
    /**
     * Sets (as xml) the "AttributeDateValue" element
     */
    public void xsetAttributeDateValue(org.apache.xmlbeans.XmlDate attributeDateValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(ATTRIBUTEDATEVALUE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDate)get_store().add_element_user(ATTRIBUTEDATEVALUE$0);
            }
            target.set(attributeDateValue);
        }
    }
}
