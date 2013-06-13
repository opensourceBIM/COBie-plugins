/*
 * An XML document type.
 * Localname: Floor
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.FloorDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Floor(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FloorDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.FloorDocument
{
    private static final long serialVersionUID = 1L;
    
    public FloorDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FLOOR$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Floor");
    private static final org.apache.xmlbeans.QNameSet FLOOR$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://floor.cobielite.cobie.erdc.org", "Floor"),
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Floor"),
    });
    
    
    /**
     * Gets the "Floor" element
     */
    public org.erdc.cobie.cobielite.core.FloorType getFloor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FloorType target = null;
            target = (org.erdc.cobie.cobielite.core.FloorType)get_store().find_element_user(FLOOR$1, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Floor" element
     */
    public void setFloor(org.erdc.cobie.cobielite.core.FloorType floor)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FloorType target = null;
            target = (org.erdc.cobie.cobielite.core.FloorType)get_store().find_element_user(FLOOR$1, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.FloorType)get_store().add_element_user(FLOOR$0);
            }
            target.set(floor);
        }
    }
    
    /**
     * Appends and returns a new empty "Floor" element
     */
    public org.erdc.cobie.cobielite.core.FloorType addNewFloor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FloorType target = null;
            target = (org.erdc.cobie.cobielite.core.FloorType)get_store().add_element_user(FLOOR$0);
            return target;
        }
    }
}
