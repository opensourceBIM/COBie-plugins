/*
 * An XML document type.
 * Localname: WarrantyGaurantorContactAssignments
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.WarrantyGaurantorContactAssignmentsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one WarrantyGaurantorContactAssignments(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class WarrantyGaurantorContactAssignmentsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.WarrantyGaurantorContactAssignmentsDocument
{
    private static final long serialVersionUID = 1L;
    
    public WarrantyGaurantorContactAssignmentsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WarrantyGaurantorContactAssignments$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "WarrantyGaurantorContactAssignments");
    
    
    /**
     * Gets the "WarrantyGaurantorContactAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType getWarrantyGaurantorContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType)get_store().find_element_user(WarrantyGaurantorContactAssignments$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "WarrantyGaurantorContactAssignments" element
     */
    public void setWarrantyGaurantorContactAssignments(org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType WarrantyGaurantorContactAssignments)
    {
        generatedSetterHelperImpl(WarrantyGaurantorContactAssignments, WarrantyGaurantorContactAssignments$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "WarrantyGaurantorContactAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType addNewWarrantyGaurantorContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType)get_store().add_element_user(WarrantyGaurantorContactAssignments$0);
            return target;
        }
    }
}
