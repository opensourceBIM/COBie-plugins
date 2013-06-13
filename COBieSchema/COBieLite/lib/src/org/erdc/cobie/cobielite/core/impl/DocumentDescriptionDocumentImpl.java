/*
 * An XML document type.
 * Localname: DocumentDescription
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.DocumentDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one DocumentDescription(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class DocumentDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.DocumentDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public DocumentDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DOCUMENTDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "DocumentDescription");
    
    
    /**
     * Gets the "DocumentDescription" element
     */
    public java.lang.String getDocumentDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "DocumentDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetDocumentDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(DOCUMENTDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "DocumentDescription" element
     */
    public void setDocumentDescription(java.lang.String documentDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DOCUMENTDESCRIPTION$0);
            }
            target.setStringValue(documentDescription);
        }
    }
    
    /**
     * Sets (as xml) the "DocumentDescription" element
     */
    public void xsetDocumentDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType documentDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(DOCUMENTDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(DOCUMENTDESCRIPTION$0);
            }
            target.set(documentDescription);
        }
    }
}
