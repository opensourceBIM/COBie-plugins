/*
 * An XML document type.
 * Localname: SpareAttributes
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpareAttributesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SpareAttributes(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SpareAttributesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SpareAttributesDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpareAttributesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPAREATTRIBUTES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpareAttributes");
    
    
    /**
     * Gets the "SpareAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getSpareAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(SPAREATTRIBUTES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "SpareAttributes" element
     */
    public void setSpareAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType spareAttributes)
    {
        generatedSetterHelperImpl(spareAttributes, SPAREATTRIBUTES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpareAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewSpareAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(SPAREATTRIBUTES$0);
            return target;
        }
    }
}
