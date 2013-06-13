/*
 * An XML document type.
 * Localname: AssemblyAssignments
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssemblyAssignmentsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssemblyAssignments(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssemblyAssignmentsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssemblyAssignmentsDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssemblyAssignmentsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSEMBLYASSIGNMENTS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssemblyAssignments");
    
    
    /**
     * Gets the "AssemblyAssignments" element
     */
    public org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType getAssemblyAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType)get_store().find_element_user(ASSEMBLYASSIGNMENTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AssemblyAssignments" element
     */
    public void setAssemblyAssignments(org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType assemblyAssignments)
    {
        generatedSetterHelperImpl(assemblyAssignments, ASSEMBLYASSIGNMENTS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssemblyAssignments" element
     */
    public org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType addNewAssemblyAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType)get_store().add_element_user(ASSEMBLYASSIGNMENTS$0);
            return target;
        }
    }
}
