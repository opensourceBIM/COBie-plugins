package org.erdc.cobie.plugins.utils.spreadsheetml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.erdc.cobie.shared.COBieTokenUtility;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.COBieTokenUtility.AttributeColumnNameLiterals;
import org.erdc.cobie.sheetxmldata.AttributeType;
import org.erdc.cobie.sheetxmldata.COBIEType;


public class SpreadsheetToAttributes {

	public static ArrayList<String> getAttributeColumns() {
		return COBieTokenUtility.AttributeColumnNames;
	}
	public static void writeAttributesToCOBie(COBIEType cType, Workbook workbook) {
		COBIEType.Attributes attributes = cType.addNewAttributes();
		Worksheet sheet = workbook
				.getWorksheet(COBieUtility.CobieSheetName.Attribute.toString());
		Map<String, Integer> columnDictionary = COBieSpreadSheet
				.GetWorksheetColumnDictionary(sheet, getAttributeColumns());
		String attributeName = "";
		String attributeCreatedBy = "";
		String attributeCreatedOnString = "";
		Calendar attributeCreatedOn;
		String attributeCategory = "";
		String attributeSheetName = "";
		String attributeRowName = "";
		String attributeValue = "";
		String attributeUnit = "";
		String attributeExtSystem = "";
		String attributeExtObject = "";
		String attributeExtIdentifier = "";
		String attributeDescription = "";
		String attributeAllowedValues = "";
		int idxName;
		int idxCreatedBy;
		int idxCreatedOn;
		int idxCategory;
		int idxSheetName;
		int idxRowName;
		int idxValue;
		int idxUnit;
		int idxExtSystem;
		int idxExtObject;
		int idxExtIdentifier;
		int idxDescription;
		int idxAllowedValues;
		idxName = columnDictionary.get(AttributeColumnNameLiterals.Name
				.toString());
		idxCreatedBy = columnDictionary
				.get(AttributeColumnNameLiterals.CreatedBy.toString());
		idxCreatedOn = columnDictionary
				.get(AttributeColumnNameLiterals.CreatedOn.toString());
		idxCategory = columnDictionary.get(AttributeColumnNameLiterals.Category
				.toString());
		idxSheetName = columnDictionary
				.get(AttributeColumnNameLiterals.SheetName.toString());
		idxRowName = columnDictionary.get(AttributeColumnNameLiterals.RowName
				.toString());
		idxValue = columnDictionary.get(AttributeColumnNameLiterals.Value
				.toString());
		idxUnit = columnDictionary.get(AttributeColumnNameLiterals.Unit
				.toString());
		idxExtSystem = columnDictionary
				.get(AttributeColumnNameLiterals.ExtSystem.toString());
		idxExtObject = columnDictionary
				.get(AttributeColumnNameLiterals.ExtObject.toString());
		idxExtIdentifier = columnDictionary
				.get(AttributeColumnNameLiterals.ExtIdentifier.toString());
		idxDescription = columnDictionary
				.get(AttributeColumnNameLiterals.Description.toString());
		idxAllowedValues = columnDictionary
				.get(AttributeColumnNameLiterals.AllowedValues.toString());
		int rowIdx;
		int firstRowIdx = Worksheet.firstRow;
		for (Row rowData : sheet.getRows()) {
			rowIdx = rowData.getIndex();
			if (rowIdx > firstRowIdx && COBieSpreadSheet.isRowPopulated(rowData, 1,100)) {
				AttributeType tmpAttribute = attributes.addNewAttribute();
				if (idxName > -1)
					attributeName = rowData.getCellAt(idxName).getData$();
				if (idxCreatedBy > -1)
					attributeCreatedBy = rowData.getCellAt(idxCreatedBy)
							.getData$();
				if (idxCreatedOn > -1)
					attributeCreatedOnString = rowData.getCellAt(idxCreatedOn)
							.getData$();
				if (idxCategory > -1)
					attributeCategory = rowData.getCellAt(idxCategory)
							.getData$();
				if (idxSheetName > -1)
					attributeSheetName = rowData.getCellAt(idxSheetName)
							.getData$();
				if (idxRowName > -1)
					attributeRowName = rowData.getCellAt(idxRowName).getData$();
				if (idxValue > -1)
					attributeValue = rowData.getCellAt(idxValue).getData$();
				if (idxUnit > -1)
					attributeUnit = rowData.getCellAt(idxUnit).getData$();
				if (idxExtSystem > -1)
					attributeExtSystem = rowData.getCellAt(idxExtSystem)
							.getData$();
				if (idxExtObject > -1)
					attributeExtObject = rowData.getCellAt(idxExtObject)
							.getData$();
				if (idxExtIdentifier > -1)
					attributeExtIdentifier = rowData
							.getCellAt(idxExtIdentifier).getData$();
				if (idxDescription > -1)
					attributeDescription = rowData.getCellAt(idxDescription)
							.getData$();
				if (idxAllowedValues > -1)
					attributeAllowedValues = rowData
							.getCellAt(idxAllowedValues).getData$();
				attributeCreatedOn = COBieUtility
						.calendarFromString(attributeCreatedOnString);
				tmpAttribute
						.setName(COBieUtility.getCOBieString(attributeName));
				tmpAttribute.setCreatedBy(COBieUtility
						.getCOBieString(attributeCreatedBy));
				tmpAttribute.setCreatedOn(attributeCreatedOn);
				tmpAttribute.setCategory(COBieUtility
						.getCOBieString(attributeCategory));
				tmpAttribute.setSheetName(COBieUtility
						.getCOBieString(attributeSheetName));
				tmpAttribute.setRowName(COBieUtility
						.getCOBieString(attributeRowName));
				tmpAttribute.setValue(COBieUtility
						.getCOBieString(attributeValue));
				tmpAttribute
						.setUnit(COBieUtility.getCOBieString(attributeUnit));
				tmpAttribute.setExtSystem(COBieUtility
						.getCOBieString(attributeExtSystem));
				tmpAttribute.setExtObject(COBieUtility
						.getCOBieString(attributeExtObject));
				tmpAttribute.setExtIdentifier(COBieUtility
						.getCOBieString(attributeExtIdentifier));
				tmpAttribute.setDescription(COBieUtility
						.getCOBieString(attributeDescription));
				tmpAttribute.setAllowedValues(COBieUtility
						.getCOBieString(attributeAllowedValues));
			}
		}
	}

}
