package org.bimserver.cobie.utils.IFCWriters.PropertySets;
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
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.IfcLabel;
import org.bimserver.models.ifc2x3.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3.impl.IfcPropertySetImpl;

import cobieLite.TypeType;

public class Pset_Asset extends IfcPropertySetImpl
{
	private static final String pSetName = "Pset_Asset";
	private static final String pSetDescription = 
			"An asset is a uniquely identifiable element which has a financial " +
			"value and against which maintenance actions are recorded.";
	
	private static final String assetAccountingTypePropertyName =
			"AssetAccountingType";
	private static final String assetAccountingTypePropertyDescription =
			"Identifies the predefined types of asset from " +
			"which the type required may be set.";
	
	public Pset_Asset()
	{
		super();
		initializeSingleValueProperties();
		setDirectAttributes();
	}
	
	private void initializeSingleValueProperties()
	{
		IfcPropertySingleValue assetProperty =
				Ifc2x3Factory.eINSTANCE.createIfcPropertySingleValue();
		assetProperty.setName(getAssetAccountingTypePropertyName());
		assetProperty.setDescription(getAssetAccountingTypePropertyDescription());
		super.getHasProperties().add(assetProperty);
		
	}
	
	public void setDirectAttributes()
	{
		this.setName(getPsetName());
		this.setDescription(getPsetDescription());
	}
	
	public Pset_Asset(TypeType cobieType)
	{
		this();
		String assetType = cobieType.getAssetType();
		setAssetAccountingType(assetType);	
	}
	
	public static String getPsetName() {
		return pSetName;
	}
	
	private void setAssetAccountingType(String assetAccountingType)
	{
		String assetAccountingTypeDerived =
				assetAccountingType;
		if (assetAccountingTypeDerived.equalsIgnoreCase("fixed"))
			assetAccountingTypeDerived = "Fixed";
			else
				assetAccountingTypeDerived = "NonFixed";
		IfcLabel assetType =
				Ifc2x3Factory.eINSTANCE.createIfcLabel();
		assetType.setWrappedValue(assetAccountingTypeDerived);
		PropertySetUtility.
		setPropertySetPropertyValueOfName
		(getAssetAccountingTypePropertyName(), this,assetType);
	}
	
	public String getAssetAccountingType() 
	{
		return PropertySetUtility.getPropertySetPropertyValueOfName
				(getAssetAccountingTypePropertyName(), this);
	}
	
	private static String getPsetDescription() {
		return pSetDescription;
	}
	private static String getAssetAccountingTypePropertyName() {
		return assetAccountingTypePropertyName;
	}
	private static String getAssetAccountingTypePropertyDescription() {
		return assetAccountingTypePropertyDescription;
	}
}
