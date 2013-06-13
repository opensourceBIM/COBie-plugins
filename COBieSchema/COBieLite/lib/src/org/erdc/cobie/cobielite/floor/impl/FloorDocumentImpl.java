/*
 * An XML document type.
 * Localname: Floor
 * Namespace: http://floor.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.floor.FloorDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.floor.impl;
/**
 * A document containing one Floor(@http://floor.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FloorDocumentImpl extends org.erdc.cobie.cobielite.core.impl.FloorDocumentImpl implements org.erdc.cobie.cobielite.floor.FloorDocument
{
    private static final long serialVersionUID = 1L;
    
    public FloorDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FLOOR2$0 = 
        new javax.xml.namespace.QName("http://floor.cobielite.cobie.erdc.org", "Floor");
    
    
    /**
     * Gets the "Floor" element
     */
    public org.erdc.cobie.cobielite.floor.FloorType getFloor2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.floor.FloorType target = null;
            target = (org.erdc.cobie.cobielite.floor.FloorType)get_store().find_element_user(FLOOR2$0, 0);
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
    public void setFloor2(org.erdc.cobie.cobielite.floor.FloorType floor2)
    {
        generatedSetterHelperImpl(floor2, FLOOR2$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Floor" element
     */
    public org.erdc.cobie.cobielite.floor.FloorType addNewFloor2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.floor.FloorType target = null;
            target = (org.erdc.cobie.cobielite.floor.FloorType)get_store().add_element_user(FLOOR2$0);
            return target;
        }
    }
}
