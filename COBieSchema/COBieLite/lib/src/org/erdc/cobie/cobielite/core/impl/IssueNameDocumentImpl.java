/*
 * An XML document type.
 * Localname: IssueName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.IssueNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one IssueName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class IssueNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.IssueNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public IssueNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ISSUENAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "IssueName");
    
    
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
}
