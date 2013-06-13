/*
 * An XML document type.
 * Localname: AttributeBooleanValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeBooleanValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AttributeBooleanValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AttributeBooleanValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AttributeBooleanValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public AttributeBooleanValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTEBOOLEANVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeBooleanValue");
    
    
    /**
     * Gets the "AttributeBooleanValue" element
     */
    public org.erdc.cobie.cobielite.core.BooleanValueType getAttributeBooleanValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.BooleanValueType target = null;
            target = (org.erdc.cobie.cobielite.core.BooleanValueType)get_store().find_element_user(ATTRIBUTEBOOLEANVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AttributeBooleanValue" element
     */
    public void setAttributeBooleanValue(org.erdc.cobie.cobielite.core.BooleanValueType attributeBooleanValue)
    {
        generatedSetterHelperImpl(attributeBooleanValue, ATTRIBUTEBOOLEANVALUE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AttributeBooleanValue" element
     */
    public org.erdc.cobie.cobielite.core.BooleanValueType addNewAttributeBooleanValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.BooleanValueType target = null;
            target = (org.erdc.cobie.cobielite.core.BooleanValueType)get_store().add_element_user(ATTRIBUTEBOOLEANVALUE$0);
            return target;
        }
    }
}
