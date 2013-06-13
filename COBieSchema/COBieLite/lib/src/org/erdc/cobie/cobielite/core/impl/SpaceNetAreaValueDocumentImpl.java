/*
 * An XML document type.
 * Localname: SpaceNetAreaValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpaceNetAreaValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SpaceNetAreaValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SpaceNetAreaValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SpaceNetAreaValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpaceNetAreaValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPACENETAREAVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceNetAreaValue");
    
    
    /**
     * Gets the "SpaceNetAreaValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getSpaceNetAreaValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(SPACENETAREAVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "SpaceNetAreaValue" element
     */
    public void setSpaceNetAreaValue(org.erdc.cobie.cobielite.core.DecimalValueType spaceNetAreaValue)
    {
        generatedSetterHelperImpl(spaceNetAreaValue, SPACENETAREAVALUE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpaceNetAreaValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType addNewSpaceNetAreaValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(SPACENETAREAVALUE$0);
            return target;
        }
    }
}
