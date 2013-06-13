/*
 * XML Type:  IssueType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.IssueType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML IssueType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class IssueTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieRowTypeImpl implements org.erdc.cobie.cobielite.core.IssueType
{
    private static final long serialVersionUID = 1L;
    
    public IssueTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ISSUENAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "IssueName");
    private static final javax.xml.namespace.QName ISSUECATEGORY$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "IssueCategory");
    
    
    /**
     * Gets the "IssueName" element
     */
    public java.lang.String getIssueName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUENAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "IssueName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetIssueName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(ISSUENAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "IssueName" element
     */
    public void setIssueName(java.lang.String issueName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUENAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISSUENAME$0);
            }
            target.setStringValue(issueName);
        }
    }
    
    /**
     * Sets (as xml) the "IssueName" element
     */
    public void xsetIssueName(org.erdc.cobie.cobielite.core.CobieNameSimpleType issueName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(ISSUENAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(ISSUENAME$0);
            }
            target.set(issueName);
        }
    }
    
    /**
     * Gets the "IssueCategory" element
     */
    public java.lang.String getIssueCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUECATEGORY$2, 0);
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
            target = (org.erdc.cobie.cobielite.core.IssueCategorySimpleType)get_store().find_element_user(ISSUECATEGORY$2, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUECATEGORY$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISSUECATEGORY$2);
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
            target = (org.erdc.cobie.cobielite.core.IssueCategorySimpleType)get_store().find_element_user(ISSUECATEGORY$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.IssueCategorySimpleType)get_store().add_element_user(ISSUECATEGORY$2);
            }
            target.set(issueCategory);
        }
    }
}
