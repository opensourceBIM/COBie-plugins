package org.bimserver.cobie.utils.deserializer;
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
import java.util.Map;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.SpaceType;
import org.bimserver.cobie.plugins.COBieIfcModel;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.stringwriters.DeserializerStaticStrings;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.IfcBuildingStorey;
import org.bimserver.models.ifc2x3.IfcClassification;
import org.bimserver.models.ifc2x3.IfcClassificationReference;
import org.bimserver.models.ifc2x3.IfcElementQuantity;
import org.bimserver.models.ifc2x3.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3.IfcLabel;
import org.bimserver.models.ifc2x3.IfcLengthMeasure;
import org.bimserver.models.ifc2x3.IfcOwnerHistory;
import org.bimserver.models.ifc2x3.IfcPropertySet;
import org.bimserver.models.ifc2x3.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3.IfcQuantityArea;
import org.bimserver.models.ifc2x3.IfcRelAggregates;
import org.bimserver.models.ifc2x3.IfcSpace;


public class SpaceDeserializer 
{
	private COBieIfcModel model;
	private IfcCommonHandler ifcCommonHandler;
	private COBIEType.Spaces spaces;
	private Map<String,ArrayList<String>> FloorNameSpaceNames;
	public SpaceDeserializer(COBieIfcModel cobieIfcModel, IfcCommonHandler ifcCommonHandler, COBIEType.Spaces spaces)
	{
		this.model = cobieIfcModel;
		this.ifcCommonHandler = ifcCommonHandler;
		this.spaces = spaces;
		init();
	}
	
	private void init()
	{
		FloorNameSpaceNames = new HashMap<String,ArrayList<String>>();
	}
	
