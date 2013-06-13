/*
 * An XML attribute type.
 * Localname: propertySetName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.PropertySetNameAttribute
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one propertySetName(@http://core.cobielite.cobie.erdc.org) attribute.
 *
 * This is a complex type.
 */
public class PropertySetNameAttributeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.PropertySetNameAttribute
{
    private static final long serialVersionUID = 1L;
    
    public PropertySetNameAttributeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROPERTYSETNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "propertySetName");
    
    
    /**
     * Gets the "propertySetName" attribute
     */
    public java.lang.String getPropertySetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROPERTYSETNAME$0);
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
            target = (org.erdc.cobie.cobielite.core.PropertySetNameSimpleType)get_store().find_attribute_user(PROPERTYSETNAME$0);
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
            return get_store().find_attribute_user(PROPERTYSETNAME$0) != null;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROPERTYSETNAME$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PROPERTYSETNAME$0);
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
            target = (org.erdc.cobie.cobielite.core.PropertySetNameSimpleType)get_store().find_attribute_user(PROPERTYSETNAME$0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.PropertySetNameSimpleType)get_store().add_attribute_user(PROPERTYSETNAME$0);
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
            get_store().remove_attribute(PROPERTYSETNAME$0);
        }
    }
}
