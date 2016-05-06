package org.bimserver.cobie.shared.serialization.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bimserver.cobie.shared.deserialization.cobietab.propertysets.Pset_Warranty;
import org.bimserver.cobie.shared.serialization.IfcCobieSerializer;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.CaseInsensitiveStringList;
import org.bimserver.cobie.shared.utility.ifc.IfcRelationshipUtility;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcFurnitureType;
import org.bimserver.models.ifc2x3tc1.IfcMaterial;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSetUsage;
import org.bimserver.models.ifc2x3tc1.IfcMaterialSelect;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOrganization;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcPropertyReferenceValue;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesMaterial;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.COBIEType.Types;
import org.nibs.cobie.tab.TypeType;

import com.prairiesky.transform.cobieifc.settings.SettingsType;

public class IfcTypeToCOBieTypeSerializer extends IfcCobieSerializer<TypeType, COBIEType.Types, IfcTypeObject>
{
    public enum WarrantyType
    {
        PARTS, LABOR
    }

    public static String WARRANTY_PARTS_ID = "Parts";
    public static String WARRANTY_LABOR_ID = "Labor";
    private static final String FIXED_ASSET_TYPE_CAMELCASE = "Fixed";
    private static final String MOVEABLE_ASSET_TYPE_CAMELCASE = "Moveable";
    private static final String NONFIXED_ASSET_TYPE_LCASE = "nonfixed";
    private static final String MOVEABLE_ASSET_TYPE_LCASE = "moveable";
    public IfcTypeToCOBieTypeSerializer(Types cobieSection, IfcModelInterface model, SettingsType settings)
    {
        super(cobieSection, model, settings);
    }

    private void assignFromWarranty(WarrantyType warrantyType, Pset_Warranty warranty, TypeType newType, boolean assignOnlyOnNulls)
    {
        IfcPropertySingleValue duration = warranty.getWarrantyPeriod();
        IfcPropertyReferenceValue guarantor = warranty.getPointOfContact();

        IfcSingleValueToCOBieString durationStrings = null;
        IfcSingleValueToCOBieString warrantyDescription = null;
        try
        {
            durationStrings = new IfcSingleValueToCOBieString(duration);
        } catch (Exception ex)
        {

        }
        try
        {
            warrantyDescription = new IfcSingleValueToCOBieString(warranty.getWarrantyContent());
        } catch (Exception ex)
        {

        }

        String durationValue = (durationStrings == null ? null : durationStrings.getValueString());
        String durationUnit = (durationStrings == null ? null : durationStrings.getUnitString());
        String guarantorEmail = "";
        String existingDuration, existingGuarantor, existingDescription;
        String description = (warrantyDescription == null ? null : warrantyDescription.getValueString());
        existingDescription = newType.getWarrantyDescription();
        if ((guarantor != null) && (guarantor.getPropertyReference() != null) && (guarantor.getPropertyReference() instanceof IfcOrganization))
        {
            guarantorEmail = COBieIfcUtility.getEmailFromOrganization((IfcOrganization)guarantor.getPropertyReference());
        }
        switch (warrantyType)
        {
            case LABOR:
                if (assignOnlyOnNulls)
                {
                    existingDuration = newType.getWarrantyDurationLabor();
                    existingGuarantor = newType.getWarrantyGuarantorLabor();

                    if (COBieUtility.isNA(existingDuration))
                    {
                        newType.setWarrantyDurationLabor(durationValue);
                    }
                    if (COBieUtility.isNA(existingGuarantor))
                    {
                        newType.setWarrantyGuarantorLabor(guarantorEmail);
                    }
                } else
                {
                    newType.setWarrantyDurationLabor(durationValue);
                    newType.setWarrantyGuarantorLabor(guarantorEmail);
                }
                break;
            case PARTS:
                if (assignOnlyOnNulls)
                {
                    existingDuration = newType.getWarrantyDurationParts();
                    existingGuarantor = newType.getWarrantyGuarantorParts();
                    if (COBieUtility.isNA(existingDuration))
                    {
                        newType.setWarrantyDurationParts(durationValue);
                    }
                    if (COBieUtility.isNA(existingGuarantor))
                    {
                        newType.setWarrantyGuarantorParts(guarantorEmail);
                    }
                } else
                {
                    newType.setWarrantyDurationParts(durationValue);
                    newType.setWarrantyGuarantorParts(guarantorEmail);
                }
                break;
            default:
                break;

        }
        if (assignOnlyOnNulls)
        {
            if (COBieUtility.isNA(newType.getWarrantyDurationUnit()))
            {
                newType.setDurationUnit(durationUnit);
            }
            if (COBieUtility.isNA(existingDescription))
            {
                newType.setWarrantyDescription(existingDescription);
            }
        } else
        {
            newType.setDurationUnit(durationUnit);
            newType.setWarrantyDescription(description);
        }

    }

