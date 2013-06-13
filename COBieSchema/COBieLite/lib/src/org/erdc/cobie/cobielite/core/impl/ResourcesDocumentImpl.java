/*
 * An XML document type.
 * Localname: Resources
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ResourcesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Resources(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ResourcesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ResourcesDocument
{
    private static final long serialVersionUID = 1L;
    
    public ResourcesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RESOURCES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Resources");
    
    
    /**
     * Gets the "Resources" element
     */
    public org.erdc.cobie.cobielite.core.ResourceCollectionType getResources()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ResourceCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ResourceCollectionType)get_store().find_element_user(RESOURCES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Resources" element
     */
    public void setResources(org.erdc.cobie.cobielite.core.ResourceCollectionType resources)
    {
        generatedSetterHelperImpl(resources, RESOURCES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Resources" element
     */
    public org.erdc.cobie.cobielite.core.ResourceCollectionType addNewResources()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ResourceCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ResourceCollectionType)get_store().add_element_user(RESOURCES$0);
            return target;
        }
    }
}
