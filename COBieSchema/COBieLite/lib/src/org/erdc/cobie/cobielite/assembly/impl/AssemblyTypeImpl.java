/*
 * XML Type:  AssemblyType
 * Namespace: http://assembly.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.assembly.AssemblyType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.assembly.impl;
/**
 * An XML AssemblyType(@http://assembly.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class AssemblyTypeImpl extends org.erdc.cobie.cobielite.core.impl.AssemblyTypeImpl implements org.erdc.cobie.cobielite.assembly.AssemblyType
{
    private static final long serialVersionUID = 1L;
    
    public AssemblyTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSEMBLYCATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssemblyCategory");
    private static final javax.xml.namespace.QName ASSEMBLYDESCRIPTION$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssemblyDescription");
    private static final javax.xml.namespace.QName ASSEMBLYATTRIBUTES$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssemblyAttributes");
    private static final javax.xml.namespace.QName ASSEMBLYDOCUMENTS$6 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssemblyDocuments");
    private static final javax.xml.namespace.QName ASSEMBLYISSUES$8 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssemblyIssues");
    
    
    /**
     * Gets the "AssemblyCategory" element
     */
    public java.lang.String getAssemblyCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSEMBLYCATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssemblyCategory" element
     */
    public org.erdc.cobie.cobielite.core.AssemblyCategorySimpleType xgetAssemblyCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssemblyCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.AssemblyCategorySimpleType)get_store().find_element_user(ASSEMBLYCATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssemblyCategory" element
     */
    public boolean isSetAssemblyCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSEMBLYCATEGORY$0) != 0;
        }
    }
    
    /**
     * Sets the "AssemblyCategory" element
     */
    public void setAssemblyCategory(java.lang.String assemblyCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSEMBLYCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSEMBLYCATEGORY$0);
            }
            target.setStringValue(assemblyCategory);
        }
    }
    
    /**
     * Sets (as xml) the "AssemblyCategory" element
     */
    public void xsetAssemblyCategory(org.erdc.cobie.cobielite.core.AssemblyCategorySimpleType assemblyCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssemblyCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.AssemblyCategorySimpleType)get_store().find_element_user(ASSEMBLYCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.AssemblyCategorySimpleType)get_store().add_element_user(ASSEMBLYCATEGORY$0);
            }
            target.set(assemblyCategory);
        }
    }
    
    /**
     * Unsets the "AssemblyCategory" element
     */
    public void unsetAssemblyCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSEMBLYCATEGORY$0, 0);
        }
    }
    
    /**
     * Gets the "AssemblyDescription" element
     */
    public java.lang.String getAssemblyDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSEMBLYDESCRIPTION$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssemblyDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssemblyDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSEMBLYDESCRIPTION$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssemblyDescription" element
     */
    public boolean isSetAssemblyDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSEMBLYDESCRIPTION$2) != 0;
        }
    }
    
    /**
     * Sets the "AssemblyDescription" element
     */
    public void setAssemblyDescription(java.lang.String assemblyDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSEMBLYDESCRIPTION$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSEMBLYDESCRIPTION$2);
            }
            target.setStringValue(assemblyDescription);
        }
    }
    
    /**
     * Sets (as xml) the "AssemblyDescription" element
     */
    public void xsetAssemblyDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assemblyDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSEMBLYDESCRIPTION$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(ASSEMBLYDESCRIPTION$2);
            }
            target.set(assemblyDescription);
        }
    }
    
    /**
     * Unsets the "AssemblyDescription" element
     */
    public void unsetAssemblyDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSEMBLYDESCRIPTION$2, 0);
        }
    }
    
    /**
     * Gets the "AssemblyAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getAssemblyAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(ASSEMBLYATTRIBUTES$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AssemblyAttributes" element
     */
    public boolean isSetAssemblyAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSEMBLYATTRIBUTES$4) != 0;
        }
    }
    
    /**
     * Sets the "AssemblyAttributes" element
     */
    public void setAssemblyAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType assemblyAttributes)
    {
        generatedSetterHelperImpl(assemblyAttributes, ASSEMBLYATTRIBUTES$4, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssemblyAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewAssemblyAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(ASSEMBLYATTRIBUTES$4);
            return target;
        }
    }
    
    /**
     * Unsets the "AssemblyAttributes" element
     */
    public void unsetAssemblyAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSEMBLYATTRIBUTES$4, 0);
        }
    }
    
    /**
     * Gets the "AssemblyDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getAssemblyDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(ASSEMBLYDOCUMENTS$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AssemblyDocuments" element
     */
    public boolean isSetAssemblyDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSEMBLYDOCUMENTS$6) != 0;
        }
    }
    
    /**
     * Sets the "AssemblyDocuments" element
     */
    public void setAssemblyDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType assemblyDocuments)
    {
        generatedSetterHelperImpl(assemblyDocuments, ASSEMBLYDOCUMENTS$6, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssemblyDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewAssemblyDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(ASSEMBLYDOCUMENTS$6);
            return target;
        }
    }
    
    /**
     * Unsets the "AssemblyDocuments" element
     */
    public void unsetAssemblyDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSEMBLYDOCUMENTS$6, 0);
        }
    }
    
    /**
     * Gets the "AssemblyIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getAssemblyIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(ASSEMBLYISSUES$8, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AssemblyIssues" element
     */
    public boolean isSetAssemblyIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSEMBLYISSUES$8) != 0;
        }
    }
    
    /**
     * Sets the "AssemblyIssues" element
     */
    public void setAssemblyIssues(org.erdc.cobie.cobielite.core.IssueCollectionType assemblyIssues)
    {
        generatedSetterHelperImpl(assemblyIssues, ASSEMBLYISSUES$8, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssemblyIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewAssemblyIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(ASSEMBLYISSUES$8);
            return target;
        }
    }
    
    /**
     * Unsets the "AssemblyIssues" element
     */
    public void unsetAssemblyIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSEMBLYISSUES$8, 0);
        }
    }
}
