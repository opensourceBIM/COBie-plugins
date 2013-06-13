/*
 * An XML document type.
 * Localname: WarrantyAttributes
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.WarrantyAttributesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one WarrantyAttributes(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class WarrantyAttributesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.WarrantyAttributesDocument
{
    private static final long serialVersionUID = 1L;
    
    public WarrantyAttributesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WARRANTYATTRIBUTES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "WarrantyAttributes");
    
    
    /**
     * Gets the "WarrantyAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getWarrantyAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(WARRANTYATTRIBUTES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "WarrantyAttributes" element
     */
    public void setWarrantyAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType warrantyAttributes)
    {
        generatedSetterHelperImpl(warrantyAttributes, WARRANTYATTRIBUTES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "WarrantyAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewWarrantyAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(WARRANTYATTRIBUTES$0);
            return target;
        }
    }
}
