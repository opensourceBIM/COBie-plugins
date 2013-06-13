/*
 * An XML document type.
 * Localname: Polygon
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.PolygonDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Polygon(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class PolygonDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.PolygonDocument
{
    private static final long serialVersionUID = 1L;
    
    public PolygonDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName POLYGON$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Polygon");
    
    
    /**
     * Gets the "Polygon" element
     */
    public org.erdc.cobie.cobielite.core.PolygonType getPolygon()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.PolygonType target = null;
            target = (org.erdc.cobie.cobielite.core.PolygonType)get_store().find_element_user(POLYGON$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Polygon" element
     */
    public void setPolygon(org.erdc.cobie.cobielite.core.PolygonType polygon)
    {
        generatedSetterHelperImpl(polygon, POLYGON$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Polygon" element
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
}
