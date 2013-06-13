/*
 * An XML document type.
 * Localname: Issues
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.IssuesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Issues(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class IssuesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.IssuesDocument
{
    private static final long serialVersionUID = 1L;
    
    public IssuesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ISSUES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Issues");
    
    
    /**
     * Gets the "Issues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(ISSUES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Issues" element
     */
    public void setIssues(org.erdc.cobie.cobielite.core.IssueCollectionType issues)
    {
        generatedSetterHelperImpl(issues, ISSUES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Issues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(ISSUES$0);
            return target;
        }
    }
}
