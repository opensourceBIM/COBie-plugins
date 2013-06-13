/*
 * An XML document type.
 * Localname: IssueCategory
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.IssueCategoryDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one IssueCategory(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class IssueCategoryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.IssueCategoryDocument
{
    private static final long serialVersionUID = 1L;
    
    public IssueCategoryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ISSUECATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "IssueCategory");
    
    
    /**
     * Gets the "IssueCategory" element
     */
    public java.lang.String getIssueCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUECATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "IssueCategory" element
     */
    public org.erdc.cobie.cobielite.core.IssueCategorySimpleType xgetIssueCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCategorySimpleType)get_store().find_element_user(ISSUECATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "IssueCategory" element
     */
    public void setIssueCategory(java.lang.String issueCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISSUECATEGORY$0);
            }
            target.setStringValue(issueCategory);
        }
    }
    
    /**
     * Sets (as xml) the "IssueCategory" element
     */
    public void xsetIssueCategory(org.erdc.cobie.cobielite.core.IssueCategorySimpleType issueCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCategorySimpleType)get_store().find_element_user(ISSUECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.IssueCategorySimpleType)get_store().add_element_user(ISSUECATEGORY$0);
            }
            target.set(issueCategory);
        }
    }
}
