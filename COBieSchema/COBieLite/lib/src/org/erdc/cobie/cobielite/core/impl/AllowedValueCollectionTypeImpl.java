/*
 * XML Type:  AllowedValueCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AllowedValueCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML AllowedValueCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class AllowedValueCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieComplexObjectTypeImpl implements org.erdc.cobie.cobielite.core.AllowedValueCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public AllowedValueCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTEALLOWEDVALUE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AttributeAllowedValue");
    
    
    /**
     * Gets array of all "AttributeAllowedValue" elements
     */
    public java.lang.String[] getAttributeAllowedValueArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ATTRIBUTEALLOWEDVALUE$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "AttributeAllowedValue" element
     */
    public java.lang.String getAttributeAllowedValueArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTEALLOWEDVALUE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "AttributeAllowedValue" elements
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType[] xgetAttributeAllowedValueArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ATTRIBUTEALLOWEDVALUE$0, targetList);
            org.erdc.cobie.cobielite.core.CobieTextSimpleType[] result = new org.erdc.cobie.cobielite.core.CobieTextSimpleType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "AttributeAllowedValue" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAttributeAllowedValueArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ATTRIBUTEALLOWEDVALUE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "AttributeAllowedValue" element
     */
    public int sizeOfAttributeAllowedValueArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ATTRIBUTEALLOWEDVALUE$0);
        }
    }
    
    /**
     * Sets array of all "AttributeAllowedValue" element
     */
    public void setAttributeAllowedValueArray(java.lang.String[] attributeAllowedValueArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(attributeAllowedValueArray, ATTRIBUTEALLOWEDVALUE$0);
        }
    }
    
    /**
     * Sets ith "AttributeAllowedValue" element
     */
    public void setAttributeAllowedValueArray(int i, java.lang.String attributeAllowedValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ATTRIBUTEALLOWEDVALUE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(attributeAllowedValue);
        }
    }
    
    /**
     * Sets (as xml) array of all "AttributeAllowedValue" element
     */
    public void xsetAttributeAllowedValueArray(org.erdc.cobie.cobielite.core.CobieTextSimpleType[]attributeAllowedValueArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(attributeAllowedValueArray, ATTRIBUTEALLOWEDVALUE$0);
        }
    }
    
    /**
     * Sets (as xml) ith "AttributeAllowedValue" element
     */
    public void xsetAttributeAllowedValueArray(int i, org.erdc.cobie.cobielite.core.CobieTextSimpleType attributeAllowedValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ATTRIBUTEALLOWEDVALUE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(attributeAllowedValue);
        }
    }
    
    /**
     * Inserts the value as the ith "AttributeAllowedValue" element
     */
    public void insertAttributeAllowedValue(int i, java.lang.String attributeAllowedValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(ATTRIBUTEALLOWEDVALUE$0, i);
            target.setStringValue(attributeAllowedValue);
        }
    }
    
    /**
     * Appends the value as the last "AttributeAllowedValue" element
     */
    public void addAttributeAllowedValue(java.lang.String attributeAllowedValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ATTRIBUTEALLOWEDVALUE$0);
            target.setStringValue(attributeAllowedValue);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "AttributeAllowedValue" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType insertNewAttributeAllowedValue(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().insert_element_user(ATTRIBUTEALLOWEDVALUE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "AttributeAllowedValue" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType addNewAttributeAllowedValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ATTRIBUTEALLOWEDVALUE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "AttributeAllowedValue" element
     */
    public void removeAttributeAllowedValue(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ATTRIBUTEALLOWEDVALUE$0, i);
        }
    }
}
