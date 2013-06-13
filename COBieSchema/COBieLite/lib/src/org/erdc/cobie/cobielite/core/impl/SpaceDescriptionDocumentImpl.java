/*
 * An XML document type.
 * Localname: SpaceDescription
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpaceDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SpaceDescription(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SpaceDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SpaceDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpaceDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPACEDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceDescription");
    
    
    /**
     * Gets the "SpaceDescription" element
     */
    public java.lang.String getSpaceDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPACEDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SpaceDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetSpaceDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(SPACEDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SpaceDescription" element
     */
    public void setSpaceDescription(java.lang.String spaceDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPACEDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SPACEDESCRIPTION$0);
            }
            target.setStringValue(spaceDescription);
        }
    }
    
    /**
     * Sets (as xml) the "SpaceDescription" element
     */
    public void xsetSpaceDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType spaceDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(SPACEDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(SPACEDESCRIPTION$0);
            }
            target.set(spaceDescription);
        }
    }
}
