/*
 * An XML document type.
 * Localname: ConnectionDescription
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ConnectionDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ConnectionDescription(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ConnectionDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ConnectionDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public ConnectionDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONNECTIONDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ConnectionDescription");
    
    
    /**
     * Gets the "ConnectionDescription" element
     */
    public java.lang.String getConnectionDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ConnectionDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetConnectionDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(CONNECTIONDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ConnectionDescription" element
     */
    public void setConnectionDescription(java.lang.String connectionDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONNECTIONDESCRIPTION$0);
            }
            target.setStringValue(connectionDescription);
        }
    }
    
    /**
     * Sets (as xml) the "ConnectionDescription" element
     */
    public void xsetConnectionDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType connectionDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(CONNECTIONDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(CONNECTIONDESCRIPTION$0);
            }
            target.set(connectionDescription);
        }
    }
}
