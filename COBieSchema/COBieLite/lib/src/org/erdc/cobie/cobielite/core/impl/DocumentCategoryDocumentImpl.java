/*
 * An XML document type.
 * Localname: DocumentCategory
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.DocumentCategoryDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one DocumentCategory(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class DocumentCategoryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.DocumentCategoryDocument
{
    private static final long serialVersionUID = 1L;
    
    public DocumentCategoryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DOCUMENTCATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "DocumentCategory");
    
    
    /**
     * Gets the "DocumentCategory" element
     */
    public java.lang.String getDocumentCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTCATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "DocumentCategory" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCategorySimpleType xgetDocumentCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCategorySimpleType)get_store().find_element_user(DOCUMENTCATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "DocumentCategory" element
     */
    public void setDocumentCategory(java.lang.String documentCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DOCUMENTCATEGORY$0);
            }
            target.setStringValue(documentCategory);
        }
    }
    
    /**
     * Sets (as xml) the "DocumentCategory" element
     */
    public void xsetDocumentCategory(org.erdc.cobie.cobielite.core.DocumentCategorySimpleType documentCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCategorySimpleType)get_store().find_element_user(DOCUMENTCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.DocumentCategorySimpleType)get_store().add_element_user(DOCUMENTCATEGORY$0);
            }
            target.set(documentCategory);
        }
    }
}
