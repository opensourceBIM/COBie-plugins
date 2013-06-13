/*
 * XML Type:  AssetTypeKeyType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeKeyType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML AssetTypeKeyType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class AssetTypeKeyTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieKeyTypeImpl implements org.erdc.cobie.cobielite.core.AssetTypeKeyType
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeKeyTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPENAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeName");
    private static final javax.xml.namespace.QName ASSETTYPECATEGORY$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeCategory");
    
    
    /**
     * Gets the "AssetTypeName" element
     */
    public java.lang.String getAssetTypeName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPENAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetAssetTypeName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(ASSETTYPENAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeName" element
     */
    public void setAssetTypeName(java.lang.String assetTypeName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPENAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPENAME$0);
            }
            target.setStringValue(assetTypeName);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeName" element
     */
    public void xsetAssetTypeName(org.erdc.cobie.cobielite.core.CobieNameSimpleType assetTypeName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(ASSETTYPENAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(ASSETTYPENAME$0);
            }
            target.set(assetTypeName);
        }
    }
    
    /**
     * Gets the "AssetTypeCategory" element
     */
    public java.lang.String getAssetTypeCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPECATEGORY$2, 0);
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
            target = (org.erdc.cobie.cobielite.core.AssetCategorySimpleType)get_store().find_element_user(ASSETTYPECATEGORY$2, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPECATEGORY$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPECATEGORY$2);
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
            target = (org.erdc.cobie.cobielite.core.AssetCategorySimpleType)get_store().find_element_user(ASSETTYPECATEGORY$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.AssetCategorySimpleType)get_store().add_element_user(ASSETTYPECATEGORY$2);
            }
            target.set(assetTypeCategory);
        }
    }
}
