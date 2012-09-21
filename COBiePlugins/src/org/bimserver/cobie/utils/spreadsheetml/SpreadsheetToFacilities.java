package org.bimserver.cobie.utils.spreadsheetml;
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
import java.util.Map;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.FacilityType;
import org.bimserver.shared.cobie.COBieTokenUtility;
import org.bimserver.shared.cobie.COBieTokenUtility.FacilityColumnNameLiterals;
import org.bimserver.shared.cobie.COBieUtility;


public class SpreadsheetToFacilities 
{
	
	public static ArrayList<String> getFacilityColumns()
	{
		return COBieTokenUtility.FacilityColumnNames;
	}

	public static void writeFacilitiesToCOBie(COBIEType cType,Workbook workbook)
	{
		COBIEType.Facilities facilities =  cType.addNewFacilities();
     	    
	   	Worksheet sheet = workbook.getWorksheet(COBieUtility.CobieSheetName.Facility.toString());
	   	Map<String,Integer> columnDictionary =
	   			COBieSpreadSheet.GetWorksheetColumnDictionary(sheet, getFacilityColumns());
	   	String facilityName="";
	   	String facilityCreatedBy="";
	   	Calendar facilityCreatedOn;
	   	String facilityCreatedOnString = "";
	   	String facilityCategory="";
	   	String facilityProjectName="";
	   	String facilitySiteName="";
	   	String facilityLinearUnits="";
	   	String facilityAreaUnits="";
	   	String facilityVolumeUnits="";
	   	String facilityCurrencyUnit="";
	   	String facilityAreaMeasurement="";
	   	String facilityExternalSystem="";
	   	String facilityExternalProjectObject="";
	   	String facilityExternalProjectIdentifier="";
	   	String facilityExternalSiteObject="";
	   	String facilityExternalSiteIdentifier="";
	   	String facilityExternalFacilityObject="";
	   	String facilityExternalFacilityIdentifier="";
	   	String facilityDescription="";
	   	String facilityProjectDescription="";
	   	String facilitySiteDescription="";
	   	String facilityPhase="";
	   	
	   	int idxName;
	   	int idxCreatedBy;
	   	int idxCreatedOn;
	   	int idxCategory;
	   	int idxProjectName;
	   	int idxSiteName;
	   	int idxLinearUnits;
	   	int idxAreaUnits;
	   	int idxVolumeUnits;
	   	int idxCurrencyUnit;
	   	int idxAreaMeasurement;
	   	int idxExternalSystem;
	   	int idxExternalProjectObject;
	   	int idxExternalProjectIdentifier;
	   	int idxExternalSiteObject;
	   	int idxExternalSiteIdentifier;
	   	int idxExternalFacilityObject;
	   	int idxExternalFacilityIdentifier;
	   	int idxDescription;
	   	int idxProjectDescription;
	   	int idxSiteDescription;
	   	int idxPhase;

	   	idxName=columnDictionary.get(FacilityColumnNameLiterals.Name.toString());
	   	idxCreatedBy=columnDictionary.get(FacilityColumnNameLiterals.CreatedBy.toString());
	   	idxCreatedOn=columnDictionary.get(FacilityColumnNameLiterals.CreatedOn.toString());
	   	idxCategory=columnDictionary.get(FacilityColumnNameLiterals.Category.toString());
	   	idxProjectName=columnDictionary.get(FacilityColumnNameLiterals.ProjectName.toString());
	   	idxSiteName=columnDictionary.get(FacilityColumnNameLiterals.SiteName.toString());
	   	idxLinearUnits=columnDictionary.get(FacilityColumnNameLiterals.LinearUnits.toString());
	   	idxAreaUnits=columnDictionary.get(FacilityColumnNameLiterals.AreaUnits.toString());
	   	idxVolumeUnits=columnDictionary.get(FacilityColumnNameLiterals.VolumeUnits.toString());
	   	idxCurrencyUnit=columnDictionary.get(FacilityColumnNameLiterals.CurrencyUnit.toString());
	   	idxAreaMeasurement=columnDictionary.get(FacilityColumnNameLiterals.AreaMeasurement.toString());
	   	idxExternalSystem=columnDictionary.get(FacilityColumnNameLiterals.ExternalSystem.toString());
	   	idxExternalProjectObject=columnDictionary.get(FacilityColumnNameLiterals.ExternalProjectObject.toString());
	   	idxExternalProjectIdentifier=columnDictionary.get(FacilityColumnNameLiterals.ExternalProjectIdentifier.toString());
	   	idxExternalSiteObject=columnDictionary.get(FacilityColumnNameLiterals.ExternalSiteObject.toString());
	   	idxExternalSiteIdentifier=columnDictionary.get(FacilityColumnNameLiterals.ExternalSiteIdentifier.toString());
	   	idxExternalFacilityObject=columnDictionary.get(FacilityColumnNameLiterals.ExternalFacilityObject.toString());
	   	idxExternalFacilityIdentifier=columnDictionary.get(FacilityColumnNameLiterals.ExternalFacilityIdentifier.toString());
	   	idxDescription=columnDictionary.get(FacilityColumnNameLiterals.Description.toString());
	   	idxProjectDescription=columnDictionary.get(FacilityColumnNameLiterals.ProjectDescription.toString());
	   	idxSiteDescription=columnDictionary.get(FacilityColumnNameLiterals.SiteDescription.toString());
	   	idxPhase=columnDictionary.get(FacilityColumnNameLiterals.Phase.toString());
	    int rowIdx;
	    int firstRowIdx = Worksheet.firstRow;
	   	for (Row rowData : sheet.getRows())
	   	{
	   		rowIdx = rowData.getIndex();
	   		if (rowIdx>firstRowIdx && COBieSpreadSheet.isRowPopulated(rowData, 1,100))
	   		{
		   	    FacilityType tmpFacility = facilities.addNewFacility();	
		   	    
				if (idxName > -1)
					facilityName = rowData.getCellAt(idxName).getData$();
				if (idxCreatedBy > -1)
					facilityCreatedBy = rowData.getCellAt(idxCreatedBy)
							.getData$();
				if (idxCreatedOn > -1)
					facilityCreatedOnString = rowData.getCellAt(idxCreatedOn)
							.getData$();
				if (idxCategory > -1)
					facilityCategory = rowData.getCellAt(idxCategory)
							.getData$();
				if (idxProjectName > -1)
					facilityProjectName = rowData.getCellAt(idxProjectName)
							.getData$();
				if (idxSiteName > -1)
					facilitySiteName = rowData.getCellAt(idxSiteName)
							.getData$();
				if (idxLinearUnits > -1)
					facilityLinearUnits = rowData.getCellAt(idxLinearUnits)
							.getData$();
				if (idxAreaUnits > -1)
					facilityAreaUnits = rowData.getCellAt(idxAreaUnits)
							.getData$();
				if (idxVolumeUnits > -1)
					facilityVolumeUnits = rowData.getCellAt(idxVolumeUnits)
							.getData$();
				if (idxCurrencyUnit > -1)
					facilityCurrencyUnit = rowData.getCellAt(idxCurrencyUnit)
							.getData$();
				if (idxAreaMeasurement > -1)
					facilityAreaMeasurement = rowData.getCellAt(
							idxAreaMeasurement).getData$();
				if (idxExternalSystem > -1)
					facilityExternalSystem = rowData.getCellAt(
							idxExternalSystem).getData$();
				if (idxExternalProjectObject > -1)
					facilityExternalProjectObject = rowData.getCellAt(
							idxExternalProjectObject).getData$();
				if (idxExternalProjectIdentifier > -1)
					facilityExternalProjectIdentifier = rowData.getCellAt(
							idxExternalProjectIdentifier).getData$();
				if (idxExternalSiteObject > -1)
					facilityExternalSiteObject = rowData.getCellAt(
							idxExternalSiteObject).getData$();
				if (idxExternalSiteIdentifier > -1)
					facilityExternalSiteIdentifier = rowData.getCellAt(
							idxExternalSiteIdentifier).getData$();
				if (idxExternalFacilityObject > -1)
					facilityExternalFacilityObject = rowData.getCellAt(
							idxExternalFacilityObject).getData$();
				if (idxExternalFacilityIdentifier > -1)
					facilityExternalFacilityIdentifier = rowData.getCellAt(
							idxExternalFacilityIdentifier).getData$();
				if (idxDescription > -1)
					facilityDescription = rowData.getCellAt(idxDescription)
							.getData$();
				if (idxProjectDescription > -1)
					facilityProjectDescription = rowData.getCellAt(
							idxProjectDescription).getData$();
				if (idxSiteDescription > -1)
					facilitySiteDescription = rowData.getCellAt(
							idxSiteDescription).getData$();
				if (idxPhase > -1)
					facilityPhase = rowData.getCellAt(idxPhase).getData$();
				
				facilityCreatedOn = COBieUtility.calendarFromString(facilityCreatedOnString);
				
				tmpFacility.setName(COBieUtility.getCOBieString(facilityName));
				tmpFacility.setCreatedBy(COBieUtility.getCOBieString(facilityCreatedBy));
				tmpFacility.setCreatedOn(facilityCreatedOn);
				tmpFacility.setCategory(COBieUtility.getCOBieString(facilityCategory));
				tmpFacility.setProjectName(COBieUtility.getCOBieString(facilityProjectName));
				tmpFacility.setSiteName(COBieUtility.getCOBieString(facilitySiteName));
				tmpFacility.setLinearUnits(COBieUtility.getCOBieString(facilityLinearUnits));
				tmpFacility.setAreaUnits(COBieUtility.getCOBieString(facilityAreaUnits));
				tmpFacility.setVolumeUnits(COBieUtility.getCOBieString(facilityVolumeUnits));
				tmpFacility.setCurrencyUnit(COBieUtility.getCOBieString(facilityCurrencyUnit));
				tmpFacility.setAreaMeasurement(COBieUtility.getCOBieString(facilityAreaMeasurement));
				tmpFacility.setExternalSystem(COBieUtility.getCOBieString(facilityExternalSystem));
				tmpFacility.setExternalProjectObject(COBieUtility.getCOBieString(facilityExternalProjectObject));
				tmpFacility.setExternalProjectIdentifier(COBieUtility.getCOBieString(facilityExternalProjectIdentifier));
				tmpFacility.setExternalSiteObject(COBieUtility.getCOBieString(facilityExternalSiteObject));
				tmpFacility.setExternalSiteIdentifier(COBieUtility.getCOBieString(facilityExternalSiteIdentifier));
				tmpFacility.setExternalFacilityObject(COBieUtility.getCOBieString(facilityExternalFacilityObject));
				tmpFacility.setExternalFacilityIdentifier(COBieUtility.getCOBieString(facilityExternalFacilityIdentifier));
				tmpFacility.setDescription(COBieUtility.getCOBieString(facilityDescription));
				tmpFacility.setProjectDescription(COBieUtility.getCOBieString(facilityProjectDescription));
				tmpFacility.setSiteDescription(COBieUtility.getCOBieString(facilitySiteDescription));
				tmpFacility.setPhase(COBieUtility.getCOBieString(facilityPhase));


	   		}
	   		
	   	}

	}
	
}
