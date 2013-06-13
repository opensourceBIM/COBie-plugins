/*
 * An XML attribute type.
 * Localname: externalEntityName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ExternalEntityNameAttribute
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one externalEntityName(@http://core.cobielite.cobie.erdc.org) attribute.
 *
 * This is a complex type.
 */
public class ExternalEntityNameAttributeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ExternalEntityNameAttribute
{
    private static final long serialVersionUID = 1L;
    
    public ExternalEntityNameAttributeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXTERNALENTITYNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "externalEntityName");
    
    
    /**
     * Gets the "externalEntityName" attribute
     */
    public java.lang.String getExternalEntityName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(EXTERNALENTITYNAME$0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "externalEntityName" attribute
     */
    public org.erdc.cobie.cobielite.core.ExternalEntityNameSimpleType xgetExternalEntityName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ExternalEntityNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.ExternalEntityNameSimpleType)get_store().find_attribute_user(EXTERNALENTITYNAME$0);
            return target;
        }
    }
    
    /**
     * True if has "externalEntityName" attribute
     */
    public boolean isSetExternalEntityName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(EXTERNALENTITYNAME$0) != null;
        }
    }
    
    /**
     * Sets the "externalEntityName" attribute
     */
    public void setExternalEntityName(java.lang.String externalEntityName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(EXTERNALENTITYNAME$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(EXTERNALENTITYNAME$0);
            }
            target.setStringValue(externalEntityName);
        }
    }
    
    /**
     * Sets (as xml) the "externalEntityName" attribute
     */
    public void xsetExternalEntityName(org.erdc.cobie.cobielite.core.ExternalEntityNameSimpleType externalEntityName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ExternalEntityNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.ExternalEntityNameSimpleType)get_store().find_attribute_user(EXTERNALENTITYNAME$0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.ExternalEntityNameSimpleType)get_store().add_attribute_user(EXTERNALENTITYNAME$0);
            }
            target.set(externalEntityName);
        }
    }
    
    /**
     * Unsets the "externalEntityName" attribute
     */
    public void unsetExternalEntityName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(EXTERNALENTITYNAME$0);
        }
    }
}
