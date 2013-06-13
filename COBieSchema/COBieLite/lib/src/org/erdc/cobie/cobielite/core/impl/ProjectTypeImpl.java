/*
 * XML Type:  ProjectType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ProjectType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML ProjectType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class ProjectTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieBaseTypeImpl implements org.erdc.cobie.cobielite.core.ProjectType
{
    private static final long serialVersionUID = 1L;
    
    public ProjectTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROJECTNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ProjectName");
    private static final javax.xml.namespace.QName PROJECTDESCRIPTION$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ProjectDescription");
    
    
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
    
    /**
     * Gets the "ProjectDescription" element
     */
    public java.lang.String getProjectDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROJECTDESCRIPTION$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ProjectDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetProjectDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(PROJECTDESCRIPTION$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "ProjectDescription" element
     */
    public boolean isSetProjectDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PROJECTDESCRIPTION$2) != 0;
        }
    }
    
    /**
     * Sets the "ProjectDescription" element
     */
    public void setProjectDescription(java.lang.String projectDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROJECTDESCRIPTION$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROJECTDESCRIPTION$2);
            }
            target.setStringValue(projectDescription);
        }
    }
    
    /**
     * Sets (as xml) the "ProjectDescription" element
     */
    public void xsetProjectDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType projectDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(PROJECTDESCRIPTION$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(PROJECTDESCRIPTION$2);
            }
            target.set(projectDescription);
        }
    }
    
    /**
     * Unsets the "ProjectDescription" element
     */
    public void unsetProjectDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PROJECTDESCRIPTION$2, 0);
        }
    }
}
