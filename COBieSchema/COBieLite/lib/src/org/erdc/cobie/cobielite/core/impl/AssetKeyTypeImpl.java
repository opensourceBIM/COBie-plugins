/*
 * XML Type:  AssetKeyType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetKeyType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML AssetKeyType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class AssetKeyTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieKeyTypeImpl implements org.erdc.cobie.cobielite.core.AssetKeyType
{
    private static final long serialVersionUID = 1L;
    
    public AssetKeyTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetName");
    private static final javax.xml.namespace.QName ASSETTYPEASSIGNMENT$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeAssignment");
    private static final javax.xml.namespace.QName ASSETSPACEASSIGNMENTS$4 = 
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
     * Gets the "AssetTypeAssignment" element
     */
    public org.erdc.cobie.cobielite.core.AssetTypeKeyType getAssetTypeAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetTypeKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetTypeKeyType)get_store().find_element_user(ASSETTYPEASSIGNMENT$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeAssignment" element
     */
    public void setAssetTypeAssignment(org.erdc.cobie.cobielite.core.AssetTypeKeyType assetTypeAssignment)
    {
        generatedSetterHelperImpl(assetTypeAssignment, ASSETTYPEASSIGNMENT$2, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypeAssignment" element
     */
    public org.erdc.cobie.cobielite.core.AssetTypeKeyType addNewAssetTypeAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetTypeKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetTypeKeyType)get_store().add_element_user(ASSETTYPEASSIGNMENT$2);
            return target;
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
            target = (org.erdc.cobie.cobielite.core.SpaceAssignmentCollectionType)get_store().find_element_user(ASSETSPACEASSIGNMENTS$4, 0);
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
        generatedSetterHelperImpl(assetSpaceAssignments, ASSETSPACEASSIGNMENTS$4, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
            target = (org.erdc.cobie.cobielite.core.SpaceAssignmentCollectionType)get_store().add_element_user(ASSETSPACEASSIGNMENTS$4);
            return target;
        }
    }
}
