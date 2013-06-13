/*
 * An XML document type.
 * Localname: Space
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpaceDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Space(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SpaceDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SpaceDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpaceDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPACE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Space");
    private static final org.apache.xmlbeans.QNameSet SPACE$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Space"),
        new javax.xml.namespace.QName("http://space.cobielite.cobie.erdc.org", "Space"),
    });
    
    
    /**
     * Gets the "Space" element
     */
    public org.erdc.cobie.cobielite.core.SpaceType getSpace()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceType)get_store().find_element_user(SPACE$1, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Space" element
     */
    public void setSpace(org.erdc.cobie.cobielite.core.SpaceType space)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceType)get_store().find_element_user(SPACE$1, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.SpaceType)get_store().add_element_user(SPACE$0);
            }
            target.set(space);
        }
    }
    
    /**
     * Appends and returns a new empty "Space" element
     */
    public org.erdc.cobie.cobielite.core.SpaceType addNewSpace()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceType)get_store().add_element_user(SPACE$0);
            return target;
        }
    }
}
