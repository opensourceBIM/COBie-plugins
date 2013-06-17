/*
 * An XML document type.
 * Localname: Spaces
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SpacesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Spaces(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SpacesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SpacesDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpacesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPACES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Spaces");
    
    
    /**
     * Gets the "Spaces" element
     */
    public org.erdc.cobie.cobielite.core.SpaceCollectionType getSpaces()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceCollectionType)get_store().find_element_user(SPACES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Spaces" element
     */
    public void setSpaces(org.erdc.cobie.cobielite.core.SpaceCollectionType spaces)
    {
        generatedSetterHelperImpl(spaces, SPACES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Spaces" element
     */
    public org.erdc.cobie.cobielite.core.SpaceCollectionType addNewSpaces()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceCollectionType)get_store().add_element_user(SPACES$0);
            return target;
        }
    }
}
