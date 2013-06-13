/*
 * An XML document type.
 * Localname: AssetType
 * Namespace: http://assettype.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.assettype.AssetTypeDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.assettype.impl;
/**
 * A document containing one AssetType(@http://assettype.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeDocumentImpl extends org.erdc.cobie.cobielite.core.impl.AssetTypeDocumentImpl implements org.erdc.cobie.cobielite.assettype.AssetTypeDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPE2$0 = 
        new javax.xml.namespace.QName("http://assettype.cobielite.cobie.erdc.org", "AssetType");
    
    
    /**
     * Gets the "AssetType" element
     */
    public org.erdc.cobie.cobielite.assettype.AssetTypeInfoType getAssetType2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.assettype.AssetTypeInfoType target = null;
            target = (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType)get_store().find_element_user(ASSETTYPE2$0, 0);
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
    public void setAssetType2(org.erdc.cobie.cobielite.assettype.AssetTypeInfoType assetType2)
    {
        generatedSetterHelperImpl(assetType2, ASSETTYPE2$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetType" element
     */
    public org.erdc.cobie.cobielite.assettype.AssetTypeInfoType addNewAssetType2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.assettype.AssetTypeInfoType target = null;
            target = (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType)get_store().add_element_user(ASSETTYPE2$0);
            return target;
        }
    }
}
