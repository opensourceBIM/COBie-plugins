/*
 * XML Type:  FloorKeyType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.FloorKeyType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML FloorKeyType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class FloorKeyTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieKeyTypeImpl implements org.erdc.cobie.cobielite.core.FloorKeyType
{
    private static final long serialVersionUID = 1L;
    
    public FloorKeyTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FLOORNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FloorName");
    
    
    /**
     * Gets the "FloorName" element
     */
    public java.lang.String getFloorName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FLOORNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FloorName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetFloorName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(FLOORNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "FloorName" element
     */
    public void setFloorName(java.lang.String floorName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FLOORNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FLOORNAME$0);
            }
            target.setStringValue(floorName);
        }
    }
    
    /**
     * Sets (as xml) the "FloorName" element
     */
    public void xsetFloorName(org.erdc.cobie.cobielite.core.CobieNameSimpleType floorName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(FLOORNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(FLOORNAME$0);
            }
            target.set(floorName);
        }
    }
}
