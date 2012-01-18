/*
 * An XML document type.
 * Localname: COBIE
 * Namespace: cobieLite
 * Java type: cobieLite.COBIEDocument
 *
 * Automatically generated - do not modify.
 */
package cobieLite.impl;
/**
 * A document containing one COBIE(@cobieLite) element.
 *
 * This is a complex type.
 */
public class COBIEDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEDocument
{
    private static final long serialVersionUID = 1L;
    
    public COBIEDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COBIE$0 = 
        new javax.xml.namespace.QName("cobieLite", "COBIE");
    
    
    /**
     * Gets the "COBIE" element
     */
    public cobieLite.COBIEType getCOBIE()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType target = null;
            target = (cobieLite.COBIEType)get_store().find_element_user(COBIE$0, 0);
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
    public void setCOBIE(cobieLite.COBIEType cobie)
    {
        generatedSetterHelperImpl(cobie, COBIE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "COBIE" element
     */
    public cobieLite.COBIEType addNewCOBIE()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType target = null;
            target = (cobieLite.COBIEType)get_store().add_element_user(COBIE$0);
            return target;
        }
    }
}
