/*
 * An XML document type.
 * Localname: System
 * Namespace: http://system.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.system.SystemDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.system.impl;
/**
 * A document containing one System(@http://system.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SystemDocumentImpl extends org.erdc.cobie.cobielite.core.impl.SystemDocumentImpl implements org.erdc.cobie.cobielite.system.SystemDocument
{
    private static final long serialVersionUID = 1L;
    
    public SystemDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SYSTEM2$0 = 
        new javax.xml.namespace.QName("http://system.cobielite.cobie.erdc.org", "System");
    
    
    /**
     * Gets the "System" element
     */
    public org.erdc.cobie.cobielite.system.SystemType getSystem2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.system.SystemType target = null;
            target = (org.erdc.cobie.cobielite.system.SystemType)get_store().find_element_user(SYSTEM2$0, 0);
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
    public void setSystem2(org.erdc.cobie.cobielite.system.SystemType system2)
    {
        generatedSetterHelperImpl(system2, SYSTEM2$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "System" element
     */
    public org.erdc.cobie.cobielite.system.SystemType addNewSystem2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.system.SystemType target = null;
            target = (org.erdc.cobie.cobielite.system.SystemType)get_store().add_element_user(SYSTEM2$0);
            return target;
        }
    }
}
