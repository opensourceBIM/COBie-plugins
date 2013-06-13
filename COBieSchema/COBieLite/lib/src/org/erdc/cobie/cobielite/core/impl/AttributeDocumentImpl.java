/*
 * An XML document type.
 * Localname: Attribute
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Attribute(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class AttributeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.AttributeDocument
{
    private static final long serialVersionUID = 1L;
    
    public AttributeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Attribute");
    private static final org.apache.xmlbeans.QNameSet ATTRIBUTE$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Attribute"),
        new javax.xml.namespace.QName("http://attribute.cobielite.cobie.erdc.org", "Attribute"),
    });
    
    
    /**
     * Gets the "Attribute" element
     */
    public org.erdc.cobie.cobielite.core.AttributeType getAttribute()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeType)get_store().find_element_user(ATTRIBUTE$1, 0);
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
    public void setAttribute(org.erdc.cobie.cobielite.core.AttributeType attribute)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeType)get_store().find_element_user(ATTRIBUTE$1, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.AttributeType)get_store().add_element_user(ATTRIBUTE$0);
            }
            target.set(attribute);
        }
    }
    
    /**
     * Appends and returns a new empty "Attribute" element
     */
    public org.erdc.cobie.cobielite.core.AttributeType addNewAttribute()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeType)get_store().add_element_user(ATTRIBUTE$0);
            return target;
        }
    }
}
