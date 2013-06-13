/*
 * An XML document type.
 * Localname: SystemName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SystemNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SystemName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SystemNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SystemNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public SystemNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SYSTEMNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SystemName");
    
    
    /**
     * Gets the "SystemName" element
     */
    public java.lang.String getSystemName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SYSTEMNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SystemName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetSystemName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(SYSTEMNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SystemName" element
     */
    public void setSystemName(java.lang.String systemName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SYSTEMNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SYSTEMNAME$0);
            }
            target.setStringValue(systemName);
        }
    }
    
    /**
     * Sets (as xml) the "SystemName" element
     */
    public void xsetSystemName(org.erdc.cobie.cobielite.core.CobieNameSimpleType systemName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(SYSTEMNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(SYSTEMNAME$0);
            }
            target.set(systemName);
        }
    }
}
