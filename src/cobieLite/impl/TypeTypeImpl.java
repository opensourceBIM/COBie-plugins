/*
 * XML Type:  TypeType
 * Namespace: cobieLite
 * Java type: cobieLite.TypeType
 *
 * Automatically generated - do not modify.
 */
package cobieLite.impl;
/**
 * An XML TypeType(@cobieLite).
 *
 * This is a complex type.
 */
public class TypeTypeImpl extends cobieLite.impl.COBIEBaseTypeImpl implements cobieLite.TypeType
{
    private static final long serialVersionUID = 1L;
    
    public TypeTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CREATEDBY$0 = 
        new javax.xml.namespace.QName("", "CreatedBy");
    private static final javax.xml.namespace.QName CREATEDON$2 = 
        new javax.xml.namespace.QName("", "CreatedOn");
    private static final javax.xml.namespace.QName CATEGORY$4 = 
        new javax.xml.namespace.QName("", "Category");
    private static final javax.xml.namespace.QName DESCRIPTION$6 = 
        new javax.xml.namespace.QName("", "Description");
    private static final javax.xml.namespace.QName ASSETTYPE$8 = 
        new javax.xml.namespace.QName("", "AssetType");
    private static final javax.xml.namespace.QName MANUFACTURER$10 = 
        new javax.xml.namespace.QName("", "Manufacturer");
    private static final javax.xml.namespace.QName MODELNUMBER$12 = 
        new javax.xml.namespace.QName("", "ModelNumber");
    private static final javax.xml.namespace.QName WARRANTYGUARANTORPARTS$14 = 
        new javax.xml.namespace.QName("", "WarrantyGuarantorParts");
    private static final javax.xml.namespace.QName WARRANTYDURATIONPARTS$16 = 
        new javax.xml.namespace.QName("", "WarrantyDurationParts");
    private static final javax.xml.namespace.QName WARRANTYGUARANTORLABOR$18 = 
        new javax.xml.namespace.QName("", "WarrantyGuarantorLabor");
    private static final javax.xml.namespace.QName WARRANTYDURATIONLABOR$20 = 
        new javax.xml.namespace.QName("", "WarrantyDurationLabor");
    private static final javax.xml.namespace.QName WARRANTYDURATIONUNIT$22 = 
        new javax.xml.namespace.QName("", "WarrantyDurationUnit");
    private static final javax.xml.namespace.QName REPLACEMENTCOST$24 = 
        new javax.xml.namespace.QName("", "ReplacementCost");
    private static final javax.xml.namespace.QName EXPECTEDLIFE$26 = 
        new javax.xml.namespace.QName("", "ExpectedLife");
    private static final javax.xml.namespace.QName DURATIONUNIT$28 = 
        new javax.xml.namespace.QName("", "DurationUnit");
    private static final javax.xml.namespace.QName WARRANTYDESCRIPTION$30 = 
        new javax.xml.namespace.QName("", "WarrantyDescription");
    private static final javax.xml.namespace.QName EXTSYSTEM$32 = 
        new javax.xml.namespace.QName("", "ExtSystem");
    private static final javax.xml.namespace.QName EXTOBJECT$34 = 
        new javax.xml.namespace.QName("", "ExtObject");
    private static final javax.xml.namespace.QName EXTIDENTIFIER$36 = 
        new javax.xml.namespace.QName("", "ExtIdentifier");
    private static final javax.xml.namespace.QName NOMINALLENGTH$38 = 
        new javax.xml.namespace.QName("", "NominalLength");
    private static final javax.xml.namespace.QName NOMINALWIDTH$40 = 
        new javax.xml.namespace.QName("", "NominalWidth");
    private static final javax.xml.namespace.QName NOMINALHEIGHT$42 = 
        new javax.xml.namespace.QName("", "NominalHeight");
    private static final javax.xml.namespace.QName MODELREFERENCE$44 = 
        new javax.xml.namespace.QName("", "ModelReference");
    private static final javax.xml.namespace.QName SHAPE$46 = 
        new javax.xml.namespace.QName("", "Shape");
    private static final javax.xml.namespace.QName SIZE$48 = 
        new javax.xml.namespace.QName("", "Size");
    private static final javax.xml.namespace.QName COLOR$50 = 
        new javax.xml.namespace.QName("", "Color");
    private static final javax.xml.namespace.QName FINISH$52 = 
        new javax.xml.namespace.QName("", "Finish");
    private static final javax.xml.namespace.QName GRADE$54 = 
        new javax.xml.namespace.QName("", "Grade");
    private static final javax.xml.namespace.QName MATERIAL$56 = 
        new javax.xml.namespace.QName("", "Material");
    private static final javax.xml.namespace.QName CONSTITUENTS$58 = 
        new javax.xml.namespace.QName("", "Constituents");
    private static final javax.xml.namespace.QName FEATURES$60 = 
        new javax.xml.namespace.QName("", "Features");
    private static final javax.xml.namespace.QName ACCESSIBILITYPERFORMANCE$62 = 
        new javax.xml.namespace.QName("", "AccessibilityPerformance");
    private static final javax.xml.namespace.QName CODEPERFORMANCE$64 = 
        new javax.xml.namespace.QName("", "CodePerformance");
    private static final javax.xml.namespace.QName SUSTAINABILITYPERFORMANCE$66 = 
        new javax.xml.namespace.QName("", "SustainabilityPerformance");
    
    
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
     * Gets the "Description" element
     */
    public java.lang.String getDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$6, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$6, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DESCRIPTION$6);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DESCRIPTION$6);
            }
            target.set(description);
        }
    }
    
    /**
     * Gets the "AssetType" element
     */
    public java.lang.String getAssetType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPE$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetType" element
     */
    public org.apache.xmlbeans.XmlString xgetAssetType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ASSETTYPE$8, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AssetType" element
     */
    public void setAssetType(java.lang.String assetType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPE$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPE$8);
            }
            target.setStringValue(assetType);
        }
    }
    
    /**
     * Sets (as xml) the "AssetType" element
     */
    public void xsetAssetType(org.apache.xmlbeans.XmlString assetType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ASSETTYPE$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ASSETTYPE$8);
            }
            target.set(assetType);
        }
    }
    
    /**
     * Gets the "Manufacturer" element
     */
    public java.lang.String getManufacturer()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MANUFACTURER$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Manufacturer" element
     */
    public org.apache.xmlbeans.XmlString xgetManufacturer()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MANUFACTURER$10, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Manufacturer" element
     */
    public void setManufacturer(java.lang.String manufacturer)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MANUFACTURER$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MANUFACTURER$10);
            }
            target.setStringValue(manufacturer);
        }
    }
    
    /**
     * Sets (as xml) the "Manufacturer" element
     */
    public void xsetManufacturer(org.apache.xmlbeans.XmlString manufacturer)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MANUFACTURER$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(MANUFACTURER$10);
            }
            target.set(manufacturer);
        }
    }
    
    /**
     * Gets the "ModelNumber" element
     */
    public java.lang.String getModelNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MODELNUMBER$12, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ModelNumber" element
     */
    public org.apache.xmlbeans.XmlString xgetModelNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MODELNUMBER$12, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ModelNumber" element
     */
    public void setModelNumber(java.lang.String modelNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MODELNUMBER$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MODELNUMBER$12);
            }
            target.setStringValue(modelNumber);
        }
    }
    
    /**
     * Sets (as xml) the "ModelNumber" element
     */
    public void xsetModelNumber(org.apache.xmlbeans.XmlString modelNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MODELNUMBER$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(MODELNUMBER$12);
            }
            target.set(modelNumber);
        }
    }
    
    /**
     * Gets the "WarrantyGuarantorParts" element
     */
    public java.lang.String getWarrantyGuarantorParts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYGUARANTORPARTS$14, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "WarrantyGuarantorParts" element
     */
    public org.apache.xmlbeans.XmlString xgetWarrantyGuarantorParts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WARRANTYGUARANTORPARTS$14, 0);
            return target;
        }
    }
    
    /**
     * Sets the "WarrantyGuarantorParts" element
     */
    public void setWarrantyGuarantorParts(java.lang.String warrantyGuarantorParts)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYGUARANTORPARTS$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WARRANTYGUARANTORPARTS$14);
            }
            target.setStringValue(warrantyGuarantorParts);
        }
    }
    
    /**
     * Sets (as xml) the "WarrantyGuarantorParts" element
     */
    public void xsetWarrantyGuarantorParts(org.apache.xmlbeans.XmlString warrantyGuarantorParts)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WARRANTYGUARANTORPARTS$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(WARRANTYGUARANTORPARTS$14);
            }
            target.set(warrantyGuarantorParts);
        }
    }
    
    /**
     * Gets the "WarrantyDurationParts" element
     */
    public java.lang.String getWarrantyDurationParts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYDURATIONPARTS$16, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "WarrantyDurationParts" element
     */
    public org.apache.xmlbeans.XmlString xgetWarrantyDurationParts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WARRANTYDURATIONPARTS$16, 0);
            return target;
        }
    }
    
    /**
     * Sets the "WarrantyDurationParts" element
     */
    public void setWarrantyDurationParts(java.lang.String warrantyDurationParts)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYDURATIONPARTS$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WARRANTYDURATIONPARTS$16);
            }
            target.setStringValue(warrantyDurationParts);
        }
    }
    
    /**
     * Sets (as xml) the "WarrantyDurationParts" element
     */
    public void xsetWarrantyDurationParts(org.apache.xmlbeans.XmlString warrantyDurationParts)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WARRANTYDURATIONPARTS$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(WARRANTYDURATIONPARTS$16);
            }
            target.set(warrantyDurationParts);
        }
    }
    
    /**
     * Gets the "WarrantyGuarantorLabor" element
     */
    public java.lang.String getWarrantyGuarantorLabor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYGUARANTORLABOR$18, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "WarrantyGuarantorLabor" element
     */
    public org.apache.xmlbeans.XmlString xgetWarrantyGuarantorLabor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WARRANTYGUARANTORLABOR$18, 0);
            return target;
        }
    }
    
    /**
     * Sets the "WarrantyGuarantorLabor" element
     */
    public void setWarrantyGuarantorLabor(java.lang.String warrantyGuarantorLabor)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYGUARANTORLABOR$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WARRANTYGUARANTORLABOR$18);
            }
            target.setStringValue(warrantyGuarantorLabor);
        }
    }
    
    /**
     * Sets (as xml) the "WarrantyGuarantorLabor" element
     */
    public void xsetWarrantyGuarantorLabor(org.apache.xmlbeans.XmlString warrantyGuarantorLabor)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WARRANTYGUARANTORLABOR$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(WARRANTYGUARANTORLABOR$18);
            }
            target.set(warrantyGuarantorLabor);
        }
    }
    
    /**
     * Gets the "WarrantyDurationLabor" element
     */
    public java.lang.String getWarrantyDurationLabor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYDURATIONLABOR$20, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "WarrantyDurationLabor" element
     */
    public org.apache.xmlbeans.XmlString xgetWarrantyDurationLabor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WARRANTYDURATIONLABOR$20, 0);
            return target;
        }
    }
    
    /**
     * Sets the "WarrantyDurationLabor" element
     */
    public void setWarrantyDurationLabor(java.lang.String warrantyDurationLabor)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYDURATIONLABOR$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WARRANTYDURATIONLABOR$20);
            }
            target.setStringValue(warrantyDurationLabor);
        }
    }
    
    /**
     * Sets (as xml) the "WarrantyDurationLabor" element
     */
    public void xsetWarrantyDurationLabor(org.apache.xmlbeans.XmlString warrantyDurationLabor)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WARRANTYDURATIONLABOR$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(WARRANTYDURATIONLABOR$20);
            }
            target.set(warrantyDurationLabor);
        }
    }
    
    /**
     * Gets the "WarrantyDurationUnit" element
     */
    public java.lang.String getWarrantyDurationUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYDURATIONUNIT$22, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "WarrantyDurationUnit" element
     */
    public org.apache.xmlbeans.XmlString xgetWarrantyDurationUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WARRANTYDURATIONUNIT$22, 0);
            return target;
        }
    }
    
    /**
     * Sets the "WarrantyDurationUnit" element
     */
    public void setWarrantyDurationUnit(java.lang.String warrantyDurationUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYDURATIONUNIT$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WARRANTYDURATIONUNIT$22);
            }
            target.setStringValue(warrantyDurationUnit);
        }
    }
    
    /**
     * Sets (as xml) the "WarrantyDurationUnit" element
     */
    public void xsetWarrantyDurationUnit(org.apache.xmlbeans.XmlString warrantyDurationUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WARRANTYDURATIONUNIT$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(WARRANTYDURATIONUNIT$22);
            }
            target.set(warrantyDurationUnit);
        }
    }
    
    /**
     * Gets the "ReplacementCost" element
     */
    public java.lang.String getReplacementCost()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REPLACEMENTCOST$24, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ReplacementCost" element
     */
    public org.apache.xmlbeans.XmlString xgetReplacementCost()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REPLACEMENTCOST$24, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ReplacementCost" element
     */
    public void setReplacementCost(java.lang.String replacementCost)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REPLACEMENTCOST$24, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REPLACEMENTCOST$24);
            }
            target.setStringValue(replacementCost);
        }
    }
    
    /**
     * Sets (as xml) the "ReplacementCost" element
     */
    public void xsetReplacementCost(org.apache.xmlbeans.XmlString replacementCost)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REPLACEMENTCOST$24, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(REPLACEMENTCOST$24);
            }
            target.set(replacementCost);
        }
    }
    
    /**
     * Gets the "ExpectedLife" element
     */
    public java.lang.String getExpectedLife()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXPECTEDLIFE$26, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ExpectedLife" element
     */
    public org.apache.xmlbeans.XmlString xgetExpectedLife()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXPECTEDLIFE$26, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ExpectedLife" element
     */
    public void setExpectedLife(java.lang.String expectedLife)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXPECTEDLIFE$26, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXPECTEDLIFE$26);
            }
            target.setStringValue(expectedLife);
        }
    }
    
    /**
     * Sets (as xml) the "ExpectedLife" element
     */
    public void xsetExpectedLife(org.apache.xmlbeans.XmlString expectedLife)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXPECTEDLIFE$26, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXPECTEDLIFE$26);
            }
            target.set(expectedLife);
        }
    }
    
    /**
     * Gets the "DurationUnit" element
     */
    public java.lang.String getDurationUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DURATIONUNIT$28, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "DurationUnit" element
     */
    public org.apache.xmlbeans.XmlString xgetDurationUnit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DURATIONUNIT$28, 0);
            return target;
        }
    }
    
    /**
     * Sets the "DurationUnit" element
     */
    public void setDurationUnit(java.lang.String durationUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DURATIONUNIT$28, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DURATIONUNIT$28);
            }
            target.setStringValue(durationUnit);
        }
    }
    
    /**
     * Sets (as xml) the "DurationUnit" element
     */
    public void xsetDurationUnit(org.apache.xmlbeans.XmlString durationUnit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DURATIONUNIT$28, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DURATIONUNIT$28);
            }
            target.set(durationUnit);
        }
    }
    
    /**
     * Gets the "WarrantyDescription" element
     */
    public java.lang.String getWarrantyDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYDESCRIPTION$30, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "WarrantyDescription" element
     */
    public org.apache.xmlbeans.XmlString xgetWarrantyDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WARRANTYDESCRIPTION$30, 0);
            return target;
        }
    }
    
    /**
     * Sets the "WarrantyDescription" element
     */
    public void setWarrantyDescription(java.lang.String warrantyDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WARRANTYDESCRIPTION$30, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WARRANTYDESCRIPTION$30);
            }
            target.setStringValue(warrantyDescription);
        }
    }
    
    /**
     * Sets (as xml) the "WarrantyDescription" element
     */
    public void xsetWarrantyDescription(org.apache.xmlbeans.XmlString warrantyDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WARRANTYDESCRIPTION$30, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(WARRANTYDESCRIPTION$30);
            }
            target.set(warrantyDescription);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTSYSTEM$32, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTSYSTEM$32, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTSYSTEM$32, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTSYSTEM$32);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTSYSTEM$32, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTSYSTEM$32);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTOBJECT$34, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTOBJECT$34, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTOBJECT$34, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTOBJECT$34);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTOBJECT$34, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTOBJECT$34);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTIDENTIFIER$36, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTIDENTIFIER$36, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXTIDENTIFIER$36, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXTIDENTIFIER$36);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXTIDENTIFIER$36, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXTIDENTIFIER$36);
            }
            target.set(extIdentifier);
        }
    }
    
    /**
     * Gets the "NominalLength" element
     */
    public java.lang.String getNominalLength()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NOMINALLENGTH$38, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "NominalLength" element
     */
    public org.apache.xmlbeans.XmlString xgetNominalLength()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NOMINALLENGTH$38, 0);
            return target;
        }
    }
    
    /**
     * Sets the "NominalLength" element
     */
    public void setNominalLength(java.lang.String nominalLength)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NOMINALLENGTH$38, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NOMINALLENGTH$38);
            }
            target.setStringValue(nominalLength);
        }
    }
    
    /**
     * Sets (as xml) the "NominalLength" element
     */
    public void xsetNominalLength(org.apache.xmlbeans.XmlString nominalLength)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NOMINALLENGTH$38, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NOMINALLENGTH$38);
            }
            target.set(nominalLength);
        }
    }
    
    /**
     * Gets the "NominalWidth" element
     */
    public java.lang.String getNominalWidth()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NOMINALWIDTH$40, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "NominalWidth" element
     */
    public org.apache.xmlbeans.XmlString xgetNominalWidth()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NOMINALWIDTH$40, 0);
            return target;
        }
    }
    
    /**
     * Sets the "NominalWidth" element
     */
    public void setNominalWidth(java.lang.String nominalWidth)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NOMINALWIDTH$40, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NOMINALWIDTH$40);
            }
            target.setStringValue(nominalWidth);
        }
    }
    
    /**
     * Sets (as xml) the "NominalWidth" element
     */
    public void xsetNominalWidth(org.apache.xmlbeans.XmlString nominalWidth)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NOMINALWIDTH$40, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NOMINALWIDTH$40);
            }
            target.set(nominalWidth);
        }
    }
    
    /**
     * Gets the "NominalHeight" element
     */
    public java.lang.String getNominalHeight()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NOMINALHEIGHT$42, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "NominalHeight" element
     */
    public org.apache.xmlbeans.XmlString xgetNominalHeight()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NOMINALHEIGHT$42, 0);
            return target;
        }
    }
    
    /**
     * Sets the "NominalHeight" element
     */
    public void setNominalHeight(java.lang.String nominalHeight)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NOMINALHEIGHT$42, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NOMINALHEIGHT$42);
            }
            target.setStringValue(nominalHeight);
        }
    }
    
    /**
     * Sets (as xml) the "NominalHeight" element
     */
    public void xsetNominalHeight(org.apache.xmlbeans.XmlString nominalHeight)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NOMINALHEIGHT$42, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NOMINALHEIGHT$42);
            }
            target.set(nominalHeight);
        }
    }
    
    /**
     * Gets the "ModelReference" element
     */
    public java.lang.String getModelReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MODELREFERENCE$44, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ModelReference" element
     */
    public org.apache.xmlbeans.XmlString xgetModelReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MODELREFERENCE$44, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ModelReference" element
     */
    public void setModelReference(java.lang.String modelReference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MODELREFERENCE$44, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MODELREFERENCE$44);
            }
            target.setStringValue(modelReference);
        }
    }
    
    /**
     * Sets (as xml) the "ModelReference" element
     */
    public void xsetModelReference(org.apache.xmlbeans.XmlString modelReference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MODELREFERENCE$44, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(MODELREFERENCE$44);
            }
            target.set(modelReference);
        }
    }
    
    /**
     * Gets the "Shape" element
     */
    public java.lang.String getShape()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SHAPE$46, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Shape" element
     */
    public org.apache.xmlbeans.XmlString xgetShape()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SHAPE$46, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Shape" element
     */
    public void setShape(java.lang.String shape)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SHAPE$46, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SHAPE$46);
            }
            target.setStringValue(shape);
        }
    }
    
    /**
     * Sets (as xml) the "Shape" element
     */
    public void xsetShape(org.apache.xmlbeans.XmlString shape)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SHAPE$46, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SHAPE$46);
            }
            target.set(shape);
        }
    }
    
    /**
     * Gets the "Size" element
     */
    public java.lang.String getSize()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIZE$48, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Size" element
     */
    public org.apache.xmlbeans.XmlString xgetSize()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SIZE$48, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Size" element
     */
    public void setSize(java.lang.String size)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIZE$48, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SIZE$48);
            }
            target.setStringValue(size);
        }
    }
    
    /**
     * Sets (as xml) the "Size" element
     */
    public void xsetSize(org.apache.xmlbeans.XmlString size)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SIZE$48, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SIZE$48);
            }
            target.set(size);
        }
    }
    
    /**
     * Gets the "Color" element
     */
    public java.lang.String getColor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COLOR$50, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Color" element
     */
    public org.apache.xmlbeans.XmlString xgetColor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COLOR$50, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Color" element
     */
    public void setColor(java.lang.String color)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COLOR$50, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COLOR$50);
            }
            target.setStringValue(color);
        }
    }
    
    /**
     * Sets (as xml) the "Color" element
     */
    public void xsetColor(org.apache.xmlbeans.XmlString color)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COLOR$50, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COLOR$50);
            }
            target.set(color);
        }
    }
    
    /**
     * Gets the "Finish" element
     */
    public java.lang.String getFinish()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FINISH$52, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Finish" element
     */
    public org.apache.xmlbeans.XmlString xgetFinish()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FINISH$52, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Finish" element
     */
    public void setFinish(java.lang.String finish)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FINISH$52, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FINISH$52);
            }
            target.setStringValue(finish);
        }
    }
    
    /**
     * Sets (as xml) the "Finish" element
     */
    public void xsetFinish(org.apache.xmlbeans.XmlString finish)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FINISH$52, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FINISH$52);
            }
            target.set(finish);
        }
    }
    
    /**
     * Gets the "Grade" element
     */
    public java.lang.String getGrade()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(GRADE$54, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Grade" element
     */
    public org.apache.xmlbeans.XmlString xgetGrade()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(GRADE$54, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Grade" element
     */
    public void setGrade(java.lang.String grade)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(GRADE$54, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(GRADE$54);
            }
            target.setStringValue(grade);
        }
    }
    
    /**
     * Sets (as xml) the "Grade" element
     */
    public void xsetGrade(org.apache.xmlbeans.XmlString grade)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(GRADE$54, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(GRADE$54);
            }
            target.set(grade);
        }
    }
    
    /**
     * Gets the "Material" element
     */
    public java.lang.String getMaterial()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MATERIAL$56, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Material" element
     */
    public org.apache.xmlbeans.XmlString xgetMaterial()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MATERIAL$56, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Material" element
     */
    public void setMaterial(java.lang.String material)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MATERIAL$56, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MATERIAL$56);
            }
            target.setStringValue(material);
        }
    }
    
    /**
     * Sets (as xml) the "Material" element
     */
    public void xsetMaterial(org.apache.xmlbeans.XmlString material)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MATERIAL$56, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(MATERIAL$56);
            }
            target.set(material);
        }
    }
    
    /**
     * Gets the "Constituents" element
     */
    public java.lang.String getConstituents()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONSTITUENTS$58, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Constituents" element
     */
    public org.apache.xmlbeans.XmlString xgetConstituents()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CONSTITUENTS$58, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Constituents" element
     */
    public void setConstituents(java.lang.String constituents)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONSTITUENTS$58, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONSTITUENTS$58);
            }
            target.setStringValue(constituents);
        }
    }
    
    /**
     * Sets (as xml) the "Constituents" element
     */
    public void xsetConstituents(org.apache.xmlbeans.XmlString constituents)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CONSTITUENTS$58, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CONSTITUENTS$58);
            }
            target.set(constituents);
        }
    }
    
    /**
     * Gets the "Features" element
     */
    public java.lang.String getFeatures()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FEATURES$60, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Features" element
     */
    public org.apache.xmlbeans.XmlString xgetFeatures()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FEATURES$60, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Features" element
     */
    public void setFeatures(java.lang.String features)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FEATURES$60, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FEATURES$60);
            }
            target.setStringValue(features);
        }
    }
    
    /**
     * Sets (as xml) the "Features" element
     */
    public void xsetFeatures(org.apache.xmlbeans.XmlString features)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FEATURES$60, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FEATURES$60);
            }
            target.set(features);
        }
    }
    
    /**
     * Gets the "AccessibilityPerformance" element
     */
    public java.lang.String getAccessibilityPerformance()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ACCESSIBILITYPERFORMANCE$62, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AccessibilityPerformance" element
     */
    public org.apache.xmlbeans.XmlString xgetAccessibilityPerformance()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ACCESSIBILITYPERFORMANCE$62, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AccessibilityPerformance" element
     */
    public void setAccessibilityPerformance(java.lang.String accessibilityPerformance)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ACCESSIBILITYPERFORMANCE$62, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ACCESSIBILITYPERFORMANCE$62);
            }
            target.setStringValue(accessibilityPerformance);
        }
    }
    
    /**
     * Sets (as xml) the "AccessibilityPerformance" element
     */
    public void xsetAccessibilityPerformance(org.apache.xmlbeans.XmlString accessibilityPerformance)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ACCESSIBILITYPERFORMANCE$62, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ACCESSIBILITYPERFORMANCE$62);
            }
            target.set(accessibilityPerformance);
        }
    }
    
    /**
     * Gets the "CodePerformance" element
     */
    public java.lang.String getCodePerformance()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CODEPERFORMANCE$64, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "CodePerformance" element
     */
    public org.apache.xmlbeans.XmlString xgetCodePerformance()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CODEPERFORMANCE$64, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CodePerformance" element
     */
    public void setCodePerformance(java.lang.String codePerformance)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CODEPERFORMANCE$64, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CODEPERFORMANCE$64);
            }
            target.setStringValue(codePerformance);
        }
    }
    
    /**
     * Sets (as xml) the "CodePerformance" element
     */
    public void xsetCodePerformance(org.apache.xmlbeans.XmlString codePerformance)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CODEPERFORMANCE$64, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CODEPERFORMANCE$64);
            }
            target.set(codePerformance);
        }
    }
    
    /**
     * Gets the "SustainabilityPerformance" element
     */
    public java.lang.String getSustainabilityPerformance()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUSTAINABILITYPERFORMANCE$66, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SustainabilityPerformance" element
     */
    public org.apache.xmlbeans.XmlString xgetSustainabilityPerformance()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SUSTAINABILITYPERFORMANCE$66, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SustainabilityPerformance" element
     */
    public void setSustainabilityPerformance(java.lang.String sustainabilityPerformance)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUSTAINABILITYPERFORMANCE$66, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SUSTAINABILITYPERFORMANCE$66);
            }
            target.setStringValue(sustainabilityPerformance);
        }
    }
    
    /**
     * Sets (as xml) the "SustainabilityPerformance" element
     */
    public void xsetSustainabilityPerformance(org.apache.xmlbeans.XmlString sustainabilityPerformance)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SUSTAINABILITYPERFORMANCE$66, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SUSTAINABILITYPERFORMANCE$66);
            }
            target.set(sustainabilityPerformance);
        }
    }
}
