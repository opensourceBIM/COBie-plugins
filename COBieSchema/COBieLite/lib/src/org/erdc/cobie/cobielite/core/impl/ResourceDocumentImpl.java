/*
 * An XML document type.
 * Localname: Resource
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ResourceDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Resource(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ResourceDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ResourceDocument
{
    private static final long serialVersionUID = 1L;
    
    public ResourceDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RESOURCE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Resource");
    private static final org.apache.xmlbeans.QNameSet RESOURCE$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Resource"),
        new javax.xml.namespace.QName("http://resource.cobielite.cobie.erdc.org", "Resource"),
    });
    
    
    /**
     * Gets the "Resource" element
     */
    public org.erdc.cobie.cobielite.core.ResourceType getResource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ResourceType target = null;
            target = (org.erdc.cobie.cobielite.core.ResourceType)get_store().find_element_user(RESOURCE$1, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Resource" element
     */
    public void setResource(org.erdc.cobie.cobielite.core.ResourceType resource)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ResourceType target = null;
            target = (org.erdc.cobie.cobielite.core.ResourceType)get_store().find_element_user(RESOURCE$1, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.ResourceType)get_store().add_element_user(RESOURCE$0);
            }
            target.set(resource);
        }
    }
    
    /**
     * Appends and returns a new empty "Resource" element
     */
    public org.erdc.cobie.cobielite.core.ResourceType addNewResource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ResourceType target = null;
            target = (org.erdc.cobie.cobielite.core.ResourceType)get_store().add_element_user(RESOURCE$0);
            return target;
        }
    }
}
