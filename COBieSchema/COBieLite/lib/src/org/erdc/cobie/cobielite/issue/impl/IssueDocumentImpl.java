/*
 * An XML document type.
 * Localname: Issue
 * Namespace: http://issue.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.issue.IssueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.issue.impl;
/**
 * A document containing one Issue(@http://issue.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class IssueDocumentImpl extends org.erdc.cobie.cobielite.core.impl.IssueDocumentImpl implements org.erdc.cobie.cobielite.issue.IssueDocument
{
    private static final long serialVersionUID = 1L;
    
    public IssueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ISSUE2$0 = 
        new javax.xml.namespace.QName("http://issue.cobielite.cobie.erdc.org", "Issue");
    
    
    /**
     * Gets the "Issue" element
     */
    public org.erdc.cobie.cobielite.issue.IssueType getIssue2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.issue.IssueType target = null;
            target = (org.erdc.cobie.cobielite.issue.IssueType)get_store().find_element_user(ISSUE2$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Issue" element
     */
    public void setIssue2(org.erdc.cobie.cobielite.issue.IssueType issue2)
    {
        generatedSetterHelperImpl(issue2, ISSUE2$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Issue" element
     */
    public org.erdc.cobie.cobielite.issue.IssueType addNewIssue2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.issue.IssueType target = null;
            target = (org.erdc.cobie.cobielite.issue.IssueType)get_store().add_element_user(ISSUE2$0);
            return target;
        }
    }
}
