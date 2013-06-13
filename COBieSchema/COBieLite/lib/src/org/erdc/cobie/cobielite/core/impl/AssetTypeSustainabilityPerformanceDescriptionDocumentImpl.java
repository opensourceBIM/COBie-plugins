/*
 * An XML document type.
 * Localname: AssetTypeSustainabilityPerformanceDescription
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeSustainabilityPerformanceDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypeSustainabilityPerformanceDescription(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeSustainabilityPerformanceDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeSustainabilityPerformanceDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeSustainabilityPerformanceDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPESUSTAINABILITYPERFORMANCEDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeSustainabilityPerformanceDescription");
    
    
    /**
     * Gets the "AssetTypeSustainabilityPerformanceDescription" element
     */
    public java.lang.String getAssetTypeSustainabilityPerformanceDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPESUSTAINABILITYPERFORMANCEDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeSustainabilityPerformanceDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeSustainabilityPerformanceDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPESUSTAINABILITYPERFORMANCEDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeSustainabilityPerformanceDescription" element
     */
    public void setAssetTypeSustainabilityPerformanceDescription(java.lang.String assetTypeSustainabilityPerformanceDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPESUSTAINABILITYPERFORMANCEDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPESUSTAINABILITYPERFORMANCEDESCRIPTION$0);
            }
            target.setStringValue(assetTypeSustainabilityPerformanceDescription);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeSustainabilityPerformanceDescription" element
     */
    public void xsetAssetTypeSustainabilityPerformanceDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeSustainabilityPerformanceDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPESUSTAINABILITYPERFORMANCEDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(ASSETTYPESUSTAINABILITYPERFORMANCEDESCRIPTION$0);
            }
            target.set(assetTypeSustainabilityPerformanceDescription);
        }
    }
}
