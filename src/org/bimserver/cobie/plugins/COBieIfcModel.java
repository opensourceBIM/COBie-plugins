package org.bimserver.cobie.plugins;
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
import java.util.HashMap;
import java.util.Map;

import org.bimserver.cobie.cobielite.ComponentType;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.cobiewriters.IfcToFacility;
import org.bimserver.cobie.utils.cobiewriters.IfcToFloor;
import org.bimserver.cobie.utils.cobiewriters.IfcToSpace;
import org.bimserver.cobie.utils.deserializer.IfcCommonHandler;
import org.bimserver.cobie.utils.stringwriters.DeserializerStaticStrings;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.IfcBuilding;
import org.bimserver.models.ifc2x3.IfcBuildingStorey;
import org.bimserver.models.ifc2x3.IfcObjectDefinition;
import org.bimserver.models.ifc2x3.IfcOwnerHistory;
import org.bimserver.models.ifc2x3.IfcPersonAndOrganization;
import org.bimserver.models.ifc2x3.IfcProduct;
import org.bimserver.models.ifc2x3.IfcRelAggregates;
import org.bimserver.models.ifc2x3.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3.IfcSpace;
import org.bimserver.models.ifc2x3.IfcTypeObject;
import org.bimserver.plugins.serializers.OidProvider;


import com.google.common.collect.BiMap;

public class COBieIfcModel extends IfcModel {

	private Map<String, Long> componentNameToOid;

	private Map<String, Long> EmailToIfcOwnerHistoryOid;

	private Map<String, Long> EmailToPersonAndOrganizationOid;
		
	private Map<String, Long> enumerationNameToOid;
	
	private Map<String, Long> FacilityNameToOid;
	

	
	private Map<String, Long> FloorNameToOid;
	
	private Map<String, ArrayList<String>> FloorNameToSpaceNames;
	
	private Map<String, ArrayList<String>> spaceNameToComponentNames;
	
	private Map<String, Long> SpaceNameToOid;

	
	private Map<String, ArrayList<String>> typeNameToComponentNames;

	private Map<String, Long> TypeNameToOid;

	private Map<String, Long> unitNameToOid;

	private Long firstFacilityOid;

	public COBieIfcModel() {
		super();
		initializeHashMaps();
		// TODO Auto-generated constructor stub
	}

	public COBieIfcModel(BiMap<Long, IdEObject> objects) {
		super(objects);
		// TODO Auto-generated constructor stub
	}

	public COBieIfcModel(int size) {
		super(size);
		initializeHashMaps();
		// TODO Auto-generated constructor stub
	}
	
	public long add(IdEObject eObject, OidProvider oidProvider) 
	{
		long oid = oidProvider.newOid();
		this.add(oid, eObject);
		objectAdded(eObject,oid);
		return oid;
	}
	
	public long addComponent(IfcProduct product, ComponentType component, IfcCommonHandler ifcCommonHandler)
	{
		long oid = ifcCommonHandler.getOidProvider().newOid();
		this.add(oid, product);
		componentAdded(product,oid,component,ifcCommonHandler);
		return oid;
	}

	
	private void assignComponentToSpace(ComponentType component)
	{
		ArrayList<String> spaceComponents = new ArrayList<String>();
		String componentName = component.getName();
		String spaceName = component.getSpace();
		if (!COBieUtility.isNA(spaceName)
				&& SpaceNameToOid.containsKey(spaceName))
		{
			if (spaceNameToComponentNames.containsKey(spaceName))
				spaceComponents = spaceNameToComponentNames.get(spaceName);
			if (!spaceComponents.contains(componentName))
			{
				spaceComponents.add(componentName);
				spaceNameToComponentNames.put(spaceName, spaceComponents);
			}
		}
	}

