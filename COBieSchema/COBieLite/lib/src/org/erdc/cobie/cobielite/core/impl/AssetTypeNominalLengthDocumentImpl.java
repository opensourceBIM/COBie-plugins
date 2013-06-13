/*
 * An XML document type.
 * Localname: AssetTypeNominalLength
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeNominalLengthDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypeNominalLength(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeNominalLengthDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeNominalLengthDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeNominalLengthDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPENOMINALLENGTH$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeNominalLength");
    
    
    /**
     * Gets the "AssetTypeNominalLength" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getAssetTypeNominalLength()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(ASSETTYPENOMINALLENGTH$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeNominalLength" element
     */
    public void setAssetTypeNominalLength(org.erdc.cobie.cobielite.core.DecimalValueType assetTypeNominalLength)
    {
        generatedSetterHelperImpl(assetTypeNominalLength, ASSETTYPENOMINALLENGTH$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypeNominalLength" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType addNewAssetTypeNominalLength()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(ASSETTYPENOMINALLENGTH$0);
            return target;
        }
    }
}
