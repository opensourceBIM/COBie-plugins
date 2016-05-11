package com.prairiesky.transform.template.schema.productinstallation;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.COBieUtility.CobieSheetName;
import org.nibs.cobie.tab.AttributeType;
import org.nibs.cobie.tab.ComponentType;
import org.nibs.cobie.tab.TypeType;

import com.prairiesky.transform.template.meta.AttributeName;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateRow;

public abstract class ConstructionTemplateProductRow extends SpreadsheetTemplateRow 
{
	public abstract void populateFromCOBie(ComponentType component, TypeType type, IndexedCOBie cobie);
	
	private String stringBuffer;
	
	private String getStringBuffer()
	{
		return stringBuffer;
	}
	private void setStringBuffer(String string)
	{
		this.stringBuffer = string;
	}
	protected void populateStringValueFromComponentAttribute(AttributeName attributeName, 
			String componentName, IndexedCOBie indexedCobie, Consumer<String> consumer)
	{
		
		List<AttributeType> componentAttributes = indexedCobie.getDescriptiveElementIndex().getDescriptiveDataBySheetNameRowName(CobieSheetName.Component, componentName).getAttributes();
		Optional<AttributeType> attribute = componentAttributes.stream().filter(a -> a.getName().equalsIgnoreCase(attributeName.toString())).findFirst();
		if(attribute.isPresent() && !COBieUtility.isNA(attribute.get().getValue()))
		{
			consumer.accept(attribute.get().getValue());
		}
	}
	
	protected void populateCalendarValueFromComponentAttribute(AttributeName attributeName, String componentName,
			IndexedCOBie indexedCobie, Consumer<Calendar> consumer)
	{
		
		populateStringValueFromComponentAttribute(attributeName, componentName, indexedCobie, s -> setStringBuffer(s));
		if(Optional.ofNullable(getStringBuffer()).isPresent())
		{
			try
			{
				Calendar calendar = COBieUtility.calendarFromStringWithException(getStringBuffer());
				consumer.accept(calendar);
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
	

}
