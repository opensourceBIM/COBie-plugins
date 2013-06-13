/*
 * An XML document type.
 * Localname: SparePartNumber
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SparePartNumberDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SparePartNumber(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SparePartNumberDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SparePartNumberDocument
{
    private static final long serialVersionUID = 1L;
    
    public SparePartNumberDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPAREPARTNUMBER$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SparePartNumber");
    
    
    /**
     * Gets the "SparePartNumber" element
     */
    public java.lang.String getSparePartNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPAREPARTNUMBER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SparePartNumber" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetSparePartNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(SPAREPARTNUMBER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SparePartNumber" element
     */
    public void setSparePartNumber(java.lang.String sparePartNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPAREPARTNUMBER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SPAREPARTNUMBER$0);
            }
            target.setStringValue(sparePartNumber);
        }
    }
    
    /**
     * Sets (as xml) the "SparePartNumber" element
     */
    public void xsetSparePartNumber(org.erdc.cobie.cobielite.core.CobieTextSimpleType sparePartNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(SPAREPARTNUMBER$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(SPAREPARTNUMBER$0);
            }
            target.set(sparePartNumber);
        }
    }
}
