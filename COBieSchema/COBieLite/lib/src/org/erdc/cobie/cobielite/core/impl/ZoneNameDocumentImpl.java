/*
 * An XML document type.
 * Localname: ZoneName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ZoneNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ZoneName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ZoneNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ZoneNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public ZoneNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ZONENAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ZoneName");
    
    
    /**
     * Gets the "ZoneName" element
     */
    public java.lang.String getZoneName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ZONENAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ZoneName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetZoneName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(ZONENAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ZoneName" element
     */
    public void setZoneName(java.lang.String zoneName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ZONENAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ZONENAME$0);
            }
            target.setStringValue(zoneName);
        }
    }
    
    /**
     * Sets (as xml) the "ZoneName" element
     */
    public void xsetZoneName(org.erdc.cobie.cobielite.core.CobieNameSimpleType zoneName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(ZONENAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(ZONENAME$0);
            }
            target.set(zoneName);
        }
    }
}
