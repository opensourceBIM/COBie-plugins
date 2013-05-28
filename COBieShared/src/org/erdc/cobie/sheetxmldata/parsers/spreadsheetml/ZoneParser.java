package org.erdc.cobie.sheetxmldata.parsers.spreadsheetml;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.erdc.cobie.shared.COBieTokenUtility;
import org.erdc.cobie.shared.COBieTokenUtility.ZoneColumnNameLiterals;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.ZoneType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZoneParser extends Parser
{

    public ZoneParser(COBIEType cobie, Workbook workbook)
    {
        super(cobie, workbook);

    }

    @Override
    protected List<String> getColumnNames()
    {
        return COBieTokenUtility.ZoneColumnNames;
    }

    @Override
    protected Logger getLogger()
    {
        return LoggerFactory.getLogger(ZoneParser.class);
    }

    @Override
    protected String getWorksheetName()
    {
        return CobieSheetName.Zone.name();
    }

    @Override
    protected void write()
    {
        COBIEType.Zones zones = getCobie().addNewZones();
        Worksheet sheet = getWorksheet();
        Map<String, Integer> columnDictionary = getColumnDictionary();
        String zoneName = "";
        String zoneCreatedBy = "";
        Calendar zoneCreatedOn;
        String zoneCreatedOnString = "";
        String zoneCategory = "";
        String zoneSpaceNames = "";
        String zoneExtSystem = "";
        String zoneExtObject = "";
        String zoneExtIdentifier = "";
        String zoneDescription = "";
        int idxName;
        int idxCreatedBy;
        int idxCreatedOn;
        int idxCategory;
        int idxSpaceNames;
        int idxExtSystem;
        int idxExtObject;
        int idxExtIdentifier;
        int idxDescription;
        idxName = columnDictionary.get(ZoneColumnNameLiterals.Name.toString());
        idxCreatedBy = columnDictionary.get(ZoneColumnNameLiterals.CreatedBy.toString());
        idxCreatedOn = columnDictionary.get(ZoneColumnNameLiterals.CreatedOn.toString());
        idxCategory = columnDictionary.get(ZoneColumnNameLiterals.Category.toString());
        idxSpaceNames = columnDictionary.get(ZoneColumnNameLiterals.SpaceNames.toString());
        idxExtSystem = columnDictionary.get(ZoneColumnNameLiterals.ExtSystem.toString());
        idxExtObject = columnDictionary.get(ZoneColumnNameLiterals.ExtObject.toString());
        idxExtIdentifier = columnDictionary.get(ZoneColumnNameLiterals.ExtIdentifier.toString());
        idxDescription = columnDictionary.get(ZoneColumnNameLiterals.Description.toString());
        int rowIdx;
        int firstRowIdx = Worksheet.firstRow;
        for (Row rowData : sheet.getRows())
        {
            rowIdx = rowData.getIndex();
            if ((rowIdx > firstRowIdx) && COBieSpreadSheet.isRowPopulated(rowData, 1, 100))
            {
                ZoneType tmpZone = zones.addNewZone();
                if (idxName > -1)
                {
                    zoneName = rowData.getCellAt(idxName).getData$();
                }
                if (idxCreatedBy > -1)
                {
                    zoneCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
                }
                if (idxCreatedOn > -1)
                {
                    zoneCreatedOnString = rowData.getCellAt(idxCreatedOn).getData$();
                }
                if (idxCategory > -1)
                {
                    zoneCategory = rowData.getCellAt(idxCategory).getData$();
                }
                if (idxSpaceNames > -1)
                {
                    zoneSpaceNames = rowData.getCellAt(idxSpaceNames).getData$();
                }
                if (idxExtSystem > -1)
                {
                    zoneExtSystem = rowData.getCellAt(idxExtSystem).getData$();
                }
                if (idxExtObject > -1)
                {
                    zoneExtObject = rowData.getCellAt(idxExtObject).getData$();
                }
                if (idxExtIdentifier > -1)
                {
                    zoneExtIdentifier = rowData.getCellAt(idxExtIdentifier).getData$();
                }
                if (idxDescription > -1)
                {
                    zoneDescription = rowData.getCellAt(idxDescription).getData$();
                }
                zoneCreatedOn = COBieUtility.calendarFromString(zoneCreatedOnString);
                tmpZone.setName(COBieUtility.getCOBieString(zoneName));
                tmpZone.setCreatedBy(COBieUtility.getCOBieString(zoneCreatedBy));
                tmpZone.setCreatedOn(zoneCreatedOn);
                tmpZone.setCategory(COBieUtility.getCOBieString(zoneCategory));
                tmpZone.setSpaceNames(COBieUtility.getCOBieString(zoneSpaceNames));
                tmpZone.setExtSystem(COBieUtility.getCOBieString(zoneExtSystem));
                tmpZone.setExtObject(COBieUtility.getCOBieString(zoneExtObject));
                tmpZone.setExtIdentifier(COBieUtility.getCOBieString(zoneExtIdentifier));
                tmpZone.setDescription(COBieUtility.getCOBieString(zoneDescription));
            }
        }
    }

}
