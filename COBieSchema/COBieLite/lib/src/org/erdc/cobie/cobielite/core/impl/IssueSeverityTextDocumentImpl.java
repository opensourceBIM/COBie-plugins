/*
 * An XML document type.
 * Localname: IssueSeverityText
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.IssueSeverityTextDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one IssueSeverityText(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class IssueSeverityTextDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.IssueSeverityTextDocument
{
    private static final long serialVersionUID = 1L;
    
    public IssueSeverityTextDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ISSUESEVERITYTEXT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "IssueSeverityText");
    
    
    /**
     * Gets the "IssueSeverityText" element
     */
    public java.lang.String getIssueSeverityText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUESEVERITYTEXT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "IssueSeverityText" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetIssueSeverityText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ISSUESEVERITYTEXT$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "IssueSeverityText" element
     */
    public void setIssueSeverityText(java.lang.String issueSeverityText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUESEVERITYTEXT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISSUESEVERITYTEXT$0);
            }
            target.setStringValue(issueSeverityText);
        }
    }
    
    /**
     * Sets (as xml) the "IssueSeverityText" element
     */
    public void xsetIssueSeverityText(org.erdc.cobie.cobielite.core.CobieTextSimpleType issueSeverityText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ISSUESEVERITYTEXT$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ISSUESEVERITYTEXT$0);
            }
            target.set(issueSeverityText);
        }
    }
}
