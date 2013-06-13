/*
 * XML Type:  SystemType
 * Namespace: http://system.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.system.SystemType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.system.impl;
/**
 * An XML SystemType(@http://system.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class SystemTypeImpl extends org.erdc.cobie.cobielite.core.impl.SystemTypeImpl implements org.erdc.cobie.cobielite.system.SystemType
{
    private static final long serialVersionUID = 1L;
    
    public SystemTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SYSTEMDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SystemDescription");
    private static final javax.xml.namespace.QName SYSTEMATTRIBUTES$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SystemAttributes");
    private static final javax.xml.namespace.QName SYSTEMDOCUMENTS$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SystemDocuments");
    private static final javax.xml.namespace.QName SYSTEMISSUES$6 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SystemIssues");
    
    
    /**
     * Gets the "SystemDescription" element
     */
    public java.lang.String getSystemDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SYSTEMDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SystemDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetSystemDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(SYSTEMDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "SystemDescription" element
     */
    public boolean isSetSystemDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SYSTEMDESCRIPTION$0) != 0;
        }
    }
    
    /**
     * Sets the "SystemDescription" element
     */
    public void setSystemDescription(java.lang.String systemDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SYSTEMDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SYSTEMDESCRIPTION$0);
            }
            target.setStringValue(systemDescription);
        }
    }
    
    /**
     * Sets (as xml) the "SystemDescription" element
     */
    public void xsetSystemDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType systemDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(SYSTEMDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(SYSTEMDESCRIPTION$0);
            }
            target.set(systemDescription);
        }
    }
    
    /**
     * Unsets the "SystemDescription" element
     */
    public void unsetSystemDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SYSTEMDESCRIPTION$0, 0);
        }
    }
    
    /**
     * Gets the "SystemAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getSystemAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(SYSTEMATTRIBUTES$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "SystemAttributes" element
     */
    public boolean isSetSystemAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SYSTEMATTRIBUTES$2) != 0;
        }
    }
    
    /**
     * Sets the "SystemAttributes" element
     */
    public void setSystemAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType systemAttributes)
    {
        generatedSetterHelperImpl(systemAttributes, SYSTEMATTRIBUTES$2, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SystemAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewSystemAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(SYSTEMATTRIBUTES$2);
            return target;
        }
    }
    
    /**
     * Unsets the "SystemAttributes" element
     */
    public void unsetSystemAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SYSTEMATTRIBUTES$2, 0);
        }
    }
    
    /**
     * Gets the "SystemDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getSystemDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(SYSTEMDOCUMENTS$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "SystemDocuments" element
     */
    public boolean isSetSystemDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SYSTEMDOCUMENTS$4) != 0;
        }
    }
    
    /**
     * Sets the "SystemDocuments" element
     */
    public void setSystemDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType systemDocuments)
    {
        generatedSetterHelperImpl(systemDocuments, SYSTEMDOCUMENTS$4, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SystemDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewSystemDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(SYSTEMDOCUMENTS$4);
            return target;
        }
    }
    
    /**
     * Unsets the "SystemDocuments" element
     */
    public void unsetSystemDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SYSTEMDOCUMENTS$4, 0);
        }
    }
    
    /**
     * Gets the "SystemIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getSystemIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(SYSTEMISSUES$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "SystemIssues" element
     */
    public boolean isSetSystemIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SYSTEMISSUES$6) != 0;
        }
    }
    
    /**
     * Sets the "SystemIssues" element
     */
    public void setSystemIssues(org.erdc.cobie.cobielite.core.IssueCollectionType systemIssues)
    {
        generatedSetterHelperImpl(systemIssues, SYSTEMISSUES$6, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SystemIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewSystemIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(SYSTEMISSUES$6);
            return target;
        }
    }
    
    /**
     * Unsets the "SystemIssues" element
     */
    public void unsetSystemIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SYSTEMISSUES$6, 0);
        }
    }
}
