/*
 * An XML document type.
 * Localname: ResourceIssues
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ResourceIssuesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ResourceIssues(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ResourceIssuesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ResourceIssuesDocument
{
    private static final long serialVersionUID = 1L;
    
    public ResourceIssuesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RESOURCEISSUES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ResourceIssues");
    
    
    /**
     * Gets the "ResourceIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getResourceIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(RESOURCEISSUES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ResourceIssues" element
     */
    public void setResourceIssues(org.erdc.cobie.cobielite.core.IssueCollectionType resourceIssues)
    {
        generatedSetterHelperImpl(resourceIssues, RESOURCEISSUES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ResourceIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewResourceIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(RESOURCEISSUES$0);
            return target;
        }
    }
}
