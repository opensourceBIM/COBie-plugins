/*
 * XML Type:  DocumentType
 * Namespace: cobieLite
 * Java type: cobieLite.DocumentType
 *
 * Automatically generated - do not modify.
 */
package cobieLite.impl;
/**
 * An XML DocumentType(@cobieLite).
 *
 * This is a complex type.
 */
public class DocumentTypeImpl extends cobieLite.impl.COBIEBaseTypeImpl implements cobieLite.DocumentType
{
    private static final long serialVersionUID = 1L;
    
    public DocumentTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CREATEDBY$0 = 
        new javax.xml.namespace.QName("", "CreatedBy");
    private static final javax.xml.namespace.QName CREATEDON$2 = 
        new javax.xml.namespace.QName("", "CreatedOn");
    private static final javax.xml.namespace.QName CATEGORY$4 = 
        new javax.xml.namespace.QName("", "Category");
    private static final javax.xml.namespace.QName APPROVALBY$6 = 
        new javax.xml.namespace.QName("", "ApprovalBy");
    private static final javax.xml.namespace.QName STAGE$8 = 
        new javax.xml.namespace.QName("", "Stage");
    private static final javax.xml.namespace.QName SHEETNAME$10 = 
        new javax.xml.namespace.QName("", "SheetName");
    private static final javax.xml.namespace.QName ROWNAME$12 = 
        new javax.xml.namespace.QName("", "RowName");
    private static final javax.xml.namespace.QName DIRECTORY$14 = 
        new javax.xml.namespace.QName("", "Directory");
    private static final javax.xml.namespace.QName FILE$16 = 
        new javax.xml.namespace.QName("", "File");
    private static final javax.xml.namespace.QName EXTSYSTEM$18 = 
        new javax.xml.namespace.QName("", "ExtSystem");
    private static final javax.xml.namespace.QName EXTOBJECT$20 = 
        new javax.xml.namespace.QName("", "ExtObject");
    private static final javax.xml.namespace.QName EXTIDENTIFIER$22 = 
        new javax.xml.namespace.QName("", "ExtIdentifier");
    private static final javax.xml.namespace.QName DESCRIPTION$24 = 
        new javax.xml.namespace.QName("", "Description");
    private static final javax.xml.namespace.QName REFERENCE$26 = 
        new javax.xml.namespace.QName("", "Reference");
    
    
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
     * Gets the "ApprovalBy" element
     */
    public java.lang.String getApprovalBy()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(APPROVALBY$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ApprovalBy" element
     */
    public org.apache.xmlbeans.XmlString xgetApprovalBy()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(APPROVALBY$6, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ApprovalBy" element
     */
    public void setApprovalBy(java.lang.String approvalBy)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(APPROVALBY$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(APPROVALBY$6);
            }
            target.setStringValue(approvalBy);
        }
    }
    
    /**
     * Sets (as xml) the "ApprovalBy" element
     */
    public void xsetApprovalBy(org.apache.xmlbeans.XmlString approvalBy)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(APPROVALBY$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(APPROVALBY$6);
            }
            target.set(approvalBy);
        }
    }
    
    /**
     * Gets the "Stage" element
     */
    public java.lang.String getStage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STAGE$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Stage" element
     */
    public org.apache.xmlbeans.XmlString xgetStage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STAGE$8, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Stage" element
     */
    public void setStage(java.lang.String stage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STAGE$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(STAGE$8);
            }
            target.setStringValue(stage);
        }
    }
    
    /**
     * Sets (as xml) the "Stage" element
     */
    public void xsetStage(org.apache.xmlbeans.XmlString stage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STAGE$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(STAGE$8);
            }
            target.set(stage);
        }
    }
    
    /**
     * Gets the "SheetName" element
     */
    public java.lang.String getSheetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SHEETNAME$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SheetName" element
     */
    public org.apache.xmlbeans.XmlString xgetSheetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SHEETNAME$10, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SheetName" element
     */
    public void setSheetName(java.lang.String sheetName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SHEETNAME$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SHEETNAME$10);
            }
            target.setStringValue(sheetName);
        }
    }
    
    /**
     * Sets (as xml) the "SheetName" element
     */
    public void xsetSheetName(org.apache.xmlbeans.XmlString sheetName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SHEETNAME$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SHEETNAME$10);
            }
            target.set(sheetName);
        }
    }
    
    /**
     * Gets the "RowName" element
     */
    public java.lang.String getRowName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ROWNAME$12, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "RowName" element
     */
    public org.apache.xmlbeans.XmlString xgetRowName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ROWNAME$12, 0);
            return target;
        }
    }
    
    /**
     * Sets the "RowName" element
     */
    public void setRowName(java.lang.String rowName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ROWNAME$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ROWNAME$12);
            }
            target.setStringValue(rowName);
        }
    }
    
    /**
     * Sets (as xml) the "RowName" element
     */
    public void xsetRowName(org.apache.xmlbeans.XmlString rowName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ROWNAME$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ROWNAME$12);
            }
            target.set(rowName);
        }
    }
    
    /**
     * Gets the "Directory" element
     */
    public java.lang.String getDirectory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DIRECTORY$14, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Directory" element
     */
    public org.apache.xmlbeans.XmlString xgetDirectory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DIRECTORY$14, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Directory" element
     */
    public void setDirectory(java.lang.String directory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DIRECTORY$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DIRECTORY$14);
            }
            target.setStringValue(directory);
        }
    }
    
    /**
     * Sets (as xml) the "Directory" element
     */
    public void xsetDirectory(org.apache.xmlbeans.XmlString directory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DIRECTORY$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DIRECTORY$14);
            }
            target.set(directory);
        }
    }
    
    /**
     * Gets the "File" element
     */
    public java.lang.String getFile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FILE$16, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "File" element
     */
    public org.apache.xmlbeans.XmlString xgetFile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FILE$16, 0);
            return target;
        }
    }
    
    /**
     * Sets the "File" element
     */
    public void setFile(java.lang.String file)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FILE$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FILE$16);
            }
            target.setStringValue(file);
        }
    }
    
    /**
     * Sets (as xml) the "File" element
     */
    public void xsetFile(org.apache.xmlbeans.XmlString file)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FILE$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FILE$16);
            }
            target.set(file);
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
    
    /**
     * Gets the "Reference" element
     */
    public java.lang.String getReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCE$26, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Reference" element
     */
    public org.apache.xmlbeans.XmlString xgetReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REFERENCE$26, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Reference" element
     */
    public void setReference(java.lang.String reference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFERENCE$26, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REFERENCE$26);
            }
            target.setStringValue(reference);
        }
    }
    
    /**
     * Sets (as xml) the "Reference" element
     */
    public void xsetReference(org.apache.xmlbeans.XmlString reference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REFERENCE$26, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(REFERENCE$26);
            }
            target.set(reference);
        }
    }
}
