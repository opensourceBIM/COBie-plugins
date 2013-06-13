/*
 * An XML document type.
 * Localname: AssetTypeAttributes
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeAttributesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypeAttributes(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeAttributesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeAttributesDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeAttributesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPEATTRIBUTES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeAttributes");
    
    
    /**
     * Gets the "AssetTypeAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getAssetTypeAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(ASSETTYPEATTRIBUTES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeAttributes" element
     */
    public void setAssetTypeAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType assetTypeAttributes)
    {
        generatedSetterHelperImpl(assetTypeAttributes, ASSETTYPEATTRIBUTES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypeAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewAssetTypeAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(ASSETTYPEATTRIBUTES$0);
            return target;
        }
    }
}
