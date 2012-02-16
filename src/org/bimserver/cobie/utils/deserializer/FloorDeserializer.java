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

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.FloorType;
import org.bimserver.cobie.plugins.COBieIfcModel;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.stringwriters.DeserializerStaticStrings;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.IfcBuilding;
import org.bimserver.models.ifc2x3.IfcBuildingStorey;
import org.bimserver.models.ifc2x3.IfcClassification;
import org.bimserver.models.ifc2x3.IfcClassificationReference;
import org.bimserver.models.ifc2x3.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3.IfcLengthMeasure;
import org.bimserver.models.ifc2x3.IfcOwnerHistory;
import org.bimserver.models.ifc2x3.IfcPropertySet;
import org.bimserver.models.ifc2x3.IfcQuantityLength;
import org.bimserver.models.ifc2x3.IfcRelAggregates;


public class FloorDeserializer 
{
	private COBieIfcModel model;
	private COBIEType.Floors floors;
	private IfcCommonHandler ifcCommonHandler;
	public FloorDeserializer(COBieIfcModel cobieIfcModel, COBIEType.Floors floors, IfcCommonHandler ifcCommonHandler)
	{
		this.model = cobieIfcModel;
		this.floors = floors;
		this.ifcCommonHandler = ifcCommonHandler;
	}
	
	public void deserializeFloors()
	{

		long tmpOid;
		String name;
		String createdBy;
		String externalId;
		Calendar createdOn;
		try
		{

			if (floors != null)
			{
				for (FloorType floor : floors.getFloorArray())
				{
					name = floor.getName();
					if (!model.containsFloor(name))
					{
						createdBy = floor.getCreatedBy();
						externalId = floor.getExtIdentifier();
						createdOn = floor.getCreatedOn();
						IfcOwnerHistory ownerHistory = this
								.ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailAndTimestamp(createdBy, createdOn);
						IfcBuildingStorey buildingStorey = 
								buildingStoreyFromFloor(floor);
						buildingStorey.setOwnerHistory(ownerHistory);
						IfcGloballyUniqueId guid = this
								.ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(externalId);
						buildingStorey.setGlobalId(guid);
						IfcPropertySet psetHeight = PropertySetHandler
								.heightPropertySetFromFloor(floor);
						this.ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToObject(buildingStorey,
								psetHeight, true);
						buildingStorey.setElevation(
							elevationFromFloor(floor));
						IfcClassificationReference classification = 
								classificationReferenceFromFloor(floor);

						tmpOid = model.add(buildingStorey, ifcCommonHandler.getOidProvider());
						buildingStorey = (IfcBuildingStorey) model.get(tmpOid);
						if (classification != null)
						{
							ifcCommonHandler.getClassificationHandler().addClassificationReferenceToObject(classification,
									buildingStorey);
						}
						
					}
				}
				setFacilityAggregates();
			}

		} catch (Exception e)
		{

		}

	}
	public static IfcBuildingStorey buildingStoreyFromFloor(FloorType floor)
	{
		IfcBuildingStorey buildingStorey =
				Ifc2x3Factory.eINSTANCE.createIfcBuildingStorey();
		buildingStorey.setName(floor.getName());
		buildingStorey.setDescription(floor.getDescription());
		float elevation = Float.parseFloat(floor.getElevation());
		buildingStorey.setElevation(elevation);
		return buildingStorey;
	}
	
	public static IfcClassification classificationFromFloor(FloorType floor)
	{
		IfcClassification classification = 
				Ifc2x3Factory.eINSTANCE.createIfcClassification();
		String category = floor.getCategory();
		if (!COBieUtility.isNA(category))
		{
			classification.setName(floor.getCategory());
			return classification;
		}
		else
			return null;
	}
	
	public  IfcClassificationReference classificationReferenceFromFloor(FloorType floor)
	{
		return ifcCommonHandler.getClassificationHandler().classificationReferenceFromString(floor.getCategory());
	}
	
	public static IfcQuantityLength quantityLengthFromFloor(FloorType floor) throws Exception
	{
		IfcQuantityLength quanLength =
				Ifc2x3Factory.eINSTANCE.createIfcQuantityLength();
		try
		{
			quanLength.setLengthValue(Float.parseFloat(floor.getHeight()));
		}
		catch(Exception e)
		{
			throw e;
		}
		return quanLength;	
	}
	
	public static IfcLengthMeasure storeyHeightFromFloor(FloorType floor) 
	{
		IfcLengthMeasure lMeasure =
				Ifc2x3Factory.eINSTANCE.createIfcLengthMeasure();
		float height;
		try
		{
			height = Float.parseFloat(floor.getHeight());
			lMeasure.setWrappedValue(height);
		}
		catch(Exception e)
		{
			height = 0;
		}
		return lMeasure;
	}
	
	public static float elevationFromFloor(FloorType floor) 
	{
		float elevation;
		try
		{
			elevation = Float.parseFloat(floor.getElevation());
		}
		catch(Exception e)
		{
			elevation = 0;
		}
		return elevation;
	}
	
	private void setFacilityAggregates()
	{
		if (model.getFloorCount() > 0)
		{
			IfcBuilding building = model.getFirstFacility();
			ArrayList<IfcBuildingStorey> storeys = new ArrayList<IfcBuildingStorey>();
			for (String floorName : model.getFloorNames())
				storeys.add(model.getFloorByName(floorName));
			IfcRelAggregates aggregatesBuilding = Ifc2x3Factory.eINSTANCE
					.createIfcRelAggregates();
			aggregatesBuilding.setName(DeserializerStaticStrings
					.getBuildingRelAggregatesName());
			aggregatesBuilding.setDescription(DeserializerStaticStrings
					.getBuildingRelAggregatesDescription());
			aggregatesBuilding.setOwnerHistory(this.ifcCommonHandler.getOwnerHistoryHandler().DefaultOwnerHistory());
			aggregatesBuilding.setGlobalId(this.ifcCommonHandler.getGuidHandler().newGuid());
			aggregatesBuilding.setRelatingObject(building);
			for (IfcBuildingStorey floor : storeys)
				aggregatesBuilding.getRelatedObjects().add(floor);
			model.add(aggregatesBuilding, ifcCommonHandler.getOidProvider());
		}
	}
	
}
