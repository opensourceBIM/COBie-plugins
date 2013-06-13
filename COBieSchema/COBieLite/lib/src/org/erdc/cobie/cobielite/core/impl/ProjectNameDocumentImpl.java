/*
 * An XML document type.
 * Localname: ProjectName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ProjectNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ProjectName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ProjectNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ProjectNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public ProjectNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROJECTNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ProjectName");
    
    
    /**
     * Gets the "ProjectName" element
     */
    public java.lang.String getProjectName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROJECTNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ProjectName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetProjectName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(PROJECTNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ProjectName" element
     */
    public void setProjectName(java.lang.String projectName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROJECTNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROJECTNAME$0);
            }
            target.setStringValue(projectName);
        }
    }
    
    /**
     * Sets (as xml) the "ProjectName" element
     */
    public void xsetProjectName(org.erdc.cobie.cobielite.core.CobieNameSimpleType projectName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(PROJECTNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(PROJECTNAME$0);
            }
            target.set(projectName);
        }
    }
}
