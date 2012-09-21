package org.bimserver.shared.cobie;

import org.apache.xmlbeans.SchemaType;
import org.bimserver.cobie.cobielite.ConnectionType;
import org.bimserver.cobie.cobielite.impl.ConnectionTypeImpl;
import org.bimserver.cobie.utils.deserializer.COBieIfcModel;
import org.bimserver.cobie.utils.deserializer.ComponentDeserializer;
import org.bimserver.cobie.utils.deserializer.ConnectionDeserializer;
import org.bimserver.models.ifc2x3tc1.IfcElement;
import org.bimserver.models.ifc2x3tc1.IfcPort;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsPorts;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.plugins.serializers.IfcModelInterface;

public class ConnectionBetweenSensorAndControllerType 
{

	private IfcProduct sensor;
	private IfcProduct controller;
	private IfcPort sensorPort;
	private IfcPort controllerPort;
	private COBieIfcModel model;
	private ConnectionType connection;
	public ConnectionBetweenSensorAndControllerType(SchemaType arg0,ConnectionType connectionType,COBieIfcModel model)
	{
		connection = connectionType;
		this.model = model;
		initializeSensorAndController();
		initializeSensorAndControllerPorts();
	}
	
	private void initializeSensorAndControllerPorts()
	{
		if(controller!=null && sensor!=null)
		{
			IfcRelConnectsPorts connectsPorts =
					ConnectionDeserializer.relConnectsPortsBetweenTwoElements((IfcElement)controller, (IfcElement)sensor, model);
			IfcPort relatedPort = connectsPorts.getRelatedPort();
			IfcPort relatingPort = connectsPorts.getRelatingPort();
			if(portBelongsToObject(relatedPort,(IfcElement)controller))
				controllerPort = relatedPort;
			else if (portBelongsToObject(relatingPort,(IfcElement)controller))
				controllerPort = relatingPort;
			if(portBelongsToObject(relatedPort,(IfcElement)sensor))
				sensorPort = relatedPort;
			else if (portBelongsToObject(relatingPort,(IfcElement)sensor))
				sensorPort = relatedPort;	
		}
		
	}


	
	public static boolean portBelongsToObject(IfcPort relatedPort,IfcElement ifcElement)
	{
		return relatedPort.isSetContainedIn() && relatedPort.getContainedIn().getRelatedElement().getGlobalId().isSetWrappedValue() &&
				relatedPort.getContainedIn().getRelatedElement().getGlobalId().getWrappedValue().equals(ifcElement.getGlobalId().getWrappedValue());
	}

	private void initializeSensorAndController()
	{
		setSensor(null);
		setController(null);
		if(ConnectionDeserializer.isAComponentConnection(connection.getSheetName(), connection.getRowName1(), connection.getRowName2(), model));
		{
			if(ConnectionDeserializer.connectsControllerAndSensor(connection, model))
			{
				IfcProduct product1 = (IfcProduct) model.get(model.getComponentOid(connection.getRowName1()));
				IfcProduct product2 = (IfcProduct) model.get(model.getComponentOid(connection.getRowName2()));
				if(ComponentDeserializer.isProductAController(product1))
					setController(product1);
				else if(ComponentDeserializer.isProductAController(product2))
					setController(product2);
				if(ComponentDeserializer.isProductASensor(product1))
					setSensor(product1);
				else if(ComponentDeserializer.isProductASensor(product2))
					setSensor(product2);
			}
		}
	}

	public IfcProduct getSensor()
	{
		return sensor;
	}

	private void setSensor(IfcProduct sensor)
	{
		this.sensor = sensor;
	}

	public IfcProduct getController()
	{
		return controller;
	}

	private void setController(IfcProduct controller)
	{
		this.controller = controller;
	}

	public IfcPort getSensorPort()
	{
		return sensorPort;
	}

	private void setSensorPort(IfcPort sensorPort)
	{
		this.sensorPort = sensorPort;
	}

	public IfcPort getControllerPort()
	{
		return controllerPort;
	}

	private void setControllerPort(IfcPort controllerPort)
	{
		this.controllerPort = controllerPort;
	}

}