    private void assignWarrantyInformation(List<Pset_Warranty> psetWarranties, TypeType newType)
    {
        Pset_Warranty parts = null;
        Pset_Warranty labor = null;

        try
        {
            parts = getPartsWarranty(psetWarranties);
            assignFromWarranty(WarrantyType.PARTS, parts, newType, false);

        } catch (Exception ex)
        {

        }
        try
        {
            labor = getLaborWarranty(psetWarranties);
            assignFromWarranty(WarrantyType.LABOR, labor, newType, false);
        } catch (Exception ex)
        {

        }

        tryToAssignEmptyWarrantyFields(WarrantyType.PARTS, psetWarranties, newType);
        tryToAssignEmptyWarrantyFields(WarrantyType.LABOR, psetWarranties, newType);

    }

    private void assignWarrantyInformationByPropertyNames(IfcTypeObject type, TypeType newType, boolean assignOnlyOnNulls)
    {

        if (assignOnlyOnNulls)
        {
            if (COBieUtility.isNA(newType.getWarrantyGuarantorParts()))
            {
                newType.setWarrantyGuarantorParts(warrantyGuarantorPartsFromTypeObject(type));
            }
            if (COBieUtility.isNA(newType.getWarrantyDurationParts()))
            {
                newType.setWarrantyDurationParts(warrantyDurationPartsFromTypeObject(type));
            }
            if (COBieUtility.isNA(newType.getWarrantyGuarantorLabor()))
            {
                newType.setWarrantyGuarantorLabor(warrantyGuarantorLaborFromTypeObject(type));
            }
            if (COBieUtility.isNA(newType.getWarrantyDurationLabor()))
            {
                newType.setWarrantyDurationLabor(warrantyDurationLaborFromTypeObject(type));
            }
            if (COBieUtility.isNA(newType.getWarrantyDurationUnit()))
            {
                newType.setWarrantyDurationUnit(warrantyDurationUnitsFromTypeObject(type, model));
            }
            if (COBieUtility.isNA(newType.getWarrantyDescription()))
            {
                newType.setWarrantyDescription(warrantyDescriptionFromTypeObject(type));
            }
        } 
        else
        {
            newType.setWarrantyGuarantorParts(warrantyGuarantorPartsFromTypeObject(type));
            newType.setWarrantyDurationParts(warrantyDurationPartsFromTypeObject(type));
            newType.setWarrantyGuarantorLabor(warrantyGuarantorLaborFromTypeObject(type));
            newType.setWarrantyDurationLabor(warrantyDurationLaborFromTypeObject(type));
            newType.setWarrantyDurationUnit(warrantyDurationUnitsFromTypeObject(type, model));
            newType.setWarrantyDescription(warrantyDescriptionFromTypeObject(type));
        }
    }

    private Pset_Warranty getLaborWarranty(List<Pset_Warranty> psetWarranties) throws UnsupportedOperationException
    {
        return getWarrantyWithWarrantyIdentifierContaining(psetWarranties, WARRANTY_LABOR_ID);
    }

    private Pset_Warranty getPartsWarranty(List<Pset_Warranty> psetWarranties)
    {
        return getWarrantyWithWarrantyIdentifierContaining(psetWarranties, WARRANTY_PARTS_ID);
    }

    private List<Pset_Warranty> getPsetWarrantyPropertySets(IfcTypeObject type, TypeType newType)
    {
        List<Pset_Warranty> psetWarrantyOccurences = new ArrayList<Pset_Warranty>();
        for (IfcPropertySetDefinition propertySetDefinition : type.getHasPropertySets())
        {
            if (propertySetDefinition instanceof IfcPropertySet)
            {
                IfcPropertySet propertySet = (IfcPropertySet)propertySetDefinition;
                try
                {
                    Pset_Warranty psetWarranty = new Pset_Warranty(propertySet);
                    psetWarrantyOccurences.add(psetWarranty);
                } catch (Exception ex)
                {

                }
            }
        }
        return psetWarrantyOccurences;

    }

