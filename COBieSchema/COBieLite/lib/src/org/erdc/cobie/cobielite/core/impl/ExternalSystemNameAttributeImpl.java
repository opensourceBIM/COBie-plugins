/*
 * An XML attribute type.
 * Localname: externalSystemName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ExternalSystemNameAttribute
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one externalSystemName(@http://core.cobielite.cobie.erdc.org) attribute.
 *
 * This is a complex type.
 */
public class ExternalSystemNameAttributeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ExternalSystemNameAttribute
{
    private static final long serialVersionUID = 1L;
    
    public ExternalSystemNameAttributeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXTERNALSYSTEMNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "externalSystemName");
    
    
    /**
     * Gets the "externalSystemName" attribute
     */
    public java.lang.String getExternalSystemName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(EXTERNALSYSTEMNAME$0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "externalSystemName" attribute
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetExternalSystemName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_attribute_user(EXTERNALSYSTEMNAME$0);
            return target;
        }
    }
    
    /**
     * True if has "externalSystemName" attribute
     */
    public boolean isSetExternalSystemName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(EXTERNALSYSTEMNAME$0) != null;
        }
    }
    
    /**
     * Sets the "externalSystemName" attribute
     */
    public void setExternalSystemName(java.lang.String externalSystemName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(EXTERNALSYSTEMNAME$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(EXTERNALSYSTEMNAME$0);
            }
            target.setStringValue(externalSystemName);
        }
    }
    
    /**
     * Sets (as xml) the "externalSystemName" attribute
     */
    public void xsetExternalSystemName(org.erdc.cobie.cobielite.core.CobieTextSimpleType externalSystemName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_attribute_user(EXTERNALSYSTEMNAME$0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_attribute_user(EXTERNALSYSTEMNAME$0);
            }
            target.set(externalSystemName);
        }
    }
    
    /**
     * Unsets the "externalSystemName" attribute
     */
    public void unsetExternalSystemName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(EXTERNALSYSTEMNAME$0);
        }
    }
}
