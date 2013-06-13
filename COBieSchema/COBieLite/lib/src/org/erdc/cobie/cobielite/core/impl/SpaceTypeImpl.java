/*
 * XML Type:  SpaceType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpaceType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML SpaceType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class SpaceTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieBaseTypeImpl implements org.erdc.cobie.cobielite.core.SpaceType
{
    private static final long serialVersionUID = 1L;
    
    public SpaceTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPACENAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceName");
    
    
    /**
     * Gets the "SpaceName" element
     */
    public java.lang.String getSpaceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPACENAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SpaceName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetSpaceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(SPACENAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SpaceName" element
     */
    public void setSpaceName(java.lang.String spaceName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPACENAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SPACENAME$0);
            }
            target.setStringValue(spaceName);
        }
    }
    
    /**
     * Sets (as xml) the "SpaceName" element
     */
    public void xsetSpaceName(org.erdc.cobie.cobielite.core.CobieNameSimpleType spaceName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(SPACENAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(SPACENAME$0);
            }
            target.set(spaceName);
        }
    }
}
