package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import java.util.ArrayList;
import java.util.List;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetTypeInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AssetPortabilitySimpleType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ContactAssignmentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IntegerValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.WarrantyCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.WarrantyType;
import org.erdc.cobie.cobielite.ValueHelper;

import org.erdc.cobie.cobielite.parsers.COBieLiteParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.AssetTypeAssemblyDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.AssetTypeAssetDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.AssetTypeJobDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.AssetTypeSpareDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.AssignmentHelper;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.TypeAssemblyIndex;
import org.erdc.cobie.sheetxmldata.TypeType;

public class AssetTypeParser extends DeepParser<TypeType, AssetTypeInfoType>
{

    private static final String WARRANTY_CATEGORY_LABOR = "Labor";
    private static final String WARRANTY_CATEGORY_PARTS = "Parts";

    public AssetTypeParser(TypeType cobieSheetXMLData, AssetTypeInfoType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected ArrayList<COBieLiteParserDispatcher> getChildParsingDispatchers()
    {
        ArrayList<COBieLiteParserDispatcher> parserDispatchers = new ArrayList<COBieLiteParserDispatcher>();
        TypeAssemblyIndex typeAssemblies = indexedCOBie.getTypeAssemblies();
        parserDispatchers.add(new AssetTypeAssemblyDispatcher(typeAssemblies.get(sourceCOBie.getName()), targetCOBie, indexedCOBie));
        parserDispatchers.add(new AssetTypeAssetDispatcher(indexedCOBie.getTypeComponents().get(sourceCOBie.getName()), targetCOBie, indexedCOBie));
        parserDispatchers.add(new AssetTypeJobDispatcher(indexedCOBie.getTypeJobs().get(sourceCOBie.getName()), targetCOBie, indexedCOBie));
        parserDispatchers.add(new AssetTypeSpareDispatcher(indexedCOBie.getTypeSpares().get(sourceCOBie.getName()), targetCOBie, indexedCOBie));
        return parserDispatchers;
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return targetCOBie.addNewAssetTypeAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return targetCOBie.addNewAssetTypeDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return targetCOBie.addNewAssetTypeIssues();
    }

    private void newWarranty(
            String warrantyNameCategory,
            String warrantyProvider,
            String warrantyDuration,
            String warrantyDurationUnit,
            WarrantyCollectionType warranties)
    {
        WarrantyType warranty = warranties.addNewWarranty();
        warranty.setWarrantyCategory(warrantyNameCategory);
        warranty.setWarrantyName(warrantyNameCategory);
        ContactAssignmentCollectionType contacts = warranty.addNewWarrantyGaurantorContactAssignments();
        AssignmentHelper.parseContactAssignments(contacts, warrantyProvider);
        IntegerValueType duration = warranty.addNewWarrantyDuration();
        ValueHelper.assign(warrantyDuration, duration);
        duration.addNewUnitName().setStringValue(warrantyDurationUnit);
    }

    @Override
    protected void parseChildLeaves()
    {
    	if(!COBieUtility.isNA(sourceCOBie.getExpectedLife()))
    		ValueHelper.assign(sourceCOBie.getExpectedLife(), targetCOBie.addNewAssetTypeExpectedLifeValue());
    	if(!COBieUtility.isNA(sourceCOBie.getNominalHeight()))
    		ValueHelper.assign(sourceCOBie.getNominalHeight(), targetCOBie.addNewAssetTypeNominalHeight());
    	if(!COBieUtility.isNA(sourceCOBie.getNominalLength()))
    		ValueHelper.assign(sourceCOBie.getNominalLength(), targetCOBie.addNewAssetTypeNominalLength());
    	if(!COBieUtility.isNA(sourceCOBie.getNominalWidth()))
    		ValueHelper.assign(sourceCOBie.getNominalWidth(), targetCOBie.addNewAssetTypeNominalWidth());
    	if(!COBieUtility.isNA(sourceCOBie.getReplacementCost()))
    		ValueHelper.assign(sourceCOBie.getReplacementCost(), targetCOBie.addNewAssetTypeReplacementCostValue());
        try
        {
            processWarranties();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        try
        {
            processManufacturer();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        try
        {
            processAssetPortabilityText();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private void processAssetPortabilityText()
    {
        String portability = sourceCOBie.getAssetType().toUpperCase();
        AssetPortabilitySimpleType.Enum assetPortability = null;
        if(portability.equalsIgnoreCase(AssetPortabilitySimpleType.FIXED.toString()))
            assetPortability = AssetPortabilitySimpleType.FIXED;
        else if (portability.equalsIgnoreCase(AssetPortabilitySimpleType.MOVEABLE.toString()))
            assetPortability = AssetPortabilitySimpleType.MOVEABLE;
        targetCOBie.setAssetTypeAccountingCategory(assetPortability);       
    }

    @Override
    protected void parseSimpleElements()
    {
    	if(!COBieUtility.isNA(sourceCOBie.getAccessibilityPerformance()))
    		targetCOBie.setAssetTypeAccessibilityText(sourceCOBie.getAccessibilityPerformance());
    	if(!COBieUtility.isNA(sourceCOBie.getCategory()))
    		targetCOBie.setAssetTypeCategory(sourceCOBie.getCategory());
    	if(!COBieUtility.isNA(sourceCOBie.getCodePerformance()))
    		targetCOBie.setAssetTypeCodePerformance(sourceCOBie.getCodePerformance());
    	if(!COBieUtility.isNA(sourceCOBie.getColor()))
    		targetCOBie.setAssetTypeColorCode(sourceCOBie.getColor());
    	if(!COBieUtility.isNA(sourceCOBie.getConstituents()))
    		targetCOBie.setAssetTypeConstituentsDescription(sourceCOBie.getConstituents());
    	if(!COBieUtility.isNA(sourceCOBie.getDescription()))
    		targetCOBie.setAssetTypeDescription(sourceCOBie.getDescription());
    	if(!COBieUtility.isNA(sourceCOBie.getFeatures()))
    		targetCOBie.setAssetTypeFeaturesDescription(sourceCOBie.getFeatures());
    	if(!COBieUtility.isNA(sourceCOBie.getFinish()))
    		targetCOBie.setAssetTypeFinishDescription(sourceCOBie.getFinish());
    	if(!COBieUtility.isNA(sourceCOBie.getGrade()))
    		targetCOBie.setAssetTypeGradeDescription(sourceCOBie.getGrade());
    	if(!COBieUtility.isNA(sourceCOBie.getMaterial()))
    		targetCOBie.setAssetTypeMaterialDescription(sourceCOBie.getMaterial());
    	if(!COBieUtility.isNA(sourceCOBie.getModelNumber()))
    		targetCOBie.setAssetTypeModelNumber(sourceCOBie.getModelNumber());
    	if(!COBieUtility.isNA(sourceCOBie.getName()))
    		targetCOBie.setAssetTypeName(sourceCOBie.getName());
    	if(!COBieUtility.isNA(sourceCOBie.getShape()))
    		targetCOBie.setAssetTypeShapeDescription(sourceCOBie.getShape());
    	if(!COBieUtility.isNA(sourceCOBie.getSize()))
    		targetCOBie.setAssetTypeSizeDescription(sourceCOBie.getSize());
    	if(!COBieUtility.isNA(sourceCOBie.getSustainabilityPerformance()))
    		targetCOBie.setAssetTypeSustainabilityPerformanceDescription(sourceCOBie.getSustainabilityPerformance());
    	if(!COBieUtility.isNA(sourceCOBie.getExtObject()))
    		targetCOBie.setExternalEntityName(sourceCOBie.getExtObject());
    	if(!COBieUtility.isNA(sourceCOBie.getExtIdentifier()))
    		targetCOBie.setExternalID(sourceCOBie.getExtIdentifier());
    	if(!COBieUtility.isNA(sourceCOBie.getExtSystem()))
    		targetCOBie.setExternalSystemName(sourceCOBie.getExtSystem());
    }

    private void processManufacturer()
    {
        String manufacturer = sourceCOBie.getManufacturer();
        if (!COBieUtility.isNA(manufacturer))
        {
            AssignmentHelper.parseContactAssignments(targetCOBie.addNewAssetTypeManufacturerContactAssignments(), manufacturer);
        }
    }

    private void processWarranties()
    {
        List<String> warrantyStrings = new ArrayList<String>();
        String warrantyProviderLabor = sourceCOBie.getWarrantyGuarantorLabor();
        warrantyStrings.add(warrantyProviderLabor);
        String warrantyProviderParts = sourceCOBie.getWarrantyGuarantorParts();
        warrantyStrings.add(warrantyProviderParts);
        String warrantyDurationLabor = sourceCOBie.getWarrantyDurationLabor();
        warrantyStrings.add(warrantyDurationLabor);
        String warrantyDurationParts = sourceCOBie.getWarrantyDurationParts();
        warrantyStrings.add(warrantyDurationParts);
        String warrantyDurationUnit = sourceCOBie.getWarrantyDurationUnit();
        warrantyStrings.add(warrantyDurationUnit);
        String warrantyDescription = sourceCOBie.getWarrantyDescription();
        warrantyStrings.add(warrantyDescription);
        if (!COBieUtility.isNA(warrantyStrings))
        {
            WarrantyCollectionType warranties = targetCOBie.addNewWarranties();
            if (!COBieUtility.isNA(warrantyProviderLabor) || !COBieUtility.isNA(warrantyDurationLabor))
            {
                newWarranty(WARRANTY_CATEGORY_LABOR, warrantyProviderLabor, warrantyDurationLabor, warrantyDurationUnit, warranties);
                newWarranty(WARRANTY_CATEGORY_PARTS, warrantyProviderParts, warrantyDurationParts, warrantyDurationUnit, warranties);
            }
        }

    }

}
