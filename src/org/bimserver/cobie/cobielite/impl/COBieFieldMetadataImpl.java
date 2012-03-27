/*
 * XML Type:  COBieFieldMetadata
 * Namespace: cobielite.cobie.bimserver.org
 * Java type: org.bimserver.cobie.cobielite.COBieFieldMetadata
 *
 * Automatically generated - do not modify.
 */
package org.bimserver.cobie.cobielite.impl;
/**
 * An XML COBieFieldMetadata(@cobielite.cobie.bimserver.org).
 *
 * This is a complex type.
 */
public class COBieFieldMetadataImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.bimserver.cobie.cobielite.COBieFieldMetadata
{
    private static final long serialVersionUID = 1L;
    
    public COBieFieldMetadataImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PICKLISTNAME$0 = 
        new javax.xml.namespace.QName("", "PickListName");
    private static final javax.xml.namespace.QName COBIEFIELDRESTRICTION$2 = 
        new javax.xml.namespace.QName("", "COBieFieldRestriction");
    
    
    /**
     * Gets the "PickListName" element
     */
    public java.lang.String getPickListName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PICKLISTNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PickListName" element
     */
    public org.apache.xmlbeans.XmlString xgetPickListName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PICKLISTNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PickListName" element
     */
    public void setPickListName(java.lang.String pickListName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PICKLISTNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PICKLISTNAME$0);
            }
            target.setStringValue(pickListName);
        }
    }
    
    /**
     * Sets (as xml) the "PickListName" element
     */
    public void xsetPickListName(org.apache.xmlbeans.XmlString pickListName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PICKLISTNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PICKLISTNAME$0);
            }
            target.set(pickListName);
        }
    }
    
    /**
     * Gets the "COBieFieldRestriction" element
     */
    public org.bimserver.cobie.cobielite.COBieRestriction.Enum getCOBieFieldRestriction()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COBIEFIELDRESTRICTION$2, 0);
            if (target == null)
            {
                return null;
            }
            return (org.bimserver.cobie.cobielite.COBieRestriction.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "COBieFieldRestriction" element
     */
    public org.bimserver.cobie.cobielite.COBieRestriction xgetCOBieFieldRestriction()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bimserver.cobie.cobielite.COBieRestriction target = null;
            target = (org.bimserver.cobie.cobielite.COBieRestriction)get_store().find_element_user(COBIEFIELDRESTRICTION$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "COBieFieldRestriction" element
     */
    public void setCOBieFieldRestriction(org.bimserver.cobie.cobielite.COBieRestriction.Enum coBieFieldRestriction)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COBIEFIELDRESTRICTION$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COBIEFIELDRESTRICTION$2);
            }
            target.setEnumValue(coBieFieldRestriction);
        }
    }
    
    /**
     * Sets (as xml) the "COBieFieldRestriction" element
     */
    public void xsetCOBieFieldRestriction(org.bimserver.cobie.cobielite.COBieRestriction coBieFieldRestriction)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bimserver.cobie.cobielite.COBieRestriction target = null;
            target = (org.bimserver.cobie.cobielite.COBieRestriction)get_store().find_element_user(COBIEFIELDRESTRICTION$2, 0);
            if (target == null)
            {
                target = (org.bimserver.cobie.cobielite.COBieRestriction)get_store().add_element_user(COBIEFIELDRESTRICTION$2);
            }
            target.set(coBieFieldRestriction);
        }
    }
}
