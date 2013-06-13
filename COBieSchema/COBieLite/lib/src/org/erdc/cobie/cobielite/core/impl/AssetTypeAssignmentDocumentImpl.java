/*
 * An XML document type.
 * Localname: AssetTypeAssignment
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeAssignmentDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypeAssignment(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeAssignmentDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeAssignmentDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeAssignmentDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPEASSIGNMENT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeAssignment");
    
    
    /**
     * Gets the "AssetTypeAssignment" element
     */
    public org.erdc.cobie.cobielite.core.AssetTypeKeyType getAssetTypeAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetTypeKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetTypeKeyType)get_store().find_element_user(ASSETTYPEASSIGNMENT$0, 0);
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
        generatedSetterHelperImpl(assetTypeAssignment, ASSETTYPEASSIGNMENT$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
            target = (org.erdc.cobie.cobielite.core.AssetTypeKeyType)get_store().add_element_user(ASSETTYPEASSIGNMENT$0);
            return target;
        }
    }
}
