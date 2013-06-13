/*
 * An XML document type.
 * Localname: AssetTypePortabilityText
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypePortabilityTextDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypePortabilityText(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypePortabilityTextDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypePortabilityTextDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypePortabilityTextDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPEPORTABILITYTEXT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypePortabilityText");
    
    
    /**
     * Gets the "AssetTypePortabilityText" element
     */
    public org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType.Enum getAssetTypePortabilityText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEPORTABILITYTEXT$0, 0);
            if (target == null)
            {
                return null;
            }
            return (org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypePortabilityText" element
     */
    public org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType xgetAssetTypePortabilityText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType)get_store().find_element_user(ASSETTYPEPORTABILITYTEXT$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypePortabilityText" element
     */
    public void setAssetTypePortabilityText(org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType.Enum assetTypePortabilityText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEPORTABILITYTEXT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPEPORTABILITYTEXT$0);
            }
            target.setEnumValue(assetTypePortabilityText);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypePortabilityText" element
     */
    public void xsetAssetTypePortabilityText(org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType assetTypePortabilityText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType)get_store().find_element_user(ASSETTYPEPORTABILITYTEXT$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType)get_store().add_element_user(ASSETTYPEPORTABILITYTEXT$0);
            }
            target.set(assetTypePortabilityText);
        }
    }
}
