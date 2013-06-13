/*
 * An XML document type.
 * Localname: Space
 * Namespace: http://space.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.space.SpaceDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.space.impl;
/**
 * A document containing one Space(@http://space.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SpaceDocumentImpl extends org.erdc.cobie.cobielite.core.impl.SpaceDocumentImpl implements org.erdc.cobie.cobielite.space.SpaceDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpaceDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPACE2$0 = 
        new javax.xml.namespace.QName("http://space.cobielite.cobie.erdc.org", "Space");
    
    
    /**
     * Gets the "Space" element
     */
    public org.erdc.cobie.cobielite.space.SpaceType getSpace2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.space.SpaceType target = null;
            target = (org.erdc.cobie.cobielite.space.SpaceType)get_store().find_element_user(SPACE2$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Space" element
     */
    public void setSpace2(org.erdc.cobie.cobielite.space.SpaceType space2)
    {
        generatedSetterHelperImpl(space2, SPACE2$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Space" element
     */
    public org.erdc.cobie.cobielite.space.SpaceType addNewSpace2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.space.SpaceType target = null;
            target = (org.erdc.cobie.cobielite.space.SpaceType)get_store().add_element_user(SPACE2$0);
            return target;
        }
    }
}
