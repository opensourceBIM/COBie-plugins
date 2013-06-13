/*
 * XML Type:  SpareKeyType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpareKeyType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML SpareKeyType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class SpareKeyTypeImpl extends org.erdc.cobie.cobielite.core.impl.AssetTypeKeyTypeImpl implements org.erdc.cobie.cobielite.core.SpareKeyType
{
    private static final long serialVersionUID = 1L;
    
    public SpareKeyTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPARENAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpareName");
    
    
    /**
     * Gets the "SpareName" element
     */
    public java.lang.String getSpareName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPARENAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SpareName" element
     */
    public org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetSpareName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(SPARENAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SpareName" element
     */
    public void setSpareName(java.lang.String spareName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPARENAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SPARENAME$0);
            }
            target.setStringValue(spareName);
        }
    }
    
    /**
     * Sets (as xml) the "SpareName" element
     */
    public void xsetSpareName(org.erdc.cobie.cobielite.core.CobieNameSimpleType spareName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieNameSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().find_element_user(SPARENAME$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieNameSimpleType)get_store().add_element_user(SPARENAME$0);
            }
            target.set(spareName);
        }
    }
}
