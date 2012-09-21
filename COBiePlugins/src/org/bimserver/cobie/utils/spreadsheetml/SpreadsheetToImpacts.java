package org.bimserver.cobie.utils.spreadsheetml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.ImpactType;
import org.bimserver.shared.cobie.COBieUtility;

public class SpreadsheetToImpacts
{
	public static ArrayList<String> ImpactColumnNames = new ArrayList<String>(
			Arrays.asList("Name", "CreatedBy", "CreatedOn", "ImpactType",
					"ImpactStage", "SheetName", "RowName", "Value",
					"ImpactUnit", "LeadInTime", "Duration", "LeadOutTime",
					"ExtSystem", "ExtObject", "ExtIdentifier", "Description"));

	public static enum ImpactColumnNameLiterals
	{
		Name, CreatedBy, CreatedOn, ImpactType, ImpactStage, SheetName, RowName, Value, ImpactUnit, LeadInTime, Duration, LeadOutTime, ExtSystem, ExtObject, ExtIdentifier, Description
	};

	public static ArrayList<String> getImpactColumns()
	{
		return ImpactColumnNames;
	}

	public static void writeImpactsToCOBie(COBIEType cType, Workbook workbook)
	{
		COBIEType.Impacts impacts = cType.addNewImpacts();
		Worksheet sheet = workbook
				.getWorksheet(COBieUtility.CobieSheetName.Impact.toString());
		Map<String, Integer> columnDictionary = COBieSpreadSheet
				.GetWorksheetColumnDictionary(sheet, getImpactColumns());
		String impactName = "";
		String impactCreatedBy = "";
		String impactCreatedOnString = "";
		Calendar impactCreatedOn;
		String impactImpactType = "";
		String impactImpactStage = "";
		String impactSheetName = "";
		String impactRowName = "";
		String impactValue = "";
		String impactImpactUnit = "";
		String impactLeadInTime = "";
		String impactDuration = "";
		String impactLeadOutTime = "";
		String impactExtSystem = "";
		String impactExtObject = "";
		String impactExtIdentifier = "";
		String impactDescription = "";
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
		idxName = columnDictionary
				.get(ImpactColumnNameLiterals.Name.toString());
		idxCreatedBy = columnDictionary.get(ImpactColumnNameLiterals.CreatedBy
				.toString());
		idxCreatedOn = columnDictionary.get(ImpactColumnNameLiterals.CreatedOn
				.toString());
		idxImpactType = columnDictionary
				.get(ImpactColumnNameLiterals.ImpactType.toString());
		idxImpactStage = columnDictionary
				.get(ImpactColumnNameLiterals.ImpactStage.toString());
		idxSheetName = columnDictionary.get(ImpactColumnNameLiterals.SheetName
				.toString());
		idxRowName = columnDictionary.get(ImpactColumnNameLiterals.RowName
				.toString());
		idxValue = columnDictionary.get(ImpactColumnNameLiterals.Value
				.toString());
		idxImpactUnit = columnDictionary
				.get(ImpactColumnNameLiterals.ImpactUnit.toString());
		idxLeadInTime = columnDictionary
				.get(ImpactColumnNameLiterals.LeadInTime.toString());
		idxDuration = columnDictionary.get(ImpactColumnNameLiterals.Duration
				.toString());
		idxLeadOutTime = columnDictionary
				.get(ImpactColumnNameLiterals.LeadOutTime.toString());
		idxExtSystem = columnDictionary.get(ImpactColumnNameLiterals.ExtSystem
				.toString());
		idxExtObject = columnDictionary.get(ImpactColumnNameLiterals.ExtObject
				.toString());
		idxExtIdentifier = columnDictionary
				.get(ImpactColumnNameLiterals.ExtIdentifier.toString());
		idxDescription = columnDictionary
				.get(ImpactColumnNameLiterals.Description.toString());
		int rowIdx;
		int firstRowIdx = sheet.firstRow;
		for (Row rowData : sheet.getRows())
		{
			rowIdx = rowData.getIndex();
			if (rowIdx > firstRowIdx)
			{
				ImpactType tmpImpact = impacts.addNewImpact();
				if (idxName > -1)
					impactName = rowData.getCellAt(idxName).getData$();
				if (idxCreatedBy > -1)
					impactCreatedBy = rowData.getCellAt(idxCreatedBy)
							.getData$();
				if (idxCreatedOn > -1)
					impactCreatedOnString = rowData.getCellAt(idxCreatedOn)
							.getData$();
				if (idxImpactType > -1)
					impactImpactType = rowData.getCellAt(idxImpactType)
							.getData$();
				if (idxImpactStage > -1)
					impactImpactStage = rowData.getCellAt(idxImpactStage)
							.getData$();
				if (idxSheetName > -1)
					impactSheetName = rowData.getCellAt(idxSheetName)
							.getData$();
				if (idxRowName > -1)
					impactRowName = rowData.getCellAt(idxRowName).getData$();
				if (idxValue > -1)
					impactValue = rowData.getCellAt(idxValue).getData$();
				if (idxImpactUnit > -1)
					impactImpactUnit = rowData.getCellAt(idxImpactUnit)
							.getData$();
				if (idxLeadInTime > -1)
					impactLeadInTime = rowData.getCellAt(idxLeadInTime)
							.getData$();
				if (idxDuration > -1)
					impactDuration = rowData.getCellAt(idxDuration).getData$();
				if (idxLeadOutTime > -1)
					impactLeadOutTime = rowData.getCellAt(idxLeadOutTime)
							.getData$();
				if (idxExtSystem > -1)
					impactExtSystem = rowData.getCellAt(idxExtSystem)
							.getData$();
				if (idxExtObject > -1)
					impactExtObject = rowData.getCellAt(idxExtObject)
							.getData$();
				if (idxExtIdentifier > -1)
					impactExtIdentifier = rowData.getCellAt(idxExtIdentifier)
							.getData$();
				if (idxDescription > -1)
					impactDescription = rowData.getCellAt(idxDescription)
							.getData$();
				impactCreatedOn = COBieUtility
						.calendarFromString(impactCreatedOnString);
				tmpImpact.setName(COBieUtility.getCOBieString(impactName));
				tmpImpact.setCreatedBy(COBieUtility
						.getCOBieString(impactCreatedBy));
				tmpImpact.setCreatedOn(impactCreatedOn);
				tmpImpact.setImpactType(COBieUtility
						.getCOBieString(impactImpactType));
				tmpImpact.setImpactStage(COBieUtility
						.getCOBieString(impactImpactStage));
				tmpImpact.setSheetName(COBieUtility
						.getCOBieString(impactSheetName));
				tmpImpact
						.setRowName(COBieUtility.getCOBieString(impactRowName));
				tmpImpact.setValue(COBieUtility.getCOBieString(impactValue));
			}
		}
	}

}
