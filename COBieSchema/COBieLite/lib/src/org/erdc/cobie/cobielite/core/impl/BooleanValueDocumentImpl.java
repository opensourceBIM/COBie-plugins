/*
 * An XML document type.
 * Localname: BooleanValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.BooleanValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one BooleanValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class BooleanValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.BooleanValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public BooleanValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName BOOLEANVALUE1$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "BooleanValue");
    
    
    /**
     * Gets the "BooleanValue" element
     */
    public boolean getBooleanValue1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BOOLEANVALUE1$0, 0);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "BooleanValue" element
     */
    public org.apache.xmlbeans.XmlBoolean xgetBooleanValue1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(BOOLEANVALUE1$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "BooleanValue" element
     */
    public void setBooleanValue1(boolean booleanValue1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BOOLEANVALUE1$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(BOOLEANVALUE1$0);
            }
            target.setBooleanValue(booleanValue1);
        }
    }
    
    /**
     * Sets (as xml) the "BooleanValue" element
     */
    public void xsetBooleanValue1(org.apache.xmlbeans.XmlBoolean booleanValue1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(BOOLEANVALUE1$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(BOOLEANVALUE1$0);
            }
            target.set(booleanValue1);
        }
    }
}
