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
import java.util.Calendar;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.ComponentType;

import org.bimserver.cobie.utils.deserializer.modelhandlers.IfcCommonHandler;
import org.bimserver.cobie.utils.deserializer.propertysets.Pset_Component;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcControllerType;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3tc1.IfcSensorType;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.bimserver.shared.cobie.COBieUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ComponentDeserializer 
{
	private static final String ERROR_PREFIX_LOCAL_PLACEMENT = "An error occured when attempting to initialize the local placement of component ";
	private static final Logger LOGGER = LoggerFactory.getLogger(ComponentDeserializer.class);
	private COBieIfcModel model;
	private IfcCommonHandler ifcCommonHandler;
	private COBIEType.Components components;
	private static final String BAMIE_DEFAULT_EXT_OBJECT = "IfcDistributionElement";
	public ComponentDeserializer(COBieIfcModel cobieIfcModel, IfcCommonHandler ifcCommonHandler, COBIEType.Components components)
	{
		this.model = cobieIfcModel;
		this.ifcCommonHandler = ifcCommonHandler;
		this.components = components;
	}
	
	public boolean isComponentBAMie(ComponentType component)
	{
		return isComponentBAMie(component,model);
	}
	
	public static boolean isComponentBAMie(ComponentType component,COBieIfcModel cobieIfcModel)
	{
		boolean isBAMie = false;
		String typeName = component.getTypeName();
		if(cobieIfcModel.containsType(typeName))
		{
			IfcTypeObject typeObject = (IfcTypeObject) cobieIfcModel.get(cobieIfcModel.getTypeOid(typeName));
			if(TypeDeserializer.isTypeBAMie(typeObject))
			{
				isBAMie = true;
			}
		}
		return isBAMie;
	}
	
	public static boolean isProductAController(IfcProduct product)
	{
		boolean isAController = false;
		for(IfcRelDefines relDefines:product.getIsDefinedBy())
		{
			if(relDefines instanceof IfcRelDefinesByType &&
					((IfcRelDefinesByType)relDefines).getRelatingType() instanceof IfcControllerType)
						isAController = true;
		}
		return isAController;
	}
	
	public static IfcSensorType getSensorTypeInformationFromProduct(IfcProduct product)
	{
		IfcSensorType sensorType = null;
		if(isProductASensor(product))
		{
			for(IfcRelDefines relDefines:product.getIsDefinedBy())
			{
				if(relDefines instanceof IfcRelDefinesByType &&
						((IfcRelDefinesByType)relDefines).getRelatingType() instanceof IfcSensorType)
							sensorType = (IfcSensorType) ((IfcRelDefinesByType)relDefines).getRelatingType();
			}
		}
		return sensorType;
	}
	
	public static IfcControllerType getControllerTypeInformationFromProduct(IfcProduct product)
	{
		IfcControllerType controllerType = null;
		if(isProductAController(product))
		{
			for(IfcRelDefines relDefines:product.getIsDefinedBy())
			{
				if(relDefines instanceof IfcRelDefinesByType &&
						((IfcRelDefinesByType)relDefines).getRelatingType() instanceof IfcControllerType)
							controllerType = (IfcControllerType) ((IfcRelDefinesByType)relDefines).getRelatingType();
			}
		}
		return controllerType;
	}
	
	public static boolean isProductASensor(IfcProduct product)
	{
		boolean isASensor = false;
		for(IfcRelDefines relDefines:product.getIsDefinedBy())
		{
			if(relDefines instanceof IfcRelDefinesByType &&
					((IfcRelDefinesByType)relDefines).getRelatingType() instanceof IfcSensorType)
						isASensor = true;
		}
		return isASensor;
	}
	
	public static boolean isIfcProductBAMie(IfcProduct product)
	{
		boolean isBAMie = false;
		for(IfcRelDefines definesBy: product.getIsDefinedBy())
		{
			if(definesBy instanceof IfcRelDefinesByType)
			{
				IfcTypeObject relatingType =
						((IfcRelDefinesByType)definesBy).getRelatingType();
				if(TypeDeserializer.isTypeBAMie(relatingType))
					isBAMie = true;
			}
		}
		return isBAMie;
	}


	public void deserializeComponents()
	{
		String name = "";
		String createdBy;
		String externalId;
		Calendar createdOn;
		if (components != null)
		{
			for (ComponentType component : components.getComponentArray())
			{
				try
				{
					name = component.getName();
					component.getExtObject();
					IfcProduct newProduct = productFromComponent(component);
					if (newProduct != null && !model.containsComponent(name))
					{
						createdBy = component.getCreatedBy();
						externalId = component.getExtIdentifier();
						createdOn = component.getCreatedOn();
						IfcOwnerHistory ownerHistory = this
								.ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(createdBy, createdOn, component.getExtSystem());
						newProduct.setOwnerHistory(ownerHistory);
						newProduct.setGlobalId(this
								.ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(externalId));
						Pset_Component psetComponent = new Pset_Component(component);
						this.ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToObject(newProduct,
								psetComponent, true);
						model.addComponent(newProduct, component,this.ifcCommonHandler);
					}
				} catch (Exception e)
				{
					LOGGER.error("An exception occured while adding a component to the model "+name+"..."+e.getMessage());
				}
				
			}
			try
			{
				model.setSpaceAggregates(ifcCommonHandler);
				model.setFacilityComponentAggregates(ifcCommonHandler);
			}
			catch(Exception e)
			{
				LOGGER.error("An exception occured while assigning components to spaces..."+e.getMessage());
				e.printStackTrace();
			}
			try
			{
				model.setComponentTypeRelations(ifcCommonHandler);
				
			}
			catch(Exception e)
			{
				LOGGER.error("An Exception occured while assigning components to types..."+e.getMessage());
				e.printStackTrace();
			}
		}

	}
	
	
	
	public  IfcProduct productFromComponent(ComponentType component)
	{
		IfcProduct product;
		product = COBieUtility.ifcFactory.createIfcProduct();
		
		String externalObject = "";
		if(isComponentBAMie(component))
			externalObject = BAMIE_DEFAULT_EXT_OBJECT;
		else
			externalObject = component.getExtObject();
		IdEObject genericProduct = null;
		try
		{
			genericProduct = FromCOBieToIfc.newIdEObject(externalObject);
		}
		catch(Exception e)
		{
			genericProduct = COBieUtility.ifcFactory.createIfcFurnishingElement();
		}


		if (genericProduct!= null && genericProduct instanceof IfcProduct)
		{
			product = (IfcProduct) genericProduct;

		}
		String Name=COBieUtility.getCOBieString(component.getName());
		String Description=COBieUtility.getCOBieString(component.getDescription());
		product.setName(Name);
		product.setDescription(Description);
		setComponentLocalPlacement(component, product);
		
		return product;
	}

	private void setComponentLocalPlacement(ComponentType component,
			IfcProduct product)
	{
		try
		{
			IfcLocalPlacement spacePlacement =
					ifcCommonHandler.getGeometryHandler().getSpaceLocalPlacement(component.getSpace());
			IfcLocalPlacement componentPlacement =
					ifcCommonHandler.getGeometryHandler().newDefaultLocalPlacement(spacePlacement);
			product.setObjectPlacement(componentPlacement);
		}
		catch(Exception ex)
		{
			LOGGER.error(ERROR_PREFIX_LOCAL_PLACEMENT,component.getName());
		}
	}
	
}
