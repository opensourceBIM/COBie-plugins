package org.erdc.cobie.sheetxmldata.parsers.spreadsheetml;

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
import org.erdc.cobie.shared.COBieTokenUtility.SpaceColumnNameLiterals;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.SpaceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpaceParser extends Parser
{

    public SpaceParser(COBIEType cobie, Workbook workbook)
    {
        super(cobie, workbook);
    }

    @Override
    protected List<String> getColumnNames()
    {
        return COBieTokenUtility.SpaceColumnNames;
    }

    @Override
    protected Logger getLogger()
    {
        return LoggerFactory.getLogger(SpaceParser.class);
    }

    @Override
    protected String getWorksheetName()
    {
        return CobieSheetName.Space.name();
    }

    @Override
    protected void write()
    {

        COBIEType.Spaces spaces = getCobie().addNewSpaces();
        Worksheet sheet = getWorksheet();
        int firstRowIdx = Worksheet.firstRow;
        Map<String, Integer> columnDictionary = getColumnDictionary();

        String spaceName = "";
        String spaceCreatedBy = "";
        String spaceCreatedOnString = "";
        Calendar spaceCreatedOn;
        String spaceCategory = "";
        String spaceFloorName = "";
        String spaceDescription = "";
        String spaceExtSystem = "";
        String spaceExtObject = "";
        String spaceExtIdentifier = "";
        String spaceRoomTag = "";
        String spaceUsableHeight = "";
        String spaceGrossArea = "";
        String spaceNetArea = "";

        int idxName;
        int idxCreatedBy;
        int idxCreatedOn;
        int idxCategory;
        int idxFloorName;
        int idxDescription;
        int idxExtSystem;
        int idxExtObject;
        int idxExtIdentifier;
        int idxRoomTag;
        int idxUsableHeight;
        int idxGrossArea;
        int idxNetArea;

        int rowIdx;

        idxName = columnDictionary.get(SpaceColumnNameLiterals.Name.toString());
        idxCreatedBy = columnDictionary.get(SpaceColumnNameLiterals.CreatedBy.toString());
        idxCreatedOn = columnDictionary.get(SpaceColumnNameLiterals.CreatedOn.toString());
        idxCategory = columnDictionary.get(SpaceColumnNameLiterals.Category.toString());
        idxFloorName = columnDictionary.get(SpaceColumnNameLiterals.FloorName.toString());
        idxDescription = columnDictionary.get(SpaceColumnNameLiterals.Description.toString());
        idxExtSystem = columnDictionary.get(SpaceColumnNameLiterals.ExtSystem.toString());
        idxExtObject = columnDictionary.get(SpaceColumnNameLiterals.ExtObject.toString());
        idxExtIdentifier = columnDictionary.get(SpaceColumnNameLiterals.ExtIdentifier.toString());
        idxRoomTag = columnDictionary.get(SpaceColumnNameLiterals.RoomTag.toString());
        idxUsableHeight = columnDictionary.get(SpaceColumnNameLiterals.UsableHeight.toString());
        idxGrossArea = columnDictionary.get(SpaceColumnNameLiterals.GrossArea.toString());
        idxNetArea = columnDictionary.get(SpaceColumnNameLiterals.NetArea.toString());

        for (Row rowData : sheet.getRows())
        {
            rowIdx = rowData.getIndex();
            if ((rowIdx > firstRowIdx) && COBieSpreadSheet.isRowPopulated(rowData, 1, 100))
            {
                SpaceType tmpSpace = spaces.addNewSpace();

                if (idxName > -1)
                {
                    spaceName = rowData.getCellAt(idxName).getData$();
                }
                if (idxCreatedBy > -1)
                {
                    spaceCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
                }
                if (idxCreatedOn > -1)
                {
                    spaceCreatedOnString = rowData.getCellAt(idxCreatedOn).getData$();
                }
                if (idxCategory > -1)
                {
                    spaceCategory = rowData.getCellAt(idxCategory).getData$();
                }
                if (idxFloorName > -1)
                {
                    spaceFloorName = rowData.getCellAt(idxFloorName).getData$();
                }
                if (idxDescription > -1)
                {
                    spaceDescription = rowData.getCellAt(idxDescription).getData$();
                }
                if (idxExtSystem > -1)
                {
                    spaceExtSystem = rowData.getCellAt(idxExtSystem).getData$();
                }
                if (idxExtObject > -1)
                {
                    spaceExtObject = rowData.getCellAt(idxExtObject).getData$();
                }
                if (idxExtIdentifier > -1)
                {
                    spaceExtIdentifier = rowData.getCellAt(idxExtIdentifier).getData$();
                }
                if (idxRoomTag > -1)
                {
                    spaceRoomTag = rowData.getCellAt(idxRoomTag).getData$();
                }
                if (idxUsableHeight > -1)
                {
                    spaceUsableHeight = rowData.getCellAt(idxUsableHeight).getData$();
                }
                if (idxGrossArea > -1)
                {
                    spaceGrossArea = rowData.getCellAt(idxGrossArea).getData$();
                }
                if (idxNetArea > -1)
                {
                    spaceNetArea = rowData.getCellAt(idxNetArea).getData$();
                }
                spaceCreatedOn = COBieUtility.calendarFromString(spaceCreatedOnString);

                tmpSpace.setName(COBieUtility.getCOBieString(spaceName));
                tmpSpace.setCreatedBy(COBieUtility.getCOBieString(spaceCreatedBy));
                tmpSpace.setCreatedOn(spaceCreatedOn);
                tmpSpace.setCategory(COBieUtility.getCOBieString(spaceCategory));
                tmpSpace.setFloorName(COBieUtility.getCOBieString(spaceFloorName));
                tmpSpace.setDescription(COBieUtility.getCOBieString(spaceDescription));
                tmpSpace.setExtSystem(COBieUtility.getCOBieString(spaceExtSystem));
                tmpSpace.setExtObject(COBieUtility.getCOBieString(spaceExtObject));
                tmpSpace.setExtIdentifier(COBieUtility.getCOBieString(spaceExtIdentifier));
                tmpSpace.setRoomTag(COBieUtility.getCOBieString(spaceRoomTag));
                tmpSpace.setUsableHeight(COBieUtility.getCOBieString(spaceUsableHeight));
                tmpSpace.setGrossArea(COBieUtility.getCOBieString(spaceGrossArea));
                tmpSpace.setNetArea(COBieUtility.getCOBieString(spaceNetArea));

            }
        }
    }

}
