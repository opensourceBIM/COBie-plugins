/*
 * XML Type:  ZoneType
 * Namespace: http://zone.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.zone.ZoneType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.zone.impl;
/**
 * An XML ZoneType(@http://zone.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class ZoneTypeImpl extends org.erdc.cobie.cobielite.core.impl.ZoneTypeImpl implements org.erdc.cobie.cobielite.zone.ZoneType
{
    private static final long serialVersionUID = 1L;
    
    public ZoneTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ZONEDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ZoneDescription");
    private static final javax.xml.namespace.QName ZONEATTRIBUTES$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ZoneAttributes");
    private static final javax.xml.namespace.QName ZONEDOCUMENTS$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ZoneDocuments");
    private static final javax.xml.namespace.QName ZONEISSUES$6 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ZoneIssues");
    
    
    /**
     * Gets the "ZoneDescription" element
     */
    public java.lang.String getZoneDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ZONEDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ZoneDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetZoneDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ZONEDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "ZoneDescription" element
     */
    public boolean isSetZoneDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ZONEDESCRIPTION$0) != 0;
        }
    }
    
    /**
     * Sets the "ZoneDescription" element
     */
    public void setZoneDescription(java.lang.String zoneDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ZONEDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ZONEDESCRIPTION$0);
            }
            target.setStringValue(zoneDescription);
        }
    }
    
    /**
     * Sets (as xml) the "ZoneDescription" element
     */
    public void xsetZoneDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType zoneDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ZONEDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(ZONEDESCRIPTION$0);
            }
            target.set(zoneDescription);
        }
    }
    
    /**
     * Unsets the "ZoneDescription" element
     */
    public void unsetZoneDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ZONEDESCRIPTION$0, 0);
        }
    }
    
    /**
     * Gets the "ZoneAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getZoneAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(ZONEATTRIBUTES$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ZoneAttributes" element
     */
    public boolean isSetZoneAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ZONEATTRIBUTES$2) != 0;
        }
    }
    
    /**
     * Sets the "ZoneAttributes" element
     */
    public void setZoneAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType zoneAttributes)
    {
        generatedSetterHelperImpl(zoneAttributes, ZONEATTRIBUTES$2, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ZoneAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewZoneAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(ZONEATTRIBUTES$2);
            return target;
        }
    }
    
    /**
     * Unsets the "ZoneAttributes" element
     */
    public void unsetZoneAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ZONEATTRIBUTES$2, 0);
        }
    }
    
    /**
     * Gets the "ZoneDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getZoneDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(ZONEDOCUMENTS$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ZoneDocuments" element
     */
    public boolean isSetZoneDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ZONEDOCUMENTS$4) != 0;
        }
    }
    
    /**
     * Sets the "ZoneDocuments" element
     */
    public void setZoneDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType zoneDocuments)
    {
        generatedSetterHelperImpl(zoneDocuments, ZONEDOCUMENTS$4, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ZoneDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewZoneDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(ZONEDOCUMENTS$4);
            return target;
        }
    }
    
    /**
     * Unsets the "ZoneDocuments" element
     */
    public void unsetZoneDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ZONEDOCUMENTS$4, 0);
        }
    }
    
    /**
     * Gets the "ZoneIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getZoneIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(ZONEISSUES$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ZoneIssues" element
     */
    public boolean isSetZoneIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ZONEISSUES$6) != 0;
        }
    }
    
    /**
     * Sets the "ZoneIssues" element
     */
    public void setZoneIssues(org.erdc.cobie.cobielite.core.IssueCollectionType zoneIssues)
    {
        generatedSetterHelperImpl(zoneIssues, ZONEISSUES$6, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ZoneIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewZoneIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(ZONEISSUES$6);
            return target;
        }
    }
    
    /**
     * Unsets the "ZoneIssues" element
     */
    public void unsetZoneIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ZONEISSUES$6, 0);
        }
    }
}
