package org.bimserver.cobie.utils.spreadsheetml;
/******************************************************************************
 * Copyright (C) 2011  ERDC
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.ComponentType;
import org.bimserver.cobie.utils.COBieUtility;


public class SpreadSheetToComponents
{
	public static enum ComponentColumnNameLiterals
	{
		Name, CreatedBy, CreatedOn, TypeName, Space, Description, ExtSystem, ExtObject, ExtIdentifier, SerialNumber, InstallationDate, WarrantyStartDate, TagNumber, BarCode, AssetIdentifier
	};

	public static ArrayList<String> ComponentColumnNames = new ArrayList<String>(
			Arrays.asList("Name", "CreatedBy", "CreatedOn", "TypeName",
					"Space", "Description", "ExtSystem", "ExtObject",
					"ExtIdentifier", "SerialNumber", "InstallationDate",
					"WarrantyStartDate", "TagNumber", "BarCode",
					"AssetIdentifier"));

	public static ArrayList<String> getComponentColumns()
	{
		return ComponentColumnNames;
	}

	public static void writeComponentsToCOBie(COBIEType cType,Workbook workbook)
	{
		COBIEType.Components components = cType.addNewComponents();
		Worksheet sheet = workbook.getWorksheet(COBieUtility.CobieSheetName.Component.toString());
		Map<String,Integer> columnDictionary =
				COBieUtility.GetWorksheetColumnDictionary(sheet,getComponentColumns());
		String componentName="";
		String componentCreatedBy="";
		Calendar componentCreatedOn;
		String componentCreatedOnString="";
		String componentTypeName="";
		String componentSpace="";
		String componentDescription="";
		String componentExtSystem="";
		String componentExtObject="";
		String componentExtIdentifier="";
		String componentSerialNumber="";
		String componentInstallationDate="";
		String componentWarrantyStartDate="";
		String componentTagNumber="";
		String componentBarCode="";
		String componentAssetIdentifier="";int idxName;
		int idxCreatedBy;
		int idxCreatedOn;
		int idxTypeName;
		int idxSpace;
		int idxDescription;
		int idxExtSystem;
		int idxExtObject;
		int idxExtIdentifier;
		int idxSerialNumber;
		int idxInstallationDate;
		int idxWarrantyStartDate;
		int idxTagNumber;
		int idxBarCode;
		int idxAssetIdentifier;idxName=columnDictionary.get(ComponentColumnNameLiterals.Name.toString());
		idxCreatedBy=columnDictionary.get(ComponentColumnNameLiterals.CreatedBy.toString());
		idxCreatedOn=columnDictionary.get(ComponentColumnNameLiterals.CreatedOn.toString());
		idxTypeName=columnDictionary.get(ComponentColumnNameLiterals.TypeName.toString());
		idxSpace=columnDictionary.get(ComponentColumnNameLiterals.Space.toString());
		idxDescription=columnDictionary.get(ComponentColumnNameLiterals.Description.toString());
		idxExtSystem=columnDictionary.get(ComponentColumnNameLiterals.ExtSystem.toString());
		idxExtObject=columnDictionary.get(ComponentColumnNameLiterals.ExtObject.toString());
		idxExtIdentifier=columnDictionary.get(ComponentColumnNameLiterals.ExtIdentifier.toString());
		idxSerialNumber=columnDictionary.get(ComponentColumnNameLiterals.SerialNumber.toString());
		idxInstallationDate=columnDictionary.get(ComponentColumnNameLiterals.InstallationDate.toString());
		idxWarrantyStartDate=columnDictionary.get(ComponentColumnNameLiterals.WarrantyStartDate.toString());
		idxTagNumber=columnDictionary.get(ComponentColumnNameLiterals.TagNumber.toString());
		idxBarCode=columnDictionary.get(ComponentColumnNameLiterals.BarCode.toString());
		idxAssetIdentifier=columnDictionary.get(ComponentColumnNameLiterals.AssetIdentifier.toString());int rowIdx;
		int firstRowIdx = Worksheet.firstRow;
		for (Row rowData : sheet.getRows())
		{
			rowIdx = rowData.getIndex();
			if (rowIdx>firstRowIdx && COBieSpreadSheet.isRowPopulated(rowData, 1,100))
			{
				ComponentType tmpComponent=components.addNewComponent();
				if(idxName>-1)
					componentName=rowData.getCellAt(idxName).getData$();
				if(idxCreatedBy>-1)
					componentCreatedBy=rowData.getCellAt(idxCreatedBy).getData$();
				if(idxCreatedOn>-1)
					componentCreatedOnString=rowData.getCellAt(idxCreatedOn).getData$();
				if(idxTypeName>-1)
					componentTypeName=rowData.getCellAt(idxTypeName).getData$();
				if(idxSpace>-1)
					componentSpace=rowData.getCellAt(idxSpace).getData$();
				if(idxDescription>-1)
					componentDescription=rowData.getCellAt(idxDescription).getData$();
				if(idxExtSystem>-1)
					componentExtSystem=rowData.getCellAt(idxExtSystem).getData$();
				if(idxExtObject>-1)
					componentExtObject=rowData.getCellAt(idxExtObject).getData$();
				if(idxExtIdentifier>-1)
					componentExtIdentifier=rowData.getCellAt(idxExtIdentifier).getData$();
				if(idxSerialNumber>-1)
					componentSerialNumber=rowData.getCellAt(idxSerialNumber).getData$();
				if(idxInstallationDate>-1)
					componentInstallationDate=rowData.getCellAt(idxInstallationDate).getData$();
				if(idxWarrantyStartDate>-1)
					componentWarrantyStartDate=rowData.getCellAt(idxWarrantyStartDate).getData$();
				if(idxTagNumber>-1)
					componentTagNumber=rowData.getCellAt(idxTagNumber).getData$();
				if(idxBarCode>-1)
					componentBarCode=rowData.getCellAt(idxBarCode).getData$();
				if(idxAssetIdentifier>-1)
					componentAssetIdentifier=rowData.getCellAt(idxAssetIdentifier).getData$();
				componentCreatedOn=COBieUtility.calendarFromString(componentCreatedOnString);
				tmpComponent.setName(COBieUtility.getCOBieString(componentName));
				tmpComponent.setCreatedBy(COBieUtility.getCOBieString(componentCreatedBy));
				tmpComponent.setCreatedOn(componentCreatedOn);
				tmpComponent.setTypeName(COBieUtility.getCOBieString(componentTypeName));
				tmpComponent.setSpace(COBieUtility.getCOBieString(componentSpace));
				tmpComponent.setDescription(COBieUtility.getCOBieString(componentDescription));
				tmpComponent.setExtSystem(COBieUtility.getCOBieString(componentExtSystem));
				tmpComponent.setExtObject(COBieUtility.getCOBieString(componentExtObject));
				tmpComponent.setExtIdentifier(COBieUtility.getCOBieString(componentExtIdentifier));
				tmpComponent.setSerialNumber(COBieUtility.getCOBieString(componentSerialNumber));
				tmpComponent.setInstallationDate(COBieUtility.getCOBieString(componentInstallationDate));
				tmpComponent.setWarrantyStartDate(COBieUtility.getCOBieString(componentWarrantyStartDate));
				tmpComponent.setTagNumber(COBieUtility.getCOBieString(componentTagNumber));
				tmpComponent.setBarCode(COBieUtility.getCOBieString(componentBarCode));
				tmpComponent.setAssetIdentifier(COBieUtility.getCOBieString(componentAssetIdentifier));
			}}}
}
