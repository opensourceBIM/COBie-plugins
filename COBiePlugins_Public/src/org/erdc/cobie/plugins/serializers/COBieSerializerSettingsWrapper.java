package org.erdc.cobie.plugins.serializers;

import java.lang.reflect.InvocationTargetException;

import org.bimserver.models.store.DoubleType;
import org.bimserver.models.store.LongType;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ParameterDefinition;
import org.bimserver.models.store.PrimitiveDefinition;
import org.bimserver.models.store.PrimitiveEnum;
import org.bimserver.models.store.StoreFactory;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

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
		objectDefinition.getParameters().add(rowLimit);
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
		for(ParameterDefinition parameter:cobieSerializerSettingsDefinition.getParameters())
		{
			if(parameter.getName().equals(SETTINGS_PARAMETER_ROW_LIMIT_NAME))
			{
				
			}
		}
		return rowLimit;
	}
}
