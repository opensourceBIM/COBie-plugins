/*
 * XML Type:  ZoneAssignmentCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ZoneAssignmentCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML ZoneAssignmentCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class ZoneAssignmentCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieRowAssignmentsTypeImpl implements org.erdc.cobie.cobielite.core.ZoneAssignmentCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public ZoneAssignmentCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ZONEASSIGNMENT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ZoneAssignment");
    
    
    /**
     * Gets the "ZoneAssignment" element
     */
    public org.erdc.cobie.cobielite.core.ZoneKeyType getZoneAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneKeyType)get_store().find_element_user(ZONEASSIGNMENT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ZoneAssignment" element
     */
    public boolean isSetZoneAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ZONEASSIGNMENT$0) != 0;
        }
    }
    
    /**
     * Sets the "ZoneAssignment" element
     */
    public void setZoneAssignment(org.erdc.cobie.cobielite.core.ZoneKeyType zoneAssignment)
    {
        generatedSetterHelperImpl(zoneAssignment, ZONEASSIGNMENT$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ZoneAssignment" element
     */
    public org.erdc.cobie.cobielite.core.ZoneKeyType addNewZoneAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneKeyType)get_store().add_element_user(ZONEASSIGNMENT$0);
            return target;
        }
    }
    
    /**
     * Unsets the "ZoneAssignment" element
     */
    public void unsetZoneAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ZONEASSIGNMENT$0, 0);
        }
    }
}
