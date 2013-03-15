package org.erdc.cobie.plugins.utils.spreadsheetml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.IssueType;

public class SpreadsheetToIssues
{
	public static ArrayList<String> IssueColumnNames = new ArrayList<String>(
			Arrays.asList("Name", "CreatedBy", "CreatedOn", "Type", "Risk",
					"Chance", "Impact", "SheetName1", "RowName1", "SheetName2",
					"RowName2", "Description", "Owner", "Mitigation",
					"ExtSystem"));

	public static enum IssueColumnNameLiterals
	{
		Name, CreatedBy, CreatedOn, Type, Risk, Chance, Impact, SheetName1, RowName1, SheetName2, RowName2, Description, Owner, Mitigation, ExtSystem
	};

	public static ArrayList<String> getIssueColumns()
	{
		return IssueColumnNames;
	}

	public static void writeIssuesToCOBie(COBIEType cobie, Workbook workbook)
	{
		COBIEType.Issues issues = cobie.addNewIssues();
		Worksheet sheet = workbook
				.getWorksheet(COBieUtility.CobieSheetName.Issue.toString());
		Map<String, Integer> columnDictionary = COBieSpreadSheet
				.GetWorksheetColumnDictionary(sheet, getIssueColumns());
		String issueName = "";
		String issueCreatedBy = "";
		String issueCreatedOnString = "";
		Calendar issueCreatedOn;
		String issueType = "";
		String issueRisk = "";
		String issueChance = "";
		String issueImpact = "";
		String issueSheetName1 = "";
		String issueRowName1 = "";
		String issueSheetName2 = "";
		String issueRowName2 = "";
		String issueDescription = "";
		String issueOwner = "";
		String issueMitigation = "";
		String issueExtSystem = "";
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
		idxCreatedBy = columnDictionary.get(IssueColumnNameLiterals.CreatedBy
				.toString());
		idxCreatedOn = columnDictionary.get(IssueColumnNameLiterals.CreatedOn
				.toString());
		idxType = columnDictionary.get(IssueColumnNameLiterals.Type.toString());
		idxRisk = columnDictionary.get(IssueColumnNameLiterals.Risk.toString());
		idxChance = columnDictionary.get(IssueColumnNameLiterals.Chance
				.toString());
		idxImpact = columnDictionary.get(IssueColumnNameLiterals.Impact
				.toString());
		idxSheetName1 = columnDictionary.get(IssueColumnNameLiterals.SheetName1
				.toString());
		idxRowName1 = columnDictionary.get(IssueColumnNameLiterals.RowName1
				.toString());
		idxSheetName2 = columnDictionary.get(IssueColumnNameLiterals.SheetName2
				.toString());
		idxRowName2 = columnDictionary.get(IssueColumnNameLiterals.RowName2
				.toString());
		idxDescription = columnDictionary
				.get(IssueColumnNameLiterals.Description.toString());
		idxOwner = columnDictionary.get(IssueColumnNameLiterals.Owner
				.toString());
		idxMitigation = columnDictionary.get(IssueColumnNameLiterals.Mitigation
				.toString());
		idxExtSystem = columnDictionary.get(IssueColumnNameLiterals.ExtSystem
				.toString());
		int rowIdx;
		int firstRowIdx = sheet.firstRow;
		for (Row rowData : sheet.getRows())
		{
			rowIdx = rowData.getIndex();
			if (rowIdx > firstRowIdx && COBieSpreadSheet.isRowPopulated(rowData, 1,100))
			{
				IssueType tmpIssue = issues.addNewIssue();
				if (idxName > -1)
					issueName = rowData.getCellAt(idxName).getData$();
				if (idxCreatedBy > -1)
					issueCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
				if (idxCreatedOn > -1)
					issueCreatedOnString = rowData.getCellAt(idxCreatedOn)
							.getData$();
				if (idxType > -1)
					issueType = rowData.getCellAt(idxType).getData$();
				if (idxRisk > -1)
					issueRisk = rowData.getCellAt(idxRisk).getData$();
				if (idxChance > -1)
					issueChance = rowData.getCellAt(idxChance).getData$();
				if (idxImpact > -1)
					issueImpact = rowData.getCellAt(idxImpact).getData$();
				if (idxSheetName1 > -1)
					issueSheetName1 = rowData.getCellAt(idxSheetName1)
							.getData$();
				if (idxRowName1 > -1)
					issueRowName1 = rowData.getCellAt(idxRowName1).getData$();
				if (idxSheetName2 > -1)
					issueSheetName2 = rowData.getCellAt(idxSheetName2)
							.getData$();
				if (idxRowName2 > -1)
					issueRowName2 = rowData.getCellAt(idxRowName2).getData$();
				if (idxDescription > -1)
					issueDescription = rowData.getCellAt(idxDescription)
							.getData$();
				if (idxOwner > -1)
					issueOwner = rowData.getCellAt(idxOwner).getData$();
				if (idxMitigation > -1)
					issueMitigation = rowData.getCellAt(idxMitigation)
							.getData$();
				if (idxExtSystem > -1)
					issueExtSystem = rowData.getCellAt(idxExtSystem).getData$();
				issueCreatedOn = COBieUtility
						.calendarFromString(issueCreatedOnString);
				tmpIssue.setName(COBieUtility.getCOBieString(issueName));
				tmpIssue.setCreatedBy(COBieUtility
						.getCOBieString(issueCreatedBy));
				tmpIssue.setCreatedOn(issueCreatedOn);
				tmpIssue.setType(COBieUtility.getCOBieString(issueType));
				tmpIssue.setRisk(COBieUtility.getCOBieString(issueRisk));
				tmpIssue.setChance(COBieUtility.getCOBieString(issueChance));
				tmpIssue.setImpact(COBieUtility.getCOBieString(issueImpact));
				tmpIssue.setSheetName1(COBieUtility
						.getCOBieString(issueSheetName1));
			}
		}
	}

}