	public void setSpaceAggregates(IfcCommonHandler ifcCommonHandler)
	{
		ArrayList<String> ComponentNames;
		long SpaceOid, ComponentOid;
		for (String SpaceName : spaceNameToComponentNames.keySet())
		{
			if (SpaceNameToOid.containsKey(SpaceName))
			{
				SpaceOid = SpaceNameToOid.get(SpaceName);
				IfcSpace Space = (IfcSpace) this.get(SpaceOid);
				ComponentNames = spaceNameToComponentNames.get(SpaceName);
				IfcRelContainedInSpatialStructure aggregatesSpace = Ifc2x3Factory.eINSTANCE
						.createIfcRelContainedInSpatialStructure();
				// IfcRelAggregates aggregatesSpace =
				// Ifc2x3Factory.eINSTANCE.createIfcRelAggregates();
				aggregatesSpace.setName(DeserializerStaticStrings
						.getStoreyRelAggregatesName());
				aggregatesSpace.setDescription(DeserializerStaticStrings
						.getStoreyRelAggregatesDescription());
				aggregatesSpace.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().DefaultOwnerHistory());
				aggregatesSpace.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid());
				aggregatesSpace.setRelatingStructure(Space);
				// aggregatesSpace.setRelatingObject(Space);
				if (ComponentNames != null)
				{
					for (String ComponentName : ComponentNames)
					{
						ComponentOid = componentNameToOid.get(ComponentName);
						IfcProduct component = (IfcProduct) this.get(ComponentOid);
						// aggregatesSpace.getRelatedObjects().add(component);
						aggregatesSpace.getRelatedElements().add(component);
					}
				}
				this.add(aggregatesSpace, ifcCommonHandler.getOidProvider());
			}
		}
	}
	
	public void setComponentTypeRelations(IfcCommonHandler ifcCommonHandler)
	{
		ArrayList<String> ComponentNames;
		long TypeOid, ComponentOid, RelOid;
		for (String TypeName : typeNameToComponentNames.keySet())
		{
			TypeOid = TypeNameToOid.get(TypeName);
			IfcTypeObject typeObject = (IfcTypeObject) this.get(TypeOid);
			ComponentNames = typeNameToComponentNames.get(TypeName);
			IfcRelDefinesByType defByType = Ifc2x3Factory.eINSTANCE
					.createIfcRelDefinesByType();
			defByType.setName(DeserializerStaticStrings
					.getComponentRelDefinesByTypeName());
			defByType.setDescription(DeserializerStaticStrings
					.getComponentRelDefinesByTypeDescription());
			defByType.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().DefaultOwnerHistory());
			defByType.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid());
			defByType.setRelatingType(typeObject);
			if (ComponentNames != null)
			{
				for (String ComponentName : ComponentNames)
				{
					ComponentOid = componentNameToOid.get(ComponentName);
					IfcProduct component = (IfcProduct) this.get(ComponentOid);
					defByType.getRelatedObjects().add(component);

				}
				RelOid = this.add(defByType, ifcCommonHandler.getOidProvider());
				for (String ComponentName : ComponentNames)
				{
					ComponentOid = componentNameToOid.get(ComponentName);
					IfcProduct component = (IfcProduct) this.get(ComponentOid);
					component.getIsDefinedBy().add(
							(IfcRelDefinesByType) this.get(RelOid));
				}
			}

		}

	}
	
	private void assignComponentToType(ComponentType component)
	{
		ArrayList<String> typeComponents = new ArrayList<String>();
		String componentName = component.getName();
		String typeName = component.getTypeName();
		if (!COBieUtility.isNA(typeName) && TypeNameToOid.containsKey(typeName))
		{
			if (typeNameToComponentNames.containsKey(typeName))
				typeComponents = typeNameToComponentNames.get(typeName);
			if (!typeComponents.contains(componentName))
			{
				typeComponents.add(componentName);
				typeNameToComponentNames.put(typeName, typeComponents);
			}
		}
	}
	
	public boolean containsContact(String email)
	{
		return EmailToPersonAndOrganizationOid.containsKey(email);
	}

	public boolean containsCreatedBy(String email)
	{
		return EmailToIfcOwnerHistoryOid.containsKey(email);
	}
	
	public boolean containsFacility(String facilityName)
	{
		return FacilityNameToOid.containsKey(facilityName);
	}
	
	public boolean containsComponent(String componentName)
	{
		return this.componentNameToOid.containsKey(componentName);
	}

	public IfcPersonAndOrganization getContact(String email)
	{
		if (containsContact(email))
			return (IfcPersonAndOrganization) this.get(EmailToPersonAndOrganizationOid.get(email));
		else
			return null;
	}

	public Long getContactOid(String email)
	{
		if (EmailToPersonAndOrganizationOid.containsKey(email))
			return EmailToPersonAndOrganizationOid.get(email);
		else
			return null;
	}
	
	public Map<String,Long> getEmailToIfcOwnerHistoryOid()
	{
		return this.EmailToIfcOwnerHistoryOid;
	}

	public Map<String, Long> getEnumerationNameToOid()
	{
		return enumerationNameToOid;
	}

	public Map<String, Long> getFacilityNameToOid()
	{
		return FacilityNameToOid;
	}


	public Long getFacilityOid(String facilityName)
	{
		if (FacilityNameToOid.containsKey(facilityName))
			return FacilityNameToOid.get(facilityName);
		else 
			return null;
	}
	
	public Long getTypeOid(String typeName)
	{
		if (TypeNameToOid.containsKey(typeName))
			return TypeNameToOid.get(typeName);
		else
			return null;
	}
	
	public Long getComponentOid(String componentName)
	{
		if (this.componentNameToOid.containsKey(componentName))
			return componentNameToOid.get(componentName);
		else
			return null;
	}

	public Long getFloorOid(String floorName)
	{
		if (FloorNameToOid.containsKey(floorName))
			return FloorNameToOid.get(floorName);
		else
			return null;
	}


	public IfcOwnerHistory getOwnerHistory(String email)
	{
		if (containsCreatedBy(email))
			return (IfcOwnerHistory) this.get(EmailToIfcOwnerHistoryOid.get(email));
		else
			return null;
	}
	
	public IfcSpace getSpaceFromName(String spaceName)
	{
		return (IfcSpace) this.get(SpaceNameToOid.get(spaceName));
	}
	

	
	public ArrayList<String> getFloorNames()
	{
		ArrayList<String> floorNames = new ArrayList<String>();
		for(String key : this.FloorNameToOid.keySet())
			floorNames.add(key);
		return floorNames;
	}
	
	public ArrayList<String> getFloorSpaceNames(String floorName)
	{
		if (this.FloorNameToSpaceNames.containsKey(floorName))
			return this.FloorNameToSpaceNames.get(floorName);
		else
			return null;
	}
	

	public boolean containsSpace(String spaceName)
	{
		return SpaceNameToOid.containsKey(spaceName);
	}
	
	public Long getSpaceOid(String spaceName)
	{
		return SpaceNameToOid.get(spaceName);
	}
		
	public Map<String, Long> getUnitNameToOid()
	{
		return unitNameToOid;
	}

	public int getFacilityCount()
	{
		return FacilityNameToOid.size();
	}
	
	private void contactAdded(IfcPersonAndOrganization personOrg,Long oid)
	{
		String email = COBieUtility.getEmailFromPersonAndOrganization(personOrg);
		if (!containsContact(email))
			EmailToPersonAndOrganizationOid.put(email, oid);
	}
	
	private void createdByAdded(IfcOwnerHistory ownerHistory,Long oid)
	{
		String email = COBieUtility.getEmailFromOwnerHistory(ownerHistory);
		contactAdded(ownerHistory.getOwningUser(),oid);
		if (!containsCreatedBy(email))
			EmailToIfcOwnerHistoryOid.put(email, oid);
	}
	
	private void facilityAdded(IfcBuilding facility, Long oid)
	{
		String name = IfcToFacility.nameFromBuildign(facility);
		if (getFacilityCount()==0)
			this.firstFacilityOid = oid;
		if (!FacilityNameToOid.containsKey(name))
			FacilityNameToOid.put(name, oid);

	}
	
	private void componentAdded(IfcProduct product, Long oid,ComponentType component,IfcCommonHandler ifcCommonHandler)
	{
		if (!containsComponent(product.getName()))
		{
			this.componentNameToOid.put(product.getName(), oid);
			assignComponentToSpace(component);
			assignComponentToType(component);
		}
	}
	
	public Long getFirstFacilityOid()
	{
		return this.firstFacilityOid;
	}
	
	public IfcBuilding getFirstFacility()
	{
		return (IfcBuilding) this.get(getFirstFacilityOid());
	}
	
	private void initializeHashMaps()
	{
		setEmailToIfcOwnerHistoryOid(new HashMap<String,Long>());
		setEmailToPersonAndOrganizationOid(new HashMap<String,Long>());
		setEnumerationNameToOid(new HashMap<String,Long>());
		setUnitNameToOid(new HashMap<String,Long>());
		setFacilityNameToOid(new HashMap<String, Long>());
		setFloorNameToOid(new HashMap<String, Long>());
		setSpaceNameToOid(new HashMap<String, Long>());
		setTypeNameToOid(new HashMap<String, Long>());
		setFloorNameToSpaceNames(new HashMap<String, ArrayList<String>>());
		setComponentNameToOid(new HashMap<String, Long>());
		setSpaceNameToComponentNames(new HashMap<String, ArrayList<String>>());
		setTypeNameToComponentNames(new HashMap<String, ArrayList<String>>());
	}
	
	private void objectAdded(IdEObject eObject,Long oid)
	{
		if(eObject instanceof IfcPersonAndOrganization)
			contactAdded((IfcPersonAndOrganization) eObject,oid);
		else if (eObject instanceof IfcOwnerHistory)
			createdByAdded((IfcOwnerHistory)eObject,oid);
		else if (eObject instanceof IfcBuilding)
			facilityAdded((IfcBuilding)eObject,oid);
		else if (eObject instanceof IfcBuildingStorey)
			floorAdded((IfcBuildingStorey)eObject,oid);
		else if (eObject instanceof IfcSpace)
			spaceAdded((IfcSpace)eObject,oid);
		else if (eObject instanceof IfcRelAggregates)
			relAggregatesAdded((IfcRelAggregates)eObject);
		else if (eObject instanceof IfcTypeObject)
			typeAdded((IfcTypeObject)eObject,oid);
	}
	
	private void relAggregatesAdded(IfcRelAggregates relAggregates)
	{
		if(relAggregates.getRelatingObject() instanceof IfcBuildingStorey)
		{
			floorAggregateAdded(relAggregates);
		}
	}
	
	private void typeAdded(IfcTypeObject type,Long oid)
	{
		String typeName = type.getName();
		if (!this.TypeNameToOid.containsKey(typeName))
			TypeNameToOid.put(typeName, oid);
	}
	
	public boolean containsType(String typeName)
	{
		return this.TypeNameToOid.containsKey(typeName);
	}
	
	private void floorAggregateAdded(IfcRelAggregates relAggregates)
	{
		IfcBuildingStorey buildingStorey = (IfcBuildingStorey) relAggregates.getRelatingObject();
		for(IfcObjectDefinition obj : relAggregates.getRelatedObjects())
		{
			if (obj instanceof IfcSpace)
			{
				IfcSpace tmpSpace =(IfcSpace) obj;
				assignSpaceToFloor(tmpSpace, buildingStorey);
				
			}
		}
	}
	
	private void floorAdded(IfcBuildingStorey floor, Long oid)
	{
		String floorName = floor.getName();
		if (!FloorNameToOid.containsKey(floorName))
			FloorNameToOid.put(floorName, oid);
	}
	
	private void spaceAdded(IfcSpace space, Long oid)
	{
		String spaceName = space.getName();
		if(!SpaceNameToOid.containsKey(spaceName))
		{
			SpaceNameToOid.put(spaceName, oid);
		}
	}
	
	public boolean containsFloor(String floorName)
	{
		return this.FloorNameToOid.containsKey(floorName);
	}
	
	public IfcBuildingStorey getFloorByName(String floorName)
	{
		if (containsFloor(floorName))
			return (IfcBuildingStorey) this.get(FloorNameToOid.get(floorName));
			else 
				return null;
	}
	
	
	private void assignSpaceToFloor(IfcSpace space,IfcBuildingStorey floor)
	{
		ArrayList<String> floorSpaces = new ArrayList<String>();
		String spaceName = IfcToSpace.nameFromSpace(space);
		String floorName = IfcToFloor.nameFromBuildingStorey(floor);
		if (floorName != null && floorName.length() > 0
				&& containsFloor(floorName))
		{
			if (FloorNameToSpaceNames.containsKey(floorName))
				floorSpaces = FloorNameToSpaceNames.get(floorName);
			floorSpaces.add(spaceName);
			FloorNameToSpaceNames.put(floorName, floorSpaces);
		}
	}
	
	public int getFloorCount()
	{
		return FloorNameToOid.size();
	}
	
	private void setComponentNameToOid(Map<String, Long> componentNameToOid)
	{
		this.componentNameToOid = componentNameToOid;
	}
	private void setEmailToIfcOwnerHistoryOid(Map<String,Long> emailToIfcOwnerHistoryOid)
	{
		this.EmailToIfcOwnerHistoryOid = emailToIfcOwnerHistoryOid;
	}
	private void setEmailToPersonAndOrganizationOid(Map<String,Long> emailToPersonAndOrganizationOid)
	{
		this.EmailToPersonAndOrganizationOid = emailToPersonAndOrganizationOid;
	}
	private void setEnumerationNameToOid(Map<String, Long> enumerationNameToOid)
	{
		this.enumerationNameToOid = enumerationNameToOid;
	}
	private void setFacilityNameToOid(Map<String, Long> facilityNameToOid)
	{
		FacilityNameToOid = facilityNameToOid;
	}
	private void setFloorNameToOid(Map<String, Long> floorNameToOid)
	{
		FloorNameToOid = floorNameToOid;
	}
	private void setFloorNameToSpaceNames(Map<String, ArrayList<String>> floorNameToSpaceNames)
	{
		FloorNameToSpaceNames = floorNameToSpaceNames;
	}
	private void setSpaceNameToComponentNames(Map<String, ArrayList<String>> spaceNameToComponentNames)
	{
		this.spaceNameToComponentNames = spaceNameToComponentNames;
	}
	private void setSpaceNameToOid(Map<String, Long> spaceNameToOid)
	{
		SpaceNameToOid = spaceNameToOid;
	}
	private void setTypeNameToComponentNames(Map<String, ArrayList<String>> typeNameToComponentNames)
	{
		this.typeNameToComponentNames = typeNameToComponentNames;
	}
	private void setTypeNameToOid(Map<String, Long> typeNameToOid)
	{
		TypeNameToOid = typeNameToOid;
	}
	private void setUnitNameToOid(Map<String, Long> unitNameToOid)
	{
		this.unitNameToOid = unitNameToOid;
	}

}
