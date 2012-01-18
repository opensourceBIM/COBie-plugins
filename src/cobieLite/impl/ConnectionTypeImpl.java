/*
 * XML Type:  ConnectionType
 * Namespace: cobieLite
 * Java type: cobieLite.ConnectionType
 *
 * Automatically generated - do not modify.
 */
package cobieLite.impl;
/**
 * An XML ConnectionType(@cobieLite).
 *
 * This is a complex type.
 */
public class ConnectionTypeImpl extends cobieLite.impl.COBIEBaseTypeImpl implements cobieLite.ConnectionType
{
    private static final long serialVersionUID = 1L;
    
    public ConnectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CREATEDBY$0 = 
        new javax.xml.namespace.QName("", "CreatedBy");
    private static final javax.xml.namespace.QName CREATEDON$2 = 
        new javax.xml.namespace.QName("", "CreatedOn");
    private static final javax.xml.namespace.QName CATEGORY$4 = 
        new javax.xml.namespace.QName("", "Category");
    private static final javax.xml.namespace.QName CONNECTIONTYPE$6 = 
        new javax.xml.namespace.QName("", "ConnectionType");
    private static final javax.xml.namespace.QName SHEETNAMES$8 = 
        new javax.xml.namespace.QName("", "SheetNames");
    private static final javax.xml.namespace.QName ROWNAME1$10 = 
        new javax.xml.namespace.QName("", "RowName1");
    private static final javax.xml.namespace.QName PORTNAME1$12 = 
        new javax.xml.namespace.QName("", "PortName1");
    private static final javax.xml.namespace.QName ROWNAME2$14 = 
        new javax.xml.namespace.QName("", "RowName2");
    private static final javax.xml.namespace.QName PORTNAME2$16 = 
        new javax.xml.namespace.QName("", "PortName2");
    private static final javax.xml.namespace.QName EXTSYSTEM$18 = 
        new javax.xml.namespace.QName("", "ExtSystem");
    private static final javax.xml.namespace.QName EXTOBJECT$20 = 
        new javax.xml.namespace.QName("", "ExtObject");
    private static final javax.xml.namespace.QName EXTIDENTIFIER$22 = 
        new javax.xml.namespace.QName("", "ExtIdentifier");
    private static final javax.xml.namespace.QName DESCRIPTION$24 = 
        new javax.xml.namespace.QName("", "Description");
    
    
    /**
     * Gets the "CreatedBy" element
     */
    public java.lang.String getCreatedBy()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREATEDBY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "CreatedBy" element
     */
    public cobieLite.EmailAddressType xgetCreatedBy()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.EmailAddressType target = null;
            target = (cobieLite.EmailAddressType)get_store().find_element_user(CREATEDBY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CreatedBy" element
     */
    public void setCreatedBy(java.lang.String createdBy)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREATEDBY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CREATEDBY$0);
            }
            target.setStringValue(createdBy);
        }
    }
    
    /**
     * Sets (as xml) the "CreatedBy" element
     */
    public void xsetCreatedBy(cobieLite.EmailAddressType createdBy)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.EmailAddressType target = null;
            target = (cobieLite.EmailAddressType)get_store().find_element_user(CREATEDBY$0, 0);
            if (target == null)
            {
                target = (cobieLite.EmailAddressType)get_store().add_element_user(CREATEDBY$0);
            }
            target.set(createdBy);
        }
    }
    
    /**
     * Gets the "CreatedOn" element
     */
    public java.util.Calendar getCreatedOn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREATEDON$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "CreatedOn" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetCreatedOn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(CREATEDON$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CreatedOn" element
     */
    public void setCreatedOn(java.util.Calendar createdOn)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREATEDON$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CREATEDON$2);
            }
            target.setCalendarValue(createdOn);
        }
    }
    
    /**
     * Sets (as xml) the "CreatedOn" element
     */
    public void xsetCreatedOn(org.apache.xmlbeans.XmlDateTime createdOn)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(CREATEDON$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(CREATEDON$2);
            }
            target.set(createdOn);
        }
    }
    
    /**
     * Gets the "Category" element
     */
    public java.lang.String getCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Category" element
     */
    public org.apache.xmlbeans.XmlString xgetCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY$4, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Category" element
     */
    public void setCategory(java.lang.String category)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CATEGORY$4);
            }
            target.setStringValue(category);
        }
    }
    
    /**
     * Sets (as xml) the "Category" element
     */
    public void xsetCategory(org.apache.xmlbeans.XmlString category)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CATEGORY$4);
            }
            target.set(category);
        }
    }
    
    /**
     * Gets the "ConnectionType" element
     */
    public java.lang.String getConnectionType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONTYPE$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ConnectionType" element
     */
    public org.apache.xmlbeans.XmlString xgetConnectionType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CONNECTIONTYPE$6, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ConnectionType" element
     */
    public void setConnectionType(java.lang.String connectionType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONNECTIONTYPE$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONNECTIONTYPE$6);
            }
            target.setStringValue(connectionType);
        }
    }
    
    /**
     * Sets (as xml) the "ConnectionType" element
     */
    public void xsetConnectionType(org.apache.xmlbeans.XmlString connectionType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CONNECTIONTYPE$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CONNECTIONTYPE$6);
            }
            target.set(connectionType);
        }
    }
    
    /**
     * Gets the "SheetNames" element
     */
    public java.lang.String getSheetNames()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SHEETNAMES$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SheetNames" element
     */
    public org.apache.xmlbeans.XmlString xgetSheetNames()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SHEETNAMES$8, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SheetNames" element
     */
    public void setSheetNames(java.lang.String sheetNames)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SHEETNAMES$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SHEETNAMES$8);
            }
            target.setStringValue(sheetNames);
        }
    }
    
    /**
     * Sets (as xml) the "SheetNames" element
     */
    public void xsetSheetNames(org.apache.xmlbeans.XmlString sheetNames)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SHEETNAMES$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SHEETNAMES$8);
            }
            target.set(sheetNames);
        }
    }
    
    /**
     * Gets the "RowName1" element
     */
    public java.lang.String getRowName1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ROWNAME1$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "RowName1" element
     */
    public org.apache.xmlbeans.XmlString xgetRowName1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ROWNAME1$10, 0);
            return target;
        }
    }
    
    /**
     * Sets the "RowName1" element
     */
    public void setRowName1(java.lang.String rowName1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ROWNAME1$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ROWNAME1$10);
            }
            target.setStringValue(rowName1);
        }
    }
    
    /**
     * Sets (as xml) the "RowName1" element
     */
    public void xsetRowName1(org.apache.xmlbeans.XmlString rowName1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ROWNAME1$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ROWNAME1$10);
            }
            target.set(rowName1);
        }
    }
    
    /**
     * Gets the "PortName1" element
     */
    public java.lang.String getPortName1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PORTNAME1$12, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PortName1" element
     */
    public org.apache.xmlbeans.XmlString xgetPortName1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PORTNAME1$12, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PortName1" element
     */
    public void setPortName1(java.lang.String portName1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PORTNAME1$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PORTNAME1$12);
            }
            target.setStringValue(portName1);
        }
    }
    
    /**
     * Sets (as xml) the "PortName1" element
     */
    public void xsetPortName1(org.apache.xmlbeans.XmlString portName1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PORTNAME1$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PORTNAME1$12);
            }
            target.set(portName1);
        }
    }
    
    /**
     * Gets the "RowName2" element
     */
    public java.lang.String getRowName2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ROWNAME2$14, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "RowName2" element
     */
    public org.apache.xmlbeans.XmlString xgetRowName2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ROWNAME2$14, 0);
            return target;
        }
    }
    
    /**
     * Sets the "RowName2" element
     */
    public void setRowName2(java.lang.String rowName2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ROWNAME2$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ROWNAME2$14);
            }
            target.setStringValue(rowName2);
        }
    }
    
    /**
     * Sets (as xml) the "RowName2" element
     */
    public void xsetRowName2(org.apache.xmlbeans.XmlString rowName2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ROWNAME2$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ROWNAME2$14);
            }
            target.set(rowName2);
        }
    }
    
    /**
     * Gets the "PortName2" element
     */
    public java.lang.String getPortName2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PORTNAME2$16, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PortName2" element
     */
    public org.apache.xmlbeans.XmlString xgetPortName2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PORTNAME2$16, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PortName2" element
     */
    public void setPortName2(java.lang.String portName2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PORTNAME2$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PORTNAME2$16);
            }
            target.setStringValue(portName2);
        }
    }
    
    /**
     * Sets (as xml) the "PortName2" element
     */
    public void xsetPortName2(org.apache.xmlbeans.XmlString portName2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PORTNAME2$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PORTNAME2$16);
            }
            target.set(portName2);
        }
    }
    
    /**
     * Gets the "ExtSystem" element
     */
    public java.lang.String getExtSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTSYSTEM$18, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ExtSystem" element
     */
    public org.apache.xmlbeans.XmlString xgetExtSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTSYSTEM$18, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ExtSystem" element
     */
    public void setExtSystem(java.lang.String extSystem)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTSYSTEM$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTSYSTEM$18);
            }
            target.setStringValue(extSystem);
        }
    }
    
    /**
     * Sets (as xml) the "ExtSystem" element
     */
    public void xsetExtSystem(org.apache.xmlbeans.XmlString extSystem)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTSYSTEM$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTSYSTEM$18);
            }
            target.set(extSystem);
        }
    }
    
    /**
     * Gets the "ExtObject" element
     */
    public java.lang.String getExtObject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTOBJECT$20, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ExtObject" element
     */
    public org.apache.xmlbeans.XmlString xgetExtObject()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTOBJECT$20, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ExtObject" element
     */
    public void setExtObject(java.lang.String extObject)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTOBJECT$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTOBJECT$20);
            }
            target.setStringValue(extObject);
        }
    }
    
    /**
     * Sets (as xml) the "ExtObject" element
     */
    public void xsetExtObject(org.apache.xmlbeans.XmlString extObject)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTOBJECT$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTOBJECT$20);
            }
            target.set(extObject);
        }
    }
    
    /**
     * Gets the "ExtIdentifier" element
     */
    public java.lang.String getExtIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTIDENTIFIER$22, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ExtIdentifier" element
     */
    public org.apache.xmlbeans.XmlString xgetExtIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTIDENTIFIER$22, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ExtIdentifier" element
     */
    public void setExtIdentifier(java.lang.String extIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTIDENTIFIER$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTIDENTIFIER$22);
            }
            target.setStringValue(extIdentifier);
        }
    }
    
    /**
     * Sets (as xml) the "ExtIdentifier" element
     */
    public void xsetExtIdentifier(org.apache.xmlbeans.XmlString extIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTIDENTIFIER$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTIDENTIFIER$22);
            }
            target.set(extIdentifier);
        }
    }
    
    /**
     * Gets the "Description" element
     */
    public java.lang.String getDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$24, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Description" element
     */
    public org.apache.xmlbeans.XmlString xgetDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$24, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Description" element
     */
    public void setDescription(java.lang.String description)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$24, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DESCRIPTION$24);
            }
            target.setStringValue(description);
        }
    }
    
    /**
     * Sets (as xml) the "Description" element
     */
    public void xsetDescription(org.apache.xmlbeans.XmlString description)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$24, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DESCRIPTION$24);
            }
            target.set(description);
        }
    }
}
