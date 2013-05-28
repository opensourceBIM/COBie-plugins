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
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.IssueType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IssueParser extends Parser
{
    public static enum IssueColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Type, Risk, Chance, Impact, SheetName1, RowName1, SheetName2, RowName2, Description, Owner, Mitigation, ExtSystem
    }

    public static ArrayList<String> IssueColumnNames = new ArrayList<String>(Arrays.asList("Name", "CreatedBy", "CreatedOn", "Type", "Risk",
            "Chance", "Impact", "SheetName1", "RowName1", "SheetName2", "RowName2", "Description", "Owner", "Mitigation", "ExtSystem"));

    public IssueParser(COBIEType cobie, Workbook workbook)
    {
        super(cobie, workbook);
    };

    @Override
    protected List<String> getColumnNames()
    {
        return IssueColumnNames;
    }

    @Override
    protected Logger getLogger()
    {
        return LoggerFactory.getLogger(IssueParser.class);
    }

    @Override
    protected String getWorksheetName()
    {
        return CobieSheetName.Issue.name();
    }

    @Override
    protected void write()
    {
        COBIEType.Issues issues = getCobie().addNewIssues();
        Worksheet sheet = getWorksheet();
        Map<String, Integer> columnDictionary = getColumnDictionary();
        String issueName = "";
        String issueCreatedBy = "";
        String issueCreatedOnString = "";
        Calendar issueCreatedOn;
        String issueType = "";
        String issueRisk = "";
        String issueChance = "";
        String issueImpact = "";
        String issueSheetName1 = "";
        int idxName;
        int idxCreatedBy;
        int idxCreatedOn;
        int idxType;
        int idxRisk;
        int idxChance;
        int idxImpact;
        int idxSheetName1;
        int idxRowName1;
        int idxSheetName2;
        int idxRowName2;
        int idxDescription;
        int idxOwner;
        int idxMitigation;
        int idxExtSystem;
        idxName = columnDictionary.get(IssueColumnNameLiterals.Name.toString());
        idxCreatedBy = columnDictionary.get(IssueColumnNameLiterals.CreatedBy.toString());
        idxCreatedOn = columnDictionary.get(IssueColumnNameLiterals.CreatedOn.toString());
        idxType = columnDictionary.get(IssueColumnNameLiterals.Type.toString());
        idxRisk = columnDictionary.get(IssueColumnNameLiterals.Risk.toString());
        idxChance = columnDictionary.get(IssueColumnNameLiterals.Chance.toString());
        idxImpact = columnDictionary.get(IssueColumnNameLiterals.Impact.toString());
        idxSheetName1 = columnDictionary.get(IssueColumnNameLiterals.SheetName1.toString());
        idxRowName1 = columnDictionary.get(IssueColumnNameLiterals.RowName1.toString());
        idxSheetName2 = columnDictionary.get(IssueColumnNameLiterals.SheetName2.toString());
        idxRowName2 = columnDictionary.get(IssueColumnNameLiterals.RowName2.toString());
        idxDescription = columnDictionary.get(IssueColumnNameLiterals.Description.toString());
        idxOwner = columnDictionary.get(IssueColumnNameLiterals.Owner.toString());
        idxMitigation = columnDictionary.get(IssueColumnNameLiterals.Mitigation.toString());
        idxExtSystem = columnDictionary.get(IssueColumnNameLiterals.ExtSystem.toString());
        int rowIdx;
        int firstRowIdx = Worksheet.firstRow;
        for (Row rowData : sheet.getRows())
        {
            rowIdx = rowData.getIndex();
            if ((rowIdx > firstRowIdx) && COBieSpreadSheet.isRowPopulated(rowData, 1, 100))
            {
                IssueType tmpIssue = issues.addNewIssue();
                if (idxName > -1)
                {
                    issueName = rowData.getCellAt(idxName).getData$();
                }
                if (idxCreatedBy > -1)
                {
                    issueCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
                }
                if (idxCreatedOn > -1)
                {
                    issueCreatedOnString = rowData.getCellAt(idxCreatedOn).getData$();
                }
                if (idxType > -1)
                {
                    issueType = rowData.getCellAt(idxType).getData$();
                }
                if (idxRisk > -1)
                {
                    issueRisk = rowData.getCellAt(idxRisk).getData$();
                }
                if (idxChance > -1)
                {
                    issueChance = rowData.getCellAt(idxChance).getData$();
                }
                if (idxImpact > -1)
                {
                    issueImpact = rowData.getCellAt(idxImpact).getData$();
                }
                if (idxSheetName1 > -1)
                {
                    issueSheetName1 = rowData.getCellAt(idxSheetName1).getData$();
                }
                if (idxRowName1 > -1)
                {
                    rowData.getCellAt(idxRowName1).getData$();
                }
                if (idxSheetName2 > -1)
                {
                    rowData.getCellAt(idxSheetName2).getData$();
                }
                if (idxRowName2 > -1)
                {
                    rowData.getCellAt(idxRowName2).getData$();
                }
                if (idxDescription > -1)
                {
                    rowData.getCellAt(idxDescription).getData$();
                }
                if (idxOwner > -1)
                {
                    rowData.getCellAt(idxOwner).getData$();
                }
                if (idxMitigation > -1)
                {
                    rowData.getCellAt(idxMitigation).getData$();
                }
                if (idxExtSystem > -1)
                {
                    rowData.getCellAt(idxExtSystem).getData$();
                }
                issueCreatedOn = COBieUtility.calendarFromString(issueCreatedOnString);
                tmpIssue.setName(COBieUtility.getCOBieString(issueName));
                tmpIssue.setCreatedBy(COBieUtility.getCOBieString(issueCreatedBy));
                tmpIssue.setCreatedOn(issueCreatedOn);
                tmpIssue.setType(COBieUtility.getCOBieString(issueType));
                tmpIssue.setRisk(COBieUtility.getCOBieString(issueRisk));
                tmpIssue.setChance(COBieUtility.getCOBieString(issueChance));
                tmpIssue.setImpact(COBieUtility.getCOBieString(issueImpact));
                tmpIssue.setSheetName1(COBieUtility.getCOBieString(issueSheetName1));
            }
        }
    }

}
