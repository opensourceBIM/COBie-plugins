/*
 * An XML document type.
 * Localname: ZoneAssignment
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ZoneAssignmentDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ZoneAssignment(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ZoneAssignmentDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ZoneAssignmentDocument
{
    private static final long serialVersionUID = 1L;
    
    public ZoneAssignmentDocumentImpl(org.apache.xmlbeans.SchemaType sType)
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
}
