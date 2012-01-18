/*
 * XML Type:  IssueType
 * Namespace: cobieLite
 * Java type: cobieLite.IssueType
 *
 * Automatically generated - do not modify.
 */
package cobieLite.impl;
/**
 * An XML IssueType(@cobieLite).
 *
 * This is a complex type.
 */
public class IssueTypeImpl extends cobieLite.impl.COBIEBaseTypeImpl implements cobieLite.IssueType
{
    private static final long serialVersionUID = 1L;
    
    public IssueTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CREATEDBY$0 = 
        new javax.xml.namespace.QName("", "CreatedBy");
    private static final javax.xml.namespace.QName CREATEDON$2 = 
        new javax.xml.namespace.QName("", "CreatedOn");
    private static final javax.xml.namespace.QName TYPE$4 = 
        new javax.xml.namespace.QName("", "Type");
    private static final javax.xml.namespace.QName RISK$6 = 
        new javax.xml.namespace.QName("", "Risk");
    private static final javax.xml.namespace.QName CHANCE$8 = 
        new javax.xml.namespace.QName("", "Chance");
    private static final javax.xml.namespace.QName IMPACT$10 = 
        new javax.xml.namespace.QName("", "Impact");
    private static final javax.xml.namespace.QName SHEETNAME1$12 = 
        new javax.xml.namespace.QName("", "SheetName1");
    private static final javax.xml.namespace.QName ROWNAME1$14 = 
        new javax.xml.namespace.QName("", "RowName1");
    private static final javax.xml.namespace.QName SHEETNAME2$16 = 
        new javax.xml.namespace.QName("", "SheetName2");
    private static final javax.xml.namespace.QName ROWNAME2$18 = 
        new javax.xml.namespace.QName("", "RowName2");
    private static final javax.xml.namespace.QName DESCRIPTION$20 = 
        new javax.xml.namespace.QName("", "Description");
    private static final javax.xml.namespace.QName OWNER$22 = 
        new javax.xml.namespace.QName("", "Owner");
    private static final javax.xml.namespace.QName MITIGATION$24 = 
        new javax.xml.namespace.QName("", "Mitigation");
    private static final javax.xml.namespace.QName EXTSYSTEM$26 = 
        new javax.xml.namespace.QName("", "ExtSystem");
    private static final javax.xml.namespace.QName EXTOBJECT$28 = 
        new javax.xml.namespace.QName("", "ExtObject");
    private static final javax.xml.namespace.QName EXTIDENTIFIER$30 = 
        new javax.xml.namespace.QName("", "ExtIdentifier");
    
    
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
     * Gets the "Type" element
     */
    public java.lang.String getType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$4, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TYPE$4, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TYPE$4);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TYPE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TYPE$4);
            }
            target.set(type);
        }
    }
    
    /**
     * Gets the "Risk" element
     */
    public java.lang.String getRisk()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RISK$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Risk" element
     */
    public org.apache.xmlbeans.XmlString xgetRisk()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RISK$6, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Risk" element
     */
    public void setRisk(java.lang.String risk)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RISK$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RISK$6);
            }
            target.setStringValue(risk);
        }
    }
    
    /**
     * Sets (as xml) the "Risk" element
     */
    public void xsetRisk(org.apache.xmlbeans.XmlString risk)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RISK$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(RISK$6);
            }
            target.set(risk);
        }
    }
    
    /**
     * Gets the "Chance" element
     */
    public java.lang.String getChance()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CHANCE$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Chance" element
     */
    public org.apache.xmlbeans.XmlString xgetChance()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CHANCE$8, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Chance" element
     */
    public void setChance(java.lang.String chance)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CHANCE$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CHANCE$8);
            }
            target.setStringValue(chance);
        }
    }
    
    /**
     * Sets (as xml) the "Chance" element
     */
    public void xsetChance(org.apache.xmlbeans.XmlString chance)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CHANCE$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CHANCE$8);
            }
            target.set(chance);
        }
    }
    
    /**
     * Gets the "Impact" element
     */
    public java.lang.String getImpact()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IMPACT$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Impact" element
     */
    public org.apache.xmlbeans.XmlString xgetImpact()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(IMPACT$10, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Impact" element
     */
    public void setImpact(java.lang.String impact)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IMPACT$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(IMPACT$10);
            }
            target.setStringValue(impact);
        }
    }
    
    /**
     * Sets (as xml) the "Impact" element
     */
    public void xsetImpact(org.apache.xmlbeans.XmlString impact)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(IMPACT$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(IMPACT$10);
            }
            target.set(impact);
        }
    }
    
    /**
     * Gets the "SheetName1" element
     */
    public java.lang.String getSheetName1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SHEETNAME1$12, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SheetName1" element
     */
    public org.apache.xmlbeans.XmlString xgetSheetName1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SHEETNAME1$12, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SheetName1" element
     */
    public void setSheetName1(java.lang.String sheetName1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SHEETNAME1$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SHEETNAME1$12);
            }
            target.setStringValue(sheetName1);
        }
    }
    
    /**
     * Sets (as xml) the "SheetName1" element
     */
    public void xsetSheetName1(org.apache.xmlbeans.XmlString sheetName1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SHEETNAME1$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SHEETNAME1$12);
            }
            target.set(sheetName1);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ROWNAME1$14, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ROWNAME1$14, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ROWNAME1$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ROWNAME1$14);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ROWNAME1$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ROWNAME1$14);
            }
            target.set(rowName1);
        }
    }
    
    /**
     * Gets the "SheetName2" element
     */
    public java.lang.String getSheetName2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SHEETNAME2$16, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SheetName2" element
     */
    public org.apache.xmlbeans.XmlString xgetSheetName2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SHEETNAME2$16, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SheetName2" element
     */
    public void setSheetName2(java.lang.String sheetName2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SHEETNAME2$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SHEETNAME2$16);
            }
            target.setStringValue(sheetName2);
        }
    }
    
    /**
     * Sets (as xml) the "SheetName2" element
     */
    public void xsetSheetName2(org.apache.xmlbeans.XmlString sheetName2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SHEETNAME2$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SHEETNAME2$16);
            }
            target.set(sheetName2);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ROWNAME2$18, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ROWNAME2$18, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ROWNAME2$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ROWNAME2$18);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ROWNAME2$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ROWNAME2$18);
            }
            target.set(rowName2);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$20, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$20, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DESCRIPTION$20);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DESCRIPTION$20);
            }
            target.set(description);
        }
    }
    
    /**
     * Gets the "Owner" element
     */
    public java.lang.String getOwner()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OWNER$22, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Owner" element
     */
    public org.apache.xmlbeans.XmlString xgetOwner()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(OWNER$22, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Owner" element
     */
    public void setOwner(java.lang.String owner)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OWNER$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(OWNER$22);
            }
            target.setStringValue(owner);
        }
    }
    
    /**
     * Sets (as xml) the "Owner" element
     */
    public void xsetOwner(org.apache.xmlbeans.XmlString owner)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(OWNER$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(OWNER$22);
            }
            target.set(owner);
        }
    }
    
    /**
     * Gets the "Mitigation" element
     */
    public java.lang.String getMitigation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MITIGATION$24, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Mitigation" element
     */
    public org.apache.xmlbeans.XmlString xgetMitigation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MITIGATION$24, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Mitigation" element
     */
    public void setMitigation(java.lang.String mitigation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MITIGATION$24, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MITIGATION$24);
            }
            target.setStringValue(mitigation);
        }
    }
    
    /**
     * Sets (as xml) the "Mitigation" element
     */
    public void xsetMitigation(org.apache.xmlbeans.XmlString mitigation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MITIGATION$24, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(MITIGATION$24);
            }
            target.set(mitigation);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTSYSTEM$26, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTSYSTEM$26, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTSYSTEM$26, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTSYSTEM$26);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTSYSTEM$26, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTSYSTEM$26);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTOBJECT$28, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTOBJECT$28, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTOBJECT$28, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTOBJECT$28);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTOBJECT$28, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTOBJECT$28);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTIDENTIFIER$30, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTIDENTIFIER$30, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTIDENTIFIER$30, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTIDENTIFIER$30);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTIDENTIFIER$30, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTIDENTIFIER$30);
            }
            target.set(extIdentifier);
        }
    }
}
