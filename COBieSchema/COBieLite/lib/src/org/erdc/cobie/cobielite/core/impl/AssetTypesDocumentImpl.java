/*
 * An XML document type.
 * Localname: AssetTypes
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypes(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypesDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypes");
    
    
    /**
     * Gets the "AssetTypes" element
     */
    public org.erdc.cobie.cobielite.core.AssetTypeCollectionType getAssetTypes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetTypeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetTypeCollectionType)get_store().find_element_user(ASSETTYPES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypes" element
     */
    public void setAssetTypes(org.erdc.cobie.cobielite.core.AssetTypeCollectionType assetTypes)
    {
        generatedSetterHelperImpl(assetTypes, ASSETTYPES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypes" element
     */
    public org.erdc.cobie.cobielite.core.AssetTypeCollectionType addNewAssetTypes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetTypeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetTypeCollectionType)get_store().add_element_user(ASSETTYPES$0);
            return target;
        }
    }
}
