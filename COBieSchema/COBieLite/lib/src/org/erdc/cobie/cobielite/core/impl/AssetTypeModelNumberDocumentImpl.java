/*
 * An XML document type.
 * Localname: AssetTypeModelNumber
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeModelNumberDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypeModelNumber(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeModelNumberDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeModelNumberDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeModelNumberDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPEMODELNUMBER$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeModelNumber");
    
    
    /**
     * Gets the "AssetTypeModelNumber" element
     */
    public java.lang.String getAssetTypeModelNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEMODELNUMBER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeModelNumber" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetTypeModelNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTYPEMODELNUMBER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeModelNumber" element
     */
    public void setAssetTypeModelNumber(java.lang.String assetTypeModelNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEMODELNUMBER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPEMODELNUMBER$0);
            }
            target.setStringValue(assetTypeModelNumber);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeModelNumber" element
     */
    public void xsetAssetTypeModelNumber(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetTypeModelNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTYPEMODELNUMBER$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETTYPEMODELNUMBER$0);
            }
            target.set(assetTypeModelNumber);
        }
    }
}
