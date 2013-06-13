/*
 * XML Type:  AssetCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML AssetCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class AssetCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieWorksheetTypeImpl implements org.erdc.cobie.cobielite.core.AssetCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public AssetCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSET$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Asset");
    private static final org.apache.xmlbeans.QNameSet ASSET$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://asset.cobielite.cobie.erdc.org", "Asset"),
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Asset"),
    });
    
    
    /**
     * Gets array of all "Asset" elements
     */
    public org.erdc.cobie.cobielite.core.AssetInfoType[] getAssetArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ASSET$1, targetList);
            org.erdc.cobie.cobielite.core.AssetInfoType[] result = new org.erdc.cobie.cobielite.core.AssetInfoType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Asset" element
     */
    public org.erdc.cobie.cobielite.core.AssetInfoType getAssetArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetInfoType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetInfoType)get_store().find_element_user(ASSET$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Asset" element
     */
    public int sizeOfAssetArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSET$1);
        }
    }
    
    /**
     * Sets array of all "Asset" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setAssetArray(org.erdc.cobie.cobielite.core.AssetInfoType[] assetArray)
    {
        check_orphaned();
        arraySetterHelper(assetArray, ASSET$0, ASSET$1);
    }
    
    /**
     * Sets ith "Asset" element
     */
    public void setAssetArray(int i, org.erdc.cobie.cobielite.core.AssetInfoType asset)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetInfoType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetInfoType)get_store().find_element_user(ASSET$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(asset);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Asset" element
     */
    public org.erdc.cobie.cobielite.core.AssetInfoType insertNewAsset(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetInfoType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetInfoType)get_store().insert_element_user(ASSET$1, ASSET$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Asset" element
     */
    public org.erdc.cobie.cobielite.core.AssetInfoType addNewAsset()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetInfoType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetInfoType)get_store().add_element_user(ASSET$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Asset" element
     */
    public void removeAsset(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSET$1, i);
        }
    }
}