    @Override
    protected List<IfcTypeObject> getTopLevelModelObjects()
    {
    	//The IDM plugins are no longer supported, so filtering must occur in the serializers
    	//This partially fixes issue #12, https://github.com/opensourceBIM/COBie-plugins/issues/12
        return model.getAllWithSubTypes(IfcTypeObject.class).stream().filter
        		(p -> isAssetType(p)).collect(Collectors.toList());
    }
    
    

    private Pset_Warranty getWarrantyWithWarrantyIdentifierContaining(List<Pset_Warranty> psetWarranties, String searchString)
    {
        Pset_Warranty laborWarranty = null;
        for (Pset_Warranty warranty : psetWarranties)
        {
            IfcPropertySingleValue warrantyId = warranty.getWarrantyIdentifier();
            IfcSingleValueToCOBieString id = new IfcSingleValueToCOBieString(warrantyId);
            if (id.getValueString().toLowerCase().contains(searchString))
            {
                laborWarranty = warranty;
            }
        }
        if (laborWarranty == null)
        {
            throw new UnsupportedOperationException("No matches found for warranty with identifier containing " + searchString);
        }
        return laborWarranty;
    }

    private void handleCommonFields(IfcTypeObject type, IfcOwnerHistory oh, TypeType newType)
    {
        newType.setName(IfcTypeToCOBieTypeSerializer.nameFromTypeObject(type));
        newType.setCreatedBy(COBieIfcUtility.getEmailFromOwnerHistory(oh));
        newType.setCreatedOn(IfcToContact.getCreatedOn(oh.getCreationDate()));
        newType.setCategory(IfcTypeToCOBieTypeSerializer.categoryFromTypeObject(type));
        newType.setDescription(IfcTypeToCOBieTypeSerializer.descriptionFromTypeObject(type));
        newType.setExtSystem(COBieIfcUtility.getApplicationName(oh));
        newType.setExtObject(IfcTypeToCOBieTypeSerializer.extObjectFromTypeObject(type));
        newType.setExtIdentifier(COBieIfcUtility.identifierFromObjectDefinition(type));
    }
    
    protected static String descriptionFromTypeObject(IfcTypeObject type)
    {
        String description = "";
        description = type.getDescription();
        if ((description == null) || description.isEmpty())
        {
            description = type.getName();
        }
        return COBieUtility.getCOBieString(description);
    }
    
    protected static String extObjectFromTypeObject(IfcTypeObject type)
    {
        String className = type.getClass().getSimpleName();
        className = COBieUtility.trimImplFromClassNameString(className);
        return className;
    }
    
    protected static String nameFromTypeObject(IfcTypeObject type)
    {
        String name = "";
        if (type.isSetName() && !COBieUtility.isNA(type.getName()))
        {
            name = type.getName();
        }
        return COBieUtility.getCOBieString(name);
    }
    
    public static String categoryFromTypeObject(IfcTypeObject type)
    {
        String category = "";
        category = COBieIfcUtility.getObjectClassificationCategoryString(type);
        return COBieUtility.getCOBieString(category);
    }

    private void handleExtendedAttributes(IfcTypeObject type, TypeType newType)
    {
        newType.setNominalLength(nominalLengthFromTypeObject(type));
        newType.setNominalWidth(nominalWidthFromTypeObject(type));
        newType.setNominalHeight(nominalHeightFromTypeObject(type));
        newType.setModelReference(modelReferenceFromTypeObject(type));
        newType.setShape(shapeFromTypeObject(type));
        newType.setSize(sizeFromTypeObject(type));
        newType.setColor(colorFromTypeObject(type));
        newType.setFinish(finishFromTypeObject(type));
        newType.setGrade(gradeFromTypeObject(type));
        newType.setMaterial(materialFromTypeObject(type));
        newType.setConstituents(constituentsStringFromTypeObject(type));
        newType.setFeatures(featuresFromTypeObject(type));
        newType.setAccessibilityPerformance(accessibilityPerformanceFromTypeObject(type));
        newType.setCodePerformance(codePerformanceFromTypeObject(type));
        newType.setSustainabilityPerformance(sustainabilityPerformanceFromTypeObject(type));
    }

