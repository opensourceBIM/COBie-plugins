/*
 * An XML document type.
 * Localname: Asset
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Asset(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSET$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Asset");
    private static final org.apache.xmlbeans.QNameSet ASSET$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://asset.cobielite.cobie.erdc.org", "Asset"),
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Asset"),
    });
    
    
    /**
     * Gets the "Asset" element
     */
    public org.erdc.cobie.cobielite.core.AssetInfoType getAsset()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetInfoType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetInfoType)get_store().find_element_user(ASSET$1, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Asset" element
     */
    public void setAsset(org.erdc.cobie.cobielite.core.AssetInfoType asset)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetInfoType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetInfoType)get_store().find_element_user(ASSET$1, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.AssetInfoType)get_store().add_element_user(ASSET$0);
            }
            target.set(asset);
        }
    }
    
    /**
     * Appends and returns a new empty "Asset" element
     */
    public org.erdc.cobie.cobielite.core.AssetInfoType addNewAsset()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetInfoType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetInfoType)get_store().add_element_user(ASSET$0);
            return target;
        }
    }
}
