/*
 * An XML document type.
 * Localname: AssetTypeCodePerformance
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeCodePerformanceDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypeCodePerformance(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeCodePerformanceDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeCodePerformanceDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeCodePerformanceDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPECODEPERFORMANCE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeCodePerformance");
    
    
    /**
     * Gets the "AssetTypeCodePerformance" element
     */
    public java.lang.String getAssetTypeCodePerformance()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPECODEPERFORMANCE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeCodePerformance" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetTypeCodePerformance()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTYPECODEPERFORMANCE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeCodePerformance" element
     */
    public void setAssetTypeCodePerformance(java.lang.String assetTypeCodePerformance)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPECODEPERFORMANCE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPECODEPERFORMANCE$0);
            }
            target.setStringValue(assetTypeCodePerformance);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeCodePerformance" element
     */
    public void xsetAssetTypeCodePerformance(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetTypeCodePerformance)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTYPECODEPERFORMANCE$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETTYPECODEPERFORMANCE$0);
            }
            target.set(assetTypeCodePerformance);
        }
    }
}
