package org.erdc.cobie.sheetxmldata.parsers.spreadsheetml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.CoordinateType;
import org.erdc.cobie.utils.stringwriters.COBieStringHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoordinateParser extends Parser
{
    public CoordinateParser(COBIEType cobie, Workbook workbook, COBieStringHandler cobieStringWriter)
    {
        super(cobie, workbook, cobieStringWriter);
    }

    public static enum CoordinateColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, SheetName, RowName, CoordinateXAxis, CoordinateYAxis, CoordinateZAxis, ExtSystem, ExtObject, ExtIdentifier, ClockwiseRotation, ElevationalRotation, YawRotation
    }

    public static ArrayList<String> CoordinateColumnNames = new ArrayList<String>(Arrays.asList("Name", "CreatedBy", "CreatedOn", "Category",
            "SheetName", "RowName", "CoordinateXAxis", "CoordinateYAxis", "CoordinateZAxis", "ExtSystem", "ExtObject", "ExtIdentifier",
            "ClockwiseRotation", "ElevationalRotation", "YawRotation"));

    public CoordinateParser(COBIEType cobie, Workbook workbook)
    {
        super(cobie, workbook);
    };

    @Override
    protected List<String> getColumnNames()
    {
        return CoordinateColumnNames;
    }

    @Override
    protected Logger getLogger()
    {
        return LoggerFactory.getLogger(CoordinateParser.class);
    }

    @Override
    protected String getWorksheetName()
    {
        return COBieUtility.CobieSheetName.Coordinate.name();
    }

    @Override
    protected void write()
    {
        COBIEType.Coordinates coordinates = getCobie().addNewCoordinates();
        Worksheet sheet = getWorksheet();
        Map<String, Integer> columnDictionary = getColumnDictionary();
        String coordinateName = "";
        String coordinateCreatedBy = "";
        String coordinateCreatedOnString = "";
        Calendar coordinateCreatedOn;
        String coordinateCategory = "";
        String coordinateSheetName = "";
        String coordinateRowName = "";
        String coordinateCoordinateXAxis = "";
        String coordinateCoordinateYAxis = "";
        String coordinateCoordinateZAxis = "";
        String coordinateExtSystem = "";
        String coordinateExtObject = "";
        String coordinateExtIdentifier = "";
        String coordinateClockwiseRotation = "";
        String coordinateElevationalRotation = "";
        String coordinateYawRotation = "";
        int idxName;
        int idxCreatedBy;
        int idxCreatedOn;
        int idxCategory;
        int idxSheetName;
        int idxRowName;
        int idxCoordinateXAxis;
        int idxCoordinateYAxis;
        int idxCoordinateZAxis;
        int idxExtSystem;
        int idxExtObject;
        int idxExtIdentifier;
        int idxClockwiseRotation;
        int idxElevationalRotation;
        int idxYawRotation;
        idxName = columnDictionary.get(CoordinateColumnNameLiterals.Name.toString());
        idxCreatedBy = columnDictionary.get(CoordinateColumnNameLiterals.CreatedBy.toString());
        idxCreatedOn = columnDictionary.get(CoordinateColumnNameLiterals.CreatedOn.toString());
        idxCategory = columnDictionary.get(CoordinateColumnNameLiterals.Category.toString());
        idxSheetName = columnDictionary.get(CoordinateColumnNameLiterals.SheetName.toString());
        idxRowName = columnDictionary.get(CoordinateColumnNameLiterals.RowName.toString());
        idxCoordinateXAxis = columnDictionary.get(CoordinateColumnNameLiterals.CoordinateXAxis.toString());
        idxCoordinateYAxis = columnDictionary.get(CoordinateColumnNameLiterals.CoordinateYAxis.toString());
        idxCoordinateZAxis = columnDictionary.get(CoordinateColumnNameLiterals.CoordinateZAxis.toString());
        idxExtSystem = columnDictionary.get(CoordinateColumnNameLiterals.ExtSystem.toString());
        idxExtObject = columnDictionary.get(CoordinateColumnNameLiterals.ExtObject.toString());
        idxExtIdentifier = columnDictionary.get(CoordinateColumnNameLiterals.ExtIdentifier.toString());
        idxClockwiseRotation = columnDictionary.get(CoordinateColumnNameLiterals.ClockwiseRotation.toString());
        idxElevationalRotation = columnDictionary.get(CoordinateColumnNameLiterals.ElevationalRotation.toString());
        idxYawRotation = columnDictionary.get(CoordinateColumnNameLiterals.YawRotation.toString());
        int rowIdx;
        int firstRowIdx = Worksheet.firstRow;
        for (Row rowData : sheet.getRows())
        {
            rowIdx = rowData.getIndex();
            if ((rowIdx > firstRowIdx) && COBieSpreadSheet.isRowPopulated(rowData, 1, 100))
            {
                CoordinateType tmpCoordinate = coordinates.addNewCoordinate();
                if (idxName > -1)
                {
                    coordinateName = rowData.getCellAt(idxName).getData$();
                }
                if (idxCreatedBy > -1)
                {
                    coordinateCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
                }
                if (idxCreatedOn > -1)
                {
                    coordinateCreatedOnString = rowData.getCellAt(idxCreatedOn).getData$();
                }
                if (idxCategory > -1)
                {
                    coordinateCategory = rowData.getCellAt(idxCategory).getData$();
                }
                if (idxSheetName > -1)
                {
                    coordinateSheetName = rowData.getCellAt(idxSheetName).getData$();
                }
                if (idxRowName > -1)
                {
                    coordinateRowName = rowData.getCellAt(idxRowName).getData$();
                }
                if (idxCoordinateXAxis > -1)
                {
                    coordinateCoordinateXAxis = rowData.getCellAt(idxCoordinateXAxis).getData$();
                }
                if (idxCoordinateYAxis > -1)
                {
                    coordinateCoordinateYAxis = rowData.getCellAt(idxCoordinateYAxis).getData$();
                }
                if (idxCoordinateZAxis > -1)
                {
                    coordinateCoordinateZAxis = rowData.getCellAt(idxCoordinateZAxis).getData$();
                }
                if (idxExtSystem > -1)
                {
                    coordinateExtSystem = rowData.getCellAt(idxExtSystem).getData$();
                }
                if (idxExtObject > -1)
                {
                    coordinateExtObject = rowData.getCellAt(idxExtObject).getData$();
                }
                if (idxExtIdentifier > -1)
                {
                    coordinateExtIdentifier = rowData.getCellAt(idxExtIdentifier).getData$();
                }
                if (idxClockwiseRotation > -1)
                {
                    coordinateClockwiseRotation = rowData.getCellAt(idxClockwiseRotation).getData$();
                }
                if (idxElevationalRotation > -1)
                {
                    coordinateElevationalRotation = rowData.getCellAt(idxElevationalRotation).getData$();
                }
                if (idxYawRotation > -1)
                {
                    coordinateYawRotation = rowData.getCellAt(idxYawRotation).getData$();
                }
                coordinateCreatedOn = getCobieStringHandler().calendarFromString(coordinateCreatedOnString);
                tmpCoordinate.setName(cobieStringHandler.getCOBieString(coordinateName));
                tmpCoordinate.setCreatedBy(cobieStringHandler.getCOBieString(coordinateCreatedBy));
                tmpCoordinate.setCreatedOn(coordinateCreatedOn);
                tmpCoordinate.setCategory(cobieStringHandler.getCOBieString(coordinateCategory));
                tmpCoordinate.setSheetName(cobieStringHandler.getCOBieString(coordinateSheetName));
                tmpCoordinate.setRowName(cobieStringHandler.getCOBieString(coordinateRowName));
                tmpCoordinate.setCoordinateXAxis(cobieStringHandler.getCOBieString(coordinateCoordinateXAxis));
                tmpCoordinate.setCoordinateYAxis(cobieStringHandler.getCOBieString(coordinateCoordinateYAxis));
                tmpCoordinate.setCoordinateZAxis(cobieStringHandler.getCOBieString(coordinateCoordinateZAxis));
                tmpCoordinate.setClockwiseRotation(cobieStringHandler.getCOBieString(coordinateClockwiseRotation));
                tmpCoordinate.setElevationalRotation(cobieStringHandler.getCOBieString(coordinateElevationalRotation));
                tmpCoordinate.setExtIdentifier(cobieStringHandler.getCOBieString(coordinateExtIdentifier));
                tmpCoordinate.setExtObject(cobieStringHandler.getCOBieString(coordinateExtObject));
                tmpCoordinate.setExtSystem(cobieStringHandler.getCOBieString(coordinateExtSystem));
                tmpCoordinate.setYawRotation(cobieStringHandler.getCOBieString(coordinateYawRotation));
            }
        }
    }

}
