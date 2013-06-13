/*
 * An XML document type.
 * Localname: AttributeDecimalValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeDecimalValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AttributeDecimalValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AttributeDecimalValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AttributeDecimalValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public AttributeDecimalValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTEDECIMALVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeDecimalValue");
    
    
    /**
     * Gets the "AttributeDecimalValue" element
     */
    public org.erdc.cobie.cobielite.core.AttributeDecimalValueType getAttributeDecimalValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeDecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeDecimalValueType)get_store().find_element_user(ATTRIBUTEDECIMALVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AttributeDecimalValue" element
     */
    public void setAttributeDecimalValue(org.erdc.cobie.cobielite.core.AttributeDecimalValueType attributeDecimalValue)
    {
        generatedSetterHelperImpl(attributeDecimalValue, ATTRIBUTEDECIMALVALUE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AttributeDecimalValue" element
     */
    public org.erdc.cobie.cobielite.core.AttributeDecimalValueType addNewAttributeDecimalValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeDecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeDecimalValueType)get_store().add_element_user(ATTRIBUTEDECIMALVALUE$0);
            return target;
        }
    }
}
