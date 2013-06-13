/*
 * XML Type:  SiteType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SiteType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML SiteType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class SiteTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieBaseTypeImpl implements org.erdc.cobie.cobielite.core.SiteType
{
    private static final long serialVersionUID = 1L;
    
    public SiteTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SITENAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SiteName");
    private static final javax.xml.namespace.QName SITEDESCRIPTION$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SiteDescription");
    
    
    /**
     * Gets the "SiteName" element
     */
    public java.lang.String getSiteName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SITENAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SiteName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetSiteName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(SITENAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SiteName" element
     */
    public void setSiteName(java.lang.String siteName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SITENAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SITENAME$0);
            }
            target.setStringValue(siteName);
        }
    }
    
    /**
     * Sets (as xml) the "SiteName" element
     */
    public void xsetSiteName(org.erdc.cobie.cobielite.core.CobieNameSimpleType siteName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(SITENAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(SITENAME$0);
            }
            target.set(siteName);
        }
    }
    
    /**
     * Gets the "SiteDescription" element
     */
    public java.lang.String getSiteDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SITEDESCRIPTION$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SiteDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetSiteDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(SITEDESCRIPTION$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "SiteDescription" element
     */
    public boolean isSetSiteDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SITEDESCRIPTION$2) != 0;
        }
    }
    
    /**
     * Sets the "SiteDescription" element
     */
    public void setSiteDescription(java.lang.String siteDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SITEDESCRIPTION$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SITEDESCRIPTION$2);
            }
            target.setStringValue(siteDescription);
        }
    }
    
    /**
     * Sets (as xml) the "SiteDescription" element
     */
    public void xsetSiteDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType siteDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(SITEDESCRIPTION$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(SITEDESCRIPTION$2);
            }
            target.set(siteDescription);
        }
    }
    
    /**
     * Unsets the "SiteDescription" element
     */
    public void unsetSiteDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SITEDESCRIPTION$2, 0);
        }
    }
}
