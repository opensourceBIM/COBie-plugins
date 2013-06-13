/*
 * XML Type:  AssetTypeInfoType
 * Namespace: http://assettype.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.assettype.AssetTypeInfoType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.assettype;


/**
 * An XML AssetTypeInfoType(@http://assettype.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public interface AssetTypeInfoType extends org.erdc.cobie.cobielite.core.AssetTypeInfoType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AssetTypeInfoType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sDB8A4E468FD3CA78BBE0CAC69C637E16").resolveHandle("assettypeinfotype8f8btype");
    
    /**
     * Gets the "AssetTypeCategory" element
     */
    java.lang.String getAssetTypeCategory();
    
    /**
     * Gets (as xml) the "AssetTypeCategory" element
     */
    org.erdc.cobie.cobielite.core.AssetCategorySimpleType xgetAssetTypeCategory();
    
    /**
     * True if has "AssetTypeCategory" element
     */
    boolean isSetAssetTypeCategory();
    
    /**
     * Sets the "AssetTypeCategory" element
     */
    void setAssetTypeCategory(java.lang.String assetTypeCategory);
    
    /**
     * Sets (as xml) the "AssetTypeCategory" element
     */
    void xsetAssetTypeCategory(org.erdc.cobie.cobielite.core.AssetCategorySimpleType assetTypeCategory);
    
    /**
     * Unsets the "AssetTypeCategory" element
     */
    void unsetAssetTypeCategory();
    
    /**
     * Gets the "AssetTypeDescription" element
     */
    java.lang.String getAssetTypeDescription();
    
    /**
     * Gets (as xml) the "AssetTypeDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeDescription();
    
    /**
     * True if has "AssetTypeDescription" element
     */
    boolean isSetAssetTypeDescription();
    
    /**
     * Sets the "AssetTypeDescription" element
     */
    void setAssetTypeDescription(java.lang.String assetTypeDescription);
    
    /**
     * Sets (as xml) the "AssetTypeDescription" element
     */
    void xsetAssetTypeDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeDescription);
    
    /**
     * Unsets the "AssetTypeDescription" element
     */
    void unsetAssetTypeDescription();
    
    /**
     * Gets the "AssetTypePortabilityText" element
     */
    org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType.Enum getAssetTypePortabilityText();
    
    /**
     * Gets (as xml) the "AssetTypePortabilityText" element
     */
    org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType xgetAssetTypePortabilityText();
    
    /**
     * True if has "AssetTypePortabilityText" element
     */
    boolean isSetAssetTypePortabilityText();
    
    /**
     * Sets the "AssetTypePortabilityText" element
     */
    void setAssetTypePortabilityText(org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType.Enum assetTypePortabilityText);
    
    /**
     * Sets (as xml) the "AssetTypePortabilityText" element
     */
    void xsetAssetTypePortabilityText(org.erdc.cobie.cobielite.core.AssetPortabilitySimpleType assetTypePortabilityText);
    
    /**
     * Unsets the "AssetTypePortabilityText" element
     */
    void unsetAssetTypePortabilityText();
    
    /**
     * Gets the "AssetTypeModelNumber" element
     */
    java.lang.String getAssetTypeModelNumber();
    
    /**
     * Gets (as xml) the "AssetTypeModelNumber" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetTypeModelNumber();
    
    /**
     * True if has "AssetTypeModelNumber" element
     */
    boolean isSetAssetTypeModelNumber();
    
    /**
     * Sets the "AssetTypeModelNumber" element
     */
    void setAssetTypeModelNumber(java.lang.String assetTypeModelNumber);
    
    /**
     * Sets (as xml) the "AssetTypeModelNumber" element
     */
    void xsetAssetTypeModelNumber(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetTypeModelNumber);
    
    /**
     * Unsets the "AssetTypeModelNumber" element
     */
    void unsetAssetTypeModelNumber();
    
    /**
     * Gets the "AssetTypeReplacementCostValue" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType getAssetTypeReplacementCostValue();
    
    /**
     * True if has "AssetTypeReplacementCostValue" element
     */
    boolean isSetAssetTypeReplacementCostValue();
    
    /**
     * Sets the "AssetTypeReplacementCostValue" element
     */
    void setAssetTypeReplacementCostValue(org.erdc.cobie.cobielite.core.DecimalValueType assetTypeReplacementCostValue);
    
    /**
     * Appends and returns a new empty "AssetTypeReplacementCostValue" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType addNewAssetTypeReplacementCostValue();
    
    /**
     * Unsets the "AssetTypeReplacementCostValue" element
     */
    void unsetAssetTypeReplacementCostValue();
    
    /**
     * Gets the "AssetTypeExpectedLifeValue" element
     */
    org.erdc.cobie.cobielite.core.IntegerValueType getAssetTypeExpectedLifeValue();
    
    /**
     * True if has "AssetTypeExpectedLifeValue" element
     */
    boolean isSetAssetTypeExpectedLifeValue();
    
    /**
     * Sets the "AssetTypeExpectedLifeValue" element
     */
    void setAssetTypeExpectedLifeValue(org.erdc.cobie.cobielite.core.IntegerValueType assetTypeExpectedLifeValue);
    
    /**
     * Appends and returns a new empty "AssetTypeExpectedLifeValue" element
     */
    org.erdc.cobie.cobielite.core.IntegerValueType addNewAssetTypeExpectedLifeValue();
    
    /**
     * Unsets the "AssetTypeExpectedLifeValue" element
     */
    void unsetAssetTypeExpectedLifeValue();
    
    /**
     * Gets the "AssetTypeNominalLength" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType getAssetTypeNominalLength();
    
    /**
     * True if has "AssetTypeNominalLength" element
     */
    boolean isSetAssetTypeNominalLength();
    
    /**
     * Sets the "AssetTypeNominalLength" element
     */
    void setAssetTypeNominalLength(org.erdc.cobie.cobielite.core.DecimalValueType assetTypeNominalLength);
    
    /**
     * Appends and returns a new empty "AssetTypeNominalLength" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType addNewAssetTypeNominalLength();
    
    /**
     * Unsets the "AssetTypeNominalLength" element
     */
    void unsetAssetTypeNominalLength();
    
    /**
     * Gets the "AssetTypeNominalWidth" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType getAssetTypeNominalWidth();
    
    /**
     * True if has "AssetTypeNominalWidth" element
     */
    boolean isSetAssetTypeNominalWidth();
    
    /**
     * Sets the "AssetTypeNominalWidth" element
     */
    void setAssetTypeNominalWidth(org.erdc.cobie.cobielite.core.DecimalValueType assetTypeNominalWidth);
    
    /**
     * Appends and returns a new empty "AssetTypeNominalWidth" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType addNewAssetTypeNominalWidth();
    
    /**
     * Unsets the "AssetTypeNominalWidth" element
     */
    void unsetAssetTypeNominalWidth();
    
    /**
     * Gets the "AssetTypeNominalHeight" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType getAssetTypeNominalHeight();
    
    /**
     * True if has "AssetTypeNominalHeight" element
     */
    boolean isSetAssetTypeNominalHeight();
    
    /**
     * Sets the "AssetTypeNominalHeight" element
     */
    void setAssetTypeNominalHeight(org.erdc.cobie.cobielite.core.DecimalValueType assetTypeNominalHeight);
    
    /**
     * Appends and returns a new empty "AssetTypeNominalHeight" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType addNewAssetTypeNominalHeight();
    
    /**
     * Unsets the "AssetTypeNominalHeight" element
     */
    void unsetAssetTypeNominalHeight();
    
    /**
     * Gets the "AssetTypeAccessibilityText" element
     */
    java.lang.String getAssetTypeAccessibilityText();
    
    /**
     * Gets (as xml) the "AssetTypeAccessibilityText" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetTypeAccessibilityText();
    
    /**
     * True if has "AssetTypeAccessibilityText" element
     */
    boolean isSetAssetTypeAccessibilityText();
    
    /**
     * Sets the "AssetTypeAccessibilityText" element
     */
    void setAssetTypeAccessibilityText(java.lang.String assetTypeAccessibilityText);
    
    /**
     * Sets (as xml) the "AssetTypeAccessibilityText" element
     */
    void xsetAssetTypeAccessibilityText(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetTypeAccessibilityText);
    
    /**
     * Unsets the "AssetTypeAccessibilityText" element
     */
    void unsetAssetTypeAccessibilityText();
    
    /**
     * Gets the "AssetTypeCodePerformance" element
     */
    java.lang.String getAssetTypeCodePerformance();
    
    /**
     * Gets (as xml) the "AssetTypeCodePerformance" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetTypeCodePerformance();
    
    /**
     * True if has "AssetTypeCodePerformance" element
     */
    boolean isSetAssetTypeCodePerformance();
    
    /**
     * Sets the "AssetTypeCodePerformance" element
     */
    void setAssetTypeCodePerformance(java.lang.String assetTypeCodePerformance);
    
    /**
     * Sets (as xml) the "AssetTypeCodePerformance" element
     */
    void xsetAssetTypeCodePerformance(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetTypeCodePerformance);
    
    /**
     * Unsets the "AssetTypeCodePerformance" element
     */
    void unsetAssetTypeCodePerformance();
    
    /**
     * Gets the "AssetTypeColorCode" element
     */
    java.lang.String getAssetTypeColorCode();
    
    /**
     * Gets (as xml) the "AssetTypeColorCode" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetTypeColorCode();
    
    /**
     * True if has "AssetTypeColorCode" element
     */
    boolean isSetAssetTypeColorCode();
    
    /**
     * Sets the "AssetTypeColorCode" element
     */
    void setAssetTypeColorCode(java.lang.String assetTypeColorCode);
    
    /**
     * Sets (as xml) the "AssetTypeColorCode" element
     */
    void xsetAssetTypeColorCode(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetTypeColorCode);
    
    /**
     * Unsets the "AssetTypeColorCode" element
     */
    void unsetAssetTypeColorCode();
    
    /**
     * Gets the "AssetTypeConstituentsDescription" element
     */
    java.lang.String getAssetTypeConstituentsDescription();
    
    /**
     * Gets (as xml) the "AssetTypeConstituentsDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeConstituentsDescription();
    
    /**
     * True if has "AssetTypeConstituentsDescription" element
     */
    boolean isSetAssetTypeConstituentsDescription();
    
    /**
     * Sets the "AssetTypeConstituentsDescription" element
     */
    void setAssetTypeConstituentsDescription(java.lang.String assetTypeConstituentsDescription);
    
    /**
     * Sets (as xml) the "AssetTypeConstituentsDescription" element
     */
    void xsetAssetTypeConstituentsDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeConstituentsDescription);
    
    /**
     * Unsets the "AssetTypeConstituentsDescription" element
     */
    void unsetAssetTypeConstituentsDescription();
    
    /**
     * Gets the "AssetTypeFeaturesDescription" element
     */
    java.lang.String getAssetTypeFeaturesDescription();
    
    /**
     * Gets (as xml) the "AssetTypeFeaturesDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeFeaturesDescription();
    
    /**
     * True if has "AssetTypeFeaturesDescription" element
     */
    boolean isSetAssetTypeFeaturesDescription();
    
    /**
     * Sets the "AssetTypeFeaturesDescription" element
     */
    void setAssetTypeFeaturesDescription(java.lang.String assetTypeFeaturesDescription);
    
    /**
     * Sets (as xml) the "AssetTypeFeaturesDescription" element
     */
    void xsetAssetTypeFeaturesDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeFeaturesDescription);
    
    /**
     * Unsets the "AssetTypeFeaturesDescription" element
     */
    void unsetAssetTypeFeaturesDescription();
    
    /**
     * Gets the "AssetTypeFinishDescription" element
     */
    java.lang.String getAssetTypeFinishDescription();
    
    /**
     * Gets (as xml) the "AssetTypeFinishDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeFinishDescription();
    
    /**
     * True if has "AssetTypeFinishDescription" element
     */
    boolean isSetAssetTypeFinishDescription();
    
    /**
     * Sets the "AssetTypeFinishDescription" element
     */
    void setAssetTypeFinishDescription(java.lang.String assetTypeFinishDescription);
    
    /**
     * Sets (as xml) the "AssetTypeFinishDescription" element
     */
    void xsetAssetTypeFinishDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeFinishDescription);
    
    /**
     * Unsets the "AssetTypeFinishDescription" element
     */
    void unsetAssetTypeFinishDescription();
    
    /**
     * Gets the "AssetTypeGradeDescription" element
     */
    java.lang.String getAssetTypeGradeDescription();
    
    /**
     * Gets (as xml) the "AssetTypeGradeDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeGradeDescription();
    
    /**
     * True if has "AssetTypeGradeDescription" element
     */
    boolean isSetAssetTypeGradeDescription();
    
    /**
     * Sets the "AssetTypeGradeDescription" element
     */
    void setAssetTypeGradeDescription(java.lang.String assetTypeGradeDescription);
    
    /**
     * Sets (as xml) the "AssetTypeGradeDescription" element
     */
    void xsetAssetTypeGradeDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeGradeDescription);
    
    /**
     * Unsets the "AssetTypeGradeDescription" element
     */
    void unsetAssetTypeGradeDescription();
    
    /**
     * Gets the "AssetTypeMaterialDescription" element
     */
    java.lang.String getAssetTypeMaterialDescription();
    
    /**
     * Gets (as xml) the "AssetTypeMaterialDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeMaterialDescription();
    
    /**
     * True if has "AssetTypeMaterialDescription" element
     */
    boolean isSetAssetTypeMaterialDescription();
    
    /**
     * Sets the "AssetTypeMaterialDescription" element
     */
    void setAssetTypeMaterialDescription(java.lang.String assetTypeMaterialDescription);
    
    /**
     * Sets (as xml) the "AssetTypeMaterialDescription" element
     */
    void xsetAssetTypeMaterialDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeMaterialDescription);
    
    /**
     * Unsets the "AssetTypeMaterialDescription" element
     */
    void unsetAssetTypeMaterialDescription();
    
    /**
     * Gets the "AssetTypeShapeDescription" element
     */
    java.lang.String getAssetTypeShapeDescription();
    
    /**
     * Gets (as xml) the "AssetTypeShapeDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeShapeDescription();
    
    /**
     * True if has "AssetTypeShapeDescription" element
     */
    boolean isSetAssetTypeShapeDescription();
    
    /**
     * Sets the "AssetTypeShapeDescription" element
     */
    void setAssetTypeShapeDescription(java.lang.String assetTypeShapeDescription);
    
    /**
     * Sets (as xml) the "AssetTypeShapeDescription" element
     */
    void xsetAssetTypeShapeDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeShapeDescription);
    
    /**
     * Unsets the "AssetTypeShapeDescription" element
     */
    void unsetAssetTypeShapeDescription();
    
    /**
     * Gets the "AssetTypeSizeDescription" element
     */
    java.lang.String getAssetTypeSizeDescription();
    
    /**
     * Gets (as xml) the "AssetTypeSizeDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeSizeDescription();
    
    /**
     * True if has "AssetTypeSizeDescription" element
     */
    boolean isSetAssetTypeSizeDescription();
    
    /**
     * Sets the "AssetTypeSizeDescription" element
     */
    void setAssetTypeSizeDescription(java.lang.String assetTypeSizeDescription);
    
    /**
     * Sets (as xml) the "AssetTypeSizeDescription" element
     */
    void xsetAssetTypeSizeDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeSizeDescription);
    
    /**
     * Unsets the "AssetTypeSizeDescription" element
     */
    void unsetAssetTypeSizeDescription();
    
    /**
     * Gets the "AssetTypeSustainabilityPerformanceDescription" element
     */
    java.lang.String getAssetTypeSustainabilityPerformanceDescription();
    
    /**
     * Gets (as xml) the "AssetTypeSustainabilityPerformanceDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetTypeSustainabilityPerformanceDescription();
    
    /**
     * True if has "AssetTypeSustainabilityPerformanceDescription" element
     */
    boolean isSetAssetTypeSustainabilityPerformanceDescription();
    
    /**
     * Sets the "AssetTypeSustainabilityPerformanceDescription" element
     */
    void setAssetTypeSustainabilityPerformanceDescription(java.lang.String assetTypeSustainabilityPerformanceDescription);
    
    /**
     * Sets (as xml) the "AssetTypeSustainabilityPerformanceDescription" element
     */
    void xsetAssetTypeSustainabilityPerformanceDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetTypeSustainabilityPerformanceDescription);
    
    /**
     * Unsets the "AssetTypeSustainabilityPerformanceDescription" element
     */
    void unsetAssetTypeSustainabilityPerformanceDescription();
    
    /**
     * Gets the "Assets" element
     */
    org.erdc.cobie.cobielite.core.AssetCollectionType getAssets();
    
    /**
     * True if has "Assets" element
     */
    boolean isSetAssets();
    
    /**
     * Sets the "Assets" element
     */
    void setAssets(org.erdc.cobie.cobielite.core.AssetCollectionType assets);
    
    /**
     * Appends and returns a new empty "Assets" element
     */
    org.erdc.cobie.cobielite.core.AssetCollectionType addNewAssets();
    
    /**
     * Unsets the "Assets" element
     */
    void unsetAssets();
    
    /**
     * Gets the "AssetTypeContactAssignments" element
     */
    org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType getAssetTypeContactAssignments();
    
    /**
     * True if has "AssetTypeContactAssignments" element
     */
    boolean isSetAssetTypeContactAssignments();
    
    /**
     * Sets the "AssetTypeContactAssignments" element
     */
    void setAssetTypeContactAssignments(org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType assetTypeContactAssignments);
    
    /**
     * Appends and returns a new empty "AssetTypeContactAssignments" element
     */
    org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType addNewAssetTypeContactAssignments();
    
    /**
     * Unsets the "AssetTypeContactAssignments" element
     */
    void unsetAssetTypeContactAssignments();
    
    /**
     * Gets the "Warranties" element
     */
    org.erdc.cobie.cobielite.core.WarrantyCollectionType getWarranties();
    
    /**
     * True if has "Warranties" element
     */
    boolean isSetWarranties();
    
    /**
     * Sets the "Warranties" element
     */
    void setWarranties(org.erdc.cobie.cobielite.core.WarrantyCollectionType warranties);
    
    /**
     * Appends and returns a new empty "Warranties" element
     */
    org.erdc.cobie.cobielite.core.WarrantyCollectionType addNewWarranties();
    
    /**
     * Unsets the "Warranties" element
     */
    void unsetWarranties();
    
    /**
     * Gets the "Spares" element
     */
    org.erdc.cobie.cobielite.core.SpareCollectionType getSpares();
    
    /**
     * True if has "Spares" element
     */
    boolean isSetSpares();
    
    /**
     * Sets the "Spares" element
     */
    void setSpares(org.erdc.cobie.cobielite.core.SpareCollectionType spares);
    
    /**
     * Appends and returns a new empty "Spares" element
     */
    org.erdc.cobie.cobielite.core.SpareCollectionType addNewSpares();
    
    /**
     * Unsets the "Spares" element
     */
    void unsetSpares();
    
    /**
     * Gets the "Jobs" element
     */
    org.erdc.cobie.cobielite.core.JobCollectionType getJobs();
    
    /**
     * True if has "Jobs" element
     */
    boolean isSetJobs();
    
    /**
     * Sets the "Jobs" element
     */
    void setJobs(org.erdc.cobie.cobielite.core.JobCollectionType jobs);
    
    /**
     * Appends and returns a new empty "Jobs" element
     */
    org.erdc.cobie.cobielite.core.JobCollectionType addNewJobs();
    
    /**
     * Unsets the "Jobs" element
     */
    void unsetJobs();
    
    /**
     * Gets the "AssemblyAssignments" element
     */
    org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType getAssemblyAssignments();
    
    /**
     * True if has "AssemblyAssignments" element
     */
    boolean isSetAssemblyAssignments();
    
    /**
     * Sets the "AssemblyAssignments" element
     */
    void setAssemblyAssignments(org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType assemblyAssignments);
    
    /**
     * Appends and returns a new empty "AssemblyAssignments" element
     */
    org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType addNewAssemblyAssignments();
    
    /**
     * Unsets the "AssemblyAssignments" element
     */
    void unsetAssemblyAssignments();
    
    /**
     * Gets the "AssetTypeAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType getAssetTypeAttributes();
    
    /**
     * True if has "AssetTypeAttributes" element
     */
    boolean isSetAssetTypeAttributes();
    
    /**
     * Sets the "AssetTypeAttributes" element
     */
    void setAssetTypeAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType assetTypeAttributes);
    
    /**
     * Appends and returns a new empty "AssetTypeAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType addNewAssetTypeAttributes();
    
    /**
     * Unsets the "AssetTypeAttributes" element
     */
    void unsetAssetTypeAttributes();
    
    /**
     * Gets the "AssetTypeDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType getAssetTypeDocuments();
    
    /**
     * True if has "AssetTypeDocuments" element
     */
    boolean isSetAssetTypeDocuments();
    
    /**
     * Sets the "AssetTypeDocuments" element
     */
    void setAssetTypeDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType assetTypeDocuments);
    
    /**
     * Appends and returns a new empty "AssetTypeDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType addNewAssetTypeDocuments();
    
    /**
     * Unsets the "AssetTypeDocuments" element
     */
    void unsetAssetTypeDocuments();
    
    /**
     * Gets the "AssetTypeIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType getAssetTypeIssues();
    
    /**
     * True if has "AssetTypeIssues" element
     */
    boolean isSetAssetTypeIssues();
    
    /**
     * Sets the "AssetTypeIssues" element
     */
    void setAssetTypeIssues(org.erdc.cobie.cobielite.core.IssueCollectionType assetTypeIssues);
    
    /**
     * Appends and returns a new empty "AssetTypeIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType addNewAssetTypeIssues();
    
    /**
     * Unsets the "AssetTypeIssues" element
     */
    void unsetAssetTypeIssues();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.erdc.cobie.cobielite.assettype.AssetTypeInfoType newInstance() {
          return (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.erdc.cobie.cobielite.assettype.AssetTypeInfoType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.erdc.cobie.cobielite.assettype.AssetTypeInfoType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.erdc.cobie.cobielite.assettype.AssetTypeInfoType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.erdc.cobie.cobielite.assettype.AssetTypeInfoType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.erdc.cobie.cobielite.assettype.AssetTypeInfoType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.erdc.cobie.cobielite.assettype.AssetTypeInfoType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.erdc.cobie.cobielite.assettype.AssetTypeInfoType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.erdc.cobie.cobielite.assettype.AssetTypeInfoType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.erdc.cobie.cobielite.assettype.AssetTypeInfoType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.erdc.cobie.cobielite.assettype.AssetTypeInfoType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.erdc.cobie.cobielite.assettype.AssetTypeInfoType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.erdc.cobie.cobielite.assettype.AssetTypeInfoType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.erdc.cobie.cobielite.assettype.AssetTypeInfoType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.erdc.cobie.cobielite.assettype.AssetTypeInfoType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.erdc.cobie.cobielite.assettype.AssetTypeInfoType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.assettype.AssetTypeInfoType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.assettype.AssetTypeInfoType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.assettype.AssetTypeInfoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
