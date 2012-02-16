package org.bimserver.cobie.utils.cobiewriters;
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
import java.util.Arrays;
import java.util.Calendar;

import org.bimserver.cobie.cobielite.AssemblyType;
import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.utils.COBieQuery;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.COBieUtility.CobieSheetName;
import org.bimserver.models.ifc2x3.IfcBuilding;
import org.bimserver.models.ifc2x3.IfcBuildingStorey;
import org.bimserver.models.ifc2x3.IfcMaterial;
import org.bimserver.models.ifc2x3.IfcMaterialLayer;
import org.bimserver.models.ifc2x3.IfcMaterialLayerSet;
import org.bimserver.models.ifc2x3.IfcObjectDefinition;
import org.bimserver.models.ifc2x3.IfcOwnerHistory;
import org.bimserver.models.ifc2x3.IfcProject;
import org.bimserver.models.ifc2x3.IfcRelAggregates;
import org.bimserver.models.ifc2x3.IfcRelNests;
import org.bimserver.models.ifc2x3.IfcRelationship;
import org.bimserver.models.ifc2x3.IfcSite;
import org.bimserver.models.ifc2x3.IfcSpace;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IfcToAssembly 
{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcToAssembly.class);
	private static final ArrayList<String> typeSheetNames =
			new ArrayList<String>(Arrays.asList("Type","Style"));
	private static ArrayList<String> getTypeSheetNames()
	{
		return typeSheetNames;
	}
	private static final ArrayList<String> spaceSheetNames =
			 new ArrayList<String> (Arrays.asList("Space"));
	private static final ArrayList<String> systemSheetNames =
			new ArrayList<String>(Arrays.asList("System"));
	private static final ArrayList<String> zoneSheetNames =
			new ArrayList<String>( Arrays.asList("Zone"));
	private static final ArrayList<String> floorSheetNames =
			new ArrayList<String>(Arrays.asList("Storey"));
	private static final ArrayList<String> facilitySheetNames =
			new ArrayList<String>(Arrays.asList("Site","Project","Building"));
	private static CobieSheetName SheetName = CobieSheetName.Assembly;
	protected static final String nameSuffix = " assembly";
	protected static final String typeSheetName = "Type";
	protected static final String spaceSheetName = "Space";
	protected static final String systemSheetName = "System";
	protected static final String zoneSheetName = "Zone";
	protected static final String floorSheetName = "Floor";
	protected static final String facilitySheetName = "Facility";
	protected static final String componentSheetName = "Component";
	protected static final String assetTypeFixed = "Fixed";
	protected static final String assetTypeLayer = "Layer";
	
	public static void writeAssembliesToCOBie(COBIEType cobie, IfcModelInterface model)
	{
		LogHandler loggerStrings =
				new LogHandler(SheetName,LOGGER);
		loggerStrings.sheetWriteBegin();
		
		COBIEType.Assemblies assemblies;
		try
		{
			assemblies = cobie.getAssemblies();
			if (assemblies == null)
				assemblies = cobie.addNewAssemblies();
		}
		catch(Exception ex)
		{
			assemblies = cobie.addNewAssemblies();
		}
		
		serializeMaterialLayerAssembliesOneRelationPairPerRow(model, loggerStrings,
				cobie);
		ArrayList<IfcRelationship> relationships = assemblyRelationshipsFromModel(model);
		IfcOwnerHistory oh = COBieUtility.firstOwnerHistoryFromModel(model);
		serializeRelationshipAssembliesOneRelationPairPerRow(loggerStrings, oh,cobie,
				relationships);
		loggerStrings.sheetWritten();
		
	}

	private static void serializeRelationshipAssemblies(
			LogHandler loggerStrings, IfcOwnerHistory oh,
			COBIEType.Assemblies assemblies,
			ArrayList<IfcRelationship> relationships)
	{
		String name;
		String createdBy;
		Calendar createdOn;
		String sheetName;
		String parentName;
		String childNames;
		String assemblyType;
		String extSystem;
		String extObject;
		String description;
		AssemblyType tmpAssembly;
		for (IfcRelationship relationship : relationships)
		{
			try
			{
				tmpAssembly = assemblies.addNewAssembly();
				name = IfcToAssembly.nameFromRelationship(relationship);
				createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
				createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
				sheetName = IfcToAssembly.sheetNameFromRelationship(relationship);
				parentName = IfcToAssembly.parentNameFromRelationship(relationship);
				childNames = IfcToAssembly.childNamesFromRelationship(relationship);
				assemblyType = IfcToAssembly.assemblyTypeFromRelationship(relationship);
				extSystem = COBieUtility.getApplicationName(oh);
				extObject = COBieUtility.extObjectFromRelationship(relationship);
				description = IfcToAssembly.descriptionFromRelationship(relationship);	
				
				tmpAssembly.setName(name);
				tmpAssembly.setCreatedBy(createdBy);
				tmpAssembly.setCreatedOn(createdOn);
				tmpAssembly.setSheetName(sheetName);
				tmpAssembly.setParentName(parentName);
				tmpAssembly.setChildNames(childNames);
				tmpAssembly.setAssemblyType(assemblyType);
				tmpAssembly.setExtSystem(extSystem);
				tmpAssembly.setExtObject(extObject);
				tmpAssembly.setExtIdentifier(relationship.getGlobalId().getWrappedValue());
				tmpAssembly.setDescription(description);
				loggerStrings.rowWritten();
			}
			catch(Exception ex)
			{
				loggerStrings.error(ex);
			}
		}
	}
	
	private static boolean parentIntegrityValid(String parentName, COBIEType cobie,String sheetName)
	{
		boolean isValid = false;
		if (sheetName.toLowerCase().equals(COBieUtility.CobieSheetName.Component.toString().toLowerCase()))
		{
			isValid = COBieQuery.isNameInComponent(parentName, cobie);
		}
		else if (sheetName.toLowerCase().equals(COBieUtility.CobieSheetName.Type.toString().toLowerCase()))
		{
			isValid = COBieQuery.isNameInType(parentName, cobie);
		}
		return isValid;
	}
	
	private static void serializeRelationshipAssembliesOneRelationPairPerRow(
			LogHandler loggerStrings, IfcOwnerHistory oh,
			COBIEType cobie,
			ArrayList<IfcRelationship> relationships)
	{
		COBIEType.Assemblies assemblies = cobie.getAssemblies();
		String name;
		String createdBy;
		Calendar createdOn;
		String sheetName;
		String parentName;
		String childNames;
		String assemblyType;
		String extSystem;
		String extObject;
		String description;
		AssemblyType tmpAssembly;
		for (IfcRelationship relationship : relationships)
		{
			try
			{
				ArrayList<String> children = IfcToAssembly.childNameArrayFromRelationship(relationship);
				sheetName = IfcToAssembly.sheetNameFromRelationship(relationship);
				parentName = IfcToAssembly.parentNameFromRelationship(relationship);
				if (parentIntegrityValid(parentName,cobie,sheetName))
				{
					for(String child : children)
					{
						tmpAssembly = assemblies.addNewAssembly();
						name = IfcToAssembly.nameFromRelationship(relationship);
						createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
						createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
						assemblyType = IfcToAssembly.assemblyTypeFromRelationship(relationship);
						extSystem = COBieUtility.getApplicationName(oh);
						extObject = COBieUtility.extObjectFromRelationship(relationship);
						description = IfcToAssembly.descriptionFromRelationship(relationship);	
						
						tmpAssembly.setName(name);
						tmpAssembly.setCreatedBy(createdBy);
						tmpAssembly.setCreatedOn(createdOn);
						tmpAssembly.setSheetName(sheetName);
						tmpAssembly.setParentName(parentName);
						tmpAssembly.setChildNames(child);
						tmpAssembly.setAssemblyType(assemblyType);
						tmpAssembly.setExtSystem(extSystem);
						tmpAssembly.setExtObject(extObject);
						tmpAssembly.setExtIdentifier(relationship.getGlobalId().getWrappedValue());
						tmpAssembly.setDescription(description);
						loggerStrings.rowWritten();
					}
				}
				
				
			}
			catch(Exception ex)
			{
				loggerStrings.error(ex);
			}
		}
	}


	private static ArrayList<IfcRelationship> assemblyRelationshipsFromModel(
			IfcModelInterface model)
	{
		ArrayList<IfcRelationship> relationships = 
				new ArrayList<IfcRelationship>();
		for(IfcRelAggregates relAgg : model.getAll(IfcRelAggregates.class))
			if (IfcToAssembly.relationIsAssembly(relAgg))
				relationships.add(relAgg);
				
		for(IfcRelNests relNest : model.getAll(IfcRelNests.class))
			if (IfcToAssembly.relationIsAssembly(relNest))
				relationships.add(relNest);
		return relationships;
	}

	private static void serializeMaterialLayerAssemblies(
			IfcModelInterface model, LogHandler loggerStrings,
			COBIEType.Assemblies assemblies)
	{
		String name;
		String createdBy;
		Calendar createdOn;
		String sheetName;
		String parentName;
		String childNames;
		String assemblyType;
		String extSystem;
		String description;
		String extObject = IfcMaterialLayerSet.class.getSimpleName();
		AssemblyType tmpAssembly;
		IfcOwnerHistory oh = COBieUtility.firstOwnerHistoryFromModel(model);
		for(IfcMaterialLayerSet layerSet : model.getAll(IfcMaterialLayerSet.class))
		{
			try
			{
				tmpAssembly = assemblies.addNewAssembly();
				name = IfcToAssembly.nameFromMaterialLayerSet(layerSet);
				createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
				createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
				sheetName = IfcToAssembly.sheetNameFromMaterialLayerSet(layerSet);
				parentName = IfcToAssembly.parenetNameFromMaterialLayerSet(layerSet);
				childNames = IfcToAssembly.childNamesFromMaterialLayerSet(layerSet);
				assemblyType = IfcToAssembly.assemblyTypeFromMaterialLayerSet(layerSet);
				extSystem = COBieUtility.getApplicationName(oh);
				description = IfcToAssembly.descriptionFromMaterialLayerSet(layerSet);
				
				tmpAssembly.setName(name);
				tmpAssembly.setCreatedBy(createdBy);
				tmpAssembly.setCreatedOn(createdOn);
				tmpAssembly.setSheetName(sheetName);
				tmpAssembly.setParentName(parentName);
				tmpAssembly.setChildNames(childNames);
				tmpAssembly.setAssemblyType(assemblyType);
				tmpAssembly.setExtSystem(extSystem);
				tmpAssembly.setExtObject(extObject);
				tmpAssembly.setExtIdentifier(COBieUtility.COBieNA);
				tmpAssembly.setDescription(description);
				loggerStrings.rowWritten();
			}
			catch(Exception ex)
			{
				loggerStrings.error(ex);
			}
			
			
		}
	}
	
	private static void serializeMaterialLayerAssembliesOneRelationPairPerRow(
			IfcModelInterface model, LogHandler loggerStrings,
			COBIEType cobie)
	{
		COBIEType.Assemblies assemblies = cobie.getAssemblies();
		String name;
		String createdBy;
		Calendar createdOn;
		String sheetName;
		String parentName;
		String childNames;
		String assemblyType;
		String extSystem;
		String description;
		String extObject = IfcMaterialLayerSet.class.getSimpleName();
		AssemblyType tmpAssembly;
		IfcOwnerHistory oh = COBieUtility.firstOwnerHistoryFromModel(model);
		for(IfcMaterialLayerSet layerSet : model.getAll(IfcMaterialLayerSet.class))
		{
			try
			{
				ArrayList<String> children = IfcToAssembly.childNameArrayFromMaterialLayerSet(layerSet);
				sheetName = IfcToAssembly.sheetNameFromMaterialLayerSet(layerSet);
				parentName = IfcToAssembly.parenetNameFromMaterialLayerSet(layerSet);
				if (IfcToAssembly.parentIntegrityValid(parentName, cobie, sheetName))
				{
					for(String child : children)
					{
						tmpAssembly = assemblies.addNewAssembly();
						name = IfcToAssembly.nameFromMaterialLayerSet(layerSet);
						createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
						createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
						sheetName = IfcToAssembly.sheetNameFromMaterialLayerSet(layerSet);
						parentName = IfcToAssembly.parenetNameFromMaterialLayerSet(layerSet);
						assemblyType = IfcToAssembly.assemblyTypeFromMaterialLayerSet(layerSet);
						extSystem = COBieUtility.getApplicationName(oh);
						description = IfcToAssembly.descriptionFromMaterialLayerSet(layerSet);
						
						tmpAssembly.setName(name);
						tmpAssembly.setCreatedBy(createdBy);
						tmpAssembly.setCreatedOn(createdOn);
						tmpAssembly.setSheetName(sheetName);
						tmpAssembly.setParentName(parentName);
						tmpAssembly.setChildNames(child);
						tmpAssembly.setAssemblyType(assemblyType);
						tmpAssembly.setExtSystem(extSystem);
						tmpAssembly.setExtObject(extObject);
						tmpAssembly.setExtIdentifier(COBieUtility.COBieNA);
						tmpAssembly.setDescription(description);
						loggerStrings.rowWritten();
					}
				}
				
				
			}
			catch(Exception ex)
			{
				loggerStrings.error(ex);
			}
			
			
		}
	}
	
	protected static String namePrefixFromRelationship(IfcRelationship relation)
	{
		String name = "";
		name = relation.getName();
		if (relation instanceof IfcRelAggregates)
		{
			IfcRelAggregates relAgg = (IfcRelAggregates) relation;
			name = relAgg.getRelatingObject().getName();
		}
		else if (relation instanceof IfcRelNests)
		{
			IfcRelNests relNests = (IfcRelNests) relation;
			name =  relNests.getRelatingObject().getName();
		}
		return name;
	}
	
	protected static String namePrefixFromMaterialLayerSet(IfcMaterialLayerSet materialLayerSet)
	{
		String name = materialLayerSet.getLayerSetName();
		return name;
	}
	
	protected static String nameFromRelationship(IfcRelationship relation)
	{
		String name =
				namePrefixFromRelationship(relation);
		if (name!=null && name.length()>0)
			name += nameSuffix;
		return COBieUtility.getCOBieString(name);
	}
	
	protected static String nameFromMaterialLayerSet(IfcMaterialLayerSet materialLayerSet)
	{
		String name = namePrefixFromMaterialLayerSet(materialLayerSet);
		if (name !=null && name.length()>0)
			name += nameSuffix;
		return COBieUtility.getCOBieString(name);
	}
	
	protected static String sheetNameFromRelationship(IfcRelationship relation)
	{
		String sheetName = "";
		String tmpName = nameFromRelationship(relation);
		if (COBieUtility.stringContainsOneOf(tmpName, getTypeSheetNames()))
			sheetName = typeSheetName;
		else if (COBieUtility.stringContainsOneOf(tmpName, spaceSheetNames))
			sheetName = spaceSheetName;
		else if (COBieUtility.stringContainsOneOf(tmpName,systemSheetNames))
			sheetName = systemSheetName;
		else if (COBieUtility.stringContainsOneOf(tmpName, zoneSheetNames))
			sheetName = zoneSheetName;
		else if (COBieUtility.stringContainsOneOf(tmpName, floorSheetNames))
			sheetName = floorSheetName;
		else if (COBieUtility.stringContainsOneOf(tmpName, facilitySheetNames))
			sheetName = facilitySheetName;		
		else 
			sheetName = componentSheetName;
		return COBieUtility.getCOBieString(sheetName);
	}
	
	protected static String sheetNameFromMaterialLayerSet(IfcMaterialLayerSet layerSet)
	{
		return typeSheetName;
	}
	
	protected static String parentNameFromRelationship(IfcRelationship relation)
	{
		String pName =
				namePrefixFromRelationship(relation);
		return COBieUtility.getCOBieString(pName);
	}
	
	protected static String parenetNameFromMaterialLayerSet(IfcMaterialLayerSet layerSet)
	{
		String pName =
				namePrefixFromMaterialLayerSet(layerSet);
		return COBieUtility.getCOBieString(pName);
	}
	
	protected static String childNamesFromMaterialLayerSet(IfcMaterialLayerSet layerSet)
	{
		ArrayList<String> children = new ArrayList<String>();
		String strChildren = "";
		for(IfcMaterialLayer layer : layerSet.getMaterialLayers())
		{
			IfcMaterial material =
					layer.getMaterial();
			String materialName = material.getName();
			if (!children.contains(materialName))
				children.add(materialName);
		}
		strChildren = COBieUtility.delimittedStringFromArrayList(children);
		return COBieUtility.getCOBieString(strChildren);
	}
	
	protected static ArrayList<String> childNameArrayFromMaterialLayerSet(IfcMaterialLayerSet layerSet)
	{
		ArrayList<String> children = new ArrayList<String>();
		for(IfcMaterialLayer layer : layerSet.getMaterialLayers())
		{
			IfcMaterial material =
					layer.getMaterial();
			String materialName = material.getName();
			if (!children.contains(materialName))
				children.add(materialName);
		}
		return children;
	}
	
	protected static String childNamesFromRelationship(IfcRelationship relationship)
	{
		String strChildren = "";
		ArrayList<String> children = new ArrayList<String>();
		if (relationship instanceof IfcRelAggregates)
		{
			IfcRelAggregates relAgg = (IfcRelAggregates) relationship;
			for(IfcObjectDefinition objDef : relAgg.getRelatedObjects())
			{
				if (IfcToComponent.isAssetComponent(objDef)|| objDef instanceof IfcSpace)
					children.add(objDef.getName());
			}

		}
		else if (relationship instanceof IfcRelNests)
		{
			IfcRelNests relNests = (IfcRelNests) relationship;
			for(IfcObjectDefinition objDef : relNests.getRelatedObjects())
			{
				if (IfcToComponent.isAssetComponent(objDef) || objDef instanceof IfcSpace)
					children.add(objDef.getName());
			}
		}
		strChildren = COBieUtility.delimittedStringFromArrayList(children);
		return COBieUtility.getCOBieString(strChildren);
	}
	
	protected static ArrayList<String> childNameArrayFromRelationship(IfcRelationship relationship)
	{
		ArrayList<String> children = new ArrayList<String>();
		if (relationship instanceof IfcRelAggregates)
		{
			IfcRelAggregates relAgg = (IfcRelAggregates) relationship;
			for(IfcObjectDefinition objDef : relAgg.getRelatedObjects())
			{
				if (IfcToComponent.isAssetComponent(objDef)|| objDef instanceof IfcSpace)
					children.add(objDef.getName());
			}

		}
		else if (relationship instanceof IfcRelNests)
		{
			IfcRelNests relNests = (IfcRelNests) relationship;
			for(IfcObjectDefinition objDef : relNests.getRelatedObjects())
			{
				if (IfcToComponent.isAssetComponent(objDef) || objDef instanceof IfcSpace)
					children.add(objDef.getName());
			}
		}
		return children;
	}
	
	protected static String assemblyTypeFromRelationship(IfcRelationship relationship)
	{
		return assetTypeFixed;
	}
	
	protected static String assemblyTypeFromMaterialLayerSet(IfcMaterialLayerSet layerSet)
	{
		return assetTypeLayer;
	}
	
	protected static String descriptionFromRelationship(IfcRelationship relationship)
	{
		String description = relationship.getDescription();
		if (description == null || description.length()==0)
			description = relationship.getName();
		return COBieUtility.getCOBieString(description);
	}
	
	protected static String descriptionFromMaterialLayerSet(IfcMaterialLayerSet layerSet)
	{
		return COBieUtility.getCOBieString(layerSet.getLayerSetName());
	}
	
	protected static boolean relationIsAssembly(IfcRelationship relationship)
	{
		//relating object can't be IfcSite, IfcProject,IfcBuilding, or IfcBuildingStorey
		boolean isAssembly = false;
		IfcObjectDefinition relatingObject = null;
		if (relationship instanceof IfcRelAggregates)
		{
			IfcRelAggregates relAgg = (IfcRelAggregates) relationship;
			relatingObject = relAgg.getRelatingObject();
		}
		
		if (relationship instanceof IfcRelNests)
		{
			IfcRelNests relNests = (IfcRelNests) relationship;
			relatingObject = relNests.getRelatingObject();
		}
		
		if (!(relatingObject instanceof IfcSite) && !(relatingObject instanceof IfcProject)&&
			!(relatingObject instanceof IfcBuilding) && !(relatingObject instanceof IfcBuildingStorey))
		{
			isAssembly = true;
		}
		return isAssembly;
	}
	
}
