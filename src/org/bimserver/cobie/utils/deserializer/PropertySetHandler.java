package org.bimserver.cobie.utils.deserializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.cobie.cobielite.FloorType;
import org.bimserver.cobie.plugins.COBieIfcModel;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.deserializer.propertysets.PropertyUtility;
import org.bimserver.cobie.utils.stringwriters.DeserializerStaticStrings;
import org.bimserver.cobie.utils.stringwriters.IfcUnitToCOBieString;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.IfcElementQuantity;
import org.bimserver.models.ifc2x3.IfcLengthMeasure;
import org.bimserver.models.ifc2x3.IfcObject;
import org.bimserver.models.ifc2x3.IfcOwnerHistory;
import org.bimserver.models.ifc2x3.IfcPhysicalQuantity;
import org.bimserver.models.ifc2x3.IfcProperty;
import org.bimserver.models.ifc2x3.IfcPropertyEnumeratedValue;
import org.bimserver.models.ifc2x3.IfcPropertyEnumeration;
import org.bimserver.models.ifc2x3.IfcPropertySet;
import org.bimserver.models.ifc2x3.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3.IfcRelDefines;
import org.bimserver.models.ifc2x3.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3.IfcTypeObject;
import org.bimserver.models.ifc2x3.IfcUnit;
import org.bimserver.models.ifc2x3.IfcValue;
import org.bimserver.plugins.serializers.OidProvider;


public class PropertySetHandler
{
	
	private OidProvider CobieOidProvider;
	private COBieIfcModel model;
	private IfcGuidHandler guidProvider;
	private OwnerHistoryHandler ownerHistoryProvider;
	//private Map<String, Long> enumerationNameToOid;
	private Map<String, Long> unitNameToOid;
	protected static final String fs_COBiePropertySetName = "Pset_%s_COBie";
	protected static final String fs_COBiePropertySetDescription = "Properties for %s found in COBie";
	protected static final String relDefByPropertiesCOBieNameDescription = "Associated COBie Attributes";
	
	public PropertySetHandler(COBieIfcModel cobieIfcModel, OidProvider oidProvider,
			IfcGuidHandler IfcGuidProvider, OwnerHistoryHandler ownerHistoryProvider)
	{
		model = cobieIfcModel;
		CobieOidProvider = oidProvider;
		guidProvider = IfcGuidProvider;
		this.ownerHistoryProvider = ownerHistoryProvider;
		init();
	}
	
	
	
	private void init()
	{
		unitNameToOid = new HashMap<String,Long>();
	}

	public void addPropertySetToModel(
			IfcPropertySetDefinition propertySetDefinition)
	{
		if (propertySetDefinition.getGlobalId() == null
				|| propertySetDefinition.getGlobalId().getWrappedValue().length() == 0)
			propertySetDefinition.setGlobalId(this.guidProvider.newGuid());
		IfcOwnerHistory ownerHistory = this.ownerHistoryProvider.DefaultOwnerHistory();
		propertySetDefinition.setOwnerHistory(ownerHistory);
		if (propertySetDefinition instanceof IfcPropertySet)
		{
			IfcPropertySet propertySet = (IfcPropertySet) propertySetDefinition;
			for (IfcProperty property : propertySet.getHasProperties())
			{
				addPropertyContentsToModel(property);
				model.add(property, this.CobieOidProvider);
			}

			model.add(propertySet, CobieOidProvider);
		} else if (propertySetDefinition instanceof IfcElementQuantity)
		{
			IfcElementQuantity elementQuantity = (IfcElementQuantity) propertySetDefinition;
			for (IfcPhysicalQuantity physicalQuantity : elementQuantity
					.getQuantities())
				model.add(physicalQuantity, CobieOidProvider);
			model.add(elementQuantity, CobieOidProvider);
		}
	}

	public void addPropertiesAndPropertySetToObject(IfcObject object,
			IfcPropertySetDefinition propertySetDefinition, boolean isCOBiePset)
	{
		if (!isPropertySetInModel(propertySetDefinition))
			addPropertySetToModel(propertySetDefinition);
		if (!isPropertySetRelatedToObject(propertySetDefinition, object))
		{
			relatePropertySetToObject(propertySetDefinition, object, isCOBiePset);
		}

	}
	
