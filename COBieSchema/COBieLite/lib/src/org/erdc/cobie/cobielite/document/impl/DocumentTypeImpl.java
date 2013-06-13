/*
 * XML Type:  DocumentType
 * Namespace: http://document.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.document.DocumentType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.document.impl;
/**
 * An XML DocumentType(@http://document.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class DocumentTypeImpl extends org.erdc.cobie.cobielite.core.impl.DocumentTypeImpl implements org.erdc.cobie.cobielite.document.DocumentType
{
    private static final long serialVersionUID = 1L;
    
    public DocumentTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DOCUMENTCATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "DocumentCategory");
    private static final javax.xml.namespace.QName DOCUMENTDESCRIPTION$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "DocumentDescription");
    private static final javax.xml.namespace.QName DOCUMENTURI$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "DocumentURI");
    private static final javax.xml.namespace.QName DOCUMENTREFERENCEURI$6 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "DocumentReferenceURI");
    private static final javax.xml.namespace.QName DOCUMENTATTRIBUTES$8 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "DocumentAttributes");
    private static final javax.xml.namespace.QName DOCUMENTISSUES$10 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "DocumentIssues");
    
    
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
     * True if has "DocumentCategory" element
     */
    public boolean isSetDocumentCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DOCUMENTCATEGORY$0) != 0;
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
    
    /**
     * Unsets the "DocumentCategory" element
     */
    public void unsetDocumentCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DOCUMENTCATEGORY$0, 0);
        }
    }
    
    /**
     * Gets the "DocumentDescription" element
     */
    public java.lang.String getDocumentDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTDESCRIPTION$2, 0);
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
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(DOCUMENTDESCRIPTION$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "DocumentDescription" element
     */
    public boolean isSetDocumentDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DOCUMENTDESCRIPTION$2) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTDESCRIPTION$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DOCUMENTDESCRIPTION$2);
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
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(DOCUMENTDESCRIPTION$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(DOCUMENTDESCRIPTION$2);
            }
            target.set(documentDescription);
        }
    }
    
    /**
     * Unsets the "DocumentDescription" element
     */
    public void unsetDocumentDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DOCUMENTDESCRIPTION$2, 0);
        }
    }
    
    /**
     * Gets the "DocumentURI" element
     */
    public java.lang.String getDocumentURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTURI$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "DocumentURI" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetDocumentURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(DOCUMENTURI$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "DocumentURI" element
     */
    public boolean isSetDocumentURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DOCUMENTURI$4) != 0;
        }
    }
    
    /**
     * Sets the "DocumentURI" element
     */
    public void setDocumentURI(java.lang.String documentURI)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTURI$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DOCUMENTURI$4);
            }
            target.setStringValue(documentURI);
        }
    }
    
    /**
     * Sets (as xml) the "DocumentURI" element
     */
    public void xsetDocumentURI(org.erdc.cobie.cobielite.core.CobieTextSimpleType documentURI)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(DOCUMENTURI$4, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(DOCUMENTURI$4);
            }
            target.set(documentURI);
        }
    }
    
    /**
     * Unsets the "DocumentURI" element
     */
    public void unsetDocumentURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DOCUMENTURI$4, 0);
        }
    }
    
    /**
     * Gets the "DocumentReferenceURI" element
     */
    public java.lang.String getDocumentReferenceURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTREFERENCEURI$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "DocumentReferenceURI" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetDocumentReferenceURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(DOCUMENTREFERENCEURI$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "DocumentReferenceURI" element
     */
    public boolean isSetDocumentReferenceURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DOCUMENTREFERENCEURI$6) != 0;
        }
    }
    
    /**
     * Sets the "DocumentReferenceURI" element
     */
    public void setDocumentReferenceURI(java.lang.String documentReferenceURI)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DOCUMENTREFERENCEURI$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DOCUMENTREFERENCEURI$6);
            }
            target.setStringValue(documentReferenceURI);
        }
    }
    
    /**
     * Sets (as xml) the "DocumentReferenceURI" element
     */
    public void xsetDocumentReferenceURI(org.erdc.cobie.cobielite.core.CobieTextSimpleType documentReferenceURI)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(DOCUMENTREFERENCEURI$6, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(DOCUMENTREFERENCEURI$6);
            }
            target.set(documentReferenceURI);
        }
    }
    
    /**
     * Unsets the "DocumentReferenceURI" element
     */
    public void unsetDocumentReferenceURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DOCUMENTREFERENCEURI$6, 0);
        }
    }
    
    /**
     * Gets the "DocumentAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getDocumentAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(DOCUMENTATTRIBUTES$8, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "DocumentAttributes" element
     */
    public boolean isSetDocumentAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DOCUMENTATTRIBUTES$8) != 0;
        }
    }
    
    /**
     * Sets the "DocumentAttributes" element
     */
    public void setDocumentAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType documentAttributes)
    {
        generatedSetterHelperImpl(documentAttributes, DOCUMENTATTRIBUTES$8, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "DocumentAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewDocumentAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(DOCUMENTATTRIBUTES$8);
            return target;
        }
    }
    
    /**
     * Unsets the "DocumentAttributes" element
     */
    public void unsetDocumentAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DOCUMENTATTRIBUTES$8, 0);
        }
    }
    
    /**
     * Gets the "DocumentIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getDocumentIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(DOCUMENTISSUES$10, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "DocumentIssues" element
     */
    public boolean isSetDocumentIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DOCUMENTISSUES$10) != 0;
        }
    }
    
    /**
     * Sets the "DocumentIssues" element
     */
    public void setDocumentIssues(org.erdc.cobie.cobielite.core.IssueCollectionType documentIssues)
    {
        generatedSetterHelperImpl(documentIssues, DOCUMENTISSUES$10, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "DocumentIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewDocumentIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(DOCUMENTISSUES$10);
            return target;
        }
    }
    
    /**
     * Unsets the "DocumentIssues" element
     */
    public void unsetDocumentIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DOCUMENTISSUES$10, 0);
        }
    }
}
