/*
 * An XML document type.
 * Localname: Document
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.DocumentDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Document(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class DocumentDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.DocumentDocument
{
    private static final long serialVersionUID = 1L;
    
    public DocumentDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DOCUMENT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Document");
    private static final org.apache.xmlbeans.QNameSet DOCUMENT$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Document"),
        new javax.xml.namespace.QName("http://document.cobielite.cobie.erdc.org", "Document"),
    });
    
    
    /**
     * Gets the "Document" element
     */
    public org.erdc.cobie.cobielite.core.DocumentType getDocument()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentType)get_store().find_element_user(DOCUMENT$1, 0);
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
    public void setDocument(org.erdc.cobie.cobielite.core.DocumentType document)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentType)get_store().find_element_user(DOCUMENT$1, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.DocumentType)get_store().add_element_user(DOCUMENT$0);
            }
            target.set(document);
        }
    }
    
    /**
     * Appends and returns a new empty "Document" element
     */
    public org.erdc.cobie.cobielite.core.DocumentType addNewDocument()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentType)get_store().add_element_user(DOCUMENT$0);
            return target;
        }
    }
}
