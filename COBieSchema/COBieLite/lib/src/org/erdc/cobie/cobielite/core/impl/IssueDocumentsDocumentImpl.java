/*
 * An XML document type.
 * Localname: IssueDocuments
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.IssueDocumentsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one IssueDocuments(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class IssueDocumentsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.IssueDocumentsDocument
{
    private static final long serialVersionUID = 1L;
    
    public IssueDocumentsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ISSUEDOCUMENTS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "IssueDocuments");
    
    
    /**
     * Gets the "IssueDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getIssueDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(ISSUEDOCUMENTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "IssueDocuments" element
     */
    public void setIssueDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType issueDocuments)
    {
        generatedSetterHelperImpl(issueDocuments, ISSUEDOCUMENTS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "IssueDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewIssueDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(ISSUEDOCUMENTS$0);
            return target;
        }
    }
}
