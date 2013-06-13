/*
 * An XML document type.
 * Localname: SpareContactAssignments
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpareContactAssignmentsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SpareContactAssignments(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SpareContactAssignmentsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SpareContactAssignmentsDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpareContactAssignmentsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPARECONTACTASSIGNMENTS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpareContactAssignments");
    
    
    /**
     * Gets the "SpareContactAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType getSpareContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType)get_store().find_element_user(SPARECONTACTASSIGNMENTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "SpareContactAssignments" element
     */
    public void setSpareContactAssignments(org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType spareContactAssignments)
    {
        generatedSetterHelperImpl(spareContactAssignments, SPARECONTACTASSIGNMENTS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpareContactAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType addNewSpareContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType)get_store().add_element_user(SPARECONTACTASSIGNMENTS$0);
            return target;
        }
    }
}
