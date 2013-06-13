/*
 * An XML document type.
 * Localname: AttributeValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AttributeValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AttributeValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AttributeValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public AttributeValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTEVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeValue");
    
    
    /**
     * Gets the "AttributeValue" element
     */
    public org.erdc.cobie.cobielite.core.AttributeValueType getAttributeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeValueType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeValueType)get_store().find_element_user(ATTRIBUTEVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AttributeValue" element
     */
    public void setAttributeValue(org.erdc.cobie.cobielite.core.AttributeValueType attributeValue)
    {
        generatedSetterHelperImpl(attributeValue, ATTRIBUTEVALUE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AttributeValue" element
     */
    public org.erdc.cobie.cobielite.core.AttributeValueType addNewAttributeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeValueType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeValueType)get_store().add_element_user(ATTRIBUTEVALUE$0);
            return target;
        }
    }
}
