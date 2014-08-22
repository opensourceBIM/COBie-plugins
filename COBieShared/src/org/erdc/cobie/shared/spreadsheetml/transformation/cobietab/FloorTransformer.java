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
import org.erdc.cobie.shared.COBieTokenUtility.FloorColumnNameLiterals;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.utility.COBieStringHandler;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.FloorType;

public class FloorTransformer extends SpreadsheetMLTransformer
{

    public FloorTransformer(COBIEType cobie, Workbook workbook, COBieStringHandler cobieStringWriter)
    {
        super(workbook, cobie, cobieStringWriter);
    }

    public FloorTransformer(COBIEType cobie, Workbook workbook)
    {
        super(cobie, workbook);
    }

    @Override
    protected List<String> getColumnNames()
    {
        return COBieTokenUtility.FloorColumnNames;
    }

    @Override
    protected String getWorksheetName()
    {
        return COBieUtility.CobieSheetName.Floor.name();
    }

    @Override
    protected void write()
    {
        COBIEType.Floors floors = getTarget().addNewFloors();

        Worksheet sheet = getWorksheet();
        Map<String, Integer> columnDictionary = getColumnDictionary();
        String floorName = "";
        String floorCreatedBy = "";
        String floorCreatedOnString = "";
        Calendar floorCreatedOn;
        String floorCategory = "";
        String floorExtSystem = "";
        String floorExtObject = "";
        String floorExtIdentifier = "";
        String floorDescription = "";
        String floorElevation = "";
        String floorHeight = "";

        int idxName;
        int idxCreatedBy;
        int idxCreatedOn;
        int idxCategory;
        int idxExtSystem;
        int idxExtObject;
        int idxExtIdentifier;
        int idxDescription;
        int idxElevation;
        int idxHeight;

        idxName = columnDictionary.get(FloorColumnNameLiterals.Name.toString());
        idxCreatedBy = columnDictionary.get(FloorColumnNameLiterals.CreatedBy.toString());
        idxCreatedOn = columnDictionary.get(FloorColumnNameLiterals.CreatedOn.toString());
        idxCategory = columnDictionary.get(FloorColumnNameLiterals.Category.toString());
        idxExtSystem = columnDictionary.get(FloorColumnNameLiterals.ExtSystem.toString());
        idxExtObject = columnDictionary.get(FloorColumnNameLiterals.ExtObject.toString());
        idxExtIdentifier = columnDictionary.get(FloorColumnNameLiterals.ExtIdentifier.toString());
        idxDescription = columnDictionary.get(FloorColumnNameLiterals.Description.toString());
        idxElevation = columnDictionary.get(FloorColumnNameLiterals.Elevation.toString());
        idxHeight = columnDictionary.get(FloorColumnNameLiterals.Height.toString());
        int rowIdx;
        int firstRowIdx = Worksheet.firstRow;
        for (Row rowData : sheet.getRows())
        {
            rowIdx = rowData.getIndex();
            if ((rowIdx > firstRowIdx) && COBieSpreadSheet.isRowPopulated(rowData, 1, 100))
            {
                FloorType tmpFloor = floors.addNewFloor();
                if (idxName > -1)
                {
                    floorName = rowData.getCellAt(idxName).getData$();
                }
                if (idxCreatedBy > -1)
                {
                    floorCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
                }
                if (idxCreatedOn > -1)
                {
                    floorCreatedOnString = rowData.getCellAt(idxCreatedOn).getData$();
                }
                if (idxCategory > -1)
                {
                    floorCategory = rowData.getCellAt(idxCategory).getData$();
                }
                if (idxExtSystem > -1)
                {
                    floorExtSystem = rowData.getCellAt(idxExtSystem).getData$();
                }
                if (idxExtObject > -1)
                {
                    floorExtObject = rowData.getCellAt(idxExtObject).getData$();
                }
                if (idxExtIdentifier > -1)
                {
                    floorExtIdentifier = rowData.getCellAt(idxExtIdentifier).getData$();
                }
                if (idxDescription > -1)
                {
                    floorDescription = rowData.getCellAt(idxDescription).getData$();
                }
                if (idxElevation > -1)
                {
                    floorElevation = rowData.getCellAt(idxElevation).getData$();
                }
                if (idxHeight > -1)
                {
                    floorHeight = rowData.getCellAt(idxHeight).getData$();
                }
                floorCreatedOn = getCobieStringHandler().calendarFromString(floorCreatedOnString);
                tmpFloor.setName(cobieStringHandler.getCOBieString(floorName));
                tmpFloor.setCreatedBy(cobieStringHandler.getCOBieString(floorCreatedBy));
                tmpFloor.setCreatedOn(floorCreatedOn);
                tmpFloor.setCategory(cobieStringHandler.getCOBieString(floorCategory));
                tmpFloor.setExtSystem(cobieStringHandler.getCOBieString(floorExtSystem));
                tmpFloor.setExtObject(cobieStringHandler.getCOBieString(floorExtObject));
                tmpFloor.setExtIdentifier(cobieStringHandler.getCOBieString(floorExtIdentifier));
                tmpFloor.setDescription(cobieStringHandler.getCOBieString(floorDescription));
                tmpFloor.setElevation(cobieStringHandler.getCOBieString(floorElevation));
                tmpFloor.setHeight(cobieStringHandler.getCOBieString(floorHeight));
            }
        }

    }

}
