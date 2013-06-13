/*
 * XML Type:  AttributeCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML AttributeCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class AttributeCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieWorksheetTypeImpl implements org.erdc.cobie.cobielite.core.AttributeCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public AttributeCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Attribute");
    private static final org.apache.xmlbeans.QNameSet ATTRIBUTE$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Attribute"),
        new javax.xml.namespace.QName("http://attribute.cobielite.cobie.erdc.org", "Attribute"),
    });
    
    
    /**
     * Gets array of all "Attribute" elements
     */
    public org.erdc.cobie.cobielite.core.AttributeType[] getAttributeArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ATTRIBUTE$1, targetList);
            org.erdc.cobie.cobielite.core.AttributeType[] result = new org.erdc.cobie.cobielite.core.AttributeType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Attribute" element
     */
    public org.erdc.cobie.cobielite.core.AttributeType getAttributeArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeType)get_store().find_element_user(ATTRIBUTE$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Attribute" element
     */
    public int sizeOfAttributeArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ATTRIBUTE$1);
        }
    }
    
    /**
     * Sets array of all "Attribute" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setAttributeArray(org.erdc.cobie.cobielite.core.AttributeType[] attributeArray)
    {
        check_orphaned();
        arraySetterHelper(attributeArray, ATTRIBUTE$0, ATTRIBUTE$1);
    }
    
    /**
     * Sets ith "Attribute" element
     */
    public void setAttributeArray(int i, org.erdc.cobie.cobielite.core.AttributeType attribute)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeType)get_store().find_element_user(ATTRIBUTE$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(attribute);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Attribute" element
     */
    public org.erdc.cobie.cobielite.core.AttributeType insertNewAttribute(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeType)get_store().insert_element_user(ATTRIBUTE$1, ATTRIBUTE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Attribute" element
     */
    public org.erdc.cobie.cobielite.core.AttributeType addNewAttribute()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeType)get_store().add_element_user(ATTRIBUTE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Attribute" element
     */
    public void removeAttribute(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ATTRIBUTE$1, i);
        }
    }
}
