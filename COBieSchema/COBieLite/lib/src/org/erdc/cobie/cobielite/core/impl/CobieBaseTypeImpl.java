/*
 * XML Type:  CobieBaseType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.CobieBaseType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML CobieBaseType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class CobieBaseTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieComplexObjectTypeImpl implements org.erdc.cobie.cobielite.core.CobieBaseType
{
    private static final long serialVersionUID = 1L;
    
    public CobieBaseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXTERNALENTITYNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "externalEntityName");
    private static final javax.xml.namespace.QName EXTERNALID$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "externalID");
    private static final javax.xml.namespace.QName EXTERNALSYSTEMNAME$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "externalSystemName");
    
    
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
    
    /**
     * Gets the "externalID" attribute
     */
    public java.lang.String getExternalID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(EXTERNALID$2);
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
            target = (org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType)get_store().find_attribute_user(EXTERNALID$2);
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
            return get_store().find_attribute_user(EXTERNALID$2) != null;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(EXTERNALID$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(EXTERNALID$2);
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
            target = (org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType)get_store().find_attribute_user(EXTERNALID$2);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType)get_store().add_attribute_user(EXTERNALID$2);
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
            get_store().remove_attribute(EXTERNALID$2);
        }
    }
    
    /**
     * Gets the "externalSystemName" attribute
     */
    public java.lang.String getExternalSystemName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(EXTERNALSYSTEMNAME$4);
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
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_attribute_user(EXTERNALSYSTEMNAME$4);
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
            return get_store().find_attribute_user(EXTERNALSYSTEMNAME$4) != null;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(EXTERNALSYSTEMNAME$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(EXTERNALSYSTEMNAME$4);
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
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_attribute_user(EXTERNALSYSTEMNAME$4);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_attribute_user(EXTERNALSYSTEMNAME$4);
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
            get_store().remove_attribute(EXTERNALSYSTEMNAME$4);
        }
    }
}
