/*
 * An XML document type.
 * Localname: AssetTypeContactAssignments
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeContactAssignmentsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypeContactAssignments(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeContactAssignmentsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeContactAssignmentsDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeContactAssignmentsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPECONTACTASSIGNMENTS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeContactAssignments");
    
    
    /**
     * Gets the "AssetTypeContactAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType getAssetTypeContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType)get_store().find_element_user(ASSETTYPECONTACTASSIGNMENTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeContactAssignments" element
     */
    public void setAssetTypeContactAssignments(org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType assetTypeContactAssignments)
    {
        generatedSetterHelperImpl(assetTypeContactAssignments, ASSETTYPECONTACTASSIGNMENTS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypeContactAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType addNewAssetTypeContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType)get_store().add_element_user(ASSETTYPECONTACTASSIGNMENTS$0);
            return target;
        }
    }
}
