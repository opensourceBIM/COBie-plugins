/*
 * An XML document type.
 * Localname: Document
 * Namespace: http://document.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.document.DocumentDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.document.impl;
/**
 * A document containing one Document(@http://document.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class DocumentDocumentImpl extends org.erdc.cobie.cobielite.core.impl.DocumentDocumentImpl implements org.erdc.cobie.cobielite.document.DocumentDocument
{
    private static final long serialVersionUID = 1L;
    
    public DocumentDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DOCUMENT2$0 = 
        new javax.xml.namespace.QName("http://document.cobielite.cobie.erdc.org", "Document");
    
    
    /**
     * Gets the "Document" element
     */
    public org.erdc.cobie.cobielite.document.DocumentType getDocument2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.document.DocumentType target = null;
            target = (org.erdc.cobie.cobielite.document.DocumentType)get_store().find_element_user(DOCUMENT2$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Document" element
     */
    public void setDocument2(org.erdc.cobie.cobielite.document.DocumentType document2)
    {
        generatedSetterHelperImpl(document2, DOCUMENT2$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Document" element
     */
    public org.erdc.cobie.cobielite.document.DocumentType addNewDocument2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.document.DocumentType target = null;
            target = (org.erdc.cobie.cobielite.document.DocumentType)get_store().add_element_user(DOCUMENT2$0);
            return target;
        }
    }
}
