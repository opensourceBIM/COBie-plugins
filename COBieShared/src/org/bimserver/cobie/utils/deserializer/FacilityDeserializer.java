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
import java.util.List;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.FacilityType;

import org.bimserver.cobie.utils.deserializer.modelhandlers.ClassificationHandler;
import org.bimserver.cobie.utils.deserializer.modelhandlers.IfcCommonHandler;
import org.bimserver.cobie.utils.deserializer.modelhandlers.IfcGuidHandler;
import org.bimserver.cobie.utils.deserializer.modelhandlers.OwnerHistoryHandler;
import org.bimserver.cobie.utils.deserializer.modelhandlers.PropertySetHandler;
import org.bimserver.cobie.utils.stringwriters.DeserializerStaticStrings;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.ifc2x3tc1.IfcClassification;
import org.bimserver.models.ifc2x3tc1.IfcClassificationReference;
import org.bimserver.models.ifc2x3tc1.IfcCurrencyEnum;
import org.bimserver.models.ifc2x3tc1.IfcDirection;
import org.bimserver.models.ifc2x3tc1.IfcGeometricRepresentationContext;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.bimserver.models.ifc2x3tc1.IfcMonetaryUnit;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcRelAggregates;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationContext;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcSite;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitAssignment;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.plugins.serializers.OidProvider;
import org.bimserver.shared.cobie.COBieUtility;
import org.bimserver.shared.cobie.targetunits.area.AreaUnitSearch;
import org.bimserver.shared.cobie.targetunits.length.LengthUnitSearch;
import org.bimserver.shared.cobie.targetunits.monetary.MonetaryTextMatcher;
import org.bimserver.shared.cobie.targetunits.volume.VolumeUnitSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FacilityDeserializer 
{
	private static final String ERROR_PREFIX_LOCAL_PLACEMENT = "An error occured while attempting to initialize the local placement of facility ";
	private Logger LOGGER = LoggerFactory.getLogger(FacilityDeserializer.class);
	private IfcCommonHandler ifcCommonHandler;
	private COBieIfcModel model;
	private IfcGuidHandler guidProvider;
	private OidProvider CobieOidProvider;
	private OwnerHistoryHandler ownerHistoryProvider;
	private PropertySetHandler propertySetProvider;
	private ClassificationHandler classificationHandler;
	private COBIEType.Facilities facilities;
	private IfcLocalPlacement siteLocalPlacement;
	private static final IfcCurrencyEnum defaultCurrency = IfcCurrencyEnum.USD;
	public FacilityDeserializer(COBieIfcModel cobieIfcModel, IfcCommonHandler ifcCommonHandler,COBIEType.Facilities facilities)
	{
		model = cobieIfcModel;
		guidProvider = ifcCommonHandler.getGuidHandler();
		CobieOidProvider = ifcCommonHandler.getOidProvider();
		ownerHistoryProvider = ifcCommonHandler.getOwnerHistoryHandler();
		classificationHandler = ifcCommonHandler.getClassificationHandler();
		this.ifcCommonHandler = ifcCommonHandler;
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
		String category;
		try
		{
			if (facilities != null)
			{
				for (FacilityType facility : facilities.getFacilityArray())
				{
					name = facility.getName();
					if (!model.containsFacility(name))
					{
						category = facility.getCategory();
						createdBy = facility.getCreatedBy();
						projectExternalId = facility.getExternalProjectIdentifier();
						siteExternalId = facility.getExternalSiteIdentifier();
						buildingExternalId = facility.getExternalFacilityIdentifier();
						createdOn = facility.getCreatedOn();
						IfcOwnerHistory ownerHistory = this
								.ownerHistoryProvider.ownerHistoryFromEmailTimestampAndApplication(createdBy, createdOn, facility.getExternalSystem());

						IfcUnit linearUnit = linearUnitsFromFacility(facility);
						tmpOid = propertySetProvider.addUnitToModel(linearUnit);
						linearUnit = (IfcUnit) model.get(tmpOid);
						// model.add(linearUnit,this.CobieOidProvider);
						IfcUnit areaUnit = areaUnitsFromFacility(facility);
						tmpOid = propertySetProvider.addUnitToModel(areaUnit);
						areaUnit = (IfcUnit) model.get(tmpOid);
						// model.add(areaUnit, CobieOidProvider);
						IfcUnit volumeUnit = volumeUnitsFromFacility(facility);
						tmpOid = propertySetProvider.addUnitToModel(volumeUnit);
						volumeUnit = (IfcUnit) model.get(tmpOid);
						// model.add(volumeUnit, CobieOidProvider);
						IfcUnit monetaryUnit = FacilityDeserializer
								.monetaryUnitFromFacility(facility);
						tmpOid = propertySetProvider.addUnitToModel(monetaryUnit);
						monetaryUnit = (IfcUnit) model.get(tmpOid);
						// model.add(monetaryUnit, CobieOidProvider);

						IfcUnitAssignment unitAssignment = Ifc2x3tc1Factory.eINSTANCE
								.createIfcUnitAssignment();
						unitAssignment.getUnits().add(linearUnit);
						unitAssignment.getUnits().add(areaUnit);
						unitAssignment.getUnits().add(volumeUnit);
						unitAssignment.getUnits().add(monetaryUnit);
						model.add(unitAssignment, CobieOidProvider);

						IfcGloballyUniqueId projGuid = guidProvider.guidFromExternalIdentifier(projectExternalId);
						IfcGloballyUniqueId siteGuid = guidProvider.guidFromExternalIdentifier(siteExternalId);
						IfcGloballyUniqueId buildingGuid = guidProvider.guidFromExternalIdentifier(buildingExternalId);
						String objectType =
								ClassificationHandler.objectTypeFromCategoryString(category);
						
						IfcProject project = projectFromFacility(facility);
						project.setGlobalId(projGuid);
						project.setUnitsInContext(unitAssignment);
						project.setOwnerHistory(ownerHistory);
						
						if(!COBieUtility.isNA(objectType))
							project.setObjectType(objectType);
						model.add(project, CobieOidProvider);
						
						IfcSite site = siteFromFacility(facility);
						site.setGlobalId(siteGuid);
						site.setOwnerHistory(ownerHistory);
						if(!COBieUtility.isNA(objectType))
							site.setObjectType(objectType);
						model.add(site, CobieOidProvider);

						IfcBuilding bldg = buildingFromFacility(facility);
						bldg.setGlobalId(buildingGuid);
						bldg.setOwnerHistory(ownerHistory);
						if(!COBieUtility.isNA(objectType))
							bldg.setObjectType(objectType);
						List<IfcClassificationReference> classifications = classificationReferencesFromFacility(facility);
						
						tmpOid = model.add(bldg, this.CobieOidProvider);
						this.setFacilityAggregates(project, site, bldg);
						for(IfcClassificationReference classification:classifications)
							classificationHandler.addClassificationReferenceToObject(classification, bldg);
							
					}

				}
			}

		}
		catch (Exception e)
		{
		}

	}
	
	private void setFacilityAggregates(IfcProject project, IfcSite site,
			IfcBuilding building)
	{
		IfcRelAggregates aggregatesProj = Ifc2x3tc1Factory.eINSTANCE
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

		IfcRelAggregates aggregatesSite = Ifc2x3tc1Factory.eINSTANCE
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
	
	
	protected IfcProject projectFromFacility(FacilityType facility)
	{
		IfcProject project = Ifc2x3tc1Factory.eINSTANCE.createIfcProject();
		project.setName(facility.getProjectName());
		project.setDescription(facility.getProjectDescription());
		project.setPhase(facility.getPhase());
		project.getRepresentationContexts().add(this.getDefaultRepresentationContext());
		return project;
	}
	
	protected static IfcClassification classificationFromFacility(FacilityType facility)
	{
		IfcClassification classification =
				Ifc2x3tc1Factory.eINSTANCE.createIfcClassification();
		String category = facility.getCategory();
		if (!COBieUtility.isNA(category))
		{
			classification.setName(category);
			return classification;
		}
		else
			return null;
	}
	
	protected  List<IfcClassificationReference> classificationReferencesFromFacility(FacilityType facility)
	{
		return this.classificationHandler.classificationReferencesFromString(facility.getCategory());
	}
	
	protected IfcSite siteFromFacility(FacilityType facility)
	{
		IfcSite site = Ifc2x3tc1Factory.eINSTANCE.createIfcSite();
		site.setName(facility.getSiteName());
		site.setDescription(facility.getDescription());
		IfcLocalPlacement sitePlacement =
				ifcCommonHandler.getGeometryHandler().newDefaultLocalPlacement(null);
		site.setObjectPlacement(sitePlacement);
		setSiteLocalPlacement(sitePlacement);
		return site;
	}
	
	protected  IfcBuilding buildingFromFacility(FacilityType facility)
	{
		IfcBuilding building =
				Ifc2x3tc1Factory.eINSTANCE.createIfcBuilding();
		building.setName(facility.getName());
		building.setDescription(facility.getDescription());
		setFacilityLocalPlacement(facility, building);
		return building;
	}


	private void setFacilityLocalPlacement(FacilityType facility,
			IfcBuilding building)
	{
		try
		{
			building.setObjectPlacement(ifcCommonHandler.getGeometryHandler().newDefaultLocalPlacement(getSiteLocalPlacement()));
		}
		catch(Exception ex)
		{
			LOGGER.error(ERROR_PREFIX_LOCAL_PLACEMENT+facility.getName());
		}
	}
	
	protected  IfcUnit linearUnitsFromFacility(FacilityType facility)
	{

		IfcUnit unit = getDefaultLinearUnits();
		if(!COBieUtility.isNA(facility.getLinearUnits()))
		{
			LengthUnitSearch lengthMatcher =
					new LengthUnitSearch(facility.getLinearUnits());
			unit = lengthMatcher.getMatchedUnit();
		}
		
		return unit;
	}


	public static IfcSIUnit getDefaultLinearUnits()
	{
		IfcSIUnit siUnit =
				Ifc2x3tc1Factory.eINSTANCE.createIfcSIUnit();
		siUnit.setName(IfcSIUnitName.METRE);
		siUnit.setPrefix(IfcSIPrefix.MILLI);
		siUnit.setUnitType(IfcUnitEnum.LENGTHUNIT);
		return siUnit;
	}
	
	protected  IfcUnit areaUnitsFromFacility(FacilityType facility)
	{
		IfcUnit areaUnit = getDefaultAreaUnits();
		if(!COBieUtility.isNA(facility.getAreaUnits()))
		{
			AreaUnitSearch areaSearch =
					new AreaUnitSearch(facility.getAreaUnits());
			areaUnit = areaSearch.getMatchedUnit();
		}
		return areaUnit;
	}


	public static IfcSIUnit getDefaultAreaUnits()
	{
		IfcSIUnit siUnit =
				Ifc2x3tc1Factory.eINSTANCE.createIfcSIUnit();
		siUnit.setName(IfcSIUnitName.SQUARE_METRE);
		siUnit.setUnitType(IfcUnitEnum.AREAUNIT);
		return siUnit;
	}
	
	protected  IfcUnit volumeUnitsFromFacility(FacilityType facility)
	{
		IfcUnit volumeUnit = getDefaultVolumeUnits();
		if(!COBieUtility.isNA(facility.getVolumeUnits()))
		{
			VolumeUnitSearch volumeSearch =
					new VolumeUnitSearch(facility.getVolumeUnits());
			volumeUnit = volumeSearch.getMatchedUnit();
		}
		return volumeUnit;
	}


	private static IfcUnit getDefaultVolumeUnits()
	{
		IfcSIUnit siUnit =
				Ifc2x3tc1Factory.eINSTANCE.createIfcSIUnit();	
		siUnit.setName(IfcSIUnitName.CUBIC_METRE);
		siUnit.setUnitType(IfcUnitEnum.VOLUMEUNIT);
		return siUnit;
	}
	
	protected static IfcUnit monetaryUnitFromFacility(FacilityType facility)
	{
		IfcMonetaryUnit monetaryUnit =
				Ifc2x3tc1Factory.eINSTANCE.createIfcMonetaryUnit();
		String facilityMonetary = facility.getCurrencyUnit();
		try
		{
			IfcCurrencyEnum currency = IfcCurrencyEnum.getByName(facilityMonetary);
			if (currency==null)
			{
				monetaryUnit.setCurrency(monetaryUnitFromString(facilityMonetary));
			}
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
	private static IfcCurrencyEnum monetaryUnitFromString(String monetaryUnitString)
	{
		IfcCurrencyEnum currency;
		try
		{
			MonetaryTextMatcher monetarySearch =
				new MonetaryTextMatcher(monetaryUnitString);
			currency = monetarySearch.getMatchingCurrency();
		}
		catch(Exception ex)
		{
			currency = getDefaultMonetaryUnits();
		}
		return currency;
	}


	public IfcLocalPlacement getSiteLocalPlacement()
	{
		return siteLocalPlacement;
	}


	private void setSiteLocalPlacement(IfcLocalPlacement siteLocalPlacement)
	{
		this.siteLocalPlacement = siteLocalPlacement;
	}
	
	private IfcGeometricRepresentationContext getDefaultRepresentationContext()
	{
		IfcGeometricRepresentationContext repContext =
				COBieUtility.ifcFactory.createIfcGeometricRepresentationContext();
		
		repContext.setContextIdentifier("GeometricRepresentationContext_Global");
		repContext.setContextType("Design");
		repContext.setCoordinateSpaceDimension(3);
		repContext.setPrecision(1.000000000E-5);
		IfcAxis2Placement3D coordSystem =
				COBieUtility.ifcFactory.createIfcAxis2Placement3D();
		IfcCartesianPoint origin =
				COBieUtility.ifcFactory.createIfcCartesianPoint();
		origin.getCoordinates().add((double) 0);
		origin.getCoordinates().add((double) 0);
		origin.getCoordinates().add((double) 0);
		model.add(origin,CobieOidProvider);
		coordSystem.setLocation(origin);
		IfcDirection direction =
				COBieUtility.ifcFactory.createIfcDirection();
		direction.getDirectionRatios().add((double)0);
		direction.getDirectionRatios().add((double)0);
		direction.getDirectionRatios().add((double)1);
		model.add(direction,CobieOidProvider);
		coordSystem.setAxis(direction);
		IfcDirection refDirection =
				COBieUtility.ifcFactory.createIfcDirection();
		refDirection.getDirectionRatios().add((double)1);
		refDirection.getDirectionRatios().add((double)0);
		refDirection.getDirectionRatios().add((double)0);
		model.add(refDirection,CobieOidProvider);
		coordSystem.setRefDirection(refDirection);
		model.add(coordSystem,CobieOidProvider);
		repContext.setWorldCoordinateSystem(coordSystem);
		
		IfcDirection north=
				COBieUtility.ifcFactory.createIfcDirection();
		north.getDirectionRatios().add((double)0);
		north.getDirectionRatios().add((double)1);
		north.getDirectionRatios().add((double)0);
		model.add(north,CobieOidProvider);
		repContext.setTrueNorth(north);
		model.add(repContext,CobieOidProvider);
		return repContext;
	}
	
}
