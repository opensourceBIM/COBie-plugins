/*
 * An XML document type.
 * Localname: Assets
 * Namespace: http://asset.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.asset.AssetsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.asset.impl;
/**
 * A document containing one Assets(@http://asset.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetsDocumentImpl extends org.erdc.cobie.cobielite.core.impl.AssetsDocumentImpl implements org.erdc.cobie.cobielite.asset.AssetsDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETS2$0 = 
        new javax.xml.namespace.QName("http://asset.cobielite.cobie.erdc.org", "Assets");
    
    
    /**
     * Gets the "Assets" element
     */
    public org.erdc.cobie.cobielite.core.AssetCollectionType getAssets2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetCollectionType)get_store().find_element_user(ASSETS2$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Assets" element
     */
    public void setAssets2(org.erdc.cobie.cobielite.core.AssetCollectionType assets2)
    {
        generatedSetterHelperImpl(assets2, ASSETS2$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Assets" element
     */
    public org.erdc.cobie.cobielite.core.AssetCollectionType addNewAssets2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetCollectionType)get_store().add_element_user(ASSETS2$0);
            return target;
        }
    }
}
