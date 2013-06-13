/*
 * An XML document type.
 * Localname: Assets
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Assets(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetsDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Assets");
    
    
    /**
     * Gets the "Assets" element
     */
    public org.erdc.cobie.cobielite.core.AssetCollectionType getAssets()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetCollectionType)get_store().find_element_user(ASSETS$0, 0);
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
    public void setAssets(org.erdc.cobie.cobielite.core.AssetCollectionType assets)
    {
        generatedSetterHelperImpl(assets, ASSETS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Assets" element
     */
    public org.erdc.cobie.cobielite.core.AssetCollectionType addNewAssets()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetCollectionType)get_store().add_element_user(ASSETS$0);
            return target;
        }
    }
}
