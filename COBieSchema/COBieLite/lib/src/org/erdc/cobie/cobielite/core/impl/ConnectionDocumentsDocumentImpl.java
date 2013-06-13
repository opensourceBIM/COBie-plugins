/*
 * An XML document type.
 * Localname: ConnectionDocuments
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ConnectionDocumentsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ConnectionDocuments(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ConnectionDocumentsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ConnectionDocumentsDocument
{
    private static final long serialVersionUID = 1L;
    
    public ConnectionDocumentsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONNECTIONDOCUMENTS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ConnectionDocuments");
    
    
    /**
     * Gets the "ConnectionDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getConnectionDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(CONNECTIONDOCUMENTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ConnectionDocuments" element
     */
    public void setConnectionDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType connectionDocuments)
    {
        generatedSetterHelperImpl(connectionDocuments, CONNECTIONDOCUMENTS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ConnectionDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewConnectionDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(CONNECTIONDOCUMENTS$0);
            return target;
        }
    }
}
