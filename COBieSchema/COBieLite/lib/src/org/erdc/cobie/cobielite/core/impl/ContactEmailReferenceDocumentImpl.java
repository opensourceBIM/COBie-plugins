/*
 * An XML document type.
 * Localname: ContactEmailReference
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactEmailReferenceDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ContactEmailReference(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ContactEmailReferenceDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ContactEmailReferenceDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContactEmailReferenceDocumentImpl(org.apache.xmlbeans.SchemaType sType)
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
}
