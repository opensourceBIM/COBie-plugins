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
import org.bimserver.cobie.cobielite.FacilityType;
import org.bimserver.cobie.plugins.COBieIfcModel;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.stringwriters.DeserializerStaticStrings;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.IfcBuilding;
import org.bimserver.models.ifc2x3.IfcClassification;
import org.bimserver.models.ifc2x3.IfcClassificationReference;
import org.bimserver.models.ifc2x3.IfcCurrencyEnum;
import org.bimserver.models.ifc2x3.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3.IfcMonetaryUnit;
import org.bimserver.models.ifc2x3.IfcOwnerHistory;
import org.bimserver.models.ifc2x3.IfcProject;
import org.bimserver.models.ifc2x3.IfcRelAggregates;
import org.bimserver.models.ifc2x3.IfcSIPrefix;
import org.bimserver.models.ifc2x3.IfcSIUnit;
import org.bimserver.models.ifc2x3.IfcSIUnitName;
import org.bimserver.models.ifc2x3.IfcSite;
import org.bimserver.models.ifc2x3.IfcUnit;
import org.bimserver.models.ifc2x3.IfcUnitAssignment;
import org.bimserver.models.ifc2x3.IfcUnitEnum;
import org.bimserver.plugins.serializers.OidProvider;


public class FacilityDeserializer 
{
	private COBieIfcModel model;
	private IfcGuidHandler guidProvider;
	private OidProvider CobieOidProvider;
	private OwnerHistoryHandler ownerHistoryProvider;
	private PropertySetHandler propertySetProvider;
	private ClassificationHandler classificationHandler;
	private COBIEType.Facilities facilities;
	private static final IfcCurrencyEnum defaultCurrency = IfcCurrencyEnum.USD;
	public FacilityDeserializer(COBieIfcModel cobieIfcModel, IfcCommonHandler ifcCommonHandler,COBIEType.Facilities facilities)
	{
		model = cobieIfcModel;
		guidProvider = ifcCommonHandler.getGuidHandler();
		CobieOidProvider = ifcCommonHandler.getOidProvider();
		ownerHistoryProvider = ifcCommonHandler.getOwnerHistoryHandler();
		classificationHandler = ifcCommonHandler.getClassificationHandler();
		this.propertySetProvider = ifcCommonHandler.getPropertySetHandler();
		this.facilities = facilities;
	}
	
	
	public void deserializeFacilities()
	{
		long tmpOid;
		String name;
		String createdBy;
		String projectExternalId;
		String siteExternalId;
		String buildingExternalId;
		Calendar createdOn;
		try
		{
			if (facilities != null)
			{
				for (FacilityType facility : facilities.getFacilityArray())
				{
					name = facility.getName();
					if (!model.containsFacility(name))
					{
						createdBy = facility.getCreatedBy();
						projectExternalId = facility.getExternalProjectIdentifier();
						siteExternalId = facility.getExternalSiteIdentifier();
						buildingExternalId = facility.getExternalFacilityIdentifier();
						createdOn = facility.getCreatedOn();
						IfcOwnerHistory ownerHistory = this
								.ownerHistoryProvider.ownerHistoryFromEmailAndTimestamp(createdBy, createdOn);

						IfcUnit linearUnit = FacilityDeserializer
								.linearUnitsFromFacility(facility);
						tmpOid = propertySetProvider.addUnitToModel(linearUnit);
						linearUnit = (IfcUnit) model.get(tmpOid);
						// model.add(linearUnit,this.CobieOidProvider);
						IfcUnit areaUnit = FacilityDeserializer
								.areaUnitsFromFacility(facility);
						tmpOid = propertySetProvider.addUnitToModel(areaUnit);
						areaUnit = (IfcUnit) model.get(tmpOid);
						// model.add(areaUnit, CobieOidProvider);
						IfcUnit volumeUnit = FacilityDeserializer
								.volumeUnitsFromFacility(facility);
						tmpOid = propertySetProvider.addUnitToModel(volumeUnit);
						volumeUnit = (IfcUnit) model.get(tmpOid);
						// model.add(volumeUnit, CobieOidProvider);
						IfcUnit monetaryUnit = FacilityDeserializer
								.monetaryUnitFromFacility(facility);
						tmpOid = propertySetProvider.addUnitToModel(monetaryUnit);
						monetaryUnit = (IfcUnit) model.get(tmpOid);
						// model.add(monetaryUnit, CobieOidProvider);

						IfcUnitAssignment unitAssignment = Ifc2x3Factory.eINSTANCE
								.createIfcUnitAssignment();
						unitAssignment.getUnits().add(linearUnit);
						unitAssignment.getUnits().add(areaUnit);
						unitAssignment.getUnits().add(volumeUnit);
						unitAssignment.getUnits().add(monetaryUnit);
						model.add(unitAssignment, CobieOidProvider);

						IfcGloballyUniqueId projGuid = guidProvider.guidFromExternalIdentifier(projectExternalId);
						IfcGloballyUniqueId siteGuid = guidProvider.guidFromExternalIdentifier(siteExternalId);
						IfcGloballyUniqueId buildingGuid = guidProvider.guidFromExternalIdentifier(buildingExternalId);

						IfcProject project = FacilityDeserializer
								.projectFromFacility(facility);
						project.setGlobalId(projGuid);
						project.setUnitsInContext(unitAssignment);
						project.setOwnerHistory(ownerHistory);
						model.add(project, CobieOidProvider);

						IfcSite site = FacilityDeserializer.siteFromFacility(facility);
						site.setGlobalId(siteGuid);
						site.setOwnerHistory(ownerHistory);
						model.add(site, CobieOidProvider);

						IfcBuilding bldg = FacilityDeserializer
								.buildingFromFacility(facility);
						bldg.setGlobalId(buildingGuid);
						bldg.setOwnerHistory(ownerHistory);
						IfcClassificationReference classification = FacilityDeserializer
								.classificationReferenceFromFacility(facility);
						tmpOid = model.add(bldg, this.CobieOidProvider);
						this.setFacilityAggregates(project, site, bldg);
						if (classification != null)
							classificationHandler.addClassificationReferenceToObject(classification, bldg);
					}

				}
			}

		} catch (Exception e)
		{
		}

	}
	
