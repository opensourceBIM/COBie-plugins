/*
 * An XML document type.
 * Localname: IssueRiskText
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.IssueRiskTextDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one IssueRiskText(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class IssueRiskTextDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.IssueRiskTextDocument
{
    private static final long serialVersionUID = 1L;
    
    public IssueRiskTextDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ISSUERISKTEXT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "IssueRiskText");
    
    
    /**
     * Gets the "IssueRiskText" element
     */
    public java.lang.String getIssueRiskText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUERISKTEXT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "IssueRiskText" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetIssueRiskText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ISSUERISKTEXT$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "IssueRiskText" element
     */
    public void setIssueRiskText(java.lang.String issueRiskText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUERISKTEXT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISSUERISKTEXT$0);
            }
            target.setStringValue(issueRiskText);
        }
    }
    
    /**
     * Sets (as xml) the "IssueRiskText" element
     */
    public void xsetIssueRiskText(org.erdc.cobie.cobielite.core.CobieTextSimpleType issueRiskText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ISSUERISKTEXT$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ISSUERISKTEXT$0);
            }
            target.set(issueRiskText);
        }
    }
}
