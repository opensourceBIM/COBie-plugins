/*
 * XML Type:  ContactType
 * Namespace: http://contact.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.contact.ContactType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.contact.impl;
/**
 * An XML ContactType(@http://contact.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class ContactTypeImpl extends org.erdc.cobie.cobielite.core.impl.ContactTypeImpl implements org.erdc.cobie.cobielite.contact.ContactType
{
    private static final long serialVersionUID = 1L;
    
    public ContactTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTCATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactCategory");
    private static final javax.xml.namespace.QName CONTACTCOMPANYNAME$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactCompanyName");
    private static final javax.xml.namespace.QName CONTACTPHONENUMBER$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactPhoneNumber");
    private static final javax.xml.namespace.QName CONTACTDEPARTMENTNAME$6 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactDepartmentName");
    private static final javax.xml.namespace.QName CONTACTGIVENNAME$8 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactGivenName");
    private static final javax.xml.namespace.QName CONTACTFAMILYNAME$10 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactFamilyName");
    private static final javax.xml.namespace.QName CONTACTSTREET$12 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactStreet");
    private static final javax.xml.namespace.QName CONTACTPOSTALBOXNUMBER$14 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactPostalBoxNumber");
    private static final javax.xml.namespace.QName CONTACTTOWNNAME$16 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactTownName");
    private static final javax.xml.namespace.QName CONTACTREGIONCODE$18 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactRegionCode");
    private static final javax.xml.namespace.QName CONTACTCOUNTRYNAME$20 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactCountryName");
    private static final javax.xml.namespace.QName CONTACTPOSTALCODE$22 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactPostalCode");
    private static final javax.xml.namespace.QName CONTACTURL$24 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactURL");
    private static final javax.xml.namespace.QName CONTACTATTRIBUTES$26 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactAttributes");
    private static final javax.xml.namespace.QName CONTACTDOCUMENTS$28 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactDocuments");
    private static final javax.xml.namespace.QName CONTACTISSUES$30 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactIssues");
    
    
    /**
     * Gets the "ContactCategory" element
     */
    public java.lang.String getContactCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTCATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactCategory" element
     */
    public org.erdc.cobie.cobielite.core.CobieCategorySimpleType xgetContactCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieCategorySimpleType)get_store().find_element_user(CONTACTCATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "ContactCategory" element
     */
    public boolean isSetContactCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTCATEGORY$0) != 0;
        }
    }
    
    /**
     * Sets the "ContactCategory" element
     */
    public void setContactCategory(java.lang.String contactCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTCATEGORY$0);
            }
            target.setStringValue(contactCategory);
        }
    }
    
    /**
     * Sets (as xml) the "ContactCategory" element
     */
    public void xsetContactCategory(org.erdc.cobie.cobielite.core.CobieCategorySimpleType contactCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieCategorySimpleType)get_store().find_element_user(CONTACTCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieCategorySimpleType)get_store().add_element_user(CONTACTCATEGORY$0);
            }
            target.set(contactCategory);
        }
    }
    
    /**
     * Unsets the "ContactCategory" element
     */
    public void unsetContactCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTCATEGORY$0, 0);
        }
    }
    
    /**
     * Gets the "ContactCompanyName" element
     */
    public java.lang.String getContactCompanyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTCOMPANYNAME$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactCompanyName" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactCompanyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTCOMPANYNAME$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "ContactCompanyName" element
     */
    public boolean isSetContactCompanyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTCOMPANYNAME$2) != 0;
        }
    }
    
    /**
     * Sets the "ContactCompanyName" element
     */
    public void setContactCompanyName(java.lang.String contactCompanyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTCOMPANYNAME$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTCOMPANYNAME$2);
            }
            target.setStringValue(contactCompanyName);
        }
    }
    
    /**
     * Sets (as xml) the "ContactCompanyName" element
     */
    public void xsetContactCompanyName(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactCompanyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTCOMPANYNAME$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTCOMPANYNAME$2);
            }
            target.set(contactCompanyName);
        }
    }
    
    /**
     * Unsets the "ContactCompanyName" element
     */
    public void unsetContactCompanyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTCOMPANYNAME$2, 0);
        }
    }
    
    /**
     * Gets the "ContactPhoneNumber" element
     */
    public java.lang.String getContactPhoneNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTPHONENUMBER$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactPhoneNumber" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactPhoneNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTPHONENUMBER$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "ContactPhoneNumber" element
     */
    public boolean isSetContactPhoneNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTPHONENUMBER$4) != 0;
        }
    }
    
    /**
     * Sets the "ContactPhoneNumber" element
     */
    public void setContactPhoneNumber(java.lang.String contactPhoneNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTPHONENUMBER$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTPHONENUMBER$4);
            }
            target.setStringValue(contactPhoneNumber);
        }
    }
    
    /**
     * Sets (as xml) the "ContactPhoneNumber" element
     */
    public void xsetContactPhoneNumber(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactPhoneNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTPHONENUMBER$4, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTPHONENUMBER$4);
            }
            target.set(contactPhoneNumber);
        }
    }
    
    /**
     * Unsets the "ContactPhoneNumber" element
     */
    public void unsetContactPhoneNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTPHONENUMBER$4, 0);
        }
    }
    
    /**
     * Gets the "ContactDepartmentName" element
     */
    public java.lang.String getContactDepartmentName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTDEPARTMENTNAME$6, 0);
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
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTDEPARTMENTNAME$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "ContactDepartmentName" element
     */
    public boolean isSetContactDepartmentName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTDEPARTMENTNAME$6) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTDEPARTMENTNAME$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTDEPARTMENTNAME$6);
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
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTDEPARTMENTNAME$6, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTDEPARTMENTNAME$6);
            }
            target.set(contactDepartmentName);
        }
    }
    
    /**
     * Unsets the "ContactDepartmentName" element
     */
    public void unsetContactDepartmentName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTDEPARTMENTNAME$6, 0);
        }
    }
    
    /**
     * Gets the "ContactGivenName" element
     */
    public java.lang.String getContactGivenName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTGIVENNAME$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactGivenName" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactGivenName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTGIVENNAME$8, 0);
            return target;
        }
    }
    
    /**
     * True if has "ContactGivenName" element
     */
    public boolean isSetContactGivenName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTGIVENNAME$8) != 0;
        }
    }
    
    /**
     * Sets the "ContactGivenName" element
     */
    public void setContactGivenName(java.lang.String contactGivenName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTGIVENNAME$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTGIVENNAME$8);
            }
            target.setStringValue(contactGivenName);
        }
    }
    
    /**
     * Sets (as xml) the "ContactGivenName" element
     */
    public void xsetContactGivenName(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactGivenName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTGIVENNAME$8, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTGIVENNAME$8);
            }
            target.set(contactGivenName);
        }
    }
    
    /**
     * Unsets the "ContactGivenName" element
     */
    public void unsetContactGivenName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTGIVENNAME$8, 0);
        }
    }
    
    /**
     * Gets the "ContactFamilyName" element
     */
    public java.lang.String getContactFamilyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTFAMILYNAME$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactFamilyName" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactFamilyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTFAMILYNAME$10, 0);
            return target;
        }
    }
    
    /**
     * True if has "ContactFamilyName" element
     */
    public boolean isSetContactFamilyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTFAMILYNAME$10) != 0;
        }
    }
    
    /**
     * Sets the "ContactFamilyName" element
     */
    public void setContactFamilyName(java.lang.String contactFamilyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTFAMILYNAME$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTFAMILYNAME$10);
            }
            target.setStringValue(contactFamilyName);
        }
    }
    
    /**
     * Sets (as xml) the "ContactFamilyName" element
     */
    public void xsetContactFamilyName(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactFamilyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTFAMILYNAME$10, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTFAMILYNAME$10);
            }
            target.set(contactFamilyName);
        }
    }
    
    /**
     * Unsets the "ContactFamilyName" element
     */
    public void unsetContactFamilyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTFAMILYNAME$10, 0);
        }
    }
    
    /**
     * Gets the "ContactStreet" element
     */
    public java.lang.String getContactStreet()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTSTREET$12, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactStreet" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactStreet()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTSTREET$12, 0);
            return target;
        }
    }
    
    /**
     * True if has "ContactStreet" element
     */
    public boolean isSetContactStreet()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTSTREET$12) != 0;
        }
    }
    
    /**
     * Sets the "ContactStreet" element
     */
    public void setContactStreet(java.lang.String contactStreet)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTSTREET$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTSTREET$12);
            }
            target.setStringValue(contactStreet);
        }
    }
    
    /**
     * Sets (as xml) the "ContactStreet" element
     */
    public void xsetContactStreet(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactStreet)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTSTREET$12, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTSTREET$12);
            }
            target.set(contactStreet);
        }
    }
    
    /**
     * Unsets the "ContactStreet" element
     */
    public void unsetContactStreet()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTSTREET$12, 0);
        }
    }
    
    /**
     * Gets the "ContactPostalBoxNumber" element
     */
    public java.lang.String getContactPostalBoxNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTPOSTALBOXNUMBER$14, 0);
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
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTPOSTALBOXNUMBER$14, 0);
            return target;
        }
    }
    
    /**
     * True if has "ContactPostalBoxNumber" element
     */
    public boolean isSetContactPostalBoxNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTPOSTALBOXNUMBER$14) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTPOSTALBOXNUMBER$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTPOSTALBOXNUMBER$14);
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
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTPOSTALBOXNUMBER$14, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTPOSTALBOXNUMBER$14);
            }
            target.set(contactPostalBoxNumber);
        }
    }
    
    /**
     * Unsets the "ContactPostalBoxNumber" element
     */
    public void unsetContactPostalBoxNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTPOSTALBOXNUMBER$14, 0);
        }
    }
    
    /**
     * Gets the "ContactTownName" element
     */
    public java.lang.String getContactTownName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTTOWNNAME$16, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactTownName" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactTownName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTTOWNNAME$16, 0);
            return target;
        }
    }
    
    /**
     * True if has "ContactTownName" element
     */
    public boolean isSetContactTownName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTTOWNNAME$16) != 0;
        }
    }
    
    /**
     * Sets the "ContactTownName" element
     */
    public void setContactTownName(java.lang.String contactTownName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTTOWNNAME$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTTOWNNAME$16);
            }
            target.setStringValue(contactTownName);
        }
    }
    
    /**
     * Sets (as xml) the "ContactTownName" element
     */
    public void xsetContactTownName(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactTownName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTTOWNNAME$16, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTTOWNNAME$16);
            }
            target.set(contactTownName);
        }
    }
    
    /**
     * Unsets the "ContactTownName" element
     */
    public void unsetContactTownName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTTOWNNAME$16, 0);
        }
    }
    
    /**
     * Gets the "ContactRegionCode" element
     */
    public java.lang.String getContactRegionCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTREGIONCODE$18, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactRegionCode" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactRegionCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTREGIONCODE$18, 0);
            return target;
        }
    }
    
    /**
     * True if has "ContactRegionCode" element
     */
    public boolean isSetContactRegionCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTREGIONCODE$18) != 0;
        }
    }
    
    /**
     * Sets the "ContactRegionCode" element
     */
    public void setContactRegionCode(java.lang.String contactRegionCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTREGIONCODE$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTREGIONCODE$18);
            }
            target.setStringValue(contactRegionCode);
        }
    }
    
    /**
     * Sets (as xml) the "ContactRegionCode" element
     */
    public void xsetContactRegionCode(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactRegionCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTREGIONCODE$18, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTREGIONCODE$18);
            }
            target.set(contactRegionCode);
        }
    }
    
    /**
     * Unsets the "ContactRegionCode" element
     */
    public void unsetContactRegionCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTREGIONCODE$18, 0);
        }
    }
    
    /**
     * Gets the "ContactCountryName" element
     */
    public java.lang.String getContactCountryName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTCOUNTRYNAME$20, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactCountryName" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactCountryName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTCOUNTRYNAME$20, 0);
            return target;
        }
    }
    
    /**
     * True if has "ContactCountryName" element
     */
    public boolean isSetContactCountryName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTCOUNTRYNAME$20) != 0;
        }
    }
    
    /**
     * Sets the "ContactCountryName" element
     */
    public void setContactCountryName(java.lang.String contactCountryName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTCOUNTRYNAME$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTCOUNTRYNAME$20);
            }
            target.setStringValue(contactCountryName);
        }
    }
    
    /**
     * Sets (as xml) the "ContactCountryName" element
     */
    public void xsetContactCountryName(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactCountryName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTCOUNTRYNAME$20, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTCOUNTRYNAME$20);
            }
            target.set(contactCountryName);
        }
    }
    
    /**
     * Unsets the "ContactCountryName" element
     */
    public void unsetContactCountryName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTCOUNTRYNAME$20, 0);
        }
    }
    
    /**
     * Gets the "ContactPostalCode" element
     */
    public java.lang.String getContactPostalCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTPOSTALCODE$22, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactPostalCode" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactPostalCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTPOSTALCODE$22, 0);
            return target;
        }
    }
    
    /**
     * True if has "ContactPostalCode" element
     */
    public boolean isSetContactPostalCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTPOSTALCODE$22) != 0;
        }
    }
    
    /**
     * Sets the "ContactPostalCode" element
     */
    public void setContactPostalCode(java.lang.String contactPostalCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTPOSTALCODE$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTPOSTALCODE$22);
            }
            target.setStringValue(contactPostalCode);
        }
    }
    
    /**
     * Sets (as xml) the "ContactPostalCode" element
     */
    public void xsetContactPostalCode(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactPostalCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTPOSTALCODE$22, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTPOSTALCODE$22);
            }
            target.set(contactPostalCode);
        }
    }
    
    /**
     * Unsets the "ContactPostalCode" element
     */
    public void unsetContactPostalCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTPOSTALCODE$22, 0);
        }
    }
    
    /**
     * Gets the "ContactURL" element
     */
    public java.lang.String getContactURL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTURL$24, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactURL" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetContactURL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTURL$24, 0);
            return target;
        }
    }
    
    /**
     * True if has "ContactURL" element
     */
    public boolean isSetContactURL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTURL$24) != 0;
        }
    }
    
    /**
     * Sets the "ContactURL" element
     */
    public void setContactURL(java.lang.String contactURL)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTURL$24, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTURL$24);
            }
            target.setStringValue(contactURL);
        }
    }
    
    /**
     * Sets (as xml) the "ContactURL" element
     */
    public void xsetContactURL(org.erdc.cobie.cobielite.core.CobieTextSimpleType contactURL)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(CONTACTURL$24, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(CONTACTURL$24);
            }
            target.set(contactURL);
        }
    }
    
    /**
     * Unsets the "ContactURL" element
     */
    public void unsetContactURL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTURL$24, 0);
        }
    }
    
    /**
     * Gets the "ContactAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getContactAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(CONTACTATTRIBUTES$26, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ContactAttributes" element
     */
    public boolean isSetContactAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTATTRIBUTES$26) != 0;
        }
    }
    
    /**
     * Sets the "ContactAttributes" element
     */
    public void setContactAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType contactAttributes)
    {
        generatedSetterHelperImpl(contactAttributes, CONTACTATTRIBUTES$26, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ContactAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewContactAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(CONTACTATTRIBUTES$26);
            return target;
        }
    }
    
    /**
     * Unsets the "ContactAttributes" element
     */
    public void unsetContactAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTATTRIBUTES$26, 0);
        }
    }
    
    /**
     * Gets the "ContactDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getContactDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(CONTACTDOCUMENTS$28, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ContactDocuments" element
     */
    public boolean isSetContactDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTDOCUMENTS$28) != 0;
        }
    }
    
    /**
     * Sets the "ContactDocuments" element
     */
    public void setContactDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType contactDocuments)
    {
        generatedSetterHelperImpl(contactDocuments, CONTACTDOCUMENTS$28, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ContactDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewContactDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(CONTACTDOCUMENTS$28);
            return target;
        }
    }
    
    /**
     * Unsets the "ContactDocuments" element
     */
    public void unsetContactDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTDOCUMENTS$28, 0);
        }
    }
    
    /**
     * Gets the "ContactIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getContactIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(CONTACTISSUES$30, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ContactIssues" element
     */
    public boolean isSetContactIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTISSUES$30) != 0;
        }
    }
    
    /**
     * Sets the "ContactIssues" element
     */
    public void setContactIssues(org.erdc.cobie.cobielite.core.IssueCollectionType contactIssues)
    {
        generatedSetterHelperImpl(contactIssues, CONTACTISSUES$30, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ContactIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewContactIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(CONTACTISSUES$30);
            return target;
        }
    }
    
    /**
     * Unsets the "ContactIssues" element
     */
    public void unsetContactIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTISSUES$30, 0);
        }
    }
}
