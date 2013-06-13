/*
 * An XML document type.
 * Localname: AttributeMonetaryValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeMonetaryValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AttributeMonetaryValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AttributeMonetaryValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AttributeMonetaryValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public AttributeMonetaryValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTEMONETARYVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeMonetaryValue");
    
    
    /**
     * Gets the "AttributeMonetaryValue" element
     */
    public org.erdc.cobie.cobielite.core.AttributeMonetaryValueType getAttributeMonetaryValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeMonetaryValueType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeMonetaryValueType)get_store().find_element_user(ATTRIBUTEMONETARYVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AttributeMonetaryValue" element
     */
    public void setAttributeMonetaryValue(org.erdc.cobie.cobielite.core.AttributeMonetaryValueType attributeMonetaryValue)
    {
        generatedSetterHelperImpl(attributeMonetaryValue, ATTRIBUTEMONETARYVALUE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AttributeMonetaryValue" element
     */
    public org.erdc.cobie.cobielite.core.AttributeMonetaryValueType addNewAttributeMonetaryValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeMonetaryValueType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeMonetaryValueType)get_store().add_element_user(ATTRIBUTEMONETARYVALUE$0);
            return target;
        }
    }
}
