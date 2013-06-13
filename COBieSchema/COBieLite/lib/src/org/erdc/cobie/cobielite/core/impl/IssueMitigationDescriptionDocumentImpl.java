/*
 * An XML document type.
 * Localname: IssueMitigationDescription
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.IssueMitigationDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one IssueMitigationDescription(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class IssueMitigationDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.IssueMitigationDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public IssueMitigationDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ISSUEMITIGATIONDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "IssueMitigationDescription");
    
    
    /**
     * Gets the "IssueMitigationDescription" element
     */
    public java.lang.String getIssueMitigationDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUEMITIGATIONDESCRIPTION$0, 0);
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
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ISSUEMITIGATIONDESCRIPTION$0, 0);
            return target;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSUEMITIGATIONDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISSUEMITIGATIONDESCRIPTION$0);
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
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ISSUEMITIGATIONDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ISSUEMITIGATIONDESCRIPTION$0);
            }
            target.set(issueMitigationDescription);
        }
    }
}
