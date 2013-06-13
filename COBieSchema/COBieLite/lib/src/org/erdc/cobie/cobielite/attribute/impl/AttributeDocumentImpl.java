/*
 * An XML document type.
 * Localname: Attribute
 * Namespace: http://attribute.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.attribute.AttributeDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.attribute.impl;
/**
 * A document containing one Attribute(@http://attribute.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AttributeDocumentImpl extends org.erdc.cobie.cobielite.core.impl.AttributeDocumentImpl implements org.erdc.cobie.cobielite.attribute.AttributeDocument
{
    private static final long serialVersionUID = 1L;
    
    public AttributeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTE2$0 = 
        new javax.xml.namespace.QName("http://attribute.cobielite.cobie.erdc.org", "Attribute");
    
    
    /**
     * Gets the "Attribute" element
     */
    public org.erdc.cobie.cobielite.attribute.AttributeType getAttribute2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.attribute.AttributeType target = null;
            target = (org.erdc.cobie.cobielite.attribute.AttributeType)get_store().find_element_user(ATTRIBUTE2$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Attribute" element
     */
    public void setAttribute2(org.erdc.cobie.cobielite.attribute.AttributeType attribute2)
    {
        generatedSetterHelperImpl(attribute2, ATTRIBUTE2$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Attribute" element
     */
    public org.erdc.cobie.cobielite.attribute.AttributeType addNewAttribute2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.attribute.AttributeType target = null;
            target = (org.erdc.cobie.cobielite.attribute.AttributeType)get_store().add_element_user(ATTRIBUTE2$0);
            return target;
        }
    }
}
