package com.prairiesky.transform.template.schema;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.bimserver.cobie.shared.utility.COBieStringHandler;
import org.bimserver.cobie.shared.utility.COBieStringHandlerSettings;
import org.bimserver.cobie.shared.utility.COBieStringHandlerSettings.EmptyStringMode;
import org.bimserver.cobie.shared.utility.COBieStringHandlerSettings.InvalidDateTimeStringMode;
import org.bimserver.cobie.shared.utility.COBieStringHandlerSettings.SpecialCharacterMode;
import org.bimserver.cobie.shared.utility.COBieStringHandlerSettings.TrailingDelimiterMode;
import org.bimserver.cobie.shared.utility.COBieUtility;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;

public abstract class ConstructionTemplateRow 
{

	protected final Map<ColumnAddress, String> columnNames = new HashMap<>();
	protected final Map<ColumnAddress, Method> columnProperties = new HashMap<>();

	public ConstructionTemplateRow()
	{
		initializePropertyMaps();
	}
	
	private void initializePropertyMaps()
	{
		for(Method method : getClass().getMethods())
		{
			if(method.getReturnType().equals(Property.class))
			{
				ExcelReference methodAnnotation = method.getAnnotation(ExcelReference.class);
				if(methodAnnotation != null && methodAnnotation.columnAddress() != null)
				{
					getColumnProperties().put(methodAnnotation.columnAddress(), method);
					getColumnNames().put(methodAnnotation.columnAddress(), methodAnnotation.columnName());
				}
			}
			
		}	
	}
	public Map<ColumnAddress, String> getColumnNames()
	{
		return columnNames;
	}

	public Map<ColumnAddress, Method> getColumnProperties()
	{
		return columnProperties;
	}
	
	public void populateFromXLSXRow(Row row)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException
	{
		for(ColumnAddress columnAddress : ColumnAddress.values())
		{
			if(columnProperties.containsKey(columnAddress))
			{
				Method propertyGetter = columnProperties.get(columnAddress);
				Property<?> property = (Property) propertyGetter.invoke(this, null);
				Cell cell = row.getCell(columnAddress.ordinal());
				if(cell != null)
				{
					setPropertyFromCell(property, cell);
				}	
			}
			else
			{
				break;
			}
		}
	}

	private void setPropertyFromCell(Property<?> property, Cell cell)
	{
		Class valueType = property.getValueType();
		Object cellValue = getCellValue(cell);
		//boolean -> boolean or string
		//number -> double, int, long or string
		//string -> any
		if(valueType.equals(String.class) && cellValue != null)
		{
			if(cellValue instanceof String)
			{
				((Property<String>)property).set((String) cellValue);
			}
			else
			{
				((Property<String>)property).set(cellValue.toString());
			}
		}
		else if(valueType.equals(Double.class))
		{
			if(cellValue instanceof Double)
			{
				((Property<Double>)property).set((Double)cellValue);
			}
			else if (cellValue instanceof String)
			{
				try
				{
					((Property<Double>)property).set( Double.parseDouble(((String)cellValue)));
				}
				catch(Exception e)
				{
					
				}
				
			}
	
		}
		else if(valueType.equals(Integer.class))
		{
			if(cellValue instanceof Double)
			{
				((Property<Integer>)property).set((int)cellValue);
			}
			else if (cellValue instanceof String)
			{
				try
				{
					((Property<Integer>)property).set( Integer.parseInt(((String)cellValue)));
				}
				catch(Exception e)
				{
					
				}
				
			}
		}
		else if (valueType.equals(Long.class))
		{
			if(cellValue instanceof Double)
			{
				((Property<Long>)property).set((long)cellValue);
			}
			else if (cellValue instanceof String)
			{
				try
				{
					((Property<Long>)property).set( Long.parseLong(((String)cellValue)));
				}
				catch(Exception e)
				{
					
				}
				
			}
		}
		else if (valueType.equals(Boolean.class))
		{
			if(cellValue instanceof Boolean)
			{
				((Property<Boolean>)property).set((boolean)cellValue);
			}
			else if (cellValue instanceof String)
			{
				try
				{
					((Property<Boolean>)property).set( Boolean.parseBoolean(((String)cellValue)));
				}
				catch(Exception e)
				{
					
				}
				
			}	
		}
		else if (valueType.equals(Calendar.class))
		{
			if(cellValue instanceof Date)
			{
				Calendar calendar = Calendar.getInstance();
				calendar.setTime((Date)cellValue);
				((Property<Calendar>)property).set(calendar);
			}
			else if (cellValue instanceof String)
			{
				try
				{
					
					COBieStringHandlerSettings settings =
							new COBieStringHandlerSettings(EmptyStringMode.REPLACE_WITH_NA, SpecialCharacterMode.REMOVE, TrailingDelimiterMode.REMOVE, InvalidDateTimeStringMode.SET_TO_NULL);
					COBieStringHandler handler = new COBieStringHandler(settings);
					((Property<Calendar>)property).set( handler.calendarFromString((String)cellValue));
				}
				catch(Exception e)
				{
					
				}
				
			}
		}
	}

	private Object getCellValue(Cell cell)
	{
		Object value = null;
		switch(cell.getCellType())
		{
			case Cell.CELL_TYPE_BOOLEAN:
				value = cell.getBooleanCellValue();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				try
				{
					value = cell.getDateCellValue();
				}
				catch(NumberFormatException e)
				{
					value = cell.getNumericCellValue();
				}
				break;
			case Cell.CELL_TYPE_STRING:
				value = cell.getStringCellValue();
		}
		return value;
	}

}
