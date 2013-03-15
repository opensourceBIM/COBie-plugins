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
import org.erdc.cobie.sheetxmldata.SpareType;

public class SpreadSheetToSpares
{
	public static ArrayList<String> SpareColumnNames = new ArrayList<String>(
			Arrays.asList("Name", "CreatedBy", "CreatedOn", "Category",
					"TypeName", "Suppliers", "ExtSystem", "ExtObject",
					"ExtIdentifier", "Description", "SetNumber","PartNumber"));

	public static enum SpareColumnNameLiterals
	{
		Name, CreatedBy, CreatedOn, Category, TypeName, Suppliers, ExtSystem, ExtObject, ExtIdentifier, Description, SetNumber,PartNumber
	};

	public static ArrayList<String> getSpareColumns()
	{
		return SpareColumnNames;
	}

	public static void writeSparesToCOBie(COBIEType cType, Workbook workbook)
	{
		COBIEType.Spares spares = cType.addNewSpares();
		Worksheet sheet = workbook
				.getWorksheet(COBieUtility.CobieSheetName.Spare.toString());
		Map<String, Integer> columnDictionary = COBieSpreadSheet
				.GetWorksheetColumnDictionary(sheet, getSpareColumns());
		String spareName = "";
		String spareCreatedBy = "";
		Calendar spareCreatedOn;
		String spareCreatedOnString = "";
		String spareCategory = "";
		String spareTypeName = "";
		String spareSuppliers = "";
		String spareExtSystem = "";
		String spareExtObject = "";
		String spareExtIdentifier = "";
		String spareDescription = "";
		String spareSetNumber = "";
		String sparePartNumber = "";
		int idxName;
		int idxCreatedBy;
		int idxCreatedOn;
		int idxCategory;
		int idxTypeName;
		int idxSuppliers;
		int idxExtSystem;
		int idxExtObject;
		int idxExtIdentifier;
		int idxDescription;
		int idxSetNumber;
		int idxPartNumber;
		idxName = columnDictionary.get(SpareColumnNameLiterals.Name.toString());
		idxCreatedBy = columnDictionary.get(SpareColumnNameLiterals.CreatedBy
				.toString());
		idxCreatedOn = columnDictionary.get(SpareColumnNameLiterals.CreatedOn
				.toString());
		idxCategory = columnDictionary.get(SpareColumnNameLiterals.Category
				.toString());
		idxTypeName = columnDictionary.get(SpareColumnNameLiterals.TypeName
				.toString());
		idxSuppliers = columnDictionary.get(SpareColumnNameLiterals.Suppliers
				.toString());
		idxExtSystem = columnDictionary.get(SpareColumnNameLiterals.ExtSystem
				.toString());
		idxExtObject = columnDictionary.get(SpareColumnNameLiterals.ExtObject
				.toString());
		idxExtIdentifier = columnDictionary
				.get(SpareColumnNameLiterals.ExtIdentifier.toString());
		idxDescription = columnDictionary
				.get(SpareColumnNameLiterals.Description.toString());
		idxSetNumber = columnDictionary.get(SpareColumnNameLiterals.SetNumber
				.toString());
		idxPartNumber = columnDictionary.get(SpareColumnNameLiterals.PartNumber.toString());
		int rowIdx;
		int firstRowIdx = sheet.firstRow;
		for (Row rowData : sheet.getRows())
		{
			rowIdx = rowData.getIndex();
			if (rowIdx > firstRowIdx && COBieSpreadSheet.isRowPopulated(rowData, 1,100))
			{
				SpareType tmpSpare = spares.addNewSpare();
				if (idxName > -1)
					spareName = rowData.getCellAt(idxName).getData$();
				if (idxCreatedBy > -1)
					spareCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
				if (idxCreatedOn > -1)
					spareCreatedOnString = rowData.getCellAt(idxCreatedOn)
							.getData$();
				if (idxCategory > -1)
					spareCategory = rowData.getCellAt(idxCategory).getData$();
				if (idxTypeName > -1)
					spareTypeName = rowData.getCellAt(idxTypeName).getData$();
				if (idxSuppliers > -1)
					spareSuppliers = rowData.getCellAt(idxSuppliers).getData$();
				if (idxExtSystem > -1)
					spareExtSystem = rowData.getCellAt(idxExtSystem).getData$();
				if (idxExtObject > -1)
					spareExtObject = rowData.getCellAt(idxExtObject).getData$();
				if (idxExtIdentifier > -1)
					spareExtIdentifier = rowData.getCellAt(idxExtIdentifier)
							.getData$();
				if (idxDescription > -1)
					spareDescription = rowData.getCellAt(idxDescription)
							.getData$();
				if (idxSetNumber > -1)
					spareSetNumber = rowData.getCellAt(idxSetNumber).getData$();
				if(idxPartNumber > -1)
					sparePartNumber = rowData.getCellAt(idxPartNumber).getData$();
				spareCreatedOn = COBieUtility
						.calendarFromString(spareCreatedOnString);
				tmpSpare.setName(COBieUtility.getCOBieString(spareName));
				tmpSpare.setCreatedBy(COBieUtility
						.getCOBieString(spareCreatedBy));
				tmpSpare.setCreatedOn(spareCreatedOn);
				tmpSpare.setCategory(COBieUtility.getCOBieString(spareCategory));
				tmpSpare.setTypeName(COBieUtility.getCOBieString(spareTypeName));
				tmpSpare.setSuppliers(COBieUtility
						.getCOBieString(spareSuppliers));
				tmpSpare.setExtSystem(COBieUtility
						.getCOBieString(spareExtSystem));
				tmpSpare.setExtObject(COBieUtility
						.getCOBieString(spareExtObject));
				tmpSpare.setExtIdentifier(COBieUtility
						.getCOBieString(spareExtIdentifier));
				tmpSpare.setDescription(COBieUtility
						.getCOBieString(spareDescription));
				tmpSpare.setSetNumber(COBieUtility
						.getCOBieString(spareSetNumber));
				tmpSpare.setPartNumber(COBieUtility.getCOBieString(sparePartNumber));
			}
		}
	}

}
