/*
 * XML Type:  ResourceType
 * Namespace: http://resource.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.resource.ResourceType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.resource.impl;
/**
 * An XML ResourceType(@http://resource.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class ResourceTypeImpl extends org.erdc.cobie.cobielite.core.impl.ResourceTypeImpl implements org.erdc.cobie.cobielite.resource.ResourceType
{
    private static final long serialVersionUID = 1L;
    
    public ResourceTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RESOURCECATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ResourceCategory");
    private static final javax.xml.namespace.QName RESOURCEDESCRIPTION$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ResourceDescription");
    private static final javax.xml.namespace.QName RESOURCEATTRIBUTES$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ResourceAttributes");
    private static final javax.xml.namespace.QName RESOURCEDOCUMENTS$6 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ResourceDocuments");
    private static final javax.xml.namespace.QName RESOURCEISSUES$8 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ResourceIssues");
    
    
    /**
     * Gets the "ResourceCategory" element
     */
    public java.lang.String getResourceCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESOURCECATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ResourceCategory" element
     */
    public org.erdc.cobie.cobielite.core.ResourceCategorySimpleType xgetResourceCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ResourceCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.ResourceCategorySimpleType)get_store().find_element_user(RESOURCECATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "ResourceCategory" element
     */
    public boolean isSetResourceCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RESOURCECATEGORY$0) != 0;
        }
    }
    
    /**
     * Sets the "ResourceCategory" element
     */
    public void setResourceCategory(java.lang.String resourceCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESOURCECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RESOURCECATEGORY$0);
            }
            target.setStringValue(resourceCategory);
        }
    }
    
    /**
     * Sets (as xml) the "ResourceCategory" element
     */
    public void xsetResourceCategory(org.erdc.cobie.cobielite.core.ResourceCategorySimpleType resourceCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ResourceCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.ResourceCategorySimpleType)get_store().find_element_user(RESOURCECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.ResourceCategorySimpleType)get_store().add_element_user(RESOURCECATEGORY$0);
            }
            target.set(resourceCategory);
        }
    }
    
    /**
     * Unsets the "ResourceCategory" element
     */
    public void unsetResourceCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RESOURCECATEGORY$0, 0);
        }
    }
    
    /**
     * Gets the "ResourceDescription" element
     */
    public java.lang.String getResourceDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESOURCEDESCRIPTION$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ResourceDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetResourceDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(RESOURCEDESCRIPTION$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "ResourceDescription" element
     */
    public boolean isSetResourceDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RESOURCEDESCRIPTION$2) != 0;
        }
    }
    
    /**
     * Sets the "ResourceDescription" element
     */
    public void setResourceDescription(java.lang.String resourceDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESOURCEDESCRIPTION$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RESOURCEDESCRIPTION$2);
            }
            target.setStringValue(resourceDescription);
        }
    }
    
    /**
     * Sets (as xml) the "ResourceDescription" element
     */
    public void xsetResourceDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType resourceDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(RESOURCEDESCRIPTION$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(RESOURCEDESCRIPTION$2);
            }
            target.set(resourceDescription);
        }
    }
    
    /**
     * Unsets the "ResourceDescription" element
     */
    public void unsetResourceDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RESOURCEDESCRIPTION$2, 0);
        }
    }
    
    /**
     * Gets the "ResourceAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getResourceAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(RESOURCEATTRIBUTES$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ResourceAttributes" element
     */
    public boolean isSetResourceAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RESOURCEATTRIBUTES$4) != 0;
        }
    }
    
    /**
     * Sets the "ResourceAttributes" element
     */
    public void setResourceAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType resourceAttributes)
    {
        generatedSetterHelperImpl(resourceAttributes, RESOURCEATTRIBUTES$4, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ResourceAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewResourceAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(RESOURCEATTRIBUTES$4);
            return target;
        }
    }
    
    /**
     * Unsets the "ResourceAttributes" element
     */
    public void unsetResourceAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RESOURCEATTRIBUTES$4, 0);
        }
    }
    
    /**
     * Gets the "ResourceDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getResourceDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(RESOURCEDOCUMENTS$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ResourceDocuments" element
     */
    public boolean isSetResourceDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RESOURCEDOCUMENTS$6) != 0;
        }
    }
    
    /**
     * Sets the "ResourceDocuments" element
     */
    public void setResourceDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType resourceDocuments)
    {
        generatedSetterHelperImpl(resourceDocuments, RESOURCEDOCUMENTS$6, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ResourceDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewResourceDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(RESOURCEDOCUMENTS$6);
            return target;
        }
    }
    
    /**
     * Unsets the "ResourceDocuments" element
     */
    public void unsetResourceDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RESOURCEDOCUMENTS$6, 0);
        }
    }
    
    /**
     * Gets the "ResourceIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getResourceIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(RESOURCEISSUES$8, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ResourceIssues" element
     */
    public boolean isSetResourceIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RESOURCEISSUES$8) != 0;
        }
    }
    
    /**
     * Sets the "ResourceIssues" element
     */
    public void setResourceIssues(org.erdc.cobie.cobielite.core.IssueCollectionType resourceIssues)
    {
        generatedSetterHelperImpl(resourceIssues, RESOURCEISSUES$8, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ResourceIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewResourceIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(RESOURCEISSUES$8);
            return target;
        }
    }
    
    /**
     * Unsets the "ResourceIssues" element
     */
    public void unsetResourceIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RESOURCEISSUES$8, 0);
        }
    }
}
