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
import org.erdc.cobie.sheetxmldata.ImpactType;
import org.erdc.cobie.utils.stringwriters.COBieStringHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImpactParser extends Parser
{
    public ImpactParser(COBIEType cobie, Workbook workbook, COBieStringHandler cobieStringWriter)
    {
        super(cobie, workbook, cobieStringWriter);
    }

    public static enum ImpactColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, ImpactType, ImpactStage, SheetName, RowName, Value, ImpactUnit, LeadInTime, Duration, LeadOutTime, ExtSystem, ExtObject, ExtIdentifier, Description
    }

    public static ArrayList<String> ImpactColumnNames = new ArrayList<String>(Arrays.asList("Name", "CreatedBy", "CreatedOn", "ImpactType",
            "ImpactStage", "SheetName", "RowName", "Value", "ImpactUnit", "LeadInTime", "Duration", "LeadOutTime", "ExtSystem", "ExtObject",
            "ExtIdentifier", "Description"));

    public ImpactParser(COBIEType cobie, Workbook workbook)
    {
        super(cobie, workbook);
    };

    @Override
    protected List<String> getColumnNames()
    {
        return ImpactColumnNames;
    }

    @Override
    protected Logger getLogger()
    {
        return LoggerFactory.getLogger(ImpactParser.class);
    }

    @Override
    protected String getWorksheetName()
    {
        return COBieUtility.CobieSheetName.Impact.name();
    }

    @Override
    protected void write()
    {
        COBIEType.Impacts impacts = getCobie().addNewImpacts();
        Worksheet sheet = getWorksheet();

        if (sheet != null)
        {
            Map<String, Integer> columnDictionary = getColumnDictionary();

            String impactName = "";
            String impactCreatedBy = "";
            String impactCreatedOnString = "";
            Calendar impactCreatedOn;
            String impactImpactType = "";
            String impactImpactStage = "";
            String impactSheetName = "";
            String impactRowName = "";
            String impactValue = "";
            int idxName;
            int idxCreatedBy;
            int idxCreatedOn;
            int idxImpactType;
            int idxImpactStage;
            int idxSheetName;
            int idxRowName;
            int idxValue;
            int idxImpactUnit;
            int idxLeadInTime;
            int idxDuration;
            int idxLeadOutTime;
            int idxExtSystem;
            int idxExtObject;
            int idxExtIdentifier;
            int idxDescription;

            idxName = columnDictionary.get(ImpactColumnNameLiterals.Name.toString());
            idxCreatedBy = columnDictionary.get(ImpactColumnNameLiterals.CreatedBy.toString());
            idxCreatedOn = columnDictionary.get(ImpactColumnNameLiterals.CreatedOn.toString());
            idxImpactType = columnDictionary.get(ImpactColumnNameLiterals.ImpactType.toString());
            idxImpactStage = columnDictionary.get(ImpactColumnNameLiterals.ImpactStage.toString());
            idxSheetName = columnDictionary.get(ImpactColumnNameLiterals.SheetName.toString());
            idxRowName = columnDictionary.get(ImpactColumnNameLiterals.RowName.toString());
            idxValue = columnDictionary.get(ImpactColumnNameLiterals.Value.toString());
            idxImpactUnit = columnDictionary.get(ImpactColumnNameLiterals.ImpactUnit.toString());
            idxLeadInTime = columnDictionary.get(ImpactColumnNameLiterals.LeadInTime.toString());
            idxDuration = columnDictionary.get(ImpactColumnNameLiterals.Duration.toString());
            idxLeadOutTime = columnDictionary.get(ImpactColumnNameLiterals.LeadOutTime.toString());
            idxExtSystem = columnDictionary.get(ImpactColumnNameLiterals.ExtSystem.toString());
            idxExtObject = columnDictionary.get(ImpactColumnNameLiterals.ExtObject.toString());
            idxExtIdentifier = columnDictionary.get(ImpactColumnNameLiterals.ExtIdentifier.toString());
            idxDescription = columnDictionary.get(ImpactColumnNameLiterals.Description.toString());
            int rowIdx;
            int firstRowIdx = Worksheet.firstRow;
            for (Row rowData : sheet.getRows())
            {
                rowIdx = rowData.getIndex();
                if ((rowIdx > firstRowIdx) && COBieSpreadSheet.isRowPopulated(rowData, 1, 100))
                {
                    ImpactType tmpImpact = impacts.addNewImpact();
                    if (idxName > -1)
                    {
                        impactName = rowData.getCellAt(idxName).getData$();
                    }
                    if (idxCreatedBy > -1)
                    {
                        impactCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
                    }
                    if (idxCreatedOn > -1)
                    {
                        impactCreatedOnString = rowData.getCellAt(idxCreatedOn).getData$();
                    }
                    if (idxImpactType > -1)
                    {
                        impactImpactType = rowData.getCellAt(idxImpactType).getData$();
                    }
                    if (idxImpactStage > -1)
                    {
                        impactImpactStage = rowData.getCellAt(idxImpactStage).getData$();
                    }
                    if (idxSheetName > -1)
                    {
                        impactSheetName = rowData.getCellAt(idxSheetName).getData$();
                    }
                    if (idxRowName > -1)
                    {
                        impactRowName = rowData.getCellAt(idxRowName).getData$();
                    }
                    if (idxValue > -1)
                    {
                        impactValue = rowData.getCellAt(idxValue).getData$();
                    }
                    if (idxImpactUnit > -1)
                    {
                        rowData.getCellAt(idxImpactUnit).getData$();
                    }
                    if (idxLeadInTime > -1)
                    {
                        rowData.getCellAt(idxLeadInTime).getData$();
                    }
                    if (idxDuration > -1)
                    {
                        rowData.getCellAt(idxDuration).getData$();
                    }
                    if (idxLeadOutTime > -1)
                    {
                        rowData.getCellAt(idxLeadOutTime).getData$();
                    }
                    if (idxExtSystem > -1)
                    {
                        rowData.getCellAt(idxExtSystem).getData$();
                    }
                    if (idxExtObject > -1)
                    {
                        rowData.getCellAt(idxExtObject).getData$();
                    }
                    if (idxExtIdentifier > -1)
                    {
                        rowData.getCellAt(idxExtIdentifier).getData$();
                    }
                    if (idxDescription > -1)
                    {
                        rowData.getCellAt(idxDescription).getData$();
                    }
                    impactCreatedOn = getCobieStringHandler().calendarFromString(impactCreatedOnString);
                    tmpImpact.setName(cobieStringHandler.getCOBieString(impactName));
                    tmpImpact.setCreatedBy(cobieStringHandler.getCOBieString(impactCreatedBy));
                    tmpImpact.setCreatedOn(impactCreatedOn);
                    tmpImpact.setImpactType(cobieStringHandler.getCOBieString(impactImpactType));
                    tmpImpact.setImpactStage(cobieStringHandler.getCOBieString(impactImpactStage));
                    tmpImpact.setSheetName(cobieStringHandler.getCOBieString(impactSheetName));
                    tmpImpact.setRowName(cobieStringHandler.getCOBieString(impactRowName));
                    tmpImpact.setValue(cobieStringHandler.getCOBieString(impactValue));
                }
            }
        }

    }

}
