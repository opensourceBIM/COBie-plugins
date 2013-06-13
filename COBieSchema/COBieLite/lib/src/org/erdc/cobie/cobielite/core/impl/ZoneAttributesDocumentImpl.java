/*
 * An XML document type.
 * Localname: ZoneAttributes
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ZoneAttributesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one ZoneAttributes(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class ZoneAttributesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.ZoneAttributesDocument
{
    private static final long serialVersionUID = 1L;
    
    public ZoneAttributesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ZONEATTRIBUTES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "ZoneAttributes");
    
    
    /**
     * Gets the "ZoneAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getZoneAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(ZONEATTRIBUTES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ZoneAttributes" element
     */
    public void setZoneAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType zoneAttributes)
    {
        generatedSetterHelperImpl(zoneAttributes, ZONEATTRIBUTES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ZoneAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewZoneAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(ZONEATTRIBUTES$0);
            return target;
        }
    }
}
