/*
 * An XML document type.
 * Localname: SpaceIssues
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpaceIssuesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SpaceIssues(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SpaceIssuesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SpaceIssuesDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpaceIssuesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPACEISSUES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceIssues");
    
    
    /**
     * Gets the "SpaceIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getSpaceIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(SPACEISSUES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "SpaceIssues" element
     */
    public void setSpaceIssues(org.erdc.cobie.cobielite.core.IssueCollectionType spaceIssues)
    {
        generatedSetterHelperImpl(spaceIssues, SPACEISSUES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpaceIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewSpaceIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(SPACEISSUES$0);
            return target;
        }
    }
}
