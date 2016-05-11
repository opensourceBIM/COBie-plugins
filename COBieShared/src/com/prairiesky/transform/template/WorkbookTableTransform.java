package com.prairiesky.transform.template;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.bimserver.cobie.shared.transform.Transformer;

import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateRow;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;
import com.prairiesky.transform.template.schema.productinstallation.TableCollection;

public class WorkbookTableTransform extends Transformer<Workbook, TableCollection>
{

	public WorkbookTableTransform(Workbook source, TableCollection target)
	{
		super(source, target);
	}

	@Override
	public TableCollection transform()
	{
		try
		{
			populateTableWorkbook();
		}
		catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e)
		{

		}
		return getTarget();
	}
	
	private void populateTableWorkbook() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{	
		for(SpreadsheetTemplateTable table : getTarget().getTables())
		{
			int rowCount = 0;
			ExcelReference annotation = table.getRowSupplier().get().getClass().getAnnotation(ExcelReference.class);
			if(annotation != null && annotation.spreadsheetName().length() > 0)
			{
				String spreadSheetName = annotation.spreadsheetName();
				Sheet sheet = getSource().getSheet(annotation.spreadsheetName());
				if(sheet != null && getTarget().getColumnGetters().containsKey(spreadSheetName))
				{
					
					for(Row sheetRow : sheet)
					{
						if(rowCount > 0 && !isEmptyRow(sheetRow))
						{
							SpreadsheetTemplateRow tableRow = table.newRow();
						    ((SpreadsheetTemplateRow)tableRow).populateFromXLSXRow(sheetRow);
						    table.getRows().add(tableRow);
						}
						rowCount++;
					}
				}
			}	
		}
	}

	  boolean isEmptyRow(Row row){
		     boolean isEmptyRow = true;
		         for(int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++){
		            Cell cell = row.getCell(cellNum);
		            if(cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK && StringUtils.isNotBlank(cell.toString())){
		            isEmptyRow = false;
		            }    
		         }
		     return isEmptyRow;
		   }

}
