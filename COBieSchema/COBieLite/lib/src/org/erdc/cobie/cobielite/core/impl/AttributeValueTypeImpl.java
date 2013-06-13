/*
 * XML Type:  AttributeValueType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeValueType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML AttributeValueType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class AttributeValueTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieComplexObjectTypeImpl implements org.erdc.cobie.cobielite.core.AttributeValueType
{
    private static final long serialVersionUID = 1L;
    
    public AttributeValueTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTEBOOLEANVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeBooleanValue");
    private static final javax.xml.namespace.QName ATTRIBUTEDATEVALUE$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeDateValue");
    private static final javax.xml.namespace.QName ATTRIBUTEDATETIMEVALUE$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeDateTimeValue");
    private static final javax.xml.namespace.QName ATTRIBUTEDECIMALVALUE$6 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeDecimalValue");
    private static final javax.xml.namespace.QName ATTRIBUTEINTEGERVALUE$8 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeIntegerValue");
    private static final javax.xml.namespace.QName ATTRIBUTEMONETARYVALUE$10 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeMonetaryValue");
    private static final javax.xml.namespace.QName ATTRIBUTESTRINGVALUE$12 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeStringValue");
    private static final javax.xml.namespace.QName ATTRIBUTETIMEVALUE$14 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeTimeValue");
    
    
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
     * True if has "AttributeBooleanValue" element
     */
    public boolean isSetAttributeBooleanValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ATTRIBUTEBOOLEANVALUE$0) != 0;
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
    
    /**
     * Unsets the "AttributeBooleanValue" element
     */
    public void unsetAttributeBooleanValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ATTRIBUTEBOOLEANVALUE$0, 0);
        }
    }
    
    /**
     * Gets the "AttributeDateValue" element
     */
    public java.util.Calendar getAttributeDateValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTEDATEVALUE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "AttributeDateValue" element
     */
    public org.apache.xmlbeans.XmlDate xgetAttributeDateValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(ATTRIBUTEDATEVALUE$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "AttributeDateValue" element
     */
    public boolean isSetAttributeDateValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ATTRIBUTEDATEVALUE$2) != 0;
        }
    }
    
    /**
     * Sets the "AttributeDateValue" element
     */
    public void setAttributeDateValue(java.util.Calendar attributeDateValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTEDATEVALUE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ATTRIBUTEDATEVALUE$2);
            }
            target.setCalendarValue(attributeDateValue);
        }
    }
    
    /**
     * Sets (as xml) the "AttributeDateValue" element
     */
    public void xsetAttributeDateValue(org.apache.xmlbeans.XmlDate attributeDateValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(ATTRIBUTEDATEVALUE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDate)get_store().add_element_user(ATTRIBUTEDATEVALUE$2);
            }
            target.set(attributeDateValue);
        }
    }
    
    /**
     * Unsets the "AttributeDateValue" element
     */
    public void unsetAttributeDateValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ATTRIBUTEDATEVALUE$2, 0);
        }
    }
    
    /**
     * Gets the "AttributeDateTimeValue" element
     */
    public java.util.Calendar getAttributeDateTimeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTEDATETIMEVALUE$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "AttributeDateTimeValue" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetAttributeDateTimeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(ATTRIBUTEDATETIMEVALUE$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "AttributeDateTimeValue" element
     */
    public boolean isSetAttributeDateTimeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ATTRIBUTEDATETIMEVALUE$4) != 0;
        }
    }
    
    /**
     * Sets the "AttributeDateTimeValue" element
     */
    public void setAttributeDateTimeValue(java.util.Calendar attributeDateTimeValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTEDATETIMEVALUE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ATTRIBUTEDATETIMEVALUE$4);
            }
            target.setCalendarValue(attributeDateTimeValue);
        }
    }
    
    /**
     * Sets (as xml) the "AttributeDateTimeValue" element
     */
    public void xsetAttributeDateTimeValue(org.apache.xmlbeans.XmlDateTime attributeDateTimeValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(ATTRIBUTEDATETIMEVALUE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(ATTRIBUTEDATETIMEVALUE$4);
            }
            target.set(attributeDateTimeValue);
        }
    }
    
    /**
     * Unsets the "AttributeDateTimeValue" element
     */
    public void unsetAttributeDateTimeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ATTRIBUTEDATETIMEVALUE$4, 0);
        }
    }
    
    /**
     * Gets the "AttributeDecimalValue" element
     */
    public org.erdc.cobie.cobielite.core.AttributeDecimalValueType getAttributeDecimalValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeDecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeDecimalValueType)get_store().find_element_user(ATTRIBUTEDECIMALVALUE$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AttributeDecimalValue" element
     */
    public boolean isSetAttributeDecimalValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ATTRIBUTEDECIMALVALUE$6) != 0;
        }
    }
    
    /**
     * Sets the "AttributeDecimalValue" element
     */
    public void setAttributeDecimalValue(org.erdc.cobie.cobielite.core.AttributeDecimalValueType attributeDecimalValue)
    {
        generatedSetterHelperImpl(attributeDecimalValue, ATTRIBUTEDECIMALVALUE$6, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
            target = (org.erdc.cobie.cobielite.core.AttributeDecimalValueType)get_store().add_element_user(ATTRIBUTEDECIMALVALUE$6);
            return target;
        }
    }
    
    /**
     * Unsets the "AttributeDecimalValue" element
     */
    public void unsetAttributeDecimalValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ATTRIBUTEDECIMALVALUE$6, 0);
        }
    }
    
    /**
     * Gets the "AttributeIntegerValue" element
     */
    public org.erdc.cobie.cobielite.core.AttributeIntegerValueType getAttributeIntegerValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeIntegerValueType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeIntegerValueType)get_store().find_element_user(ATTRIBUTEINTEGERVALUE$8, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AttributeIntegerValue" element
     */
    public boolean isSetAttributeIntegerValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ATTRIBUTEINTEGERVALUE$8) != 0;
        }
    }
    
    /**
     * Sets the "AttributeIntegerValue" element
     */
    public void setAttributeIntegerValue(org.erdc.cobie.cobielite.core.AttributeIntegerValueType attributeIntegerValue)
    {
        generatedSetterHelperImpl(attributeIntegerValue, ATTRIBUTEINTEGERVALUE$8, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
            target = (org.erdc.cobie.cobielite.core.AttributeIntegerValueType)get_store().add_element_user(ATTRIBUTEINTEGERVALUE$8);
            return target;
        }
    }
    
    /**
     * Unsets the "AttributeIntegerValue" element
     */
    public void unsetAttributeIntegerValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ATTRIBUTEINTEGERVALUE$8, 0);
        }
    }
    
    /**
     * Gets the "AttributeMonetaryValue" element
     */
    public org.erdc.cobie.cobielite.core.AttributeMonetaryValueType getAttributeMonetaryValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeMonetaryValueType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeMonetaryValueType)get_store().find_element_user(ATTRIBUTEMONETARYVALUE$10, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AttributeMonetaryValue" element
     */
    public boolean isSetAttributeMonetaryValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ATTRIBUTEMONETARYVALUE$10) != 0;
        }
    }
    
    /**
     * Sets the "AttributeMonetaryValue" element
     */
    public void setAttributeMonetaryValue(org.erdc.cobie.cobielite.core.AttributeMonetaryValueType attributeMonetaryValue)
    {
        generatedSetterHelperImpl(attributeMonetaryValue, ATTRIBUTEMONETARYVALUE$10, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
            target = (org.erdc.cobie.cobielite.core.AttributeMonetaryValueType)get_store().add_element_user(ATTRIBUTEMONETARYVALUE$10);
            return target;
        }
    }
    
    /**
     * Unsets the "AttributeMonetaryValue" element
     */
    public void unsetAttributeMonetaryValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ATTRIBUTEMONETARYVALUE$10, 0);
        }
    }
    
    /**
     * Gets the "AttributeStringValue" element
     */
    public org.erdc.cobie.cobielite.core.AttributeStringValueType getAttributeStringValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeStringValueType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeStringValueType)get_store().find_element_user(ATTRIBUTESTRINGVALUE$12, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AttributeStringValue" element
     */
    public boolean isSetAttributeStringValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ATTRIBUTESTRINGVALUE$12) != 0;
        }
    }
    
    /**
     * Sets the "AttributeStringValue" element
     */
    public void setAttributeStringValue(org.erdc.cobie.cobielite.core.AttributeStringValueType attributeStringValue)
    {
        generatedSetterHelperImpl(attributeStringValue, ATTRIBUTESTRINGVALUE$12, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
            target = (org.erdc.cobie.cobielite.core.AttributeStringValueType)get_store().add_element_user(ATTRIBUTESTRINGVALUE$12);
            return target;
        }
    }
    
    /**
     * Unsets the "AttributeStringValue" element
     */
    public void unsetAttributeStringValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ATTRIBUTESTRINGVALUE$12, 0);
        }
    }
    
    /**
     * Gets the "AttributeTimeValue" element
     */
    public java.util.Calendar getAttributeTimeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTETIMEVALUE$14, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "AttributeTimeValue" element
     */
    public org.apache.xmlbeans.XmlTime xgetAttributeTimeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlTime target = null;
            target = (org.apache.xmlbeans.XmlTime)get_store().find_element_user(ATTRIBUTETIMEVALUE$14, 0);
            return target;
        }
    }
    
    /**
     * True if has "AttributeTimeValue" element
     */
    public boolean isSetAttributeTimeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ATTRIBUTETIMEVALUE$14) != 0;
        }
    }
    
    /**
     * Sets the "AttributeTimeValue" element
     */
    public void setAttributeTimeValue(java.util.Calendar attributeTimeValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTETIMEVALUE$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ATTRIBUTETIMEVALUE$14);
            }
            target.setCalendarValue(attributeTimeValue);
        }
    }
    
    /**
     * Sets (as xml) the "AttributeTimeValue" element
     */
    public void xsetAttributeTimeValue(org.apache.xmlbeans.XmlTime attributeTimeValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlTime target = null;
            target = (org.apache.xmlbeans.XmlTime)get_store().find_element_user(ATTRIBUTETIMEVALUE$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlTime)get_store().add_element_user(ATTRIBUTETIMEVALUE$14);
            }
            target.set(attributeTimeValue);
        }
    }
    
    /**
     * Unsets the "AttributeTimeValue" element
     */
    public void unsetAttributeTimeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ATTRIBUTETIMEVALUE$14, 0);
        }
    }
}
