/*
 * XML Type:  COBiePickedField
 * Namespace: cobielite.cobie.bimserver.org
 * Java type: org.bimserver.cobie.cobielite.COBiePickedField
 *
 * Automatically generated - do not modify.
 */
package org.bimserver.cobie.cobielite.impl;
/**
 * An XML COBiePickedField(@cobielite.cobie.bimserver.org).
 *
 * This is an atomic type that is a restriction of org.bimserver.cobie.cobielite.COBiePickedField.
 */
public class COBiePickedFieldImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements org.bimserver.cobie.cobielite.COBiePickedField
{
    private static final long serialVersionUID = 1L;
    
    public COBiePickedFieldImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType, true);
    }
    
    protected COBiePickedFieldImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
    {
        super(sType, b);
    }
    
    private static final javax.xml.namespace.QName PICKLISTNAME$0 = 
        new javax.xml.namespace.QName("", "PickListName");
    
    
    /**
     * Gets the "PickListName" attribute
     */
    public java.lang.String getPickListName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PICKLISTNAME$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(PICKLISTNAME$0);
            }
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PickListName" attribute
     */
    public org.apache.xmlbeans.XmlString xgetPickListName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PICKLISTNAME$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_default_attribute_value(PICKLISTNAME$0);
            }
            return target;
        }
    }
    
    /**
     * Sets the "PickListName" attribute
     */
    public void setPickListName(java.lang.String pickListName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PICKLISTNAME$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PICKLISTNAME$0);
            }
            target.setStringValue(pickListName);
        }
    }
    
    /**
     * Sets (as xml) the "PickListName" attribute
     */
    public void xsetPickListName(org.apache.xmlbeans.XmlString pickListName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PICKLISTNAME$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PICKLISTNAME$0);
            }
            target.set(pickListName);
        }
    }
}
