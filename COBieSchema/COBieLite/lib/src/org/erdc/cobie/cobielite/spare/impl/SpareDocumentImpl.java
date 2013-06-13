/*
 * An XML document type.
 * Localname: Spare
 * Namespace: http://spare.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.spare.SpareDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.spare.impl;
/**
 * A document containing one Spare(@http://spare.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SpareDocumentImpl extends org.erdc.cobie.cobielite.core.impl.SpareDocumentImpl implements org.erdc.cobie.cobielite.spare.SpareDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpareDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPARE2$0 = 
        new javax.xml.namespace.QName("http://spare.cobielite.cobie.erdc.org", "Spare");
    
    
    /**
     * Gets the "Spare" element
     */
    public org.erdc.cobie.cobielite.spare.SpareType getSpare2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.spare.SpareType target = null;
            target = (org.erdc.cobie.cobielite.spare.SpareType)get_store().find_element_user(SPARE2$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Spare" element
     */
    public void setSpare2(org.erdc.cobie.cobielite.spare.SpareType spare2)
    {
        generatedSetterHelperImpl(spare2, SPARE2$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Spare" element
     */
    public org.erdc.cobie.cobielite.spare.SpareType addNewSpare2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.spare.SpareType target = null;
            target = (org.erdc.cobie.cobielite.spare.SpareType)get_store().add_element_user(SPARE2$0);
            return target;
        }
    }
}