	private void setFacilityAggregates(IfcProject project, IfcSite site,
			IfcBuilding building)
	{
		IfcRelAggregates aggregatesProj = Ifc2x3Factory.eINSTANCE
				.createIfcRelAggregates();
		aggregatesProj.setGlobalId(this.guidProvider.newGuid());
		aggregatesProj.setOwnerHistory(ownerHistoryProvider.DefaultOwnerHistory());
		aggregatesProj.setName(DeserializerStaticStrings
				.getProjectRelAggregatesName());
		aggregatesProj.setDescription(DeserializerStaticStrings
				.getProjectRelAggregatesDescription());
		aggregatesProj.setRelatingObject(project);
		aggregatesProj.getRelatedObjects().add(site);
		model.add(aggregatesProj, this.CobieOidProvider);

		IfcRelAggregates aggregatesSite = Ifc2x3Factory.eINSTANCE
				.createIfcRelAggregates();
		aggregatesSite.setGlobalId(this.guidProvider.newGuid());
		aggregatesSite.setOwnerHistory(this.ownerHistoryProvider.DefaultOwnerHistory());
		aggregatesSite.setName(DeserializerStaticStrings
				.getSiteRelAggregatesName());
		aggregatesSite.setDescription(DeserializerStaticStrings
				.getSiteRelAggregatesDescription());
		aggregatesSite.setRelatingObject(site);
		aggregatesSite.getRelatedObjects().add(building);
		model.add(aggregatesSite, CobieOidProvider);
	}
	
	
	protected static IfcProject projectFromFacility(FacilityType facility)
	{
		IfcProject project = Ifc2x3Factory.eINSTANCE.createIfcProject();
		project.setName(facility.getProjectName());
		project.setDescription(facility.getProjectDescription());
		project.setPhase(facility.getPhase());
		return project;
	}
	
	protected static IfcClassification classificationFromFacility(FacilityType facility)
	{
		IfcClassification classification =
				Ifc2x3Factory.eINSTANCE.createIfcClassification();
		String category = facility.getCategory();
		if (!COBieUtility.isNA(category))
		{
			classification.setName(category);
			return classification;
		}
		else
			return null;
	}
	
	protected static IfcClassificationReference classificationReferenceFromFacility(FacilityType facility)
	{
		return ClassificationHandler.classificationReferenceFromString(facility.getCategory());
	}
	
	protected static IfcSite siteFromFacility(FacilityType facility)
	{
		IfcSite site = Ifc2x3Factory.eINSTANCE.createIfcSite();
		site.setName(facility.getSiteName());
		site.setDescription(facility.getDescription());
		return site;
	}
	
	protected static IfcBuilding buildingFromFacility(FacilityType facility)
	{
		IfcBuilding building =
				Ifc2x3Factory.eINSTANCE.createIfcBuilding();
		building.setName(facility.getName());
		building.setDescription(facility.getDescription());
		return building;
	}
	
	protected static IfcUnit linearUnitsFromFacility(FacilityType facility)
	{

		IfcSIUnit siUnit =
				Ifc2x3Factory.eINSTANCE.createIfcSIUnit();
		siUnit.setName(IfcSIUnitName.METRE);
		siUnit.setPrefix(IfcSIPrefix.MILLI);
		siUnit.setUnitType(IfcUnitEnum.LENGTHUNIT);
		return siUnit;
	}
	
	protected static IfcUnit areaUnitsFromFacility(FacilityType facility)
	{
		IfcSIUnit siUnit =
				Ifc2x3Factory.eINSTANCE.createIfcSIUnit();
		siUnit.setName(IfcSIUnitName.SQUARE_METRE);
		siUnit.setUnitType(IfcUnitEnum.AREAUNIT);
		return siUnit;
	}
	
	protected static IfcUnit volumeUnitsFromFacility(FacilityType facility)
	{
		IfcSIUnit siUnit =
				Ifc2x3Factory.eINSTANCE.createIfcSIUnit();	
		siUnit.setName(IfcSIUnitName.CUBIC_METRE);
		siUnit.setUnitType(IfcUnitEnum.VOLUMEUNIT);
		return siUnit;
	}
	
	protected static IfcUnit monetaryUnitFromFacility(FacilityType facility)
	{
		IfcMonetaryUnit monetaryUnit =
				Ifc2x3Factory.eINSTANCE.createIfcMonetaryUnit();
		String facilityMonetary = facility.getCurrencyUnits();
		try
		{
			IfcCurrencyEnum currency = IfcCurrencyEnum.getByName(facilityMonetary);
			if (currency==null)
				monetaryUnit.setCurrency(getDefaultMonetaryUnits());
			else
				monetaryUnit.setCurrency(currency);
		}
		catch(Exception e)
		{
			monetaryUnit.setCurrency(getDefaultMonetaryUnits());
		}
		return monetaryUnit;
	}
	
	private static IfcCurrencyEnum getDefaultMonetaryUnits()
	{
		return defaultCurrency;
	}
	
}
