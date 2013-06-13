/*
 * An XML document type.
 * Localname: AssetSystemAssignments
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetSystemAssignmentsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetSystemAssignments(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetSystemAssignmentsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetSystemAssignmentsDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetSystemAssignmentsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETSYSTEMASSIGNMENTS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetSystemAssignments");
    
    
    /**
     * Gets the "AssetSystemAssignments" element
     */
    public org.erdc.cobie.cobielite.core.SystemAssignmentCollectionType getAssetSystemAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemAssignmentCollectionType)get_store().find_element_user(ASSETSYSTEMASSIGNMENTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AssetSystemAssignments" element
     */
    public void setAssetSystemAssignments(org.erdc.cobie.cobielite.core.SystemAssignmentCollectionType assetSystemAssignments)
    {
        generatedSetterHelperImpl(assetSystemAssignments, ASSETSYSTEMASSIGNMENTS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetSystemAssignments" element
     */
    public org.erdc.cobie.cobielite.core.SystemAssignmentCollectionType addNewAssetSystemAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemAssignmentCollectionType)get_store().add_element_user(ASSETSYSTEMASSIGNMENTS$0);
            return target;
        }
    }
}
