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
import org.bimserver.cobie.cobielite.TypeType;
import org.bimserver.cobie.utils.COBieUtility;


public class SpreadsheetToTypes {
	public static enum TypeColumnNameLiterals {
		Name, CreatedBy, CreatedOn, Category, Description, AssetType, Manufacturer, ModelNumber, WarrantyGuarantorParts, WarrantyDurationParts, WarrantyGuarantorLabor, WarrantyDurationLabor, WarrantyDurationUnit, ExtSystem, ExtObject, ExtIdentifier, ReplacementCost, ExpectedLife, DurationUnit, WarrantyDescription, NominalLength, NominalWidth, NominalHeight, ModelReference, Shape, Size, Color, Finish, Grade, Material, Constituents, Features, AccessibilityPerformance, CodePerformance, SustainabilityPerformance
	};

	public static ArrayList<String> TypeColumnNames = new ArrayList<String>(
			Arrays.asList("Name", "CreatedBy", "CreatedOn", "Category",
					"Description", "AssetType", "Manufacturer", "ModelNumber",
					"WarrantyGuarantorParts", "WarrantyDurationParts",
					"WarrantyGuarantorLabor", "WarrantyDurationLabor",
					"WarrantyDurationUnit", "ExtSystem", "ExtObject",
					"ExtIdentifier", "ReplacementCost", "ExpectedLife",
					"DurationUnit", "WarrantyDescription", "NominalLength",
					"NominalWidth", "NominalHeight", "ModelReference", "Shape",
					"Size", "Color", "Finish", "Grade", "Material",
					"Constituents", "Features", "AccessibilityPerformance",
					"CodePerformance", "SustainabilityPerformance"));

	public static ArrayList<String> getTypeColumns() {
		return TypeColumnNames;
	}

