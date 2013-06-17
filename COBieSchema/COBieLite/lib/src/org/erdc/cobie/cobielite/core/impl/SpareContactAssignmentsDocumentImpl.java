/*
 * An XML document type.
 * Localname: SpareSupplierContactAssignments
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpareSupplierContactAssignmentsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SpareSupplierContactAssignments(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SpareSupplierContactAssignmentsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SpareSupplierContactAssignmentsDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpareSupplierContactAssignmentsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SpareSupplierContactAssignments$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpareSupplierContactAssignments");
    
    
    /**
     * Gets the "SpareSupplierContactAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType getSpareSupplierContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType)get_store().find_element_user(SpareSupplierContactAssignments$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "SpareSupplierContactAssignments" element
     */
    public void setSpareSupplierContactAssignments(org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType SpareSupplierContactAssignments)
    {
        generatedSetterHelperImpl(SpareSupplierContactAssignments, SpareSupplierContactAssignments$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpareSupplierContactAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType addNewSpareSupplierContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType)get_store().add_element_user(SpareSupplierContactAssignments$0);
            return target;
        }
    }
}
