/*
 * XML Type:  WarrantyCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.WarrantyCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML WarrantyCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class WarrantyCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieComplexObjectTypeImpl implements org.erdc.cobie.cobielite.core.WarrantyCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public WarrantyCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WARRANTY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Warranty");
    
    
    /**
     * Gets array of all "Warranty" elements
     */
    public org.erdc.cobie.cobielite.core.WarrantyType[] getWarrantyArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(WARRANTY$0, targetList);
            org.erdc.cobie.cobielite.core.WarrantyType[] result = new org.erdc.cobie.cobielite.core.WarrantyType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Warranty" element
     */
    public org.erdc.cobie.cobielite.core.WarrantyType getWarrantyArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.WarrantyType target = null;
            target = (org.erdc.cobie.cobielite.core.WarrantyType)get_store().find_element_user(WARRANTY$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Warranty" element
     */
    public int sizeOfWarrantyArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WARRANTY$0);
        }
    }
    
    /**
     * Sets array of all "Warranty" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setWarrantyArray(org.erdc.cobie.cobielite.core.WarrantyType[] warrantyArray)
    {
        check_orphaned();
        arraySetterHelper(warrantyArray, WARRANTY$0);
    }
    
    /**
     * Sets ith "Warranty" element
     */
    public void setWarrantyArray(int i, org.erdc.cobie.cobielite.core.WarrantyType warranty)
    {
        generatedSetterHelperImpl(warranty, WARRANTY$0, i, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_ARRAYITEM);
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Warranty" element
     */
    public org.erdc.cobie.cobielite.core.WarrantyType insertNewWarranty(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.WarrantyType target = null;
            target = (org.erdc.cobie.cobielite.core.WarrantyType)get_store().insert_element_user(WARRANTY$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Warranty" element
     */
    public org.erdc.cobie.cobielite.core.WarrantyType addNewWarranty()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.WarrantyType target = null;
            target = (org.erdc.cobie.cobielite.core.WarrantyType)get_store().add_element_user(WARRANTY$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Warranty" element
     */
    public void removeWarranty(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WARRANTY$0, i);
        }
    }
}
