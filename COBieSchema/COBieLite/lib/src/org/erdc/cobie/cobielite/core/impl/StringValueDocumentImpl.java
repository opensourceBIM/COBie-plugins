/*
 * An XML document type.
 * Localname: StringValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.StringValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one StringValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class StringValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.StringValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public StringValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
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
}
