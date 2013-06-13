/*
 * An XML document type.
 * Localname: AssetTypeNominalWidth
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeNominalWidthDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypeNominalWidth(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeNominalWidthDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeNominalWidthDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeNominalWidthDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPENOMINALWIDTH$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeNominalWidth");
    
    
    /**
     * Gets the "AssetTypeNominalWidth" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getAssetTypeNominalWidth()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(ASSETTYPENOMINALWIDTH$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeNominalWidth" element
     */
    public void setAssetTypeNominalWidth(org.erdc.cobie.cobielite.core.DecimalValueType assetTypeNominalWidth)
    {
        generatedSetterHelperImpl(assetTypeNominalWidth, ASSETTYPENOMINALWIDTH$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypeNominalWidth" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType addNewAssetTypeNominalWidth()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(ASSETTYPENOMINALWIDTH$0);
            return target;
        }
    }
}
