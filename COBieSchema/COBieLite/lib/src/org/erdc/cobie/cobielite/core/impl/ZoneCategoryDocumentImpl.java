/*
 * An XML document type.
 * Localname: ZoneCategory
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ZoneCategoryDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ZoneCategory(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ZoneCategoryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ZoneCategoryDocument
{
    private static final long serialVersionUID = 1L;
    
    public ZoneCategoryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ZONECATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ZoneCategory");
    
    
    /**
     * Gets the "ZoneCategory" element
     */
    public java.lang.String getZoneCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ZONECATEGORY$0, 0);
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
            target = (org.erdc.cobie.cobielite.core.ZoneCategorySimpleType)get_store().find_element_user(ZONECATEGORY$0, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ZONECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ZONECATEGORY$0);
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
            target = (org.erdc.cobie.cobielite.core.ZoneCategorySimpleType)get_store().find_element_user(ZONECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.ZoneCategorySimpleType)get_store().add_element_user(ZONECATEGORY$0);
            }
            target.set(zoneCategory);
        }
    }
}
