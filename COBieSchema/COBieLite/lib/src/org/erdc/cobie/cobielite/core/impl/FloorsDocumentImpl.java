/*
 * An XML document type.
 * Localname: Floors
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.FloorsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Floors(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FloorsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.FloorsDocument
{
    private static final long serialVersionUID = 1L;
    
    public FloorsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FLOORS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Floors");
    
    
    /**
     * Gets the "Floors" element
     */
    public org.erdc.cobie.cobielite.core.FloorCollectionType getFloors()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FloorCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.FloorCollectionType)get_store().find_element_user(FLOORS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Floors" element
     */
    public void setFloors(org.erdc.cobie.cobielite.core.FloorCollectionType floors)
    {
        generatedSetterHelperImpl(floors, FLOORS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Floors" element
     */
    public org.erdc.cobie.cobielite.core.FloorCollectionType addNewFloors()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FloorCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.FloorCollectionType)get_store().add_element_user(FLOORS$0);
            return target;
        }
    }
}
