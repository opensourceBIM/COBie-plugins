/*
 * An XML document type.
 * Localname: Spares
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SparesDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one Spares(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SparesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SparesDocument
{
    private static final long serialVersionUID = 1L;
    
    public SparesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPARES$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Spares");
    
    
    /**
     * Gets the "Spares" element
     */
    public org.erdc.cobie.cobielite.core.SpareCollectionType getSpares()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpareCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.SpareCollectionType)get_store().find_element_user(SPARES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Spares" element
     */
    public void setSpares(org.erdc.cobie.cobielite.core.SpareCollectionType spares)
    {
        generatedSetterHelperImpl(spares, SPARES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Spares" element
     */
    public org.erdc.cobie.cobielite.core.SpareCollectionType addNewSpares()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpareCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.SpareCollectionType)get_store().add_element_user(SPARES$0);
            return target;
        }
    }
}
