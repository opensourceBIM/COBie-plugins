package com.prairiesky.transform.template;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.bimserver.cobie.shared.transform.Transformer;
import org.bimserver.cobie.shared.utility.NullInputCellPolicy;
import org.bimserver.cobie.shared.utility.WorkbookCopier;
import org.bimserver.cobie.shared.utility.WorkbookCopierOptions;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;
import com.prairiesky.transform.template.schema.productinstallation.TableCollection;

public class TableWorkbookTransform extends Transformer<TableCollection, Workbook>
{
	private final Workbook blankTemplate;
	public TableWorkbookTransform(TableCollection source, Workbook target, Workbook blankTemplate)
	{
		super(source, target);
		this.blankTemplate = blankTemplate;
	}

	private void populateTableWorkbook() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{	
		for(SpreadsheetTemplateTable table : getSource().getTables())
		{
			int rowCount = 0;
			ExcelReference annotation = table.getRowSupplier().get().getClass().getAnnotation(ExcelReference.class);
			if(annotation != null && annotation.spreadsheetName().length() > 0)
			{
				String spreadSheetName = annotation.spreadsheetName();
				Sheet sheet = getTarget().createSheet(annotation.spreadsheetName());
				if(getSource().getColumnGetters().containsKey(spreadSheetName))
				{
					Row headerRow = sheet.createRow(rowCount);
					rowCount++;
					for(ColumnAddress address : getSource().getColumnHeaders().get(spreadSheetName).keySet())
					{
						Cell cell = headerRow.createCell(address.ordinal());
						cell.setCellValue(getSource().getColumnHeaders().get(spreadSheetName).get(address));
					}
				}
				if(getSource().getColumnGetters().containsKey(spreadSheetName))
				{
					for(Object templateRow : table.getRows())
					{
						Row row = sheet.createRow(rowCount);
						rowCount++;
						for(ColumnAddress address : getSource().getColumnGetters().get(spreadSheetName).keySet())
						{
							Cell cell = row.createCell(address.ordinal());
							Object property = getSource().getColumnGetters().get(spreadSheetName).get(address).invoke(templateRow, null);
							if(property instanceof Property)
							{
								Object value = ((Property)property).get();
								if(value instanceof String)
								{
									cell.setCellValue((String)value);
								}
								else if (value instanceof Calendar)
								{
									cell.setCellValue((Calendar) value);
								}
								else if (value instanceof Double)
								{
									cell.setCellValue((Double) value);
								}
							}
							
						}
					}
				}
				
			}	
		}
		
	}

	public Workbook getBlankTemplate()
	{
		return blankTemplate;
	}


	@Override
	public Workbook transform()
	{
		Workbook returnValue = null;
		try
		{
			populateTableWorkbook();
			WorkbookCopierOptions options = new WorkbookCopierOptions();
			options.setEvaluatePickLists(false);
			options.setNullInputCellPolicy(NullInputCellPolicy.PRESERVE_OUTPUT_VALUE);
			WorkbookCopier copier = new WorkbookCopier(getTarget(), getBlankTemplate(), options);
			returnValue = copier.copyWorkbookValues();
		}
		catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e)
		{
			
		}
		return returnValue;
	}
}
