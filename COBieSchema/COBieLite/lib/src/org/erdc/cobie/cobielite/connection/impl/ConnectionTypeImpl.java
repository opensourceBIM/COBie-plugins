/*
 * XML Type:  ConnectionType
 * Namespace: http://connection.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.connection.ConnectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.connection.impl;
/**
 * An XML ConnectionType(@http://connection.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class ConnectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.ConnectionTypeImpl implements org.erdc.cobie.cobielite.connection.ConnectionType
{
    private static final long serialVersionUID = 1L;
    
    public ConnectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONNECTIONASSET1NAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ConnectionAsset1Name");
    private static final javax.xml.namespace.QName CONNECTIONASSET1PORTNAME$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ConnectionAsset1PortName");
    private static final javax.xml.namespace.QName CONNECTIONASSET2NAME$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ConnectionAsset2Name");
    private static final javax.xml.namespace.QName CONNECTIONASSET2PORTNAME$6 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ConnectionAsset2PortName");
    private static final javax.xml.namespace.QName CONNECTIONDESCRIPTION$8 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ConnectionDescription");
    private static final javax.xml.namespace.QName CONNECTIONATTRIBUTES$10 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ConnectionAttributes");
    private static final javax.xml.namespace.QName CONNECTIONDOCUMENTS$12 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ConnectionDocuments");
    private static final javax.xml.namespace.QName CONNECTIONISSUES$14 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ConnectionIssues");
    
    
    /**
     * Gets the "ConnectionAsset1Name" element
     */
    public java.lang.String getConnectionAsset1Name()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONASSET1NAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ConnectionAsset1Name" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetConnectionAsset1Name()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(CONNECTIONASSET1NAME$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "ConnectionAsset1Name" element
     */
    public boolean isSetConnectionAsset1Name()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONNECTIONASSET1NAME$0) != 0;
        }
    }
    
    /**
     * Sets the "ConnectionAsset1Name" element
     */
    public void setConnectionAsset1Name(java.lang.String connectionAsset1Name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONASSET1NAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONNECTIONASSET1NAME$0);
            }
            target.setStringValue(connectionAsset1Name);
        }
    }
    
    /**
     * Sets (as xml) the "ConnectionAsset1Name" element
     */
    public void xsetConnectionAsset1Name(org.erdc.cobie.cobielite.core.CobieNameSimpleType connectionAsset1Name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(CONNECTIONASSET1NAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(CONNECTIONASSET1NAME$0);
            }
            target.set(connectionAsset1Name);
        }
    }
    
    /**
     * Unsets the "ConnectionAsset1Name" element
     */
    public void unsetConnectionAsset1Name()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONNECTIONASSET1NAME$0, 0);
        }
    }
    
    /**
     * Gets the "ConnectionAsset1PortName" element
     */
    public java.lang.String getConnectionAsset1PortName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONASSET1PORTNAME$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ConnectionAsset1PortName" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetConnectionAsset1PortName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONNECTIONASSET1PORTNAME$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "ConnectionAsset1PortName" element
     */
    public boolean isSetConnectionAsset1PortName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONNECTIONASSET1PORTNAME$2) != 0;
        }
    }
    
    /**
     * Sets the "ConnectionAsset1PortName" element
     */
    public void setConnectionAsset1PortName(java.lang.String connectionAsset1PortName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONASSET1PORTNAME$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONNECTIONASSET1PORTNAME$2);
            }
            target.setStringValue(connectionAsset1PortName);
        }
    }
    
    /**
     * Sets (as xml) the "ConnectionAsset1PortName" element
     */
    public void xsetConnectionAsset1PortName(org.erdc.cobie.cobielite.core.CobieTextSimpleType connectionAsset1PortName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONNECTIONASSET1PORTNAME$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONNECTIONASSET1PORTNAME$2);
            }
            target.set(connectionAsset1PortName);
        }
    }
    
    /**
     * Unsets the "ConnectionAsset1PortName" element
     */
    public void unsetConnectionAsset1PortName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONNECTIONASSET1PORTNAME$2, 0);
        }
    }
    
    /**
     * Gets the "ConnectionAsset2Name" element
     */
    public java.lang.String getConnectionAsset2Name()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONASSET2NAME$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ConnectionAsset2Name" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetConnectionAsset2Name()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(CONNECTIONASSET2NAME$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "ConnectionAsset2Name" element
     */
    public boolean isSetConnectionAsset2Name()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONNECTIONASSET2NAME$4) != 0;
        }
    }
    
    /**
     * Sets the "ConnectionAsset2Name" element
     */
    public void setConnectionAsset2Name(java.lang.String connectionAsset2Name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONASSET2NAME$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONNECTIONASSET2NAME$4);
            }
            target.setStringValue(connectionAsset2Name);
        }
    }
    
    /**
     * Sets (as xml) the "ConnectionAsset2Name" element
     */
    public void xsetConnectionAsset2Name(org.erdc.cobie.cobielite.core.CobieNameSimpleType connectionAsset2Name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(CONNECTIONASSET2NAME$4, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(CONNECTIONASSET2NAME$4);
            }
            target.set(connectionAsset2Name);
        }
    }
    
    /**
     * Unsets the "ConnectionAsset2Name" element
     */
    public void unsetConnectionAsset2Name()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONNECTIONASSET2NAME$4, 0);
        }
    }
    
    /**
     * Gets the "ConnectionAsset2PortName" element
     */
    public java.lang.String getConnectionAsset2PortName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONASSET2PORTNAME$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ConnectionAsset2PortName" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetConnectionAsset2PortName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONNECTIONASSET2PORTNAME$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "ConnectionAsset2PortName" element
     */
    public boolean isSetConnectionAsset2PortName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONNECTIONASSET2PORTNAME$6) != 0;
        }
    }
    
    /**
     * Sets the "ConnectionAsset2PortName" element
     */
    public void setConnectionAsset2PortName(java.lang.String connectionAsset2PortName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONASSET2PORTNAME$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONNECTIONASSET2PORTNAME$6);
            }
            target.setStringValue(connectionAsset2PortName);
        }
    }
    
    /**
     * Sets (as xml) the "ConnectionAsset2PortName" element
     */
    public void xsetConnectionAsset2PortName(org.erdc.cobie.cobielite.core.CobieTextSimpleType connectionAsset2PortName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONNECTIONASSET2PORTNAME$6, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONNECTIONASSET2PORTNAME$6);
            }
            target.set(connectionAsset2PortName);
        }
    }
    
    /**
     * Unsets the "ConnectionAsset2PortName" element
     */
    public void unsetConnectionAsset2PortName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONNECTIONASSET2PORTNAME$6, 0);
        }
    }
    
    /**
     * Gets the "ConnectionDescription" element
     */
    public java.lang.String getConnectionDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONDESCRIPTION$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ConnectionDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetConnectionDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(CONNECTIONDESCRIPTION$8, 0);
            return target;
        }
    }
    
    /**
     * True if has "ConnectionDescription" element
     */
    public boolean isSetConnectionDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONNECTIONDESCRIPTION$8) != 0;
        }
    }
    
    /**
     * Sets the "ConnectionDescription" element
     */
    public void setConnectionDescription(java.lang.String connectionDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONDESCRIPTION$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONNECTIONDESCRIPTION$8);
            }
            target.setStringValue(connectionDescription);
        }
    }
    
    /**
     * Sets (as xml) the "ConnectionDescription" element
     */
    public void xsetConnectionDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType connectionDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(CONNECTIONDESCRIPTION$8, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(CONNECTIONDESCRIPTION$8);
            }
            target.set(connectionDescription);
        }
    }
    
    /**
     * Unsets the "ConnectionDescription" element
     */
    public void unsetConnectionDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONNECTIONDESCRIPTION$8, 0);
        }
    }
    
    /**
     * Gets the "ConnectionAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getConnectionAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(CONNECTIONATTRIBUTES$10, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ConnectionAttributes" element
     */
    public boolean isSetConnectionAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONNECTIONATTRIBUTES$10) != 0;
        }
    }
    
    /**
     * Sets the "ConnectionAttributes" element
     */
    public void setConnectionAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType connectionAttributes)
    {
        generatedSetterHelperImpl(connectionAttributes, CONNECTIONATTRIBUTES$10, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ConnectionAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewConnectionAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(CONNECTIONATTRIBUTES$10);
            return target;
        }
    }
    
    /**
     * Unsets the "ConnectionAttributes" element
     */
    public void unsetConnectionAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONNECTIONATTRIBUTES$10, 0);
        }
    }
    
    /**
     * Gets the "ConnectionDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getConnectionDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(CONNECTIONDOCUMENTS$12, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ConnectionDocuments" element
     */
    public boolean isSetConnectionDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONNECTIONDOCUMENTS$12) != 0;
        }
    }
    
    /**
     * Sets the "ConnectionDocuments" element
     */
    public void setConnectionDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType connectionDocuments)
    {
        generatedSetterHelperImpl(connectionDocuments, CONNECTIONDOCUMENTS$12, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ConnectionDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewConnectionDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(CONNECTIONDOCUMENTS$12);
            return target;
        }
    }
    
    /**
     * Unsets the "ConnectionDocuments" element
     */
    public void unsetConnectionDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONNECTIONDOCUMENTS$12, 0);
        }
    }
    
    /**
     * Gets the "ConnectionIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getConnectionIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(CONNECTIONISSUES$14, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ConnectionIssues" element
     */
    public boolean isSetConnectionIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONNECTIONISSUES$14) != 0;
        }
    }
    
    /**
     * Sets the "ConnectionIssues" element
     */
    public void setConnectionIssues(org.erdc.cobie.cobielite.core.IssueCollectionType connectionIssues)
    {
        generatedSetterHelperImpl(connectionIssues, CONNECTIONISSUES$14, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ConnectionIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewConnectionIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(CONNECTIONISSUES$14);
            return target;
        }
    }
    
    /**
     * Unsets the "ConnectionIssues" element
     */
    public void unsetConnectionIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONNECTIONISSUES$14, 0);
        }
    }
}
