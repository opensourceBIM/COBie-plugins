/*
 * XML Type:  IssueType
 * Namespace: http://issue.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.issue.IssueType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.issue.impl;
/**
 * An XML IssueType(@http://issue.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class IssueTypeImpl extends org.erdc.cobie.cobielite.core.impl.IssueTypeImpl implements org.erdc.cobie.cobielite.issue.IssueType
{
    private static final long serialVersionUID = 1L;
    
    public IssueTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ISSUERISKTEXT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "IssueRiskText");
    private static final javax.xml.namespace.QName ISSUESEVERITYTEXT$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "IssueSeverityText");
    private static final javax.xml.namespace.QName ISSUEIMPACTTEXT$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "IssueImpactText");
    private static final javax.xml.namespace.QName ISSUEDESCRIPTION$6 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "IssueDescription");
    private static final javax.xml.namespace.QName CONTACTASSIGNMENT$8 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ContactAssignment");
    private static final javax.xml.namespace.QName ISSUEMITIGATIONDESCRIPTION$10 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "IssueMitigationDescription");
    
    
    /**
     * Gets the "IssueRiskText" element
     */
    public java.lang.String getIssueRiskText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUERISKTEXT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "IssueRiskText" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetIssueRiskText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ISSUERISKTEXT$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "IssueRiskText" element
     */
    public boolean isSetIssueRiskText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ISSUERISKTEXT$0) != 0;
        }
    }
    
    /**
     * Sets the "IssueRiskText" element
     */
    public void setIssueRiskText(java.lang.String issueRiskText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUERISKTEXT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISSUERISKTEXT$0);
            }
            target.setStringValue(issueRiskText);
        }
    }
    
    /**
     * Sets (as xml) the "IssueRiskText" element
     */
    public void xsetIssueRiskText(org.erdc.cobie.cobielite.core.CobieTextSimpleType issueRiskText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ISSUERISKTEXT$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ISSUERISKTEXT$0);
            }
            target.set(issueRiskText);
        }
    }
    
    /**
     * Unsets the "IssueRiskText" element
     */
    public void unsetIssueRiskText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ISSUERISKTEXT$0, 0);
        }
    }
    
    /**
     * Gets the "IssueSeverityText" element
     */
    public java.lang.String getIssueSeverityText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUESEVERITYTEXT$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "IssueSeverityText" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetIssueSeverityText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ISSUESEVERITYTEXT$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "IssueSeverityText" element
     */
    public boolean isSetIssueSeverityText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ISSUESEVERITYTEXT$2) != 0;
        }
    }
    
    /**
     * Sets the "IssueSeverityText" element
     */
    public void setIssueSeverityText(java.lang.String issueSeverityText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUESEVERITYTEXT$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISSUESEVERITYTEXT$2);
            }
            target.setStringValue(issueSeverityText);
        }
    }
    
    /**
     * Sets (as xml) the "IssueSeverityText" element
     */
    public void xsetIssueSeverityText(org.erdc.cobie.cobielite.core.CobieTextSimpleType issueSeverityText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ISSUESEVERITYTEXT$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ISSUESEVERITYTEXT$2);
            }
            target.set(issueSeverityText);
        }
    }
    
    /**
     * Unsets the "IssueSeverityText" element
     */
    public void unsetIssueSeverityText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ISSUESEVERITYTEXT$2, 0);
        }
    }
    
    /**
     * Gets the "IssueImpactText" element
     */
    public java.lang.String getIssueImpactText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUEIMPACTTEXT$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "IssueImpactText" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetIssueImpactText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ISSUEIMPACTTEXT$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "IssueImpactText" element
     */
    public boolean isSetIssueImpactText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ISSUEIMPACTTEXT$4) != 0;
        }
    }
    
    /**
     * Sets the "IssueImpactText" element
     */
    public void setIssueImpactText(java.lang.String issueImpactText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUEIMPACTTEXT$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISSUEIMPACTTEXT$4);
            }
            target.setStringValue(issueImpactText);
        }
    }
    
    /**
     * Sets (as xml) the "IssueImpactText" element
     */
    public void xsetIssueImpactText(org.erdc.cobie.cobielite.core.CobieTextSimpleType issueImpactText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ISSUEIMPACTTEXT$4, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ISSUEIMPACTTEXT$4);
            }
            target.set(issueImpactText);
        }
    }
    
    /**
     * Unsets the "IssueImpactText" element
     */
    public void unsetIssueImpactText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ISSUEIMPACTTEXT$4, 0);
        }
    }
    
    /**
     * Gets the "IssueDescription" element
     */
    public java.lang.String getIssueDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUEDESCRIPTION$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "IssueDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetIssueDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ISSUEDESCRIPTION$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "IssueDescription" element
     */
    public boolean isSetIssueDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ISSUEDESCRIPTION$6) != 0;
        }
    }
    
    /**
     * Sets the "IssueDescription" element
     */
    public void setIssueDescription(java.lang.String issueDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUEDESCRIPTION$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISSUEDESCRIPTION$6);
            }
            target.setStringValue(issueDescription);
        }
    }
    
    /**
     * Sets (as xml) the "IssueDescription" element
     */
    public void xsetIssueDescription(org.erdc.cobie.cobielite.core.CobieTextSimpleType issueDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ISSUEDESCRIPTION$6, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ISSUEDESCRIPTION$6);
            }
            target.set(issueDescription);
        }
    }
    
    /**
     * Unsets the "IssueDescription" element
     */
    public void unsetIssueDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ISSUEDESCRIPTION$6, 0);
        }
    }
    
    /**
     * Gets the "ContactAssignment" element
     */
    public org.erdc.cobie.cobielite.core.ContactKeyType getContactAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactKeyType)get_store().find_element_user(CONTACTASSIGNMENT$8, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ContactAssignment" element
     */
    public boolean isSetContactAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTASSIGNMENT$8) != 0;
        }
    }
    
    /**
     * Sets the "ContactAssignment" element
     */
    public void setContactAssignment(org.erdc.cobie.cobielite.core.ContactKeyType contactAssignment)
    {
        generatedSetterHelperImpl(contactAssignment, CONTACTASSIGNMENT$8, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ContactAssignment" element
     */
    public org.erdc.cobie.cobielite.core.ContactKeyType addNewContactAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactKeyType)get_store().add_element_user(CONTACTASSIGNMENT$8);
            return target;
        }
    }
    
    /**
     * Unsets the "ContactAssignment" element
     */
    public void unsetContactAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTASSIGNMENT$8, 0);
        }
    }
    
    /**
     * Gets the "IssueMitigationDescription" element
     */
    public java.lang.String getIssueMitigationDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUEMITIGATIONDESCRIPTION$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "IssueMitigationDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetIssueMitigationDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ISSUEMITIGATIONDESCRIPTION$10, 0);
            return target;
        }
    }
    
    /**
     * True if has "IssueMitigationDescription" element
     */
    public boolean isSetIssueMitigationDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ISSUEMITIGATIONDESCRIPTION$10) != 0;
        }
    }
    
    /**
     * Sets the "IssueMitigationDescription" element
     */
    public void setIssueMitigationDescription(java.lang.String issueMitigationDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUEMITIGATIONDESCRIPTION$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISSUEMITIGATIONDESCRIPTION$10);
            }
            target.setStringValue(issueMitigationDescription);
        }
    }
    
    /**
     * Sets (as xml) the "IssueMitigationDescription" element
     */
    public void xsetIssueMitigationDescription(org.erdc.cobie.cobielite.core.CobieTextSimpleType issueMitigationDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ISSUEMITIGATIONDESCRIPTION$10, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ISSUEMITIGATIONDESCRIPTION$10);
            }
            target.set(issueMitigationDescription);
        }
    }
    
    /**
     * Unsets the "IssueMitigationDescription" element
     */
    public void unsetIssueMitigationDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ISSUEMITIGATIONDESCRIPTION$10, 0);
        }
    }
}
