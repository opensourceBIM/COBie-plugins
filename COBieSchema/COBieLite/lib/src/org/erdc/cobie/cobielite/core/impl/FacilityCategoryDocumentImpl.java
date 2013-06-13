/*
 * An XML document type.
 * Localname: FacilityCategory
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.FacilityCategoryDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one FacilityCategory(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class FacilityCategoryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.FacilityCategoryDocument
{
    private static final long serialVersionUID = 1L;
    
    public FacilityCategoryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FACILITYCATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FacilityCategory");
    
    
    /**
     * Gets the "FacilityCategory" element
     */
    public java.lang.String getFacilityCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYCATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FacilityCategory" element
     */
    public org.erdc.cobie.cobielite.core.FacilityCategorySimpleType xgetFacilityCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FacilityCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.FacilityCategorySimpleType)get_store().find_element_user(FACILITYCATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "FacilityCategory" element
     */
    public void setFacilityCategory(java.lang.String facilityCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITYCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FACILITYCATEGORY$0);
            }
            target.setStringValue(facilityCategory);
        }
    }
    
    /**
     * Sets (as xml) the "FacilityCategory" element
     */
    public void xsetFacilityCategory(org.erdc.cobie.cobielite.core.FacilityCategorySimpleType facilityCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FacilityCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.FacilityCategorySimpleType)get_store().find_element_user(FACILITYCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.FacilityCategorySimpleType)get_store().add_element_user(FACILITYCATEGORY$0);
            }
            target.set(facilityCategory);
        }
    }
}
