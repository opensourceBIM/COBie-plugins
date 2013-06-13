/*
 * An XML document type.
 * Localname: SystemIssues
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SystemIssuesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SystemIssues(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SystemIssuesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SystemIssuesDocument
{
    private static final long serialVersionUID = 1L;
    
    public SystemIssuesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SYSTEMISSUES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SystemIssues");
    
    
    /**
     * Gets the "SystemIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getSystemIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(SYSTEMISSUES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "SystemIssues" element
     */
    public void setSystemIssues(org.erdc.cobie.cobielite.core.IssueCollectionType systemIssues)
    {
        generatedSetterHelperImpl(systemIssues, SYSTEMISSUES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SystemIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewSystemIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(SYSTEMISSUES$0);
            return target;
        }
    }
}
