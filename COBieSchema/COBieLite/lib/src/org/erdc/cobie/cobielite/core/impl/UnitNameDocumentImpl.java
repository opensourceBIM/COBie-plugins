/*
 * An XML document type.
 * Localname: UnitName
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.UnitNameDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one UnitName(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class UnitNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.UnitNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public UnitNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UNITNAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "UnitName");
    
    
    /**
     * Gets the "UnitName" element
     */
    public java.lang.String getUnitName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNITNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "UnitName" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetUnitName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(UNITNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "UnitName" element
     */
    public void setUnitName(java.lang.String unitName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNITNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UNITNAME$0);
            }
            target.setStringValue(unitName);
        }
    }
    
    /**
     * Sets (as xml) the "UnitName" element
     */
    public void xsetUnitName(org.erdc.cobie.cobielite.core.CobieTextSimpleType unitName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(UNITNAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(UNITNAME$0);
            }
            target.set(unitName);
        }
    }
}
