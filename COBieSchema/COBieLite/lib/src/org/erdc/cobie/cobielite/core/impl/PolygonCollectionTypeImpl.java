/*
 * XML Type:  PolygonCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.PolygonCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML PolygonCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class PolygonCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieComplexObjectTypeImpl implements org.erdc.cobie.cobielite.core.PolygonCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public PolygonCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName POLYGON$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Polygon");
    
    
    /**
     * Gets array of all "Polygon" elements
     */
    public org.erdc.cobie.cobielite.core.PolygonType[] getPolygonArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(POLYGON$0, targetList);
            org.erdc.cobie.cobielite.core.PolygonType[] result = new org.erdc.cobie.cobielite.core.PolygonType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Polygon" element
     */
    public org.erdc.cobie.cobielite.core.PolygonType getPolygonArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.PolygonType target = null;
            target = (org.erdc.cobie.cobielite.core.PolygonType)get_store().find_element_user(POLYGON$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Polygon" element
     */
    public int sizeOfPolygonArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(POLYGON$0);
        }
    }
    
    /**
     * Sets array of all "Polygon" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setPolygonArray(org.erdc.cobie.cobielite.core.PolygonType[] polygonArray)
    {
        check_orphaned();
        arraySetterHelper(polygonArray, POLYGON$0);
    }
    
    /**
     * Sets ith "Polygon" element
     */
    public void setPolygonArray(int i, org.erdc.cobie.cobielite.core.PolygonType polygon)
    {
        generatedSetterHelperImpl(polygon, POLYGON$0, i, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_ARRAYITEM);
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Polygon" element
     */
    public org.erdc.cobie.cobielite.core.PolygonType insertNewPolygon(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.PolygonType target = null;
            target = (org.erdc.cobie.cobielite.core.PolygonType)get_store().insert_element_user(POLYGON$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Polygon" element
     */
    public org.erdc.cobie.cobielite.core.PolygonType addNewPolygon()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.PolygonType target = null;
            target = (org.erdc.cobie.cobielite.core.PolygonType)get_store().add_element_user(POLYGON$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Polygon" element
     */
    public void removePolygon(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(POLYGON$0, i);
        }
    }
}
