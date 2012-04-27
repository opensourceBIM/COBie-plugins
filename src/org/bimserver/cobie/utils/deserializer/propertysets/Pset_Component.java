package org.bimserver.cobie.utils.deserializer.propertysets;
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
import java.util.HashMap;
import java.util.Map;

import org.bimserver.cobie.cobielite.ComponentType;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.impl.IfcPropertySetImpl;


public class Pset_Component extends IfcPropertySetImpl
{
	public static final String pSetName = "Pset_Component";
	public static final String pSetDescription= "Properties for Component found in COBie";
	public static enum ComponentField
	{
		SerialNumber,InstallationDate,WarrantyStartDate,TagNumber,BarCode,AssetIdentifier
	}
	private static final Map<ComponentField,String> PropertyDescriptions =
			new HashMap<ComponentField,String>()
			{/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

			{
				put(ComponentField.SerialNumber,"The manufacturers unique component identifier");
				put(ComponentField.InstallationDate,"Date of installation");
				put(ComponentField.WarrantyStartDate,"Date of warranty start");
				put(ComponentField.TagNumber,"Occupiers unique tag");
				put(ComponentField.BarCode,"Identifying barcode or rfid");
				put(ComponentField.AssetIdentifier,"Asset identification label");

			}};
	public Pset_Component()
	{
		super();
		setDirectAttributes();
		initializeSingleValueAttributes();
	}
	
	public Pset_Component(ComponentType component)
	{
		this();
		setSerialNumber(component);
		setInstallationDate(component);
		setWarrantyStartDate(component);
		setTagNumber(component);
		setBarCode(component);
		setAssetIdentifier(component);
	}
	
	private void setSerialNumber(ComponentType component)
	{
		IfcLabel serialLbl =
				PropertyUtility.initializeLabel(component.getSerialNumber());
		PropertySetUtility.setPropertySetPropertyValueOfName
		(ComponentField.SerialNumber.toString(),this,serialLbl);
	}
	
	private void setInstallationDate(ComponentType component)
	{
		IfcLabel installLbl =
				PropertyUtility.initializeLabel(component.getInstallationDate());
		PropertySetUtility.setPropertySetPropertyValueOfName
		(ComponentField.InstallationDate.toString(),this,installLbl);
	}
	
	private void setWarrantyStartDate(ComponentType component)
	{
		IfcLabel warrantyStart =
				PropertyUtility.initializeLabel(component.getWarrantyStartDate());
		PropertySetUtility.setPropertySetPropertyValueOfName
		(ComponentField.WarrantyStartDate.toString(),this,warrantyStart);
	}
	
	private void setTagNumber(ComponentType component)
	{
		IfcLabel tagNumberLbl =
				PropertyUtility.initializeLabel(component.getTagNumber());
		PropertySetUtility.setPropertySetPropertyValueOfName
		(ComponentField.TagNumber.toString(),this,tagNumberLbl);
	}
	
	private void setBarCode(ComponentType component)
	{
		IfcLabel barcodeLbl =
				PropertyUtility.initializeLabel(component.getBarCode());
		PropertySetUtility.setPropertySetPropertyValueOfName
		(ComponentField.BarCode.toString(),this,barcodeLbl);
	}
	
	private void setAssetIdentifier(ComponentType component)
	{
		IfcLabel assetidentifierLbl =
				PropertyUtility.initializeLabel(component.getAssetIdentifier());
		PropertySetUtility.setPropertySetPropertyValueOfName
		(ComponentField.AssetIdentifier.toString(),this,assetidentifierLbl);
	}
	
	public void setDirectAttributes()
	{
		this.setName(pSetName);
		this.setDescription(pSetDescription);
	}
	public void initializeSingleValueAttributes()
	{
		for (ComponentField field : ComponentField.values())
		{
			IfcPropertySingleValue sVal =
					Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
			sVal.setName(field.toString());
			sVal.setDescription(PropertyDescriptions.get(field));
			this.getHasProperties().add(sVal);
		}
	}
}
