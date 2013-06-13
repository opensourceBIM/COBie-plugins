/*
 * An XML document type.
 * Localname: AssemblyAssignment
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssemblyAssignmentDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssemblyAssignment(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssemblyAssignmentDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssemblyAssignmentDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssemblyAssignmentDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSEMBLYASSIGNMENT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssemblyAssignment");
    private static final org.apache.xmlbeans.QNameSet ASSEMBLYASSIGNMENT$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssemblyAssignment"),
        new javax.xml.namespace.QName("http://assembly.cobielite.cobie.erdc.org", "AssemblyAssignment"),
    });
    
    
    /**
     * Gets the "AssemblyAssignment" element
     */
    public org.erdc.cobie.cobielite.core.AssemblyType getAssemblyAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssemblyType target = null;
            target = (org.erdc.cobie.cobielite.core.AssemblyType)get_store().find_element_user(ASSEMBLYASSIGNMENT$1, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AssemblyAssignment" element
     */
    public void setAssemblyAssignment(org.erdc.cobie.cobielite.core.AssemblyType assemblyAssignment)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssemblyType target = null;
            target = (org.erdc.cobie.cobielite.core.AssemblyType)get_store().find_element_user(ASSEMBLYASSIGNMENT$1, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.AssemblyType)get_store().add_element_user(ASSEMBLYASSIGNMENT$0);
            }
            target.set(assemblyAssignment);
        }
    }
    
    /**
     * Appends and returns a new empty "AssemblyAssignment" element
     */
    public org.erdc.cobie.cobielite.core.AssemblyType addNewAssemblyAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssemblyType target = null;
            target = (org.erdc.cobie.cobielite.core.AssemblyType)get_store().add_element_user(ASSEMBLYASSIGNMENT$0);
            return target;
        }
    }
}
