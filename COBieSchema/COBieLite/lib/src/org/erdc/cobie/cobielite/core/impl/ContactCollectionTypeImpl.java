/*
 * XML Type:  ContactCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ContactCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML ContactCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class ContactCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieWorksheetTypeImpl implements org.erdc.cobie.cobielite.core.ContactCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public ContactCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Contact");
    private static final org.apache.xmlbeans.QNameSet CONTACT$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Contact"),
        new javax.xml.namespace.QName("http://contact.cobielite.cobie.erdc.org", "Contact"),
    });
    
    
    /**
     * Gets array of all "Contact" elements
     */
    public org.erdc.cobie.cobielite.core.ContactType[] getContactArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(CONTACT$1, targetList);
            org.erdc.cobie.cobielite.core.ContactType[] result = new org.erdc.cobie.cobielite.core.ContactType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Contact" element
     */
    public org.erdc.cobie.cobielite.core.ContactType getContactArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactType)get_store().find_element_user(CONTACT$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Contact" element
     */
    public int sizeOfContactArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACT$1);
        }
    }
    
    /**
     * Sets array of all "Contact" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setContactArray(org.erdc.cobie.cobielite.core.ContactType[] contactArray)
    {
        check_orphaned();
        arraySetterHelper(contactArray, CONTACT$0, CONTACT$1);
    }
    
    /**
     * Sets ith "Contact" element
     */
    public void setContactArray(int i, org.erdc.cobie.cobielite.core.ContactType contact)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactType)get_store().find_element_user(CONTACT$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(contact);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Contact" element
     */
    public org.erdc.cobie.cobielite.core.ContactType insertNewContact(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactType)get_store().insert_element_user(CONTACT$1, CONTACT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Contact" element
     */
    public org.erdc.cobie.cobielite.core.ContactType addNewContact()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactType)get_store().add_element_user(CONTACT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Contact" element
     */
    public void removeContact(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACT$1, i);
        }
    }
}
