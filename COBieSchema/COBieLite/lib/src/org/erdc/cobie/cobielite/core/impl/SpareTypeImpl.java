/*
 * XML Type:  SpareType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpareType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML SpareType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class SpareTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieRowTypeImpl implements org.erdc.cobie.cobielite.core.SpareType
{
    private static final long serialVersionUID = 1L;
    
    public SpareTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPARENAME$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpareName");
    private static final javax.xml.namespace.QName SPARECATEGORY$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpareCategory");
    
    
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
    
    /**
     * Gets the "SpareCategory" element
     */
    public java.lang.String getSpareCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPARECATEGORY$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SpareCategory" element
     */
    public org.erdc.cobie.cobielite.core.SpareCategorySimpleType xgetSpareCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpareCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.SpareCategorySimpleType)get_store().find_element_user(SPARECATEGORY$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SpareCategory" element
     */
    public void setSpareCategory(java.lang.String spareCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPARECATEGORY$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SPARECATEGORY$2);
            }
            target.setStringValue(spareCategory);
        }
    }
    
    /**
     * Sets (as xml) the "SpareCategory" element
     */
    public void xsetSpareCategory(org.erdc.cobie.cobielite.core.SpareCategorySimpleType spareCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpareCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.SpareCategorySimpleType)get_store().find_element_user(SPARECATEGORY$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.SpareCategorySimpleType)get_store().add_element_user(SPARECATEGORY$2);
            }
            target.set(spareCategory);
        }
    }
}
