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
import org.bimserver.cobie.plugins.COBieIfcModel;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.deserializer.propertysets.Pset_Component;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.IfcOwnerHistory;
import org.bimserver.models.ifc2x3.IfcProduct;


public class ComponentDeserializer 
{
	private COBieIfcModel model;
	private IfcCommonHandler ifcCommonHandler;
	private COBIEType.Components components;
	public ComponentDeserializer(COBieIfcModel cobieIfcModel, IfcCommonHandler ifcCommonHandler, COBIEType.Components components)
	{
		this.model = cobieIfcModel;
		this.ifcCommonHandler = ifcCommonHandler;
		this.components = components;
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
					IfcProduct newProduct = ComponentDeserializer
							.productFromComponent(component);
					if (newProduct != null && !model.containsComponent(name))
					{
						createdBy = component.getCreatedBy();
						externalId = component.getExtIdentifier();
						createdOn = component.getCreatedOn();
						IfcOwnerHistory ownerHistory = this
								.ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailAndTimestamp(createdBy, createdOn);
						newProduct.setOwnerHistory(ownerHistory);
						newProduct.setGlobalId(this
								.ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(externalId));
						Pset_Component psetComponent = new Pset_Component(component);
						this.ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToObject(newProduct,
								psetComponent, true);
						component.getTypeName();
						component.getSpace();
						model.addComponent(newProduct, component,this.ifcCommonHandler);
					}
				} catch (Exception e)
				{
				}
				
			}
			try
			{
				model.setSpaceAggregates(ifcCommonHandler);
			}
			catch(Exception e)
			{
				
			}
			try
			{
				model.setComponentTypeRelations(ifcCommonHandler);
			}
			catch(Exception e)
			{
				
			}
		}

	}
	
	
	
	public static IfcProduct productFromComponent(ComponentType component)
	{
		IfcProduct product =
				Ifc2x3Factory.eINSTANCE.createIfcProduct();
		String externalObject =
				component.getExtObject();
		IdEObject genericType =
				FromCOBieToIfc.newIdEObject(externalObject);
		String Name=COBieUtility.getCOBieString(component.getName());
		String Description=COBieUtility.getCOBieString(component.getDescription());
		

		if (genericType instanceof IfcProduct)
		{
			product = (IfcProduct) genericType;
			product.setName(Name);
			product.setDescription(Description);
		}
		return product;
	}
	
}
