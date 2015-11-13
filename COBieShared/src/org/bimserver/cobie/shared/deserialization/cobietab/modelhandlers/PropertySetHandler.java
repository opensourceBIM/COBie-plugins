package org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.cobie.shared.deserialization.DeserializerStaticStrings;
import org.bimserver.cobie.shared.deserialization.cobietab.COBieIfcModel;
import org.bimserver.cobie.shared.deserialization.cobietab.FloorDeserializer;
import org.bimserver.cobie.shared.deserialization.cobietab.propertysets.PropertyUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.ifc.IfcUnitToCOBieString;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.OidProvider;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcContextDependentUnit;
import org.bimserver.models.ifc2x3tc1.IfcConversionBasedUnit;
import org.bimserver.models.ifc2x3tc1.IfcElementQuantity;
import org.bimserver.models.ifc2x3tc1.IfcLengthMeasure;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcPhysicalQuantity;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertyEnumeratedValue;
import org.bimserver.models.ifc2x3tc1.IfcPropertyEnumeration;
import org.bimserver.models.ifc2x3tc1.IfcPropertyReferenceValue;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcValue;
import org.nibs.cobie.tab.FloorType;

public class PropertySetHandler
{

    public static String getRelDefByproPertiesCobieNameDescription()
    {
        return relDefByPropertiesCOBieNameDescription;
    }

    public static IfcPropertySet heightPropertySetFromFloor(FloorType floor)
    {
        IfcLengthMeasure heightMeasure = FloorDeserializer.storeyHeightFromFloor(floor);
        IfcPropertySet propertySetHeight = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySet();
        propertySetHeight.setName(String.format(fs_COBiePropertySetName, COBieUtility.CobieSheetName.Floor.toString()));
        propertySetHeight.setDescription(String.format(fs_COBiePropertySetDescription, COBieUtility.CobieSheetName.Floor.toString()));
        IfcPropertySingleValue heightVal = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
        heightVal.setName(DeserializerStaticStrings.getFloorHeightPropertyName());
        heightVal.setDescription(DeserializerStaticStrings.getFloorHeightPropertyDescription());
        heightVal.setNominalValue(heightMeasure);
        propertySetHeight.getHasProperties().add(heightVal);
        return propertySetHeight;
    }

    private OidProvider cobieOidProvider;
    private COBieIfcModel model;
    private IfcGuidHandler guidProvider;
    private OwnerHistoryHandler ownerHistoryProvider;
    // private Map<String, Long> enumerationNameToOid;
    private Map<String, Long> unitNameToOid;
    public static final String fs_COBiePropertySetName = "COBie_Pset_%s";

    public static final String fs_COBiePropertySetDescription = "Properties for %s found in COBie";

    protected static final String relDefByPropertiesCOBieNameDescription = "Associated COBie Attributes";

    public PropertySetHandler(COBieIfcModel cobieIfcModel, OidProvider oidProvider, IfcGuidHandler IfcGuidProvider,
            OwnerHistoryHandler ownerHistoryProvider)
    {
        model = cobieIfcModel;
        cobieOidProvider = oidProvider;
        guidProvider = IfcGuidProvider;
        this.ownerHistoryProvider = ownerHistoryProvider;
        init();
    }

