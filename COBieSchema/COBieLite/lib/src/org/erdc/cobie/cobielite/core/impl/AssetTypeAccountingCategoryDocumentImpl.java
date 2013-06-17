/*
 * An XML document type.
 * Localname: AssetTypeAccountingCategory
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeAccountingCategoryDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypeAccountingCategory(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeAccountingCategoryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeAccountingCategoryDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeAccountingCategoryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPEACCOUNTINGCATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeAccountingCategory");
    
    
    /**
     * Gets the "AssetTypeAccountingCategory" element
     */
    public org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType.Enum getAssetTypeAccountingCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEACCOUNTINGCATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return (org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeAccountingCategory" element
     */
    public org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType xgetAssetTypeAccountingCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType)get_store().find_element_user(ASSETTYPEACCOUNTINGCATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeAccountingCategory" element
     */
    public void setAssetTypeAccountingCategory(org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType.Enum assetTypeAccountingCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEACCOUNTINGCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPEACCOUNTINGCATEGORY$0);
            }
            target.setEnumValue(assetTypeAccountingCategory);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeAccountingCategory" element
     */
    public void xsetAssetTypeAccountingCategory(org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType assetTypeAccountingCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType)get_store().find_element_user(ASSETTYPEACCOUNTINGCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType)get_store().add_element_user(ASSETTYPEACCOUNTINGCATEGORY$0);
            }
            target.set(assetTypeAccountingCategory);
        }
    }
}