	public void deserializeSpaces()
	{
		String name;
		String createdBy;
		String externalId;
		Calendar createdOn;
		try
		{
			if (spaces != null)
			{
				for (SpaceType space : spaces.getSpaceArray())
				{
					name = space.getName();
					if (!model.containsSpace(name))
					{
						IfcSpace newSpace = SpaceDeserializer.spaceFromCOBieSpace(space);

						createdBy = space.getCreatedBy();
						externalId = space.getExtIdentifier();
						IfcGloballyUniqueId guid = this
								.ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(externalId);
						createdOn = space.getCreatedOn();
						IfcOwnerHistory ownerHistory = ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailAndTimestamp(
								createdBy, createdOn);
						newSpace.setGlobalId(guid);
						newSpace.setOwnerHistory(ownerHistory);
						IfcClassificationReference classification = classificationReferenceFromSpace(space);
						IfcPropertySet psetSpaceCommon = SpaceDeserializer
								.spaceCommonPropertySetFromSpace(space);
						IfcElementQuantity psetBaseQuantities = SpaceDeserializer
								.baseQuantitiesPropertySetFromSpace(space);
						this.ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToObject(newSpace,
								psetSpaceCommon, true);
						this.ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToObject(newSpace,
								psetBaseQuantities, false);
						model.add(newSpace, ifcCommonHandler.getOidProvider());
						mapSpaceToFloor(name,space.getFloorName());
						if (classification != null)
							this.ifcCommonHandler.getClassificationHandler().addClassificationReferenceToObject(classification,
									newSpace);
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
	
	private void mapSpaceToFloor(String spaceName, String floorName)
	{
		ArrayList<String> floorSpaces = new ArrayList<String>();
		if (floorName != null && floorName.length() > 0
				&& model.containsFloor(floorName))
		{
			if (FloorNameSpaceNames.containsKey(floorName))
				floorSpaces = FloorNameSpaceNames.get(floorName);
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
			floorOid =  model.getFloorOid(floorName);
			IfcBuildingStorey floor = (IfcBuildingStorey) model.get(floorOid);
			spaceNames = FloorNameSpaceNames.get(floorName);
			IfcRelAggregates aggregatesFloor = Ifc2x3Factory.eINSTANCE
					.createIfcRelAggregates();
			aggregatesFloor.setName(DeserializerStaticStrings
					.getStoreyRelAggregatesName());
			aggregatesFloor.setDescription(DeserializerStaticStrings
					.getStoreyRelAggregatesDescription());
			aggregatesFloor.setOwnerHistory(this.ifcCommonHandler.getOwnerHistoryHandler().DefaultOwnerHistory());
			aggregatesFloor.setGlobalId(this.ifcCommonHandler.getGuidHandler().newGuid());
			aggregatesFloor.setRelatingObject(floor);
			if (spaceNames != null)
			{
				for (String spaceName : spaceNames)
				{
					spaceOid = model.getSpaceOid(spaceName);
					IfcSpace space = (IfcSpace) model.get(spaceOid);
					aggregatesFloor.getRelatedObjects().add(space);
				}
			}
			model.add(aggregatesFloor, ifcCommonHandler.getOidProvider());
		}
	}
	

	
	private static final String roomTagPropertyName = "RoomTag";
	private static final String roomTagPropertyDescription = "Occupiers room identification";
	private static final String spaceCommonPsetName = "Pset_SpaceCommon";
	private static final String baseQuantitiesPsetName = "BaseQuantities";
	private static final String spaceCommonPsetDescription = "Properties for Space found in COBie";
	private static final String baseQuantitiesPsetDescription = "Base Quantities";
	private static final String baseQuantitiesMethodOfMeasurement = "GSA BIM Area";
	private static final String usableHeightPropertyName ="UsableHeight";
	private static final String usableHeightPropertyDescription = "indicative usable height";
	private static final String grossAreaPropertyName = "GrossFloorArea";
	private static final String grossAreaPropertyDescription = "Gross Floor Area";
	private static final String netAreaPropertyName = "NetFloorArea";
	private static final String netAreaPropertyDescription = "Net Floor Area";
	public static IfcSpace spaceFromCOBieSpace(SpaceType cobieSpace)
	{
		IfcSpace ifcSpace =
				Ifc2x3Factory.eINSTANCE.createIfcSpace();
		ifcSpace.setName(cobieSpace.getName());
		ifcSpace.setDescription(cobieSpace.getDescription());
		return ifcSpace;
	}
	
	public static IfcClassification classificationFromSpace(SpaceType cobieSpace)
	{
		IfcClassification classification =
				Ifc2x3Factory.eINSTANCE.createIfcClassification();
		String category = cobieSpace.getCategory();
		if (!COBieUtility.isNA(category))
			classification.setName(category);
		else
			classification = null;
		return classification;
	}
	
	public  IfcClassificationReference classificationReferenceFromSpace(SpaceType cobieSpace)
	{
		return ifcCommonHandler.getClassificationHandler().classificationReferenceFromString(cobieSpace.getCategory());
	}
	
	public static IfcPropertySet spaceCommonPropertySetFromSpace(SpaceType cobieSpace)
	{
		IfcPropertySet propertySet =
				Ifc2x3Factory.eINSTANCE.createIfcPropertySet();
		propertySet.setName(getSpaceCommonPsetName());
		propertySet.setDescription(getSpaceCommonPsetDescription());
		IfcPropertySingleValue roomTag =
				roomTagPropertyFromSpace(cobieSpace);
		IfcPropertySingleValue usableHeight =
				usableHeightPropertyFromSpace(cobieSpace);
		propertySet.getHasProperties().add(roomTag);
		propertySet.getHasProperties().add(usableHeight);
		return propertySet;
	}
	
	public static IfcElementQuantity baseQuantitiesPropertySetFromSpace(SpaceType cobieSpace)
	{		
			IfcElementQuantity elementQuantity =
					Ifc2x3Factory.eINSTANCE.createIfcElementQuantity();
			elementQuantity.setName(getBaseQuantitiesPsetName());
			elementQuantity.setDescription(getBaseQuantitiesPsetDescription());
			elementQuantity.setMethodOfMeasurement(getBaseQuantitiesMethodOfMeasurement());
			elementQuantity.getQuantities().add(netFloorAreaFromSpace(cobieSpace));
			elementQuantity.getQuantities().add(grossFloorAreaFromSpace(cobieSpace));
			return elementQuantity;
	}
	
	public static IfcQuantityArea netFloorAreaFromSpace(SpaceType cobieSpace)
	{
		IfcQuantityArea qArea =
				Ifc2x3Factory.eINSTANCE.createIfcQuantityArea();
		qArea.setName(getNetAreaPropertyName());
		qArea.setDescription(getNetAreaPropertyDescription());
		float areaVal;
		try
		{
			areaVal = Float.parseFloat(cobieSpace.getNetArea());
		}
		catch(Exception e)
		{
			areaVal = 0;
		}
		qArea.setAreaValue(areaVal);
		return qArea;	
	}
	
	public static IfcQuantityArea grossFloorAreaFromSpace(SpaceType cobieSpace)
	{
		IfcQuantityArea qArea =
				Ifc2x3Factory.eINSTANCE.createIfcQuantityArea();
		qArea.setName(getGrossAreaPropertyName());
		qArea.setDescription(getGrossAreaPropertyDescription());
		float areaVal;
		try
		{
			areaVal = Float.parseFloat(cobieSpace.getGrossArea());
		}
		catch(Exception e)
		{
			areaVal = 0;
		}
		qArea.setAreaValue(areaVal);
		return qArea;	
	}
	
	private static IfcPropertySingleValue roomTagPropertyFromSpace(SpaceType cobieSpace)
	{
		IfcPropertySingleValue roomTag =
				Ifc2x3Factory.eINSTANCE.createIfcPropertySingleValue();
		roomTag.setName(getRoomTagPropertyName());
		roomTag.setDescription(getRoomTagPropertyDescription());
		String spaceRoomTag = cobieSpace.getRoomTag();
		IfcLabel lblRoomTag = Ifc2x3Factory.eINSTANCE.createIfcLabel();
		lblRoomTag.setWrappedValue(spaceRoomTag);
		roomTag.setNominalValue(lblRoomTag);
		return roomTag;
	}
	
	private static IfcPropertySingleValue usableHeightPropertyFromSpace(SpaceType cobieSpace) 
	{
		String usableHeightString =
				cobieSpace.getUsableHeight();
		float usableHeightVal;
		try
		{

			usableHeightVal =
					Float.parseFloat(usableHeightString);
		}
		catch (Exception e)
		{
			usableHeightVal = 0;
		}
		IfcPropertySingleValue usableHeight =
				Ifc2x3Factory.eINSTANCE.createIfcPropertySingleValue();
		usableHeight.setName(getUsableHeightPropertyName());
		usableHeight.setDescription(getUsableHeightPropertyDescription());
		IfcLengthMeasure lengthMeasure =
				Ifc2x3Factory.eINSTANCE.createIfcLengthMeasure();
		lengthMeasure.setWrappedValue(usableHeightVal);
		usableHeight.setNominalValue(lengthMeasure);
		return usableHeight;
		
	}

	private static String getSpaceCommonPsetName() {
		return spaceCommonPsetName;
	}

	private static String getBaseQuantitiesPsetName() {
		return baseQuantitiesPsetName;
	}

	private static String getSpaceCommonPsetDescription() {
		return spaceCommonPsetDescription;
	}

	private static String getBaseQuantitiesPsetDescription() {
		return baseQuantitiesPsetDescription;
	}

	private static String getRoomTagPropertyDescription() {
		return roomTagPropertyDescription;
	}

	private static String getRoomTagPropertyName() {
		return roomTagPropertyName;
	}

	public static String getUsableHeightPropertyName() {
		return usableHeightPropertyName;
	}

	public static String getUsableHeightPropertyDescription() {
		return usableHeightPropertyDescription;
	}

	
	public static String getGrossAreaPropertyName() {
		return grossAreaPropertyName;
	}

	public static String getGrossAreaPropertyDescription() {
		return grossAreaPropertyDescription;
	}

	public static String getNetAreaPropertyName() {
		return netAreaPropertyName;
	}

	public static String getNetAreaPropertyDescription() {
		return netAreaPropertyDescription;
	}

	public static String getBaseQuantitiesMethodOfMeasurement() {
		return baseQuantitiesMethodOfMeasurement;
	}
}
