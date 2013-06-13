/*
 * An XML document type.
 * Localname: IssueImpactText
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.IssueImpactTextDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one IssueImpactText(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class IssueImpactTextDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.IssueImpactTextDocument
{
    private static final long serialVersionUID = 1L;
    
    public IssueImpactTextDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ISSUEIMPACTTEXT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "IssueImpactText");
    
    
    /**
     * Gets the "IssueImpactText" element
     */
    public java.lang.String getIssueImpactText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUEIMPACTTEXT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "IssueImpactText" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetIssueImpactText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ISSUEIMPACTTEXT$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "IssueImpactText" element
     */
    public void setIssueImpactText(java.lang.String issueImpactText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUEIMPACTTEXT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISSUEIMPACTTEXT$0);
            }
            target.setStringValue(issueImpactText);
        }
    }
    
    /**
     * Sets (as xml) the "IssueImpactText" element
     */
    public void xsetIssueImpactText(org.erdc.cobie.cobielite.core.CobieTextSimpleType issueImpactText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ISSUEIMPACTTEXT$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ISSUEIMPACTTEXT$0);
            }
            target.set(issueImpactText);
        }
    }
}
