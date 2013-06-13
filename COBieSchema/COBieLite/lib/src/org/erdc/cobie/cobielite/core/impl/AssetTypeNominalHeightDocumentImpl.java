/*
 * An XML document type.
 * Localname: AssetTypeNominalHeight
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeNominalHeightDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypeNominalHeight(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeNominalHeightDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeNominalHeightDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeNominalHeightDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPENOMINALHEIGHT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeNominalHeight");
    
    
    /**
     * Gets the "AssetTypeNominalHeight" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getAssetTypeNominalHeight()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(ASSETTYPENOMINALHEIGHT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeNominalHeight" element
     */
    public void setAssetTypeNominalHeight(org.erdc.cobie.cobielite.core.DecimalValueType assetTypeNominalHeight)
    {
        generatedSetterHelperImpl(assetTypeNominalHeight, ASSETTYPENOMINALHEIGHT$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypeNominalHeight" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType addNewAssetTypeNominalHeight()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(ASSETTYPENOMINALHEIGHT$0);
            return target;
        }
    }
}
