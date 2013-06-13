/*
 * XML Type:  StringValueType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.StringValueType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML StringValueType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class StringValueTypeImpl extends org.erdc.cobie.cobielite.core.impl.ValueBaseTypeImpl implements org.erdc.cobie.cobielite.core.StringValueType
{
    private static final long serialVersionUID = 1L;
    
    public StringValueTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName STRINGVALUE1$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "StringValue");
    
    
    /**
     * Gets the "StringValue" element
     */
    public java.lang.String getStringValue1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STRINGVALUE1$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "StringValue" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetStringValue1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(STRINGVALUE1$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "StringValue" element
     */
    public boolean isSetStringValue1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(STRINGVALUE1$0) != 0;
        }
    }
    
    /**
     * Sets the "StringValue" element
     */
    public void setStringValue1(java.lang.String stringValue1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STRINGVALUE1$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(STRINGVALUE1$0);
            }
            target.setStringValue(stringValue1);
        }
    }
    
    /**
     * Sets (as xml) the "StringValue" element
     */
    public void xsetStringValue1(org.erdc.cobie.cobielite.core.CobieTextSimpleType stringValue1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(STRINGVALUE1$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(STRINGVALUE1$0);
            }
            target.set(stringValue1);
        }
    }
    
    /**
     * Unsets the "StringValue" element
     */
    public void unsetStringValue1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(STRINGVALUE1$0, 0);
        }
    }
}
