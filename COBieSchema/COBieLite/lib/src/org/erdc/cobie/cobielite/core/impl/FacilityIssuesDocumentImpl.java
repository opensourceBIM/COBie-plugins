/*
 * An XML document type.
 * Localname: FacilityIssues
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.FacilityIssuesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one FacilityIssues(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FacilityIssuesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.FacilityIssuesDocument
{
    private static final long serialVersionUID = 1L;
    
    public FacilityIssuesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FACILITYISSUES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityIssues");
    
    
    /**
     * Gets the "FacilityIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getFacilityIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(FACILITYISSUES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "FacilityIssues" element
     */
    public void setFacilityIssues(org.erdc.cobie.cobielite.core.IssueCollectionType facilityIssues)
    {
        generatedSetterHelperImpl(facilityIssues, FACILITYISSUES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "FacilityIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewFacilityIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(FACILITYISSUES$0);
            return target;
        }
    }
}
