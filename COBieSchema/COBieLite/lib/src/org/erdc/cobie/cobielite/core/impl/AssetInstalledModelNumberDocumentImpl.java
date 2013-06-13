/*
 * An XML document type.
 * Localname: AssetInstalledModelNumber
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetInstalledModelNumberDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetInstalledModelNumber(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetInstalledModelNumberDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetInstalledModelNumberDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetInstalledModelNumberDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETINSTALLEDMODELNUMBER$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetInstalledModelNumber");
    
    
    /**
     * Gets the "AssetInstalledModelNumber" element
     */
    public java.lang.String getAssetInstalledModelNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETINSTALLEDMODELNUMBER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetInstalledModelNumber" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetInstalledModelNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETINSTALLEDMODELNUMBER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetInstalledModelNumber" element
     */
    public void setAssetInstalledModelNumber(java.lang.String assetInstalledModelNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETINSTALLEDMODELNUMBER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETINSTALLEDMODELNUMBER$0);
            }
            target.setStringValue(assetInstalledModelNumber);
        }
    }
    
    /**
     * Sets (as xml) the "AssetInstalledModelNumber" element
     */
    public void xsetAssetInstalledModelNumber(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetInstalledModelNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETINSTALLEDMODELNUMBER$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETINSTALLEDMODELNUMBER$0);
            }
            target.set(assetInstalledModelNumber);
        }
    }
}
