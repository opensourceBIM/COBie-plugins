/*
 * An XML document type.
 * Localname: System
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SystemDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one System(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SystemDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SystemDocument
{
    private static final long serialVersionUID = 1L;
    
    public SystemDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SYSTEM$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "System");
    private static final org.apache.xmlbeans.QNameSet SYSTEM$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://system.cobielite.cobie.erdc.org", "System"),
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "System"),
    });
    
    
    /**
     * Gets the "System" element
     */
    public org.erdc.cobie.cobielite.core.SystemType getSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemType)get_store().find_element_user(SYSTEM$1, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "System" element
     */
    public void setSystem(org.erdc.cobie.cobielite.core.SystemType system)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemType)get_store().find_element_user(SYSTEM$1, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.SystemType)get_store().add_element_user(SYSTEM$0);
            }
            target.set(system);
        }
    }
    
    /**
     * Appends and returns a new empty "System" element
     */
    public org.erdc.cobie.cobielite.core.SystemType addNewSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemType)get_store().add_element_user(SYSTEM$0);
            return target;
        }
    }
}
