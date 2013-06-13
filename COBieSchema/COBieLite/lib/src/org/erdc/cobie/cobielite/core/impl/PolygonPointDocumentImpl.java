/*
 * An XML document type.
 * Localname: PolygonPoint
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.PolygonPointDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one PolygonPoint(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class PolygonPointDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.PolygonPointDocument
{
    private static final long serialVersionUID = 1L;
    
    public PolygonPointDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName POLYGONPOINT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "PolygonPoint");
    
    
    /**
     * Gets the "PolygonPoint" element
     */
    public org.erdc.cobie.cobielite.core.PointType getPolygonPoint()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.PointType target = null;
            target = (org.erdc.cobie.cobielite.core.PointType)get_store().find_element_user(POLYGONPOINT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "PolygonPoint" element
     */
    public void setPolygonPoint(org.erdc.cobie.cobielite.core.PointType polygonPoint)
    {
        generatedSetterHelperImpl(polygonPoint, POLYGONPOINT$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "PolygonPoint" element
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
}
