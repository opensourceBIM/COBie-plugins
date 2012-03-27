package org.bimserver.cobie.utils.spreadsheetml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.ZoneType;
import org.bimserver.cobie.utils.COBieUtility;

public class SpreadsheetToZones {
	public static ArrayList<String> ZoneColumnNames = new ArrayList<String>(
			Arrays.asList("Name", "CreatedBy", "CreatedOn", "Category",
					"SpaceNames", "ExtSystem", "ExtObject", "ExtIdentifier",
					"Description"));

	public static enum ZoneColumnNameLiterals {
		Name, CreatedBy, CreatedOn, Category, SpaceNames, ExtSystem, ExtObject, ExtIdentifier, Description
	};

	public static ArrayList<String> getZoneColumns() {
		return SpreadsheetToZones.ZoneColumnNames;
	}

	public static void writeZonesToCOBie(COBIEType cType, Workbook workbook) {
		COBIEType.Zones zones = cType.addNewZones();
		Worksheet sheet = workbook
				.getWorksheet(COBieUtility.CobieSheetName.Zone.toString());
		Map<String, Integer> columnDictionary = COBieUtility
				.GetWorksheetColumnDictionary(sheet, getZoneColumns());
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
		idxCreatedBy = columnDictionary.get(ZoneColumnNameLiterals.CreatedBy
				.toString());
		idxCreatedOn = columnDictionary.get(ZoneColumnNameLiterals.CreatedOn
				.toString());
		idxCategory = columnDictionary.get(ZoneColumnNameLiterals.Category
				.toString());
		idxSpaceNames = columnDictionary.get(ZoneColumnNameLiterals.SpaceNames
				.toString());
		idxExtSystem = columnDictionary.get(ZoneColumnNameLiterals.ExtSystem
				.toString());
		idxExtObject = columnDictionary.get(ZoneColumnNameLiterals.ExtObject
				.toString());
		idxExtIdentifier = columnDictionary
				.get(ZoneColumnNameLiterals.ExtIdentifier.toString());
		idxDescription = columnDictionary
				.get(ZoneColumnNameLiterals.Description.toString());
		int rowIdx;
		int firstRowIdx = sheet.firstRow;
		for (Row rowData : sheet.getRows()) {
			rowIdx = rowData.getIndex();
			if (rowIdx > firstRowIdx && COBieSpreadSheet.isRowPopulated(rowData, 1,100)) {
				ZoneType tmpZone = zones.addNewZone();
				if (idxName > -1)
					zoneName = rowData.getCellAt(idxName).getData$();
				if (idxCreatedBy > -1)
					zoneCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
				if (idxCreatedOn > -1)
					zoneCreatedOnString = rowData.getCellAt(idxCreatedOn)
							.getData$();
				if (idxCategory > -1)
					zoneCategory = rowData.getCellAt(idxCategory).getData$();
				if (idxSpaceNames > -1)
					zoneSpaceNames = rowData.getCellAt(idxSpaceNames)
							.getData$();
				if (idxExtSystem > -1)
					zoneExtSystem = rowData.getCellAt(idxExtSystem).getData$();
				if (idxExtObject > -1)
					zoneExtObject = rowData.getCellAt(idxExtObject).getData$();
				if (idxExtIdentifier > -1)
					zoneExtIdentifier = rowData.getCellAt(idxExtIdentifier)
							.getData$();
				if (idxDescription > -1)
					zoneDescription = rowData.getCellAt(idxDescription)
							.getData$();
				zoneCreatedOn = COBieUtility
						.calendarFromString(zoneCreatedOnString);
				tmpZone.setName(COBieUtility.getCOBieString(zoneName));
				tmpZone.setCreatedBy(COBieUtility.getCOBieString(zoneCreatedBy));
				tmpZone.setCreatedOn(zoneCreatedOn);
				tmpZone.setCategory(COBieUtility.getCOBieString(zoneCategory));
				tmpZone.setSpaceNames(COBieUtility
						.getCOBieString(zoneSpaceNames));
				tmpZone.setExtSystem(COBieUtility.getCOBieString(zoneExtSystem));
				tmpZone.setExtObject(COBieUtility.getCOBieString(zoneExtObject));
				tmpZone.setExtIdentifier(COBieUtility
						.getCOBieString(zoneExtIdentifier));
				tmpZone.setDescription(COBieUtility
						.getCOBieString(zoneDescription));
			}
		}
	}

}
