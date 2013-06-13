/*
 * An XML document type.
 * Localname: DocumentReferenceURI
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.DocumentReferenceURIDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one DocumentReferenceURI(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class DocumentReferenceURIDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.DocumentReferenceURIDocument
{
    private static final long serialVersionUID = 1L;
    
    public DocumentReferenceURIDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DOCUMENTREFERENCEURI$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "DocumentReferenceURI");
    
    
    /**
     * Gets the "DocumentReferenceURI" element
     */
    public java.lang.String getDocumentReferenceURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTREFERENCEURI$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "DocumentReferenceURI" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetDocumentReferenceURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(DOCUMENTREFERENCEURI$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "DocumentReferenceURI" element
     */
    public void setDocumentReferenceURI(java.lang.String documentReferenceURI)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTREFERENCEURI$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DOCUMENTREFERENCEURI$0);
            }
            target.setStringValue(documentReferenceURI);
        }
    }
    
    /**
     * Sets (as xml) the "DocumentReferenceURI" element
     */
    public void xsetDocumentReferenceURI(org.erdc.cobie.cobielite.core.CobieTextSimpleType documentReferenceURI)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(DOCUMENTREFERENCEURI$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(DOCUMENTREFERENCEURI$0);
            }
            target.set(documentReferenceURI);
        }
    }
}
