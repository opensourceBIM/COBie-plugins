/*
 * An XML document type.
 * Localname: SiteAssignment
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SiteAssignmentDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SiteAssignment(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SiteAssignmentDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SiteAssignmentDocument
{
    private static final long serialVersionUID = 1L;
    
    public SiteAssignmentDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SITEASSIGNMENT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SiteAssignment");
    
    
    /**
     * Gets the "SiteAssignment" element
     */
    public org.erdc.cobie.cobielite.core.SiteType getSiteAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SiteType target = null;
            target = (org.erdc.cobie.cobielite.core.SiteType)get_store().find_element_user(SITEASSIGNMENT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "SiteAssignment" element
     */
    public void setSiteAssignment(org.erdc.cobie.cobielite.core.SiteType siteAssignment)
    {
        generatedSetterHelperImpl(siteAssignment, SITEASSIGNMENT$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SiteAssignment" element
     */
    public org.erdc.cobie.cobielite.core.SiteType addNewSiteAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SiteType target = null;
            target = (org.erdc.cobie.cobielite.core.SiteType)get_store().add_element_user(SITEASSIGNMENT$0);
            return target;
        }
    }
}
