/*
 * An XML document type.
 * Localname: SystemDocuments
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SystemDocumentsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SystemDocuments(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SystemDocumentsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SystemDocumentsDocument
{
    private static final long serialVersionUID = 1L;
    
    public SystemDocumentsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SYSTEMDOCUMENTS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SystemDocuments");
    
    
    /**
     * Gets the "SystemDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getSystemDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(SYSTEMDOCUMENTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "SystemDocuments" element
     */
    public void setSystemDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType systemDocuments)
    {
        generatedSetterHelperImpl(systemDocuments, SYSTEMDOCUMENTS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SystemDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewSystemDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(SYSTEMDOCUMENTS$0);
            return target;
        }
    }
}
