/*
 * An XML document type.
 * Localname: AssetSpaceAssignments
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetSpaceAssignmentsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetSpaceAssignments(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetSpaceAssignmentsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetSpaceAssignmentsDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetSpaceAssignmentsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETSPACEASSIGNMENTS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetSpaceAssignments");
    
    
    /**
     * Gets the "AssetSpaceAssignments" element
     */
    public org.erdc.cobie.cobielite.core.SpaceAssignmentCollectionType getAssetSpaceAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceAssignmentCollectionType)get_store().find_element_user(ASSETSPACEASSIGNMENTS$0, 0);
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
        generatedSetterHelperImpl(assetSpaceAssignments, ASSETSPACEASSIGNMENTS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
            target = (org.erdc.cobie.cobielite.core.SpaceAssignmentCollectionType)get_store().add_element_user(ASSETSPACEASSIGNMENTS$0);
            return target;
        }
    }
}
