/*
 * XML Type:  BooleanValueType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.BooleanValueType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML BooleanValueType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class BooleanValueTypeImpl extends org.erdc.cobie.cobielite.core.impl.ValueBaseTypeImpl implements org.erdc.cobie.cobielite.core.BooleanValueType
{
    private static final long serialVersionUID = 1L;
    
    public BooleanValueTypeImpl(org.apache.xmlbeans.SchemaType sType)
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
     * True if has "BooleanValue" element
     */
    public boolean isSetBooleanValue1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(BOOLEANVALUE1$0) != 0;
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
    
    /**
     * Unsets the "BooleanValue" element
     */
    public void unsetBooleanValue1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(BOOLEANVALUE1$0, 0);
        }
    }
}
