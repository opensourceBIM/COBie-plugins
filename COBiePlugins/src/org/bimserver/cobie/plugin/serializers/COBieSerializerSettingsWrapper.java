package org.bimserver.cobie.plugin.serializers;

import org.bimserver.models.store.LongType;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ParameterDefinition;
import org.bimserver.models.store.PrimitiveDefinition;
import org.bimserver.models.store.PrimitiveEnum;
import org.bimserver.models.store.StoreFactory;

public class COBieSerializerSettingsWrapper 
{
	public static final String SETTINGS_PARAMETER_ROW_LIMIT_NAME = "Spreadsheet Row Count Limit";
	private static final long DEFAULT_ROW_LIMIT_VALUE = 64000;
	private ObjectDefinition cobieSerializerSettingsDefinition;
	public COBieSerializerSettingsWrapper()
	{
		initializeSettingsObjectDefinition();
	}
	
	private void initializeSettingsObjectDefinition()
	{
		ObjectDefinition objectDefinition = StoreFactory.eINSTANCE.createObjectDefinition();
		ParameterDefinition rowLimit = StoreFactory.eINSTANCE.createParameterDefinition();
		rowLimit.setName(SETTINGS_PARAMETER_ROW_LIMIT_NAME);
		rowLimit.setRequired(true);
		LongType defaultValue = StoreFactory.eINSTANCE.createLongType();
		defaultValue.setValue(DEFAULT_ROW_LIMIT_VALUE);
		rowLimit.setDefaultValue(defaultValue);
		PrimitiveDefinition longDefinition = StoreFactory.eINSTANCE.createPrimitiveDefinition();
		longDefinition.setType(PrimitiveEnum.LONG);
		rowLimit.setType(longDefinition);
		//objectDefinition.getParameters().add(rowLimit);
		setCobieSerializerSettingsDefinition(objectDefinition);
	}
	
	public ObjectDefinition getCobieSerializerSettingsDefinition()
	{
		return cobieSerializerSettingsDefinition;
	}
	public void setCobieSerializerSettingsDefinition(
			ObjectDefinition cobieSerializerSettingsDefinition)
	{
		this.cobieSerializerSettingsDefinition = cobieSerializerSettingsDefinition;
	}
	
	public long getRowLimitParameterValue()
	{
		long rowLimit=0;
//		for(ParameterDefinition parameter:cobieSerializerSettingsDefinition.getParameters())
//		{
//			if(parameter.getName().equals(SETTINGS_PARAMETER_ROW_LIMIT_NAME))
//			{
//				
//			}
//		}
		return rowLimit;
	}
}
