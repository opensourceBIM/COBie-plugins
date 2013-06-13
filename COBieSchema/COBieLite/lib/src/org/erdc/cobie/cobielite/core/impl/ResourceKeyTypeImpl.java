/*
 * XML Type:  ResourceKeyType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ResourceKeyType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML ResourceKeyType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class ResourceKeyTypeImpl extends org.erdc.cobie.cobielite.core.impl.AssetTypeKeyTypeImpl implements org.erdc.cobie.cobielite.core.ResourceKeyType
{
    private static final long serialVersionUID = 1L;
    
    public ResourceKeyTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RESOURCENAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ResourceName");
    
    
    /**
     * Gets the "ResourceName" element
     */
    public java.lang.String getResourceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESOURCENAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ResourceName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetResourceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(RESOURCENAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ResourceName" element
     */
    public void setResourceName(java.lang.String resourceName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESOURCENAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RESOURCENAME$0);
            }
            target.setStringValue(resourceName);
        }
    }
    
    /**
     * Sets (as xml) the "ResourceName" element
     */
    public void xsetResourceName(org.erdc.cobie.cobielite.core.CobieNameSimpleType resourceName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(RESOURCENAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(RESOURCENAME$0);
            }
            target.set(resourceName);
        }
    }
}
