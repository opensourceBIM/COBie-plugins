package com.prairiesky.transform.template.schema.productinstallation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bimserver.cobie.shared.transform.Transformer;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class TableCollection
{

	protected final List<SpreadsheetTemplateTable> tables;
	protected HashMap<String,HashMap<ColumnAddress, Method>> columnGetters = new HashMap<>();
	protected HashMap<String,HashMap<ColumnAddress, String>> columnHeaders = new HashMap<>();

	public TableCollection(List<SpreadsheetTemplateTable> tables)
	{
		this.tables = tables;
		initColumnGetters();
	}
	
	public TableCollection(SpreadsheetTemplateTable table)
	{
		this(Arrays.asList(table));
	}

	protected void initColumnGetters()
	{
		for(SpreadsheetTemplateTable table : tables)
		{
			String spreadSheetName = "";
			HashMap<ColumnAddress, Method> getters = new HashMap<>();
			HashMap<ColumnAddress, String> headers = new HashMap<>();
			ExcelReference annotation = table.getRowSupplier().get().getClass().getAnnotation(ExcelReference.class);
			if(annotation != null && annotation.spreadsheetName().length() > 0)
			{
				spreadSheetName = annotation.spreadsheetName();
			}
			for(Method method : table.getRowSupplier().get().getClass().getMethods())
			{
				if(method.getReturnType().equals(Property.class))
				{
					ExcelReference methodAnnotation = method.getAnnotation(ExcelReference.class);
					if(methodAnnotation != null && methodAnnotation.columnAddress() != null)
					{
						getters.put(methodAnnotation.columnAddress(), method);
						headers.put(methodAnnotation.columnAddress(), methodAnnotation.columnName());
					}
				}
				
			}
			columnGetters.put(spreadSheetName, getters);
			columnHeaders.put(spreadSheetName, headers);
		}
		
	}

	public List<SpreadsheetTemplateTable> getTables()
	{
		return tables;
	}

	public HashMap<String, HashMap<ColumnAddress, Method>> getColumnGetters()
	{
		return columnGetters;
	}

	public HashMap<String, HashMap<ColumnAddress, String>> getColumnHeaders()
	{
		return columnHeaders;
	}
	

}