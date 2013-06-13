/*
 * An XML document type.
 * Localname: Warranty
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.WarrantyDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Warranty(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class WarrantyDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.WarrantyDocument
{
    private static final long serialVersionUID = 1L;
    
    public WarrantyDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WARRANTY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Warranty");
    
    
    /**
     * Gets the "Warranty" element
     */
    public org.erdc.cobie.cobielite.core.WarrantyType getWarranty()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.WarrantyType target = null;
            target = (org.erdc.cobie.cobielite.core.WarrantyType)get_store().find_element_user(WARRANTY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Warranty" element
     */
    public void setWarranty(org.erdc.cobie.cobielite.core.WarrantyType warranty)
    {
        generatedSetterHelperImpl(warranty, WARRANTY$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Warranty" element
     */
    public org.erdc.cobie.cobielite.core.WarrantyType addNewWarranty()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.WarrantyType target = null;
            target = (org.erdc.cobie.cobielite.core.WarrantyType)get_store().add_element_user(WARRANTY$0);
            return target;
        }
    }
}
