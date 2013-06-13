/*
 * XML Type:  AssetInfoType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetInfoType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML AssetInfoType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class AssetInfoTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieRowTypeImpl implements org.erdc.cobie.cobielite.core.AssetInfoType
{
    private static final long serialVersionUID = 1L;
    
    public AssetInfoTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetName");
    private static final javax.xml.namespace.QName ASSETSPACEASSIGNMENTS$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetSpaceAssignments");
    
    
    /**
     * Gets the "AssetName" element
     */
    public java.lang.String getAssetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetAssetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(ASSETNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetName" element
     */
    public void setAssetName(java.lang.String assetName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETNAME$0);
            }
            target.setStringValue(assetName);
        }
    }
    
    /**
     * Sets (as xml) the "AssetName" element
     */
    public void xsetAssetName(org.erdc.cobie.cobielite.core.CobieNameSimpleType assetName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(ASSETNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(ASSETNAME$0);
            }
            target.set(assetName);
        }
    }
    
    /**
     * Gets the "AssetSpaceAssignments" element
     */
    public org.erdc.cobie.cobielite.core.SpaceAssignmentCollectionType getAssetSpaceAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceAssignmentCollectionType)get_store().find_element_user(ASSETSPACEASSIGNMENTS$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AssetSpaceAssignments" element
     */
    public void setAssetSpaceAssignments(org.erdc.cobie.cobielite.core.SpaceAssignmentCollectionType assetSpaceAssignments)
    {
        generatedSetterHelperImpl(assetSpaceAssignments, ASSETSPACEASSIGNMENTS$2, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetSpaceAssignments" element
     */
    public org.erdc.cobie.cobielite.core.SpaceAssignmentCollectionType addNewAssetSpaceAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceAssignmentCollectionType)get_store().add_element_user(ASSETSPACEASSIGNMENTS$2);
            return target;
        }
    }
}
