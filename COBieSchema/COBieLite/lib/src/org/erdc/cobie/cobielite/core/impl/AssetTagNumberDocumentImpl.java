/*
 * An XML document type.
 * Localname: AssetTagNumber
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTagNumberDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTagNumber(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTagNumberDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTagNumberDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTagNumberDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTAGNUMBER$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTagNumber");
    
    
    /**
     * Gets the "AssetTagNumber" element
     */
    public java.lang.String getAssetTagNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTAGNUMBER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTagNumber" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetTagNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTAGNUMBER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetTagNumber" element
     */
    public void setAssetTagNumber(java.lang.String assetTagNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTAGNUMBER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTAGNUMBER$0);
            }
            target.setStringValue(assetTagNumber);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTagNumber" element
     */
    public void xsetAssetTagNumber(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetTagNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTAGNUMBER$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETTAGNUMBER$0);
            }
            target.set(assetTagNumber);
        }
    }
}
