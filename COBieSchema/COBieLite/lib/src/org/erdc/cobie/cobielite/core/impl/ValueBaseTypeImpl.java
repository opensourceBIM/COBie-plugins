/*
 * XML Type:  ValueBaseType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ValueBaseType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML ValueBaseType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class ValueBaseTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieComplexObjectTypeImpl implements org.erdc.cobie.cobielite.core.ValueBaseType
{
    private static final long serialVersionUID = 1L;
    
    public ValueBaseTypeImpl(org.apache.xmlbeans.SchemaType sType)
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
     * True if has "UnitName" element
     */
    public boolean isSetUnitName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(UNITNAME$0) != 0;
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
    
    /**
     * Unsets the "UnitName" element
     */
    public void unsetUnitName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(UNITNAME$0, 0);
        }
    }
}
