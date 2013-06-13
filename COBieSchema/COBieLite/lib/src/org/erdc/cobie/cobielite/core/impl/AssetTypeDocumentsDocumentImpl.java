/*
 * An XML document type.
 * Localname: AssetTypeDocuments
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeDocumentsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypeDocuments(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeDocumentsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeDocumentsDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeDocumentsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPEDOCUMENTS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeDocuments");
    
    
    /**
     * Gets the "AssetTypeDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getAssetTypeDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(ASSETTYPEDOCUMENTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeDocuments" element
     */
    public void setAssetTypeDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType assetTypeDocuments)
    {
        generatedSetterHelperImpl(assetTypeDocuments, ASSETTYPEDOCUMENTS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypeDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewAssetTypeDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(ASSETTYPEDOCUMENTS$0);
            return target;
        }
    }
}
