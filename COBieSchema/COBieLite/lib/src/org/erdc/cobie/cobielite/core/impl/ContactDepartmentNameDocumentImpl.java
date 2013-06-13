/*
 * An XML document type.
 * Localname: ContactDepartmentName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactDepartmentNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ContactDepartmentName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ContactDepartmentNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ContactDepartmentNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContactDepartmentNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTDEPARTMENTNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactDepartmentName");
    
    
    /**
     * Gets the "ContactDepartmentName" element
     */
    public java.lang.String getContactDepartmentName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTDEPARTMENTNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactDepartmentName" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactDepartmentName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTDEPARTMENTNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ContactDepartmentName" element
     */
    public void setContactDepartmentName(java.lang.String contactDepartmentName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTDEPARTMENTNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTDEPARTMENTNAME$0);
            }
            target.setStringValue(contactDepartmentName);
        }
    }
    
    /**
     * Sets (as xml) the "ContactDepartmentName" element
     */
    public void xsetContactDepartmentName(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactDepartmentName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTDEPARTMENTNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTDEPARTMENTNAME$0);
            }
            target.set(contactDepartmentName);
        }
    }
}
