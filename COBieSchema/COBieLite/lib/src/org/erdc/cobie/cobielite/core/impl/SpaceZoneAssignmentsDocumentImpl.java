/*
 * An XML document type.
 * Localname: SpaceZoneAssignments
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpaceZoneAssignmentsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SpaceZoneAssignments(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SpaceZoneAssignmentsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SpaceZoneAssignmentsDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpaceZoneAssignmentsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPACEZONEASSIGNMENTS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceZoneAssignments");
    
    
    /**
     * Gets the "SpaceZoneAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ZoneAssignmentCollectionType getSpaceZoneAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneAssignmentCollectionType)get_store().find_element_user(SPACEZONEASSIGNMENTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "SpaceZoneAssignments" element
     */
    public void setSpaceZoneAssignments(org.erdc.cobie.cobielite.core.ZoneAssignmentCollectionType spaceZoneAssignments)
    {
        generatedSetterHelperImpl(spaceZoneAssignments, SPACEZONEASSIGNMENTS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpaceZoneAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ZoneAssignmentCollectionType addNewSpaceZoneAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneAssignmentCollectionType)get_store().add_element_user(SPACEZONEASSIGNMENTS$0);
            return target;
        }
    }
}
