/*
 * An XML document type.
 * Localname: AllowedValues
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AllowedValuesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one AllowedValues(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AllowedValuesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AllowedValuesDocument
{
    private static final long serialVersionUID = 1L;
    
    public AllowedValuesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ALLOWEDVALUES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AllowedValues");
    
    
    /**
     * Gets the "AllowedValues" element
     */
    public org.erdc.cobie.cobielite.core.AllowedValueCollectionType getAllowedValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AllowedValueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AllowedValueCollectionType)get_store().find_element_user(ALLOWEDVALUES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AllowedValues" element
     */
    public void setAllowedValues(org.erdc.cobie.cobielite.core.AllowedValueCollectionType allowedValues)
    {
        generatedSetterHelperImpl(allowedValues, ALLOWEDVALUES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AllowedValues" element
     */
    public org.erdc.cobie.cobielite.core.AllowedValueCollectionType addNewAllowedValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AllowedValueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AllowedValueCollectionType)get_store().add_element_user(ALLOWEDVALUES$0);
            return target;
        }
    }
}
