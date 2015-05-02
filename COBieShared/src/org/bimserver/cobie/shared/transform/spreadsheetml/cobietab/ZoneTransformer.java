package org.bimserver.cobie.shared.transform.spreadsheetml.cobietab;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.bimserver.cobie.shared.COBieTokenUtility;
import org.bimserver.cobie.shared.COBieTokenUtility.ZoneColumnNameLiterals;
import org.bimserver.cobie.shared.utility.COBieStringHandler;
import org.bimserver.cobie.shared.utility.COBieUtility.CobieSheetName;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.ZoneType;

public class ZoneTransformer extends SpreadsheetMLTransformer
{

    public ZoneTransformer(COBIEType cobie, Workbook workbook, COBieStringHandler cobieStringWriter)
    {
        super(workbook, cobie, cobieStringWriter);
    }

    public ZoneTransformer(COBIEType cobie, Workbook workbook)
    {
        super(cobie, workbook);

    }

    @Override
    protected List<String> getColumnNames()
    {
        return COBieTokenUtility.ZoneColumnNames;
    }

    @Override
    protected String getWorksheetName()
    {
        return CobieSheetName.Zone.name();
    }

    @Override
    protected void write()
    {
        COBIEType.Zones zones = getTarget().addNewZones();
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
                zoneCreatedOn = getCobieStringHandler().calendarFromString(zoneCreatedOnString);
                tmpZone.setName(cobieStringHandler.getCOBieString(zoneName));
                tmpZone.setCreatedBy(cobieStringHandler.getCOBieString(zoneCreatedBy));
                tmpZone.setCreatedOn(zoneCreatedOn);
                tmpZone.setCategory(cobieStringHandler.getCOBieString(zoneCategory));
                tmpZone.setSpaceNames(cobieStringHandler.getCOBieString(zoneSpaceNames));
                tmpZone.setExtSystem(cobieStringHandler.getCOBieString(zoneExtSystem));
                tmpZone.setExtObject(cobieStringHandler.getCOBieString(zoneExtObject));
                tmpZone.setExtIdentifier(cobieStringHandler.getCOBieString(zoneExtIdentifier));
                tmpZone.setDescription(cobieStringHandler.getCOBieString(zoneDescription));
            }
        }
    }

}
