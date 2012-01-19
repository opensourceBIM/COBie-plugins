package org.bimserver.cobie.utils.deserializer;

import org.bimserver.cobie.plugins.COBieIfcModel;
import org.bimserver.plugins.serializers.OidProvider;

public class IfcCommonHandler
{
	private IfcGuidHandler guidHandler;
	private OwnerHistoryHandler ownerHistoryHandler;
	private PropertySetHandler propertySetHandler;
	private ClassificationHandler classificationHandler;
	private OidProvider oidHandler;
	private COBieIfcModel model;
	
	public IfcCommonHandler(COBieIfcModel cobieIfcmodel, OidProvider oidProvider)
	{
		this.oidHandler = oidProvider;
		this.model = cobieIfcmodel;
		ownerHistoryHandler = new OwnerHistoryHandler(model,oidProvider);
		guidHandler = new IfcGuidHandler(model,oidProvider);
		classificationHandler = new ClassificationHandler(model, guidHandler, oidProvider);
		propertySetHandler = new PropertySetHandler(model,oidProvider, guidHandler, ownerHistoryHandler);
		
	}
	
	public IfcGuidHandler getGuidHandler()
	{
		return guidHandler;
	}
	
	public OwnerHistoryHandler getOwnerHistoryHandler()
	{
		return ownerHistoryHandler;
	}
	
	public PropertySetHandler getPropertySetHandler()
	{
		return propertySetHandler;
	}
	
	public ClassificationHandler getClassificationHandler()
	{
		return classificationHandler;
	}
	
	public OidProvider getOidProvider()
	{
		return oidHandler;
	}
	
}
