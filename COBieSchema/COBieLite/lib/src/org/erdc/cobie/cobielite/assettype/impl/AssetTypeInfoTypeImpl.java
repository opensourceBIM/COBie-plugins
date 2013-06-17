/*
 * XML Type:  AssetTypeInfoType
 * Namespace: http://assettype.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.assettype.AssetTypeInfoType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.assettype.impl;
/**
 * An XML AssetTypeInfoType(@http://assettype.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class AssetTypeInfoTypeImpl extends org.erdc.cobie.cobielite.core.impl.AssetTypeInfoTypeImpl implements org.erdc.cobie.cobielite.assettype.AssetTypeInfoType
{
    private static final long serialVersionUID = 1L;
    
    public AssetTypeInfoTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETTYPECATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeCategory");
    private static final javax.xml.namespace.QName ASSETTYPEDESCRIPTION$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeDescription");
    private static final javax.xml.namespace.QName AssetTypeAccountingCategory$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeAccountingCategory");
    private static final javax.xml.namespace.QName ASSETTYPEMODELNUMBER$6 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeModelNumber");
    private static final javax.xml.namespace.QName ASSETTYPEREPLACEMENTCOSTVALUE$8 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeReplacementCostValue");
    private static final javax.xml.namespace.QName ASSETTYPEEXPECTEDLIFEVALUE$10 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeExpectedLifeValue");
    private static final javax.xml.namespace.QName ASSETTYPENOMINALLENGTH$12 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeNominalLength");
    private static final javax.xml.namespace.QName ASSETTYPENOMINALWIDTH$14 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeNominalWidth");
    private static final javax.xml.namespace.QName ASSETTYPENOMINALHEIGHT$16 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeNominalHeight");
    private static final javax.xml.namespace.QName ASSETTYPEACCESSIBILITYTEXT$18 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeAccessibilityText");
    private static final javax.xml.namespace.QName ASSETTYPECODEPERFORMANCE$20 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeCodePerformance");
    private static final javax.xml.namespace.QName ASSETTYPECOLORCODE$22 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeColorCode");
    private static final javax.xml.namespace.QName ASSETTYPECONSTITUENTSDESCRIPTION$24 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeConstituentsDescription");
    private static final javax.xml.namespace.QName ASSETTYPEFEATURESDESCRIPTION$26 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeFeaturesDescription");
    private static final javax.xml.namespace.QName ASSETTYPEFINISHDESCRIPTION$28 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeFinishDescription");
    private static final javax.xml.namespace.QName ASSETTYPEGRADEDESCRIPTION$30 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeGradeDescription");
    private static final javax.xml.namespace.QName ASSETTYPEMATERIALDESCRIPTION$32 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeMaterialDescription");
    private static final javax.xml.namespace.QName ASSETTYPESHAPEDESCRIPTION$34 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeShapeDescription");
    private static final javax.xml.namespace.QName ASSETTYPESIZEDESCRIPTION$36 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeSizeDescription");
    private static final javax.xml.namespace.QName ASSETTYPESUSTAINABILITYPERFORMANCEDESCRIPTION$38 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeSustainabilityPerformanceDescription");
    private static final javax.xml.namespace.QName ASSETS$40 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Assets");
    private static final javax.xml.namespace.QName AssetTypeManufacturerContactAssignments$42 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeManufacturerContactAssignments");
    private static final javax.xml.namespace.QName WARRANTIES$44 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Warranties");
    private static final javax.xml.namespace.QName SPARES$46 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Spares");
    private static final javax.xml.namespace.QName JOBS$48 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Jobs");
    private static final javax.xml.namespace.QName ASSEMBLYASSIGNMENTS$50 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssemblyAssignments");
    private static final javax.xml.namespace.QName ASSETTYPEATTRIBUTES$52 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeAttributes");
    private static final javax.xml.namespace.QName ASSETTYPEDOCUMENTS$54 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeDocuments");
    private static final javax.xml.namespace.QName ASSETTYPEISSUES$56 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTypeIssues");
    
    
    /**
     * Gets the "AssetTypeCategory" element
     */
    public java.lang.String getAssetTypeCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPECATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeCategory" element
     */
    public org.erdc.cobie.cobielite.core.AssetCategorySimpleType xgetAssetTypeCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetCategorySimpleType)get_store().find_element_user(ASSETTYPECATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeCategory" element
     */
    public boolean isSetAssetTypeCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPECATEGORY$0) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeCategory" element
     */
    public void setAssetTypeCategory(java.lang.String assetTypeCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPECATEGORY$0);
            }
            target.setStringValue(assetTypeCategory);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeCategory" element
     */
    public void xsetAssetTypeCategory(org.erdc.cobie.cobielite.core.AssetCategorySimpleType assetTypeCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetCategorySimpleType)get_store().find_element_user(ASSETTYPECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.AssetCategorySimpleType)get_store().add_element_user(ASSETTYPECATEGORY$0);
            }
            target.set(assetTypeCategory);
        }
    }
    
    /**
     * Unsets the "AssetTypeCategory" element
     */
    public void unsetAssetTypeCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPECATEGORY$0, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeDescription" element
     */
    public java.lang.String getAssetTypeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEDESCRIPTION$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPEDESCRIPTION$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeDescription" element
     */
    public boolean isSetAssetTypeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPEDESCRIPTION$2) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeDescription" element
     */
    public void setAssetTypeDescription(java.lang.String assetTypeDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEDESCRIPTION$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPEDESCRIPTION$2);
            }
            target.setStringValue(assetTypeDescription);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeDescription" element
     */
    public void xsetAssetTypeDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPEDESCRIPTION$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(ASSETTYPEDESCRIPTION$2);
            }
            target.set(assetTypeDescription);
        }
    }
    
    /**
     * Unsets the "AssetTypeDescription" element
     */
    public void unsetAssetTypeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPEDESCRIPTION$2, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeAccountingCategory" element
     */
    public org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType.Enum getAssetTypeAccountingCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AssetTypeAccountingCategory$4, 0);
            if (target == null)
            {
                return null;
            }
            return (org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeAccountingCategory" element
     */
    public org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType xgetAssetTypeAccountingCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType)get_store().find_element_user(AssetTypeAccountingCategory$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeAccountingCategory" element
     */
    public boolean isSetAssetTypeAccountingCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(AssetTypeAccountingCategory$4) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeAccountingCategory" element
     */
    public void setAssetTypeAccountingCategory(org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType.Enum AssetTypeAccountingCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AssetTypeAccountingCategory$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AssetTypeAccountingCategory$4);
            }
            target.setEnumValue(AssetTypeAccountingCategory);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeAccountingCategory" element
     */
    public void xsetAssetTypeAccountingCategory(org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType AssetTypeAccountingCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType)get_store().find_element_user(AssetTypeAccountingCategory$4, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType)get_store().add_element_user(AssetTypeAccountingCategory$4);
            }
            target.set(AssetTypeAccountingCategory);
        }
    }
    
    /**
     * Unsets the "AssetTypeAccountingCategory" element
     */
    public void unsetAssetTypeAccountingCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(AssetTypeAccountingCategory$4, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeModelNumber" element
     */
    public java.lang.String getAssetTypeModelNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEMODELNUMBER$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeModelNumber" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetTypeModelNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTYPEMODELNUMBER$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeModelNumber" element
     */
    public boolean isSetAssetTypeModelNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPEMODELNUMBER$6) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeModelNumber" element
     */
    public void setAssetTypeModelNumber(java.lang.String assetTypeModelNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEMODELNUMBER$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPEMODELNUMBER$6);
            }
            target.setStringValue(assetTypeModelNumber);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeModelNumber" element
     */
    public void xsetAssetTypeModelNumber(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetTypeModelNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTYPEMODELNUMBER$6, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETTYPEMODELNUMBER$6);
            }
            target.set(assetTypeModelNumber);
        }
    }
    
    /**
     * Unsets the "AssetTypeModelNumber" element
     */
    public void unsetAssetTypeModelNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPEMODELNUMBER$6, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeReplacementCostValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getAssetTypeReplacementCostValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(ASSETTYPEREPLACEMENTCOSTVALUE$8, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeReplacementCostValue" element
     */
    public boolean isSetAssetTypeReplacementCostValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPEREPLACEMENTCOSTVALUE$8) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeReplacementCostValue" element
     */
    public void setAssetTypeReplacementCostValue(org.erdc.cobie.cobielite.core.DecimalValueType assetTypeReplacementCostValue)
    {
        generatedSetterHelperImpl(assetTypeReplacementCostValue, ASSETTYPEREPLACEMENTCOSTVALUE$8, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypeReplacementCostValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType addNewAssetTypeReplacementCostValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(ASSETTYPEREPLACEMENTCOSTVALUE$8);
            return target;
        }
    }
    
    /**
     * Unsets the "AssetTypeReplacementCostValue" element
     */
    public void unsetAssetTypeReplacementCostValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPEREPLACEMENTCOSTVALUE$8, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeExpectedLifeValue" element
     */
    public org.erdc.cobie.cobielite.core.IntegerValueType getAssetTypeExpectedLifeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IntegerValueType target = null;
            target = (org.erdc.cobie.cobielite.core.IntegerValueType)get_store().find_element_user(ASSETTYPEEXPECTEDLIFEVALUE$10, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeExpectedLifeValue" element
     */
    public boolean isSetAssetTypeExpectedLifeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPEEXPECTEDLIFEVALUE$10) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeExpectedLifeValue" element
     */
    public void setAssetTypeExpectedLifeValue(org.erdc.cobie.cobielite.core.IntegerValueType assetTypeExpectedLifeValue)
    {
        generatedSetterHelperImpl(assetTypeExpectedLifeValue, ASSETTYPEEXPECTEDLIFEVALUE$10, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypeExpectedLifeValue" element
     */
    public org.erdc.cobie.cobielite.core.IntegerValueType addNewAssetTypeExpectedLifeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IntegerValueType target = null;
            target = (org.erdc.cobie.cobielite.core.IntegerValueType)get_store().add_element_user(ASSETTYPEEXPECTEDLIFEVALUE$10);
            return target;
        }
    }
    
    /**
     * Unsets the "AssetTypeExpectedLifeValue" element
     */
    public void unsetAssetTypeExpectedLifeValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPEEXPECTEDLIFEVALUE$10, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeNominalLength" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getAssetTypeNominalLength()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(ASSETTYPENOMINALLENGTH$12, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeNominalLength" element
     */
    public boolean isSetAssetTypeNominalLength()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPENOMINALLENGTH$12) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeNominalLength" element
     */
    public void setAssetTypeNominalLength(org.erdc.cobie.cobielite.core.DecimalValueType assetTypeNominalLength)
    {
        generatedSetterHelperImpl(assetTypeNominalLength, ASSETTYPENOMINALLENGTH$12, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypeNominalLength" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType addNewAssetTypeNominalLength()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(ASSETTYPENOMINALLENGTH$12);
            return target;
        }
    }
    
    /**
     * Unsets the "AssetTypeNominalLength" element
     */
    public void unsetAssetTypeNominalLength()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPENOMINALLENGTH$12, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeNominalWidth" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getAssetTypeNominalWidth()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(ASSETTYPENOMINALWIDTH$14, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeNominalWidth" element
     */
    public boolean isSetAssetTypeNominalWidth()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPENOMINALWIDTH$14) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeNominalWidth" element
     */
    public void setAssetTypeNominalWidth(org.erdc.cobie.cobielite.core.DecimalValueType assetTypeNominalWidth)
    {
        generatedSetterHelperImpl(assetTypeNominalWidth, ASSETTYPENOMINALWIDTH$14, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypeNominalWidth" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType addNewAssetTypeNominalWidth()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(ASSETTYPENOMINALWIDTH$14);
            return target;
        }
    }
    
    /**
     * Unsets the "AssetTypeNominalWidth" element
     */
    public void unsetAssetTypeNominalWidth()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPENOMINALWIDTH$14, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeNominalHeight" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getAssetTypeNominalHeight()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(ASSETTYPENOMINALHEIGHT$16, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeNominalHeight" element
     */
    public boolean isSetAssetTypeNominalHeight()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPENOMINALHEIGHT$16) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeNominalHeight" element
     */
    public void setAssetTypeNominalHeight(org.erdc.cobie.cobielite.core.DecimalValueType assetTypeNominalHeight)
    {
        generatedSetterHelperImpl(assetTypeNominalHeight, ASSETTYPENOMINALHEIGHT$16, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypeNominalHeight" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType addNewAssetTypeNominalHeight()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(ASSETTYPENOMINALHEIGHT$16);
            return target;
        }
    }
    
    /**
     * Unsets the "AssetTypeNominalHeight" element
     */
    public void unsetAssetTypeNominalHeight()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPENOMINALHEIGHT$16, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeAccessibilityText" element
     */
    public java.lang.String getAssetTypeAccessibilityText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEACCESSIBILITYTEXT$18, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeAccessibilityText" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetTypeAccessibilityText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTYPEACCESSIBILITYTEXT$18, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeAccessibilityText" element
     */
    public boolean isSetAssetTypeAccessibilityText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPEACCESSIBILITYTEXT$18) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeAccessibilityText" element
     */
    public void setAssetTypeAccessibilityText(java.lang.String assetTypeAccessibilityText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEACCESSIBILITYTEXT$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPEACCESSIBILITYTEXT$18);
            }
            target.setStringValue(assetTypeAccessibilityText);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeAccessibilityText" element
     */
    public void xsetAssetTypeAccessibilityText(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetTypeAccessibilityText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTYPEACCESSIBILITYTEXT$18, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETTYPEACCESSIBILITYTEXT$18);
            }
            target.set(assetTypeAccessibilityText);
        }
    }
    
    /**
     * Unsets the "AssetTypeAccessibilityText" element
     */
    public void unsetAssetTypeAccessibilityText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPEACCESSIBILITYTEXT$18, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeCodePerformance" element
     */
    public java.lang.String getAssetTypeCodePerformance()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPECODEPERFORMANCE$20, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeCodePerformance" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetTypeCodePerformance()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTYPECODEPERFORMANCE$20, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeCodePerformance" element
     */
    public boolean isSetAssetTypeCodePerformance()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPECODEPERFORMANCE$20) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeCodePerformance" element
     */
    public void setAssetTypeCodePerformance(java.lang.String assetTypeCodePerformance)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPECODEPERFORMANCE$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPECODEPERFORMANCE$20);
            }
            target.setStringValue(assetTypeCodePerformance);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeCodePerformance" element
     */
    public void xsetAssetTypeCodePerformance(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetTypeCodePerformance)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTYPECODEPERFORMANCE$20, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETTYPECODEPERFORMANCE$20);
            }
            target.set(assetTypeCodePerformance);
        }
    }
    
    /**
     * Unsets the "AssetTypeCodePerformance" element
     */
    public void unsetAssetTypeCodePerformance()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPECODEPERFORMANCE$20, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeColorCode" element
     */
    public java.lang.String getAssetTypeColorCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPECOLORCODE$22, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeColorCode" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetTypeColorCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTYPECOLORCODE$22, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeColorCode" element
     */
    public boolean isSetAssetTypeColorCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPECOLORCODE$22) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeColorCode" element
     */
    public void setAssetTypeColorCode(java.lang.String assetTypeColorCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPECOLORCODE$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPECOLORCODE$22);
            }
            target.setStringValue(assetTypeColorCode);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeColorCode" element
     */
    public void xsetAssetTypeColorCode(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetTypeColorCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTYPECOLORCODE$22, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETTYPECOLORCODE$22);
            }
            target.set(assetTypeColorCode);
        }
    }
    
    /**
     * Unsets the "AssetTypeColorCode" element
     */
    public void unsetAssetTypeColorCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPECOLORCODE$22, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeConstituentsDescription" element
     */
    public java.lang.String getAssetTypeConstituentsDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPECONSTITUENTSDESCRIPTION$24, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeConstituentsDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeConstituentsDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPECONSTITUENTSDESCRIPTION$24, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeConstituentsDescription" element
     */
    public boolean isSetAssetTypeConstituentsDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPECONSTITUENTSDESCRIPTION$24) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeConstituentsDescription" element
     */
    public void setAssetTypeConstituentsDescription(java.lang.String assetTypeConstituentsDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPECONSTITUENTSDESCRIPTION$24, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPECONSTITUENTSDESCRIPTION$24);
            }
            target.setStringValue(assetTypeConstituentsDescription);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeConstituentsDescription" element
     */
    public void xsetAssetTypeConstituentsDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeConstituentsDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPECONSTITUENTSDESCRIPTION$24, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(ASSETTYPECONSTITUENTSDESCRIPTION$24);
            }
            target.set(assetTypeConstituentsDescription);
        }
    }
    
    /**
     * Unsets the "AssetTypeConstituentsDescription" element
     */
    public void unsetAssetTypeConstituentsDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPECONSTITUENTSDESCRIPTION$24, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeFeaturesDescription" element
     */
    public java.lang.String getAssetTypeFeaturesDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEFEATURESDESCRIPTION$26, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeFeaturesDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeFeaturesDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPEFEATURESDESCRIPTION$26, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeFeaturesDescription" element
     */
    public boolean isSetAssetTypeFeaturesDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPEFEATURESDESCRIPTION$26) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeFeaturesDescription" element
     */
    public void setAssetTypeFeaturesDescription(java.lang.String assetTypeFeaturesDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEFEATURESDESCRIPTION$26, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPEFEATURESDESCRIPTION$26);
            }
            target.setStringValue(assetTypeFeaturesDescription);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeFeaturesDescription" element
     */
    public void xsetAssetTypeFeaturesDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeFeaturesDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPEFEATURESDESCRIPTION$26, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(ASSETTYPEFEATURESDESCRIPTION$26);
            }
            target.set(assetTypeFeaturesDescription);
        }
    }
    
    /**
     * Unsets the "AssetTypeFeaturesDescription" element
     */
    public void unsetAssetTypeFeaturesDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPEFEATURESDESCRIPTION$26, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeFinishDescription" element
     */
    public java.lang.String getAssetTypeFinishDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEFINISHDESCRIPTION$28, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeFinishDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeFinishDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPEFINISHDESCRIPTION$28, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeFinishDescription" element
     */
    public boolean isSetAssetTypeFinishDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPEFINISHDESCRIPTION$28) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeFinishDescription" element
     */
    public void setAssetTypeFinishDescription(java.lang.String assetTypeFinishDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEFINISHDESCRIPTION$28, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPEFINISHDESCRIPTION$28);
            }
            target.setStringValue(assetTypeFinishDescription);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeFinishDescription" element
     */
    public void xsetAssetTypeFinishDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeFinishDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPEFINISHDESCRIPTION$28, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(ASSETTYPEFINISHDESCRIPTION$28);
            }
            target.set(assetTypeFinishDescription);
        }
    }
    
    /**
     * Unsets the "AssetTypeFinishDescription" element
     */
    public void unsetAssetTypeFinishDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPEFINISHDESCRIPTION$28, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeGradeDescription" element
     */
    public java.lang.String getAssetTypeGradeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEGRADEDESCRIPTION$30, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeGradeDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeGradeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPEGRADEDESCRIPTION$30, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeGradeDescription" element
     */
    public boolean isSetAssetTypeGradeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPEGRADEDESCRIPTION$30) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeGradeDescription" element
     */
    public void setAssetTypeGradeDescription(java.lang.String assetTypeGradeDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEGRADEDESCRIPTION$30, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPEGRADEDESCRIPTION$30);
            }
            target.setStringValue(assetTypeGradeDescription);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeGradeDescription" element
     */
    public void xsetAssetTypeGradeDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeGradeDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPEGRADEDESCRIPTION$30, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(ASSETTYPEGRADEDESCRIPTION$30);
            }
            target.set(assetTypeGradeDescription);
        }
    }
    
    /**
     * Unsets the "AssetTypeGradeDescription" element
     */
    public void unsetAssetTypeGradeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPEGRADEDESCRIPTION$30, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeMaterialDescription" element
     */
    public java.lang.String getAssetTypeMaterialDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEMATERIALDESCRIPTION$32, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeMaterialDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeMaterialDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPEMATERIALDESCRIPTION$32, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeMaterialDescription" element
     */
    public boolean isSetAssetTypeMaterialDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPEMATERIALDESCRIPTION$32) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeMaterialDescription" element
     */
    public void setAssetTypeMaterialDescription(java.lang.String assetTypeMaterialDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPEMATERIALDESCRIPTION$32, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPEMATERIALDESCRIPTION$32);
            }
            target.setStringValue(assetTypeMaterialDescription);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeMaterialDescription" element
     */
    public void xsetAssetTypeMaterialDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeMaterialDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPEMATERIALDESCRIPTION$32, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(ASSETTYPEMATERIALDESCRIPTION$32);
            }
            target.set(assetTypeMaterialDescription);
        }
    }
    
    /**
     * Unsets the "AssetTypeMaterialDescription" element
     */
    public void unsetAssetTypeMaterialDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPEMATERIALDESCRIPTION$32, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeShapeDescription" element
     */
    public java.lang.String getAssetTypeShapeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPESHAPEDESCRIPTION$34, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeShapeDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeShapeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPESHAPEDESCRIPTION$34, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeShapeDescription" element
     */
    public boolean isSetAssetTypeShapeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPESHAPEDESCRIPTION$34) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeShapeDescription" element
     */
    public void setAssetTypeShapeDescription(java.lang.String assetTypeShapeDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPESHAPEDESCRIPTION$34, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPESHAPEDESCRIPTION$34);
            }
            target.setStringValue(assetTypeShapeDescription);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeShapeDescription" element
     */
    public void xsetAssetTypeShapeDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeShapeDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPESHAPEDESCRIPTION$34, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(ASSETTYPESHAPEDESCRIPTION$34);
            }
            target.set(assetTypeShapeDescription);
        }
    }
    
    /**
     * Unsets the "AssetTypeShapeDescription" element
     */
    public void unsetAssetTypeShapeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPESHAPEDESCRIPTION$34, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeSizeDescription" element
     */
    public java.lang.String getAssetTypeSizeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPESIZEDESCRIPTION$36, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeSizeDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeSizeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPESIZEDESCRIPTION$36, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeSizeDescription" element
     */
    public boolean isSetAssetTypeSizeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPESIZEDESCRIPTION$36) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeSizeDescription" element
     */
    public void setAssetTypeSizeDescription(java.lang.String assetTypeSizeDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPESIZEDESCRIPTION$36, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPESIZEDESCRIPTION$36);
            }
            target.setStringValue(assetTypeSizeDescription);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeSizeDescription" element
     */
    public void xsetAssetTypeSizeDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeSizeDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPESIZEDESCRIPTION$36, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(ASSETTYPESIZEDESCRIPTION$36);
            }
            target.set(assetTypeSizeDescription);
        }
    }
    
    /**
     * Unsets the "AssetTypeSizeDescription" element
     */
    public void unsetAssetTypeSizeDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPESIZEDESCRIPTION$36, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeSustainabilityPerformanceDescription" element
     */
    public java.lang.String getAssetTypeSustainabilityPerformanceDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPESUSTAINABILITYPERFORMANCEDESCRIPTION$38, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTypeSustainabilityPerformanceDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeSustainabilityPerformanceDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPESUSTAINABILITYPERFORMANCEDESCRIPTION$38, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeSustainabilityPerformanceDescription" element
     */
    public boolean isSetAssetTypeSustainabilityPerformanceDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPESUSTAINABILITYPERFORMANCEDESCRIPTION$38) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeSustainabilityPerformanceDescription" element
     */
    public void setAssetTypeSustainabilityPerformanceDescription(java.lang.String assetTypeSustainabilityPerformanceDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTYPESUSTAINABILITYPERFORMANCEDESCRIPTION$38, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTYPESUSTAINABILITYPERFORMANCEDESCRIPTION$38);
            }
            target.setStringValue(assetTypeSustainabilityPerformanceDescription);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTypeSustainabilityPerformanceDescription" element
     */
    public void xsetAssetTypeSustainabilityPerformanceDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeSustainabilityPerformanceDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETTYPESUSTAINABILITYPERFORMANCEDESCRIPTION$38, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(ASSETTYPESUSTAINABILITYPERFORMANCEDESCRIPTION$38);
            }
            target.set(assetTypeSustainabilityPerformanceDescription);
        }
    }
    
    /**
     * Unsets the "AssetTypeSustainabilityPerformanceDescription" element
     */
    public void unsetAssetTypeSustainabilityPerformanceDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPESUSTAINABILITYPERFORMANCEDESCRIPTION$38, 0);
        }
    }
    
    /**
     * Gets the "Assets" element
     */
    public org.erdc.cobie.cobielite.core.AssetCollectionType getAssets()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetCollectionType)get_store().find_element_user(ASSETS$40, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Assets" element
     */
    public boolean isSetAssets()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETS$40) != 0;
        }
    }
    
    /**
     * Sets the "Assets" element
     */
    public void setAssets(org.erdc.cobie.cobielite.core.AssetCollectionType assets)
    {
        generatedSetterHelperImpl(assets, ASSETS$40, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Assets" element
     */
    public org.erdc.cobie.cobielite.core.AssetCollectionType addNewAssets()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssetCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AssetCollectionType)get_store().add_element_user(ASSETS$40);
            return target;
        }
    }
    
    /**
     * Unsets the "Assets" element
     */
    public void unsetAssets()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETS$40, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeManufacturerContactAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType getAssetTypeManufacturerContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType)get_store().find_element_user(AssetTypeManufacturerContactAssignments$42, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeManufacturerContactAssignments" element
     */
    public boolean isSetAssetTypeManufacturerContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(AssetTypeManufacturerContactAssignments$42) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeManufacturerContactAssignments" element
     */
    public void setAssetTypeManufacturerContactAssignments(org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType AssetTypeManufacturerContactAssignments)
    {
        generatedSetterHelperImpl(AssetTypeManufacturerContactAssignments, AssetTypeManufacturerContactAssignments$42, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypeManufacturerContactAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType addNewAssetTypeManufacturerContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType)get_store().add_element_user(AssetTypeManufacturerContactAssignments$42);
            return target;
        }
    }
    
    /**
     * Unsets the "AssetTypeManufacturerContactAssignments" element
     */
    public void unsetAssetTypeManufacturerContactAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(AssetTypeManufacturerContactAssignments$42, 0);
        }
    }
    
    /**
     * Gets the "Warranties" element
     */
    public org.erdc.cobie.cobielite.core.WarrantyCollectionType getWarranties()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.WarrantyCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.WarrantyCollectionType)get_store().find_element_user(WARRANTIES$44, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Warranties" element
     */
    public boolean isSetWarranties()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WARRANTIES$44) != 0;
        }
    }
    
    /**
     * Sets the "Warranties" element
     */
    public void setWarranties(org.erdc.cobie.cobielite.core.WarrantyCollectionType warranties)
    {
        generatedSetterHelperImpl(warranties, WARRANTIES$44, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Warranties" element
     */
    public org.erdc.cobie.cobielite.core.WarrantyCollectionType addNewWarranties()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.WarrantyCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.WarrantyCollectionType)get_store().add_element_user(WARRANTIES$44);
            return target;
        }
    }
    
    /**
     * Unsets the "Warranties" element
     */
    public void unsetWarranties()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WARRANTIES$44, 0);
        }
    }
    
    /**
     * Gets the "Spares" element
     */
    public org.erdc.cobie.cobielite.core.SpareCollectionType getSpares()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpareCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.SpareCollectionType)get_store().find_element_user(SPARES$46, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Spares" element
     */
    public boolean isSetSpares()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPARES$46) != 0;
        }
    }
    
    /**
     * Sets the "Spares" element
     */
    public void setSpares(org.erdc.cobie.cobielite.core.SpareCollectionType spares)
    {
        generatedSetterHelperImpl(spares, SPARES$46, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Spares" element
     */
    public org.erdc.cobie.cobielite.core.SpareCollectionType addNewSpares()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpareCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.SpareCollectionType)get_store().add_element_user(SPARES$46);
            return target;
        }
    }
    
    /**
     * Unsets the "Spares" element
     */
    public void unsetSpares()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPARES$46, 0);
        }
    }
    
    /**
     * Gets the "Jobs" element
     */
    public org.erdc.cobie.cobielite.core.JobCollectionType getJobs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.JobCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.JobCollectionType)get_store().find_element_user(JOBS$48, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Jobs" element
     */
    public boolean isSetJobs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(JOBS$48) != 0;
        }
    }
    
    /**
     * Sets the "Jobs" element
     */
    public void setJobs(org.erdc.cobie.cobielite.core.JobCollectionType jobs)
    {
        generatedSetterHelperImpl(jobs, JOBS$48, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Jobs" element
     */
    public org.erdc.cobie.cobielite.core.JobCollectionType addNewJobs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.JobCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.JobCollectionType)get_store().add_element_user(JOBS$48);
            return target;
        }
    }
    
    /**
     * Unsets the "Jobs" element
     */
    public void unsetJobs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(JOBS$48, 0);
        }
    }
    
    /**
     * Gets the "AssemblyAssignments" element
     */
    public org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType getAssemblyAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType)get_store().find_element_user(ASSEMBLYASSIGNMENTS$50, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AssemblyAssignments" element
     */
    public boolean isSetAssemblyAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSEMBLYASSIGNMENTS$50) != 0;
        }
    }
    
    /**
     * Sets the "AssemblyAssignments" element
     */
    public void setAssemblyAssignments(org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType assemblyAssignments)
    {
        generatedSetterHelperImpl(assemblyAssignments, ASSEMBLYASSIGNMENTS$50, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssemblyAssignments" element
     */
    public org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType addNewAssemblyAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType)get_store().add_element_user(ASSEMBLYASSIGNMENTS$50);
            return target;
        }
    }
    
    /**
     * Unsets the "AssemblyAssignments" element
     */
    public void unsetAssemblyAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSEMBLYASSIGNMENTS$50, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getAssetTypeAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(ASSETTYPEATTRIBUTES$52, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeAttributes" element
     */
    public boolean isSetAssetTypeAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPEATTRIBUTES$52) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeAttributes" element
     */
    public void setAssetTypeAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType assetTypeAttributes)
    {
        generatedSetterHelperImpl(assetTypeAttributes, ASSETTYPEATTRIBUTES$52, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypeAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewAssetTypeAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(ASSETTYPEATTRIBUTES$52);
            return target;
        }
    }
    
    /**
     * Unsets the "AssetTypeAttributes" element
     */
    public void unsetAssetTypeAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPEATTRIBUTES$52, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getAssetTypeDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(ASSETTYPEDOCUMENTS$54, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeDocuments" element
     */
    public boolean isSetAssetTypeDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPEDOCUMENTS$54) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeDocuments" element
     */
    public void setAssetTypeDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType assetTypeDocuments)
    {
        generatedSetterHelperImpl(assetTypeDocuments, ASSETTYPEDOCUMENTS$54, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypeDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewAssetTypeDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(ASSETTYPEDOCUMENTS$54);
            return target;
        }
    }
    
    /**
     * Unsets the "AssetTypeDocuments" element
     */
    public void unsetAssetTypeDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPEDOCUMENTS$54, 0);
        }
    }
    
    /**
     * Gets the "AssetTypeIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getAssetTypeIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(ASSETTYPEISSUES$56, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AssetTypeIssues" element
     */
    public boolean isSetAssetTypeIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTYPEISSUES$56) != 0;
        }
    }
    
    /**
     * Sets the "AssetTypeIssues" element
     */
    public void setAssetTypeIssues(org.erdc.cobie.cobielite.core.IssueCollectionType assetTypeIssues)
    {
        generatedSetterHelperImpl(assetTypeIssues, ASSETTYPEISSUES$56, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetTypeIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewAssetTypeIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(ASSETTYPEISSUES$56);
            return target;
        }
    }
    
    /**
     * Unsets the "AssetTypeIssues" element
     */
    public void unsetAssetTypeIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTYPEISSUES$56, 0);
        }
    }
}
