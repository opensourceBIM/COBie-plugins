/*
 * An XML document type.
 * Localname: AssetTypeManufacturerContactAssignments
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeManufacturerContactAssignmentsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypeManufacturerContactAssignments(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeManufacturerContactAssignmentsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeManufacturerContactAssignmentsDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeManufacturerContactAssignmentsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AssetTypeManufacturerContactAssignments$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeManufacturerContactAssignments");
    
    
    /**
     * Gets the "AssetTypeManufacturerContactAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType getAssetTypeManufacturerContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType)get_store().find_element_user(AssetTypeManufacturerContactAssignments$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeManufacturerContactAssignments" element
     */
    public void setAssetTypeManufacturerContactAssignments(org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType AssetTypeManufacturerContactAssignments)
    {
        generatedSetterHelperImpl(AssetTypeManufacturerContactAssignments, AssetTypeManufacturerContactAssignments$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypeManufacturerContactAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType addNewAssetTypeManufacturerContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType)get_store().add_element_user(AssetTypeManufacturerContactAssignments$0);
            return target;
        }
    }
}
