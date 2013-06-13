/*
 * An XML document type.
 * Localname: AssemblyCategory
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssemblyCategoryDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssemblyCategory(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssemblyCategoryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssemblyCategoryDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssemblyCategoryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSEMBLYCATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssemblyCategory");
    
    
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
}
