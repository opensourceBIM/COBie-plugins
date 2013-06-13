/*
 * An XML document type.
 * Localname: AssemblyName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssemblyNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssemblyName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssemblyNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssemblyNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssemblyNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSEMBLYNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssemblyName");
    
    
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
}
