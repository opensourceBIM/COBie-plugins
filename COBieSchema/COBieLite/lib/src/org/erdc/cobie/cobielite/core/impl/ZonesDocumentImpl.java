/*
 * An XML document type.
 * Localname: Zones
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ZonesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Zones(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ZonesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ZonesDocument
{
    private static final long serialVersionUID = 1L;
    
    public ZonesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ZONES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Zones");
    private static final org.apache.xmlbeans.QNameSet ZONES$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://zone.cobielite.cobie.erdc.org", "Zones"),
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Zones"),
    });
    
    
    /**
     * Gets the "Zones" element
     */
    public org.erdc.cobie.cobielite.core.ZoneCollectionType getZones()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneCollectionType)get_store().find_element_user(ZONES$1, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Zones" element
     */
    public void setZones(org.erdc.cobie.cobielite.core.ZoneCollectionType zones)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneCollectionType)get_store().find_element_user(ZONES$1, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.ZoneCollectionType)get_store().add_element_user(ZONES$0);
            }
            target.set(zones);
        }
    }
    
    /**
     * Appends and returns a new empty "Zones" element
     */
    public org.erdc.cobie.cobielite.core.ZoneCollectionType addNewZones()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneCollectionType)get_store().add_element_user(ZONES$0);
            return target;
        }
    }
}
