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
import org.bimserver.cobie.cobielite.TypeType;
import org.bimserver.cobie.plugins.COBieIfcModel;
import org.bimserver.cobie.utils.deserializer.propertysets.Pset_Asset;
import org.bimserver.cobie.utils.deserializer.propertysets.Pset_EconomicImpactValues;
import org.bimserver.cobie.utils.deserializer.propertysets.Pset_ManufacturersTypeInformation;
import org.bimserver.cobie.utils.deserializer.propertysets.Pset_ServiceLife;
import org.bimserver.cobie.utils.deserializer.propertysets.Pset_Specification;
import org.bimserver.cobie.utils.deserializer.propertysets.Pset_Warranty;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.IfcClassificationReference;
import org.bimserver.models.ifc2x3.IfcDoorStyle;
import org.bimserver.models.ifc2x3.IfcElementType;
import org.bimserver.models.ifc2x3.IfcMaterial;
import org.bimserver.models.ifc2x3.IfcMaterialLayer;
import org.bimserver.models.ifc2x3.IfcMaterialLayerSet;
import org.bimserver.models.ifc2x3.IfcOwnerHistory;
import org.bimserver.models.ifc2x3.IfcTypeObject;
import org.bimserver.models.ifc2x3.IfcWindowStyle;


public class TypeDeserializer 
{
	private COBieIfcModel model;
	private IfcCommonHandler ifcCommonHandler;
	private COBIEType.Types types;
	public TypeDeserializer(COBieIfcModel cobieIfcModel, IfcCommonHandler ifcCommonHandler, COBIEType.Types types)
	{
		this.model = cobieIfcModel;
		this.ifcCommonHandler = ifcCommonHandler;
		this.types = types;
	}
	
	public void deserializeTypes()
	{
		String name = "";
		String createdBy;
		String externalId;
		Calendar createdOn;
		if (types != null)
		{
			for (TypeType type : types.getTypeArray())
			{
				try
				{
					name = type.getName();
					type.getExtObject();
					IfcTypeObject newTypeObject = TypeDeserializer.typeObjectFromType(type);
					if (newTypeObject != null && !model.containsType(name))
					{
						IfcClassificationReference classification = classificationReferenceFromType(type);
						createdBy = type.getCreatedBy();
						externalId = type.getExtIdentifier();
						createdOn = type.getCreatedOn();
						IfcOwnerHistory ownerHistory = this
								.ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailAndTimestamp(createdBy, createdOn);
						newTypeObject.setOwnerHistory(ownerHistory);
						newTypeObject.setGlobalId(this
								.ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(externalId));

						Pset_ManufacturersTypeInformation psetManufacturerType = new Pset_ManufacturersTypeInformation(
								type);
						this.ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToTypeObject(newTypeObject,
								psetManufacturerType, false);

						Pset_Warranty psetWarranty = new Pset_Warranty(type);
						this.ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToTypeObject

						(newTypeObject, psetWarranty, false);

						Pset_Asset psetAsset = new Pset_Asset(type);
						this.ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToTypeObject(newTypeObject,
								psetAsset, false);

						Pset_ServiceLife svcLife = new Pset_ServiceLife(type);
						this.ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToTypeObject(newTypeObject,
								svcLife, false);

						Pset_EconomicImpactValues psetEconomicImpact = new Pset_EconomicImpactValues(
								type);
						this.ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToTypeObject(newTypeObject,
								psetEconomicImpact, false);
						Pset_Specification psetSpec = new Pset_Specification(type);
						this.ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToTypeObject(newTypeObject,
								psetSpec, false);
								model.add(newTypeObject, this.ifcCommonHandler.getOidProvider());
						if (classification != null)
							this.ifcCommonHandler.getClassificationHandler().addClassificationReferenceToObject(classification,
									newTypeObject);
					}
				} catch (Exception e)
				{
				}
			}
		}

	}
	
	public static IfcTypeObject typeObjectFromType(TypeType cobieType)
	{
		boolean isLegal = false;
		IfcTypeObject defaultTypeObj =
				Ifc2x3Factory.eINSTANCE.createIfcTypeObject();
		String externalObject =
				cobieType.getExtObject();
		IdEObject genericType =
				FromCOBieToIfc.newIdEObject(externalObject);
		if (genericType instanceof IfcMaterial || genericType instanceof IfcMaterialLayer ||
				genericType instanceof IfcMaterialLayerSet)
			genericType = Ifc2x3Factory.eINSTANCE.createIfcFurnishingElementType();
		if (genericType != null && genericType instanceof 
				IfcTypeObject)
		{
			IfcTypeObject typeObj =
					(IfcTypeObject) genericType;
			typeObj.setName(cobieType.getName());
			typeObj.setDescription(cobieType.getDescription());
			isLegal = true;
			if (genericType instanceof IfcWindowStyle)
			{
				IfcWindowStyle windowStyle =
						(IfcWindowStyle) typeObj;
				//has to get some properties from the Attribute sheet
				//e.g. OperationType ConstructionType...
				return windowStyle;
				
			}
			else if (genericType instanceof IfcDoorStyle)
			{
				IfcDoorStyle doorStyle =
						(IfcDoorStyle) typeObj;
				return doorStyle;
			}
			else if (genericType instanceof IfcElementType)
			{
				IfcElementType elementType =
						(IfcElementType) typeObj;
				return elementType;
			}
		}
		if (!isLegal)
			defaultTypeObj = null;
		return defaultTypeObj;
	}
	
	public  IfcClassificationReference classificationReferenceFromType
	(TypeType cobieType)
	{
		return ifcCommonHandler.getClassificationHandler().classificationReferenceFromString(cobieType.getCategory());
	}
}
