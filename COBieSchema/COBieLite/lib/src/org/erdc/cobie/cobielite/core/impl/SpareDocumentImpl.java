/*
 * An XML document type.
 * Localname: Spare
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpareDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Spare(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SpareDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SpareDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpareDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPARE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Spare");
    private static final org.apache.xmlbeans.QNameSet SPARE$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Spare"),
        new javax.xml.namespace.QName("http://spare.cobielite.cobie.erdc.org", "Spare"),
    });
    
    
    /**
     * Gets the "Spare" element
     */
    public org.erdc.cobie.cobielite.core.SpareType getSpare()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpareType target = null;
            target = (org.erdc.cobie.cobielite.core.SpareType)get_store().find_element_user(SPARE$1, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Spare" element
     */
    public void setSpare(org.erdc.cobie.cobielite.core.SpareType spare)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpareType target = null;
            target = (org.erdc.cobie.cobielite.core.SpareType)get_store().find_element_user(SPARE$1, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.SpareType)get_store().add_element_user(SPARE$0);
            }
            target.set(spare);
        }
    }
    
    /**
     * Appends and returns a new empty "Spare" element
     */
    public org.erdc.cobie.cobielite.core.SpareType addNewSpare()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpareType target = null;
            target = (org.erdc.cobie.cobielite.core.SpareType)get_store().add_element_user(SPARE$0);
            return target;
        }
    }
}
