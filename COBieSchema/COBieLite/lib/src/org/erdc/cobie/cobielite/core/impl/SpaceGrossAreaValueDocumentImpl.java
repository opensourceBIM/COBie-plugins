/*
 * An XML document type.
 * Localname: SpaceGrossAreaValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpaceGrossAreaValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SpaceGrossAreaValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SpaceGrossAreaValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SpaceGrossAreaValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpaceGrossAreaValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPACEGROSSAREAVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceGrossAreaValue");
    
    
    /**
     * Gets the "SpaceGrossAreaValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getSpaceGrossAreaValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(SPACEGROSSAREAVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "SpaceGrossAreaValue" element
     */
    public void setSpaceGrossAreaValue(org.erdc.cobie.cobielite.core.DecimalValueType spaceGrossAreaValue)
    {
        generatedSetterHelperImpl(spaceGrossAreaValue, SPACEGROSSAREAVALUE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpaceGrossAreaValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType addNewSpaceGrossAreaValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(SPACEGROSSAREAVALUE$0);
            return target;
        }
    }
}
