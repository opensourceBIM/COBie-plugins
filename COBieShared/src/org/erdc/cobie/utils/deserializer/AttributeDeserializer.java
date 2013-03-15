package org.erdc.cobie.utils.deserializer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcClassificationReference;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertyEnumeratedValue;
import org.bimserver.models.ifc2x3tc1.IfcPropertyEnumeration;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.shared.CaseAgnosticStringList;
import org.erdc.cobie.shared.GuidCompressor;
import org.erdc.cobie.shared.keyedcobiesheetxml.KeyedAttributeType;
import org.erdc.cobie.sheetxmldata.AttributeType;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.utils.deserializer.modelhandlers.IfcCommonHandler;
import org.erdc.cobie.utils.deserializer.propertysets.PropertyUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AttributeDeserializer
{
    private static final int NULL_OID = -1;
    private static final Logger LOGGER = LoggerFactory.getLogger(AttributeDeserializer.class);

    private static String getEnumerationNameFromAttribute(AttributeType attribute)
    {
        return attribute.getName() + "_" + attribute.getSheetName() + "_Enumeration";
    }

    private COBIEType.Attributes attributes;
    private IfcCommonHandler ifcCommonHandler;
    private HashMap<KeyedAttributeType, Long> attributesAddedToPropertySetOid;

    private COBieIfcModel model;
    public static final String ENUM_UNSET_DEFAULT_VALUE = "UNSET";

    public AttributeDeserializer(COBieIfcModel cobieIfcModel, IfcCommonHandler ifcCommonHandler, COBIEType.Attributes attributes)
    {
        model = cobieIfcModel;
        this.ifcCommonHandler = ifcCommonHandler;
        this.attributes = attributes;
        setAttributesAddedToOid(new HashMap<KeyedAttributeType, Long>());
    }

    private void addEnumerationToModel(AttributeType attribute, IfcPropertyEnumeratedValue enumValue)
    {
        try
        {
            if (!enumValue.isSetEnumerationReference())
            {
                IfcPropertyEnumeration enumeration = ifcCommonHandler.getPropertySetHandler().enumerationFromNameAndValues(
                        getEnumerationNameFromAttribute(attribute), attribute.getAllowedValues(), "");
                enumValue.setEnumerationReference(enumeration);
            } else
            {
                model.add(enumValue.getEnumerationReference(), ifcCommonHandler.getOidProvider());
            }

        } catch (Exception e)
        {

        }
    }

    public IfcProperty addNewPropertyToPropertySet(AttributeType attribute, IfcPropertySet pSet)
    {
        IfcProperty newProperty = null;
        try
        {
            newProperty = propertyFromAttribute(attribute);
            pSet.getHasProperties().add(newProperty);

        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            LOGGER.error("", e);
        }
        return newProperty;
    }

    private long assignPropertySetToObject(IfcPropertySet pSet, AttributeType attribute, long relatedObjectOid) throws Exception
    {
        IdEObject ideObj = model.get(relatedObjectOid);
        long propertySetOid = NULL_OID;
        if (ideObj instanceof IfcObject)
        {
            IfcObject ifcObj = (IfcObject)ideObj;
            propertySetOid = ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToObject(ifcObj, pSet, false);
        } else if (ideObj instanceof IfcTypeObject)
        {
            IfcTypeObject ifcType = (IfcTypeObject)ideObj;
            propertySetOid = ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToTypeObject(ifcType, pSet, false);
        }
        return propertySetOid;
    }

    public List<IfcClassificationReference> classificationReferencesFromAttribute(AttributeType attribute)
    {
        return ifcCommonHandler.getClassificationHandler().classificationReferencesFromString(attribute.getCategory());
    }

    private void deserializeAttribute(AttributeType attribute) throws Exception
    {
        IfcPropertySet pSet;
        long relatedObjectOid;
        relatedObjectOid = objectOidFromAttribute(attribute);
        pSet = propertySetFromAttribute(attribute, relatedObjectOid);
        long propertySetOid = assignPropertySetToObject(pSet, attribute, relatedObjectOid);
        attributesAddedToPropertySetOid.put(new KeyedAttributeType(attribute), propertySetOid);

    }

    public void deserializeAttributes()
    {

        if (attributes != null)
        {
            int i = 0;
            for (AttributeType attribute : attributes.getAttributeArray())
            {
                if (shouldAddAttribute(attribute))
                {
                    try
                    {
                        i++;
                        deserializeAttribute(attribute);
                    } catch (Exception e)
                    {
                    }
                }
            }
        }
    }

    private IfcPropertyEnumeratedValue enumeratedValueFromString(
            String cobieValueString,
            String cobieAllowedValsString,
            String propertyName,
            String propertyDescription) throws Exception
    {
        String exceptionMsg = PropertyUtility.getAllowedValueExceptionMessage();
        Exception exception = new Exception(exceptionMsg);
        IfcPropertyEnumeratedValue enumeratedValue = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertyEnumeratedValue();
        IfcPropertyEnumeration enumeration = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertyEnumeration();
        enumeratedValue.setName(propertyName);
        enumeratedValue.setDescription(propertyDescription);
        enumeration.setName(propertyName + PropertyUtility.getEnumerationNameSuffix());
        if (COBieUtility.isNA(cobieAllowedValsString))
        {
            throw exception;
        }
        String[] splitAllowedVals = cobieAllowedValsString.split(COBieUtility.getCOBieDelim());
        for (int i = 0; i < splitAllowedVals.length; i++)
        {
            splitAllowedVals[i] = splitAllowedVals[i].trim();
        }
        ArrayList<String> allowedValsList = PropertyUtility.delimStringToArrayList(cobieAllowedValsString);
        CaseAgnosticStringList caseAgnosticAllowedValues = new CaseAgnosticStringList(allowedValsList);
        if (COBieUtility.isNA(cobieValueString))
        {
            cobieValueString = String.valueOf(AttributeDeserializer.ENUM_UNSET_DEFAULT_VALUE);
        }
        ArrayList<String> valuesStrings;
        if (cobieValueString.contains(COBieUtility.getCOBieDelim()))
        {
            ArrayList<Integer> matchingValuesIndices = new ArrayList<Integer>();
            valuesStrings = PropertyUtility.delimStringToArrayList(cobieValueString);
            for (String valueString : valuesStrings)
            {
                if (!caseAgnosticAllowedValues.contains(valueString))
                {
                    caseAgnosticAllowedValues.add(valueString);
                } else
                {
                    matchingValuesIndices.add(valuesStrings.indexOf(valueString));
                }

            }
            for (int index : matchingValuesIndices)
            {
                valuesStrings.set(index, caseAgnosticAllowedValues.get(caseAgnosticAllowedValues.indexOf(valuesStrings.get(index))));
            }
            cobieValueString = COBieUtility.delimittedStringFromArrayList(valuesStrings);
        } else if (!caseAgnosticAllowedValues.contains(cobieValueString))
        {
            caseAgnosticAllowedValues.add(cobieValueString);
            cobieValueString = caseAgnosticAllowedValues.get(caseAgnosticAllowedValues.indexOf(cobieValueString));
        } else
        {
            cobieValueString = caseAgnosticAllowedValues.get(caseAgnosticAllowedValues.indexOf(cobieValueString));
        }
        try
        {

            PropertyUtility.populateEnumeration(enumeration, caseAgnosticAllowedValues);
            if (!model.containsEnumeration(enumeration.getName()))
            {
                model.add(enumeration, ifcCommonHandler.getOidProvider());
            } else
            {
                enumeration = (IfcPropertyEnumeration)model.get(model.getEnumerationOid(enumeration.getName()));
            }
            enumeratedValue.setEnumerationReference(enumeration);
            PropertyUtility.popoulateEnumerationValues(enumeratedValue, cobieValueString, caseAgnosticAllowedValues);
        } catch (Exception e)
        {
            throw e;
        }
        return enumeratedValue;
    }

    private long getAttributeExistingPropertySetOid(AttributeType attribute)
    {
        attribute.getName();
        String attributeSheet = attribute.getSheetName();
        String attributeRow = attribute.getRowName();
        String attributePsetName = guessPropertySetName(attribute);
        long existingOid = NULL_OID;
        if (attributesAddedToPropertySetOid.containsKey(new KeyedAttributeType(attribute)))
        {
            existingOid = attributesAddedToPropertySetOid.get(new KeyedAttributeType(attribute));
        } else
        {
            for (KeyedAttributeType keyedAttribute : attributesAddedToPropertySetOid.keySet())
            {
                AttributeType tmpAttribute = keyedAttribute.getCOBieSheetXMLDataElement();
                if (attributeSheet.equalsIgnoreCase(tmpAttribute.getSheetName()) && attributeRow.equalsIgnoreCase(tmpAttribute.getRowName())
                        && attributePsetName.equalsIgnoreCase(guessPropertySetName(tmpAttribute)))
                {
                    existingOid = attributesAddedToPropertySetOid.get(keyedAttribute);
                }
            }
        }
        return existingOid;
    }

    public HashMap<KeyedAttributeType, Long> getAttributesAddedToOid()
    {
        return attributesAddedToPropertySetOid;
    }

    private IfcPropertySet getPropertySetAsFilledByPerson(AttributeType attribute) throws Exception
    {
        String createdBy;
        Calendar createdOn;
        IfcPropertySet pSet;
        createdBy = attribute.getCreatedBy();
        createdOn = attribute.getCreatedOn();
        IfcOwnerHistory ownerHistory = ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(createdBy, createdOn,
                attribute.getExtSystem());
        long existingPropertySetOid = getAttributeExistingPropertySetOid(attribute);
        if (existingPropertySetOid != NULL_OID)
        {
            pSet = (IfcPropertySet)model.get(existingPropertySetOid);
            IfcProperty property = propertyFromAttribute(attribute);
            if (property instanceof IfcPropertyEnumeratedValue)
            {
                addEnumerationToModel(attribute, (IfcPropertyEnumeratedValue)property);
            }
            if (!ifcCommonHandler.getPropertySetHandler().isPropertyInPropertySet(property, pSet))
            {
                model.add(property, ifcCommonHandler.getOidProvider());
                pSet.getHasProperties().add(property);
            }

        } else
        {
            pSet = newPropertySetFromAttribute(attribute);
            pSet.setOwnerHistory(ownerHistory);
            pSet.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid());
        }

        return pSet;
    }

    private IfcPropertySet getPropertySetAsFilledBySoftware(AttributeType attribute) throws Exception
    {
        String createdBy;
        String externalId;
        Calendar createdOn;
        IfcPropertySet pSet;
        createdBy = attribute.getCreatedBy();
        createdOn = attribute.getCreatedOn();
        IfcOwnerHistory ownerHistory = ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(createdBy, createdOn,
                attribute.getExtSystem());
        externalId = attribute.getExtIdentifier();
        IfcGloballyUniqueId guid = ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(externalId, true);
        if (ifcCommonHandler.getGuidHandler().guidInModelAndIsAttachedToPropertySet(externalId))
        {
            pSet = ifcCommonHandler.getGuidHandler().getPropertySetFromGuid(externalId);
            IfcProperty property = propertyFromAttribute(attribute);
            if (property instanceof IfcPropertyEnumeratedValue)
            {
                addEnumerationToModel(attribute, (IfcPropertyEnumeratedValue)property);
            }
            if (!ifcCommonHandler.getPropertySetHandler().isPropertyInPropertySet(property, pSet))
            {
                model.add(property, ifcCommonHandler.getOidProvider());
                pSet.getHasProperties().add(property);
            }

        } else
        {
            pSet = newPropertySetFromAttribute(attribute);
            pSet.setOwnerHistory(ownerHistory);
            pSet.setGlobalId(guid);
        }

        return pSet;
    }

    private String guessPropertySetName(AttributeType attribute)
    {
        if (isAttributeFilledByPerson(attribute))
        {
            return attribute.getExtIdentifier();
        } else
        {
            return attribute.getExtObject();
        }
    }

    private boolean isAttributeFilledByPerson(AttributeType attribute)
    {
        boolean filledByPerson = false;
        String extIdentifier = attribute.getExtIdentifier();
        boolean hasValidGuid = GuidCompressor.isValidGuid(extIdentifier);
        boolean extIdentifierIsValid = !COBieUtility.isNA(extIdentifier);
        filledByPerson = (!hasValidGuid && extIdentifierIsValid);
        return filledByPerson;
    }

    public IfcPropertySet newPropertySetFromAttribute(AttributeType attribute)
    {
        IfcPropertySet pSet = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySet();
        pSet.setName(guessPropertySetName(attribute));
        IfcProperty property = addNewPropertyToPropertySet(attribute, pSet);
        if (property instanceof IfcPropertyEnumeratedValue)
        {
            addEnumerationToModel(attribute, (IfcPropertyEnumeratedValue)property);
        }
        if (!COBieUtility.isNA(attribute.getCategory()))
        {
            List<IfcClassificationReference> classificationReferences = ifcCommonHandler.getClassificationHandler()
                    .classificationReferencesFromString(attribute.getCategory());
            for (IfcClassificationReference classificationReference : classificationReferences)
            {
                ifcCommonHandler.getClassificationHandler().addClassificationReferenceToObject(classificationReference, pSet);
            }
        }
        return pSet;
    }

    private Long objectOidFromAttribute(AttributeType attribute) throws Exception
    {
        Long relatedObjOid = (long)NULL_OID;
        String sheetName = attribute.getSheetName();
        String rowName = attribute.getRowName();

        try
        {
            CobieSheetName enumSheetName = COBieUtility.CobieSheetNameEnumFromString(sheetName);

            switch (enumSheetName)
            {
                case Contact:
                {
                    relatedObjOid = model.getContactOid(rowName);
                    break;
                }

                case Facility:
                {
                    relatedObjOid = model.getFacilityOid(rowName);
                    break;
                }

                case Floor:
                {
                    relatedObjOid = model.getFloorOid(rowName);
                    break;
                }

                case Space:
                {
                    relatedObjOid = model.getSpaceOid(rowName);
                    break;
                }

                case Zone:
                {
                    break;
                }

                case Type:
                {
                    relatedObjOid = model.getTypeOid(rowName);
                    break;
                }

                case Assembly:
                {
                    break;
                }

                case Component:
                {
                    relatedObjOid = model.getComponentOid(rowName);
                    break;
                }

                default:
                {
                    relatedObjOid = (long)NULL_OID;
                    break;
                }

            }
        } catch (Exception e)
        {
            throw e;
        }
        if (relatedObjOid == NULL_OID)
        {
            throw new Exception("SheetName-RowName entry not found");
        }
        return relatedObjOid;
    }

    public IfcProperty propertyFromAttribute(AttributeType attribute) throws Exception
    {
        String valStr = attribute.getValue();
        String allowedVals = attribute.getAllowedValues();
        String unit = attribute.getUnit();
        IfcProperty newProperty;
        if (PropertyUtility.isCandidateEnumeration(valStr, allowedVals))
        {
            try
            {
                newProperty = enumeratedValueFromString(valStr, allowedVals, attribute.getName(), attribute.getDescription());
            } catch (Exception e)
            {
                newProperty = PropertyUtility.propertyFromCOBieString(valStr, attribute.getName(), attribute.getDescription());
            }
        } else
        {
            newProperty = PropertyUtility.propertyFromCOBieString(valStr, attribute.getName(), attribute.getDescription());
        }
        if (!COBieUtility.isNA(unit))
        {
            IfcUnit ifcUnit = ifcCommonHandler.getUnitHandler().unitFromStringAndUnitType(unit, IfcUnitEnum.USERDEFINED);
            long oid = ifcCommonHandler.getPropertySetHandler().addUnitToModel(ifcUnit);
            // model.add(ifcUnit,this.ifcCommonHandler.getOidProvider());
            PropertyUtility.attachUnitToProperty(newProperty, (IfcUnit)model.get(oid));
        }
        return newProperty;
    }

    private IfcPropertySet propertySetFromAttribute(AttributeType attribute, long relatedObjectOid) throws Exception
    {
        IfcPropertySet pSet;
        if (isAttributeFilledByPerson(attribute))
        {
            pSet = getPropertySetAsFilledByPerson(attribute);
        } else
        {
            pSet = getPropertySetAsFilledBySoftware(attribute);
        }

        return pSet;
    }

    private void setAttributesAddedToOid(HashMap<KeyedAttributeType, Long> attributesAddedToOid)
    {
        attributesAddedToPropertySetOid = attributesAddedToOid;
    }

    private boolean shouldAddAttribute(AttributeType attribute)
    {
        boolean shouldAdd = true;
        String pSetName = guessPropertySetName(attribute);
        String sheetName = attribute.getSheetName();
        boolean isSpaceSheet = COBieUtility.CobieSheetName.Space.name().equalsIgnoreCase(sheetName);
        boolean isBaseQuantities = SpaceDeserializer.baseQuantitiesPsetName.equalsIgnoreCase(pSetName);
        shouldAdd = !(isSpaceSheet && isBaseQuantities) && !attributesAddedToPropertySetOid.containsKey(attribute);
        return shouldAdd;
    }

}
