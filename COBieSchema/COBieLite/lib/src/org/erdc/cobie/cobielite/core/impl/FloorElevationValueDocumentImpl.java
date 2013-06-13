/*
 * An XML document type.
 * Localname: FloorElevationValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.FloorElevationValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one FloorElevationValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FloorElevationValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.FloorElevationValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public FloorElevationValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FLOORELEVATIONVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FloorElevationValue");
    
    
    /**
     * Gets the "FloorElevationValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getFloorElevationValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(FLOORELEVATIONVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "FloorElevationValue" element
     */
    public void setFloorElevationValue(org.erdc.cobie.cobielite.core.DecimalValueType floorElevationValue)
    {
        generatedSetterHelperImpl(floorElevationValue, FLOORELEVATIONVALUE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "FloorElevationValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType addNewFloorElevationValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(FLOORELEVATIONVALUE$0);
            return target;
        }
    }
}
