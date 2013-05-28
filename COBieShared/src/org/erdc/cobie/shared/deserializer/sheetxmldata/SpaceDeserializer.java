package org.erdc.cobie.shared.deserializer.sheetxmldata;

/******************************************************************************
 * Copyright (C) 2011  ERDC
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcClassificationReference;
import org.bimserver.models.ifc2x3tc1.IfcElementQuantity;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3tc1.IfcInternalOrExternalEnum;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcQuantityArea;
import org.bimserver.models.ifc2x3tc1.IfcQuantityLength;
import org.bimserver.models.ifc2x3tc1.IfcRelAggregates;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcText;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.deserializer.sheetxmldata.modelhandlers.ClassificationHandler;
import org.erdc.cobie.shared.deserializer.sheetxmldata.modelhandlers.IfcCommonHandler;
import org.erdc.cobie.shared.deserializer.sheetxmldata.modelhandlers.PropertySetHandler;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.SpaceType;
import org.erdc.cobie.utils.stringwriters.DeserializerStaticStrings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpaceDeserializer
{
    private static final IfcInternalOrExternalEnum DEFAULT_SPACE_INTERNAL_EXTERNAL = IfcInternalOrExternalEnum.INTERNAL;
    private static final String ERROR_PREFIX_LOCAL_PLACEMENT = "An error occured while attempting to initialize the object placement of space ";

    private final static String SPACE_COBIE_PROPERTY_SET_NAME = String.format(PropertySetHandler.fs_COBiePropertySetName,
            COBieUtility.CobieSheetName.Space.name());

    public static IfcElementQuantity baseQuantitiesPropertySetFromSpace(
            SpaceType cobieSpace,
            IfcOwnerHistory ownerHistory,
            IfcPropertySet psetSpaceCommon)
    {
        IfcElementQuantity elementQuantity = Ifc2x3tc1Factory.eINSTANCE.createIfcElementQuantity();
        elementQuantity.setName(getBaseQuantitiesPsetName());
        elementQuantity.setDescription(getBaseQuantitiesPsetDescription());
        elementQuantity.setMethodOfMeasurement(getBaseQuantitiesMethodOfMeasurement(cobieSpace));
        // if deriving quantities fail then try assigning them as property
        // values
        try
        {
            elementQuantity.getQuantities().add(netFloorAreaQuantityFromSpace(cobieSpace));
        } catch (Exception ex)
        {
            if (!COBieUtility.isNA(cobieSpace.getNetArea()))
            {
                ;
            }
            psetSpaceCommon.getHasProperties().add(netFloorAreaPropertyFromSpace(cobieSpace));
        }
        try
        {
            elementQuantity.getQuantities().add(grossFloorAreaQuantityFromSpace(cobieSpace));
        } catch (Exception ex)
        {
            if (!COBieUtility.isNA(cobieSpace.getGrossArea()))
            {
                psetSpaceCommon.getHasProperties().add(grossFloorAreaPropertyFromSpace(cobieSpace));
            }
        }
        try
        {
            elementQuantity.getQuantities().add(finishCeilingHeightFromSpace(cobieSpace));
        } catch (Exception ex)
        {
            if (!COBieUtility.isNA(cobieSpace.getUsableHeight()))
            {
                psetSpaceCommon.getHasProperties().add(usableHeightPropertyFromSpace(cobieSpace));
            }
        }
        elementQuantity.setOwnerHistory(ownerHistory);
        return elementQuantity;
    }

    public static IfcQuantityLength finishCeilingHeightFromSpace(SpaceType cobieSpace)
    {
        IfcQuantityLength qLength = Ifc2x3tc1Factory.eINSTANCE.createIfcQuantityLength();
        qLength.setName(getFloorFinishCeilingPropertyName());
        qLength.setDescription(getFloorFinishCeilingPropertyDescription());
        float lengthValue;
        lengthValue = Float.parseFloat(cobieSpace.getUsableHeight());
        qLength.setLengthValue(lengthValue);
        return qLength;
    }

    public static String getBaseQuantitiesMethodOfMeasurement(SpaceType space)
    {
        String methodOfMeasurement = baseQuantitiesMethodOfMeasurement;
        if (!COBieUtility.isNA(space.getExtSystem()))
        {
            methodOfMeasurement = space.getExtSystem();
        }
        return methodOfMeasurement;
    }

    private static String getBaseQuantitiesPsetDescription()
    {
        return baseQuantitiesPsetDescription;
    }

    private static String getBaseQuantitiesPsetName()
    {
        return baseQuantitiesPsetName;
    }

    private static String getFloorFinishCeilingPropertyDescription()
    {
        return FINISH_CEILING_HEIGHT_DESCRIPTION;
    }

    private static String getFloorFinishCeilingPropertyName()
    {
        return FINISH_CEILING_HEIGHT_NAME;
    }

    public static String getGrossAreaPropertyDescription()
    {
        return grossAreaPropertyDescription;
    }

    public static String getGrossAreaPropertyName()
    {
        return grossAreaPropertyName;
    }

    public static String getNetAreaPropertyDescription()
    {
        return netAreaPropertyDescription;
    }

    public static String getNetAreaPropertyName()
    {
        return netAreaPropertyName;
    }

    private static String getRoomTagPropertyDescription()
    {
        return roomTagPropertyDescription;
    }

    private static String getRoomTagPropertyName()
    {
        return roomTagPropertyName;
    }

    private static String getSpaceCommonPsetDescription()
    {
        return spaceCommonPsetDescription;
    }

    public static String getUsableHeightPropertyDescription()
    {
        return usableHeightPropertyDescription;
    }

    public static String getUsableHeightPropertyName()
    {
        return usableHeightPropertyName;
    }

    private static IfcProperty grossFloorAreaPropertyFromSpace(SpaceType cobieSpace)
    {
        IfcPropertySingleValue grossArea = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
        grossArea.setName(getGrossAreaPropertyName());
        grossArea.setDescription(getGrossAreaPropertyDescription());
        String spaceGrossArea = cobieSpace.getGrossArea();
        IfcText spaceGrossAreaText = Ifc2x3tc1Factory.eINSTANCE.createIfcText();
        spaceGrossAreaText.setWrappedValue(spaceGrossArea);
        grossArea.setNominalValue(spaceGrossAreaText);
        return grossArea;
    }

    public static IfcQuantityArea grossFloorAreaQuantityFromSpace(SpaceType cobieSpace)
    {
        IfcQuantityArea qArea = Ifc2x3tc1Factory.eINSTANCE.createIfcQuantityArea();
        qArea.setName(getGrossAreaPropertyName());
        qArea.setDescription(getGrossAreaPropertyDescription());
        float areaVal;
        areaVal = Float.parseFloat(cobieSpace.getGrossArea());
        qArea.setAreaValue(areaVal);
        return qArea;
    }

    private static IfcProperty netFloorAreaPropertyFromSpace(SpaceType cobieSpace)
    {
        IfcPropertySingleValue netArea = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
        netArea.setName(getNetAreaPropertyName());
        netArea.setDescription(getNetAreaPropertyDescription());
        String spaceNetArea = cobieSpace.getNetArea();
        IfcText netAreaText = Ifc2x3tc1Factory.eINSTANCE.createIfcText();
        netAreaText.setWrappedValue(spaceNetArea);
        netArea.setNominalValue(netAreaText);
        return netArea;
    }

    public static IfcQuantityArea netFloorAreaQuantityFromSpace(SpaceType cobieSpace)
    {
        IfcQuantityArea qArea = Ifc2x3tc1Factory.eINSTANCE.createIfcQuantityArea();
        qArea.setName(getNetAreaPropertyName());
        qArea.setDescription(getNetAreaPropertyDescription());
        float areaVal;
        areaVal = Float.parseFloat(cobieSpace.getNetArea());
        qArea.setAreaValue(areaVal);
        return qArea;
    }

    private static IfcPropertySingleValue roomTagPropertyFromSpace(SpaceType cobieSpace)
    {
        IfcPropertySingleValue roomTag = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
        roomTag.setName(getRoomTagPropertyName());
        roomTag.setDescription(getRoomTagPropertyDescription());
        String spaceRoomTag = cobieSpace.getRoomTag();
        IfcLabel lblRoomTag = Ifc2x3tc1Factory.eINSTANCE.createIfcLabel();
        lblRoomTag.setWrappedValue(spaceRoomTag);
        roomTag.setNominalValue(lblRoomTag);
        return roomTag;
    }

    public static IfcPropertySet spaceCommonPropertySetFromSpace(SpaceType cobieSpace)
    {
        IfcPropertySet propertySet = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySet();
        propertySet.setName(SPACE_COBIE_PROPERTY_SET_NAME);
        propertySet.setDescription(getSpaceCommonPsetDescription());
        IfcPropertySingleValue roomTag = roomTagPropertyFromSpace(cobieSpace);
        // IfcPropertySingleValue usableHeight =
        // usableHeightPropertyFromSpace(cobieSpace);
        propertySet.getHasProperties().add(roomTag);
        // propertySet.getHasProperties().add(usableHeight);
        return propertySet;
    }

    private static IfcPropertySingleValue usableHeightPropertyFromSpace(SpaceType cobieSpace)
    {
        String usableHeightString = cobieSpace.getUsableHeight();

        IfcPropertySingleValue usableHeight = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
        usableHeight.setName(getUsableHeightPropertyName());
        usableHeight.setDescription(getUsableHeightPropertyDescription());

        if (!COBieUtility.isNA(usableHeightString))
        {
            IfcText value = Ifc2x3tc1Factory.eINSTANCE.createIfcText();
            value.setWrappedValue(usableHeightString);
            usableHeight.setNominalValue(value);
        }
        return usableHeight;

    }

    private COBieIfcModel model;

    private IfcCommonHandler ifcCommonHandler;

    private COBIEType.Spaces spaces;

    private Map<String, ArrayList<String>> FloorNameSpaceNames;

    private static final Logger LOGGER = LoggerFactory.getLogger(SpaceDeserializer.class);

    private static final String roomTagPropertyName = "RoomTag";

    private static final String roomTagPropertyDescription = "Occupiers room identification";

    protected static final String baseQuantitiesPsetName = "qto_SpaceBaseQuantities";

    private static final String spaceCommonPsetDescription = "Properties for Space found in COBie";

    private static final String baseQuantitiesPsetDescription = "Base Quantities";

    private static final String baseQuantitiesMethodOfMeasurement = "GSA BIM Area";

    private static final String usableHeightPropertyName = "UsableHeight";

    private static final String usableHeightPropertyDescription = "indicative usable height";

    private static final String grossAreaPropertyName = "GrossFloorArea";

    private static final String grossAreaPropertyDescription = "Gross Floor Area";

    private static final String netAreaPropertyName = "NetFloorArea";

    private static final String netAreaPropertyDescription = "Net Floor Area";

    private static final String FINISH_CEILING_HEIGHT_NAME = "FinishCeilingHeight";
    private static final String FINISH_CEILING_HEIGHT_DESCRIPTION = "Height of the suspended ceiling (from top of flooring to the bottom of the suspended ceiling). To be provided only if the space has a suspended ceiling with constant height.";

    public SpaceDeserializer(COBieIfcModel cobieIfcModel, IfcCommonHandler ifcCommonHandler, COBIEType.Spaces spaces)
    {
        model = cobieIfcModel;
        this.ifcCommonHandler = ifcCommonHandler;
        this.spaces = spaces;
        init();
    }

    public List<IfcClassificationReference> classificationReferencesFromSpace(SpaceType cobieSpace) throws IfcModelInterfaceException
    {
        return ifcCommonHandler.getClassificationHandler().classificationReferencesFromString(cobieSpace.getCategory());
    }

    public void deserializeSpaces()
    {
        String name;
        String createdBy;
        String externalId;
        Calendar createdOn;
        String category;
        try
        {
            if (spaces != null)
            {
                for (SpaceType space : spaces.getSpaceArray())
                {
                    name = space.getName();
                    if (!model.containsSpace(name))
                    {
                        IfcSpace newSpace = spaceFromCOBieSpace(space);
                        category = space.getCategory();
                        newSpace.setInteriorOrExteriorSpace(DEFAULT_SPACE_INTERNAL_EXTERNAL);
                        createdBy = space.getCreatedBy();
                        externalId = space.getExtIdentifier();
                        IfcGloballyUniqueId guid = ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(externalId);
                        createdOn = space.getCreatedOn();
                        IfcOwnerHistory ownerHistory = ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(
                                createdBy, createdOn, space.getExtSystem());
                        newSpace.setGlobalId(guid.getWrappedValue());
                        String objectType = ClassificationHandler.objectTypeFromCategoryString(category);
                        if (!COBieUtility.isNA(objectType))
                        {
                            newSpace.setObjectType(objectType);
                        }
                        newSpace.setOwnerHistory(ownerHistory);
                        List<IfcClassificationReference> classifications = classificationReferencesFromSpace(space);
                        IfcPropertySet psetSpaceCommon = SpaceDeserializer.spaceCommonPropertySetFromSpace(space);
                        IfcElementQuantity psetBaseQuantities = SpaceDeserializer.baseQuantitiesPropertySetFromSpace(space, ownerHistory,
                                psetSpaceCommon);
                        ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToObject(newSpace, psetSpaceCommon, true);
                        ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToObject(newSpace, psetBaseQuantities, false);
                        model.add(newSpace, ifcCommonHandler.getOidProvider());
                        mapSpaceToFloor(name, space.getFloorName());
                        for (IfcClassificationReference classification : classifications)
                        {
                            ifcCommonHandler.getClassificationHandler().addClassificationReferenceToObject(classification, newSpace);
                        }
                    }
                }
            }

        } catch (Exception e)
        {

        }
        try
        {
            setFloorAggregates();
        } catch (Exception e)
        {

        }
    }

    private void init()
    {
        FloorNameSpaceNames = new HashMap<String, ArrayList<String>>();
    }

    private void mapSpaceToFloor(String spaceName, String floorName)
    {
        ArrayList<String> floorSpaces = new ArrayList<String>();
        if ((floorName != null) && (floorName.length() > 0) && model.containsFloor(floorName))
        {
            if (FloorNameSpaceNames.containsKey(floorName))
            {
                floorSpaces = FloorNameSpaceNames.get(floorName);
            }
            floorSpaces.add(spaceName);
            FloorNameSpaceNames.put(floorName, floorSpaces);
        }
    }

    private void setFloorAggregates()
    {
        ArrayList<String> spaceNames;
        long floorOid, spaceOid;
        for (String floorName : model.getFloorNames())
        {
            floorOid = model.getFloorOid(floorName);
            IfcBuildingStorey floor = (IfcBuildingStorey)model.get(floorOid);
            spaceNames = FloorNameSpaceNames.get(floorName);
            if ((spaceNames != null) && (spaceNames.size() > 0))
            {
                IfcRelAggregates aggregatesFloor = Ifc2x3tc1Factory.eINSTANCE.createIfcRelAggregates();
                aggregatesFloor.setName(DeserializerStaticStrings.getStoreyRelAggregatesName());
                aggregatesFloor.setDescription(DeserializerStaticStrings.getStoreyRelAggregatesDescription());
                aggregatesFloor.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().DefaultOwnerHistory());
                aggregatesFloor.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid().getWrappedValue());
                aggregatesFloor.setRelatingObject(floor);
                for (String spaceName : spaceNames)
                {
                    spaceOid = model.getSpaceOid(spaceName);
                    IfcSpace space = (IfcSpace)model.get(spaceOid);
                    aggregatesFloor.getRelatedObjects().add(space);
                }
                try
                {
                    model.add(aggregatesFloor, ifcCommonHandler.getOidProvider());
                } catch (IfcModelInterfaceException e)
                {
                    LOGGER.error("An error occured while setting a floor aggregate..." + e.getMessage());
                }
            }

        }
    }

    private void setSpaceObjectPlacement(SpaceType cobieSpace, IfcSpace ifcSpace)
    {
        try
        {
            IfcLocalPlacement floorPlacement = ifcCommonHandler.getGeometryHandler().getFloorLocalPlacement(cobieSpace.getFloorName());
            IfcLocalPlacement spacePlacement = ifcCommonHandler.getGeometryHandler().newDefaultLocalPlacement(floorPlacement);
            ifcSpace.setObjectPlacement(spacePlacement);
        } catch (Exception ex)
        {
            LOGGER.error(ERROR_PREFIX_LOCAL_PLACEMENT + cobieSpace.getName());
        }
    }

    public IfcSpace spaceFromCOBieSpace(SpaceType cobieSpace)
    {
        IfcSpace ifcSpace = Ifc2x3tc1Factory.eINSTANCE.createIfcSpace();
        ifcSpace.setName(cobieSpace.getName());
        ifcSpace.setDescription(cobieSpace.getDescription());
        setSpaceObjectPlacement(cobieSpace, ifcSpace);
        return ifcSpace;
    }
}
