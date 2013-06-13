/*
 * An XML document type.
 * Localname: ContactCategory
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactCategoryDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ContactCategory(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ContactCategoryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ContactCategoryDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContactCategoryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTCATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactCategory");
    
    
    /**
     * Gets the "ContactCategory" element
     */
    public java.lang.String getContactCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTCATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactCategory" element
     */
    public org.erdc.cobie.cobielite.core.CobieCategorySimpleType xgetContactCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieCategorySimpleType)get_store().find_element_user(CONTACTCATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ContactCategory" element
     */
    public void setContactCategory(java.lang.String contactCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTCATEGORY$0);
            }
            target.setStringValue(contactCategory);
        }
    }
    
    /**
     * Sets (as xml) the "ContactCategory" element
     */
    public void xsetContactCategory(org.erdc.cobie.cobielite.core.CobieCategorySimpleType contactCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieCategorySimpleType)get_store().find_element_user(CONTACTCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieCategorySimpleType)get_store().add_element_user(CONTACTCATEGORY$0);
            }
            target.set(contactCategory);
        }
    }
}
