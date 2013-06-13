/*
 * An XML document type.
 * Localname: AssetType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetType(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetType");
    private static final org.apache.xmlbeans.QNameSet ASSETTYPE$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://assettype.cobielite.cobie.erdc.org", "AssetType"),
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetType"),
    });
    
    
    /**
     * Gets the "AssetType" element
     */
    public org.erdc.cobie.cobielite.core.AssetTypeInfoType getAssetType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetTypeInfoType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetTypeInfoType)get_store().find_element_user(ASSETTYPE$1, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AssetType" element
     */
    public void setAssetType(org.erdc.cobie.cobielite.core.AssetTypeInfoType assetType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetTypeInfoType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetTypeInfoType)get_store().find_element_user(ASSETTYPE$1, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.AssetTypeInfoType)get_store().add_element_user(ASSETTYPE$0);
            }
            target.set(assetType);
        }
    }
    
    /**
     * Appends and returns a new empty "AssetType" element
     */
    public org.erdc.cobie.cobielite.core.AssetTypeInfoType addNewAssetType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetTypeInfoType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetTypeInfoType)get_store().add_element_user(ASSETTYPE$0);
            return target;
        }
    }
}
