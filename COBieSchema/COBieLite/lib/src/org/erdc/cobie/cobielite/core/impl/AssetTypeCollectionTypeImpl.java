/*
 * XML Type:  AssetTypeCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML AssetTypeCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class AssetTypeCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieWorksheetTypeImpl implements org.erdc.cobie.cobielite.core.AssetTypeCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetType");
    private static final org.apache.xmlbeans.QNameSet ASSETTYPE$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://assettype.cobielite.cobie.erdc.org", "AssetType"),
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetType"),
    });
    
    
    /**
     * Gets array of all "AssetType" elements
     */
    public org.erdc.cobie.cobielite.core.AssetTypeInfoType[] getAssetTypeArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ASSETTYPE$1, targetList);
            org.erdc.cobie.cobielite.core.AssetTypeInfoType[] result = new org.erdc.cobie.cobielite.core.AssetTypeInfoType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "AssetType" element
     */
    public org.erdc.cobie.cobielite.core.AssetTypeInfoType getAssetTypeArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetTypeInfoType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetTypeInfoType)get_store().find_element_user(ASSETTYPE$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "AssetType" element
     */
    public int sizeOfAssetTypeArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPE$1);
        }
    }
    
    /**
     * Sets array of all "AssetType" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setAssetTypeArray(org.erdc.cobie.cobielite.core.AssetTypeInfoType[] assetTypeArray)
    {
        check_orphaned();
        arraySetterHelper(assetTypeArray, ASSETTYPE$0, ASSETTYPE$1);
    }
    
    /**
     * Sets ith "AssetType" element
     */
    public void setAssetTypeArray(int i, org.erdc.cobie.cobielite.core.AssetTypeInfoType assetType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetTypeInfoType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetTypeInfoType)get_store().find_element_user(ASSETTYPE$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(assetType);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "AssetType" element
     */
    public org.erdc.cobie.cobielite.core.AssetTypeInfoType insertNewAssetType(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetTypeInfoType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetTypeInfoType)get_store().insert_element_user(ASSETTYPE$1, ASSETTYPE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "AssetType" element
     */
    public org.erdc.cobie.cobielite.core.AssetTypeInfoType addNewAssetType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetTypeInfoType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetTypeInfoType)get_store().add_element_user(ASSETTYPE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "AssetType" element
     */
    public void removeAssetType(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPE$1, i);
        }
    }
}
