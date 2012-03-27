/*
 * An XML attribute type.
 * Localname: COBiePickListName
 * Namespace: cobielite.cobie.bimserver.org
 * Java type: org.bimserver.cobie.cobielite.COBiePickListNameAttribute
 *
 * Automatically generated - do not modify.
 */
package org.bimserver.cobie.cobielite.impl;
/**
 * A document containing one COBiePickListName(@cobielite.cobie.bimserver.org) attribute.
 *
 * This is a complex type.
 */
public class COBiePickListNameAttributeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.bimserver.cobie.cobielite.COBiePickListNameAttribute
{
    private static final long serialVersionUID = 1L;
    
    public COBiePickListNameAttributeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COBIEPICKLISTNAME$0 = 
        new javax.xml.namespace.QName("cobielite.cobie.bimserver.org", "COBiePickListName");
    
    
    /**
     * Gets the "COBiePickListName" attribute
     */
    public java.lang.String getCOBiePickListName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(COBIEPICKLISTNAME$0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "COBiePickListName" attribute
     */
    public org.apache.xmlbeans.XmlString xgetCOBiePickListName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(COBIEPICKLISTNAME$0);
            return target;
        }
    }
    
    /**
     * True if has "COBiePickListName" attribute
     */
    public boolean isSetCOBiePickListName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(COBIEPICKLISTNAME$0) != null;
        }
    }
    
    /**
     * Sets the "COBiePickListName" attribute
     */
    public void setCOBiePickListName(java.lang.String coBiePickListName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(COBIEPICKLISTNAME$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(COBIEPICKLISTNAME$0);
            }
            target.setStringValue(coBiePickListName);
        }
    }
    
    /**
     * Sets (as xml) the "COBiePickListName" attribute
     */
    public void xsetCOBiePickListName(org.apache.xmlbeans.XmlString coBiePickListName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(COBIEPICKLISTNAME$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(COBIEPICKLISTNAME$0);
            }
            target.set(coBiePickListName);
        }
    }
    
    /**
     * Unsets the "COBiePickListName" attribute
     */
    public void unsetCOBiePickListName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(COBIEPICKLISTNAME$0);
        }
    }
}
