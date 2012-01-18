/*
 * XML Type:  ContactType
 * Namespace: cobieLite
 * Java type: cobieLite.ContactType
 *
 * Automatically generated - do not modify.
 */
package cobieLite.impl;
/**
 * An XML ContactType(@cobieLite).
 *
 * This is a complex type.
 */
public class ContactTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.ContactType
{
    private static final long serialVersionUID = 1L;
    
    public ContactTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EMAIL$0 = 
        new javax.xml.namespace.QName("", "Email");
    private static final javax.xml.namespace.QName CREATEDBY$2 = 
        new javax.xml.namespace.QName("", "CreatedBy");
    private static final javax.xml.namespace.QName CREATEDON$4 = 
        new javax.xml.namespace.QName("", "CreatedOn");
    private static final javax.xml.namespace.QName CATEGORY$6 = 
        new javax.xml.namespace.QName("", "Category");
    private static final javax.xml.namespace.QName COMPANY$8 = 
        new javax.xml.namespace.QName("", "Company");
    private static final javax.xml.namespace.QName PHONE$10 = 
        new javax.xml.namespace.QName("", "Phone");
    private static final javax.xml.namespace.QName EXTERNALSYSTEM$12 = 
        new javax.xml.namespace.QName("", "ExternalSystem");
    private static final javax.xml.namespace.QName EXTERNALOBJECT$14 = 
        new javax.xml.namespace.QName("", "ExternalObject");
    private static final javax.xml.namespace.QName EXTERNALIDENTIFIER$16 = 
        new javax.xml.namespace.QName("", "ExternalIdentifier");
    private static final javax.xml.namespace.QName DEPARTMENT$18 = 
        new javax.xml.namespace.QName("", "Department");
    private static final javax.xml.namespace.QName ORGANIZATIONCODE$20 = 
        new javax.xml.namespace.QName("", "OrganizationCode");
    private static final javax.xml.namespace.QName GIVENNAME$22 = 
        new javax.xml.namespace.QName("", "GivenName");
    private static final javax.xml.namespace.QName FAMILYNAME$24 = 
        new javax.xml.namespace.QName("", "FamilyName");
    private static final javax.xml.namespace.QName STREET$26 = 
        new javax.xml.namespace.QName("", "Street");
    private static final javax.xml.namespace.QName POSTALBOX$28 = 
        new javax.xml.namespace.QName("", "PostalBox");
    private static final javax.xml.namespace.QName TOWN$30 = 
        new javax.xml.namespace.QName("", "Town");
    private static final javax.xml.namespace.QName STATEREGION$32 = 
        new javax.xml.namespace.QName("", "StateRegion");
    private static final javax.xml.namespace.QName POSTALCODE$34 = 
        new javax.xml.namespace.QName("", "PostalCode");
    private static final javax.xml.namespace.QName COUNTRY$36 = 
        new javax.xml.namespace.QName("", "Country");
    
    
    /**
     * Gets the "Email" element
     */
    public java.lang.String getEmail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EMAIL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Email" element
     */
    public cobieLite.EmailAddressType xgetEmail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.EmailAddressType target = null;
            target = (cobieLite.EmailAddressType)get_store().find_element_user(EMAIL$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Email" element
     */
    public void setEmail(java.lang.String email)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EMAIL$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EMAIL$0);
            }
            target.setStringValue(email);
        }
    }
    
    /**
     * Sets (as xml) the "Email" element
     */
    public void xsetEmail(cobieLite.EmailAddressType email)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.EmailAddressType target = null;
            target = (cobieLite.EmailAddressType)get_store().find_element_user(EMAIL$0, 0);
            if (target == null)
            {
                target = (cobieLite.EmailAddressType)get_store().add_element_user(EMAIL$0);
            }
            target.set(email);
        }
    }
    
    /**
     * Gets the "CreatedBy" element
     */
    public java.lang.String getCreatedBy()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREATEDBY$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "CreatedBy" element
     */
    public cobieLite.EmailAddressType xgetCreatedBy()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.EmailAddressType target = null;
            target = (cobieLite.EmailAddressType)get_store().find_element_user(CREATEDBY$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CreatedBy" element
     */
    public void setCreatedBy(java.lang.String createdBy)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREATEDBY$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CREATEDBY$2);
            }
            target.setStringValue(createdBy);
        }
    }
    
    /**
     * Sets (as xml) the "CreatedBy" element
     */
    public void xsetCreatedBy(cobieLite.EmailAddressType createdBy)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.EmailAddressType target = null;
            target = (cobieLite.EmailAddressType)get_store().find_element_user(CREATEDBY$2, 0);
            if (target == null)
            {
                target = (cobieLite.EmailAddressType)get_store().add_element_user(CREATEDBY$2);
            }
            target.set(createdBy);
        }
    }
    
    /**
     * Gets the "CreatedOn" element
     */
    public java.util.Calendar getCreatedOn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREATEDON$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "CreatedOn" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetCreatedOn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(CREATEDON$4, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CreatedOn" element
     */
    public void setCreatedOn(java.util.Calendar createdOn)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREATEDON$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CREATEDON$4);
            }
            target.setCalendarValue(createdOn);
        }
    }
    
    /**
     * Sets (as xml) the "CreatedOn" element
     */
    public void xsetCreatedOn(org.apache.xmlbeans.XmlDateTime createdOn)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(CREATEDON$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(CREATEDON$4);
            }
            target.set(createdOn);
        }
    }
    
    /**
     * Gets the "Category" element
     */
    public java.lang.String getCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Category" element
     */
    public org.apache.xmlbeans.XmlString xgetCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY$6, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Category" element
     */
    public void setCategory(java.lang.String category)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CATEGORY$6);
            }
            target.setStringValue(category);
        }
    }
    
    /**
     * Sets (as xml) the "Category" element
     */
    public void xsetCategory(org.apache.xmlbeans.XmlString category)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CATEGORY$6);
            }
            target.set(category);
        }
    }
    
    /**
     * Gets the "Company" element
     */
    public java.lang.String getCompany()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPANY$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Company" element
     */
    public org.apache.xmlbeans.XmlString xgetCompany()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPANY$8, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Company" element
     */
    public void setCompany(java.lang.String company)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COMPANY$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COMPANY$8);
            }
            target.setStringValue(company);
        }
    }
    
    /**
     * Sets (as xml) the "Company" element
     */
    public void xsetCompany(org.apache.xmlbeans.XmlString company)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COMPANY$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COMPANY$8);
            }
            target.set(company);
        }
    }
    
    /**
     * Gets the "Phone" element
     */
    public java.lang.String getPhone()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PHONE$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Phone" element
     */
    public org.apache.xmlbeans.XmlString xgetPhone()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PHONE$10, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Phone" element
     */
    public void setPhone(java.lang.String phone)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PHONE$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PHONE$10);
            }
            target.setStringValue(phone);
        }
    }
    
    /**
     * Sets (as xml) the "Phone" element
     */
    public void xsetPhone(org.apache.xmlbeans.XmlString phone)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PHONE$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PHONE$10);
            }
            target.set(phone);
        }
    }
    
    /**
     * Gets the "ExternalSystem" element
     */
    public java.lang.String getExternalSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALSYSTEM$12, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ExternalSystem" element
     */
    public org.apache.xmlbeans.XmlString xgetExternalSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALSYSTEM$12, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ExternalSystem" element
     */
    public void setExternalSystem(java.lang.String externalSystem)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALSYSTEM$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTERNALSYSTEM$12);
            }
            target.setStringValue(externalSystem);
        }
    }
    
    /**
     * Sets (as xml) the "ExternalSystem" element
     */
    public void xsetExternalSystem(org.apache.xmlbeans.XmlString externalSystem)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALSYSTEM$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTERNALSYSTEM$12);
            }
            target.set(externalSystem);
        }
    }
    
    /**
     * Gets the "ExternalObject" element
     */
    public java.lang.String getExternalObject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALOBJECT$14, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ExternalObject" element
     */
    public org.apache.xmlbeans.XmlString xgetExternalObject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALOBJECT$14, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ExternalObject" element
     */
    public void setExternalObject(java.lang.String externalObject)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALOBJECT$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTERNALOBJECT$14);
            }
            target.setStringValue(externalObject);
        }
    }
    
    /**
     * Sets (as xml) the "ExternalObject" element
     */
    public void xsetExternalObject(org.apache.xmlbeans.XmlString externalObject)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALOBJECT$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTERNALOBJECT$14);
            }
            target.set(externalObject);
        }
    }
    
    /**
     * Gets the "ExternalIdentifier" element
     */
    public java.lang.String getExternalIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALIDENTIFIER$16, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ExternalIdentifier" element
     */
    public org.apache.xmlbeans.XmlString xgetExternalIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALIDENTIFIER$16, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ExternalIdentifier" element
     */
    public void setExternalIdentifier(java.lang.String externalIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTERNALIDENTIFIER$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTERNALIDENTIFIER$16);
            }
            target.setStringValue(externalIdentifier);
        }
    }
    
    /**
     * Sets (as xml) the "ExternalIdentifier" element
     */
    public void xsetExternalIdentifier(org.apache.xmlbeans.XmlString externalIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTERNALIDENTIFIER$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTERNALIDENTIFIER$16);
            }
            target.set(externalIdentifier);
        }
    }
    
    /**
     * Gets the "Department" element
     */
    public java.lang.String getDepartment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DEPARTMENT$18, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Department" element
     */
    public org.apache.xmlbeans.XmlString xgetDepartment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DEPARTMENT$18, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Department" element
     */
    public void setDepartment(java.lang.String department)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DEPARTMENT$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DEPARTMENT$18);
            }
            target.setStringValue(department);
        }
    }
    
    /**
     * Sets (as xml) the "Department" element
     */
    public void xsetDepartment(org.apache.xmlbeans.XmlString department)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DEPARTMENT$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DEPARTMENT$18);
            }
            target.set(department);
        }
    }
    
    /**
     * Gets the "OrganizationCode" element
     */
    public java.lang.String getOrganizationCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORGANIZATIONCODE$20, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "OrganizationCode" element
     */
    public org.apache.xmlbeans.XmlString xgetOrganizationCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ORGANIZATIONCODE$20, 0);
            return target;
        }
    }
    
    /**
     * Sets the "OrganizationCode" element
     */
    public void setOrganizationCode(java.lang.String organizationCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORGANIZATIONCODE$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ORGANIZATIONCODE$20);
            }
            target.setStringValue(organizationCode);
        }
    }
    
    /**
     * Sets (as xml) the "OrganizationCode" element
     */
    public void xsetOrganizationCode(org.apache.xmlbeans.XmlString organizationCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ORGANIZATIONCODE$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ORGANIZATIONCODE$20);
            }
            target.set(organizationCode);
        }
    }
    
    /**
     * Gets the "GivenName" element
     */
    public java.lang.String getGivenName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(GIVENNAME$22, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "GivenName" element
     */
    public org.apache.xmlbeans.XmlString xgetGivenName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(GIVENNAME$22, 0);
            return target;
        }
    }
    
    /**
     * Sets the "GivenName" element
     */
    public void setGivenName(java.lang.String givenName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(GIVENNAME$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(GIVENNAME$22);
            }
            target.setStringValue(givenName);
        }
    }
    
    /**
     * Sets (as xml) the "GivenName" element
     */
    public void xsetGivenName(org.apache.xmlbeans.XmlString givenName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(GIVENNAME$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(GIVENNAME$22);
            }
            target.set(givenName);
        }
    }
    
    /**
     * Gets the "FamilyName" element
     */
    public java.lang.String getFamilyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FAMILYNAME$24, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FamilyName" element
     */
    public org.apache.xmlbeans.XmlString xgetFamilyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FAMILYNAME$24, 0);
            return target;
        }
    }
    
    /**
     * Sets the "FamilyName" element
     */
    public void setFamilyName(java.lang.String familyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FAMILYNAME$24, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FAMILYNAME$24);
            }
            target.setStringValue(familyName);
        }
    }
    
    /**
     * Sets (as xml) the "FamilyName" element
     */
    public void xsetFamilyName(org.apache.xmlbeans.XmlString familyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FAMILYNAME$24, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FAMILYNAME$24);
            }
            target.set(familyName);
        }
    }
    
    /**
     * Gets the "Street" element
     */
    public java.lang.String getStreet()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STREET$26, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Street" element
     */
    public org.apache.xmlbeans.XmlString xgetStreet()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STREET$26, 0);
            return target;
        }
    }
    
    /**
     * True if has "Street" element
     */
    public boolean isSetStreet()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(STREET$26) != 0;
        }
    }
    
    /**
     * Sets the "Street" element
     */
    public void setStreet(java.lang.String street)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STREET$26, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(STREET$26);
            }
            target.setStringValue(street);
        }
    }
    
    /**
     * Sets (as xml) the "Street" element
     */
    public void xsetStreet(org.apache.xmlbeans.XmlString street)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STREET$26, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(STREET$26);
            }
            target.set(street);
        }
    }
    
    /**
     * Unsets the "Street" element
     */
    public void unsetStreet()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(STREET$26, 0);
        }
    }
    
    /**
     * Gets the "PostalBox" element
     */
    public java.lang.String getPostalBox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSTALBOX$28, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PostalBox" element
     */
    public org.apache.xmlbeans.XmlString xgetPostalBox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POSTALBOX$28, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PostalBox" element
     */
    public void setPostalBox(java.lang.String postalBox)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSTALBOX$28, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(POSTALBOX$28);
            }
            target.setStringValue(postalBox);
        }
    }
    
    /**
     * Sets (as xml) the "PostalBox" element
     */
    public void xsetPostalBox(org.apache.xmlbeans.XmlString postalBox)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POSTALBOX$28, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(POSTALBOX$28);
            }
            target.set(postalBox);
        }
    }
    
    /**
     * Gets the "Town" element
     */
    public java.lang.String getTown()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TOWN$30, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Town" element
     */
    public org.apache.xmlbeans.XmlString xgetTown()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TOWN$30, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Town" element
     */
    public void setTown(java.lang.String town)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TOWN$30, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TOWN$30);
            }
            target.setStringValue(town);
        }
    }
    
    /**
     * Sets (as xml) the "Town" element
     */
    public void xsetTown(org.apache.xmlbeans.XmlString town)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TOWN$30, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TOWN$30);
            }
            target.set(town);
        }
    }
    
    /**
     * Gets the "StateRegion" element
     */
    public java.lang.String getStateRegion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STATEREGION$32, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "StateRegion" element
     */
    public org.apache.xmlbeans.XmlString xgetStateRegion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STATEREGION$32, 0);
            return target;
        }
    }
    
    /**
     * Sets the "StateRegion" element
     */
    public void setStateRegion(java.lang.String stateRegion)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STATEREGION$32, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(STATEREGION$32);
            }
            target.setStringValue(stateRegion);
        }
    }
    
    /**
     * Sets (as xml) the "StateRegion" element
     */
    public void xsetStateRegion(org.apache.xmlbeans.XmlString stateRegion)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STATEREGION$32, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(STATEREGION$32);
            }
            target.set(stateRegion);
        }
    }
    
    /**
     * Gets the "PostalCode" element
     */
    public java.lang.String getPostalCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSTALCODE$34, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PostalCode" element
     */
    public org.apache.xmlbeans.XmlString xgetPostalCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POSTALCODE$34, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PostalCode" element
     */
    public void setPostalCode(java.lang.String postalCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSTALCODE$34, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(POSTALCODE$34);
            }
            target.setStringValue(postalCode);
        }
    }
    
    /**
     * Sets (as xml) the "PostalCode" element
     */
    public void xsetPostalCode(org.apache.xmlbeans.XmlString postalCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POSTALCODE$34, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(POSTALCODE$34);
            }
            target.set(postalCode);
        }
    }
    
    /**
     * Gets the "Country" element
     */
    public java.lang.String getCountry()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COUNTRY$36, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Country" element
     */
    public org.apache.xmlbeans.XmlString xgetCountry()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COUNTRY$36, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Country" element
     */
    public void setCountry(java.lang.String country)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COUNTRY$36, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COUNTRY$36);
            }
            target.setStringValue(country);
        }
    }
    
    /**
     * Sets (as xml) the "Country" element
     */
    public void xsetCountry(org.apache.xmlbeans.XmlString country)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COUNTRY$36, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COUNTRY$36);
            }
            target.set(country);
        }
    }
}
