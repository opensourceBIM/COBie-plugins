/*
 * An XML document type.
 * Localname: SpaceSignageName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpaceSignageNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SpaceSignageName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SpaceSignageNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SpaceSignageNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpaceSignageNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPACESIGNAGENAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceSignageName");
    
    
    /**
     * Gets the "SpaceSignageName" element
     */
    public java.lang.String getSpaceSignageName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPACESIGNAGENAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SpaceSignageName" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetSpaceSignageName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(SPACESIGNAGENAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SpaceSignageName" element
     */
    public void setSpaceSignageName(java.lang.String spaceSignageName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPACESIGNAGENAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SPACESIGNAGENAME$0);
            }
            target.setStringValue(spaceSignageName);
        }
    }
    
    /**
     * Sets (as xml) the "SpaceSignageName" element
     */
    public void xsetSpaceSignageName(org.erdc.cobie.cobielite.core.CobieTextSimpleType spaceSignageName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(SPACESIGNAGENAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(SPACESIGNAGENAME$0);
            }
            target.set(spaceSignageName);
        }
    }
}
