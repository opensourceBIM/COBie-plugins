/*
 * XML Type:  DocumentType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.DocumentType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML DocumentType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class DocumentTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieRowTypeImpl implements org.erdc.cobie.cobielite.core.DocumentType
{
    private static final long serialVersionUID = 1L;
    
    public DocumentTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DOCUMENTNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "DocumentName");
    
    
    /**
     * Gets the "DocumentName" element
     */
    public java.lang.String getDocumentName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "DocumentName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetDocumentName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(DOCUMENTNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "DocumentName" element
     */
    public void setDocumentName(java.lang.String documentName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DOCUMENTNAME$0);
            }
            target.setStringValue(documentName);
        }
    }
    
    /**
     * Sets (as xml) the "DocumentName" element
     */
    public void xsetDocumentName(org.erdc.cobie.cobielite.core.CobieNameSimpleType documentName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(DOCUMENTNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(DOCUMENTNAME$0);
            }
            target.set(documentName);
        }
    }
}
