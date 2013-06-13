/*
 * An XML document type.
 * Localname: SpaceAssignment
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpaceAssignmentDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SpaceAssignment(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SpaceAssignmentDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SpaceAssignmentDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpaceAssignmentDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPACEASSIGNMENT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceAssignment");
    
    
    /**
     * Gets the "SpaceAssignment" element
     */
    public org.erdc.cobie.cobielite.core.SpaceKeyType getSpaceAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceKeyType)get_store().find_element_user(SPACEASSIGNMENT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "SpaceAssignment" element
     */
    public void setSpaceAssignment(org.erdc.cobie.cobielite.core.SpaceKeyType spaceAssignment)
    {
        generatedSetterHelperImpl(spaceAssignment, SPACEASSIGNMENT$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpaceAssignment" element
     */
    public org.erdc.cobie.cobielite.core.SpaceKeyType addNewSpaceAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceKeyType)get_store().add_element_user(SPACEASSIGNMENT$0);
            return target;
        }
    }
}
