package org.erdc.cobie.shared.spreadsheetml.transformation.cobietab;

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
import java.util.Map;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.erdc.cobie.shared.COBieTokenUtility;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.COBieTokenUtility.FacilityColumnNameLiterals;
import org.erdc.cobie.shared.utility.COBieStringHandler;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.FacilityType;


public class FacilityTransformer extends SpreadsheetMLTransformer
{
    public FacilityTransformer(COBIEType cobie, Workbook workbook, COBieStringHandler cobieStringWriter)
    {
        super(workbook, cobie, cobieStringWriter);
    }

    public FacilityTransformer(COBIEType cobie, Workbook workbook)
    {
        super(cobie, workbook);
    }

    @Override
    protected List<String> getColumnNames()
    {
        return COBieTokenUtility.FacilityColumnNames;
    }

    @Override
    protected String getWorksheetName()
    {
        return COBieUtility.CobieSheetName.Facility.name();
    }

    @Override
    protected void write()
    {
        COBIEType.Facilities facilities = getTarget().addNewFacilities();

        Worksheet sheet = getWorksheet();
        Map<String, Integer> columnDictionary = getColumnDictionary();

        String facilityName = "";
        String facilityCreatedBy = "";
        Calendar facilityCreatedOn;
        String facilityCreatedOnString = "";
        String facilityCategory = "";
        String facilityProjectName = "";
        String facilitySiteName = "";
        String facilityLinearUnits = "";
        String facilityAreaUnits = "";
        String facilityVolumeUnits = "";
        String facilityCurrencyUnit = "";
        String facilityAreaMeasurement = "";
        String facilityExternalSystem = "";
        String facilityExternalProjectObject = "";
        String facilityExternalProjectIdentifier = "";
        String facilityExternalSiteObject = "";
        String facilityExternalSiteIdentifier = "";
        String facilityExternalFacilityObject = "";
        String facilityExternalFacilityIdentifier = "";
        String facilityDescription = "";
        String facilityProjectDescription = "";
        String facilitySiteDescription = "";
        String facilityPhase = "";

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

        idxName = columnDictionary.get(FacilityColumnNameLiterals.Name.toString());
        idxCreatedBy = columnDictionary.get(FacilityColumnNameLiterals.CreatedBy.toString());
        idxCreatedOn = columnDictionary.get(FacilityColumnNameLiterals.CreatedOn.toString());
        idxCategory = columnDictionary.get(FacilityColumnNameLiterals.Category.toString());
        idxProjectName = columnDictionary.get(FacilityColumnNameLiterals.ProjectName.toString());
        idxSiteName = columnDictionary.get(FacilityColumnNameLiterals.SiteName.toString());
        idxLinearUnits = columnDictionary.get(FacilityColumnNameLiterals.LinearUnits.toString());
        idxAreaUnits = columnDictionary.get(FacilityColumnNameLiterals.AreaUnits.toString());
        idxVolumeUnits = columnDictionary.get(FacilityColumnNameLiterals.VolumeUnits.toString());
        idxCurrencyUnit = columnDictionary.get(FacilityColumnNameLiterals.CurrencyUnit.toString());
        idxAreaMeasurement = columnDictionary.get(FacilityColumnNameLiterals.AreaMeasurement.toString());
        idxExternalSystem = columnDictionary.get(FacilityColumnNameLiterals.ExternalSystem.toString());
        idxExternalProjectObject = columnDictionary.get(FacilityColumnNameLiterals.ExternalProjectObject.toString());
        idxExternalProjectIdentifier = columnDictionary.get(FacilityColumnNameLiterals.ExternalProjectIdentifier.toString());
        idxExternalSiteObject = columnDictionary.get(FacilityColumnNameLiterals.ExternalSiteObject.toString());
        idxExternalSiteIdentifier = columnDictionary.get(FacilityColumnNameLiterals.ExternalSiteIdentifier.toString());
        idxExternalFacilityObject = columnDictionary.get(FacilityColumnNameLiterals.ExternalFacilityObject.toString());
        idxExternalFacilityIdentifier = columnDictionary.get(FacilityColumnNameLiterals.ExternalFacilityIdentifier.toString());
        idxDescription = columnDictionary.get(FacilityColumnNameLiterals.Description.toString());
        idxProjectDescription = columnDictionary.get(FacilityColumnNameLiterals.ProjectDescription.toString());
        idxSiteDescription = columnDictionary.get(FacilityColumnNameLiterals.SiteDescription.toString());
        idxPhase = columnDictionary.get(FacilityColumnNameLiterals.Phase.toString());
        int rowIdx;
        int firstRowIdx = Worksheet.firstRow;
        for (Row rowData : sheet.getRows())
        {
            rowIdx = rowData.getIndex();
            if ((rowIdx > firstRowIdx) && COBieSpreadSheet.isRowPopulated(rowData, 1, 100))
            {
                FacilityType tmpFacility = facilities.addNewFacility();

                if (idxName > -1)
                {
                    facilityName = rowData.getCellAt(idxName).getData$();
                }
                if (idxCreatedBy > -1)
                {
                    facilityCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
                }
                if (idxCreatedOn > -1)
                {
                    facilityCreatedOnString = rowData.getCellAt(idxCreatedOn).getData$();
                }
                if (idxCategory > -1)
                {
                    facilityCategory = rowData.getCellAt(idxCategory).getData$();
                }
                if (idxProjectName > -1)
                {
                    facilityProjectName = rowData.getCellAt(idxProjectName).getData$();
                }
                if (idxSiteName > -1)
                {
                    facilitySiteName = rowData.getCellAt(idxSiteName).getData$();
                }
                if (idxLinearUnits > -1)
                {
                    facilityLinearUnits = rowData.getCellAt(idxLinearUnits).getData$();
                }
                if (idxAreaUnits > -1)
                {
                    facilityAreaUnits = rowData.getCellAt(idxAreaUnits).getData$();
                }
                if (idxVolumeUnits > -1)
                {
                    facilityVolumeUnits = rowData.getCellAt(idxVolumeUnits).getData$();
                }
                if (idxCurrencyUnit > -1)
                {
                    facilityCurrencyUnit = rowData.getCellAt(idxCurrencyUnit).getData$();
                }
                if (idxAreaMeasurement > -1)
                {
                    facilityAreaMeasurement = rowData.getCellAt(idxAreaMeasurement).getData$();
                }
                if (idxExternalSystem > -1)
                {
                    facilityExternalSystem = rowData.getCellAt(idxExternalSystem).getData$();
                }
                if (idxExternalProjectObject > -1)
                {
                    facilityExternalProjectObject = rowData.getCellAt(idxExternalProjectObject).getData$();
                }
                if (idxExternalProjectIdentifier > -1)
                {
                    facilityExternalProjectIdentifier = rowData.getCellAt(idxExternalProjectIdentifier).getData$();
                }
                if (idxExternalSiteObject > -1)
                {
                    facilityExternalSiteObject = rowData.getCellAt(idxExternalSiteObject).getData$();
                }
                if (idxExternalSiteIdentifier > -1)
                {
                    facilityExternalSiteIdentifier = rowData.getCellAt(idxExternalSiteIdentifier).getData$();
                }
                if (idxExternalFacilityObject > -1)
                {
                    facilityExternalFacilityObject = rowData.getCellAt(idxExternalFacilityObject).getData$();
                }
                if (idxExternalFacilityIdentifier > -1)
                {
                    facilityExternalFacilityIdentifier = rowData.getCellAt(idxExternalFacilityIdentifier).getData$();
                }
                if (idxDescription > -1)
                {
                    facilityDescription = rowData.getCellAt(idxDescription).getData$();
                }
                if (idxProjectDescription > -1)
                {
                    facilityProjectDescription = rowData.getCellAt(idxProjectDescription).getData$();
                }
                if (idxSiteDescription > -1)
                {
                    facilitySiteDescription = rowData.getCellAt(idxSiteDescription).getData$();
                }
                if (idxPhase > -1)
                {
                    facilityPhase = rowData.getCellAt(idxPhase).getData$();
                }

                facilityCreatedOn = getCobieStringHandler().calendarFromString(facilityCreatedOnString);

                tmpFacility.setName(cobieStringHandler.getCOBieString(facilityName));
                tmpFacility.setCreatedBy(cobieStringHandler.getCOBieString(facilityCreatedBy));
                tmpFacility.setCreatedOn(facilityCreatedOn);
                tmpFacility.setCategory(cobieStringHandler.getCOBieString(facilityCategory));
                tmpFacility.setProjectName(cobieStringHandler.getCOBieString(facilityProjectName));
                tmpFacility.setSiteName(cobieStringHandler.getCOBieString(facilitySiteName));
                tmpFacility.setLinearUnits(cobieStringHandler.getCOBieString(facilityLinearUnits));
                tmpFacility.setAreaUnits(cobieStringHandler.getCOBieString(facilityAreaUnits));
                tmpFacility.setVolumeUnits(cobieStringHandler.getCOBieString(facilityVolumeUnits));
                tmpFacility.setCurrencyUnit(cobieStringHandler.getCOBieString(facilityCurrencyUnit));
                tmpFacility.setAreaMeasurement(cobieStringHandler.getCOBieString(facilityAreaMeasurement));
                tmpFacility.setExternalSystem(cobieStringHandler.getCOBieString(facilityExternalSystem));
                tmpFacility.setExternalProjectObject(cobieStringHandler.getCOBieString(facilityExternalProjectObject));
                tmpFacility.setExternalProjectIdentifier(cobieStringHandler.getCOBieString(facilityExternalProjectIdentifier));
                tmpFacility.setExternalSiteObject(cobieStringHandler.getCOBieString(facilityExternalSiteObject));
                tmpFacility.setExternalSiteIdentifier(cobieStringHandler.getCOBieString(facilityExternalSiteIdentifier));
                tmpFacility.setExternalFacilityObject(cobieStringHandler.getCOBieString(facilityExternalFacilityObject));
                tmpFacility.setExternalFacilityIdentifier(cobieStringHandler.getCOBieString(facilityExternalFacilityIdentifier));
                tmpFacility.setDescription(cobieStringHandler.getCOBieString(facilityDescription));
                tmpFacility.setProjectDescription(cobieStringHandler.getCOBieString(facilityProjectDescription));
                tmpFacility.setSiteDescription(cobieStringHandler.getCOBieString(facilitySiteDescription));
                tmpFacility.setPhase(cobieStringHandler.getCOBieString(facilityPhase));

            }

        }

    }

}
