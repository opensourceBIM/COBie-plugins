/*
 * An XML document type.
 * Localname: SiteName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SiteNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SiteName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SiteNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SiteNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public SiteNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SITENAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SiteName");
    
    
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
}
