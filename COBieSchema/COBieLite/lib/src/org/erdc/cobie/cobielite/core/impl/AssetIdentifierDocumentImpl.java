/*
 * An XML document type.
 * Localname: AssetIdentifier
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetIdentifierDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetIdentifier(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetIdentifierDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetIdentifierDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetIdentifierDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETIDENTIFIER$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetIdentifier");
    
    
    /**
     * Gets the "AssetIdentifier" element
     */
    public java.lang.String getAssetIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETIDENTIFIER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetIdentifier" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETIDENTIFIER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetIdentifier" element
     */
    public void setAssetIdentifier(java.lang.String assetIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETIDENTIFIER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETIDENTIFIER$0);
            }
            target.setStringValue(assetIdentifier);
        }
    }
    
    /**
     * Sets (as xml) the "AssetIdentifier" element
     */
    public void xsetAssetIdentifier(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETIDENTIFIER$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETIDENTIFIER$0);
            }
            target.set(assetIdentifier);
        }
    }
}
