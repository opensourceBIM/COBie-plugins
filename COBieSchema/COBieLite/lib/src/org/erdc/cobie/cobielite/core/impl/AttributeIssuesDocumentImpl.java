/*
 * An XML document type.
 * Localname: AttributeIssues
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeIssuesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AttributeIssues(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AttributeIssuesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AttributeIssuesDocument
{
    private static final long serialVersionUID = 1L;
    
    public AttributeIssuesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTEISSUES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeIssues");
    
    
    /**
     * Gets the "AttributeIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getAttributeIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(ATTRIBUTEISSUES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AttributeIssues" element
     */
    public void setAttributeIssues(org.erdc.cobie.cobielite.core.IssueCollectionType attributeIssues)
    {
        generatedSetterHelperImpl(attributeIssues, ATTRIBUTEISSUES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AttributeIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewAttributeIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(ATTRIBUTEISSUES$0);
            return target;
        }
    }
}
