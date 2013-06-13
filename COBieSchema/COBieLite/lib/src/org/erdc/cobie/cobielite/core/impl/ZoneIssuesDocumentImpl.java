/*
 * An XML document type.
 * Localname: ZoneIssues
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ZoneIssuesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ZoneIssues(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ZoneIssuesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ZoneIssuesDocument
{
    private static final long serialVersionUID = 1L;
    
    public ZoneIssuesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ZONEISSUES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ZoneIssues");
    
    
    /**
     * Gets the "ZoneIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getZoneIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(ZONEISSUES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ZoneIssues" element
     */
    public void setZoneIssues(org.erdc.cobie.cobielite.core.IssueCollectionType zoneIssues)
    {
        generatedSetterHelperImpl(zoneIssues, ZONEISSUES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ZoneIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewZoneIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(ZONEISSUES$0);
            return target;
        }
    }
}
