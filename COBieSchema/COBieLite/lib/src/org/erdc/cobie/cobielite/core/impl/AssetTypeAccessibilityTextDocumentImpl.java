/*
 * An XML document type.
 * Localname: AssetTypeAccessibilityText
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeAccessibilityTextDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypeAccessibilityText(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeAccessibilityTextDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeAccessibilityTextDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeAccessibilityTextDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPEACCESSIBILITYTEXT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeAccessibilityText");
    
    
    /**
     * Gets the "AssetTypeAccessibilityText" element
     */
    public java.lang.String getAssetTypeAccessibilityText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEACCESSIBILITYTEXT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeAccessibilityText" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetTypeAccessibilityText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTYPEACCESSIBILITYTEXT$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeAccessibilityText" element
     */
    public void setAssetTypeAccessibilityText(java.lang.String assetTypeAccessibilityText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEACCESSIBILITYTEXT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPEACCESSIBILITYTEXT$0);
            }
            target.setStringValue(assetTypeAccessibilityText);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeAccessibilityText" element
     */
    public void xsetAssetTypeAccessibilityText(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetTypeAccessibilityText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTYPEACCESSIBILITYTEXT$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETTYPEACCESSIBILITYTEXT$0);
            }
            target.set(assetTypeAccessibilityText);
        }
    }
}
