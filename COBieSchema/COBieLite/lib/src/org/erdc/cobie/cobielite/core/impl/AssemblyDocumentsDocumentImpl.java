/*
 * An XML document type.
 * Localname: AssemblyDocuments
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssemblyDocumentsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssemblyDocuments(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssemblyDocumentsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssemblyDocumentsDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssemblyDocumentsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSEMBLYDOCUMENTS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssemblyDocuments");
    
    
    /**
     * Gets the "AssemblyDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getAssemblyDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(ASSEMBLYDOCUMENTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AssemblyDocuments" element
     */
    public void setAssemblyDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType assemblyDocuments)
    {
        generatedSetterHelperImpl(assemblyDocuments, ASSEMBLYDOCUMENTS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssemblyDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewAssemblyDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(ASSEMBLYDOCUMENTS$0);
            return target;
        }
    }
}
