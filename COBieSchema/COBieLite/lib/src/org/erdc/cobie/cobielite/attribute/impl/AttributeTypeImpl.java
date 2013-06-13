/*
 * XML Type:  AttributeType
 * Namespace: http://attribute.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.attribute.AttributeType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.attribute.impl;
/**
 * An XML AttributeType(@http://attribute.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class AttributeTypeImpl extends org.erdc.cobie.cobielite.core.impl.AttributeTypeImpl implements org.erdc.cobie.cobielite.attribute.AttributeType
{
    private static final long serialVersionUID = 1L;
    
    public AttributeTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTEDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeDescription");
    private static final javax.xml.namespace.QName ATTRIBUTEVALUE$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeValue");
    private static final javax.xml.namespace.QName ATTRIBUTEISSUES$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeIssues");
    
    
    /**
     * Gets the "AttributeDescription" element
     */
    public java.lang.String getAttributeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTEDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AttributeDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAttributeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ATTRIBUTEDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "AttributeDescription" element
     */
    public boolean isSetAttributeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ATTRIBUTEDESCRIPTION$0) != 0;
        }
    }
    
    /**
     * Sets the "AttributeDescription" element
     */
    public void setAttributeDescription(java.lang.String attributeDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTEDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ATTRIBUTEDESCRIPTION$0);
            }
            target.setStringValue(attributeDescription);
        }
    }
    
    /**
     * Sets (as xml) the "AttributeDescription" element
     */
    public void xsetAttributeDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType attributeDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ATTRIBUTEDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(ATTRIBUTEDESCRIPTION$0);
            }
            target.set(attributeDescription);
        }
    }
    
    /**
     * Unsets the "AttributeDescription" element
     */
    public void unsetAttributeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ATTRIBUTEDESCRIPTION$0, 0);
        }
    }
    
    /**
     * Gets the "AttributeValue" element
     */
    public org.erdc.cobie.cobielite.core.AttributeValueType getAttributeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeValueType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeValueType)get_store().find_element_user(ATTRIBUTEVALUE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AttributeValue" element
     */
    public boolean isSetAttributeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ATTRIBUTEVALUE$2) != 0;
        }
    }
    
    /**
     * Sets the "AttributeValue" element
     */
    public void setAttributeValue(org.erdc.cobie.cobielite.core.AttributeValueType attributeValue)
    {
        generatedSetterHelperImpl(attributeValue, ATTRIBUTEVALUE$2, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AttributeValue" element
     */
    public org.erdc.cobie.cobielite.core.AttributeValueType addNewAttributeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeValueType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeValueType)get_store().add_element_user(ATTRIBUTEVALUE$2);
            return target;
        }
    }
    
    /**
     * Unsets the "AttributeValue" element
     */
    public void unsetAttributeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ATTRIBUTEVALUE$2, 0);
        }
    }
    
    /**
     * Gets the "AttributeIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getAttributeIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(ATTRIBUTEISSUES$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AttributeIssues" element
     */
    public boolean isSetAttributeIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ATTRIBUTEISSUES$4) != 0;
        }
    }
    
    /**
     * Sets the "AttributeIssues" element
     */
    public void setAttributeIssues(org.erdc.cobie.cobielite.core.IssueCollectionType attributeIssues)
    {
        generatedSetterHelperImpl(attributeIssues, ATTRIBUTEISSUES$4, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AttributeIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewAttributeIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(ATTRIBUTEISSUES$4);
            return target;
        }
    }
    
    /**
     * Unsets the "AttributeIssues" element
     */
    public void unsetAttributeIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ATTRIBUTEISSUES$4, 0);
        }
    }
}
