/*
 * XML Type:  ContactKeyType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactKeyType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML ContactKeyType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class ContactKeyTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieKeyTypeImpl implements org.erdc.cobie.cobielite.core.ContactKeyType
{
    private static final long serialVersionUID = 1L;
    
    public ContactKeyTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTEMAILREFERENCE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactEmailReference");
    
    
    /**
     * Gets the "ContactEmailReference" element
     */
    public java.lang.String getContactEmailReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTEMAILREFERENCE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactEmailReference" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetContactEmailReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(CONTACTEMAILREFERENCE$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "ContactEmailReference" element
     */
    public boolean isSetContactEmailReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTEMAILREFERENCE$0) != 0;
        }
    }
    
    /**
     * Sets the "ContactEmailReference" element
     */
    public void setContactEmailReference(java.lang.String contactEmailReference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTEMAILREFERENCE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTEMAILREFERENCE$0);
            }
            target.setStringValue(contactEmailReference);
        }
    }
    
    /**
     * Sets (as xml) the "ContactEmailReference" element
     */
    public void xsetContactEmailReference(org.erdc.cobie.cobielite.core.CobieNameSimpleType contactEmailReference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(CONTACTEMAILREFERENCE$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(CONTACTEMAILREFERENCE$0);
            }
            target.set(contactEmailReference);
        }
    }
    
    /**
     * Unsets the "ContactEmailReference" element
     */
    public void unsetContactEmailReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTEMAILREFERENCE$0, 0);
        }
    }
}
