/*
 * An XML document type.
 * Localname: ProjectAssignment
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ProjectAssignmentDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ProjectAssignment(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ProjectAssignmentDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ProjectAssignmentDocument
{
    private static final long serialVersionUID = 1L;
    
    public ProjectAssignmentDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROJECTASSIGNMENT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ProjectAssignment");
    
    
    /**
     * Gets the "ProjectAssignment" element
     */
    public org.erdc.cobie.cobielite.core.ProjectType getProjectAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ProjectType target = null;
            target = (org.erdc.cobie.cobielite.core.ProjectType)get_store().find_element_user(PROJECTASSIGNMENT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ProjectAssignment" element
     */
    public void setProjectAssignment(org.erdc.cobie.cobielite.core.ProjectType projectAssignment)
    {
        generatedSetterHelperImpl(projectAssignment, PROJECTASSIGNMENT$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ProjectAssignment" element
     */
    public org.erdc.cobie.cobielite.core.ProjectType addNewProjectAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ProjectType target = null;
            target = (org.erdc.cobie.cobielite.core.ProjectType)get_store().add_element_user(PROJECTASSIGNMENT$0);
            return target;
        }
    }
}
