/*
 * XML Type:  PolygonType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.PolygonType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML PolygonType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class PolygonTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieComplexObjectTypeImpl implements org.erdc.cobie.cobielite.core.PolygonType
{
    private static final long serialVersionUID = 1L;
    
    public PolygonTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName POLYGONPOINT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "PolygonPoint");
    
    
    /**
     * Gets array of all "PolygonPoint" elements
     */
    public org.erdc.cobie.cobielite.core.PointType[] getPolygonPointArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(POLYGONPOINT$0, targetList);
            org.erdc.cobie.cobielite.core.PointType[] result = new org.erdc.cobie.cobielite.core.PointType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "PolygonPoint" element
     */
    public org.erdc.cobie.cobielite.core.PointType getPolygonPointArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.PointType target = null;
            target = (org.erdc.cobie.cobielite.core.PointType)get_store().find_element_user(POLYGONPOINT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "PolygonPoint" element
     */
    public int sizeOfPolygonPointArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(POLYGONPOINT$0);
        }
    }
    
    /**
     * Sets array of all "PolygonPoint" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setPolygonPointArray(org.erdc.cobie.cobielite.core.PointType[] polygonPointArray)
    {
        check_orphaned();
        arraySetterHelper(polygonPointArray, POLYGONPOINT$0);
    }
    
    /**
     * Sets ith "PolygonPoint" element
     */
    public void setPolygonPointArray(int i, org.erdc.cobie.cobielite.core.PointType polygonPoint)
    {
        generatedSetterHelperImpl(polygonPoint, POLYGONPOINT$0, i, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_ARRAYITEM);
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "PolygonPoint" element
     */
    public org.erdc.cobie.cobielite.core.PointType insertNewPolygonPoint(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.PointType target = null;
            target = (org.erdc.cobie.cobielite.core.PointType)get_store().insert_element_user(POLYGONPOINT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "PolygonPoint" element
     */
    public org.erdc.cobie.cobielite.core.PointType addNewPolygonPoint()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.PointType target = null;
            target = (org.erdc.cobie.cobielite.core.PointType)get_store().add_element_user(POLYGONPOINT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "PolygonPoint" element
     */
    public void removePolygonPoint(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(POLYGONPOINT$0, i);
        }
    }
}
