/*
 * An XML document type.
 * Localname: AssetSerialNumber
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetSerialNumberDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetSerialNumber(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetSerialNumberDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetSerialNumberDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetSerialNumberDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETSERIALNUMBER$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetSerialNumber");
    
    
    /**
     * Gets the "AssetSerialNumber" element
     */
    public java.lang.String getAssetSerialNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETSERIALNUMBER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetSerialNumber" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetSerialNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETSERIALNUMBER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetSerialNumber" element
     */
    public void setAssetSerialNumber(java.lang.String assetSerialNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETSERIALNUMBER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETSERIALNUMBER$0);
            }
            target.setStringValue(assetSerialNumber);
        }
    }
    
    /**
     * Sets (as xml) the "AssetSerialNumber" element
     */
    public void xsetAssetSerialNumber(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetSerialNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETSERIALNUMBER$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETSERIALNUMBER$0);
            }
            target.set(assetSerialNumber);
        }
    }
}
