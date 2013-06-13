/*
 * An XML document type.
 * Localname: ResourceAttributes
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ResourceAttributesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ResourceAttributes(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ResourceAttributesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ResourceAttributesDocument
{
    private static final long serialVersionUID = 1L;
    
    public ResourceAttributesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RESOURCEATTRIBUTES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ResourceAttributes");
    
    
    /**
     * Gets the "ResourceAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getResourceAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(RESOURCEATTRIBUTES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ResourceAttributes" element
     */
    public void setResourceAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType resourceAttributes)
    {
        generatedSetterHelperImpl(resourceAttributes, RESOURCEATTRIBUTES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ResourceAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewResourceAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(RESOURCEATTRIBUTES$0);
            return target;
        }
    }
}
