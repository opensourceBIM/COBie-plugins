/*
 * An XML document type.
 * Localname: AssetWarrantyStartDate
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetWarrantyStartDateDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetWarrantyStartDate(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetWarrantyStartDateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetWarrantyStartDateDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetWarrantyStartDateDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETWARRANTYSTARTDATE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetWarrantyStartDate");
    
    
    /**
     * Gets the "AssetWarrantyStartDate" element
     */
    public java.util.Calendar getAssetWarrantyStartDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETWARRANTYSTARTDATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetWarrantyStartDate" element
     */
    public org.apache.xmlbeans.XmlDate xgetAssetWarrantyStartDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(ASSETWARRANTYSTARTDATE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetWarrantyStartDate" element
     */
    public void setAssetWarrantyStartDate(java.util.Calendar assetWarrantyStartDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETWARRANTYSTARTDATE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETWARRANTYSTARTDATE$0);
            }
            target.setCalendarValue(assetWarrantyStartDate);
        }
    }
    
    /**
     * Sets (as xml) the "AssetWarrantyStartDate" element
     */
    public void xsetAssetWarrantyStartDate(org.apache.xmlbeans.XmlDate assetWarrantyStartDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(ASSETWARRANTYSTARTDATE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDate)get_store().add_element_user(ASSETWARRANTYSTARTDATE$0);
            }
            target.set(assetWarrantyStartDate);
        }
    }
}
