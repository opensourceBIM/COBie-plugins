package org.bimserver.cobie.utils.deserializer.modelhandlers;


import org.bimserver.cobie.utils.deserializer.COBieIfcModel;
import org.bimserver.plugins.serializers.OidProvider;

public class IfcCommonHandler
{
	private IfcGuidHandler guidHandler;
	private GeometryHandler geometryHandler;
	private OwnerHistoryHandler ownerHistoryHandler;
	private PropertySetHandler propertySetHandler;
	private ClassificationHandler classificationHandler;
	private OidProvider oidHandler;
	private COBieIfcModel model;
	private IfcUnitHandler unitHandler;
	public IfcCommonHandler(COBieIfcModel cobieIfcmodel, OidProvider oidProvider)
	{
		this.oidHandler = oidProvider;
		this.model = cobieIfcmodel;
		ownerHistoryHandler = new OwnerHistoryHandler(model,oidProvider);
		guidHandler = new IfcGuidHandler(model,oidProvider);
		classificationHandler = new ClassificationHandler(model, guidHandler, oidProvider,ownerHistoryHandler);
		propertySetHandler = new PropertySetHandler(model,oidProvider, guidHandler, ownerHistoryHandler);
		setUnitHandler(new IfcUnitHandler(oidProvider,cobieIfcmodel, guidHandler));
		setGeometryHandler(new GeometryHandler(oidProvider,cobieIfcmodel,guidHandler));
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

	public IfcUnitHandler getUnitHandler()
	{
		return unitHandler;
	}

	public void setUnitHandler(IfcUnitHandler unitHandler)
	{
		this.unitHandler = unitHandler;
	}

	public GeometryHandler getGeometryHandler()
	{
		return geometryHandler;
	}

	private void setGeometryHandler(GeometryHandler geometryHandler)
	{
		this.geometryHandler = geometryHandler;
	}

	
}
