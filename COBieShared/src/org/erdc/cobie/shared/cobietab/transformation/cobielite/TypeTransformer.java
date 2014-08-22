package org.erdc.cobie.shared.cobietab.transformation.cobielite;

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
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;
import org.erdc.cobie.shared.cobietab.TypeAssemblyIndex;
import org.erdc.cobie.sheetxmldata.TypeType;

public class TypeTransformer extends ParentTransformer<TypeType, AssetTypeInfoType>
{

    private static final String WARRANTY_CATEGORY_LABOR = "Labor";
    private static final String WARRANTY_CATEGORY_PARTS = "Parts";

    public TypeTransformer(TypeType cobieSheetXMLData, AssetTypeInfoType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected ArrayList<COBieLiteParserDispatcher> getChildParsingDispatchers()
    {
        ArrayList<COBieLiteParserDispatcher> parserDispatchers = new ArrayList<COBieLiteParserDispatcher>();
        TypeAssemblyIndex typeAssemblies = indexedCOBie.getTypeAssemblies();
        parserDispatchers.add(new AssetTypeAssemblyDispatcher(typeAssemblies.get(source.getName()), target, indexedCOBie));
        parserDispatchers.add(new AssetTypeAssetDispatcher(indexedCOBie.getTypeComponents().get(source.getName()), target, indexedCOBie));
        parserDispatchers.add(new AssetTypeJobDispatcher(indexedCOBie.getTypeJobs().get(source.getName()), target, indexedCOBie));
        parserDispatchers.add(new AssetTypeSpareDispatcher(indexedCOBie.getTypeSpares().get(source.getName()), target, indexedCOBie));
        return parserDispatchers;
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return target.addNewAssetTypeAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return target.addNewAssetTypeDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return target.addNewAssetTypeIssues();
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
    	if(!COBieUtility.isNA(source.getExpectedLife()))
    		ValueHelper.assign(source.getExpectedLife(), target.addNewAssetTypeExpectedLifeValue());
    	if(!COBieUtility.isNA(source.getNominalHeight()))
    		ValueHelper.assign(source.getNominalHeight(), target.addNewAssetTypeNominalHeight());
    	if(!COBieUtility.isNA(source.getNominalLength()))
    		ValueHelper.assign(source.getNominalLength(), target.addNewAssetTypeNominalLength());
    	if(!COBieUtility.isNA(source.getNominalWidth()))
    		ValueHelper.assign(source.getNominalWidth(), target.addNewAssetTypeNominalWidth());
    	if(!COBieUtility.isNA(source.getReplacementCost()))
    		ValueHelper.assign(source.getReplacementCost(), target.addNewAssetTypeReplacementCostValue());
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
        String portability = source.getAssetType().toUpperCase();
        AssetPortabilitySimpleType.Enum assetPortability = null;
        if(portability.equalsIgnoreCase(AssetPortabilitySimpleType.FIXED.toString()))
            assetPortability = AssetPortabilitySimpleType.FIXED;
        else if (portability.equalsIgnoreCase(AssetPortabilitySimpleType.MOVEABLE.toString()))
            assetPortability = AssetPortabilitySimpleType.MOVEABLE;
        target.setAssetTypeAccountingCategory(assetPortability);       
    }

    @Override
    protected void parseSimpleElements()
    {
    	if(!COBieUtility.isNA(source.getAccessibilityPerformance()))
    		target.setAssetTypeAccessibilityText(source.getAccessibilityPerformance());
    	if(!COBieUtility.isNA(source.getCategory()))
    		target.setAssetTypeCategory(source.getCategory());
    	if(!COBieUtility.isNA(source.getCodePerformance()))
    		target.setAssetTypeCodePerformance(source.getCodePerformance());
    	if(!COBieUtility.isNA(source.getColor()))
    		target.setAssetTypeColorCode(source.getColor());
    	if(!COBieUtility.isNA(source.getConstituents()))
    		target.setAssetTypeConstituentsDescription(source.getConstituents());
    	if(!COBieUtility.isNA(source.getDescription()))
    		target.setAssetTypeDescription(source.getDescription());
    	if(!COBieUtility.isNA(source.getFeatures()))
    		target.setAssetTypeFeaturesDescription(source.getFeatures());
    	if(!COBieUtility.isNA(source.getFinish()))
    		target.setAssetTypeFinishDescription(source.getFinish());
    	if(!COBieUtility.isNA(source.getGrade()))
    		target.setAssetTypeGradeDescription(source.getGrade());
    	if(!COBieUtility.isNA(source.getMaterial()))
    		target.setAssetTypeMaterialDescription(source.getMaterial());
    	if(!COBieUtility.isNA(source.getModelNumber()))
    		target.setAssetTypeModelNumber(source.getModelNumber());
    	if(!COBieUtility.isNA(source.getName()))
    		target.setAssetTypeName(source.getName());
    	if(!COBieUtility.isNA(source.getShape()))
    		target.setAssetTypeShapeDescription(source.getShape());
    	if(!COBieUtility.isNA(source.getSize()))
    		target.setAssetTypeSizeDescription(source.getSize());
    	if(!COBieUtility.isNA(source.getSustainabilityPerformance()))
    		target.setAssetTypeSustainabilityPerformanceDescription(source.getSustainabilityPerformance());
    	if(!COBieUtility.isNA(source.getExtObject()))
    		target.setExternalEntityName(source.getExtObject());
    	if(!COBieUtility.isNA(source.getExtIdentifier()))
    		target.setExternalID(source.getExtIdentifier());
    	if(!COBieUtility.isNA(source.getExtSystem()))
    		target.setExternalSystemName(source.getExtSystem());
    }

    private void processManufacturer()
    {
        String manufacturer = source.getManufacturer();
        if (!COBieUtility.isNA(manufacturer))
        {
            AssignmentHelper.parseContactAssignments(target.addNewAssetTypeManufacturerContactAssignments(), manufacturer);
        }
    }

    private void processWarranties()
    {
        List<String> warrantyStrings = new ArrayList<String>();
        String warrantyProviderLabor = source.getWarrantyGuarantorLabor();
        warrantyStrings.add(warrantyProviderLabor);
        String warrantyProviderParts = source.getWarrantyGuarantorParts();
        warrantyStrings.add(warrantyProviderParts);
        String warrantyDurationLabor = source.getWarrantyDurationLabor();
        warrantyStrings.add(warrantyDurationLabor);
        String warrantyDurationParts = source.getWarrantyDurationParts();
        warrantyStrings.add(warrantyDurationParts);
        String warrantyDurationUnit = source.getWarrantyDurationUnit();
        warrantyStrings.add(warrantyDurationUnit);
        String warrantyDescription = source.getWarrantyDescription();
        warrantyStrings.add(warrantyDescription);
        if (!COBieUtility.isNA(warrantyStrings))
        {
            WarrantyCollectionType warranties = target.addNewWarranties();
            if (!COBieUtility.isNA(warrantyProviderLabor) || !COBieUtility.isNA(warrantyDurationLabor))
            {
                newWarranty(WARRANTY_CATEGORY_LABOR, warrantyProviderLabor, warrantyDurationLabor, warrantyDurationUnit, warranties);
                newWarranty(WARRANTY_CATEGORY_PARTS, warrantyProviderParts, warrantyDurationParts, warrantyDurationUnit, warranties);
            }
        }

    }

}
