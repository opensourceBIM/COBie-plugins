/*
 * XML Type:  AttributeType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML AttributeType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class AttributeTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieRowTypeImpl implements org.erdc.cobie.cobielite.core.AttributeType
{
    private static final long serialVersionUID = 1L;
    
    public AttributeTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTENAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeName");
    private static final javax.xml.namespace.QName ATTRIBUTECATEGORY$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeCategory");
    private static final javax.xml.namespace.QName PROPERTYSETNAME$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "propertySetName");
    private static final javax.xml.namespace.QName PROPERTYSETEXTERNALIDENTIFIER$6 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "propertySetExternalIdentifier");
    
    
    /**
     * Gets the "AttributeName" element
     */
    public java.lang.String getAttributeName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTENAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AttributeName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetAttributeName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(ATTRIBUTENAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AttributeName" element
     */
    public void setAttributeName(java.lang.String attributeName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTENAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ATTRIBUTENAME$0);
            }
            target.setStringValue(attributeName);
        }
    }
    
    /**
     * Sets (as xml) the "AttributeName" element
     */
    public void xsetAttributeName(org.erdc.cobie.cobielite.core.CobieNameSimpleType attributeName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(ATTRIBUTENAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(ATTRIBUTENAME$0);
            }
            target.set(attributeName);
        }
    }
    
    /**
     * Gets the "AttributeCategory" element
     */
    public java.lang.String getAttributeCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTECATEGORY$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AttributeCategory" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCategorySimpleType xgetAttributeCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCategorySimpleType)get_store().find_element_user(ATTRIBUTECATEGORY$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AttributeCategory" element
     */
    public void setAttributeCategory(java.lang.String attributeCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTECATEGORY$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ATTRIBUTECATEGORY$2);
            }
            target.setStringValue(attributeCategory);
        }
    }
    
    /**
     * Sets (as xml) the "AttributeCategory" element
     */
    public void xsetAttributeCategory(org.erdc.cobie.cobielite.core.AttributeCategorySimpleType attributeCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCategorySimpleType)get_store().find_element_user(ATTRIBUTECATEGORY$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.AttributeCategorySimpleType)get_store().add_element_user(ATTRIBUTECATEGORY$2);
            }
            target.set(attributeCategory);
        }
    }
    
    /**
     * Gets the "propertySetName" attribute
     */
    public java.lang.String getPropertySetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROPERTYSETNAME$4);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "propertySetName" attribute
     */
    public org.erdc.cobie.cobielite.core.PropertySetNameSimpleType xgetPropertySetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.PropertySetNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.PropertySetNameSimpleType)get_store().find_attribute_user(PROPERTYSETNAME$4);
            return target;
        }
    }
    
    /**
     * True if has "propertySetName" attribute
     */
    public boolean isSetPropertySetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(PROPERTYSETNAME$4) != null;
        }
    }
    
    /**
     * Sets the "propertySetName" attribute
     */
    public void setPropertySetName(java.lang.String propertySetName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROPERTYSETNAME$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PROPERTYSETNAME$4);
            }
            target.setStringValue(propertySetName);
        }
    }
    
    /**
     * Sets (as xml) the "propertySetName" attribute
     */
    public void xsetPropertySetName(org.erdc.cobie.cobielite.core.PropertySetNameSimpleType propertySetName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.PropertySetNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.PropertySetNameSimpleType)get_store().find_attribute_user(PROPERTYSETNAME$4);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.PropertySetNameSimpleType)get_store().add_attribute_user(PROPERTYSETNAME$4);
            }
            target.set(propertySetName);
        }
    }
    
    /**
     * Unsets the "propertySetName" attribute
     */
    public void unsetPropertySetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(PROPERTYSETNAME$4);
        }
    }
    
    /**
     * Gets the "propertySetExternalIdentifier" attribute
     */
    public java.lang.String getPropertySetExternalIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROPERTYSETEXTERNALIDENTIFIER$6);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "propertySetExternalIdentifier" attribute
     */
    public org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType xgetPropertySetExternalIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType)get_store().find_attribute_user(PROPERTYSETEXTERNALIDENTIFIER$6);
            return target;
        }
    }
    
    /**
     * True if has "propertySetExternalIdentifier" attribute
     */
    public boolean isSetPropertySetExternalIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(PROPERTYSETEXTERNALIDENTIFIER$6) != null;
        }
    }
    
    /**
     * Sets the "propertySetExternalIdentifier" attribute
     */
    public void setPropertySetExternalIdentifier(java.lang.String propertySetExternalIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROPERTYSETEXTERNALIDENTIFIER$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PROPERTYSETEXTERNALIDENTIFIER$6);
            }
            target.setStringValue(propertySetExternalIdentifier);
        }
    }
    
    /**
     * Sets (as xml) the "propertySetExternalIdentifier" attribute
     */
    public void xsetPropertySetExternalIdentifier(org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType propertySetExternalIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType)get_store().find_attribute_user(PROPERTYSETEXTERNALIDENTIFIER$6);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType)get_store().add_attribute_user(PROPERTYSETEXTERNALIDENTIFIER$6);
            }
            target.set(propertySetExternalIdentifier);
        }
    }
    
    /**
     * Unsets the "propertySetExternalIdentifier" attribute
     */
    public void unsetPropertySetExternalIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(PROPERTYSETEXTERNALIDENTIFIER$6);
        }
    }
}
