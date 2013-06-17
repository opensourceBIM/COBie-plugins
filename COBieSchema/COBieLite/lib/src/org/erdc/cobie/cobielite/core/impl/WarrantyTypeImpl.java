/*
 * XML Type:  WarrantyType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.WarrantyType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML WarrantyType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class WarrantyTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieBaseTypeImpl implements org.erdc.cobie.cobielite.core.WarrantyType
{
    private static final long serialVersionUID = 1L;
    
    public WarrantyTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WARRANTYNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "WarrantyName");
    private static final javax.xml.namespace.QName WARRANTYCATEGORY$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "WarrantyCategory");
    private static final javax.xml.namespace.QName WARRANTYDURATION$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "WarrantyDuration");
    private static final javax.xml.namespace.QName WARRANTYGAURANTORCONTACTASSIGNMENTS$6 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "WarrantyGaurantorContactAssignments");
    private static final javax.xml.namespace.QName WARRANTYATTRIBUTES$8 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "WarrantyAttributes");
    private static final javax.xml.namespace.QName WARRANTYDOCUMENTS$10 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "WarrantyDocuments");
    private static final javax.xml.namespace.QName WARRANTYISSUES$12 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "WarrantyIssues");
    
    
    /**
     * Gets the "WarrantyName" element
     */
    public java.lang.String getWarrantyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "WarrantyName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetWarrantyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(WARRANTYNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "WarrantyName" element
     */
    public void setWarrantyName(java.lang.String warrantyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WARRANTYNAME$0);
            }
            target.setStringValue(warrantyName);
        }
    }
    
    /**
     * Sets (as xml) the "WarrantyName" element
     */
    public void xsetWarrantyName(org.erdc.cobie.cobielite.core.CobieNameSimpleType warrantyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(WARRANTYNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(WARRANTYNAME$0);
            }
            target.set(warrantyName);
        }
    }
    
    /**
     * Gets the "WarrantyCategory" element
     */
    public java.lang.String getWarrantyCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYCATEGORY$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "WarrantyCategory" element
     */
    public org.erdc.cobie.cobielite.core.WarrantyCategorySimpleType xgetWarrantyCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.WarrantyCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.WarrantyCategorySimpleType)get_store().find_element_user(WARRANTYCATEGORY$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "WarrantyCategory" element
     */
    public void setWarrantyCategory(java.lang.String warrantyCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYCATEGORY$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WARRANTYCATEGORY$2);
            }
            target.setStringValue(warrantyCategory);
        }
    }
    
    /**
     * Sets (as xml) the "WarrantyCategory" element
     */
    public void xsetWarrantyCategory(org.erdc.cobie.cobielite.core.WarrantyCategorySimpleType warrantyCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.WarrantyCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.WarrantyCategorySimpleType)get_store().find_element_user(WARRANTYCATEGORY$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.WarrantyCategorySimpleType)get_store().add_element_user(WARRANTYCATEGORY$2);
            }
            target.set(warrantyCategory);
        }
    }
    
    /**
     * Gets the "WarrantyDuration" element
     */
    public org.erdc.cobie.cobielite.core.IntegerValueType getWarrantyDuration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IntegerValueType target = null;
            target = (org.erdc.cobie.cobielite.core.IntegerValueType)get_store().find_element_user(WARRANTYDURATION$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "WarrantyDuration" element
     */
    public boolean isSetWarrantyDuration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WARRANTYDURATION$4) != 0;
        }
    }
    
    /**
     * Sets the "WarrantyDuration" element
     */
    public void setWarrantyDuration(org.erdc.cobie.cobielite.core.IntegerValueType warrantyDuration)
    {
        generatedSetterHelperImpl(warrantyDuration, WARRANTYDURATION$4, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "WarrantyDuration" element
     */
    public org.erdc.cobie.cobielite.core.IntegerValueType addNewWarrantyDuration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IntegerValueType target = null;
            target = (org.erdc.cobie.cobielite.core.IntegerValueType)get_store().add_element_user(WARRANTYDURATION$4);
            return target;
        }
    }
    
    /**
     * Unsets the "WarrantyDuration" element
     */
    public void unsetWarrantyDuration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WARRANTYDURATION$4, 0);
        }
    }
    
    /**
     * Gets the "WarrantyGaurantorContactAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType getWarrantyGaurantorContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType)get_store().find_element_user(WARRANTYGAURANTORCONTACTASSIGNMENTS$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "WarrantyGaurantorContactAssignments" element
     */
    public boolean isSetWarrantyGaurantorContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WARRANTYGAURANTORCONTACTASSIGNMENTS$6) != 0;
        }
    }
    
    /**
     * Sets the "WarrantyGaurantorContactAssignments" element
     */
    public void setWarrantyGaurantorContactAssignments(org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType warrantyGaurantorContactAssignments)
    {
        generatedSetterHelperImpl(warrantyGaurantorContactAssignments, WARRANTYGAURANTORCONTACTASSIGNMENTS$6, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "WarrantyGaurantorContactAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType addNewWarrantyGaurantorContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType)get_store().add_element_user(WARRANTYGAURANTORCONTACTASSIGNMENTS$6);
            return target;
        }
    }
    
    /**
     * Unsets the "WarrantyGaurantorContactAssignments" element
     */
    public void unsetWarrantyGaurantorContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WARRANTYGAURANTORCONTACTASSIGNMENTS$6, 0);
        }
    }
    
    /**
     * Gets the "WarrantyAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getWarrantyAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(WARRANTYATTRIBUTES$8, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "WarrantyAttributes" element
     */
    public boolean isSetWarrantyAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WARRANTYATTRIBUTES$8) != 0;
        }
    }
    
    /**
     * Sets the "WarrantyAttributes" element
     */
    public void setWarrantyAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType warrantyAttributes)
    {
        generatedSetterHelperImpl(warrantyAttributes, WARRANTYATTRIBUTES$8, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "WarrantyAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewWarrantyAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(WARRANTYATTRIBUTES$8);
            return target;
        }
    }
    
    /**
     * Unsets the "WarrantyAttributes" element
     */
    public void unsetWarrantyAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WARRANTYATTRIBUTES$8, 0);
        }
    }
    
    /**
     * Gets the "WarrantyDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getWarrantyDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(WARRANTYDOCUMENTS$10, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "WarrantyDocuments" element
     */
    public boolean isSetWarrantyDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WARRANTYDOCUMENTS$10) != 0;
        }
    }
    
    /**
     * Sets the "WarrantyDocuments" element
     */
    public void setWarrantyDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType warrantyDocuments)
    {
        generatedSetterHelperImpl(warrantyDocuments, WARRANTYDOCUMENTS$10, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(WARRANTYDOCUMENTS$10);
            return target;
        }
    }
    
    /**
     * Unsets the "WarrantyDocuments" element
     */
    public void unsetWarrantyDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WARRANTYDOCUMENTS$10, 0);
        }
    }
    
    /**
     * Gets the "WarrantyIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getWarrantyIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(WARRANTYISSUES$12, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "WarrantyIssues" element
     */
    public boolean isSetWarrantyIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WARRANTYISSUES$12) != 0;
        }
    }
    
    /**
     * Sets the "WarrantyIssues" element
     */
    public void setWarrantyIssues(org.erdc.cobie.cobielite.core.IssueCollectionType warrantyIssues)
    {
        generatedSetterHelperImpl(warrantyIssues, WARRANTYISSUES$12, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "WarrantyIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewWarrantyIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(WARRANTYISSUES$12);
            return target;
        }
    }
    
    /**
     * Unsets the "WarrantyIssues" element
     */
    public void unsetWarrantyIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WARRANTYISSUES$12, 0);
        }
    }
}
