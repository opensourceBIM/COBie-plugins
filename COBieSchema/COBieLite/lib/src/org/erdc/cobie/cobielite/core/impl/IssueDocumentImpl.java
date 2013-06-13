/*
 * An XML document type.
 * Localname: Issue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.IssueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Issue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class IssueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.IssueDocument
{
    private static final long serialVersionUID = 1L;
    
    public IssueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ISSUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Issue");
    private static final org.apache.xmlbeans.QNameSet ISSUE$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Issue"),
        new javax.xml.namespace.QName("http://issue.cobielite.cobie.erdc.org", "Issue"),
    });
    
    
    /**
     * Gets the "Issue" element
     */
    public org.erdc.cobie.cobielite.core.IssueType getIssue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueType)get_store().find_element_user(ISSUE$1, 0);
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
    public void setIssue(org.erdc.cobie.cobielite.core.IssueType issue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueType)get_store().find_element_user(ISSUE$1, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.IssueType)get_store().add_element_user(ISSUE$0);
            }
            target.set(issue);
        }
    }
    
    /**
     * Appends and returns a new empty "Issue" element
     */
    public org.erdc.cobie.cobielite.core.IssueType addNewIssue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueType)get_store().add_element_user(ISSUE$0);
            return target;
        }
    }
}
