/*
 * An XML document type.
 * Localname: Documents
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.DocumentsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Documents(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class DocumentsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.DocumentsDocument
{
    private static final long serialVersionUID = 1L;
    
    public DocumentsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DOCUMENTS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Documents");
    
    
    /**
     * Gets the "Documents" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(DOCUMENTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Documents" element
     */
    public void setDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType documents)
    {
        generatedSetterHelperImpl(documents, DOCUMENTS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Documents" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(DOCUMENTS$0);
            return target;
        }
    }
}
