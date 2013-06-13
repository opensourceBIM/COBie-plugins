/*
 * XML Type:  SpareType
 * Namespace: http://spare.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.spare.SpareType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.spare.impl;
/**
 * An XML SpareType(@http://spare.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class SpareTypeImpl extends org.erdc.cobie.cobielite.core.impl.SpareTypeImpl implements org.erdc.cobie.cobielite.spare.SpareType
{
    private static final long serialVersionUID = 1L;
    
    public SpareTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPAREDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpareDescription");
    private static final javax.xml.namespace.QName SPARESETNUMBER$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpareSetNumber");
    private static final javax.xml.namespace.QName SPAREPARTNUMBER$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SparePartNumber");
    private static final javax.xml.namespace.QName SPARECONTACTASSIGNMENTS$6 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpareContactAssignments");
    private static final javax.xml.namespace.QName SPAREATTRIBUTES$8 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpareAttributes");
    private static final javax.xml.namespace.QName SPAREDOCUMENTS$10 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpareDocuments");
    private static final javax.xml.namespace.QName SPAREISSUES$12 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpareIssues");
    
    
    /**
     * Gets the "SpareDescription" element
     */
    public java.lang.String getSpareDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPAREDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SpareDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetSpareDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(SPAREDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "SpareDescription" element
     */
    public boolean isSetSpareDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPAREDESCRIPTION$0) != 0;
        }
    }
    
    /**
     * Sets the "SpareDescription" element
     */
    public void setSpareDescription(java.lang.String spareDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPAREDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SPAREDESCRIPTION$0);
            }
            target.setStringValue(spareDescription);
        }
    }
    
    /**
     * Sets (as xml) the "SpareDescription" element
     */
    public void xsetSpareDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType spareDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(SPAREDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(SPAREDESCRIPTION$0);
            }
            target.set(spareDescription);
        }
    }
    
    /**
     * Unsets the "SpareDescription" element
     */
    public void unsetSpareDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPAREDESCRIPTION$0, 0);
        }
    }
    
    /**
     * Gets the "SpareSetNumber" element
     */
    public java.lang.String getSpareSetNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPARESETNUMBER$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SpareSetNumber" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetSpareSetNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(SPARESETNUMBER$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "SpareSetNumber" element
     */
    public boolean isSetSpareSetNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPARESETNUMBER$2) != 0;
        }
    }
    
    /**
     * Sets the "SpareSetNumber" element
     */
    public void setSpareSetNumber(java.lang.String spareSetNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPARESETNUMBER$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SPARESETNUMBER$2);
            }
            target.setStringValue(spareSetNumber);
        }
    }
    
    /**
     * Sets (as xml) the "SpareSetNumber" element
     */
    public void xsetSpareSetNumber(org.erdc.cobie.cobielite.core.CobieTextSimpleType spareSetNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(SPARESETNUMBER$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(SPARESETNUMBER$2);
            }
            target.set(spareSetNumber);
        }
    }
    
    /**
     * Unsets the "SpareSetNumber" element
     */
    public void unsetSpareSetNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPARESETNUMBER$2, 0);
        }
    }
    
    /**
     * Gets the "SparePartNumber" element
     */
    public java.lang.String getSparePartNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPAREPARTNUMBER$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SparePartNumber" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetSparePartNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(SPAREPARTNUMBER$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "SparePartNumber" element
     */
    public boolean isSetSparePartNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPAREPARTNUMBER$4) != 0;
        }
    }
    
    /**
     * Sets the "SparePartNumber" element
     */
    public void setSparePartNumber(java.lang.String sparePartNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPAREPARTNUMBER$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SPAREPARTNUMBER$4);
            }
            target.setStringValue(sparePartNumber);
        }
    }
    
    /**
     * Sets (as xml) the "SparePartNumber" element
     */
    public void xsetSparePartNumber(org.erdc.cobie.cobielite.core.CobieTextSimpleType sparePartNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(SPAREPARTNUMBER$4, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(SPAREPARTNUMBER$4);
            }
            target.set(sparePartNumber);
        }
    }
    
    /**
     * Unsets the "SparePartNumber" element
     */
    public void unsetSparePartNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPAREPARTNUMBER$4, 0);
        }
    }
    
    /**
     * Gets the "SpareContactAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType getSpareContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType)get_store().find_element_user(SPARECONTACTASSIGNMENTS$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "SpareContactAssignments" element
     */
    public boolean isSetSpareContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPARECONTACTASSIGNMENTS$6) != 0;
        }
    }
    
    /**
     * Sets the "SpareContactAssignments" element
     */
    public void setSpareContactAssignments(org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType spareContactAssignments)
    {
        generatedSetterHelperImpl(spareContactAssignments, SPARECONTACTASSIGNMENTS$6, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpareContactAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType addNewSpareContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType)get_store().add_element_user(SPARECONTACTASSIGNMENTS$6);
            return target;
        }
    }
    
    /**
     * Unsets the "SpareContactAssignments" element
     */
    public void unsetSpareContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPARECONTACTASSIGNMENTS$6, 0);
        }
    }
    
    /**
     * Gets the "SpareAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getSpareAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(SPAREATTRIBUTES$8, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "SpareAttributes" element
     */
    public boolean isSetSpareAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPAREATTRIBUTES$8) != 0;
        }
    }
    
    /**
     * Sets the "SpareAttributes" element
     */
    public void setSpareAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType spareAttributes)
    {
        generatedSetterHelperImpl(spareAttributes, SPAREATTRIBUTES$8, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpareAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewSpareAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(SPAREATTRIBUTES$8);
            return target;
        }
    }
    
    /**
     * Unsets the "SpareAttributes" element
     */
    public void unsetSpareAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPAREATTRIBUTES$8, 0);
        }
    }
    
    /**
     * Gets the "SpareDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getSpareDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(SPAREDOCUMENTS$10, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "SpareDocuments" element
     */
    public boolean isSetSpareDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPAREDOCUMENTS$10) != 0;
        }
    }
    
    /**
     * Sets the "SpareDocuments" element
     */
    public void setSpareDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType spareDocuments)
    {
        generatedSetterHelperImpl(spareDocuments, SPAREDOCUMENTS$10, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpareDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewSpareDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(SPAREDOCUMENTS$10);
            return target;
        }
    }
    
    /**
     * Unsets the "SpareDocuments" element
     */
    public void unsetSpareDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPAREDOCUMENTS$10, 0);
        }
    }
    
    /**
     * Gets the "SpareIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getSpareIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(SPAREISSUES$12, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "SpareIssues" element
     */
    public boolean isSetSpareIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPAREISSUES$12) != 0;
        }
    }
    
    /**
     * Sets the "SpareIssues" element
     */
    public void setSpareIssues(org.erdc.cobie.cobielite.core.IssueCollectionType spareIssues)
    {
        generatedSetterHelperImpl(spareIssues, SPAREISSUES$12, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpareIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewSpareIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(SPAREISSUES$12);
            return target;
        }
    }
    
    /**
     * Unsets the "SpareIssues" element
     */
    public void unsetSpareIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPAREISSUES$12, 0);
        }
    }
}
