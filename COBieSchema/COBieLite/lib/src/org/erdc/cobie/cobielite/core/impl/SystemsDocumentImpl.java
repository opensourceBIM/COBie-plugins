/*
 * An XML document type.
 * Localname: Systems
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SystemsDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Systems(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SystemsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SystemsDocument
{
    private static final long serialVersionUID = 1L;
    
    public SystemsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SYSTEMS$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Systems");
    
    
    /**
     * Gets the "Systems" element
     */
    public org.erdc.cobie.cobielite.core.SystemCollectionType getSystems()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemCollectionType)get_store().find_element_user(SYSTEMS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Systems" element
     */
    public void setSystems(org.erdc.cobie.cobielite.core.SystemCollectionType systems)
    {
        generatedSetterHelperImpl(systems, SYSTEMS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Systems" element
     */
    public org.erdc.cobie.cobielite.core.SystemCollectionType addNewSystems()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemCollectionType)get_store().add_element_user(SYSTEMS$0);
            return target;
        }
    }
}
