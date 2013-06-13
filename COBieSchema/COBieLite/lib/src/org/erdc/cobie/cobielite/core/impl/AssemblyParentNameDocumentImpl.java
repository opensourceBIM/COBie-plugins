/*
 * An XML document type.
 * Localname: AssemblyParentName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssemblyParentNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssemblyParentName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssemblyParentNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssemblyParentNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssemblyParentNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSEMBLYPARENTNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssemblyParentName");
    
    
    /**
     * Gets the "AssemblyParentName" element
     */
    public java.lang.String getAssemblyParentName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSEMBLYPARENTNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssemblyParentName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetAssemblyParentName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(ASSEMBLYPARENTNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssemblyParentName" element
     */
    public void setAssemblyParentName(java.lang.String assemblyParentName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSEMBLYPARENTNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSEMBLYPARENTNAME$0);
            }
            target.setStringValue(assemblyParentName);
        }
    }
    
    /**
     * Sets (as xml) the "AssemblyParentName" element
     */
    public void xsetAssemblyParentName(org.erdc.cobie.cobielite.core.CobieNameSimpleType assemblyParentName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(ASSEMBLYPARENTNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(ASSEMBLYPARENTNAME$0);
            }
            target.set(assemblyParentName);
        }
    }
}
