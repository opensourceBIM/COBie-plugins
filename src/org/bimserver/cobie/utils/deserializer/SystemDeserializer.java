package org.bimserver.cobie.utils.deserializer;

import java.util.ArrayList;
import java.util.HashMap;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.SystemType;
import org.bimserver.cobie.plugins.COBieIfcModel;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.IfcClassificationReference;
import org.bimserver.models.ifc2x3.IfcProduct;
import org.bimserver.models.ifc2x3.IfcRelAssignsToGroup;
import org.bimserver.models.ifc2x3.IfcSystem;

public class SystemDeserializer 
{
	private COBieIfcModel model;
	private IfcCommonHandler ifcCommonHandler;
	private COBIEType.Systems systems;
	private HashMap<String,ArrayList<String>> systemKeyToComponentNames;
	private HashMap<String, Long> systemNameToGroupRelationOid;
	public SystemDeserializer(COBieIfcModel cobieIfcModel, IfcCommonHandler ifcCommonHandler, COBIEType.Systems systems)
	{
		this.model = cobieIfcModel;
		this.ifcCommonHandler = ifcCommonHandler;
		this.systems = systems;
		systemKeyToComponentNames = new HashMap<String,ArrayList<String>>();
		systemNameToGroupRelationOid = new HashMap<String,Long>();
	}
	
	public void deserializeSystems()
	{
		if (systems!=null && systems.getSystemArray()!=null)
		{
			this.populateSystemNameCategoryComponentNames();
			for(SystemType system: systems.getSystemArray())
			{
				try
				{
					String systemKey = systemKeyFromSystem(system);
					if (!model.containsSystem(systemKey) && this.systemKeyToComponentNames.containsKey(systemKey))
					{
						addNewSystem(system);
					}

				}
				catch(Exception e)
				{
					String noop="";
				}
			}
		}
	}

	private void addNewSystem(SystemType system) 
	{
		String systemKey = systemKeyFromSystem(system);
		IfcSystem ifcSystem = ifcSystemFromCOBieSystem(system);
		ArrayList<String> componentNames = systemKeyToComponentNames.get(systemKey);
		populateSystemComponentRelationships(ifcSystem,componentNames);
	}
	
	public void populateSystemComponentRelationships(IfcSystem system, ArrayList<String> componentNames)
	{
		for(String componentName : componentNames)
		{
			IfcProduct component = (IfcProduct) model.get(model.getComponentOid(componentName));
			relAssignsToGroupFromSystemAndComponent(system,component);
		}
	}
	
	
	public IfcRelAssignsToGroup relAssignsToGroupFromSystemAndComponent(IfcSystem system,IfcProduct component)
	{
		IfcRelAssignsToGroup groupAssignment;
		String systemKey = SystemDeserializer.systemKeyFromSystem(system);
		if (systemNameToGroupRelationOid.containsKey(systemKey))
			groupAssignment = (IfcRelAssignsToGroup) model.get(systemNameToGroupRelationOid.get(systemKey));
		else
		{
			groupAssignment = Ifc2x3Factory.eINSTANCE.createIfcRelAssignsToGroup();
			groupAssignment.setRelatingGroup(system);
			groupAssignment.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid());
			groupAssignment.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().DefaultOwnerHistory());
			groupAssignment.setName(system.getName()+" to "+ component.getName()+ " relation");
			long relOid = model.add(groupAssignment,ifcCommonHandler.getOidProvider());
			systemNameToGroupRelationOid.put(systemKey, relOid);
		}
		groupAssignment.getRelatedObjects().add(component);
		return groupAssignment;
	}
	
	public static String systemKeyFromSystem(SystemType system)
	{
		String name = system.getName();
		String category = system.getCategory();
		return systemKeyFromNameCategory(name,category);
	}
	
	public static String systemKeyFromNameCategory(String name, String category)
	{
		String nameCopy = name;
		String categoryCopy = category;
		if (nameCopy==null) 
			name = "";
		if (categoryCopy==null)
			category="";
		return name+COBieUtility.getCOBieDelim()+category;
	}
	
	public static String systemKeyFromSystem(IfcSystem system)
	{
		String name = system.getName();
		String category = COBieUtility.getObjectClassification(system);
		if (COBieUtility.isNA(category))
			category = system.getObjectType();
		return systemKeyFromNameCategory(name,category);
	}
	
	private IfcSystem ifcSystemFromCOBieSystem(SystemType system)
	{
		IfcSystem ifcSystem =
				Ifc2x3Factory.eINSTANCE.createIfcSystem();
		String externalObject =
				system.getExtObject();
		
		try
		{
			IdEObject genericType =
					FromCOBieToIfc.newIdEObject(externalObject);
			ifcSystem = (IfcSystem) genericType;
		}
		catch(Exception e)
		{
			ifcSystem =
					Ifc2x3Factory.eINSTANCE.createIfcSystem();
		}
		String Name=COBieUtility.getCOBieString(system.getName());
		String Description=COBieUtility.getCOBieString(system.getDescription());
		ifcSystem.setGlobalId(ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(system.getExtIdentifier(),false));
		ifcSystem.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailAndTimestamp(system.getCreatedBy(), system.getCreatedOn()));
		ifcSystem.setName(Name);
		ifcSystem.setDescription(Description);
		ifcSystem.setObjectType(system.getCategory());
		if (ifcSystem instanceof IfcSystem)
			model.add(ifcSystem,ifcCommonHandler.getOidProvider());
		IfcClassificationReference classRef =
				ifcCommonHandler.getClassificationHandler().classificationReferenceFromString(system.getCategory());
		if (classRef!=null)
			ifcCommonHandler.getClassificationHandler().addClassificationReferenceToObject(classRef, ifcSystem);
		return ifcSystem;
	}
	
	private void populateSystemNameCategoryComponentNames()
	{
		String componentNames;
		String systemKey;
		ArrayList<String> componentNameList;
		for(SystemType system : systems.getSystemArray())
		{
			systemKey = systemKeyFromSystem(system);
			if (systemKeyToComponentNames.containsKey(systemKey))
				componentNameList = systemKeyToComponentNames.get(systemKey);
			else
				componentNameList = new ArrayList<String>();
			try
			{
				componentNames = system.getComponentNames();
				if (isComponentNamesDelimList(componentNames))
				{
					String[] componentNameArray = componentNames.split(COBieUtility.getCOBieDelim());
					for(String componentName : componentNameArray)
					{
						addToComponentListIgnoreDuplicates(componentName.trim(), componentNameList);
					}
				}
				else
				{
					addToComponentListIgnoreDuplicates(componentNames, componentNameList);
				}
				systemKeyToComponentNames.put(systemKey, componentNameList);
			}
			catch(Exception e)
			{
				
			}
		}	
	}
	
	private void addToComponentListIgnoreDuplicates(String componentName,ArrayList<String> componentNames)
	{
		if (!componentNames.contains(componentName) && model.containsComponent(componentName))
			componentNames.add(componentName);
	}
	public boolean isComponentNamesDelimList(String componentNames)
	{
		boolean isDelim = false;
		if (componentNames.contains(COBieUtility.getCOBieDelim()))
			isDelim=true;
		return isDelim;
	}
	
}
