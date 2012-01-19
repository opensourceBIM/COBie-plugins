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

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.SystemType;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.COBieUtility.CobieSheetName;
import org.bimserver.cobie.utils.stringwriters.IfcSingleValueToCOBieString;
import org.bimserver.models.ifc2x3.IfcGroup;
import org.bimserver.models.ifc2x3.IfcObjectDefinition;
import org.bimserver.models.ifc2x3.IfcOwnerHistory;
import org.bimserver.models.ifc2x3.IfcProduct;
import org.bimserver.models.ifc2x3.IfcProperty;
import org.bimserver.models.ifc2x3.IfcPropertySet;
import org.bimserver.models.ifc2x3.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3.IfcRelAssignsToGroup;
import org.bimserver.models.ifc2x3.IfcRelDefines;
import org.bimserver.models.ifc2x3.IfcRelDefinesByProperties;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IfcToSystem 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcToSystem.class);
	private static final CobieSheetName sheetName = CobieSheetName.System;
	private static final ArrayList<String> systemIfcClassNames = 
			new ArrayList<String>(Arrays.asList("IfcSystem","IfcElectricalCircuit"
					,"IfcGroup"));
	private static final String systemCircuitNumber = "Circuit Number";
	private static final String systemTypeProperty = "System Type";
	private static final String systemCircuitCategory = "circuit";
	private static final ArrayList<String> systemIfcPropertySingleValueNames = 
			new ArrayList<String>(Arrays.asList(systemCircuitNumber,"System Name"));
	
	protected static ArrayList<String> getSystemIfcClassNames()
	{
		return systemIfcClassNames;
	}
	
	protected static ArrayList<String> getSystemIfcPropertySingleValueNames()
	{
		return systemIfcPropertySingleValueNames;
	}
	public static COBIEType writeSystemsToCOBie(COBIEType cType, IfcModelInterface model)
	{
		LogHandler loggerHandler = new LogHandler(sheetName,LOGGER);
		loggerHandler.sheetWriteBegin();
		COBIEType.Systems systems =
				cType.addNewSystems();
		String name = "";
		String createdBy = "";
		Calendar createdOn;
		String category = "";
		String componentNames = "";
		String extSystem = "";
		String extObject = "";
		String extIdentifier = "";
		String description = "";
		IfcOwnerHistory oh;
		ArrayList<String> existingSystems = new ArrayList<String>();
		for (IfcGroup ifcGroup : model.getAll(IfcGroup.class))
		{
			try
			{
				name = IfcToSystem.nameFromGroup(ifcGroup);
				extObject = IfcToSystem.extObjectFromGroup(ifcGroup);
				if (!existingSystems.contains(name) && 
						IfcToSystem.getSystemIfcClassNames().contains(extObject))
				{
					existingSystems.add(name);
					oh = ifcGroup.getOwnerHistory();
					createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
					createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
					category = IfcToSystem.categoryFromGroup(ifcGroup);
					componentNames = IfcToSystem.componentsFromGroup(ifcGroup);
					extSystem = COBieUtility.getApplicationName(oh);
					extIdentifier = COBieUtility.identifierFromObjectDefinition(ifcGroup);
					description = IfcToSystem.descriptionFromGroup(ifcGroup);
					
					SystemType newSystem =
							systems.addNewSystem();
					newSystem.setName(name);
					newSystem.setCreatedBy(createdBy);
					newSystem.setCreatedOn(createdOn);
					newSystem.setCategory(category);
					newSystem.setComponentNames(componentNames);
					newSystem.setExtSystem(extSystem);
					newSystem.setExtObject(extObject);
					newSystem.setExtIdentifier(extIdentifier);
					newSystem.setDescription(description);
					loggerHandler.rowWritten();
				}		
			}
			catch(Exception ex)
			{
				loggerHandler.error(ex);
			}
			
		}
		cType = altWriteSystemsToCOBie(cType,model,loggerHandler);
		loggerHandler.sheetWritten();
		return cType;			
	}
	
	private static COBIEType altWriteSystemsToCOBie(COBIEType cType, IfcModelInterface model,LogHandler loggerHandler)
	{
		COBIEType.Systems systems =
				cType.getSystems();
		String name = "";
		String createdBy = "";
		Calendar createdOn;
		String category = "";
		String componentNames = "";
		String extSystem = "";
		String extObject = "";
		String extIdentifier = "";
		String description = "";
		IfcOwnerHistory oh;
		IfcSingleValueToCOBieString vStr;
		String propertyName = "";
		ArrayList<String> existingSystems = new ArrayList<String>();
		ArrayList<IfcProduct> componentProducts =
				IfcToComponent.getComponentProducts(cType, model);
		ArrayList<String> compProdNames =
				new ArrayList<String>();
		for (IfcProduct product : componentProducts)
			compProdNames.add(product.getName());
		for (IfcProduct component : componentProducts)
		{
			for (IfcRelDefines relDefines : component.getIsDefinedBy())
			{
				if (relDefines instanceof IfcRelDefinesByProperties)
				{
					IfcRelDefinesByProperties relDefByProp =
							(IfcRelDefinesByProperties) relDefines;
					IfcPropertySetDefinition propertySetDef  =
							relDefByProp.getRelatingPropertyDefinition();
					if (propertySetDef instanceof IfcPropertySet)
					{
						IfcPropertySet pSet =
								(IfcPropertySet) propertySetDef;
						for (IfcProperty property : pSet.getHasProperties())
						{
							propertyName = property.getName();
							if (property instanceof IfcPropertySingleValue
									&& IfcToSystem.getSystemIfcPropertySingleValueNames().contains(propertyName))
							{
								IfcPropertySingleValue val =
										(IfcPropertySingleValue) property;
								vStr = new IfcSingleValueToCOBieString(val);
								name = vStr.getValueString();
								if (!existingSystems.contains(name))
								{
									
									try {
										existingSystems.add(name);
										extObject = IfcToSystem.extObjectFromPropertySingleValue(val);
										oh = IfcToContact.getFirstOwnerHistory(model);
										createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
										createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
										category = IfcToSystem.categoryFromPropertySingleValue(val, pSet.getHasProperties());
										componentNames = IfcToSystem.componentsFromRelDefinesByProperties(relDefByProp,compProdNames);
										extSystem = COBieUtility.getApplicationName(oh);
										extIdentifier = COBieUtility.COBieNA;
										description = IfcToSystem.descriptionFromPropertySingleValue(val);
										
										SystemType newSystem =
												systems.addNewSystem();
										newSystem.setName(name);
										newSystem.setCreatedBy(createdBy);
										newSystem.setCreatedOn(createdOn);
										newSystem.setCategory(category);
										newSystem.setComponentNames(componentNames);
										newSystem.setExtSystem(extSystem);
										newSystem.setExtObject(extObject);
										newSystem.setExtIdentifier(extIdentifier);
										newSystem.setDescription(description);
										loggerHandler.rowWritten();
									} 
									catch (Exception e) 
									{
										// TODO Auto-generated catch block
										loggerHandler.error(e);
									}
								}
							}
						}
						
					}
				}
			}
		}
		return cType;			
	}
	
	protected static String nameFromGroup(IfcGroup system)
	{
		String name = system.getName();
		return COBieUtility.getCOBieString(name);
	}
	
	protected static String componentsFromGroup(IfcGroup system)
	{
		String components = "";
		IfcRelAssignsToGroup relGroup =
				system.getIsGroupedBy();
		for(IfcObjectDefinition def : relGroup.getRelatedObjects())
		{
			if(IfcToComponent.isAssetComponent(def))
			{
				components += def.getName() + ",";
			}
		}
		if (components.endsWith(","))
			components = components.substring(0,components.length()-1);
		return COBieUtility.getCOBieString(components);
	}
	
	protected static String componentsFromPropertySingleValue(IfcPropertySingleValue val)
	{
		String components = "";
		return COBieUtility.getCOBieString(components);
	}
	
	protected static String componentsFromRelDefinesByProperties
	(IfcRelDefinesByProperties rel,ArrayList<String> componentNames)
	{
		String components = "";
		String name = "";
		ArrayList<String> addedComponents = new ArrayList<String>();
		for (IfcObjectDefinition obj : rel.getRelatedObjects())
		{
			name = obj.getName();
			if (componentNames.contains(name) &&
					!addedComponents.contains(name))
			{
				addedComponents.add(name);
				components += name + ",";
			}
		}
		if (components.endsWith(","))
			components = components.substring(0,components.length()-1);
		return COBieUtility.getCOBieString(components);
	}
	
	protected static String nameFromPropertySingleValue(IfcPropertySingleValue val)
	{
		IfcSingleValueToCOBieString sValStr =
				new IfcSingleValueToCOBieString(val);
		return COBieUtility.getCOBieString(sValStr.getValueString());
	}
	
	protected static String categoryFromGroup(IfcGroup system)
	{
		return COBieUtility.getObjectClassification(system);
	}
	
	protected static String categoryFromPropertySingleValue(IfcPropertySingleValue val, EList<IfcProperty> siblingProperties)
	{
		String category = "";
		String name = val.getName();
		String tmpValName;
		IfcPropertySingleValue val2;
		if (name.equals(systemCircuitNumber))
		{
			category = IfcToSystem.systemCircuitCategory;
		}
		else
		{
			for(IfcProperty property : siblingProperties)
			{
				tmpValName = property.getName();
				if (tmpValName.equals(IfcToSystem.systemTypeProperty) &&
						property instanceof IfcPropertySingleValue)
				{
					val2 = (IfcPropertySingleValue) property;
					IfcSingleValueToCOBieString sValStr =
							new IfcSingleValueToCOBieString(val2);
					category = sValStr.getValueString();
					
				}
			}
		}
		return COBieUtility.getCOBieString(category);
	}
	
	protected static String descriptionFromGroup(IfcGroup system)
	{
		String description = system.getDescription();
		if (description!=null && description.isEmpty())
			description = system.getName();
		return COBieUtility.getCOBieString(description);
	}
	
	protected static String descriptionFromPropertySingleValue(IfcPropertySingleValue val)
	{
		String description = val.getDescription();
		if (description!=null && description.isEmpty())
			description = val.getName();
		return COBieUtility.getCOBieString(description);
	}
	
	protected static String extObjectFromGroup(IfcGroup system)
	{
		return COBieUtility.extObjectFromObjectDef(system);
	}
	
	protected static String extObjectFromPropertySingleValue(IfcPropertySingleValue val)
	{
		return IfcPropertySingleValue.class.getSimpleName();
	}

	
}
