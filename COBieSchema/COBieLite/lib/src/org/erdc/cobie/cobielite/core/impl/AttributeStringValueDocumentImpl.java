/*
 * An XML document type.
 * Localname: AttributeStringValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeStringValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AttributeStringValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AttributeStringValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AttributeStringValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public AttributeStringValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTESTRINGVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeStringValue");
    
    
    /**
     * Gets the "AttributeStringValue" element
     */
    public org.erdc.cobie.cobielite.core.AttributeStringValueType getAttributeStringValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeStringValueType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeStringValueType)get_store().find_element_user(ATTRIBUTESTRINGVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AttributeStringValue" element
     */
    public void setAttributeStringValue(org.erdc.cobie.cobielite.core.AttributeStringValueType attributeStringValue)
    {
        generatedSetterHelperImpl(attributeStringValue, ATTRIBUTESTRINGVALUE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AttributeStringValue" element
     */
    public org.erdc.cobie.cobielite.core.AttributeStringValueType addNewAttributeStringValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeStringValueType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeStringValueType)get_store().add_element_user(ATTRIBUTESTRINGVALUE$0);
            return target;
        }
    }
}
