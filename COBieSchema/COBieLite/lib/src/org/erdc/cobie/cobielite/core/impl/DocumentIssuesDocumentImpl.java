/*
 * An XML document type.
 * Localname: DocumentIssues
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.DocumentIssuesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one DocumentIssues(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class DocumentIssuesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.DocumentIssuesDocument
{
    private static final long serialVersionUID = 1L;
    
    public DocumentIssuesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DOCUMENTISSUES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "DocumentIssues");
    
    
    /**
     * Gets the "DocumentIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getDocumentIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(DOCUMENTISSUES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "DocumentIssues" element
     */
    public void setDocumentIssues(org.erdc.cobie.cobielite.core.IssueCollectionType documentIssues)
    {
        generatedSetterHelperImpl(documentIssues, DOCUMENTISSUES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "DocumentIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewDocumentIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(DOCUMENTISSUES$0);
            return target;
        }
    }
}
