/*
 * XML Type:  CategoryPickLists
 * Namespace: cobielite.cobie.bimserver.org
 * Java type: org.bimserver.cobie.cobielite.CategoryPickLists
 *
 * Automatically generated - do not modify.
 */
package org.bimserver.cobie.cobielite.impl;
/**
 * An XML CategoryPickLists(@cobielite.cobie.bimserver.org).
 *
 * This is a complex type.
 */
public class CategoryPickListsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.bimserver.cobie.cobielite.CategoryPickLists
{
    private static final long serialVersionUID = 1L;
    
    public CategoryPickListsImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FACILITY$0 = 
        new javax.xml.namespace.QName("", "Facility");
    private static final javax.xml.namespace.QName FLOOR$2 = 
        new javax.xml.namespace.QName("", "Floor");
    private static final javax.xml.namespace.QName SPACE$4 = 
        new javax.xml.namespace.QName("", "Space");
    private static final javax.xml.namespace.QName ZONE$6 = 
        new javax.xml.namespace.QName("", "Zone");
    private static final javax.xml.namespace.QName TYPE$8 = 
        new javax.xml.namespace.QName("", "Type");
    private static final javax.xml.namespace.QName SYSTEM$10 = 
        new javax.xml.namespace.QName("", "System");
    
    
    /**
     * Gets the "Facility" element
     */
    public java.lang.String getFacility()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Facility" element
     */
    public org.apache.xmlbeans.XmlString xgetFacility()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FACILITY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Facility" element
     */
    public void setFacility(java.lang.String facility)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACILITY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FACILITY$0);
            }
            target.setStringValue(facility);
        }
    }
    
    /**
     * Sets (as xml) the "Facility" element
     */
    public void xsetFacility(org.apache.xmlbeans.XmlString facility)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FACILITY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FACILITY$0);
            }
            target.set(facility);
        }
    }
    
    /**
     * Gets the "Floor" element
     */
    public java.lang.String getFloor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FLOOR$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Floor" element
     */
    public org.apache.xmlbeans.XmlString xgetFloor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FLOOR$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Floor" element
     */
    public void setFloor(java.lang.String floor)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FLOOR$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FLOOR$2);
            }
            target.setStringValue(floor);
        }
    }
    
    /**
     * Sets (as xml) the "Floor" element
     */
    public void xsetFloor(org.apache.xmlbeans.XmlString floor)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FLOOR$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FLOOR$2);
            }
            target.set(floor);
        }
    }
    
    /**
     * Gets the "Space" element
     */
    public java.lang.String getSpace()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPACE$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Space" element
     */
    public org.apache.xmlbeans.XmlString xgetSpace()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SPACE$4, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Space" element
     */
    public void setSpace(java.lang.String space)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPACE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SPACE$4);
            }
            target.setStringValue(space);
        }
    }
    
    /**
     * Sets (as xml) the "Space" element
     */
    public void xsetSpace(org.apache.xmlbeans.XmlString space)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SPACE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SPACE$4);
            }
            target.set(space);
        }
    }
    
    /**
     * Gets the "Zone" element
     */
    public java.lang.String getZone()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ZONE$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Zone" element
     */
    public org.apache.xmlbeans.XmlString xgetZone()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ZONE$6, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Zone" element
     */
    public void setZone(java.lang.String zone)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ZONE$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ZONE$6);
            }
            target.setStringValue(zone);
        }
    }
    
    /**
     * Sets (as xml) the "Zone" element
     */
    public void xsetZone(org.apache.xmlbeans.XmlString zone)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ZONE$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ZONE$6);
            }
            target.set(zone);
        }
    }
    
    /**
     * Gets the "Type" element
     */
    public java.lang.String getType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Type" element
     */
    public org.apache.xmlbeans.XmlString xgetType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TYPE$8, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Type" element
     */
    public void setType(java.lang.String type)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TYPE$8);
            }
            target.setStringValue(type);
        }
    }
    
    /**
     * Sets (as xml) the "Type" element
     */
    public void xsetType(org.apache.xmlbeans.XmlString type)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TYPE$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TYPE$8);
            }
            target.set(type);
        }
    }
    
    /**
     * Gets the "System" element
     */
    public java.lang.String getSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SYSTEM$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "System" element
     */
    public org.apache.xmlbeans.XmlString xgetSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SYSTEM$10, 0);
            return target;
        }
    }
    
    /**
     * Sets the "System" element
     */
    public void setSystem(java.lang.String system)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SYSTEM$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SYSTEM$10);
            }
            target.setStringValue(system);
        }
    }
    
    /**
     * Sets (as xml) the "System" element
     */
    public void xsetSystem(org.apache.xmlbeans.XmlString system)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SYSTEM$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SYSTEM$10);
            }
            target.set(system);
        }
    }
}
