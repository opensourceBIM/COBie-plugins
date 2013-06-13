/*
 * XML Type:  DocumentCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.DocumentCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML DocumentCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class DocumentCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieWorksheetTypeImpl implements org.erdc.cobie.cobielite.core.DocumentCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public DocumentCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DOCUMENT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Document");
    private static final org.apache.xmlbeans.QNameSet DOCUMENT$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Document"),
        new javax.xml.namespace.QName("http://document.cobielite.cobie.erdc.org", "Document"),
    });
    
    
    /**
     * Gets array of all "Document" elements
     */
    public org.erdc.cobie.cobielite.core.DocumentType[] getDocumentArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(DOCUMENT$1, targetList);
            org.erdc.cobie.cobielite.core.DocumentType[] result = new org.erdc.cobie.cobielite.core.DocumentType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Document" element
     */
    public org.erdc.cobie.cobielite.core.DocumentType getDocumentArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentType)get_store().find_element_user(DOCUMENT$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Document" element
     */
    public int sizeOfDocumentArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DOCUMENT$1);
        }
    }
    
    /**
     * Sets array of all "Document" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setDocumentArray(org.erdc.cobie.cobielite.core.DocumentType[] documentArray)
    {
        check_orphaned();
        arraySetterHelper(documentArray, DOCUMENT$0, DOCUMENT$1);
    }
    
    /**
     * Sets ith "Document" element
     */
    public void setDocumentArray(int i, org.erdc.cobie.cobielite.core.DocumentType document)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentType)get_store().find_element_user(DOCUMENT$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(document);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Document" element
     */
    public org.erdc.cobie.cobielite.core.DocumentType insertNewDocument(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentType)get_store().insert_element_user(DOCUMENT$1, DOCUMENT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Document" element
     */
    public org.erdc.cobie.cobielite.core.DocumentType addNewDocument()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentType)get_store().add_element_user(DOCUMENT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Document" element
     */
    public void removeDocument(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DOCUMENT$1, i);
        }
    }
}
