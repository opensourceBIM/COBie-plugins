/*
 * An XML document type.
 * Localname: Space2DShape
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.Space2DShapeDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Space2DShape(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class Space2DShapeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.Space2DShapeDocument
{
    private static final long serialVersionUID = 1L;
    
    public Space2DShapeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPACE2DSHAPE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Space2DShape");
    
    
    /**
     * Gets the "Space2DShape" element
     */
    public org.erdc.cobie.cobielite.core.PolygonCollectionType getSpace2DShape()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.PolygonCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.PolygonCollectionType)get_store().find_element_user(SPACE2DSHAPE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Space2DShape" element
     */
    public void setSpace2DShape(org.erdc.cobie.cobielite.core.PolygonCollectionType space2DShape)
    {
        generatedSetterHelperImpl(space2DShape, SPACE2DSHAPE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Space2DShape" element
     */
    public org.erdc.cobie.cobielite.core.PolygonCollectionType addNewSpace2DShape()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.PolygonCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.PolygonCollectionType)get_store().add_element_user(SPACE2DSHAPE$0);
            return target;
        }
    }
}
