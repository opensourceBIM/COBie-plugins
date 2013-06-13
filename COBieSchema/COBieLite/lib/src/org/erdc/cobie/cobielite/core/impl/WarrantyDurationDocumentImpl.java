/*
 * An XML document type.
 * Localname: WarrantyDuration
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.WarrantyDurationDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one WarrantyDuration(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class WarrantyDurationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.WarrantyDurationDocument
{
    private static final long serialVersionUID = 1L;
    
    public WarrantyDurationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WARRANTYDURATION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "WarrantyDuration");
    
    
    /**
     * Gets the "WarrantyDuration" element
     */
    public org.erdc.cobie.cobielite.core.IntegerValueType getWarrantyDuration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IntegerValueType target = null;
            target = (org.erdc.cobie.cobielite.core.IntegerValueType)get_store().find_element_user(WARRANTYDURATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "WarrantyDuration" element
     */
    public void setWarrantyDuration(org.erdc.cobie.cobielite.core.IntegerValueType warrantyDuration)
    {
        generatedSetterHelperImpl(warrantyDuration, WARRANTYDURATION$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "WarrantyDuration" element
     */
    public org.erdc.cobie.cobielite.core.IntegerValueType addNewWarrantyDuration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IntegerValueType target = null;
            target = (org.erdc.cobie.cobielite.core.IntegerValueType)get_store().add_element_user(WARRANTYDURATION$0);
            return target;
        }
    }
}
