package org.erdc.cobie.shared.deserializer.sheetxmldata;

import java.util.List;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcClassificationReference;
import org.bimserver.models.ifc2x3tc1.IfcConstructionProductResource;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcObjectTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcRelAssignsToResource;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.deserializer.sheetxmldata.modelhandlers.IfcCommonHandler;
import org.erdc.cobie.shared.deserializer.sheetxmldata.modelhandlers.PropertySetHandler;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.SpareType;

public class SpareDeserializer
{
    private static final String EXCLUDE_CLASS_NAME_STRING = "Impl";
    private final String SPARE_SUPPLIERS_PROPERTY_NAME = "Suppliers";
    private final String SPARE_SETNUMBER_PROPERTY_NAME = "SetNumber";
    private final String SPARE_PARTNUMBER_PROPERTY_NAME = "PartNumber";
    private final String SPARE_PROPERTY_SET_NAME = String
            .format(PropertySetHandler.fs_COBiePropertySetName, COBieUtility.CobieSheetName.Spare.name());
    private final String SPARE_PROPERTY_SET_DESCRIPTION = String.format(PropertySetHandler.fs_COBiePropertySetDescription,
            COBieUtility.CobieSheetName.Spare.name());
    private COBieIfcModel model;
    private IfcCommonHandler ifcCommonHandler;
    private COBIEType.Spares spares;

    public SpareDeserializer(COBieIfcModel model, IfcCommonHandler ifcCommonHandler, COBIEType.Spares spares)
    {
        this.model = model;
        this.ifcCommonHandler = ifcCommonHandler;
        this.spares = spares;
    }

    private String assignsToResourceNameFromSpareAndType(SpareType spare, IfcTypeObject typeObj)
    {
        return "Assigns " + spare.getName() + " to " + typeObj.getName();
    }

    private IfcConstructionProductResource constructionProductResourceFromSpare(SpareType spare) throws Exception
    {

        IfcConstructionProductResource newResource = Ifc2x3tc1Factory.eINSTANCE.createIfcConstructionProductResource();
        try
        {
            newResource.setName(spare.getName());
            IfcOwnerHistory ownerHistory = ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(
                    spare.getCreatedBy(), spare.getCreatedOn(), spare.getExtSystem());
            newResource.setOwnerHistory(ownerHistory);

            IfcGloballyUniqueId guid = ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(spare.getExtIdentifier());
            newResource.setGlobalId(guid.getWrappedValue());
            newResource.setDescription(spare.getDescription());
            newResource.setResourceGroup(spare.getSetNumber());
            newResource.setResourceIdentifier(spare.getPartNumber());

        } catch (Exception ex)
        {
            throw ex;
        }
        return newResource;
    }

    public void deserializeSpares()
    {

        String name;
        try
        {
            if (spares != null)
            {
                for (SpareType spare : spares.getSpareArray())
                {
                    name = spare.getName();
                    if (!model.containsSpare(name))
                    {
                        IfcConstructionProductResource newSpare = constructionProductResourceFromSpare(spare);
                        IfcPropertySet sparePropertySet = sparePropertySetFromSpare(spare);
                        ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToObject(newSpare, sparePropertySet, true);
                        model.add(newSpare, ifcCommonHandler.getOidProvider());
                        List<IfcClassificationReference> classificationReferences = ifcCommonHandler.getClassificationHandler()
                                .classificationReferencesFromString(spare.getCategory());
                        for (IfcClassificationReference classificationReference : classificationReferences)
                        {
                            ifcCommonHandler.getClassificationHandler().addClassificationReferenceToObject(classificationReference, newSpare);
                        }
                        if (model.containsSpare(name))
                        {
                            IfcRelAssignsToResource relationToType = typeRelationFromSpare(spare, newSpare);
                            String relatedObjectClassName = relationToType.getRelatedObjectsType().name();
                            if (relatedObjectClassName.endsWith(EXCLUDE_CLASS_NAME_STRING))
                            {
                                relatedObjectClassName = relatedObjectClassName.substring(0, relatedObjectClassName.length()
                                        - EXCLUDE_CLASS_NAME_STRING.length() - 1);
                            }
                            newSpare.setObjectType(relatedObjectClassName);
                            model.add(relationToType, ifcCommonHandler.getOidProvider());
                            newSpare.getResourceOf().add(relationToType);

                        }
                    }
                }
            }
        } catch (Exception ex)
        {

        }
    }

