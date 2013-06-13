/*
 * An XML document type.
 * Localname: Resource
 * Namespace: http://resource.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.resource.ResourceDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.resource.impl;
/**
 * A document containing one Resource(@http://resource.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ResourceDocumentImpl extends org.erdc.cobie.cobielite.core.impl.ResourceDocumentImpl implements org.erdc.cobie.cobielite.resource.ResourceDocument
{
    private static final long serialVersionUID = 1L;
    
    public ResourceDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RESOURCE2$0 = 
        new javax.xml.namespace.QName("http://resource.cobielite.cobie.erdc.org", "Resource");
    
    
    /**
     * Gets the "Resource" element
     */
    public org.erdc.cobie.cobielite.resource.ResourceType getResource2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.resource.ResourceType target = null;
            target = (org.erdc.cobie.cobielite.resource.ResourceType)get_store().find_element_user(RESOURCE2$0, 0);
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
    public void setResource2(org.erdc.cobie.cobielite.resource.ResourceType resource2)
    {
        generatedSetterHelperImpl(resource2, RESOURCE2$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Resource" element
     */
    public org.erdc.cobie.cobielite.resource.ResourceType addNewResource2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.resource.ResourceType target = null;
            target = (org.erdc.cobie.cobielite.resource.ResourceType)get_store().add_element_user(RESOURCE2$0);
            return target;
        }
    }
}
