/*
 * An XML document type.
 * Localname: AttributeIntegerValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeIntegerValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AttributeIntegerValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AttributeIntegerValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AttributeIntegerValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public AttributeIntegerValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTEINTEGERVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeIntegerValue");
    
    
    /**
     * Gets the "AttributeIntegerValue" element
     */
    public org.erdc.cobie.cobielite.core.AttributeIntegerValueType getAttributeIntegerValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeIntegerValueType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeIntegerValueType)get_store().find_element_user(ATTRIBUTEINTEGERVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AttributeIntegerValue" element
     */
    public void setAttributeIntegerValue(org.erdc.cobie.cobielite.core.AttributeIntegerValueType attributeIntegerValue)
    {
        generatedSetterHelperImpl(attributeIntegerValue, ATTRIBUTEINTEGERVALUE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AttributeIntegerValue" element
     */
    public org.erdc.cobie.cobielite.core.AttributeIntegerValueType addNewAttributeIntegerValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeIntegerValueType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeIntegerValueType)get_store().add_element_user(ATTRIBUTEINTEGERVALUE$0);
            return target;
        }
    }
}
