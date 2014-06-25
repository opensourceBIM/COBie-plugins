package org.erdc.cobie.utils.serializer.sheetserializers;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcOrganization;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcPropertyReferenceValue;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.deserializer.sheetxmldata.propertysets.Pset_Warranty;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.COBIEType.Types;
import org.erdc.cobie.sheetxmldata.TypeType;
import org.erdc.cobie.utils.serializer.IfcCOBieSerializer;
import org.erdc.cobie.utils.stringwriters.IfcSingleValueToCOBieString;

public class IfcTypeToCOBieTypeSerializer extends IfcCOBieSerializer<TypeType, COBIEType.Types, IfcTypeObject>
{
	private boolean ignoreNonAssets = false;
    public enum WarrantyType
    {
        PARTS, LABOR
    }

    public static String WARRANTY_PARTS_ID = "Parts";
    public static String WARRANTY_LABOR_ID = "Labor";

    public IfcTypeToCOBieTypeSerializer(Types cobieSection, IfcModelInterface model)
    {
        super(cobieSection, model);
    }
    
    public IfcTypeToCOBieTypeSerializer(Types cobieSection, IfcModelInterface model, boolean ignoreNonAssets)
    {
    	this(cobieSection, model);
    	this.ignoreNonAssets = ignoreNonAssets;
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
            guarantorEmail = COBieUtility.getEmailFromOrganization((IfcOrganization)guarantor.getPropertyReference());
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
                newType.setWarrantyGuarantorParts(IfcToType.warrantyGuarantorPartsFromTypeObject(type));
            }
            if (COBieUtility.isNA(newType.getWarrantyDurationParts()))
            {
                newType.setWarrantyDurationParts(IfcToType.warrantyDurationPartsFromTypeObject(type));
            }
            if (COBieUtility.isNA(newType.getWarrantyGuarantorLabor()))
            {
                newType.setWarrantyGuarantorLabor(IfcToType.warrantyGuarantorLaborFromTypeObject(type));
            }
            if (COBieUtility.isNA(newType.getWarrantyDurationLabor()))
            {
                newType.setWarrantyDurationLabor(IfcToType.warrantyDurationLaborFromTypeObject(type));
            }
            if (COBieUtility.isNA(newType.getWarrantyDurationUnit()))
            {
                newType.setWarrantyDurationUnit(IfcToType.warrantyDurationUnitsFromTypeObject(type, model));
            }
            if (COBieUtility.isNA(newType.getWarrantyDescription()))
            {
                newType.setWarrantyDescription(IfcToType.warrantyDescriptionFromTypeObject(type));
            }
        } else
        {
            newType.setWarrantyGuarantorParts(IfcToType.warrantyGuarantorPartsFromTypeObject(type));
            newType.setWarrantyDurationParts(IfcToType.warrantyDurationPartsFromTypeObject(type));
            newType.setWarrantyGuarantorLabor(IfcToType.warrantyGuarantorLaborFromTypeObject(type));
            newType.setWarrantyDurationLabor(IfcToType.warrantyDurationLaborFromTypeObject(type));
            newType.setWarrantyDurationUnit(IfcToType.warrantyDurationUnitsFromTypeObject(type, model));
            newType.setWarrantyDescription(IfcToType.warrantyDescriptionFromTypeObject(type));
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
        return model.getAllWithSubTypes(IfcTypeObject.class);
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
        newType.setName(IfcToType.nameFromTypeObject(type));
        newType.setCreatedBy(COBieUtility.getEmailFromOwnerHistory(oh));
        newType.setCreatedOn(IfcToContact.getCreatedOn(oh.getCreationDate()));
        newType.setCategory(IfcToType.categoryFromTypeObject(type));
        newType.setDescription(IfcToType.descriptionFromTypeObject(type));
        newType.setExtSystem(COBieUtility.getApplicationName(oh));
        newType.setExtObject(IfcToType.extObjectFromTypeObject(type));
        newType.setExtIdentifier(COBieUtility.identifierFromObjectDefinition(type));
    }

    private void handleExtendedAttributes(IfcTypeObject type, TypeType newType)
    {
        newType.setNominalLength(IfcToType.nominalLengthFromTypeObject(type));
        newType.setNominalWidth(IfcToType.nominalWidthFromTypeObject(type));
        newType.setNominalHeight(IfcToType.nominalHeightFromTypeObject(type));
        newType.setModelReference(IfcToType.modelReferenceFromTypeObject(type));
        newType.setShape(IfcToType.shapeFromTypeObject(type));
        newType.setSize(IfcToType.sizeFromTypeObject(type));
        newType.setColor(IfcToType.colorFromTypeObject(type));
        newType.setFinish(IfcToType.finishFromTypeObject(type));
        newType.setGrade(IfcToType.gradeFromTypeObject(type));
        newType.setMaterial(IfcToType.materialFromTypeObject(type));
        newType.setConstituents(IfcToType.constituentsStringFromTypeObject(type));
        newType.setFeatures(IfcToType.featuresFromTypeObject(type));
        newType.setAccessibilityPerformance(IfcToType.accessibilityPerformanceFromTypeObject(type));
        newType.setCodePerformance(IfcToType.codePerformanceFromTypeObject(type));
        newType.setSustainabilityPerformance(IfcToType.sustainabilityPerformanceFromTypeObject(type));
    }

    private void handleManufacturerInfo(IfcTypeObject type, TypeType newType)
    {
        newType.setManufacturer(IfcToType.manufacturerFromTypeObject(type));
        newType.setModelNumber(IfcToType.modelNumberFromTypeObject(type));
    }

    private void handleServiceLife(IfcTypeObject type, TypeType newType)
    {
        newType.setReplacementCost(IfcToType.replacementCostFromTypeObject(type));
        newType.setExpectedLife(IfcToType.expectedLifeFromTypeObject(type));
        newType.setDurationUnit(IfcToType.durationUnitsFromTypeObject(type, model));
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
        if (type != null && (!ignoreNonAssets || IfcToType.isAssetType(type)))
        {
            TypeType newType = cobieSection.addNewType();
            handleCommonFields(type, oh, newType);
            newType.setAssetType(IfcToType.assetTypeFromTypeObject(type));
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

}
