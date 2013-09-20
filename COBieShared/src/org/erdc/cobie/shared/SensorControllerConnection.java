package org.erdc.cobie.shared;

import org.apache.xmlbeans.SchemaType;
import org.bimserver.models.ifc2x3tc1.IfcElement;
import org.bimserver.models.ifc2x3tc1.IfcPort;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsPorts;
import org.erdc.cobie.shared.deserializer.sheetxmldata.COBieIfcModel;
import org.erdc.cobie.shared.deserializer.sheetxmldata.ComponentDeserializer;
import org.erdc.cobie.shared.deserializer.sheetxmldata.ConnectionDeserializer;
import org.erdc.cobie.sheetxmldata.ConnectionType;

public class SensorControllerConnection
{

    public static boolean portBelongsToObject(IfcPort relatedPort, IfcElement ifcElement)
    {
        return relatedPort.isSetContainedIn()
                && relatedPort.getContainedIn().getGlobalId() != null
                && relatedPort.getContainedIn().getRelatedElement().getGlobalId()
                        .equals(ifcElement.getGlobalId());
    }

    private IfcProduct sensor;
    private IfcProduct controller;
    private IfcPort sensorPort;
    private IfcPort controllerPort;
    private COBieIfcModel model;
    private ConnectionType connection;

    public SensorControllerConnection(SchemaType arg0, ConnectionType connectionType, COBieIfcModel model)
    {
        connection = connectionType;
        this.model = model;
        initializeSensorAndController();
        initializeSensorAndControllerPorts();
    }

    public IfcProduct getController()
    {
        return controller;
    }

    public IfcPort getControllerPort()
    {
        return controllerPort;
    }

    public IfcProduct getSensor()
    {
        return sensor;
    }

    public IfcPort getSensorPort()
    {
        return sensorPort;
    }

    private void initializeSensorAndController()
    {
        setSensor(null);
        setController(null);
        if (ConnectionDeserializer.isAComponentConnection(connection.getSheetName(), connection.getRowName1(), connection.getRowName2(), model))
        {
            ;
        }
        {
            if (ConnectionDeserializer.connectsControllerAndSensor(connection, model))
            {
                IfcProduct product1 = (IfcProduct)model.get(model.getComponentOid(connection.getRowName1()));
                IfcProduct product2 = (IfcProduct)model.get(model.getComponentOid(connection.getRowName2()));
                if (ComponentDeserializer.isProductAController(product1))
                {
                    setController(product1);
                } else if (ComponentDeserializer.isProductAController(product2))
                {
                    setController(product2);
                }
                if (ComponentDeserializer.isProductASensor(product1))
                {
                    setSensor(product1);
                } else if (ComponentDeserializer.isProductASensor(product2))
                {
                    setSensor(product2);
                }
            }
        }
    }

    private void initializeSensorAndControllerPorts()
    {
        if ((controller != null) && (sensor != null))
        {
            IfcRelConnectsPorts connectsPorts = ConnectionDeserializer.relConnectsPortsBetweenTwoElements((IfcElement)controller, (IfcElement)sensor,
                    model);
            IfcPort relatedPort = connectsPorts.getRelatedPort();
            IfcPort relatingPort = connectsPorts.getRelatingPort();
            if (portBelongsToObject(relatedPort, (IfcElement)controller))
            {
                controllerPort = relatedPort;
            } else if (portBelongsToObject(relatingPort, (IfcElement)controller))
            {
                controllerPort = relatingPort;
            }
            if (portBelongsToObject(relatedPort, (IfcElement)sensor))
            {
                sensorPort = relatedPort;
            } else if (portBelongsToObject(relatingPort, (IfcElement)sensor))
            {
                sensorPort = relatedPort;
            }
        }

    }

    private void setController(IfcProduct controller)
    {
        this.controller = controller;
    }

    private void setSensor(IfcProduct sensor)
    {
        this.sensor = sensor;
    }

}
