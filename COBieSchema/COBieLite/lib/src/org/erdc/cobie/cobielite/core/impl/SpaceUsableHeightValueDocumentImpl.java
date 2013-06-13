/*
 * An XML document type.
 * Localname: SpaceUsableHeightValue
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpaceUsableHeightValueDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SpaceUsableHeightValue(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SpaceUsableHeightValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SpaceUsableHeightValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpaceUsableHeightValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPACEUSABLEHEIGHTVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceUsableHeightValue");
    
    
    /**
     * Gets the "SpaceUsableHeightValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getSpaceUsableHeightValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(SPACEUSABLEHEIGHTVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "SpaceUsableHeightValue" element
     */
    public void setSpaceUsableHeightValue(org.erdc.cobie.cobielite.core.DecimalValueType spaceUsableHeightValue)
    {
        generatedSetterHelperImpl(spaceUsableHeightValue, SPACEUSABLEHEIGHTVALUE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpaceUsableHeightValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType addNewSpaceUsableHeightValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(SPACEUSABLEHEIGHTVALUE$0);
            return target;
        }
    }
}