	public void addPropertiesAndPropertySetToTypeObject(IfcTypeObject object,
			IfcPropertySetDefinition propertySetDefinition, boolean isCOBiePset)
	{
		propertySetDefinition.setGlobalId(this.guidProvider.newGuid());
		IfcOwnerHistory ownerHistory = this.ownerHistoryProvider.DefaultOwnerHistory();
		propertySetDefinition.setOwnerHistory(ownerHistory);
		if (propertySetDefinition instanceof IfcPropertySet)
		{
			IfcPropertySet propertySet = (IfcPropertySet) propertySetDefinition;
			for (IfcProperty property : propertySet.getHasProperties())
			{
				addPropertyContentsToModel(property);
				model.add(property, this.CobieOidProvider);
			}
			model.add(propertySet, CobieOidProvider);
		} else if (propertySetDefinition instanceof IfcElementQuantity)
		{
			IfcElementQuantity elementQuantity = (IfcElementQuantity) propertySetDefinition;
			for (IfcPhysicalQuantity physicalQuantity : elementQuantity
					.getQuantities())
				model.add(physicalQuantity, CobieOidProvider);
			model.add(elementQuantity, CobieOidProvider);
		}
		object.getHasPropertySets().add(propertySetDefinition);
	}

	private void addPropertyContentsToModel(IfcProperty property)
	{
		if (property instanceof IfcPropertySingleValue)
		{
			IfcPropertySingleValue sVal = (IfcPropertySingleValue) property;

			if (sVal.isSetUnit())
			{
				IfcUnit unit = sVal.getUnit();
				long oid = addUnitToModel(unit);
				unit = (IfcUnit) model.get(oid);
				sVal.setUnit(unit);
			}
			if (sVal.isSetNominalValue())
			{
				IfcValue val = sVal.getNominalValue();
				if (!model.contains(val))
					model.add(val, this.CobieOidProvider);
			}
		} else if (property instanceof IfcPropertyEnumeratedValue)
		{
			IfcPropertyEnumeratedValue enumProp = (IfcPropertyEnumeratedValue) property;
			addEnumeratedValueContentsToModel(enumProp);
		}
	}
	
	public void relatePropertySetToObject(
			IfcPropertySetDefinition propertySetDefinition, IfcObject object,
			boolean isCOBiePset)
	{
		IfcRelDefinesByProperties relDefByProperties = Ifc2x3Factory.eINSTANCE
				.createIfcRelDefinesByProperties();
		IfcOwnerHistory ownerHistory = this.ownerHistoryProvider.DefaultOwnerHistory();
		relDefByProperties.setOwnerHistory(ownerHistory);
		relDefByProperties.setGlobalId(this.guidProvider.newGuid());
		if (isCOBiePset)
		{
			relDefByProperties
					.setName(getRelDefByproPertiesCobieNameDescription());
			relDefByProperties
					.setDescription(getRelDefByproPertiesCobieNameDescription());
		}
		relDefByProperties.setRelatingPropertyDefinition(propertySetDefinition);
		model.add(relDefByProperties, CobieOidProvider);
		object.getIsDefinedBy().add(relDefByProperties);
	}

	public boolean isPropertySetInModel(
			IfcPropertySetDefinition propertySetDefinition)
	{
		boolean isInModel = false;
		try
		{
			String guid = propertySetDefinition.getGlobalId().getWrappedValue();
			/*if (IfcGuidHandler.isValidGuid(guid))
			{
				model.indexGuids();
				isInModel = model.contains(guid);
			}*/
			if (guidProvider.guidInModelAndIsAttachedToPropertySet(guid))
				isInModel = true;
		} catch (Exception e)
		{

		}
		return isInModel;
	}

	public boolean isPropertyInPropertySet(IfcProperty property,
			IfcPropertySet propertySetDefinition)
	{
		boolean isInPropertySet = false;
		for (IfcProperty tempProperty : propertySetDefinition.getHasProperties())
		{
			if (tempProperty.getName().equalsIgnoreCase(property.getName()))
				isInPropertySet = true;
		}
		return isInPropertySet;
	}

