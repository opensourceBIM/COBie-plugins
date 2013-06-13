/*
 * An XML document type.
 * Localname: AssetLocationDescription
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetLocationDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetLocationDescription(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetLocationDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetLocationDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetLocationDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETLOCATIONDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetLocationDescription");
    
    
    /**
     * Gets the "AssetLocationDescription" element
     */
    public java.lang.String getAssetLocationDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETLOCATIONDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetLocationDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetLocationDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETLOCATIONDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetLocationDescription" element
     */
    public void setAssetLocationDescription(java.lang.String assetLocationDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETLOCATIONDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETLOCATIONDESCRIPTION$0);
            }
            target.setStringValue(assetLocationDescription);
        }
    }
    
    /**
     * Sets (as xml) the "AssetLocationDescription" element
     */
    public void xsetAssetLocationDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetLocationDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETLOCATIONDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(ASSETLOCATIONDESCRIPTION$0);
            }
            target.set(assetLocationDescription);
        }
    }
}
