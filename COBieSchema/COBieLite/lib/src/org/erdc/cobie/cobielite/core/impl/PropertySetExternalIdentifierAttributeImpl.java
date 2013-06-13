/*
 * An XML attribute type.
 * Localname: propertySetExternalIdentifier
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.PropertySetExternalIdentifierAttribute
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one propertySetExternalIdentifier(@http://core.cobielite.cobie.erdc.org) attribute.
 *
 * This is a complex type.
 */
public class PropertySetExternalIdentifierAttributeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.PropertySetExternalIdentifierAttribute
{
    private static final long serialVersionUID = 1L;
    
    public PropertySetExternalIdentifierAttributeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROPERTYSETEXTERNALIDENTIFIER$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "propertySetExternalIdentifier");
    
    
    /**
     * Gets the "propertySetExternalIdentifier" attribute
     */
    public java.lang.String getPropertySetExternalIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROPERTYSETEXTERNALIDENTIFIER$0);
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
            target = (org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType)get_store().find_attribute_user(PROPERTYSETEXTERNALIDENTIFIER$0);
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
            return get_store().find_attribute_user(PROPERTYSETEXTERNALIDENTIFIER$0) != null;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROPERTYSETEXTERNALIDENTIFIER$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PROPERTYSETEXTERNALIDENTIFIER$0);
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
            target = (org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType)get_store().find_attribute_user(PROPERTYSETEXTERNALIDENTIFIER$0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType)get_store().add_attribute_user(PROPERTYSETEXTERNALIDENTIFIER$0);
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
            get_store().remove_attribute(PROPERTYSETEXTERNALIDENTIFIER$0);
        }
    }
}
