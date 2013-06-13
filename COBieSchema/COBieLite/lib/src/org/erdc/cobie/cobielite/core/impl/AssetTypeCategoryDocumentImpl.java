/*
 * An XML document type.
 * Localname: AssetTypeCategory
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeCategoryDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypeCategory(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeCategoryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeCategoryDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeCategoryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPECATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeCategory");
    
    
    /**
     * Gets the "AssetTypeCategory" element
     */
    public java.lang.String getAssetTypeCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPECATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeCategory" element
     */
    public org.erdc.cobie.cobielite.core.AssetCategorySimpleType xgetAssetTypeCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetCategorySimpleType)get_store().find_element_user(ASSETTYPECATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeCategory" element
     */
    public void setAssetTypeCategory(java.lang.String assetTypeCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPECATEGORY$0);
            }
            target.setStringValue(assetTypeCategory);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeCategory" element
     */
    public void xsetAssetTypeCategory(org.erdc.cobie.cobielite.core.AssetCategorySimpleType assetTypeCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetCategorySimpleType)get_store().find_element_user(ASSETTYPECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.AssetCategorySimpleType)get_store().add_element_user(ASSETTYPECATEGORY$0);
            }
            target.set(assetTypeCategory);
        }
    }
}
