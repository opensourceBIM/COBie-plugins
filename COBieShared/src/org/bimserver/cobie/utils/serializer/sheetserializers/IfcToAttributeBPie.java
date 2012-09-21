package org.bimserver.cobie.utils.serializer.sheetserializers;

import org.bimserver.cobie.cobielite.AttributeType;
import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.utils.deserializer.modelhandlers.IfcGuidHandler;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcSpaceType;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.cobie.COBieUtility;
import org.bimserver.shared.cobie.GuidCompressor;


public class IfcToAttributeBPie extends IfcToAttribute
{
	
	private static final String ATTRIBUTE_SPACE_TYPE = "SpaceType";
	private static final String ATTRIBUTE_SPACE_TYPE_PSET_NAME = "Pset_SpaceCommon";

	public static void writeAttributes(COBIEType cType, IfcModelInterface model)
	{	
		LogHandler loggerHandler = new LogHandler(cobieSheet,LOGGER);
		loggerHandler.sheetWriteBegin();
		IfcToAttribute.writeObjectAttributes(getBuildings(model), getCobieAttributes(cType), model,loggerHandler);
		IfcToAttribute.writeObjectAttributes(getFloors(model),getCobieAttributes(cType),model,loggerHandler);
		IfcToAttribute.writeObjectAttributes(getSpaces(model),getCobieAttributes(cType),model,loggerHandler);
		IfcToAttribute.writeTypesComponents(cType, model,loggerHandler);	
		emulateSpaceTypeRelationships(cType,model);
		loggerHandler.sheetWritten();
	}
	
	public static void emulateSpaceTypeRelationships(COBIEType cobie,
			IfcModelInterface model)
	{
		for(IfcObject objSpace: getSpaces(model))
		{
			if (objSpace instanceof IfcSpace)
			{
				IfcSpace space = (IfcSpace) objSpace;
				if(space.getIsDefinedBy()!=null)
				{
					for(IfcRelDefines relDefines:space.getIsDefinedBy())
					{
						if(relDefines instanceof IfcRelDefinesByType)
						{
							IfcRelDefinesByType relDefByType =
									(IfcRelDefinesByType) relDefines;
							if(relDefByType.getRelatingType()!=null)
							{
								IfcTypeObject typeObject =
										(IfcTypeObject) relDefByType.getRelatingType();
								if (typeObject instanceof IfcSpaceType)
								{
									IfcSpaceType spaceType =
											(IfcSpaceType) typeObject;
									writeSpaceTypeSpaceAttribute(space,spaceType,cobie);
								}
							}
						}
					}
				}
			}
		}
	}
	
	private static void writeSpaceTypeSpaceAttribute(IfcSpace space,IfcSpaceType spaceType,
			COBIEType cobie)
	{
		COBIEType.Attributes attributes;
		if(cobie.getAttributes()==null)
			attributes = cobie.addNewAttributes();
		else
			attributes = cobie.getAttributes();
		AttributeType attribute =
				attributes.addNewAttribute();
		attribute.setName(ATTRIBUTE_SPACE_TYPE);
		attribute.setAllowedValues(COBieUtility.COBieNA);
		attribute.setValue(spaceType.getName());
		attribute.setSheetName(COBieUtility.CobieSheetName.Space.name());
		attribute.setRowName(IfcToSpace.nameFromSpace(space));
		attribute.setExtObject(ATTRIBUTE_SPACE_TYPE_PSET_NAME);
		attribute.setDescription(COBieUtility.getCOBieString(spaceType.getDescription()));
		attribute.setCategory(IfcToAttribute.categoryFromRoot(spaceType));
		attribute.setCreatedBy(COBieUtility.getEmailFromOwnerHistory(spaceType.getOwnerHistory()));
		attribute.setCreatedOn(COBieUtility.ifcTimeStampAsCalendar(spaceType.getOwnerHistory().getCreationDate()));
		attribute.setExtSystem(COBieUtility.getApplicationName(spaceType.getOwnerHistory()));
		attribute.setUnit(COBieUtility.COBieNA);
		attribute.setExtIdentifier(pSetCommonGuidFromSpace(space));
	}
	
	private static String pSetCommonGuidFromSpace(IfcSpace space)
	{
		String guid = "";
		for(IfcRelDefines relDefines: space.getIsDefinedBy())
		{
			if (relDefines instanceof IfcRelDefinesByProperties)
			{
				IfcRelDefinesByProperties relPropDef =
						(IfcRelDefinesByProperties) relDefines;
				
				IfcPropertySetDefinition pSetDef =
						(IfcPropertySetDefinition) relPropDef.getRelatingPropertyDefinition();
				if (pSetDef.getName().equalsIgnoreCase(ATTRIBUTE_SPACE_TYPE_PSET_NAME))
				{
					guid = pSetDef.getGlobalId().getWrappedValue();
				}
			}
		}
		if (COBieUtility.isNA(guid))
			guid = GuidCompressor.getNewIfcGloballyUniqueId();
		return guid;
		
	}
}
