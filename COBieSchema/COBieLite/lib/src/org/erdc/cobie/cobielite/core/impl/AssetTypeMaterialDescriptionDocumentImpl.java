/*
 * An XML document type.
 * Localname: AssetTypeMaterialDescription
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeMaterialDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypeMaterialDescription(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeMaterialDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeMaterialDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeMaterialDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPEMATERIALDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeMaterialDescription");
    
    
    /**
     * Gets the "AssetTypeMaterialDescription" element
     */
    public java.lang.String getAssetTypeMaterialDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEMATERIALDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeMaterialDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeMaterialDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPEMATERIALDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeMaterialDescription" element
     */
    public void setAssetTypeMaterialDescription(java.lang.String assetTypeMaterialDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEMATERIALDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPEMATERIALDESCRIPTION$0);
            }
            target.setStringValue(assetTypeMaterialDescription);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeMaterialDescription" element
     */
    public void xsetAssetTypeMaterialDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeMaterialDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPEMATERIALDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(ASSETTYPEMATERIALDESCRIPTION$0);
            }
            target.set(assetTypeMaterialDescription);
        }
    }
}
