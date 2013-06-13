/*
 * An XML document type.
 * Localname: ContactPostalBoxNumber
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactPostalBoxNumberDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ContactPostalBoxNumber(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ContactPostalBoxNumberDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ContactPostalBoxNumberDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContactPostalBoxNumberDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTPOSTALBOXNUMBER$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactPostalBoxNumber");
    
    
    /**
     * Gets the "ContactPostalBoxNumber" element
     */
    public java.lang.String getContactPostalBoxNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTPOSTALBOXNUMBER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactPostalBoxNumber" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactPostalBoxNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTPOSTALBOXNUMBER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ContactPostalBoxNumber" element
     */
    public void setContactPostalBoxNumber(java.lang.String contactPostalBoxNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTPOSTALBOXNUMBER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTPOSTALBOXNUMBER$0);
            }
            target.setStringValue(contactPostalBoxNumber);
        }
    }
    
    /**
     * Sets (as xml) the "ContactPostalBoxNumber" element
     */
    public void xsetContactPostalBoxNumber(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactPostalBoxNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTPOSTALBOXNUMBER$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTPOSTALBOXNUMBER$0);
            }
            target.set(contactPostalBoxNumber);
        }
    }
}
