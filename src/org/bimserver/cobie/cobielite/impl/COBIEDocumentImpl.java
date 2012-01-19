/*
 * An XML document type.
 * Localname: COBIE
 * Namespace: cobielite.cobie.bimserver.org
 * Java type: org.bimserver.cobie.cobielite.COBIEDocument
 *
 * Automatically generated - do not modify.
 */
package org.bimserver.cobie.cobielite.impl;
/**
 * A document containing one COBIE(@cobielite.cobie.bimserver.org) element.
 *
 * This is a complex type.
 */
public class COBIEDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.bimserver.cobie.cobielite.COBIEDocument
{
    private static final long serialVersionUID = 1L;
    
    public COBIEDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COBIE$0 = 
        new javax.xml.namespace.QName("cobielite.cobie.bimserver.org", "COBIE");
    
    
    /**
     * Gets the "COBIE" element
     */
    public org.bimserver.cobie.cobielite.COBIEType getCOBIE()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bimserver.cobie.cobielite.COBIEType target = null;
            target = (org.bimserver.cobie.cobielite.COBIEType)get_store().find_element_user(COBIE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "COBIE" element
     */
    public void setCOBIE(org.bimserver.cobie.cobielite.COBIEType cobie)
    {
        generatedSetterHelperImpl(cobie, COBIE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "COBIE" element
     */
    public org.bimserver.cobie.cobielite.COBIEType addNewCOBIE()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bimserver.cobie.cobielite.COBIEType target = null;
            target = (org.bimserver.cobie.cobielite.COBIEType)get_store().add_element_user(COBIE$0);
            return target;
        }
    }
}
