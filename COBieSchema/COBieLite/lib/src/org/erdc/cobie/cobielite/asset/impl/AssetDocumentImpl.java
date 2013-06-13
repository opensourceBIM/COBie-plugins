/*
 * An XML document type.
 * Localname: Asset
 * Namespace: http://asset.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.asset.AssetDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.asset.impl;
/**
 * A document containing one Asset(@http://asset.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetDocumentImpl extends org.erdc.cobie.cobielite.core.impl.AssetDocumentImpl implements org.erdc.cobie.cobielite.asset.AssetDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSET2$0 = 
        new javax.xml.namespace.QName("http://asset.cobielite.cobie.erdc.org", "Asset");
    
    
    /**
     * Gets the "Asset" element
     */
    public org.erdc.cobie.cobielite.asset.AssetInfoType getAsset2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.asset.AssetInfoType target = null;
            target = (org.erdc.cobie.cobielite.asset.AssetInfoType)get_store().find_element_user(ASSET2$0, 0);
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
    public void setAsset2(org.erdc.cobie.cobielite.asset.AssetInfoType asset2)
    {
        generatedSetterHelperImpl(asset2, ASSET2$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Asset" element
     */
    public org.erdc.cobie.cobielite.asset.AssetInfoType addNewAsset2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.asset.AssetInfoType target = null;
            target = (org.erdc.cobie.cobielite.asset.AssetInfoType)get_store().add_element_user(ASSET2$0);
            return target;
        }
    }
}