    private void handleManufacturerInfo(IfcTypeObject type, TypeType newType)
    {
        newType.setManufacturer(manufacturerFromTypeObject(type));
        newType.setModelNumber(modelNumberFromTypeObject(type));
    }

    private void handleServiceLife(IfcTypeObject type, TypeType newType)
    {
        newType.setReplacementCost(replacementCostFromTypeObject(type));
        newType.setExpectedLife(expectedLifeFromTypeObject(type));
        newType.setDurationUnit(durationUnitsFromTypeObject(type, model));
    }

    private void handleWarrantyFields(IfcTypeObject type, TypeType newType)
    {

        List<Pset_Warranty> psetWarranties = getPsetWarrantyPropertySets(type, newType);

        if (psetWarranties.isEmpty())
        {
            assignWarrantyInformationByPropertyNames(type, newType, false);
        } else
        {
            assignWarrantyInformation(psetWarranties, newType);
            assignWarrantyInformationByPropertyNames(type, newType, true);
        }
    }

    @Override
    protected List<TypeType> serializeModelObject(IfcTypeObject type)
    {
        List<TypeType> newTypes = new ArrayList<TypeType>();

        IfcOwnerHistory oh = type.getOwnerHistory();
        if (type != null)
        {
            TypeType newType = cobieSection.addNewType();
            handleCommonFields(type, oh, newType);
            newType.setAssetType(assetTypeFromTypeObject(type));
            handleManufacturerInfo(type, newType);
            handleWarrantyFields(type, newType);
            handleServiceLife(type, newType);
            handleExtendedAttributes(type, newType);
            newTypes.add(newType);
        }
        return newTypes;
    }

    private void tryToAssignEmptyWarrantyFields(WarrantyType warrantyType, List<Pset_Warranty> psetWarranties, TypeType newType)
    {
        for (Pset_Warranty warranty : psetWarranties)
        {
            assignFromWarranty(warrantyType, warranty, newType, true);
        }

    }
    
    protected boolean isAssetType(IfcObjectDefinition objDef)
    {
    	return IfcTypeToCOBieTypeSerializer.isAssetType(objDef, getSettings());
    }
    
    public static boolean isAssetType(IfcObjectDefinition objDef, SettingsType settings)
    {
    	
        boolean isAsset = true;
        CaseInsensitiveStringList excludeStrings = getExcludeAssetStrings(settings);
        for (@SuppressWarnings("rawtypes")
        Class iClass : objDef.getClass().getInterfaces())
        {
            if (excludeStrings.contains(iClass.getSimpleName()))
            {
                isAsset = false;
            }
        }
        return isAsset;
    }

	private static CaseInsensitiveStringList getExcludeAssetStrings(SettingsType settings) 
	{
		CaseInsensitiveStringList exclude = new CaseInsensitiveStringList(new ArrayList<String>());
		if(settings != null && settings.getTypeSettings() != null && settings.getTypeSettings().getIfcTypeExclusions() != null)
		{
			for(String name : settings.getTypeSettings().getIfcTypeExclusions().getName())
			{
				exclude.add(name.trim());
			}
		}
		return exclude;
	}

    protected String warrantyGuarantorPartsFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getWarrantyGuarantorPartsStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }
    
    private String getTypePropertySearchResult(IfcTypeObject type, ArrayList<String> typePNames)
    {
        return IfcRelationshipUtility.getHighestRankingPropertyStringFromPropertySets(type.getHasPropertySets(), typePNames);
    }

	private ArrayList<String> getWarrantyGuarantorPartsStrings() 
	{
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getWarrantyGuarantorPartsPropertyNames() != null &&
				getSettings().getTypeSettings().getWarrantyGuarantorPartsPropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getWarrantyGuarantorPartsPropertyNames().getName());
		}
		return propertyNames;
	}
	
    private ArrayList<String> getWarrantyDurationPartsStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getWarrantyDurationPartsPropertyNames() != null &&
				getSettings().getTypeSettings().getWarrantyDurationPartsPropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getWarrantyDurationPartsPropertyNames().getName());
		}
		return propertyNames;
    }
    
    protected String warrantyDurationPartsFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getWarrantyDurationPartsStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }
    
    protected String warrantyGuarantorLaborFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getWarrantyGuarantorLaborStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }
    
    private ArrayList<String> getWarrantyGuarantorLaborStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getWarrantyGuarantorLaborPropertyNames() != null &&
				getSettings().getTypeSettings().getWarrantyGuarantorLaborPropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getWarrantyGuarantorLaborPropertyNames().getName());
		}
		return propertyNames;
    }
    
    protected String warrantyDurationLaborFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getWarrantyDurationLaborStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }
    
    private ArrayList<String> getWarrantyDurationLaborStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getWarrantyDurationLaborPropertyNames() != null &&
				getSettings().getTypeSettings().getWarrantyDurationLaborPropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getWarrantyDurationLaborPropertyNames().getName());
		}
		return propertyNames;
    }
    
    protected  String warrantyDurationUnitsFromTypeObject(IfcTypeObject type, IfcModelInterface model)
    {
        IfcPropertyStringTransformer pString;
        String durationUnit = "";
        Map<String, IfcPropertyStringTransformer> valMap = new HashMap<String, IfcPropertyStringTransformer>();
        ArrayList<String> typePNames = getWarrantyDurationLaborStrings();
        valMap = IfcRelationshipUtility.psetStringsFromTypeObject(type, typePNames, false);
        pString = COBieIfcUtility.cobiePsetStringFromStringMap(valMap, typePNames);
        if (pString == null)
        {
            typePNames = getWarrantyDurationPartsStrings();
            valMap = IfcRelationshipUtility.psetStringsFromTypeObject(type, typePNames, false);
            pString = COBieIfcUtility.cobiePsetStringFromStringMapAllowNA(valMap, typePNames);
        }
        if ((pString != null) && (pString instanceof IfcSingleValueToCOBieString))
        {
            durationUnit = ((IfcSingleValueToCOBieString)pString).getUnitString();
        }
        if (COBieUtility.isNA(durationUnit))
        {
            durationUnit = COBieIfcUtility.getFirstNamedUnitStringInProjectContext(model, IfcUnitEnum.TIMEUNIT);
        }
        return COBieUtility.getCOBieString(durationUnit);
    }
    
    protected String warrantyDescriptionFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getWarrantyDescriptionStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }
    
    private ArrayList<String> getWarrantyDescriptionStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getWarrantyDescriptionPropertyNames() != null &&
				getSettings().getTypeSettings().getWarrantyDescriptionPropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getWarrantyDescriptionPropertyNames().getName());
		}
		return propertyNames;
    }
    
    protected String nominalHeightFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getNominalHeightStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected String nominalLengthFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getNominalLengthStrings();
        pString = getTypePropertySearchResult(type, typePNames);
        return COBieUtility.getCOBieString(pString);
    }

    protected String nominalWidthFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getNominalWidthStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected String replacementCostFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getReplacementCostStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected String shapeFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getShapeStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected String sizeFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getSizeStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected String sustainabilityPerformanceFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getSustainabilityPerformanceStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }
    
    private  ArrayList<String> getMaterialStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getMaterialPropertyNames() != null &&
				getSettings().getTypeSettings().getMaterialPropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getMaterialPropertyNames().getName());
		}
		return propertyNames;
    }

    private ArrayList<String> getModelNumberStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getModelNumberPropertyNames() != null &&
				getSettings().getTypeSettings().getModelNumberPropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getModelNumberPropertyNames().getName());
		}
		return propertyNames;
    }

    private ArrayList<String> getModelReferenceStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getModelReferencePropertyNames() != null &&
				getSettings().getTypeSettings().getModelReferencePropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getModelReferencePropertyNames().getName());
		}
		return propertyNames;
    }

    private ArrayList<String> getNominalHeightStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getNominalHeightPropertyNames() != null &&
				getSettings().getTypeSettings().getNominalHeightPropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getNominalHeightPropertyNames().getName());
		}
		return propertyNames;
    }

    private ArrayList<String> getNominalLengthStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getNominalLengthPropertyNames() != null &&
				getSettings().getTypeSettings().getNominalLengthPropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getNominalLengthPropertyNames().getName());
		}
		return propertyNames;
    }

    private ArrayList<String> getNominalWidthStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getNominalWidthPropertyNames() != null &&
				getSettings().getTypeSettings().getNominalWidthPropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getNominalWidthPropertyNames().getName());
		}
		return propertyNames;
    }

    private ArrayList<String> getReplacementCostStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getReplacementCostPropertyNames() != null &&
				getSettings().getTypeSettings().getReplacementCostPropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getReplacementCostPropertyNames().getName());
		}
		return propertyNames;
    }

    private ArrayList<String> getShapeStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getShapePropertyNames() != null &&
				getSettings().getTypeSettings().getShapePropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getShapePropertyNames().getName());
		}
		return propertyNames;
    }

    private ArrayList<String> getSizeStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getSizePropertyNames() != null &&
				getSettings().getTypeSettings().getSizePropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getSizePropertyNames().getName());
		}
		return propertyNames;
    }

    private ArrayList<String> getSustainabilityPerformanceStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getSustainabilityPerformancePropertyNames() != null &&
				getSettings().getTypeSettings().getSustainabilityPerformancePropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getSustainabilityPerformancePropertyNames().getName());
		}
		return propertyNames;
    }
    
    protected String codePerformanceFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getCodePerformanceStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected String colorFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getColorStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected String constituentsStringFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getConstituentsString();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }
    
    private  ArrayList<String> getCodePerformanceStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getCodePerformancePropertyNames() != null &&
				getSettings().getTypeSettings().getCodePerformancePropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getCodePerformancePropertyNames().getName());
		}
		return propertyNames;
    }

    private ArrayList<String> getColorStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getColorPropertyNames() != null &&
				getSettings().getTypeSettings().getColorPropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getColorPropertyNames().getName());
		}
		return propertyNames;
    }

    private ArrayList<String> getConstituentsString()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getConstituentsPropertyNames() != null &&
				getSettings().getTypeSettings().getConstituentsPropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getConstituentsPropertyNames().getName());
		}
		return propertyNames;
    }
    
    protected String expectedLifeFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getExpectedLifeStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }



    protected String featuresFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getFeaturesStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }

    protected String finishFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getFinishStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }
    
    private ArrayList<String> getExpectedLifeStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getExpectedLifePropertyNames() != null &&
				getSettings().getTypeSettings().getExpectedLifePropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getExpectedLifePropertyNames().getName());
		}
		return propertyNames;
    }

    private ArrayList<String> getFeaturesStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getFeaturesPropertyNames() != null &&
				getSettings().getTypeSettings().getFeaturesPropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getFeaturesPropertyNames().getName());
		}
		return propertyNames;
    }

    private ArrayList<String> getFinishStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getFinishPropertyNames() != null &&
				getSettings().getTypeSettings().getFinishPropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getFinishPropertyNames().getName());
		}
		return propertyNames;
    }
    
    protected String gradeFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getGradeStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }
    
    private ArrayList<String> getGradeStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getGradePropertyNames() != null &&
				getSettings().getTypeSettings().getGradePropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getGradePropertyNames().getName());
		}
		return propertyNames;
    }
    
    protected String materialFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getMaterialStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }
    
    protected String accessibilityPerformanceFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getAccessibilityPerformanceStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }
    
    private ArrayList<String> getAccessibilityPerformanceStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getAccessibilityPerformancePropertyNames() != null &&
				getSettings().getTypeSettings().getAccessibilityPerformancePropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getAccessibilityPerformancePropertyNames().getName());
		}
		return propertyNames;
    }
    
    private ArrayList<String> getManufacturerStrings()
    {
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getManufacturerPropertyNames() != null &&
				getSettings().getTypeSettings().getManufacturerPropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getManufacturerPropertyNames().getName());
		}
		return propertyNames;
    }
    
    protected String manufacturerFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getManufacturerStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }
    
    protected String durationUnitsFromTypeObject(IfcTypeObject type, IfcModelInterface model)
    {
        IfcPropertyStringTransformer propertyCOBieString;
        String durationUnit = "";
        Map<String, IfcPropertyStringTransformer> valMap = new HashMap<String, IfcPropertyStringTransformer>();
        ArrayList<String> expectedLifePropertyStrings = getExpectedLifeStrings();
        valMap = IfcRelationshipUtility.psetStringsFromTypeObject(type, expectedLifePropertyStrings, false);
        propertyCOBieString = COBieIfcUtility.cobiePsetStringFromStringMapAllowNA(valMap, expectedLifePropertyStrings);
        if ((propertyCOBieString != null) && (propertyCOBieString instanceof IfcSingleValueToCOBieString))
        {
            durationUnit = ((IfcSingleValueToCOBieString)propertyCOBieString).getUnitString();
        }
        if (COBieUtility.isNA(durationUnit))
        {
            durationUnit = COBieIfcUtility.getFirstNamedUnitStringInProjectContext(model, IfcUnitEnum.TIMEUNIT);
        }
        return COBieUtility.getCOBieString(durationUnit);
    }
    
    protected String modelNumberFromTypeObject(IfcTypeObject type)
    {
        String pString;

        new HashMap<String, String>();
        ArrayList<String> typePNames = getModelNumberStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }
    
    protected String assetTypeFromTypeObject(IfcTypeObject type)
    {
        String assetType = "";
        new HashMap<String, String>();
        ArrayList<String> assetTypePNames = getAssetTypeStrings();
        assetType = getTypePropertySearchResult(type, assetTypePNames);
        if (assetType.toLowerCase().trim().equals(MOVEABLE_ASSET_TYPE_LCASE) || assetType.toLowerCase().trim().equals(NONFIXED_ASSET_TYPE_LCASE))
        {
            assetType = MOVEABLE_ASSET_TYPE_CAMELCASE;
        } else if (assetType.toLowerCase().trim().equals("fixed"))
        {
            assetType = FIXED_ASSET_TYPE_CAMELCASE;
        }

        if ((type instanceof IfcFurnitureType) && assetType.isEmpty())
        {
            assetType = MOVEABLE_ASSET_TYPE_CAMELCASE;
        }

        return COBieUtility.getCOBieString(assetType);
    }

	private ArrayList<String> getAssetTypeStrings() 
	{
		ArrayList<String> propertyNames = new ArrayList<>();
		if(getSettings() != null && getSettings().getTypeSettings() != null &&
				getSettings().getTypeSettings().getAssetTypePropertyNames() != null &&
				getSettings().getTypeSettings().getAssetTypePropertyNames().getName() != null)
		{
			propertyNames.addAll(getSettings().getTypeSettings().getAssetTypePropertyNames().getName());
		}
		return propertyNames;
	}
	
    protected String modelReferenceFromTypeObject(IfcTypeObject type)
    {
        String pString;

        ArrayList<String> typePNames = getModelReferenceStrings();
        pString = getTypePropertySearchResult(type, typePNames);

        return COBieUtility.getCOBieString(pString);
    }
    
    public static ArrayList<IfcRelDefinesByType> getCandidateRelDefinesByTypes(IfcModelInterface model, SettingsType settings)
    {
        String name;
        ArrayList<String> selectedTypes = new ArrayList<String>();
        ArrayList<IfcRelDefinesByType> relTypes = new ArrayList<IfcRelDefinesByType>();
        for (IfcRelDefinesByType defByType : model.getAll(IfcRelDefinesByType.class))
        {
            try
            {
                IfcTypeObject type = defByType.getRelatingType();
                name = IfcTypeToCOBieTypeSerializer.nameFromTypeObject(type);
                if (!selectedTypes.contains(name) && IfcTypeToCOBieTypeSerializer.isAssetType(type, settings))
                {
                	relTypes.add(defByType);
                }
            } catch (Exception e)
            {
            }
        }
        return relTypes;
    }
    
    protected static IfcMaterialSelect getMaterialOrMaterialLayerSet(IfcRelAssociatesMaterial matAssoc)
    {
        IfcMaterialSelect returnSel = null;
        IfcMaterialSelect matSel = matAssoc.getRelatingMaterial();
        if ((matSel instanceof IfcMaterialLayerSet) || (matSel instanceof IfcMaterial))
        {
            returnSel = matSel;
        }
        if (matSel instanceof IfcMaterialLayerSetUsage)
        {
            IfcMaterialLayerSetUsage usg = (IfcMaterialLayerSetUsage)matSel;
            returnSel = usg.getForLayerSet();
        }
        return returnSel;
    }
    
    protected static String nameFromMaterialSelect(IfcMaterialSelect materialSelect)
    {
        String name = "";
        if (materialSelect != null)
        {
            if (materialSelect instanceof IfcMaterial)
            {
                IfcMaterial material = (IfcMaterial)materialSelect;
                name = material.getName();
            } else if (materialSelect instanceof IfcMaterialLayerSet)
            {
                IfcMaterialLayerSet materialLayer = (IfcMaterialLayerSet)materialSelect;
                name = materialLayer.getLayerSetName();
            }
        }

        return COBieUtility.getCOBieString(name);
    }

}
