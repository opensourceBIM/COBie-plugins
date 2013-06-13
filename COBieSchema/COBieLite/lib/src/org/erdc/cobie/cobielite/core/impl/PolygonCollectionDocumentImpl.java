/*
 * An XML document type.
 * Localname: PolygonCollection
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.PolygonCollectionDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one PolygonCollection(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class PolygonCollectionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.PolygonCollectionDocument
{
    private static final long serialVersionUID = 1L;
    
    public PolygonCollectionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName POLYGONCOLLECTION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "PolygonCollection");
    
    
    /**
     * Gets the "PolygonCollection" element
     */
    public org.erdc.cobie.cobielite.core.PolygonCollectionType getPolygonCollection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.PolygonCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.PolygonCollectionType)get_store().find_element_user(POLYGONCOLLECTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "PolygonCollection" element
     */
    public void setPolygonCollection(org.erdc.cobie.cobielite.core.PolygonCollectionType polygonCollection)
    {
        generatedSetterHelperImpl(polygonCollection, POLYGONCOLLECTION$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "PolygonCollection" element
     */
    public org.erdc.cobie.cobielite.core.PolygonCollectionType addNewPolygonCollection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.PolygonCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.PolygonCollectionType)get_store().add_element_user(POLYGONCOLLECTION$0);
            return target;
        }
    }
}
