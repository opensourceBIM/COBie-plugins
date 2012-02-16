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

import org.bimserver.cobie.cobielite.AssemblyType;
import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.utils.COBieUtility;


public class SpreadsheetToAssemblies 
{
	private static final ArrayList<String> AssemblyColumnNames =
			new ArrayList<String>(Arrays.asList("Name",
					"CreatedBy",
					"CreatedOn",
					"SheetName",
					"ParentName",
					"ChildNames",
					"AssemblyType",
					"ExtSystem",
					"ExtObject",
					"ExtIdentifier",
					"Description"));
	private static enum AssemblyColumnNameLiterals
	{	Name,
		CreatedBy,
		CreatedOn,
		SheetName,
		ParentName,
		ChildNames,
		AssemblyType,
		ExtSystem,
		ExtObject,
		ExtIdentifier,
		Description};
	private static ArrayList<String> getAssemblyColumnNames()
	{
		return AssemblyColumnNames;
	}
	public static void writeAssembliesToCOBie(COBIEType cobie,Workbook workbook)
	{
		COBIEType.Assemblies assemblies =  cobie.addNewAssemblies();   	      	    
	   	Worksheet sheet = workbook.getWorksheet(COBieUtility.CobieSheetName.Assembly.toString());
	   	Map<String,Integer> columnDictionary =
	   			COBieUtility.GetWorksheetColumnDictionary(sheet, getAssemblyColumnNames());
	   	String assemblyName="";
	   	String assemblyCreatedBy="";
	   	String assemblyCreatedOnString="";
	   	Calendar assemblyCreatedOn;
	   	String assemblySheetName="";
	   	String assemblyParentName="";
	   	String assemblyChildNames="";
	   	String assemblyAssemblyType="";
	   	String assemblyExtSystem="";
	   	String assemblyExtObject="";
	   	String assemblyExtIdentifier="";
	   	String assemblyDescription="";
	   	
	   	int idxName;
	   	int idxCreatedBy;
	   	int idxCreatedOn;
	   	int idxSheetName;
	   	int idxParentName;
	   	int idxChildNames;
	   	int idxAssemblyType;
	   	int idxExtSystem;
	   	int idxExtObject;
	   	int idxExtIdentifier;
	   	int idxDescription;
	   	idxName=columnDictionary.get(AssemblyColumnNameLiterals.Name.toString());
	   	idxCreatedBy=columnDictionary.get(AssemblyColumnNameLiterals.CreatedBy.toString());
	   	idxCreatedOn=columnDictionary.get(AssemblyColumnNameLiterals.CreatedOn.toString());
	   	idxSheetName=columnDictionary.get(AssemblyColumnNameLiterals.SheetName.toString());
	   	idxParentName=columnDictionary.get(AssemblyColumnNameLiterals.ParentName.toString());
	   	idxChildNames=columnDictionary.get(AssemblyColumnNameLiterals.ChildNames.toString());
	   	idxAssemblyType=columnDictionary.get(AssemblyColumnNameLiterals.AssemblyType.toString());
	   	idxExtSystem=columnDictionary.get(AssemblyColumnNameLiterals.ExtSystem.toString());
	   	idxExtObject=columnDictionary.get(AssemblyColumnNameLiterals.ExtObject.toString());
	   	idxExtIdentifier=columnDictionary.get(AssemblyColumnNameLiterals.ExtIdentifier.toString());
	   	idxDescription=columnDictionary.get(AssemblyColumnNameLiterals.Description.toString());
	    
	   	int rowIdx;
	    int firstRowIdx = Worksheet.firstRow;
	   	for (Row rowData : sheet.getRows())
	   	{
	   		rowIdx = rowData.getIndex();
	   		if (rowIdx>firstRowIdx)
	   		{
				AssemblyType tmpAssembly = assemblies.addNewAssembly();
				if (idxName > -1)
					assemblyName = rowData.getCellAt(idxName).getData$();
				if (idxCreatedBy > -1)
					assemblyCreatedBy = rowData.getCellAt(idxCreatedBy)
							.getData$();
				if (idxCreatedOn > -1)
					assemblyCreatedOnString = rowData.getCellAt(idxCreatedOn)
							.getData$();
				if (idxSheetName > -1)
					assemblySheetName = rowData.getCellAt(idxSheetName)
							.getData$();
				if (idxParentName > -1)
					assemblyParentName = rowData.getCellAt(idxParentName)
							.getData$();
				if (idxChildNames > -1)
					assemblyChildNames = rowData.getCellAt(idxChildNames)
							.getData$();
				if (idxAssemblyType > -1)
					assemblyAssemblyType = rowData.getCellAt(idxAssemblyType)
							.getData$();
				if (idxExtSystem > -1)
					assemblyExtSystem = rowData.getCellAt(idxExtSystem)
							.getData$();
				if (idxExtObject > -1)
					assemblyExtObject = rowData.getCellAt(idxExtObject)
							.getData$();
				if (idxExtIdentifier > -1)
					assemblyExtIdentifier = rowData.getCellAt(idxExtIdentifier)
							.getData$();
				if (idxDescription > -1)
					assemblyDescription = rowData.getCellAt(idxDescription)
							.getData$();
				assemblyCreatedOn = COBieUtility.calendarFromString(assemblyCreatedOnString);
				
				tmpAssembly.setName(COBieUtility.getCOBieString(assemblyName));
				tmpAssembly.setCreatedBy(COBieUtility.getCOBieString(assemblyCreatedBy));
				tmpAssembly.setCreatedOn(assemblyCreatedOn);
				tmpAssembly.setSheetName(COBieUtility.getCOBieString(assemblySheetName));
				tmpAssembly.setParentName(COBieUtility.getCOBieString(assemblyParentName));
				tmpAssembly.setChildNames(COBieUtility.getCOBieString(assemblyChildNames));
				tmpAssembly.setAssemblyType(COBieUtility.getCOBieString(assemblyAssemblyType));
				tmpAssembly.setExtSystem(COBieUtility.getCOBieString(assemblyExtSystem));
				tmpAssembly.setExtObject(COBieUtility.getCOBieString(assemblyExtObject));
				tmpAssembly.setExtIdentifier(COBieUtility.getCOBieString(assemblyExtIdentifier));
				tmpAssembly.setDescription(COBieUtility.getCOBieString(assemblyDescription));
	   		}
	   	}
	}
}
