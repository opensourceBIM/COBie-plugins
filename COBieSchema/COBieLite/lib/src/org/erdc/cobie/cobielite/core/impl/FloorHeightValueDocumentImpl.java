/*
 * An XML document type.
 * Localname: FloorHeightValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.FloorHeightValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one FloorHeightValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FloorHeightValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.FloorHeightValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public FloorHeightValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FLOORHEIGHTVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FloorHeightValue");
    
    
    /**
     * Gets the "FloorHeightValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getFloorHeightValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(FLOORHEIGHTVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "FloorHeightValue" element
     */
    public void setFloorHeightValue(org.erdc.cobie.cobielite.core.DecimalValueType floorHeightValue)
    {
        generatedSetterHelperImpl(floorHeightValue, FLOORHEIGHTVALUE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "FloorHeightValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType addNewFloorHeightValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(FLOORHEIGHTVALUE$0);
            return target;
        }
    }
}
