/*
 * An XML document type.
 * Localname: AssetInstallationDate
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetInstallationDateDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetInstallationDate(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetInstallationDateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetInstallationDateDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetInstallationDateDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETINSTALLATIONDATE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetInstallationDate");
    
    
    /**
     * Gets the "AssetInstallationDate" element
     */
    public java.util.Calendar getAssetInstallationDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETINSTALLATIONDATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetInstallationDate" element
     */
    public org.apache.xmlbeans.XmlDate xgetAssetInstallationDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(ASSETINSTALLATIONDATE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetInstallationDate" element
     */
    public void setAssetInstallationDate(java.util.Calendar assetInstallationDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETINSTALLATIONDATE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETINSTALLATIONDATE$0);
            }
            target.setCalendarValue(assetInstallationDate);
        }
    }
    
    /**
     * Sets (as xml) the "AssetInstallationDate" element
     */
    public void xsetAssetInstallationDate(org.apache.xmlbeans.XmlDate assetInstallationDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(ASSETINSTALLATIONDATE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDate)get_store().add_element_user(ASSETINSTALLATIONDATE$0);
            }
            target.set(assetInstallationDate);
        }
    }
}