    private void addEnumeratedValueContentsToModel(IfcPropertyEnumeratedValue propEnum) throws IfcModelInterfaceException
    {
        // Commented out on 7/25/2012 b/c native type values should not be added
        // as separate entities
        for (IfcValue val : propEnum.getEnumerationValues())
        {
            if (!model.contains(val))
            {
                try
                {
                    model.add(val, cobieOidProvider);
                } catch (IfcModelInterfaceException e)
                {
                    // TODO Auto-generated catch block

                }
            }
        }
        IfcPropertyEnumeration enumeration = propEnum.getEnumerationReference();
        if (enumeration != null)
        {
            if (model.containsEnumeration(enumeration.getName()))
            {
                long enumOid = model.getEnumerationOid(enumeration.getName());
                enumeration = (IfcPropertyEnumeration)model.get(enumOid);
                propEnum.setEnumerationReference(enumeration);
            } else
            {
                if (enumeration.isSetUnit())
                {
                    IfcUnit unit = enumeration.getUnit();
                    long unitOid = addUnitToModel(unit);
                    enumeration.setUnit((IfcUnit)model.get(unitOid));
                }
                for (IfcValue val : enumeration.getEnumerationValues())
                {
                    try
                    {
                        model.add(val, cobieOidProvider);
                    } catch (IfcModelInterfaceException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                model.add(enumeration, cobieOidProvider);
            }

        }

    }

    public long addPropertiesAndPropertySetToObject(IfcObject object, IfcPropertySetDefinition propertySetDefinition, boolean isCOBiePset)
            throws IfcModelInterfaceException
    {
        long propertySetOid = -1;
        propertySetOid = getPropertySetOid(propertySetDefinition);
        if (!isPropertySetRelatedToObject(propertySetDefinition, object))
        {
            relatePropertySetToObject(propertySetDefinition, object, isCOBiePset);
        }
        return propertySetOid;

    }

    public long addPropertiesAndPropertySetToTypeObject(IfcTypeObject object, IfcPropertySetDefinition propertySetDefinition, boolean isCOBiePset)
            throws IfcModelInterfaceException
    {
        long propertySetOid = -1;
        if (propertySetDefinition.getGlobalId() == null)
        {
            propertySetDefinition.setGlobalId(guidProvider.newGuid().getWrappedValue());
        }
        if (propertySetDefinition.getOwnerHistory() == null)
        {
            IfcOwnerHistory ownerHistory = ownerHistoryProvider.DefaultOwnerHistory();
            propertySetDefinition.setOwnerHistory(ownerHistory);
        }
        if (propertySetDefinition instanceof IfcPropertySet)
        {
            IfcPropertySet propertySet = (IfcPropertySet)propertySetDefinition;
            for (IfcProperty property : propertySet.getHasProperties())
            {
                if (!model.contains(property))
                {
                    try
                    {
                        addPropertyContentsToModel(property);
                    } catch (IfcModelInterfaceException e1)
                    {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    try
                    {
                        model.add(property, cobieOidProvider);
                    } catch (IfcModelInterfaceException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            propertySetOid = getPropertySetOid(propertySetDefinition);
        } else if (propertySetDefinition instanceof IfcElementQuantity)
        {
            IfcElementQuantity elementQuantity = (IfcElementQuantity)propertySetDefinition;
            for (IfcPhysicalQuantity physicalQuantity : elementQuantity.getQuantities())
            {
                if (!model.contains(physicalQuantity))
                {
                    try
                    {
                        model.add(physicalQuantity, cobieOidProvider);
                    } catch (IfcModelInterfaceException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }
            propertySetOid = getPropertySetOid(propertySetDefinition);
        }
        object.getHasPropertySets().add(propertySetDefinition);
        return propertySetOid;
    }

    private void addPropertyContentsToModel(IfcProperty property) throws IfcModelInterfaceException
    {
        if (property instanceof IfcPropertySingleValue)
        {
            IfcPropertySingleValue sVal = (IfcPropertySingleValue)property;

            if (sVal.isSetUnit())
            {
                IfcUnit unit = sVal.getUnit();
                if (unit instanceof IfcConversionBasedUnit)
                {
                    IfcConversionBasedUnit conversionBasedUnit = (IfcConversionBasedUnit)unit;
                    IfcUnit relatedUnit = conversionBasedUnit.getConversionFactor().getUnitComponent();
                    long oid = addUnitToModel(relatedUnit);
                    relatedUnit = (IfcUnit)model.get(oid);
                    conversionBasedUnit.getConversionFactor().setUnitComponent(relatedUnit);
                }
                long oid = addUnitToModel(unit);
                unit = (IfcUnit)model.get(oid);
                sVal.setUnit(unit);

            }
            // Commented out on 7/25/2012 b/c there is no need to add value
            // types
            if (sVal.isSetNominalValue())
            {
                IfcValue val = sVal.getNominalValue();
                if (!model.contains(val))
                {
                    model.add(val, cobieOidProvider);
                }
            }
        } else if (property instanceof IfcPropertyEnumeratedValue)
        {
            IfcPropertyEnumeratedValue enumProp = (IfcPropertyEnumeratedValue)property;
            addEnumeratedValueContentsToModel(enumProp);
        } else if (property instanceof IfcPropertyReferenceValue)
        {
            IfcPropertyReferenceValue referenceValue = (IfcPropertyReferenceValue)property;
            addReferenceValueContentsToModel(referenceValue);
        }
    }

    public long addPropertySetToModel(IfcPropertySetDefinition propertySetDefinition) throws IfcModelInterfaceException
    {
        long propertySetOid = -1;
        if ((propertySetDefinition.getGlobalId() == null) || (propertySetDefinition.getGlobalId().length() == 0))
        {
            propertySetDefinition.setGlobalId(guidProvider.newGuid().getWrappedValue());
        }
        if (propertySetDefinition.getOwnerHistory() == null)
        {
            IfcOwnerHistory ownerHistory = ownerHistoryProvider.DefaultOwnerHistory();
            propertySetDefinition.setOwnerHistory(ownerHistory);
        }
        if (propertySetDefinition instanceof IfcPropertySet)
        {
            IfcPropertySet propertySet = (IfcPropertySet)propertySetDefinition;
            for (IfcProperty property : propertySet.getHasProperties())
            {
                if (!model.contains(property))
                {
                    try
                    {
                        addPropertyContentsToModel(property);
                    } catch (IfcModelInterfaceException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    try
                    {
                        model.add(property, cobieOidProvider);
                    } catch (IfcModelInterfaceException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }

            propertySetOid = model.add(propertySet, cobieOidProvider);
        } else if (propertySetDefinition instanceof IfcElementQuantity)
        {
            IfcElementQuantity elementQuantity = (IfcElementQuantity)propertySetDefinition;
            for (IfcPhysicalQuantity physicalQuantity : elementQuantity.getQuantities())
            {
                if (!model.contains(physicalQuantity))
                {
                    model.add(physicalQuantity, cobieOidProvider);
                }
            }
            propertySetOid = model.add(elementQuantity, cobieOidProvider);
        }
        return propertySetOid;
    }

    private void addReferenceValueContentsToModel(IfcPropertyReferenceValue referenceValue) throws IfcModelInterfaceException
    {
        if ((referenceValue != null) && (referenceValue.getPropertyReference() != null))
        {
            model.add(referenceValue.getPropertyReference(), cobieOidProvider);
        }

    }

    public long addUnitToModel(IfcUnit unit) throws IfcModelInterfaceException
    {
        long oid;
        String cobieUnitName = IfcUnitToCOBieString.stringFromUnit(unit);
        if (!unitNameToOid.containsKey(cobieUnitName))
        {
            if (unit instanceof IfcConversionBasedUnit)
            {
                handleConversionBasedUnit(unit);

            } else if (unit instanceof IfcContextDependentUnit)
            {
                handleContextDependentUnit((IfcContextDependentUnit)unit);
            }
            oid = model.add(unit, cobieOidProvider);
            unitNameToOid.put(cobieUnitName, oid);
        } else
        {
            oid = unitNameToOid.get(cobieUnitName);
        }
        return oid;
    }

    public IfcPropertyEnumeration enumerationFromNameAndValues(String enumName, String delimittedAllowedValues, String unit)
    {
        IfcPropertyEnumeration enumeration = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertyEnumeration();
        enumeration.setName(enumName);
        if (model.containsEnumeration(enumName))
        {
            long oid = model.getEnumerationOid(enumName);
            if (model.contains(oid))
            {
                try
                {
                    enumeration = (IfcPropertyEnumeration)model.get(oid);
                } catch (Exception e)
                {

                }
            }
        } else
        {

            String[] splitString = delimittedAllowedValues.split(COBieUtility.getCOBieDelim());
            for (int i = 0; i < splitString.length; i++)
            {
                splitString[i] = splitString[i].trim();
            }
            try
            {
                PropertyUtility.populateEnumeration(enumeration, new ArrayList<String>(Arrays.asList(splitString)));
                model.add(enumeration, cobieOidProvider);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            return enumeration;
        }
        return enumeration;

    }

    private long getPropertySetOid(IfcPropertySetDefinition propertySetDefinition) throws IfcModelInterfaceException
    {
        long propertySetOid;
        if (!isPropertySetInModel(propertySetDefinition))
        {
            propertySetOid = addPropertySetToModel(propertySetDefinition);
        } else
        {
            propertySetOid = model.getGuidToOid().get(propertySetDefinition.getGlobalId());
        }
        return propertySetOid;
    }

    private void handleContextDependentUnit(IfcContextDependentUnit unit) throws IfcModelInterfaceException
    {
        if (unit.getDimensions() != null)
        {
            model.add(unit.getDimensions(), cobieOidProvider);
        }

    }

    private void handleConversionBasedUnit(IfcUnit unit)
    {
        try
        {
            IfcConversionBasedUnit conversionBasedUnit = (IfcConversionBasedUnit)unit;
            if (conversionBasedUnit != null)
            {
                if (conversionBasedUnit.getConversionFactor() != null)
                {
                    if (conversionBasedUnit.getConversionFactor().getUnitComponent() != null)
                    {
                        IfcUnitToCOBieString.stringFromUnit(conversionBasedUnit.getConversionFactor().getUnitComponent());

                        long subUnitOid = addUnitToModel(conversionBasedUnit.getConversionFactor().getUnitComponent());
                        conversionBasedUnit.getConversionFactor().setUnitComponent((IfcUnit)model.get(subUnitOid));

                    }
                }
                model.add(conversionBasedUnit.getConversionFactor(), cobieOidProvider);
            }
            if (conversionBasedUnit.getDimensions() != null)
            {
                model.add(conversionBasedUnit.getDimensions(), cobieOidProvider);
            }
        } catch (Exception ex)
        {

        }
    }

    private void init()
    {
        unitNameToOid = new HashMap<String, Long>();
    }

    public boolean isPropertyInPropertySet(IfcProperty property, IfcPropertySet propertySetDefinition)
    {
        boolean isInPropertySet = false;
        for (IfcProperty tempProperty : propertySetDefinition.getHasProperties())
        {
            if (tempProperty.getName().equalsIgnoreCase(property.getName()))
            {
                isInPropertySet = true;
            }
        }
        return isInPropertySet;
    }

    public boolean isPropertySetInModel(IfcPropertySetDefinition propertySetDefinition)
    {
        boolean isInModel = false;
        try
        {
            String guid = propertySetDefinition.getGlobalId();
            /*
             * if (IfcGuidHandler.isValidGuid(guid)) { model.indexGuids();
             * isInModel = model.contains(guid); }
             */
            if (guidProvider.guidInModelAndIsAttachedToPropertySet(guid))
            {
                isInModel = true;
            }
        } catch (Exception e)
        {

        }
        return isInModel;
    }

    public boolean isPropertySetRelatedToObject(IfcPropertySetDefinition propertySet, IfcObject object)
    {
        boolean isRelatedToObject = false;
        for (IfcRelDefines definesRelation : object.getIsDefinedBy())
        {
            if (definesRelation instanceof IfcRelDefinesByProperties)
            {
                IfcRelDefinesByProperties defByProp = (IfcRelDefinesByProperties)definesRelation;
                if (defByProp.getRelatingPropertyDefinition().getGlobalId().equals(propertySet.getGlobalId()))
                {
                    isRelatedToObject = true;
                }
            }
        }
        return isRelatedToObject;
    }

    public void relatePropertySetToObject(IfcPropertySetDefinition propertySetDefinition, IfcObject object, boolean isCOBiePset)
            throws IfcModelInterfaceException
    {
        IfcRelDefinesByProperties relDefByProperties = Ifc2x3tc1Factory.eINSTANCE.createIfcRelDefinesByProperties();
        IfcOwnerHistory ownerHistory = ownerHistoryProvider.DefaultOwnerHistory();
        relDefByProperties.setOwnerHistory(ownerHistory);
        relDefByProperties.setGlobalId(guidProvider.newGuid().getWrappedValue());
        if (isCOBiePset)
        {
            relDefByProperties.setName(getRelDefByproPertiesCobieNameDescription());
            relDefByProperties.setDescription(getRelDefByproPertiesCobieNameDescription());
        }
        relDefByProperties.setRelatingPropertyDefinition(propertySetDefinition);
        model.add(relDefByProperties, cobieOidProvider);
        object.getIsDefinedBy().add(relDefByProperties);
    }
}
