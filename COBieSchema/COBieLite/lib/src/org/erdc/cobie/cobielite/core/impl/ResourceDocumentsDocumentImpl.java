/*
 * An XML document type.
 * Localname: ResourceDocuments
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ResourceDocumentsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ResourceDocuments(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ResourceDocumentsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ResourceDocumentsDocument
{
    private static final long serialVersionUID = 1L;
    
    public ResourceDocumentsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RESOURCEDOCUMENTS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ResourceDocuments");
    
    
    /**
     * Gets the "ResourceDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getResourceDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(RESOURCEDOCUMENTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ResourceDocuments" element
     */
    public void setResourceDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType resourceDocuments)
    {
        generatedSetterHelperImpl(resourceDocuments, RESOURCEDOCUMENTS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ResourceDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewResourceDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(RESOURCEDOCUMENTS$0);
            return target;
        }
    }
}
