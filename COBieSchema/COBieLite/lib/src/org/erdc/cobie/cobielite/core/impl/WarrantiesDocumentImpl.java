/*
 * An XML document type.
 * Localname: Warranties
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.WarrantiesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Warranties(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class WarrantiesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.WarrantiesDocument
{
    private static final long serialVersionUID = 1L;
    
    public WarrantiesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WARRANTIES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Warranties");
    
    
    /**
     * Gets the "Warranties" element
     */
    public org.erdc.cobie.cobielite.core.WarrantyCollectionType getWarranties()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.WarrantyCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.WarrantyCollectionType)get_store().find_element_user(WARRANTIES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Warranties" element
     */
    public void setWarranties(org.erdc.cobie.cobielite.core.WarrantyCollectionType warranties)
    {
        generatedSetterHelperImpl(warranties, WARRANTIES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Warranties" element
     */
    public org.erdc.cobie.cobielite.core.WarrantyCollectionType addNewWarranties()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.WarrantyCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.WarrantyCollectionType)get_store().add_element_user(WARRANTIES$0);
            return target;
        }
    }
}
