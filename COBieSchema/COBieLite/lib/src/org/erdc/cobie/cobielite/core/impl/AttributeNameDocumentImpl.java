/*
 * An XML document type.
 * Localname: AttributeName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AttributeName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AttributeNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AttributeNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public AttributeNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTENAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeName");
    
    
    /**
     * Gets the "AttributeName" element
     */
    public java.lang.String getAttributeName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTENAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AttributeName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetAttributeName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(ATTRIBUTENAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AttributeName" element
     */
    public void setAttributeName(java.lang.String attributeName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTENAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ATTRIBUTENAME$0);
            }
            target.setStringValue(attributeName);
        }
    }
    
    /**
     * Sets (as xml) the "AttributeName" element
     */
    public void xsetAttributeName(org.erdc.cobie.cobielite.core.CobieNameSimpleType attributeName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(ATTRIBUTENAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(ATTRIBUTENAME$0);
            }
            target.set(attributeName);
        }
    }
}
