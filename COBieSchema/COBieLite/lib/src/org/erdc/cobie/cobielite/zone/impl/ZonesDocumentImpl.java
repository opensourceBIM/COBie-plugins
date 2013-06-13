/*
 * An XML document type.
 * Localname: Zones
 * Namespace: http://zone.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.zone.ZonesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.zone.impl;
/**
 * A document containing one Zones(@http://zone.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ZonesDocumentImpl extends org.erdc.cobie.cobielite.core.impl.ZonesDocumentImpl implements org.erdc.cobie.cobielite.zone.ZonesDocument
{
    private static final long serialVersionUID = 1L;
    
    public ZonesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ZONES2$0 = 
        new javax.xml.namespace.QName("http://zone.cobielite.cobie.erdc.org", "Zones");
    
    
    /**
     * Gets the "Zones" element
     */
    public org.erdc.cobie.cobielite.core.ZoneCollectionType getZones2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneCollectionType)get_store().find_element_user(ZONES2$0, 0);
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
    public void setZones2(org.erdc.cobie.cobielite.core.ZoneCollectionType zones2)
    {
        generatedSetterHelperImpl(zones2, ZONES2$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Zones" element
     */
    public org.erdc.cobie.cobielite.core.ZoneCollectionType addNewZones2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneCollectionType)get_store().add_element_user(ZONES2$0);
            return target;
        }
    }
}
