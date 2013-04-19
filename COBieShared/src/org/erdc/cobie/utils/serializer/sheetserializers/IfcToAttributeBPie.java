package org.erdc.cobie.utils.serializer.sheetserializers;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcSpaceType;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.GuidCompressor;
import org.erdc.cobie.sheetxmldata.AttributeType;
import org.erdc.cobie.sheetxmldata.COBIEType;

public class IfcToAttributeBPie extends IfcToAttribute
{

    private static final String ATTRIBUTE_SPACE_TYPE = "SpaceType";
    private static final String ATTRIBUTE_SPACE_TYPE_PSET_NAME = "Pset_SpaceCommon";

    public static void emulateSpaceTypeRelationships(COBIEType cobie, IfcModelInterface model)
    {
        for (IfcObject objSpace : getSpaces(model))
        {
            if (objSpace instanceof IfcSpace)
            {
                IfcSpace space = (IfcSpace)objSpace;
                if (space.getIsDefinedBy() != null)
                {
                    for (IfcRelDefines relDefines : space.getIsDefinedBy())
                    {
                        if (relDefines instanceof IfcRelDefinesByType)
                        {
                            IfcRelDefinesByType relDefByType = (IfcRelDefinesByType)relDefines;
                            if (relDefByType.getRelatingType() != null)
                            {
                                IfcTypeObject typeObject = relDefByType.getRelatingType();
                                if (typeObject instanceof IfcSpaceType)
                                {
                                    IfcSpaceType spaceType = (IfcSpaceType)typeObject;
                                    writeSpaceTypeSpaceAttribute(space, spaceType, cobie);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static String pSetCommonGuidFromSpace(IfcSpace space)
    {
        String guid = "";
        for (IfcRelDefines relDefines : space.getIsDefinedBy())
        {
            if (relDefines instanceof IfcRelDefinesByProperties)
            {
                IfcRelDefinesByProperties relPropDef = (IfcRelDefinesByProperties)relDefines;

                IfcPropertySetDefinition pSetDef = relPropDef.getRelatingPropertyDefinition();
                if (pSetDef.getName().equalsIgnoreCase(ATTRIBUTE_SPACE_TYPE_PSET_NAME))
                {
                    guid = pSetDef.getGlobalId().getWrappedValue();
                }
            }
        }
        if (COBieUtility.isNA(guid))
        {
            guid = GuidCompressor.getNewIfcGloballyUniqueId();
        }
        return guid;

    }

    public static void writeAttributes(COBIEType cType, IfcModelInterface model)
    {
        LogHandler loggerHandler = new LogHandler(cobieSheet, LOGGER);
        loggerHandler.sheetWriteBegin();
        IfcToAttribute.writeObjectAttributes(getBuildings(model), getCobieAttributes(cType), model, loggerHandler);
        IfcToAttribute.writeObjectAttributes(getFloors(model), getCobieAttributes(cType), model, loggerHandler);
        IfcToAttribute.writeObjectAttributes(getSpaces(model), getCobieAttributes(cType), model, loggerHandler);
        IfcToAttribute.writeTypesComponents(cType, model, loggerHandler);
        emulateSpaceTypeRelationships(cType, model);
        loggerHandler.sheetWritten();
    }

    private static void writeSpaceTypeSpaceAttribute(IfcSpace space, IfcSpaceType spaceType, COBIEType cobie)
    {
        COBIEType.Attributes attributes;
        if (cobie.getAttributes() == null)
        {
            attributes = cobie.addNewAttributes();
        } else
        {
            attributes = cobie.getAttributes();
        }
        AttributeType attribute = attributes.addNewAttribute();
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
}
