/*
 * XML Type:  AssemblyKeyType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssemblyKeyType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML AssemblyKeyType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class AssemblyKeyTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieKeyTypeImpl implements org.erdc.cobie.cobielite.core.AssemblyKeyType
{
    private static final long serialVersionUID = 1L;
    
    public AssemblyKeyTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSEMBLYNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssemblyName");
    private static final javax.xml.namespace.QName ASSEMBLYCATEGORY$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssemblyCategory");
    
    
    /**
     * Gets the "AssemblyName" element
     */
    public java.lang.String getAssemblyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSEMBLYNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssemblyName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetAssemblyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(ASSEMBLYNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssemblyName" element
     */
    public void setAssemblyName(java.lang.String assemblyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSEMBLYNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSEMBLYNAME$0);
            }
            target.setStringValue(assemblyName);
        }
    }
    
    /**
     * Sets (as xml) the "AssemblyName" element
     */
    public void xsetAssemblyName(org.erdc.cobie.cobielite.core.CobieNameSimpleType assemblyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(ASSEMBLYNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(ASSEMBLYNAME$0);
            }
            target.set(assemblyName);
        }
    }
    
    /**
     * Gets the "AssemblyCategory" element
     */
    public java.lang.String getAssemblyCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSEMBLYCATEGORY$2, 0);
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
            target = (org.erdc.cobie.cobielite.core.AssemblyCategorySimpleType)get_store().find_element_user(ASSEMBLYCATEGORY$2, 0);
            return target;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSEMBLYCATEGORY$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSEMBLYCATEGORY$2);
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
            target = (org.erdc.cobie.cobielite.core.AssemblyCategorySimpleType)get_store().find_element_user(ASSEMBLYCATEGORY$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.AssemblyCategorySimpleType)get_store().add_element_user(ASSEMBLYCATEGORY$2);
            }
            target.set(assemblyCategory);
        }
    }
}
