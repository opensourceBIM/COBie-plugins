/*
 * An XML document type.
 * Localname: FloorDescription
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.FloorDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one FloorDescription(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FloorDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.FloorDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public FloorDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FLOORDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FloorDescription");
    
    
    /**
     * Gets the "FloorDescription" element
     */
    public java.lang.String getFloorDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FLOORDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FloorDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetFloorDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(FLOORDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "FloorDescription" element
     */
    public void setFloorDescription(java.lang.String floorDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FLOORDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FLOORDESCRIPTION$0);
            }
            target.setStringValue(floorDescription);
        }
    }
    
    /**
     * Sets (as xml) the "FloorDescription" element
     */
    public void xsetFloorDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType floorDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(FLOORDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(FLOORDESCRIPTION$0);
            }
            target.set(floorDescription);
        }
    }
}
