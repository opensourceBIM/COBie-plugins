/*
 * XML Type:  ZoneKeyType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ZoneKeyType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML ZoneKeyType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class ZoneKeyTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieKeyTypeImpl implements org.erdc.cobie.cobielite.core.ZoneKeyType
{
    private static final long serialVersionUID = 1L;
    
    public ZoneKeyTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ZONENAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ZoneName");
    private static final javax.xml.namespace.QName ZONECATEGORY$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ZoneCategory");
    
    
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
    
    /**
     * Gets the "ZoneCategory" element
     */
    public java.lang.String getZoneCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ZONECATEGORY$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ZoneCategory" element
     */
    public org.erdc.cobie.cobielite.core.ZoneCategorySimpleType xgetZoneCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneCategorySimpleType)get_store().find_element_user(ZONECATEGORY$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ZoneCategory" element
     */
    public void setZoneCategory(java.lang.String zoneCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ZONECATEGORY$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ZONECATEGORY$2);
            }
            target.setStringValue(zoneCategory);
        }
    }
    
    /**
     * Sets (as xml) the "ZoneCategory" element
     */
    public void xsetZoneCategory(org.erdc.cobie.cobielite.core.ZoneCategorySimpleType zoneCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneCategorySimpleType)get_store().find_element_user(ZONECATEGORY$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.ZoneCategorySimpleType)get_store().add_element_user(ZONECATEGORY$2);
            }
            target.set(zoneCategory);
        }
    }
}
