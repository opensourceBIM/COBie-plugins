/*
 * An XML document type.
 * Localname: AssetTypeColorCode
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeColorCodeDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypeColorCode(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeColorCodeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeColorCodeDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeColorCodeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPECOLORCODE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeColorCode");
    
    
    /**
     * Gets the "AssetTypeColorCode" element
     */
    public java.lang.String getAssetTypeColorCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPECOLORCODE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeColorCode" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetTypeColorCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTYPECOLORCODE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeColorCode" element
     */
    public void setAssetTypeColorCode(java.lang.String assetTypeColorCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPECOLORCODE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPECOLORCODE$0);
            }
            target.setStringValue(assetTypeColorCode);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeColorCode" element
     */
    public void xsetAssetTypeColorCode(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetTypeColorCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTYPECOLORCODE$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETTYPECOLORCODE$0);
            }
            target.set(assetTypeColorCode);
        }
    }
}
