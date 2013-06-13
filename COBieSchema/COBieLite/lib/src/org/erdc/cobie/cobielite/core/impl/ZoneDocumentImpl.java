/*
 * An XML document type.
 * Localname: Zone
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ZoneDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Zone(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ZoneDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ZoneDocument
{
    private static final long serialVersionUID = 1L;
    
    public ZoneDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ZONE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Zone");
    private static final org.apache.xmlbeans.QNameSet ZONE$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://zone.cobielite.cobie.erdc.org", "Zone"),
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Zone"),
    });
    
    
    /**
     * Gets the "Zone" element
     */
    public org.erdc.cobie.cobielite.core.ZoneType getZone()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneType)get_store().find_element_user(ZONE$1, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Zone" element
     */
    public void setZone(org.erdc.cobie.cobielite.core.ZoneType zone)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneType)get_store().find_element_user(ZONE$1, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.ZoneType)get_store().add_element_user(ZONE$0);
            }
            target.set(zone);
        }
    }
    
    /**
     * Appends and returns a new empty "Zone" element
     */
    public org.erdc.cobie.cobielite.core.ZoneType addNewZone()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneType)get_store().add_element_user(ZONE$0);
            return target;
        }
    }
}
