/*
 * An XML document type.
 * Localname: ConnectionIssues
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ConnectionIssuesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ConnectionIssues(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ConnectionIssuesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ConnectionIssuesDocument
{
    private static final long serialVersionUID = 1L;
    
    public ConnectionIssuesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONNECTIONISSUES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ConnectionIssues");
    
    
    /**
     * Gets the "ConnectionIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getConnectionIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(CONNECTIONISSUES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ConnectionIssues" element
     */
    public void setConnectionIssues(org.erdc.cobie.cobielite.core.IssueCollectionType connectionIssues)
    {
        generatedSetterHelperImpl(connectionIssues, CONNECTIONISSUES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ConnectionIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewConnectionIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(CONNECTIONISSUES$0);
            return target;
        }
    }
}
