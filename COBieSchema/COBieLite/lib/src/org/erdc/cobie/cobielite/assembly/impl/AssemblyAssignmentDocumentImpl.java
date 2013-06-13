/*
 * An XML document type.
 * Localname: AssemblyAssignment
 * Namespace: http://assembly.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.assembly.AssemblyAssignmentDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.assembly.impl;
/**
 * A document containing one AssemblyAssignment(@http://assembly.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssemblyAssignmentDocumentImpl extends org.erdc.cobie.cobielite.core.impl.AssemblyAssignmentDocumentImpl implements org.erdc.cobie.cobielite.assembly.AssemblyAssignmentDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssemblyAssignmentDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSEMBLYASSIGNMENT2$0 = 
        new javax.xml.namespace.QName("http://assembly.cobielite.cobie.erdc.org", "AssemblyAssignment");
    
    
    /**
     * Gets the "AssemblyAssignment" element
     */
    public org.erdc.cobie.cobielite.assembly.AssemblyType getAssemblyAssignment2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.assembly.AssemblyType target = null;
            target = (org.erdc.cobie.cobielite.assembly.AssemblyType)get_store().find_element_user(ASSEMBLYASSIGNMENT2$0, 0);
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
    public void setAssemblyAssignment2(org.erdc.cobie.cobielite.assembly.AssemblyType assemblyAssignment2)
    {
        generatedSetterHelperImpl(assemblyAssignment2, ASSEMBLYASSIGNMENT2$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssemblyAssignment" element
     */
    public org.erdc.cobie.cobielite.assembly.AssemblyType addNewAssemblyAssignment2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.assembly.AssemblyType target = null;
            target = (org.erdc.cobie.cobielite.assembly.AssemblyType)get_store().add_element_user(ASSEMBLYASSIGNMENT2$0);
            return target;
        }
    }
}
