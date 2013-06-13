/*
 * An XML document type.
 * Localname: ContactAssignment
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactAssignmentDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ContactAssignment(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ContactAssignmentDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ContactAssignmentDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContactAssignmentDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTASSIGNMENT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactAssignment");
    
    
    /**
     * Gets the "ContactAssignment" element
     */
    public org.erdc.cobie.cobielite.core.ContactKeyType getContactAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactKeyType)get_store().find_element_user(CONTACTASSIGNMENT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ContactAssignment" element
     */
    public void setContactAssignment(org.erdc.cobie.cobielite.core.ContactKeyType contactAssignment)
    {
        generatedSetterHelperImpl(contactAssignment, CONTACTASSIGNMENT$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ContactAssignment" element
     */
    public org.erdc.cobie.cobielite.core.ContactKeyType addNewContactAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactKeyType)get_store().add_element_user(CONTACTASSIGNMENT$0);
            return target;
        }
    }
}
