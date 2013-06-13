/*
 * An XML document type.
 * Localname: AssetBarCode
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetBarCodeDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetBarCode(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetBarCodeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetBarCodeDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetBarCodeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETBARCODE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetBarCode");
    
    
    /**
     * Gets the "AssetBarCode" element
     */
    public java.lang.String getAssetBarCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETBARCODE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetBarCode" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetBarCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETBARCODE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetBarCode" element
     */
    public void setAssetBarCode(java.lang.String assetBarCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETBARCODE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETBARCODE$0);
            }
            target.setStringValue(assetBarCode);
        }
    }
    
    /**
     * Sets (as xml) the "AssetBarCode" element
     */
    public void xsetAssetBarCode(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetBarCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETBARCODE$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETBARCODE$0);
            }
            target.set(assetBarCode);
        }
    }
}
