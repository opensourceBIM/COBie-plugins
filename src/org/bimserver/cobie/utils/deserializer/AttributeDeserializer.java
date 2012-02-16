package org.bimserver.cobie.utils.deserializer;

import java.util.Calendar;

import org.bimserver.cobie.cobielite.AttributeType;
import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.plugins.COBieIfcModel;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.COBieUtility.CobieSheetName;
import org.bimserver.cobie.utils.deserializer.propertysets.PropertyUtility;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.IfcClassificationReference;
import org.bimserver.models.ifc2x3.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3.IfcObject;
import org.bimserver.models.ifc2x3.IfcOwnerHistory;
import org.bimserver.models.ifc2x3.IfcProperty;
import org.bimserver.models.ifc2x3.IfcPropertySet;
import org.bimserver.models.ifc2x3.IfcTypeObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AttributeDeserializer 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(AttributeDeserializer.class);
	private COBieIfcModel model;
	private IfcCommonHandler ifcCommonHandler;
	private COBIEType.Attributes attributes;
	public AttributeDeserializer(COBieIfcModel cobieIfcModel, IfcCommonHandler ifcCommonHandler, COBIEType.Attributes attributes)
	{
		this.model = cobieIfcModel;
		this.ifcCommonHandler = ifcCommonHandler;
		this.attributes = attributes;
	}
	
	public void deserializeAttributes()
	{
		String createdBy;
		String externalId;
		Calendar createdOn;
		Long relatedObjectOid;
		IfcPropertySet pSet;
		if (attributes != null)
		{
			for (AttributeType attribute : attributes.getAttributeArray())
			{
				try
				{
					relatedObjectOid = objectOidFromAttribute(attribute);
					attribute.getName();
					createdBy = attribute.getCreatedBy();
					createdOn = attribute.getCreatedOn();
					IfcOwnerHistory ownerHistory = ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailAndTimestamp(
							createdBy, createdOn);

					attribute.getCategory();
					attribute.getSheetName();
					attribute.getRowName();
					attribute.getValue();
					attribute.getUnit();
					attribute.getExtSystem();
					attribute.getExtObject();
					externalId = attribute.getExtIdentifier();
					IfcGloballyUniqueId guid = ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(externalId,true);
					attribute.getDescription();
					attribute.getAllowedValues();
					if (ifcCommonHandler.getGuidHandler().guidInModelAndIsAttachedToPropertySet(externalId))
					{
						pSet = ifcCommonHandler.getGuidHandler().getPropertySetFromGuid(externalId);
						IfcProperty property = AttributeDeserializer
								.propertyFromAttribute(attribute);
						if (!ifcCommonHandler.getPropertySetHandler().isPropertyInPropertySet(property, pSet))
						{
							model.add(property, ifcCommonHandler.getOidProvider());
							pSet.getHasProperties().add(property);
						}

					} else
					{
						pSet = AttributeDeserializer.newPropertySetFromAttribute(attribute);
						pSet.setOwnerHistory(ownerHistory);
						pSet.setGlobalId(guid);
					}
					if (relatedObjectOid !=null)
					{
						IdEObject ideObj = model.get(relatedObjectOid);
						if (ideObj instanceof IfcObject)
						{
							IfcObject ifcObj = (IfcObject) ideObj;
							this.ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToObject(ifcObj, pSet, false);
						}
						else if (ideObj instanceof IfcTypeObject)
						{
							IfcTypeObject ifcType = (IfcTypeObject) ideObj;
							this.ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToTypeObject(ifcType, pSet, false);
						}
					}

				} catch (Exception e)
				{
				}

			}
		}
	}
	
	private Long objectOidFromAttribute(AttributeType attribute)
			throws Exception
	{
		Long relatedObjOid = (long) -1;
		String sheetName = attribute.getSheetName();
		String rowName = attribute.getRowName();

		try
		{
			CobieSheetName enumSheetName = COBieUtility
					.CobieSheetNameEnumFromString(sheetName);

			switch (enumSheetName)
			{
				case Contact:
				{
					relatedObjOid = this.model.getContactOid(rowName);
					break;
				}

				case Facility:
				{
					relatedObjOid = this.model.getFacilityOid(rowName);
					break;
				}

				case Floor:
				{
					relatedObjOid = this.model.getFloorOid(rowName);
					break;
				}

				case Space:
				{
					relatedObjOid = this.model.getSpaceOid(rowName);
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
					relatedObjOid = (long) -1;
					break;
				}

			}
		} catch (Exception e)
		{
			throw e;
		}
		if (relatedObjOid == -1)
			throw new Exception("SheetName-RowName entry not found");
		return relatedObjOid;
	}
	public static IfcPropertySet newPropertySetFromAttribute(AttributeType attribute)
	{
		IfcPropertySet pSet = Ifc2x3Factory.eINSTANCE.createIfcPropertySet();
		pSet.setName(attribute.getExtObject());
		AttributeDeserializer.addNewPropertyToPropertySet(attribute, pSet);
		return pSet;
	}
	
	public static void addNewPropertyToPropertySet(AttributeType attribute, IfcPropertySet pSet)
	{
		IfcProperty newProperty;
		try {
			newProperty = AttributeDeserializer.propertyFromAttribute(attribute);
			pSet.getHasProperties().add(newProperty);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error("", e);
		}
	}
	
	public  IfcClassificationReference classificationReferenceFromAttribute(AttributeType attribute)
	{
		return ifcCommonHandler.getClassificationHandler().classificationReferenceFromString(attribute.getCategory());
	}
	
	public static IfcProperty propertyFromAttribute(AttributeType attribute) throws Exception
	{
		String valStr = attribute.getValue();
		String allowedVals = attribute.getAllowedValues();
		if (PropertyUtility.isCandidateEnumeration(valStr,allowedVals))
		{
			try
			{
				return  PropertyUtility.enumeratedValueFromString(valStr, allowedVals, attribute.getName(),
					attribute.getDescription());
			}
			catch(Exception e)
			{
				return PropertyUtility.propertyFromCOBieString(valStr,
						attribute.getName(), attribute.getDescription());
			}
		}
		else
		{
			return PropertyUtility.propertyFromCOBieString(valStr,
					attribute.getName(), attribute.getDescription());
		}
	}
	
	
}
