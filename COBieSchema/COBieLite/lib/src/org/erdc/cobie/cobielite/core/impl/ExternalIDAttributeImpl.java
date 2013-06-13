/*
 * An XML attribute type.
 * Localname: externalID
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ExternalIDAttribute
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one externalID(@http://core.cobielite.cobie.erdc.org) attribute.
 *
 * This is a complex type.
 */
public class ExternalIDAttributeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ExternalIDAttribute
{
    private static final long serialVersionUID = 1L;
    
    public ExternalIDAttributeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXTERNALID$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "externalID");
    
    
    /**
     * Gets the "externalID" attribute
     */
    public java.lang.String getExternalID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(EXTERNALID$0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "externalID" attribute
     */
    public org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType xgetExternalID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType)get_store().find_attribute_user(EXTERNALID$0);
            return target;
        }
    }
    
    /**
     * True if has "externalID" attribute
     */
    public boolean isSetExternalID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(EXTERNALID$0) != null;
        }
    }
    
    /**
     * Sets the "externalID" attribute
     */
    public void setExternalID(java.lang.String externalID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(EXTERNALID$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(EXTERNALID$0);
            }
            target.setStringValue(externalID);
        }
    }
    
    /**
     * Sets (as xml) the "externalID" attribute
     */
    public void xsetExternalID(org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType externalID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType)get_store().find_attribute_user(EXTERNALID$0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType)get_store().add_attribute_user(EXTERNALID$0);
            }
            target.set(externalID);
        }
    }
    
    /**
     * Unsets the "externalID" attribute
     */
    public void unsetExternalID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(EXTERNALID$0);
        }
    }
}
