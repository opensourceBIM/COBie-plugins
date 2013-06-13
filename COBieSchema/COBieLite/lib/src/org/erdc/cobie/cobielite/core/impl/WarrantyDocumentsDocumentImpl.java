/*
 * An XML document type.
 * Localname: WarrantyDocuments
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.WarrantyDocumentsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one WarrantyDocuments(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class WarrantyDocumentsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.WarrantyDocumentsDocument
{
    private static final long serialVersionUID = 1L;
    
    public WarrantyDocumentsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WARRANTYDOCUMENTS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "WarrantyDocuments");
    
    
    /**
     * Gets the "WarrantyDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getWarrantyDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(WARRANTYDOCUMENTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "WarrantyDocuments" element
     */
    public void setWarrantyDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType warrantyDocuments)
    {
        generatedSetterHelperImpl(warrantyDocuments, WARRANTYDOCUMENTS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "WarrantyDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewWarrantyDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(WARRANTYDOCUMENTS$0);
            return target;
        }
    }
}
