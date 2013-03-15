package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import java.util.ArrayList;
import java.util.List;

import org.erdc.cobie.cobielite.AssetPortabilitySimpleType;
import org.erdc.cobie.cobielite.AssetTypeInfoType;
import org.erdc.cobie.cobielite.AttributeCollectionType;
import org.erdc.cobie.cobielite.ContactAssignmentCollectionType;
import org.erdc.cobie.cobielite.DocumentCollectionType;
import org.erdc.cobie.cobielite.IntegerValueType;
import org.erdc.cobie.cobielite.IssueCollectionType;
import org.erdc.cobie.cobielite.ValueHelper;
import org.erdc.cobie.cobielite.WarrantyCollectionType;
import org.erdc.cobie.cobielite.WarrantyType;
import org.erdc.cobie.cobielite.parsers.COBieLiteParserDispatcher;
import org.erdc.cobie.cobielite.parsers.TypicalParserDispatcher;
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
        return targetCOBie.addNewAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return targetCOBie.addNewDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return targetCOBie.addNewIssues();
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
        ContactAssignmentCollectionType contacts = warranty.addNewContactAssignments();
        AssignmentHelper.parseContactAssignments(contacts, warrantyProvider);
        IntegerValueType duration = warranty.addNewWarrantyDuration();
        ValueHelper.assign(warrantyDuration, duration);
        duration.setUnitName(warrantyDurationUnit);
    }

    @Override
    protected void parseChildLeaves()
    {
        ValueHelper.assign(sourceCOBie.getExpectedLife(), targetCOBie.addNewAssetTypeExpectedLifeValue());
        ValueHelper.assign(sourceCOBie.getNominalHeight(), targetCOBie.addNewAssetTypeNominalHeight());
        ValueHelper.assign(sourceCOBie.getNominalLength(), targetCOBie.addNewAssetTypeNominalLength());
        ValueHelper.assign(sourceCOBie.getNominalWidth(), targetCOBie.addNewAssetTypeNominalWidth());
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
        targetCOBie.setAssetTypePortabilityText(assetPortability);       
    }

    @Override
    protected void parseSimpleElements()
    {
        targetCOBie.setAssetTypeAccessibilityText(sourceCOBie.getAccessibilityPerformance());
        targetCOBie.setAssetTypeCategory(sourceCOBie.getCategory());
        targetCOBie.setAssetTypeCodePerformance(sourceCOBie.getCodePerformance());
        targetCOBie.setAssetTypeColorCode(sourceCOBie.getColor());
        targetCOBie.setAssetTypeConstituentsDescription(sourceCOBie.getConstituents());
        targetCOBie.setAssetTypeDescription(sourceCOBie.getDescription());
        targetCOBie.setAssetTypeFeaturesDescription(sourceCOBie.getFeatures());
        targetCOBie.setAssetTypeFinishDescription(sourceCOBie.getFinish());
        targetCOBie.setAssetTypeGradeDescription(sourceCOBie.getGrade());
        targetCOBie.setAssetTypeMaterialDescription(sourceCOBie.getMaterial());
        targetCOBie.setAssetTypeModelNumber(sourceCOBie.getModelNumber());
        targetCOBie.setAssetTypeName(sourceCOBie.getName());
        
        targetCOBie.setAssetTypeShapeDescription(sourceCOBie.getShape());
        targetCOBie.setAssetTypeSizeDescription(sourceCOBie.getSize());
        targetCOBie.setAssetTypeSustainabilityPerformanceDescription(sourceCOBie.getSustainabilityPerformance());
        targetCOBie.setExternalEntityName(sourceCOBie.getExtObject());
        targetCOBie.setExternalID(sourceCOBie.getExtIdentifier());
        targetCOBie.setExternalSystemName(sourceCOBie.getExtSystem());

    }

    private void processManufacturer()
    {
        String manufacturer = sourceCOBie.getManufacturer();
        if (!COBieUtility.isNA(manufacturer))
        {
            AssignmentHelper.parseContactAssignments(targetCOBie.addNewContactAssignments(), manufacturer);
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
