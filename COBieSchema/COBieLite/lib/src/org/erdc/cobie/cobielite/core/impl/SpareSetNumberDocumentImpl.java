/*
 * An XML document type.
 * Localname: SpareSetNumber
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpareSetNumberDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SpareSetNumber(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SpareSetNumberDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SpareSetNumberDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpareSetNumberDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPARESETNUMBER$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpareSetNumber");
    
    
    /**
     * Gets the "SpareSetNumber" element
     */
    public java.lang.String getSpareSetNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPARESETNUMBER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SpareSetNumber" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetSpareSetNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(SPARESETNUMBER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SpareSetNumber" element
     */
    public void setSpareSetNumber(java.lang.String spareSetNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPARESETNUMBER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SPARESETNUMBER$0);
            }
            target.setStringValue(spareSetNumber);
        }
    }
    
    /**
     * Sets (as xml) the "SpareSetNumber" element
     */
    public void xsetSpareSetNumber(org.erdc.cobie.cobielite.core.CobieTextSimpleType spareSetNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(SPARESETNUMBER$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(SPARESETNUMBER$0);
            }
            target.set(spareSetNumber);
        }
    }
}
