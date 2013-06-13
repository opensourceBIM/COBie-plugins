/*
 * An XML document type.
 * Localname: Zone
 * Namespace: http://zone.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.zone.ZoneDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.zone.impl;
/**
 * A document containing one Zone(@http://zone.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ZoneDocumentImpl extends org.erdc.cobie.cobielite.core.impl.ZoneDocumentImpl implements org.erdc.cobie.cobielite.zone.ZoneDocument
{
    private static final long serialVersionUID = 1L;
    
    public ZoneDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ZONE2$0 = 
        new javax.xml.namespace.QName("http://zone.cobielite.cobie.erdc.org", "Zone");
    
    
    /**
     * Gets the "Zone" element
     */
    public org.erdc.cobie.cobielite.zone.ZoneType getZone2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.zone.ZoneType target = null;
            target = (org.erdc.cobie.cobielite.zone.ZoneType)get_store().find_element_user(ZONE2$0, 0);
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
    public void setZone2(org.erdc.cobie.cobielite.zone.ZoneType zone2)
    {
        generatedSetterHelperImpl(zone2, ZONE2$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Zone" element
     */
    public org.erdc.cobie.cobielite.zone.ZoneType addNewZone2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.zone.ZoneType target = null;
            target = (org.erdc.cobie.cobielite.zone.ZoneType)get_store().add_element_user(ZONE2$0);
            return target;
        }
    }
}
