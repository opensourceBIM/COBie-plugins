/*
 * An XML document type.
 * Localname: SystemAssignment
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.SystemAssignmentDocument
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * A document containing one SystemAssignment(@http://core.cobielite.cobie.erdc.org) element.
 *
 * This is a complex type.
 */
public class SystemAssignmentDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.erdc.cobie.cobielite.core.SystemAssignmentDocument
{
    private static final long serialVersionUID = 1L;
    
    public SystemAssignmentDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SYSTEMASSIGNMENT$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SystemAssignment");
    
    
    /**
     * Gets the "SystemAssignment" element
     */
    public org.erdc.cobie.cobielite.core.SystemKeyType getSystemAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemKeyType)get_store().find_element_user(SYSTEMASSIGNMENT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "SystemAssignment" element
     */
    public void setSystemAssignment(org.erdc.cobie.cobielite.core.SystemKeyType systemAssignment)
    {
        generatedSetterHelperImpl(systemAssignment, SYSTEMASSIGNMENT$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SystemAssignment" element
     */
    public org.erdc.cobie.cobielite.core.SystemKeyType addNewSystemAssignment()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemKeyType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemKeyType)get_store().add_element_user(SYSTEMASSIGNMENT$0);
            return target;
        }
    }
}