    private IfcPropertySingleValue partNumberPropertyFromSpare(SpareType spare)
    {
        IfcPropertySingleValue partNumberProperty = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
        String partNumberString = spare.getPartNumber();
        partNumberProperty.setName(SPARE_PARTNUMBER_PROPERTY_NAME);
        partNumberProperty.setDescription(SPARE_PARTNUMBER_PROPERTY_NAME);
        IfcLabel partNumberLbl = Ifc2x3tc1Factory.eINSTANCE.createIfcLabel();
        partNumberLbl.setWrappedValue(partNumberString);
        partNumberProperty.setNominalValue(partNumberLbl);
        return partNumberProperty;
    }

    private IfcPropertySingleValue setNumberPropertyFromSpare(SpareType spare)
    {
        IfcPropertySingleValue setNumberProperty = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
        String setNumberString = spare.getSetNumber();
        setNumberProperty.setName(SPARE_SETNUMBER_PROPERTY_NAME);
        setNumberProperty.setDescription(SPARE_SETNUMBER_PROPERTY_NAME);
        IfcLabel setNumberLbl = Ifc2x3tc1Factory.eINSTANCE.createIfcLabel();
        setNumberLbl.setWrappedValue(setNumberString);
        setNumberProperty.setNominalValue(setNumberLbl);
        return setNumberProperty;
    }

    private IfcPropertySet sparePropertySetFromSpare(SpareType spare)
    {
        IfcPropertySet spareProperties = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySet();
        spareProperties.setName(SPARE_PROPERTY_SET_NAME);
        spareProperties.setDescription(SPARE_PROPERTY_SET_DESCRIPTION);
        IfcPropertySingleValue supplier = supplierPropertyFromSpare(spare);
        IfcPropertySingleValue partNumber = partNumberPropertyFromSpare(spare);
        IfcPropertySingleValue setNumber = setNumberPropertyFromSpare(spare);
        spareProperties.getHasProperties().add(supplier);
        spareProperties.getHasProperties().add(partNumber);
        spareProperties.getHasProperties().add(setNumber);
        return spareProperties;
    }

    private IfcPropertySingleValue supplierPropertyFromSpare(SpareType spare)
    {
        IfcPropertySingleValue supplierProperty = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
        String supplierString = spare.getSuppliers();
        supplierProperty.setName(SPARE_SUPPLIERS_PROPERTY_NAME);
        supplierProperty.setDescription(SPARE_SUPPLIERS_PROPERTY_NAME);
        IfcLabel supplierLbl = Ifc2x3tc1Factory.eINSTANCE.createIfcLabel();
        supplierLbl.setWrappedValue(supplierString);
        supplierProperty.setNominalValue(supplierLbl);
        return supplierProperty;

    }

    private IfcRelAssignsToResource typeRelationFromSpare(SpareType spare, IfcConstructionProductResource ifcResource)
    {
        IfcRelAssignsToResource spareAssignsRelation = Ifc2x3tc1Factory.eINSTANCE.createIfcRelAssignsToResource();

        String typeName = spare.getTypeName();
        if (model.containsType(typeName))
        {
            long typeOid = model.getTypeOid(typeName);
            IfcTypeObject typeObj = (IfcTypeObject)model.get(typeOid);
            String relationshipName = assignsToResourceNameFromSpareAndType(spare, typeObj);
            spareAssignsRelation.setName(relationshipName);
            spareAssignsRelation.setDescription(relationshipName);
            spareAssignsRelation.getRelatedObjects().add(typeObj);
            try
            {
                spareAssignsRelation.setRelatedObjectsType(IfcObjectTypeEnum.getByName(typeObj.getClass().getSimpleName()));
            } catch (Exception ex)
            {

            }
            spareAssignsRelation.setRelatingResource(ifcResource);
            spareAssignsRelation.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid().getWrappedValue());
            spareAssignsRelation.setOwnerHistory(ifcResource.getOwnerHistory());
        }
        return spareAssignsRelation;
    }
}
