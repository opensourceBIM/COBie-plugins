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
import java.util.Calendar;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.FacilityType;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.COBieUtility.CobieSheetName;
import org.bimserver.cobie.utils.stringwriters.IfcUnitToCOBieString;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcElementQuantity;
import org.bimserver.models.ifc2x3tc1.IfcMonetaryUnit;
import org.bimserver.models.ifc2x3tc1.IfcNamedUnit;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcRelAggregates;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcSite;
import org.bimserver.models.ifc2x3tc1.IfcSpatialStructureElement;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitAssignment;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.models.ifc2x3tc1.impl.IfcElementQuantityImpl;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public  class IfcToFacility 
{	
	private static final String GSAAreaReplaceString = "GSA";
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcToFacility.class);
	private static final CobieSheetName sheetName = CobieSheetName.Facility;
	static protected final String ExtProjectObject=IfcProject.class.getSimpleName();
	static protected final String ExtSiteObject=IfcSite.class.getSimpleName();
	static protected final String ExtFacilityObject=IfcBuilding.class.getSimpleName();
	static protected final String currencyUnit = "n/a";
	public static COBIEType writeFacilitiesToCOBie(COBIEType cType, IfcModelInterface model)
	{	
		LogHandler loggerHandler = new LogHandler(sheetName,LOGGER);
		loggerHandler.sheetWriteBegin();
		COBIEType.Facilities facilities =
				cType.addNewFacilities();
		String name = "";
		String createdBy = "";
		String category = "";
		String projectName = "";
		String siteName = "";
		String linearUnits = "";
		String areaUnits = "";
		String volumeUnits = "";
		String currencyUnits = IfcToFacility.getCurrencyUnits();
		String areaMeasurement = "";
		String extSystem = "";
		String extProjectObject = "";
		String extProjectIdentifier = "";
		String extSiteObject = "";
		String extSiteIdentifier = "";
		String extFacilityObject = "";
		String extFacilityIdentifier = "";
		String description = "";
		String projectDescription = "";
		String siteDescription = "";
		String phase = "";
		for(IfcBuilding ifcBldg  : model.getAll(IfcBuilding.class))
		{
			try
			{
				IfcSite bldgSite = IfcToFacility.getBuildingSite(ifcBldg);
				IfcProject bldgProj = IfcToFacility.getSiteProject(bldgSite);			
				IfcOwnerHistory ownerHistory = ifcBldg.getOwnerHistory();
				
				
				
				name = IfcToFacility.nameFromBuildingProjectSite(ifcBldg,bldgProj,bldgSite);
				
				createdBy = COBieUtility.getEmailFromOwnerHistory(ownerHistory);
				Calendar cal = IfcToContact.getCreatedOn(ownerHistory.getCreationDate());
				category = COBieUtility.getObjectClassification(ifcBldg);
				projectName = IfcToFacility.getProjectName(bldgProj);
				siteName = IfcToFacility.getSiteName(bldgSite);
				linearUnits = IfcToFacility.getProjectLinearUnits(bldgProj);
				areaUnits = IfcToFacility.getProjectAreaUnits(bldgProj);
				volumeUnits = IfcToFacility.volumeUnitsFromProject(bldgProj);
				currencyUnits = IfcToFacility.currencyUnitsFromProject(bldgProj);
				areaMeasurement = IfcToFacility.areaMeasurementFromObject(ifcBldg);
				extSystem =COBieUtility.getApplicationName(ownerHistory);
				extProjectObject = IfcToFacility.ExtProjectObject;
				extProjectIdentifier = COBieUtility.identifierFromObject(bldgProj);
				extSiteObject = IfcToFacility.ExtSiteObject;
				extSiteIdentifier = COBieUtility.identifierFromObject(bldgSite);
				extFacilityObject = IfcToFacility.ExtFacilityObject;
				extFacilityIdentifier = COBieUtility.identifierFromObject(ifcBldg);
				description = IfcToFacility.descriptionFromSpatialStructureElement(ifcBldg);
				projectDescription = IfcToFacility.descriptionFromProject(bldgProj);
				siteDescription = IfcToFacility.descriptionFromSpatialStructureElement(bldgSite);
				phase = IfcToFacility.phaseFromProject(bldgProj);
				
				if (areaMeasurement.startsWith(GSAAreaReplaceString) && extSystem!=null && extSystem.length()>0)
				{
					areaMeasurement =
							areaMeasurement.replaceFirst(GSAAreaReplaceString, extSystem);
				}
				
				FacilityType tmpFacility = facilities.addNewFacility();	
				tmpFacility.setName(name);
				tmpFacility.setCreatedBy(createdBy);
				tmpFacility.setCreatedOn(cal);
				tmpFacility.setCategory(category);
				tmpFacility.setProjectName(projectName);
				tmpFacility.setSiteName(siteName);
				tmpFacility.setLinearUnits(linearUnits);
				tmpFacility.setAreaUnits(areaUnits);
				tmpFacility.setVolumeUnits(volumeUnits);
				tmpFacility.setCurrencyUnits(currencyUnits);
				tmpFacility.setAreaMeasurement(areaMeasurement);
				tmpFacility.setExternalSystem(extSystem);
				tmpFacility.setExternalProjectObject(extProjectObject);
				tmpFacility.setExternalProjectIdentifier(extProjectIdentifier);
				tmpFacility.setExternalSiteObject(extSiteObject);
				tmpFacility.setExternalSiteIdentifier(extSiteIdentifier);
				tmpFacility.setExternalFacilityObject(extFacilityObject);
				tmpFacility.setExternalFacilityIdentifier(extFacilityIdentifier);
				tmpFacility.setDescription(description);
				tmpFacility.setProjectDescription(projectDescription);
				tmpFacility.setSiteDescription(siteDescription);
				tmpFacility.setPhase(phase);
				loggerHandler.rowWritten();
			}
			catch(Exception ex)
			{
				loggerHandler.error(ex);
			}
			

		}		
		loggerHandler.sheetWritten();
		return cType;
	}
	
	
	public static String getCurrencyUnits()
	{
		return currencyUnit;
	}
	
	static protected String getProjectName(IfcProject proj)
	{
		 if (proj.getName()!=null && proj.getName().length()>0)
			 return proj.getName();
		 else if (proj.getLongName()!=null && proj.getLongName().length()>0)
			 return proj.getLongName();
		 else
			 return COBieUtility.getCOBieString(proj.getGlobalId().toString());
	}
	
	static protected String nameFromBuildingProjectSite(IfcBuilding bldg,IfcProject proj, IfcSite site)
	{
		String name = "";
		name = bldg.getName();
		if (name==null || name.length()==0)
			name = bldg.getLongName();
		if (name==null || name.length()==0)
			name = proj.getName();
		if (name==null || name.length()==0)
			name = proj.getLongName();
		if (name==null || name.length()==0)
			name = site.getName();
		if (name==null || name.length()==0)
			name = site.getLongName();
		if (name==null || name.length()==0)
			name = bldg.getGlobalId().getWrappedValue();
		return COBieUtility.getCOBieString(name);
	}
	
	static public String nameFromBuildign(IfcBuilding bldg)
	{
		return COBieUtility.getCOBieString(bldg.getName());
	}
	
	static protected String getSiteName(IfcSite site)
	{
		 if (site.getName()!=null && site.getName().length()>0)
			 return site.getName();
		 else if (site.getLongName()!=null && site.getLongName().length()>0)
			 return site.getLongName();
		 else
			 return COBieUtility.getCOBieString(site.getGlobalId().toString());
	}
	
	static protected IfcProject getSiteProject(IfcSite site)
	{
		IfcProject proj = null;
		
		for( IfcRelDecomposes obj : site.getDecomposes())
		{
			if (IfcRelAggregates.class.isInstance(obj))
			{
				IfcRelAggregates relAgg =
						(IfcRelAggregates) obj;
				if(IfcProject.class.isInstance(relAgg.getRelatingObject()))
					proj = (IfcProject) relAgg.getRelatingObject();
			}

		}
		return proj;
	}
	
	static protected IfcSite getBuildingSite(IfcBuilding ifcBldg)
	{
		IfcSite site = null;
		
		for( IfcRelDecomposes obj : ifcBldg.getDecomposes())
		{
			if (IfcRelAggregates.class.isInstance(obj))
			{
				IfcRelAggregates relAgg =
						(IfcRelAggregates) obj;
				if(IfcSite.class.isInstance(relAgg.getRelatingObject()))
					site = (IfcSite) relAgg.getRelatingObject();
			}
		}
		return site;
		
	}
		
	static protected String getBuildingClassification(IfcBuilding ifcBldg)
	{
		return COBieUtility.getObjectClassification(ifcBldg);
	}
	
	static protected String getProjectLinearUnits(IfcProject proj)
	{
		String units = "";
		IfcUnitAssignment ifcUnits =
				proj.getUnitsInContext();
		for(IfcUnit unit : ifcUnits.getUnits())
		{
			
			if(IfcNamedUnit.class.isInstance(unit))
			{
				IfcNamedUnit nUnit = (IfcNamedUnit) unit;
				if (nUnit.getUnitType()==IfcUnitEnum.LENGTHUNIT)
				{
					units = IfcUnitToCOBieString.linearUnitString(nUnit);
				}
			}
		}
		return COBieUtility.getCOBieString(units.toLowerCase());
	}

	static protected String getProjectAreaUnits(IfcProject proj)
	{
		String units = "";
		IfcUnitAssignment ifcUnits =
				proj.getUnitsInContext();
		for(IfcUnit unit : ifcUnits.getUnits())
		{			
			if(IfcNamedUnit.class.isInstance(unit))
			{
				IfcNamedUnit nUnit = (IfcNamedUnit) unit;
				if (nUnit.getUnitType().getLiteral()==IfcUnitEnum.AREAUNIT.getLiteral())
					units = IfcUnitToCOBieString.getAreaUnitString(nUnit);
			}
		}
		return COBieUtility.getCOBieString(units.toLowerCase());
	}
	
	static protected String volumeUnitsFromProject(IfcProject proj)
	{
		String units = "";
		IfcUnitAssignment ifcUnits =
				proj.getUnitsInContext();
		for(IfcUnit unit : ifcUnits.getUnits())
		{
			
			if(IfcNamedUnit.class.isInstance(unit))
			{
				IfcNamedUnit nUnit = (IfcNamedUnit) unit;
				if (nUnit.getUnitType().getLiteral()==IfcUnitEnum.VOLUMEUNIT.getLiteral())
					units = IfcUnitToCOBieString.getVolumeUnitString(nUnit);
			}
		}
		return COBieUtility.getCOBieString(units.toLowerCase());
	}
	
	static protected String currencyUnitsFromProject(IfcProject proj)
	{
		String units = "";
		IfcUnitAssignment ifcUnits =
				proj.getUnitsInContext();
		for(IfcUnit unit : ifcUnits.getUnits())
		{			
			if(IfcMonetaryUnit.class.isInstance(unit))
			{
				units = IfcUnitToCOBieString.stringFromMonetaryUnit((IfcMonetaryUnit)unit);
			}
		}
		return COBieUtility.getCOBieString(units);
	}
	
	static protected String areaMeasurementFromObject(IfcObject obj)
	{
		String areaMeas = "";
		
		
		EList<IfcRelDefines> isDefinedBy = obj.getIsDefinedBy();
		for(IfcRelDefines def : isDefinedBy)
		{
			if (IfcRelDefinesByProperties.class.isInstance(def))
			{
				IfcRelDefinesByProperties
				defProp = (IfcRelDefinesByProperties) def;
				IfcPropertySetDefinition pSet = defProp.getRelatingPropertyDefinition();
				if (IfcElementQuantityImpl.class.isInstance(pSet))
				{
					IfcElementQuantity eQ = (IfcElementQuantity) pSet;
					if (eQ.getMethodOfMeasurement()!=null)
						areaMeas = eQ.getMethodOfMeasurement();
				}
			}
		}
		if (areaMeas==null || areaMeas.length()==0 || areaMeas==COBieUtility.COBieNA)
		{
			for(IfcRelDecomposes relDec : obj.getIsDecomposedBy())
			{
				for(IfcObjectDefinition ifcObjDef : relDec.getRelatedObjects())
				{					
					if (areaMeas==null || areaMeas.length()==0 || areaMeas==COBieUtility.COBieNA)
					{
						IfcObject tmpObj = (IfcObject) ifcObjDef;
						areaMeas = areaMeasurementFromObject(tmpObj);
					}
				}
			}
		}

		return COBieUtility.getCOBieString(areaMeas);
	}

	static protected String descriptionFromProject(IfcProject proj)
	{
		String desc = proj.getDescription();
		if (COBieUtility.isNA(desc))
		{
			//look for long name
			desc = proj.getLongName();
			if (COBieUtility.isNA(desc))
				desc = proj.getName();
		}
		return COBieUtility.getCOBieString(desc);
	}
	
	static protected String descriptionFromSpatialStructureElement(IfcSpatialStructureElement element)
	{
		String desc = element.getDescription();
		if (COBieUtility.isNA(desc))
		{
			//look for long name
			desc = element.getLongName();
			if (COBieUtility.isNA(desc))
				desc = element.getName();
		}
		return COBieUtility.getCOBieString(desc);
	}
	
	static protected String phaseFromProject(IfcProject proj)
	{
		String phase = proj.getPhase();
		return COBieUtility.getCOBieString(phase);
	}
}
