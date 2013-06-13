/*
 * An XML document type.
 * Localname: AssetTypeExpectedLifeValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AssetTypeExpectedLifeValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AssetTypeExpectedLifeValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AssetTypeExpectedLifeValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AssetTypeExpectedLifeValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeExpectedLifeValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPEEXPECTEDLIFEVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeExpectedLifeValue");
    
    
    /**
     * Gets the "AssetTypeExpectedLifeValue" element
     */
    public org.erdc.cobie.cobielite.core.IntegerValueType getAssetTypeExpectedLifeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IntegerValueType target = null;
            target = (org.erdc.cobie.cobielite.core.IntegerValueType)get_store().find_element_user(ASSETTYPEEXPECTEDLIFEVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AssetTypeExpectedLifeValue" element
     */
    public void setAssetTypeExpectedLifeValue(org.erdc.cobie.cobielite.core.IntegerValueType assetTypeExpectedLifeValue)
    {
        generatedSetterHelperImpl(assetTypeExpectedLifeValue, ASSETTYPEEXPECTEDLIFEVALUE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypeExpectedLifeValue" element
     */
    public org.erdc.cobie.cobielite.core.IntegerValueType addNewAssetTypeExpectedLifeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IntegerValueType target = null;
            target = (org.erdc.cobie.cobielite.core.IntegerValueType)get_store().add_element_user(ASSETTYPEEXPECTEDLIFEVALUE$0);
            return target;
        }
    }
}
