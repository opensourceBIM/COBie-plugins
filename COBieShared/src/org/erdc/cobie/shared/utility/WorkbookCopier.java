package org.erdc.cobie.shared.utility;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.erdc.cobie.shared.Common;

public class WorkbookCopier
{

	private final Workbook input;
	private Workbook output;
	private WorkbookCopierOptions options;
	private Map<String, Row> styledOutputRows = new HashMap<String, Row>();
	
	public WorkbookCopier(Workbook input, Workbook output)
	{
		this(input, output, null);
	}
	
	public WorkbookCopier(Workbook input, Workbook output, WorkbookCopierOptions options)
	{
		options = (options == null) ? new WorkbookCopierOptions() : options;
		this.input = input;
		setOutput(output);
		setOptions(options);
	}
	public Workbook getInput()
	{
		return input;
	}
	public Workbook getOutput()
	{
		return output;
	}
	public void setOutput(Workbook output)
	{
		this.output = output;
	}
	
	
	public Workbook copyWorkbookValues()
	{
		if(getOptions().getNullInputCellPolicy() == NullInputCellPolicy.CLEAR_EXISTING_OUTPUT_VALUES)
			clearWorkbookValues(output);
		int inputSheetCount = input.getNumberOfSheets();
		for(int i=0; i < inputSheetCount; i++)
		{
			Sheet dataWorksheet = input.getSheetAt(i);
			if(isSheetRelevant(dataWorksheet))
			{
				Sheet templateWorksheet = output.getSheet(dataWorksheet.getSheetName());
				copyWorkSheetValues(dataWorksheet, templateWorksheet);
			}

		}
		return output;
	}

	private boolean isSheetRelevant(Sheet dataWorksheet)
	{
		boolean isRelevant = (dataWorksheet != null && 
				(!dataWorksheet.getSheetName().equalsIgnoreCase(Common.PICKLIST_SHEETNAME.toString()) || 
						(dataWorksheet.getSheetName().equalsIgnoreCase(Common.PICKLIST_SHEETNAME.toString()) && getOptions().isEvaluatePickLists())));
		return isRelevant;
	}
	private void clearWorkbookValues(Workbook workbook)
	{
		for(int i=0; i < workbook.getNumberOfSheets(); i++)
		{
			Sheet worksheet = workbook.getSheetAt(i);
			if(worksheet != null && isSheetRelevant(worksheet))
			{
				clearWorksheetValues(worksheet);
			}
		}
		
	}
	private void clearWorksheetValues(Sheet worksheet)
	{
		int firstRowNumber = worksheet.getFirstRowNum();
		if (!getOptions().isEvaluateHeaderRows())
			firstRowNumber++;
		for(int i = firstRowNumber; i <= worksheet.getLastRowNum(); i++)
		{
			Row row = worksheet.getRow(i);
			if(row != null)
				clearRowValues(row);
		}
		
	}

	private void copyWorkSheetValues(Sheet input, Sheet output)
	{
		
		int firstRowNumber = input.getFirstRowNum();
		if (!options.isEvaluateHeaderRows())
		{
			firstRowNumber++;
		}
		for(int i=firstRowNumber; i <= input.getLastRowNum(); i++)
		{
			Row dataRow = input.getRow(i);
			Row templateRow = null;
			if(output.getLastRowNum() < i)
				templateRow = newRow(output, i);
			else
			{
				templateRow = output.getRow(i);
				if(templateRow == null)
					templateRow = newRow(output, i);
				else if (!styledOutputRows.containsKey(output.getSheetName()))
				{
					styledOutputRows.put(output.getSheetName(), templateRow);
				}
			}
			copyRowValues(dataRow, templateRow);
		}
		
	}
	private Row newRow(Sheet output, int i)
	{
		Row result = null;
		result = output.createRow(i);
		if(styledOutputRows.containsKey(output.getSheetName()))
		{
			Row styledRow = styledOutputRows.get(output.getSheetName());
			result.setRowStyle(styledRow.getRowStyle());
		}
		return result;
	}

	private void copyRowValues(Row input, Row output)
	{
		clearRowValues(output);
		if(input != null && output != null)
		{
			for(int i=input.getFirstCellNum(); i < input.getLastCellNum(); i++)
			{
				Cell dataCell = input.getCell(i, options.getINPUT_WORKSHEET_MISSING_CELL_POLICY());
				Cell templateCell = null;
				templateCell = output.getCell(i, options.getOUTPUT_WORKSHEET_MISSING_CELL_POLICY());
				if(templateCell == null)
				{
					templateCell = newCell(output, i);
				}						
				copyCellValue(dataCell, templateCell);
			}				
		}
		
	}
	
	
	private void clearRowValues(Row row)
	{
		for(int i=row.getFirstCellNum(); i < row.getLastCellNum(); i++)
		{
			Cell cell = row.getCell(i, options.getOUTPUT_WORKSHEET_MISSING_CELL_POLICY());
			if(cell != null)
			{
				cell.setCellValue(Common.EMPTY_STRING.toString());
			}
		}
		
	}
	private Cell newCell(Row output, int i)
	{
		Cell result = null; 
		result = output.createCell(i);
		if(styledOutputRows.containsKey(output.getSheet().getSheetName()))
		{
			Row styledRow = styledOutputRows.get(output.getSheet().getSheetName());
			if(styledRow.getCell(i, options.getOUTPUT_WORKSHEET_MISSING_CELL_POLICY()) != null)
			{
				result.setCellStyle(styledRow.getCell(i, options.getOUTPUT_WORKSHEET_MISSING_CELL_POLICY()).getCellStyle());
			}
		}
		return result;
	}

	private void copyCellValue(Cell input, Cell output)
	{
		output.setCellType(input.getCellType());
		switch(input.getCellType())
		{
			case Cell.CELL_TYPE_BLANK:
			{
				break;
			}

			case Cell.CELL_TYPE_BOOLEAN:
			{
				output.setCellValue(input.getBooleanCellValue());
				break;
			}

			case Cell.CELL_TYPE_ERROR:
			{
				output.setCellErrorValue(input.getErrorCellValue());
				break;
			}

			case Cell.CELL_TYPE_FORMULA:
			{
				output.setCellFormula(input.getCellFormula());
				break;
			}

			case Cell.CELL_TYPE_NUMERIC:
			{
				output.setCellValue(input.getNumericCellValue());
				break;
			}

			case Cell.CELL_TYPE_STRING:
			{
				output.setCellValue(input.getStringCellValue());
				break;
			}

			default:
			{
				output.setCellValue(input.getStringCellValue());
				break;
			}
		}
	}
	
	public WorkbookCopierOptions getOptions()
	{
		return options;
	}
	public void setOptions(WorkbookCopierOptions options)
	{
		this.options = options;
	}	
}
