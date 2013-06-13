/*
 * An XML document type.
 * Localname: AssetName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetName");
    
    
    /**
     * Gets the "AssetName" element
     */
    public java.lang.String getAssetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetAssetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(ASSETNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetName" element
     */
    public void setAssetName(java.lang.String assetName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETNAME$0);
            }
            target.setStringValue(assetName);
        }
    }
    
    /**
     * Sets (as xml) the "AssetName" element
     */
    public void xsetAssetName(org.erdc.cobie.cobielite.core.CobieNameSimpleType assetName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(ASSETNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(ASSETNAME$0);
            }
            target.set(assetName);
        }
    }
}