	public boolean isPropertySetRelatedToObject(
			IfcPropertySetDefinition propertySet, IfcObject object)
	{
		boolean isRelatedToObject = false;
		for (IfcRelDefines definesRelation : object.getIsDefinedBy())
		{
			if (definesRelation instanceof IfcRelDefinesByProperties)
			{
				IfcRelDefinesByProperties defByProp = (IfcRelDefinesByProperties) definesRelation;
				if (defByProp.getRelatingPropertyDefinition().getGlobalId()
						.getWrappedValue()
						.equals(propertySet.getGlobalId().getWrappedValue()))
					isRelatedToObject = true;
			}
		}
		return isRelatedToObject;
	}
	
	public  IfcPropertyEnumeration enumerationFromNameAndValues(String enumName, String delimittedAllowedValues,String unit)
	{
		IfcPropertyEnumeration enumeration = 
				Ifc2x3Factory.eINSTANCE.createIfcPropertyEnumeration();
		enumeration.setName(enumName);
		if(this.model.containsEnumeration(enumName))
		{
			long oid = model.getEnumerationOid(enumName);
			if (model.contains(oid))
			{
				try
				{
					enumeration = (IfcPropertyEnumeration) model.get(oid);
				}
				catch(Exception e)
				{
					
				}
			}
		}
		else
		{

			String[] splitString = delimittedAllowedValues.split(COBieUtility.getCOBieDelim());
			for(String allowedValue : splitString)
				allowedValue = allowedValue.trim();
			try
			{
				PropertyUtility.populateEnumeration(enumeration, splitString);
				model.add(enumeration,this.CobieOidProvider);
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return enumeration;
		}
		return enumeration;
		
	}
	
	private void addEnumeratedValueContentsToModel(
			IfcPropertyEnumeratedValue propEnum)
	{
		for (IfcValue val : propEnum.getEnumerationValues())
		{
			if (!model.contains(val))
				model.add(val, this.CobieOidProvider);
		}
		IfcPropertyEnumeration enumeration = propEnum.getEnumerationReference();
		if (enumeration != null)
		{
			if (model.containsEnumeration(enumeration.getName()))
			{
				long enumOid = model.getEnumerationOid(enumeration.getName());
				enumeration = (IfcPropertyEnumeration) model
						.get(enumOid);
				propEnum.setEnumerationReference(enumeration);
			} else
			{
				if (enumeration.isSetUnit())
				{
					IfcUnit unit = enumeration.getUnit();
					long unitOid = addUnitToModel(unit);
					enumeration.setUnit((IfcUnit) model.get(unitOid));
				}
				for (IfcValue val : enumeration.getEnumerationValues())
					model.add(val, this.CobieOidProvider);
				model.add(enumeration, this.CobieOidProvider);
			}

		}

	}
	
	
	public long addUnitToModel(IfcUnit unit)
	{
		long oid;
		String cobieUnitName = IfcUnitToCOBieString.stringFromUnit(unit);
		if (!unitNameToOid.containsKey(cobieUnitName))
		{
			oid = model.add(unit, this.CobieOidProvider);
			unitNameToOid.put(cobieUnitName, oid);
		} else
		{
			oid = unitNameToOid.get(cobieUnitName);
		}
		return oid;
	}
	
	public static IfcPropertySet heightPropertySetFromFloor(FloorType floor)
	{
		IfcLengthMeasure heightMeasure =
				FloorDeserializer.storeyHeightFromFloor(floor);
		IfcPropertySet propertySetHeight =
				Ifc2x3Factory.eINSTANCE.createIfcPropertySet();
		propertySetHeight.setName
			(String.format(fs_COBiePropertySetName, COBieUtility.CobieSheetName.Floor.toString()));
		propertySetHeight.setDescription
			(String.format(fs_COBiePropertySetDescription, COBieUtility.CobieSheetName.Floor.toString()));
		IfcPropertySingleValue heightVal =
				Ifc2x3Factory.eINSTANCE.createIfcPropertySingleValue();
		heightVal.setName(DeserializerStaticStrings.getFloorHeightPropertyName());
		heightVal.setDescription(DeserializerStaticStrings.getFloorHeightPropertyDescription());
		heightVal.setNominalValue(heightMeasure);
		propertySetHeight.getHasProperties().add(heightVal);
		return propertySetHeight;
	}

	public static String getRelDefByproPertiesCobieNameDescription()
	{
		return relDefByPropertiesCOBieNameDescription;
	}
}
