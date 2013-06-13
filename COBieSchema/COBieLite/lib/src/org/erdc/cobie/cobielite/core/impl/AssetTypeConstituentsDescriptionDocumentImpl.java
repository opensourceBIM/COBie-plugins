/*
 * An XML document type.
 * Localname: AssetTypeConstituentsDescription
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeConstituentsDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypeConstituentsDescription(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeConstituentsDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeConstituentsDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeConstituentsDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPECONSTITUENTSDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeConstituentsDescription");
    
    
    /**
     * Gets the "AssetTypeConstituentsDescription" element
     */
    public java.lang.String getAssetTypeConstituentsDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPECONSTITUENTSDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeConstituentsDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeConstituentsDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPECONSTITUENTSDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeConstituentsDescription" element
     */
    public void setAssetTypeConstituentsDescription(java.lang.String assetTypeConstituentsDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPECONSTITUENTSDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPECONSTITUENTSDESCRIPTION$0);
            }
            target.setStringValue(assetTypeConstituentsDescription);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeConstituentsDescription" element
     */
    public void xsetAssetTypeConstituentsDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeConstituentsDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPECONSTITUENTSDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(ASSETTYPECONSTITUENTSDESCRIPTION$0);
            }
            target.set(assetTypeConstituentsDescription);
        }
    }
}
