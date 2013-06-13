/*
 * An XML document type.
 * Localname: AssetTypeReplacementCostValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeReplacementCostValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypeReplacementCostValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeReplacementCostValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeReplacementCostValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeReplacementCostValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPEREPLACEMENTCOSTVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeReplacementCostValue");
    
    
    /**
     * Gets the "AssetTypeReplacementCostValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getAssetTypeReplacementCostValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(ASSETTYPEREPLACEMENTCOSTVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeReplacementCostValue" element
     */
    public void setAssetTypeReplacementCostValue(org.erdc.cobie.cobielite.core.DecimalValueType assetTypeReplacementCostValue)
    {
        generatedSetterHelperImpl(assetTypeReplacementCostValue, ASSETTYPEREPLACEMENTCOSTVALUE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypeReplacementCostValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType addNewAssetTypeReplacementCostValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(ASSETTYPEREPLACEMENTCOSTVALUE$0);
            return target;
        }
    }
}
