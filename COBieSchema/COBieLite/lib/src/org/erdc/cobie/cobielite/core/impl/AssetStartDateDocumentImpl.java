/*
 * An XML document type.
 * Localname: AssetStartDate
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetStartDateDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetStartDate(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetStartDateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetStartDateDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetStartDateDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETSTARTDATE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetStartDate");
    
    
    /**
     * Gets the "AssetStartDate" element
     */
    public java.lang.String getAssetStartDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETSTARTDATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetStartDate" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetStartDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETSTARTDATE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetStartDate" element
     */
    public void setAssetStartDate(java.lang.String assetStartDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETSTARTDATE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETSTARTDATE$0);
            }
            target.setStringValue(assetStartDate);
        }
    }
    
    /**
     * Sets (as xml) the "AssetStartDate" element
     */
    public void xsetAssetStartDate(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetStartDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETSTARTDATE$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETSTARTDATE$0);
            }
            target.set(assetStartDate);
        }
    }
}