	public static void writeTypesToCOBie(COBIEType cType,Workbook workbook)
	{
		COBIEType.Types types = cType.addNewTypes();
		Worksheet sheet = workbook.getWorksheet(COBieUtility.CobieSheetName.Type.toString());
		Map<String,Integer> columnDictionary =
				COBieUtility.GetWorksheetColumnDictionary(sheet,getTypeColumns());
		String typeName="";
		String typeCreatedBy="";
		Calendar typeCreatedOn;
		String typeCreatedOnString="";
		String typeCategory="";
		String typeDescription="";
		String typeAssetType="";
		String typeManufacturer="";
		String typeModelNumber="";
		String typeWarrantyGuarantorParts="";
		String typeWarrantyDurationParts="";
		String typeWarrantyGuarantorLabor="";
		String typeWarrantyDurationLabor="";
		String typeWarrantyDurationUnit="";
		String typeExtSystem="";
		String typeExtObject="";
		String typeExtIdentifier="";
		String typeReplacementCost="";
		String typeExpectedLife="";
		String typeDurationUnit="";
		String typeWarrantyDescription="";
		String typeNominalLength="";
		String typeNominalWidth="";
		String typeNominalHeight="";
		String typeModelReference="";
		String typeShape="";
		String typeSize="";
		String typeColor="";
		String typeFinish="";
		String typeGrade="";
		String typeMaterial="";
		String typeConstituents="";
		String typeFeatures="";
		String typeAccessibilityPerformance="";
		String typeCodePerformance="";
		String typeSustainabilityPerformance="";int idxName;
		int idxCreatedBy;
		int idxCreatedOn;
		int idxCategory;
		int idxDescription;
		int idxAssetType;
		int idxManufacturer;
		int idxModelNumber;
		int idxWarrantyGuarantorParts;
		int idxWarrantyDurationParts;
		int idxWarrantyGuarantorLabor;
		int idxWarrantyDurationLabor;
		int idxWarrantyDurationUnit;
		int idxExtSystem;
		int idxExtObject;
		int idxExtIdentifier;
		int idxReplacementCost;
		int idxExpectedLife;
		int idxDurationUnit;
		int idxWarrantyDescription;
		int idxNominalLength;
		int idxNominalWidth;
		int idxNominalHeight;
		int idxModelReference;
		int idxShape;
		int idxSize;
		int idxColor;
		int idxFinish;
		int idxGrade;
		int idxMaterial;
		int idxConstituents;
		int idxFeatures;
		int idxAccessibilityPerformance;
		int idxCodePerformance;
		int idxSustainabilityPerformance;idxName=columnDictionary.get(TypeColumnNameLiterals.Name.toString());
		idxCreatedBy=columnDictionary.get(TypeColumnNameLiterals.CreatedBy.toString());
		idxCreatedOn=columnDictionary.get(TypeColumnNameLiterals.CreatedOn.toString());
		idxCategory=columnDictionary.get(TypeColumnNameLiterals.Category.toString());
		idxDescription=columnDictionary.get(TypeColumnNameLiterals.Description.toString());
		idxAssetType=columnDictionary.get(TypeColumnNameLiterals.AssetType.toString());
		idxManufacturer=columnDictionary.get(TypeColumnNameLiterals.Manufacturer.toString());
		idxModelNumber=columnDictionary.get(TypeColumnNameLiterals.ModelNumber.toString());
		idxWarrantyGuarantorParts=columnDictionary.get(TypeColumnNameLiterals.WarrantyGuarantorParts.toString());
		idxWarrantyDurationParts=columnDictionary.get(TypeColumnNameLiterals.WarrantyDurationParts.toString());
		idxWarrantyGuarantorLabor=columnDictionary.get(TypeColumnNameLiterals.WarrantyGuarantorLabor.toString());
		idxWarrantyDurationLabor=columnDictionary.get(TypeColumnNameLiterals.WarrantyDurationLabor.toString());
		idxWarrantyDurationUnit=columnDictionary.get(TypeColumnNameLiterals.WarrantyDurationUnit.toString());
		idxExtSystem=columnDictionary.get(TypeColumnNameLiterals.ExtSystem.toString());
		idxExtObject=columnDictionary.get(TypeColumnNameLiterals.ExtObject.toString());
		idxExtIdentifier=columnDictionary.get(TypeColumnNameLiterals.ExtIdentifier.toString());
		idxReplacementCost=columnDictionary.get(TypeColumnNameLiterals.ReplacementCost.toString());
		idxExpectedLife=columnDictionary.get(TypeColumnNameLiterals.ExpectedLife.toString());
		idxDurationUnit=columnDictionary.get(TypeColumnNameLiterals.DurationUnit.toString());
		idxWarrantyDescription=columnDictionary.get(TypeColumnNameLiterals.WarrantyDescription.toString());
		idxNominalLength=columnDictionary.get(TypeColumnNameLiterals.NominalLength.toString());
		idxNominalWidth=columnDictionary.get(TypeColumnNameLiterals.NominalWidth.toString());
		idxNominalHeight=columnDictionary.get(TypeColumnNameLiterals.NominalHeight.toString());
		idxModelReference=columnDictionary.get(TypeColumnNameLiterals.ModelReference.toString());
		idxShape=columnDictionary.get(TypeColumnNameLiterals.Shape.toString());
		idxSize=columnDictionary.get(TypeColumnNameLiterals.Size.toString());
		idxColor=columnDictionary.get(TypeColumnNameLiterals.Color.toString());
		idxFinish=columnDictionary.get(TypeColumnNameLiterals.Finish.toString());
		idxGrade=columnDictionary.get(TypeColumnNameLiterals.Grade.toString());
		idxMaterial=columnDictionary.get(TypeColumnNameLiterals.Material.toString());
		idxConstituents=columnDictionary.get(TypeColumnNameLiterals.Constituents.toString());
		idxFeatures=columnDictionary.get(TypeColumnNameLiterals.Features.toString());
		idxAccessibilityPerformance=columnDictionary.get(TypeColumnNameLiterals.AccessibilityPerformance.toString());
		idxCodePerformance=columnDictionary.get(TypeColumnNameLiterals.CodePerformance.toString());
		idxSustainabilityPerformance=columnDictionary.get(TypeColumnNameLiterals.SustainabilityPerformance.toString());int rowIdx;
		int firstRowIdx = Worksheet.firstRow;
		for (Row rowData : sheet.getRows())
		{
			rowIdx = rowData.getIndex();
			if (rowIdx>firstRowIdx)
			{
				TypeType tmpType=types.addNewType();
				if(idxName>-1)
					typeName=rowData.getCellAt(idxName).getData$();
				if(idxCreatedBy>-1)
					typeCreatedBy=rowData.getCellAt(idxCreatedBy).getData$();
				if(idxCreatedOn>-1)
					typeCreatedOnString=rowData.getCellAt(idxCreatedOn).getData$();
				if(idxCategory>-1)
					typeCategory=rowData.getCellAt(idxCategory).getData$();
				if(idxDescription>-1)
					typeDescription=rowData.getCellAt(idxDescription).getData$();
				if(idxAssetType>-1)
					typeAssetType=rowData.getCellAt(idxAssetType).getData$();
				if(idxManufacturer>-1)
					typeManufacturer=rowData.getCellAt(idxManufacturer).getData$();
				if(idxModelNumber>-1)
					typeModelNumber=rowData.getCellAt(idxModelNumber).getData$();
				if(idxWarrantyGuarantorParts>-1)
					typeWarrantyGuarantorParts=rowData.getCellAt(idxWarrantyGuarantorParts).getData$();
				if(idxWarrantyDurationParts>-1)
					typeWarrantyDurationParts=rowData.getCellAt(idxWarrantyDurationParts).getData$();
				if(idxWarrantyGuarantorLabor>-1)
					typeWarrantyGuarantorLabor=rowData.getCellAt(idxWarrantyGuarantorLabor).getData$();
				if(idxWarrantyDurationLabor>-1)
					typeWarrantyDurationLabor=rowData.getCellAt(idxWarrantyDurationLabor).getData$();
				if(idxWarrantyDurationUnit>-1)
					typeWarrantyDurationUnit=rowData.getCellAt(idxWarrantyDurationUnit).getData$();
				if(idxExtSystem>-1)
					typeExtSystem=rowData.getCellAt(idxExtSystem).getData$();
				if(idxExtObject>-1)
					typeExtObject=rowData.getCellAt(idxExtObject).getData$();
				if(idxExtIdentifier>-1)
					typeExtIdentifier=rowData.getCellAt(idxExtIdentifier).getData$();
				if(idxReplacementCost>-1)
					typeReplacementCost=rowData.getCellAt(idxReplacementCost).getData$();
				if(idxExpectedLife>-1)
					typeExpectedLife=rowData.getCellAt(idxExpectedLife).getData$();
				if(idxDurationUnit>-1)
					typeDurationUnit=rowData.getCellAt(idxDurationUnit).getData$();
				if(idxWarrantyDescription>-1)
					typeWarrantyDescription=rowData.getCellAt(idxWarrantyDescription).getData$();
				if(idxNominalLength>-1)
					typeNominalLength=rowData.getCellAt(idxNominalLength).getData$();
				if(idxNominalWidth>-1)
					typeNominalWidth=rowData.getCellAt(idxNominalWidth).getData$();
				if(idxNominalHeight>-1)
					typeNominalHeight=rowData.getCellAt(idxNominalHeight).getData$();
				if(idxModelReference>-1)
					typeModelReference=rowData.getCellAt(idxModelReference).getData$();
				if(idxShape>-1)
					typeShape=rowData.getCellAt(idxShape).getData$();
				if(idxSize>-1)
					typeSize=rowData.getCellAt(idxSize).getData$();
				if(idxColor>-1)
					typeColor=rowData.getCellAt(idxColor).getData$();
				if(idxFinish>-1)
					typeFinish=rowData.getCellAt(idxFinish).getData$();
				if(idxGrade>-1)
					typeGrade=rowData.getCellAt(idxGrade).getData$();
				if(idxMaterial>-1)
					typeMaterial=rowData.getCellAt(idxMaterial).getData$();
				if(idxConstituents>-1)
					typeConstituents=rowData.getCellAt(idxConstituents).getData$();
				if(idxFeatures>-1)
					typeFeatures=rowData.getCellAt(idxFeatures).getData$();
				if(idxAccessibilityPerformance>-1)
					typeAccessibilityPerformance=rowData.getCellAt(idxAccessibilityPerformance).getData$();
				if(idxCodePerformance>-1)
					typeCodePerformance=rowData.getCellAt(idxCodePerformance).getData$();
				if(idxSustainabilityPerformance>-1)
					typeSustainabilityPerformance=rowData.getCellAt(idxSustainabilityPerformance).getData$();
				typeCreatedOn=COBieUtility.calendarFromString(typeCreatedOnString);
				tmpType.setName(COBieUtility.getCOBieString(typeName));
				tmpType.setCreatedBy(COBieUtility.getCOBieString(typeCreatedBy));
				tmpType.setCreatedOn(typeCreatedOn);
				tmpType.setCategory(COBieUtility.getCOBieString(typeCategory));
				tmpType.setDescription(COBieUtility.getCOBieString(typeDescription));
				tmpType.setAssetType(COBieUtility.getCOBieString(typeAssetType));
				tmpType.setManufacturer(COBieUtility.getCOBieString(typeManufacturer));
				tmpType.setModelNumber(COBieUtility.getCOBieString(typeModelNumber));
				tmpType.setWarrantyGuarantorParts(COBieUtility.getCOBieString(typeWarrantyGuarantorParts));
				tmpType.setWarrantyDurationParts(COBieUtility.getCOBieString(typeWarrantyDurationParts));
				tmpType.setWarrantyGuarantorLabor(COBieUtility.getCOBieString(typeWarrantyGuarantorLabor));
				tmpType.setWarrantyDurationLabor(COBieUtility.getCOBieString(typeWarrantyDurationLabor));
				tmpType.setWarrantyDurationUnit(COBieUtility.getCOBieString(typeWarrantyDurationUnit));
				tmpType.setExtSystem(COBieUtility.getCOBieString(typeExtSystem));
				tmpType.setExtObject(COBieUtility.getCOBieString(typeExtObject));
				tmpType.setExtIdentifier(COBieUtility.getCOBieString(typeExtIdentifier));
				tmpType.setReplacementCost(COBieUtility.getCOBieString(typeReplacementCost));
				tmpType.setExpectedLife(COBieUtility.getCOBieString(typeExpectedLife));
				tmpType.setDurationUnit(COBieUtility.getCOBieString(typeDurationUnit));
				tmpType.setWarrantyDescription(COBieUtility.getCOBieString(typeWarrantyDescription));
				tmpType.setNominalLength(COBieUtility.getCOBieString(typeNominalLength));
				tmpType.setNominalWidth(COBieUtility.getCOBieString(typeNominalWidth));
				tmpType.setNominalHeight(COBieUtility.getCOBieString(typeNominalHeight));
				tmpType.setModelReference(COBieUtility.getCOBieString(typeModelReference));
				tmpType.setShape(COBieUtility.getCOBieString(typeShape));
				tmpType.setSize(COBieUtility.getCOBieString(typeSize));
				tmpType.setColor(COBieUtility.getCOBieString(typeColor));
				tmpType.setFinish(COBieUtility.getCOBieString(typeFinish));
				tmpType.setGrade(COBieUtility.getCOBieString(typeGrade));
				tmpType.setMaterial(COBieUtility.getCOBieString(typeMaterial));
				tmpType.setConstituents(COBieUtility.getCOBieString(typeConstituents));
				tmpType.setFeatures(COBieUtility.getCOBieString(typeFeatures));
				tmpType.setAccessibilityPerformance(COBieUtility.getCOBieString(typeAccessibilityPerformance));
				tmpType.setCodePerformance(COBieUtility.getCOBieString(typeCodePerformance));
				tmpType.setSustainabilityPerformance(COBieUtility.getCOBieString(typeSustainabilityPerformance));
	}}}

}
